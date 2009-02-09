class Integration {
    Event event
    Vendor source
    Vendor destination
    Support support_info
    
    static hasMany = [details:IntDetail]

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'integration_id'
        }
    }
}
