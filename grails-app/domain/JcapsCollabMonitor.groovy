class JcapsCollabMonitor {

   int collab_instances
   String monitoring_MBean_name
   String short_name    // The Keying information necessary to find collabs.
   int num_msg_in_process
   String num_msg_processed
   Date since
   String status
   Boolean stoppable
   Date dateCreated
   Date lastUpdated
   Domain domain

   static belongsTo = Domain

   static mapping = {
      autoTimestamp true
   }

   static constraints = {
      short_name(blank:false)
   }

   String toString() {
      return "${short_name}"
   }


}
