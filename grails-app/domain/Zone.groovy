class Zone {
    String zone_name
    String zone_type
    String zone_usage
    Date dateCreated
    Date lastUpdated
    // column 'id' is inferred and created by default.
    static mapping = {
        autoTimestamp true
    }
}
