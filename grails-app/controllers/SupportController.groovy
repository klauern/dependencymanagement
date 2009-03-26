class SupportController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ supportInstanceList: Support.list( params ) ]
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
            supportInstance.delete()
            flash.message = "Support ${params.id} deleted"
            redirect(action:list)
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
