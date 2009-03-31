class Support {

    String support_level            // Following EAI standard Support Level designations 1-3
    String disaster_recovery_level  // 1, 2, 3

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'support_id'
        }
    }

    static constraints = {
        disaster_recovery_level(inList:['1', '2', '3'])
        support_level(inList:['Low', 'Medium', 'High'])
    }

    def String toString() {
        return "DR Level: ${disaster_recovery_level}, ${support_level} Support"
    }
}
