class VendorController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ vendorInstanceList: Vendor.list( params ) ]
    }

    def show = {
        def vendorInstance = Vendor.get( params.id )

        if(!vendorInstance) {
            flash.message = "Vendor not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ vendorInstance : vendorInstance ] }
    }

    def delete = {
        def vendorInstance = Vendor.get( params.id )
        if(vendorInstance) {
            vendorInstance.delete()
            flash.message = "Vendor ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Vendor not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def vendorInstance = Vendor.get( params.id )

        if(!vendorInstance) {
            flash.message = "Vendor not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ vendorInstance : vendorInstance ]
        }
    }

    def update = {
        def vendorInstance = Vendor.get( params.id )
        if(vendorInstance) {
            vendorInstance.properties = params
            if(!vendorInstance.hasErrors() && vendorInstance.save()) {
                flash.message = "Vendor ${params.id} updated"
                redirect(action:show,id:vendorInstance.id)
            }
            else {
                render(view:'edit',model:[vendorInstance:vendorInstance])
            }
        }
        else {
            flash.message = "Vendor not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def vendorInstance = new Vendor()
        vendorInstance.properties = params
        return ['vendorInstance':vendorInstance]
    }

    def save = {
        def vendorInstance = new Vendor(params)
        if(!vendorInstance.hasErrors() && vendorInstance.save()) {
            flash.message = "Vendor ${vendorInstance.id} created"
            redirect(action:show,id:vendorInstance.id)
        }
        else {
            render(view:'create',model:[vendorInstance:vendorInstance])
        }
    }
}
