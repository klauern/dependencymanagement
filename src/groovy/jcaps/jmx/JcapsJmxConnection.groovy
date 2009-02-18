/**
 * JMX Connection
 */
package jcaps.jmx

import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl
import javax.management.remote.JMXConnector
import javax.management.ObjectName


/**
 *
 * @author a03182
 */
class JcapsJmxConnection {
   String url
   def query = new ObjectName('SeeBeyond:*')
   def server
   def allSeebeyondBeans
   def activationMBeans
   String[] allNames

   def getAllCollabs() {
      allSeebeyondBeans = allNames.collect{ new GroovyMBean(server, it) }
      activationMBeans = allSeebeyondBeans.findAll {
         it.info().getClassName().equals("com.stc.codegen.mbeans.CollabMonitor")
      }
      return activationMBeans
   }

   def controlCollaboration(String collabFullName, String operation) {
      query = new ObjectName("SeeBeyond:*,Name=${collabFullName}")
      allSeebeyondBeans = server.queryNames(query, null).collect{
         new GroovyMBean(server, it)
      }
      if (allSeebeyondBeans.size()==1) {
         allSeebeyondBeans[0]."${operation}"()
         return allSeebeyondBeans[0]
      } else {
         return null // We assume that your query isn't specific enough to get the job
                     // done, so you should get nothing in return.
      }
   }

   def shutdownCollab(String obj_name) {
      return controlCollaboration(obj_name, "stop")
   }

   def startCollab(String obj_name) {
      return controlCollaboration(obj_name, "start")
   }

   def getCollabMBean(String obj_name) {
      def new_query = new ObjectName("SeeBeyond:*,Name=${obj_name}")
      def bean
      server.queryNames(new_query, null).collect {
         bean = new GroovyMBean(server, it)
      }
      return bean
   }

   /**
    * Connects to a JMX-enabled JCAPS 5.1.x server.  Note: Set the url field prior
    * to calling this method to ensure you can connect.
    */
   def connect() {
      server = JmxFactory.connect(new JmxUrl(url)).mBeanServerConnection
      allNames = server.queryNames(query, null)
   }

   def disconnect() {
      server.close
   }

   /**
    * Sets the URL of the JMX connection
    * @param server The server name (eaitestpart5, etc.)
    * @param port the domain base port, <i>NOT</i> the JMX port.
    */
   def setUrl(String server, int port) {
      this.url = "service:jmx:rmi:///jndi/rmi://${server}:${port+999}/jmxrmi"
   }

}