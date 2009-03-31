

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Application</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Application List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Application</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Application</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${applicationInstance}">
            <div class="errors">
                <g:renderErrors bean="${applicationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${applicationInstance?.id}" />
                <input type="hidden" name="version" value="${applicationInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="application_description">Applicationdescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationInstance,field:'application_description','errors')}">
                                    <input type="text" id="application_description" name="application_description" value="${fieldValue(bean:applicationInstance,field:'application_description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="application_name">Applicationname:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationInstance,field:'application_name','errors')}">
                                    <input type="text" id="application_name" name="application_name" value="${fieldValue(bean:applicationInstance,field:'application_name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="contacts">Contacts:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationInstance,field:'contacts','errors')}">
                                    <g:select name="contacts"
from="${Contact.list()}"
size="5" multiple="yes" optionKey="id"
value="${applicationInstance?.contacts}" />

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="support_information">Supportinformation:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationInstance,field:'support_information','errors')}">
                                    <g:select optionKey="id" from="${Support.list()}" name="support_information.id" value="${applicationInstance?.support_information?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
