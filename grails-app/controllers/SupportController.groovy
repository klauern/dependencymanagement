

class SupportController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ supportInstanceList: Support.list( params ), supportInstanceTotal: Support.count() ]
    }

    def show = {
        def supportInstance = Support.get( params.id )

        if(!supportInstance) {
            flash.message = "Support not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ supportInstance : supportInstance ] }
    }

    def delete = {
        def supportInstance = Support.get( params.id )
        if(supportInstance) {
            try {
                supportInstance.delete()
                flash.message = "Support ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Support ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Support not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def supportInstance = Support.get( params.id )

        if(!supportInstance) {
            flash.message = "Support not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ supportInstance : supportInstance ]
        }
    }

    def update = {
        def supportInstance = Support.get( params.id )
        if(supportInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(supportInstance.version > version) {
                    
                    supportInstance.errors.rejectValue("version", "support.optimistic.locking.failure", "Another user has updated this Support while you were editing.")
                    render(view:'edit',model:[supportInstance:supportInstance])
                    return
                }
            }
            supportInstance.properties = params
            if(!supportInstance.hasErrors() && supportInstance.save()) {
                flash.message = "Support ${params.id} updated"
                redirect(action:show,id:supportInstance.id)
            }
            else {
                render(view:'edit',model:[supportInstance:supportInstance])
            }
        }
        else {
            flash.message = "Support not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def supportInstance = new Support()
        supportInstance.properties = params
        return ['supportInstance':supportInstance]
    }

    def save = {
        def supportInstance = new Support(params)
        if(!supportInstance.hasErrors() && supportInstance.save()) {
            flash.message = "Support ${supportInstance.id} created"
            redirect(action:show,id:supportInstance.id)
        }
        else {
            render(view:'create',model:[supportInstance:supportInstance])
        }
    }
}
