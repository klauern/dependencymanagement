class DomainTests extends GroovyTestCase {

   void testCreateNewDomain() {
      def s = new JcapsServer(servername:"eaitestpart5").save(flush:true)
      Domain d = new Domain(alias:"EmplInfo", servername:s, port:18000).save(flush:true)
      assertEquals 1, Domain.list().size()
   }
}
