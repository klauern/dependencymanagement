class Application {

    String application_name
    String application_description
    Support support_information

    static hasMany = [contacts:Contact]

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'application_id'
        }
    }

    String toString() {
        return application_name
    }
}
