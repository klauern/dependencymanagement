class Port {
    Domain domain
    int port_number
    String port_use_description

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
    }
}
