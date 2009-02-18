package jcaps.jmx.samples

import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

def serverUrl = 'service:jmx:rmi:///jndi/rmi://eaitestpart5:18999/jmxrmi'
def server = JmxFactory.connect(new JmxUrl(serverUrl)).mBeanServerConnection

server.queryNames(null, null).each{ name ->
    def mbean = new GroovyMBean(server, name)
    println mbean
    println "-----------------------"
}
