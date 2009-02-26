import org.codehaus.groovy.grails.commons.GrailsControllerClass
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.codehaus.groovy.grails.commons.GrailsClassUtils

// @todo subItem sorting
class NavigationService {

    static transactional = false
    
    def manuallyRegistered = []
    def byGroup = ['*':[]]
    def hidden = new HashSet()
    
    def reset() {
        byGroup = ['*':[]]
        // re-add the manually defined items
        ConfigurationHolder.config.navigation?.each { k, v ->
            if (v instanceof Collection) {
                v.each { item -> doRegisterItem(k, item) }
            } else {
                doRegisterItem(k, v)
            }
        }
        manuallyRegistered.each { grp, info ->
            doRegisterItem(grp, info)
        }
    }
    
    /**
     * Register a navigation item by convention
     */
    def registerItem(GrailsControllerClass controllerGrailsClass) {
        def p = [ 
            controller:controllerGrailsClass.logicalPropertyName
        ]
        def grp 
        def navInfo = '*'
        if (controllerGrailsClass.clazz.metaClass.hasProperty(controllerGrailsClass.clazz, 'navigation')) {
            navInfo = controllerGrailsClass.clazz.navigation
            if (navInfo == false) { 
                return 
            }
            if (navInfo == true) {
                navInfo = '*'
            }
        }
        if (navInfo instanceof Map) {
            p.action = navInfo.action
            p.order = navInfo.order
            p.id = navInfo.id
            p.isVisible = (navInfo['isVisible'] == null) ? true : navInfo.isVisible
            if (navInfo.title) {
                p.title = navInfo.title
            }
            p.subItems = navInfo.subItems?.collect { subitem ->
                def result = [:]
                if (subitem instanceof Map) {
                    result.putAll(subitem)
                } else {
                    result.action = subitem
                }
                if (!result.title) {
                    result.title = GrailsClassUtils.getNaturalName(result.action)
                }
                result.controller = p.controller
                return result
            }
            grp = navInfo.group
        } else if (navInfo instanceof List) {
            // Handle lists of info 
            navInfo.each { info ->
                def params = [:]
                params.controller = p.controller
                params.title = GrailsClassUtils.getNaturalName(p.action)
                params.action = info.action ?: controllerGrailsClass.defaultAction
                params.order = info.order
                params.id = info.id
                params.isVisible = (info['isVisible'] == null) ? true : info.isVisible
                params.subItems = info.subItems?.collect { subitem ->
                    def result = [:]
                    if (subitem instanceof Map) {
                        result.putAll(subitem)
                    } else {
                        result.action = subitem
                    }
                    if (!result.title) {
                        result.title = GrailsClassUtils.getNaturalName(result.action)
                    }
                    result.controller = params.controller
                    return result
                }
                if (info.group) grp = info.group // use last one unless there is a new one
                doRegisterItem(grp, params)
            }
        } else {
            grp = navInfo
        }
        if (!p.action) {
            p.action = controllerGrailsClass.defaultAction
        }
        if (!p.title) {
            p.title = GrailsClassUtils.getNaturalName(controllerGrailsClass.name)
        }
        doRegisterItem(grp, p)
    }
    
    /**
     * Manually register a navigation item
     */
    def registerItem(String group, Map params) {
        manuallyRegistered << [group:group, info:params]
        doRegisterItem(group, params)
    }
    
    protected doRegisterItem(String group, Map params) {
        params.action = params.action ?: 'index'
        if (!group) group = '*'

        def catInfo = byGroup[group]
        if (!catInfo) {
            catInfo = byGroup[group] = []
        }
        catInfo << params
        if (group != '*') {
            byGroup['*'] << params
        }
    }
    
    def hide(String controller) {
        hidden << controller
    }
    
    /**
     * Must be called after you have registered your items, to enforce ordering
     */
    def updated() {
        byGroup.keySet().each { k ->
            byGroup[k] = byGroup[k].findAll { info -> !hidden.contains(info.controller) }
            byGroup[k] = byGroup[k]?.sort { a, b -> 
                if (b.order) {
                    return a.order?.compareTo(b.order) ?: 0
                } else return +1 // items with no ordering come last
            }
        }
        log.info "Navigation items updated: ${byGroup}"
    }
}
