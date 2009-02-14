class Zone {
    String zone_name
    String zone_type
    String zone_usage
    Date dateCreated
    Date lastUpdated
    // column 'id' is inferred and created by default.
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'zone_id'
        }
//        id generator:'sequence', params:[sequence:'zone_id']
    }
    static hasMany = [domains:Domain]

    static constraints = {
        zone_type(inList:['JCAPS 5.1.x', 'SRE 5.0.5', 'eGate 4.5.3', 'Other'])
    }

    def String toString() {
        return zone_name + ": " + zone_usage
    }
}
