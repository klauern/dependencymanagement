import jcaps.jmx.JcapsJmxConnection

class JcapsCollabMonitorController {

   def JmxService jmxService

   def index = { redirect(action:list,params:params) }

   // the delete, save and update actions only accept POST requests
   def allowedMethods = [delete:'POST', save:'POST', update:'POST']

   def list = {
      if(!params.max) params.max = 10
      [ jcapsCollabMonitorList: JcapsCollabMonitor.list(params) ]
   }

   def show = {
      def jcapsCollabMonitor = JcapsCollabMonitor.get( params.id )

      if(!jcapsCollabMonitor) {
         flash.message = "JcapsCollabMonitor not found with id ${params.id}"
         redirect(action:list)
      }
      else { return [ jcapsCollabMonitor : jcapsCollabMonitor ] }
   }

   def delete = {
      def jcapsCollabMonitor = JcapsCollabMonitor.get( params.id )
      if(jcapsCollabMonitor) {
         jcapsCollabMonitor.delete()
         flash.message = "JcapsCollabMonitor ${params.id} deleted"
         redirect(action:list)
      }
      else {
         flash.message = "JcapsCollabMonitor not found with id ${params.id}"
         redirect(action:list)
      }
   }

   def edit = {
      def jcapsCollabMonitor = JcapsCollabMonitor.get( params.id )

      if(!jcapsCollabMonitor) {
         flash.message = "JcapsCollabMonitor not found with id ${params.id}"
         redirect(action:list)
      }
      else {
         return [ jcapsCollabMonitor : jcapsCollabMonitor ]
      }
   }

   def update = {
      def jcapsCollabMonitor = JcapsCollabMonitor.get( params.id )
      if(jcapsCollabMonitor) {
         jcapsCollabMonitor.properties = params
         if(!jcapsCollabMonitor.hasErrors() && jcapsCollabMonitor.save()) {
            flash.message = "JcapsCollabMonitor ${params.id} updated"
            redirect(action:show,id:jcapsCollabMonitor.id)
         }
         else {
            render(view:'edit',model:[jcapsCollabMonitor:jcapsCollabMonitor])
         }
      }
      else {
         flash.message = "JcapsCollabMonitor not found with id ${params.id}"
         redirect(action:edit,id:params.id)
      }
   }

   def create = {
      def jcapsCollabMonitor = new JcapsCollabMonitor()
      jcapsCollabMonitor.properties = params
      return ['jcapsCollabMonitor':jcapsCollabMonitor]
   }

   def save = {
      def jcapsCollabMonitor = new JcapsCollabMonitor(params)
      if(!jcapsCollabMonitor.hasErrors() && jcapsCollabMonitor.save()) {
         flash.message = "JcapsCollabMonitor ${jcapsCollabMonitor.id} created"
         redirect(action:show,id:jcapsCollabMonitor.id)
      }
      else {
         render(view:'create',model:[jcapsCollabMonitor:jcapsCollabMonitor])
      }
   }

   def start = {
      println "Starting this JCD with ID of ${params.id}"
      jmxService.startCollab(params.id)
      flash.message = "Successfully started this collaboration"
      redirect(action:show,id:params.id)
   }

   def stop = {
      println "Stopping this JCD with ID of ${params.id}"
      jmxService.stopCollab(params.id)
      flash.message = "Successfully stopped this collaboration"
      redirect(action:show,id:params.id)
   }

   def refresh = {
      jmxService.refreshSingleCollab(params.id)
      redirect(action:show,id:params.id)
   }

   // Called when we need to refresh the status for the collaborations
   def refresh_collabs = {
      jmxService.refreshAllCollabs()
      flash.message = "All Collabs have been Refreshed"
      redirect(action:list)
   }

   def populateCollabs = {
      jmxService.populateCollabs(params.domain_id)
      Domain domain = Domain.get(params.domain_id)
      flash.message = "Domain ${domain.id} created"
      redirect(controller:"domain", action:list)
   }


}
