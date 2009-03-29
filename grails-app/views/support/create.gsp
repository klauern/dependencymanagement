

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Support</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Support List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Support</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${supportInstance}">
            <div class="errors">
                <g:renderErrors bean="${supportInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="disaster_recovery_level">Disasterrecoverylevel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:supportInstance,field:'disaster_recovery_level','errors')}">
                                    <g:select id="disaster_recovery_level" name="disaster_recovery_level" from="${supportInstance.constraints.disaster_recovery_level.inList}" value="${supportInstance.disaster_recovery_level}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="support_level">Supportlevel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:supportInstance,field:'support_level','errors')}">
                                    <g:select id="support_level" name="support_level" from="${supportInstance.constraints.support_level.inList}" value="${supportInstance.support_level}" ></g:select>
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
