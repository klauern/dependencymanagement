class ZoneController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ zoneInstanceList: Zone.list( params ) ]
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
            zoneInstance.delete()
            flash.message = "Zone ${params.id} deleted"
            redirect(action:list)
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
