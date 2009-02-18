class JcapsCollabMonitorTests extends GroovyTestCase {

   def jmxService

   void testCreateEmptyNewCollab() {

      JcapsServer jcs = new JcapsServer(servername:"eaitestpart5")
      jcs.save(flush:true)

      Domain d = new Domain(alias:"EmplInfo", servername:jcs, port:18000)
      d.save(flush:true)

      JcapsCollabMonitor jc = new JcapsCollabMonitor(short_name:"Unmatched Collab To Test")
      jc.domain = d
      jc.monitoring_MBean_name = "Unknown"
      jc.num_msg_processed = 0
      jc.since = new Date()
      jc.status = "N/A"
      jc.stoppable = "N/A"
      jc.save(flush:true)
      println "\nErrors:"
      println jc.errors ?: "no errors found"
      jc.validate()
      assertEquals 1, JcapsCollabMonitor.list().size()
   }

   void testNewCollab() {
      def s = new JcapsServer(servername:"eaitestpart5").save(flush:true)
      Domain d = new Domain(alias:"EmplInfo", servername:s, port:18000).save(flush:true)

      JcapsCollabMonitor jc = new JcapsCollabMonitor(short_name:"Unmatched Collab To Test")
      jc.domain = d
      jc.monitoring_MBean_name = "Unknown"
      jc.num_msg_processed = 0
      jc.since = new Date()
      jc.status = "N/A"
      jc.stoppable = "N/A"
      jc.save(flush:true)
      def c = JcapsCollabMonitor.findWhere(short_name:"Unmatched Collab To Test")
      assert c != null
   }

}
