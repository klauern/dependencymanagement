class BootStrap {

    def init = { servletContext ->
        // Create the base level types:
        // Contacts
        def contact_a = new Contact(full_name:"Meg Sviatslovsky",email:"megsviatslovsky@alliantenergy.com",
            work_phone:"1.608.458.0000",mobile_phone:"1.608.778.0000").save()
        def contact_b = new Contact(full_name:"Nick Klauer",email:"NicholasKlauer@alliantenergy.com",
            work_phone:"1.608.458.3922",mobile_phone:"1.608.516.7615").save()
        def contact_c = new Contact(full_name:"Allan_Rosanes",email:"AllanRosanes@alliantenergy.com",
            work_phone:"1.608.458.3333",mobile_phone:"1.608.444.4444").save()
        // Events
        // Zone
        def zone_a = new Zone(zone_name:"eaiprodpart1",zone_type:"JCAPS 5.1.x",
            zone_usage:"JCAPS 5.1.3 Logical host server.  Production").save()
        def zone_b = new Zone(zone_name:"eaitestpart5",zone_type:"JCAPS 5.1.x",
            zone_usage:"Test Environment for\n\n blah blah blah and some other stuff").save()
        def zone_c = new Zone(zone_name:"sreprodpart1",zone_type:"SRE 5.0.5",
            zone_usage:"SRE EmplInfo Schema").save()
        // Domain
        def domain_a = new Domain(domain_name:"EmplInfo",domain_description:"A thing",
            zone:zone_c).save()
        // Port
    }

    def destroy = {
    }
} 