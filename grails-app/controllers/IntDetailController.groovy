class IntDetailController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ intDetailInstanceList: IntDetail.list( params ) ]
    }

    def show = {
        def intDetailInstance = IntDetail.get( params.id )

        if(!intDetailInstance) {
            flash.message = "IntDetail not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ intDetailInstance : intDetailInstance ] }
    }

    def delete = {
        def intDetailInstance = IntDetail.get( params.id )
        if(intDetailInstance) {
            intDetailInstance.delete()
            flash.message = "IntDetail ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "IntDetail not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def intDetailInstance = IntDetail.get( params.id )

        if(!intDetailInstance) {
            flash.message = "IntDetail not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ intDetailInstance : intDetailInstance ]
        }
    }

    def update = {
        def intDetailInstance = IntDetail.get( params.id )
        if(intDetailInstance) {
            intDetailInstance.properties = params
            if(!intDetailInstance.hasErrors() && intDetailInstance.save()) {
                flash.message = "IntDetail ${params.id} updated"
                redirect(action:show,id:intDetailInstance.id)
            }
            else {
                render(view:'edit',model:[intDetailInstance:intDetailInstance])
            }
        }
        else {
            flash.message = "IntDetail not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def intDetailInstance = new IntDetail()
        intDetailInstance.properties = params
        return ['intDetailInstance':intDetailInstance]
    }

    def save = {
        def intDetailInstance = new IntDetail(params)
        if(!intDetailInstance.hasErrors() && intDetailInstance.save()) {
            flash.message = "IntDetail ${intDetailInstance.id} created"
            redirect(action:show,id:intDetailInstance.id)
        }
        else {
            render(view:'create',model:[intDetailInstance:intDetailInstance])
        }
    }
}
