import grails.converters.*

class BootStrap {

    def init = { servletContext ->

                 new JcapsServer(servername:"eaitestpart1").save()
         new JcapsServer(servername:"eaitestpart2").save()
         new JcapsServer(servername:"eaitestpart3").save()
         new JcapsServer(servername:"eaitestpart4").save()
         def s = new JcapsServer(servername:"eaitestpart5").save()
         new JcapsServer(servername:"eaitestpart6").save()
         new JcapsServer(servername:"eaitestpart7").save()
         new JcapsServer(servername:"eaitestpart8").save()
         new JcapsServer(servername:"eaitestpart9").save()
         def d = new Domain(alias:"EmplInfo", servername:s, port:18000).save()
         //new JcapsCollabMonitor(short_name:"Unmatched Collab To Remove", domain:d).save()



        // Base Types (don't share relationships with other types):
        // Contacts
        def contact_a = new Contact(full_name:"Meg Sviatslovsky",email:"megsviatslovsky@alliantenergy.com",
            work_phone:"1.608.458.0000",mobile_phone:"1.608.778.0000").save()
        def contact_b = new Contact(full_name:"Nick Klauer",email:"NicholasKlauer@alliantenergy.com",
            work_phone:"1.608.458.3922",mobile_phone:"1.608.516.7615").save()
        def contact_c = new Contact(full_name:"Allan_Rosanes",email:"AllanRosanes@alliantenergy.com",
            work_phone:"1.608.458.3333",mobile_phone:"1.608.444.4444").save()
        // Zones
        def zone_a = new Zone(zone_name:"eaiprodpart1",zone_type:"JCAPS 5.1.x",
            zone_usage:"JCAPS 5.1.3 Logical host server.  Production").save()
        def zone_b = new Zone(zone_name:"eaitestpart5",zone_type:"JCAPS 5.1.x",
            zone_usage:"Test Environment for\n\n blah blah blah and some other stuff").save()
        def zone_c = new Zone(zone_name:"sreprodpart1",zone_type:"SRE 5.0.5",
            zone_usage:"SRE EmplInfo Schema").save()
        // Support


        // Types that share something from another table:
        // Events
        // Application
        // Ports
        // Events
        // Domains
        def domain_a = new Domain(domain_name:"EmplInfo",domain_description:"A thing",
            zone:zone_c).save()
        // Integration
        // IntDetail



        def jsonArray = JSON.parse(new File("./docs/SomeBootStrapInfo.json").getText())

    }


    def loadJsonInfo(servletContext) {

    }

    def destroy = {
    }
} 