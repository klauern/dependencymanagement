

class ApplicationController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ applicationInstanceList: Application.list( params ), applicationInstanceTotal: Application.count() ]
    }

    def show = {
        def applicationInstance = Application.get( params.id )

        if(!applicationInstance) {
            flash.message = "Application not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ applicationInstance : applicationInstance ] }
    }

    def delete = {
        def applicationInstance = Application.get( params.id )
        if(applicationInstance) {
            try {
                applicationInstance.delete()
                flash.message = "Application ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Application ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Application not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def applicationInstance = Application.get( params.id )

        if(!applicationInstance) {
            flash.message = "Application not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ applicationInstance : applicationInstance ]
        }
    }

    def update = {
        def applicationInstance = Application.get( params.id )
        if(applicationInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(applicationInstance.version > version) {
                    
                    applicationInstance.errors.rejectValue("version", "application.optimistic.locking.failure", "Another user has updated this Application while you were editing.")
                    render(view:'edit',model:[applicationInstance:applicationInstance])
                    return
                }
            }
            applicationInstance.properties = params
            if(!applicationInstance.hasErrors() && applicationInstance.save()) {
                flash.message = "Application ${params.id} updated"
                redirect(action:show,id:applicationInstance.id)
            }
            else {
                render(view:'edit',model:[applicationInstance:applicationInstance])
            }
        }
        else {
            flash.message = "Application not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def applicationInstance = new Application()
        applicationInstance.properties = params
        return ['applicationInstance':applicationInstance]
    }

    def save = {
        def applicationInstance = new Application(params)
        if(!applicationInstance.hasErrors() && applicationInstance.save()) {
            flash.message = "Application ${applicationInstance.id} created"
            redirect(action:show,id:applicationInstance.id)
        }
        else {
            render(view:'create',model:[applicationInstance:applicationInstance])
        }
    }
}
