
/**
 * Integration is the over-arching integration that will occur for a project.
 * When a project goes underway, it is
 */
class Integration {
    Event event
    Application source
    Application destination
    
    static hasMany = [details:IntDetail, support_contacts:Contact]

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'integration_id'
        }
    }
}
