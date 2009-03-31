

class IntegrationController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ integrationInstanceList: Integration.list( params ), integrationInstanceTotal: Integration.count() ]
    }

    def show = {
        def integrationInstance = Integration.get( params.id )

        if(!integrationInstance) {
            flash.message = "Integration not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ integrationInstance : integrationInstance ] }
    }

    def delete = {
        def integrationInstance = Integration.get( params.id )
        if(integrationInstance) {
            try {
                integrationInstance.delete()
                flash.message = "Integration ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Integration ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Integration not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def integrationInstance = Integration.get( params.id )

        if(!integrationInstance) {
            flash.message = "Integration not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ integrationInstance : integrationInstance ]
        }
    }

    def update = {
        def integrationInstance = Integration.get( params.id )
        if(integrationInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(integrationInstance.version > version) {
                    
                    integrationInstance.errors.rejectValue("version", "integration.optimistic.locking.failure", "Another user has updated this Integration while you were editing.")
                    render(view:'edit',model:[integrationInstance:integrationInstance])
                    return
                }
            }
            integrationInstance.properties = params
            if(!integrationInstance.hasErrors() && integrationInstance.save()) {
                flash.message = "Integration ${params.id} updated"
                redirect(action:show,id:integrationInstance.id)
            }
            else {
                render(view:'edit',model:[integrationInstance:integrationInstance])
            }
        }
        else {
            flash.message = "Integration not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def integrationInstance = new Integration()
        integrationInstance.properties = params
        return ['integrationInstance':integrationInstance]
    }

    def save = {
        def integrationInstance = new Integration(params)
        if(!integrationInstance.hasErrors() && integrationInstance.save()) {
            flash.message = "Integration ${integrationInstance.id} created"
            redirect(action:show,id:integrationInstance.id)
        }
        else {
            render(view:'create',model:[integrationInstance:integrationInstance])
        }
    }
}
