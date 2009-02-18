class Domain {
    String alias        // CAD domain, AMI domain 1, etc.
    JcapsServer servername
    Integer port

    static belongsTo = JcapsServer
    static hasMany = [collabs:JcapsCollabMonitor]

   Date dateCreated
   Date lastUpdated

   static mapping = {
      autoTimestamp true
   }

   static constraints = {
      servername(blank:false)
      port(blank:false)
   }

    String toString() {
        return "${alias}"
    }
}
