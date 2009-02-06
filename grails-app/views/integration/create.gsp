

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Integration</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Integration List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Integration</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${integrationInstance}">
            <div class="errors">
                <g:renderErrors bean="${integrationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                        
<<<<<<< HEAD:grails-app/views/integration/create.gsp
=======
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="support_info">Supportinfo:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:integrationInstance,field:'support_info','errors')}">
                                    <g:select optionKey="id" from="${Support.list()}" name="support_info.id" value="${integrationInstance?.support_info?.id}" ></g:select>
                                </td>
                            </tr> 
                        
>>>>>>> 9b2ae8e0c1d717947cf4056dcf6178d8c261cd3f:grails-app/views/integration/create.gsp
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
