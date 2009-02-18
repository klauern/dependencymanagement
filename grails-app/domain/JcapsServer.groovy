class JcapsServer {

   String servername // eaitestpart5, eaiprodpart6, etc.
   static hasMany = [domains:Domain]
   Date dateCreated
   Date lastUpdated

   static mapping = {
      autoTimestamp true
   }

   String toString() {
      return "${servername}"
   }
}
