
class ReloadJmxCollabsJob {
    def timeout = 60000l // execute job once in 30 seconds

   JmxService jmxService

    def execute() {
        println "Updating All Domain JCD listings"
        def domains = Domain.list()
        domains.each {
           println "Updating Domain ${it.toString()}"
           jmxService.refreshCollabs(it.ident())
        }
    }
}
