

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Zone</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Zone List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Zone</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${zoneInstance}">
            <div class="errors">
                <g:renderErrors bean="${zoneInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="zone_name">Zonename:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'zone_name','errors')}">
                                    <input type="text" id="zone_name" name="zone_name" value="${fieldValue(bean:zoneInstance,field:'zone_name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="zone_type">Zonetype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'zone_type','errors')}">
                                    <input type="text" id="zone_type" name="zone_type" value="${fieldValue(bean:zoneInstance,field:'zone_type')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="zone_usage">Zoneusage:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'zone_usage','errors')}">
                                    <input type="text" id="zone_usage" name="zone_usage" value="${fieldValue(bean:zoneInstance,field:'zone_usage')}"/>
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
