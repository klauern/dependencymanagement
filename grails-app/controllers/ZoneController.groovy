

class ZoneController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ zoneInstanceList: Zone.list( params ), zoneInstanceTotal: Zone.count() ]
    }

    def show = {
        def zoneInstance = Zone.get( params.id )

        if(!zoneInstance) {
            flash.message = "Zone not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ zoneInstance : zoneInstance ] }
    }

    def delete = {
        def zoneInstance = Zone.get( params.id )
        if(zoneInstance) {
            try {
                zoneInstance.delete()
                flash.message = "Zone ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Zone ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Zone not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def zoneInstance = Zone.get( params.id )

        if(!zoneInstance) {
            flash.message = "Zone not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ zoneInstance : zoneInstance ]
        }
    }

    def update = {
        def zoneInstance = Zone.get( params.id )
        if(zoneInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(zoneInstance.version > version) {
                    
                    zoneInstance.errors.rejectValue("version", "zone.optimistic.locking.failure", "Another user has updated this Zone while you were editing.")
                    render(view:'edit',model:[zoneInstance:zoneInstance])
                    return
                }
            }
            zoneInstance.properties = params
            if(!zoneInstance.hasErrors() && zoneInstance.save()) {
                flash.message = "Zone ${params.id} updated"
                redirect(action:show,id:zoneInstance.id)
            }
            else {
                render(view:'edit',model:[zoneInstance:zoneInstance])
            }
        }
        else {
            flash.message = "Zone not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def zoneInstance = new Zone()
        zoneInstance.properties = params
        return ['zoneInstance':zoneInstance]
    }

    def save = {
        def zoneInstance = new Zone(params)
        if(!zoneInstance.hasErrors() && zoneInstance.save()) {
            flash.message = "Zone ${zoneInstance.id} created"
            redirect(action:show,id:zoneInstance.id)
        }
        else {
            render(view:'create',model:[zoneInstance:zoneInstance])
        }
    }
}
