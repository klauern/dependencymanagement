class Vendor {

    String vendor_name
    String vendor_description

    Date dateCreated
    Date lastUpdated
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'vendor_id'
        }
    }
}
