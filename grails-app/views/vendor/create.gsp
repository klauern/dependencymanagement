

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Vendor</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Vendor List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Vendor</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${vendorInstance}">
            <div class="errors">
                <g:renderErrors bean="${vendorInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vendorInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${vendorInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vendorInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${vendorInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="vendor_description">Vendordescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vendorInstance,field:'vendor_description','errors')}">
                                    <input type="text" id="vendor_description" name="vendor_description" value="${fieldValue(bean:vendorInstance,field:'vendor_description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="vendor_name">Vendorname:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vendorInstance,field:'vendor_name','errors')}">
                                    <input type="text" id="vendor_name" name="vendor_name" value="${fieldValue(bean:vendorInstance,field:'vendor_name')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
