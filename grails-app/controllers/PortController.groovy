

class PortController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ portInstanceList: Port.list( params ), portInstanceTotal: Port.count() ]
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
            try {
                portInstance.delete()
                flash.message = "Port ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Port ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
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
            if(params.version) {
                def version = params.version.toLong()
                if(portInstance.version > version) {
                    
                    portInstance.errors.rejectValue("version", "port.optimistic.locking.failure", "Another user has updated this Port while you were editing.")
                    render(view:'edit',model:[portInstance:portInstance])
                    return
                }
            }
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
