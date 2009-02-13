class Contact {

    // This models the important information on a contact
    String full_name
    
    static hasMany = [email_addresses:String, phones:String]

    Date dateCreated
    Date lastUpdated
    
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'contact_id'
        }
    }
}
