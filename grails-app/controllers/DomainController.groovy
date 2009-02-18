import jcaps.jmx.JcapsJmxConnection

class DomainController {

   def index = { redirect(action:list,params:params) }

   // the delete, save and update actions only accept POST requests
   def allowedMethods = [delete:'POST', save:'POST', update:'POST']

   def list = {
      if(!params.max) params.max = 10
      [ domainList: Domain.list( params ) ]
   }

   def show = {
      def domain = Domain.get( params.id )

      if(!domain) {
         flash.message = "Domain not found with id ${params.id}"
         redirect(action:list)
      }
      else { return [ domain : domain ] }
   }

   def delete = {
      def domain = Domain.get( params.id )
      if(domain) {
         domain.delete()
         flash.message = "Domain ${params.id} deleted"
         redirect(action:list)
      }
      else {
         flash.message = "Domain not found with id ${params.id}"
         redirect(action:list)
      }
   }

   def edit = {
      def domain = Domain.get( params.id )

      if(!domain) {
         flash.message = "Domain not found with id ${params.id}"
         redirect(action:list)
      }
      else {
         return [ domain : domain ]
      }
   }

   def update = {
      def domain = Domain.get( params.id )
      if(domain) {
         domain.properties = params
         if(!domain.hasErrors() && domain.save()) {
            flash.message = "Domain ${params.id} updated"
            redirect(action:show,id:domain.id)
         }
         else {
            render(view:'edit',model:[domain:domain])
         }
      }
      else {
         flash.message = "Domain not found with id ${params.id}"
         redirect(action:edit,id:params.id)
      }
   }

   def create = {
      def domain = new Domain()
      domain.properties = params
      return ['domain':domain]
   }

   def save = {
      def domain = new Domain(params)
      if (domain.alias == null || domain.alias == "") {
         domain.alias = domain.servername.toString() + ":" + domain.port
      }
      if(!domain.hasErrors() && domain.save()) {
         chain(controller:"jcapsCollabMonitor", action:"populateCollabs", params:[domain_id:domain.id])
      }
      else {
         render(view:'create',model:[domain:domain])
      }
   }

}
