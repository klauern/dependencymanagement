class ApplicationController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ applicationInstanceList: Application.list( params ) ]
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
            applicationInstance.delete()
            flash.message = "Application ${params.id} deleted"
            redirect(action:list)
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
