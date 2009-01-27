class PortController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ portInstanceList: Port.list( params ) ]
    }

    def show = {
        def portInstance = Port.get( params.id )

        if(!portInstance) {
            flash.message = "Port not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ portInstance : portInstance ] }
    }

    def delete = {
        def portInstance = Port.get( params.id )
        if(portInstance) {
            portInstance.delete()
            flash.message = "Port ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Port not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def portInstance = Port.get( params.id )

        if(!portInstance) {
            flash.message = "Port not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ portInstance : portInstance ]
        }
    }

    def update = {
        def portInstance = Port.get( params.id )
        if(portInstance) {
            portInstance.properties = params
            if(!portInstance.hasErrors() && portInstance.save()) {
                flash.message = "Port ${params.id} updated"
                redirect(action:show,id:portInstance.id)
            }
            else {
                render(view:'edit',model:[portInstance:portInstance])
            }
        }
        else {
            flash.message = "Port not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def portInstance = new Port()
        portInstance.properties = params
        return ['portInstance':portInstance]
    }

    def save = {
        def portInstance = new Port(params)
        if(!portInstance.hasErrors() && portInstance.save()) {
            flash.message = "Port ${portInstance.id} created"
            redirect(action:show,id:portInstance.id)
        }
        else {
            render(view:'create',model:[portInstance:portInstance])
        }
    }
}
