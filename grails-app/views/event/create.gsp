

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Event</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Event List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Event</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${eventInstance}">
            <div class="errors">
                <g:renderErrors bean="${eventInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="event_name">Eventname:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:eventInstance,field:'event_name','errors')}">
                                    <input type="text" id="event_name" name="event_name" value="${fieldValue(bean:eventInstance,field:'event_name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="event_type">Eventtype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:eventInstance,field:'event_type','errors')}">
                                    <input type="text" id="event_type" name="event_type" value="${fieldValue(bean:eventInstance,field:'event_type')}"/>
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
