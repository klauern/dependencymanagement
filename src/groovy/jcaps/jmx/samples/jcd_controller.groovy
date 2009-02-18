package jcaps.jmx.samples

import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

import javax.management.ObjectName;

public def controlCollaboration(String collabFullName, String operation) {
	def serverUrl = 'service:jmx:rmi:///jndi/rmi://localhost:9877/jmxrmi'
	def server = JmxFactory.connect(new JmxUrl(serverUrl)).mBeanServerConnection
	def query = new ObjectName("SeeBeyond:*,Name=${collabFullName}")
	def allSeebeyondBeans = server.queryNames(query, null).collect{
		new GroovyMBean(server, it)
	}
	if (allSeebeyondBeans.size()==1) {
		allSeebeyondBeans[0]."${operation}"()
	}
}

def collabFullName = "Deployment1TestSimpleJCD|TestSimpleJCD|Deployment1|CMap1_jcdProcess1"
if (this.args.size()!=1) {
	controlCollaboration(collabFullName, "stop")
} else {
	controlCollaboration(collabFullName, this.args[0])
}

/*
With this script I can start the JCD processing using the command:

$> JMXControlCollaboration.groovy start

and stop the JCD processing using the command:

$> JMXControlCollaboration.groovy stop

*/