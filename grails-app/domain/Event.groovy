class Event {
    String event_name
    String event_type

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'event_id'
        }
    }
}
