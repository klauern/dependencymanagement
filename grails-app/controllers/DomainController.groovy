class DomainController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ domainInstanceList: Domain.list( params ) ]
    }

    def show = {
        def domainInstance = Domain.get( params.id )

        if(!domainInstance) {
            flash.message = "Domain not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ domainInstance : domainInstance ] }
    }

    def delete = {
        def domainInstance = Domain.get( params.id )
        if(domainInstance) {
            domainInstance.delete()
            flash.message = "Domain ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Domain not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def domainInstance = Domain.get( params.id )

        if(!domainInstance) {
            flash.message = "Domain not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ domainInstance : domainInstance ]
        }
    }

    def update = {
        def domainInstance = Domain.get( params.id )
        if(domainInstance) {
            domainInstance.properties = params
            if(!domainInstance.hasErrors() && domainInstance.save()) {
                flash.message = "Domain ${params.id} updated"
                redirect(action:show,id:domainInstance.id)
            }
            else {
                render(view:'edit',model:[domainInstance:domainInstance])
            }
        }
        else {
            flash.message = "Domain not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def domainInstance = new Domain()
        domainInstance.properties = params
        return ['domainInstance':domainInstance]
    }

    def save = {
        def domainInstance = new Domain(params)
        if(!domainInstance.hasErrors() && domainInstance.save()) {
            flash.message = "Domain ${domainInstance.id} created"
            redirect(action:show,id:domainInstance.id)
        }
        else {
            render(view:'create',model:[domainInstance:domainInstance])
        }
    }
}
