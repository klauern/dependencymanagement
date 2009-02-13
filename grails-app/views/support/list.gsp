

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Support List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Support</g:link></span>
        </div>
        <div class="body">
            <h1>Support List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="disaster_recovery_level" title="Disasterrecoverylevel" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <g:sortableColumn property="support_level" title="Supportlevel" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${supportInstanceList}" status="i" var="supportInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${supportInstance.id}">${fieldValue(bean:supportInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:supportInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:supportInstance, field:'disaster_recovery_level')}</td>
                        
                            <td>${fieldValue(bean:supportInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:supportInstance, field:'support_level')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Support.count()}" />
            </div>
        </div>
    </body>
</html>
