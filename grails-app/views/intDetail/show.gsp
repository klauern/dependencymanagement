

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show IntDetail</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IntDetail List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IntDetail</g:link></span>
        </div>
        <div class="body">
            <h1>Show IntDetail</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Direction:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'direction')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Connection:</td>
                            
                            <td valign="top" class="value"><g:link controller="port" action="show" id="${intDetailInstance?.connection?.id}">${intDetailInstance?.connection?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Connectionname:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'connection_name')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Username:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:intDetailInstance, field:'username')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${intDetailInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
