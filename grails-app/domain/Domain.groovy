class Domain {
    String domain_name
    String domain_description
    Zone zone
    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'domain_id'
        }
    }
    static hasMany = [ports:Port]

    def String toString() {
        return "${zone.zone_name}: ${domain_name}"
    }
}
