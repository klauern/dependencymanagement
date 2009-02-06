class Integration {
    Event event
    Vendor source
    Vendor destination
<<<<<<< HEAD:grails-app/domain/Integration.groovy
    
=======
    Support support_info
>>>>>>> 9b2ae8e0c1d717947cf4056dcf6178d8c261cd3f:grails-app/domain/Integration.groovy
    
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
