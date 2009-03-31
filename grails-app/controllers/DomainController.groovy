

class DomainController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ domainInstanceList: Domain.list( params ), domainInstanceTotal: Domain.count() ]
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
            try {
                domainInstance.delete()
                flash.message = "Domain ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Domain ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
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
            if(params.version) {
                def version = params.version.toLong()
                if(domainInstance.version > version) {
                    
                    domainInstance.errors.rejectValue("version", "domain.optimistic.locking.failure", "Another user has updated this Domain while you were editing.")
                    render(view:'edit',model:[domainInstance:domainInstance])
                    return
                }
            }
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
