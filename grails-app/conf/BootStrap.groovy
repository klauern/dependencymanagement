import grails.converters.*

class BootStrap {

    def contacts = []
    def supports = []
    def applications = []
    def events = []
    def zones = []
    def domains = []
    def ports = []
    def integrations = []
    def intdetails = []

    def init = { servletContext ->

        // Base Types (don't share relationships with other types):
        // Contacts
        createContacts()
        // Zones
        createZones()
        // Support
        createSupportAry()
        // Application
        createApplications()
        // Events
        createEvents()
        // Types that share something from another table:

        // Domains
        createDomains()
        // Ports
        createPorts()
        // Integration
        createIntegrations()
        // IntDetail
        createIntDetails()


        def jsonArray = JSON.parse(new File("./docs/SomeBootStrapInfo.json").getText())
    }

    def destroy = {
    }

    def createContacts() {
        def contact_a = new Contact(full_name:"Meg Sviatslovsky",email:"megsviatslovsky@alliantenergy.com",
            work_phone:"1.608.458.0000",mobile_phone:"1.608.778.0000").save()
        def contact_b = new Contact(full_name:"Nick Klauer",email:"NicholasKlauer@alliantenergy.com",
            work_phone:"1.608.458.3922",mobile_phone:"1.608.516.7615").save()
        def contact_c = new Contact(full_name:"Allan_Rosanes",email:"AllanRosanes@alliantenergy.com",
            work_phone:"1.608.458.3333",mobile_phone:"1.608.444.4444").save()
        
    }
    
    def createZones() {
        zones.add(new Zone(zone_name:"eaiprodpart1",zone_type:"JCAPS 5.1.x",
                zone_usage:"JCAPS 5.1.3 Logical host server.  Production").save())
        zones.add(new Zone(zone_name:"eaitestpart5",zone_type:"JCAPS 5.1.x",
                zone_usage:"Test Environment for\n\n blah blah blah and some other stuff").save())
        zones.add(new Zone(zone_name:"sreprodpart1",zone_type:"SRE 5.0.5",
                zone_usage:"SRE EmplInfo Schema").save())
        zones.add(new Zone(zone_name:"eaitestpart9", zone_type:"JCAPS 5.1.x",
                zone_usage:"AMI Test").save())
       
    }


    def createSupportAry() {
        def dr = ['1', '2', '3']
        def sp = ['Low', 'Medium', 'High']
        dr.each { d ->
            sp.each { s ->
                supports.add(new Support(support_level:s, disaster_recovery_level:d).save())
            }
        }
    }

    def createApplications() {
        applications.add(new Application(application_name:"EDT", application_description:"Engineering Design Tool", support_information:supports[3]).save())
        applications.add(new Application(application_name:"GIMMS", application_description:"Really Bloated and Slow to Production Interface", support_information:supports[8]).save())
        applications.add(new Application(application_name:"PetProject1", application_description:"Some Pet Project", support_information:supports[1]).save())
        applications.add(new Application(application_name:"QueueChecker", application_description:"Queue Checker for JMS Queues", support_information:supports[4]).save())
        applications.add(new Application(application_name:"Hudson", application_description:"EAI Continuous Integration System", support_information:supports[6]).save())
        applications.add(new Application(application_name:"ECPD", application_description:"Electric Capital Project Database", support_information:supports[5]).save())
        applications.add(new Application(application_name:"CRIS", application_description:"A less-than-useful set of tools for companies who create new generation...Unlike AE at the moment.", support_information:supports[0]).save())
    }

    def createEvents() {
        events.add(new Event(event_name:"15 minute kickoff", event_type:"??").save())
        events.add(new Event(event_name:"", event_type:"").save())
        events.add(new Event(event_name:"", event_type:"").save())
        events.add(new Event(event_name:"", event_type:"").save())
        events.add(new Event(event_name:"", event_type:"").save())
        events.add(new Event(event_name:"", event_type:"").save())

    }

    def createDomains() {
        domains.add(new Domain(domain_name:"EmplInfo",domain_description:"A thing",
                zone:zones[2]).save())
        domains.add(new Domain(domain_name:"AMI", domain_description:"Big honkin' thing", zone:zones[3]).save())

    }

    def createPorts() {
        ports.add(new Port(domain:domains[1], port_number:18000, port_use_description:"Base Port for Domain 1").save())
        ports.add(new Port(domain:domains[1], port_number:18999, port_use_description:"JMX Connectivity for Domain 1").save())
        ports.add(new Port(domain:domains[1], port_number:18001, port_use_description:"JMS transmission").save())
        ports.add(new Port(domain:domains[0], port_number:18000, port_use_description:"Base JMS port for Domain 1").save())
        ports.add(new Port(domain:domains[0], port_number:19000, port_use_description:"Base JMS port for Domain 2").save())
    }

    def createIntegrations() {

    }

    def createIntDetails() {

    }
} 