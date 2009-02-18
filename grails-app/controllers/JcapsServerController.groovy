class JcapsServerController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ jcapsServerList: JcapsServer.list( params ) ]
    }

    def show = {
        def jcapsServer = JcapsServer.get( params.id )

        if(!jcapsServer) {
            flash.message = "JcapsServer not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ jcapsServer : jcapsServer ] }
    }

    def delete = {
        def jcapsServer = JcapsServer.get( params.id )
        if(jcapsServer) {
            jcapsServer.delete()
            flash.message = "JcapsServer ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "JcapsServer not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def jcapsServer = JcapsServer.get( params.id )

        if(!jcapsServer) {
            flash.message = "JcapsServer not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ jcapsServer : jcapsServer ]
        }
    }

    def update = {
        def jcapsServer = JcapsServer.get( params.id )
        if(jcapsServer) {
            jcapsServer.properties = params
            if(!jcapsServer.hasErrors() && jcapsServer.save()) {
                flash.message = "JcapsServer ${params.id} updated"
                redirect(action:show,id:jcapsServer.id)
            }
            else {
                render(view:'edit',model:[jcapsServer:jcapsServer])
            }
        }
        else {
            flash.message = "JcapsServer not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def jcapsServer = new JcapsServer()
        jcapsServer.properties = params
        return ['jcapsServer':jcapsServer]
    }

    def save = {
        def jcapsServer = new JcapsServer(params)
        if(!jcapsServer.hasErrors() && jcapsServer.save()) {
            flash.message = "JcapsServer ${jcapsServer.id} created"
            redirect(action:show,id:jcapsServer.id)
        }
        else {
            render(view:'create',model:[jcapsServer:jcapsServer])
        }
    }
}
