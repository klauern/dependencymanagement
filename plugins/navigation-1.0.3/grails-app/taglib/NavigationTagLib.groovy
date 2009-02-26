import org.codehaus.groovy.grails.commons.GrailsClassUtils

class NavigationTagLib {
    static namespace = "nav"
    
    static REQ_ATTRIB_RESOURCES_LOADED = "navigationplugin.resources.loaded"
    def navigationService

    /** 
     * Tag to pull in the CSS
     */
    def resources = { attrs ->
        if ((attrs.override != 'true') && !Boolean.valueOf(attrs.override)) {
            out << "<link rel=\"stylesheet\" type=\"text/css\" href=\"${createLinkTo(dir:pluginContextPath+'/css', file:'navigation.css')}\"/>"
        }
        request[REQ_ATTRIB_RESOURCES_LOADED] = true
    }
    
    def ifHasItems = { attrs, body -> 
        def categ = attrs.group ?: '*'
        def items = navigationService.byGroup[categ]
        if (items) {
            out << body()
        }
    }
    
    def ifHasNoItems = { attrs, body -> 
        def categ = attrs.group ?: '*'
        def items = navigationService.byGroup[categ]
        if (!items) {
            out << body()
        }
    }
    
    /**
     * Iterate over nav items in a given category
     */
    def eachItem = { attrs, body ->
        def categ = attrs.group ?: '*'
        def var = attrs.var
        
        def items = navigationService.byGroup[categ]
        if (items) {
            iterateItems(items, var, body, false)
        }
    }
    
    /**
     * Iterate over nav sub items in a given category's item (by title)
     */
    def eachSubItem = { attrs, body ->
        def categ = attrs.group ?: '*'
        def itemTitle = attrs.remove('title')
        def con = attrs.remove('controller')
        def searchKey = itemTitle
        def searchKeyAuto = false
        if (!searchKey) {
            if (!con) {
                searchKey = GrailsClassUtils.getLogicalName(controllerName, 'Controller')
                searchKeyAuto = true
            } else searchKey = con
        }
        def var = attrs.var
        
        def items = navigationService.byGroup[categ]
        // Match by title or controller as appropriate
        def item = items.find { it[itemTitle ? 'title' : 'controller'] == searchKey } 
        if (!item && !searchKeyAuto) 
            throwTagError("There is no item with ${itemTitle ? 'title' : 'controller'} [${searchKey}] in the group [$categ]")
            
        if (item?.subItems) {
            iterateItems(item.subItems, var, body, true)
        }
    }
    
        
    private iterateItems = { items, var, body, actionMatch ->
        def last = items.size()-1
        items.eachWithIndex { item, i ->
            // isVisible is closure or null/false
            def isVisible = item['isVisible']
            
            if (isVisible instanceof Closure) {
                isVisible = isVisible.clone()
                isVisible.delegate = [
                    session:session,
                    request:request,
                    flash:flash,
                    params:params
                ]
                isVisible.resolveStrategy = Closure.DELEGATE_FIRST
            }
            
            if ((isVisible == null) || (isVisible == true ) || isVisible.call()) { 
                def data = [:]
                data.putAll(item)
                data.link = g.createLink(controller:data.controller, action:data.action, id:data.id)
                if (i == 0) {
                    data.first = true
                } else if (i == last) {
                    data.last = true
                }
                if ((controllerName == data.controller) && (!actionMatch || (actionName == data.action)) ){
                    data.active = true
                }
                out << body(var ? [(var):data] : data)
            }
        }
    }

    def renderSubItems = { attrs ->
        if (!request[REQ_ATTRIB_RESOURCES_LOADED]) 
            throwTagError("You must invoke the nav:resources tag in the HEAD section of your page before you can use other [nav:*] tags")

        def grp = attrs.group ?: '*'
        def id = attrs.id == null ? "subnavigation_${grp == '*' ? 'all' : grp}" : attrs.id

        def sectionCode
        if (!attrs.title) {
            // Resolve parent by controller instead
            //attrs.controller = GrailsClassUtils.getLogicalName(controllerName, 'Controller')
            //attrs.remove('title')
            sectionCode = controllerName.toLowerCase()
        } else {
            sectionCode = attrs.title.toLowerCase()
        }
        def o = out
        o << "<ul class=\"subnavigation\""
        if (id) {
            o << " id=\"${id.encodeAsHTML()}\""
        }
        o << '>'
        o << eachSubItem(attrs, { item ->
            def title = item.title?.toLowerCase()
            def cls = "${item.active ? 'subnavigation_active ' : ''}${item.first ? 'subnavigation_first ' : ''}${item.last ? 'subnavigation_last' : ''}"
            o << "<li"
            if (cls) o << " class=\"${cls.trim()}\""
            o << "><a href=\"${item.link.encodeAsHTML()}\">${message(code:'subnavigation.'+grp+'.'+sectionCode+'.'+title, default:item.title, encodeAs:'HTML')}</a></li>"
        })
        o << "</ul>"
    }

    /**
     * Render nav items in a given category
     */
    def render = { attrs ->
        if (!request[REQ_ATTRIB_RESOURCES_LOADED]) 
            throwTagError("You must invoke the nav:resources tag in the HEAD section of your page before you can use other [nav:*] tags")

        def grp = attrs.group ?: '*'
        def subitems = attrs.subitems ? Boolean.valueOf(attrs.subitems?.toString()) : false
        def id = attrs.id == null ? "navigation_${grp == '*' ? 'all' : grp}" : attrs.id
        
        def o = out
        o << "<ul class=\"navigation\""
        if (id) {
            o << " id=\"${id.encodeAsHTML()}\""
        }
        o << '>'
        o << eachItem(attrs, {
            def title = it.title?.toLowerCase()
            def cls = "${it.active ? 'navigation_active ' : ''}${it.first ? 'navigation_first ' : ''}${it.last ? 'navigation_last' : ''}"
            o << "<li"
            if (cls) o << " class=\"${cls.trim()}\""
            o << "><a href=\"${it.link.encodeAsHTML()}\">${message(code:'navigation.'+grp+'.'+title, default:it.title, encodeAs:'HTML')}</a>"
            if (subitems) {
                o << renderSubItems([group:grp, id:'', title:it.title])
            }
            o << "</li>"
        })
        o << "</ul>"
    }    
}