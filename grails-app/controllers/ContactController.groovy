class ContactController {

    static navigation = true
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ contactInstanceList: Contact.list( params ) ]
    }

    def show = {
        def contactInstance = Contact.get( params.id )

        if(!contactInstance) {
            flash.message = "Contact not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ contactInstance : contactInstance ] }
    }

    def delete = {
        def contactInstance = Contact.get( params.id )
        if(contactInstance) {
            contactInstance.delete()
            flash.message = "Contact ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Contact not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def contactInstance = Contact.get( params.id )

        if(!contactInstance) {
            flash.message = "Contact not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ contactInstance : contactInstance ]
        }
    }

    def update = {
        def contactInstance = Contact.get( params.id )
        if(contactInstance) {
            contactInstance.properties = params
            if(!contactInstance.hasErrors() && contactInstance.save()) {
                flash.message = "Contact ${params.id} updated"
                redirect(action:show,id:contactInstance.id)
            }
            else {
                render(view:'edit',model:[contactInstance:contactInstance])
            }
        }
        else {
            flash.message = "Contact not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def contactInstance = new Contact()
        contactInstance.properties = params
        return ['contactInstance':contactInstance]
    }

    def save = {
        def contactInstance = new Contact(params)
        if(!contactInstance.hasErrors() && contactInstance.save()) {
            flash.message = "Contact ${contactInstance.id} created"
            redirect(action:show,id:contactInstance.id)
        }
        else {
            render(view:'create',model:[contactInstance:contactInstance])
        }
    }
}
