package jcaps.jmx.samples

import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

import javax.management.ObjectName;

public def getAllInstances() {
	def ret = [:]
	def serverUrl = 'service:jmx:rmi:///jndi/rmi://localhost:9877/jmxrmi'
	def server = JmxFactory.connect(new JmxUrl(serverUrl)).mBeanServerConnection
	def query = new ObjectName('SeeBeyond:*')
	String[] allNames = server.queryNames(query, null)
	def metadataBeans = allNames.findAll{
		name -> name.contains('type=MetaDataManager')
	}.collect{ new GroovyMBean(server, it) }

	metadataBeans.each { metadata ->
		def earName = metadata.name().getKeyProperty("name")
		def objects = metadata.getAllMetaDataObject().values()
		bpelMetadatas = objects.findAll { o ->
			o.getClass().getName().equals("com.stc.codegen.eInsightImpl.runtime.metadata.MDBpelMetadataImpl") }
		bpelMetadatas.each { bpelMetadata ->
			def bpengine = new GroovyMBean(server, 'SeeBeyond:EARId=' + earName + ',type=BPEngineMBean')
			def instances = bpengine.getBPInstances(bpelMetadata.getName())
			def instanceIds = []
			if (instances == null) {
				println bpelMetadata.getName() + " has 0 instance"
			} else {
				instances.values().each { l -> instanceIds.addAll(l) }
				if (instanceIds.size() == 0) {
					println bpelMetadata.getName() + " has 0 instance"
				} else if (instanceIds.size()==1) {
					println bpelMetadata.getName() + " has 1 instance:"
				} else {
					println bpelMetadata.getName() + " has " + instanceIds.size() + " instances:"
				}
				if (instanceIds != null && instanceIds.size()>=1) {
					instanceIds.each {
						v -> println v
						ret[v] = bpelMetadata.getName()
					}
				}
			}
			println "------------------"

		}
	}
	ret
}
getAllInstances()
