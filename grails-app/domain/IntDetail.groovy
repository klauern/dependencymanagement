class IntDetail {

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'detail_id'
        }
    }
}
