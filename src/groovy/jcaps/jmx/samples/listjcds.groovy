package jcaps.jmx.samples

import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

import javax.management.ObjectName;

// http://jira.codehaus.org/browse/GROOVY-2255 - beware when using JMX in Groovy, it includes a default jmx library that will
public def getAllCollaborations() {
    def serverUrl = 'service:jmx:rmi:///jndi/rmi://eaitestpart5:18999/jmxrmi'
    def server = JmxFactory.connect(new JmxUrl(serverUrl)).mBeanServerConnection
    def query = new ObjectName('SeeBeyond:*')
    String[] allNames = server.queryNames(query, null)
    def allSeebeyondBeans = allNames.collect{ new GroovyMBean(server, it) }
    def activationMBeans = allSeebeyondBeans.findAll {
        it.info().getClassName().equals("com.stc.codegen.mbeans.CollabMonitor")
    }
    activationMBeans.each {
        println it.name().getKeyProperty("Name")
        println "  is ${it.Status} since ${it.Since}"
        println "  messages processed per queue: ${it.NumberMsgProcessed}"
        println "MBean Name: ${it.MonitoringMBeanName}"
        println "Stoppable? ${it.Stoppable}"
        println "Number of Message in Process: ${it.NumberMsgInProcess}"
        println "Number of Collaboration Instances: ${it.CollabInstances}"
        println "--------"
    }
}

/* small tidbit I found out about this script.  The line
    allName.collect{ new GroovyMBean(server, it) }
    refers to the 'it' instance as the iterator.

    I am assuming that by default all collection methods infer
    'it' as the iterator instance.  You can specify your own,
    but by default, it's 'it'.
*/

getAllCollaborations()