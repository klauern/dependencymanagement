class IntegrationController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ integrationInstanceList: Integration.list( params ) ]
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
            integrationInstance.delete()
            flash.message = "Integration ${params.id} deleted"
            redirect(action:list)
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
