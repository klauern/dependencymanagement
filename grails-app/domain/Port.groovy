class Port {
    Domain domain
    int port_number
    String port_use_description     // Oracle, JMS, HTTP, etc.
                                    // MQSeries, FTP, SFTP, etc.

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'port_id'
        }
    }
}
