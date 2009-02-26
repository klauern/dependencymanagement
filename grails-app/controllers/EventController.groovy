class EventController {
    
    static navigation = true

    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ eventInstanceList: Event.list( params ) ]
    }

    def show = {
        def eventInstance = Event.get( params.id )

        if(!eventInstance) {
            flash.message = "Event not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ eventInstance : eventInstance ] }
    }

    def delete = {
        def eventInstance = Event.get( params.id )
        if(eventInstance) {
            eventInstance.delete()
            flash.message = "Event ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Event not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def eventInstance = Event.get( params.id )

        if(!eventInstance) {
            flash.message = "Event not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ eventInstance : eventInstance ]
        }
    }

    def update = {
        def eventInstance = Event.get( params.id )
        if(eventInstance) {
            eventInstance.properties = params
            if(!eventInstance.hasErrors() && eventInstance.save()) {
                flash.message = "Event ${params.id} updated"
                redirect(action:show,id:eventInstance.id)
            }
            else {
                render(view:'edit',model:[eventInstance:eventInstance])
            }
        }
        else {
            flash.message = "Event not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def eventInstance = new Event()
        eventInstance.properties = params
        return ['eventInstance':eventInstance]
    }

    def save = {
        def eventInstance = new Event(params)
        if(!eventInstance.hasErrors() && eventInstance.save()) {
            flash.message = "Event ${eventInstance.id} created"
            redirect(action:show,id:eventInstance.id)
        }
        else {
            render(view:'create',model:[eventInstance:eventInstance])
        }
    }
}
