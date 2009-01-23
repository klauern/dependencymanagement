class Domain {
    String domain_name
    String domain_description
    Zone zone
    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
    }
}
