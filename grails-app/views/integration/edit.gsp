

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Integration</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Integration List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Integration</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Integration</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${integrationInstance}">
            <div class="errors">
                <g:renderErrors bean="${integrationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${integrationInstance?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="destination">Destination:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:integrationInstance,field:'destination','errors')}">
                                    <g:select optionKey="id" from="${Vendor.list()}" name="destination.id" value="${integrationInstance?.destination?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="details">Details:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:integrationInstance,field:'details','errors')}">
                                    
<ul>
<g:each var="d" in="${integrationInstance?.details?}">
    <li><g:link controller="intDetail" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="intDetail" params="['integration.id':integrationInstance?.id]" action="create">Add IntDetail</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="event">Event:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:integrationInstance,field:'event','errors')}">
                                    <g:select optionKey="id" from="${Event.list()}" name="event.id" value="${integrationInstance?.event?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="source">Source:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:integrationInstance,field:'source','errors')}">
                                    <g:select optionKey="id" from="${Vendor.list()}" name="source.id" value="${integrationInstance?.source?.id}" ></g:select>
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
