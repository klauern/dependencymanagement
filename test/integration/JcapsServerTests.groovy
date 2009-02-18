class JcapsServerTests extends GroovyTestCase {

    void testCreateServer() {
       JcapsServer js = new JcapsServer(servername:"eaitestpart5")
       js.save(flush:true)
       assertEquals 1, JcapsServer.list().size()
    }
}
