class Support {
    String support_level
    String support_start_time
    String support_end_time
    String description

    static has_many = [support_contacts:Contact]

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'support_id'
        }
    }
}
