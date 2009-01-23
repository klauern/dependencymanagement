

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Domain</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Domain List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Domain</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Domain</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${domainInstance}">
            <div class="errors">
                <g:renderErrors bean="${domainInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${domainInstance?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${domainInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domain_description">Domaindescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'domain_description','errors')}">
                                    <input type="text" id="domain_description" name="domain_description" value="${fieldValue(bean:domainInstance,field:'domain_description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domain_name">Domainname:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'domain_name','errors')}">
                                    <input type="text" id="domain_name" name="domain_name" value="${fieldValue(bean:domainInstance,field:'domain_name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${domainInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ports">Ports:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'ports','errors')}">
                                    
<ul>
<g:each var="p" in="${domainInstance?.ports?}">
    <li><g:link controller="port" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="port" params="['domain.id':domainInstance?.id]" action="create">Add Port</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="zone">Zone:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'zone','errors')}">
                                    <g:select optionKey="id" from="${Zone.list()}" name="zone.id" value="${domainInstance?.zone?.id}" ></g:select>
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
