class IntDetail {

    String direction        // 'INBOUND' or 'OUTBOUND'
    String description      // Scheduler description, HTTPS, etc.
    String connection_name  // User-given name
    Port connection         // Reference to the actual connection
    String username         // if applicable (HTTP will not)

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'detail_id'
        }
    }
}
