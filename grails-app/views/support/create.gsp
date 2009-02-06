

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
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:supportInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:supportInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="support_end_time">Supportendtime:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:supportInstance,field:'support_end_time','errors')}">
                                    <input type="text" id="support_end_time" name="support_end_time" value="${fieldValue(bean:supportInstance,field:'support_end_time')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="support_level">Supportlevel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:supportInstance,field:'support_level','errors')}">
                                    <input type="text" id="support_level" name="support_level" value="${fieldValue(bean:supportInstance,field:'support_level')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="support_start_time">Supportstarttime:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:supportInstance,field:'support_start_time','errors')}">
                                    <input type="text" id="support_start_time" name="support_start_time" value="${fieldValue(bean:supportInstance,field:'support_start_time')}"/>
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
