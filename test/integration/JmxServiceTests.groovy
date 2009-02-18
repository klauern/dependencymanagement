class JmxServiceTests extends GroovyTestCase {

   def jmxService // Injected using Spring (Grails built-in functionality)

   def s
   Domain d
   JcapsCollabMonitor jc

   /*
    * JUnit built-in for setting up these tests.
    */
   void setUp() {
      s = new JcapsServer(servername:"eaitestpart5").save(flush:true)
      d = new Domain(alias:"EmplInfo", servername:s, port:18000).save(flush:true)
      jc = new JcapsCollabMonitor(short_name:"Unmatched Collab To Test")
   }

   /*
    * JUnit built-in for tearing down these tests.
    */
   void tearDown() {
      s = null
      d = null
      jc = null
   }


   void testUnmatchedDbCollab() {
      jc.domain = d
      jc.monitoring_MBean_name = "Unknown"
      jc.num_msg_processed = 0
      jc.since = new Date()
      jc.status = "N/A"
      jc.stoppable = "N/A"

      jc.save(flush:true)
      def c = JcapsCollabMonitor.findWhere(short_name:"Unmatched Collab To Test")
      assert c != null
      
      jmxService.refreshCollabs(d.ident())
      c = JcapsCollabMonitor.findWhere(short_name:"Unmatched Colalb To Test")
      assert c == null
   }

   
    // TODO: Get these tests written.

/*   void testRefreshSingleCollab() {
      fail "Not implemented Yet"
   }

   void testStartCollab() {
      fail "Not Implemented Yet"
   }

   void testStopCollab() {
      fail "Not Implemented Yet"
   }
 */

   void testRefreshAllCollabsWithSpecifiedDomain() {
      jmxService.refreshCollabs(d.ident())
      // TODO: Find an instnace that can be mocked up and shown to have a LastUpdate that's recent
   }

   void testRefreshAllCollabWithAllDomains() {
      jmxService.refreshAllCollabs()
      // TODO: Need to test that it did this other than not failing.
   }

   void testPopulateCollabsWithGivenDomainID() {
      assertEquals 0, JcapsCollabMonitor.list().size()
      jmxService.populateCollabs(d.ident())
      assert JcapsCollabMonitor.list().size() > 0
   }

}
