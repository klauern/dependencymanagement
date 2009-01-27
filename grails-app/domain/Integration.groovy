class Integration {
    Event event
    Vendor source
    Vendor destination
    
    
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
