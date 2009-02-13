class Contact {

    // This models the important information on a contact
    String full_name

    String email
    String work_phone
    String mobile_phone

    Date dateCreated
    Date lastUpdated
    
    static mapping = {
        autoTimestamp true
        columns {
            id column: 'contact_id'
        }
    }

    static constraints = {
        email(email:true)
        work_phone(blank:false, validator: {
                // Borrowed the regex from someone who created a validator customzied for phone #'s:
                // http://jshingler.blogspot.com/2008/07/phone-number-custom-constraint-for.html
                return it ==~ /^[01]?\s*[\(\.-]?(\d{3})[\)\.-]?\s*(\d{3})[\.-](\d{4})$/     
            })
    }
}
