package jcaps.jmx.samples

import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

import javax.management.ObjectName

def serverUrl = 'service:jmx:rmi:///jndi/rmi://localhost:9877/jmxrmi'
def server = JmxFactory.connect(new JmxUrl(serverUrl)).mBeanServerConnection

def query = new ObjectName('java.lang:type=Memory')
String[] allNames = server.queryNames(query, null)
if (allNames.size()==1) {
	memoryBean = new GroovyMBean(server, allNames[0])
	memoryBean.HeapMemoryUsage.contents.each { item ->
		println item.key + ": " + (item.value/1024/1024) + " MB"
	}
}

/* Example output:
committed: 80.34375 MB
init: 0 MB
max: 989.875 MB
used: 40.3523330688 MB
*/
