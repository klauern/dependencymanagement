class Support {

    String support_level            // Following EAI standard Support Level designations 1-3
    String disaster_recovery_level // 1, 2, 3

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'support_id'
        }
    }
}
