import jcaps.jmx.JcapsJmxConnection

class JmxService {

   boolean transactional = true

   static scope = "prototype"

   String url

   def populateCollabs(domain_id) {
      Domain domain = Domain.get(domain_id)
      JcapsJmxConnection conn = new JcapsJmxConnection()
      conn.setUrl(domain.servername.toString(), domain.port)
      conn.connect()
      def mbeans = conn.getAllCollabs()
      mbeans.each {
         def mb = mapCollabMonitor(it, domain)
         validateAndSave(mb)
      }
   }

   def mapCollabMonitor(mbean, Domain domain) {
      mapCollabMonitor(mbean, domain, null)
   }

   def mapCollabMonitor(mbean, Domain domain, JcapsCollabMonitor m) {
      if (m == null) {
         m = new JcapsCollabMonitor()
      }
      if (mbean.CollabInstances != null) {
         m.collab_instances = mbean.CollabInstances ?: 0
         m.monitoring_MBean_name = mbean.MonitoringMBeanName ?: "N/A"
         m.short_name = mbean.name().getKeyProperty("Name") ?: ""
         m.num_msg_in_process = mbean.NumberMsgInProcess ?: 0
         m.num_msg_processed = mbean.NumberMsgProcessed ?: 0
         m.since = mbean.Since ?: new Date()
         m.status = mbean.Status ?: "Unknown"
         m.stoppable = mbean.Stoppable ?: false
         m.domain = domain
         return m
      }
   }

   def refreshAllCollabs() {
      def domains = Domain.list()
      domains.each {
         refreshCollabs(it.ident())
      }
   }

   def refreshCollabs(domain_id) {
      Domain domain = Domain.get(domain_id)
      JcapsJmxConnection conn = new JcapsJmxConnection()
      conn.setUrl(domain.servername.toString(), domain.port)
      conn.connect()
      def domain_collabs = JcapsCollabMonitor.findAll() // Get all Collabs
      def completed_map = [:]  // Define an empty hashmap
      domain_collabs.each {
         completed_map[it.short_name] = false // Set every item to false
      }
      def mbeans = conn.getAllCollabs()
      mbeans.each {
         def mb = JcapsCollabMonitor.findWhere(short_name:it.name().getKeyProperty("Name"))
         if (mb != null) {
            mb = mapCollabMonitor(it, domain, mb)
            mb.lastUpdated = new Date()
            validateAndSave(mb)
         }
         else {
            mb = mapCollabMonitor(it, domain)
            validateAndSave(mb)
         }
         completed_map[it.name().getKeyProperty("Name")] = true // Check off each collab when we come across it
      }
      // The go back and find all the unmatched values and delete them from the table.
      completed_map.findAll { it.value == false }.each {
         JcapsCollabMonitor.findWhere(short_name:it.key).delete()
      }
   }

   def validateAndSave(mbean) {
      mbean.validate()
      if(mbean.hasErrors()) {
         mbean.errors.each {
            println it
         }
      }
      else {
         mbean.save()
      }
   }

   def refreshSingleCollab(mbean, collabmonitor) {
      mapCollabMonitor(mbean, collabmonitor.domain, collabmonitor).save()
   }

   def refreshSingleCollab(collab_id) {
      def collab = JcapsCollabMonitor.get(collab_id)
      JcapsJmxConnection conn = new JcapsJmxConnection()
      conn.setUrl(collab.domain.servername.toString(), collab.domain.port)
      conn.connect()
      def mbean = conn.getCollabMBean(collab.short_name)
      mapCollabMonitor(mbean, collab.domain, collab).save()
   }

   def startCollab(collab_id) {
      def collab = JcapsCollabMonitor.get(collab_id)
      JcapsJmxConnection conn = new JcapsJmxConnection()
      conn.setUrl(collab.domain.servername.toString(), collab.domain.port)
      conn.connect()
      def mbean = conn.startCollab(collab.short_name)
      refreshSingleCollab(mbean, collab)
   }

   def stopCollab(collab_id) {
      def collab = JcapsCollabMonitor.get(collab_id)
      JcapsJmxConnection conn = new JcapsJmxConnection()
      conn.setUrl(collab.domain.servername.toString(), collab.domain.port)
      conn.connect()
      def mbean = conn.shutdownCollab(collab.short_name)
      refreshSingleCollab(mbean, collab)
   }

}
