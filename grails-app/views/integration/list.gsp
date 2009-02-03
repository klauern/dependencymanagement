

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Integration List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Integration</g:link></span>
        </div>
        <div class="body">
            <h1>Integration List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <th>Destination</th>
                   	    
                   	        <th>Event</th>
                   	    
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <th>Source</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${integrationInstanceList}" status="i" var="integrationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${integrationInstance.id}">${fieldValue(bean:integrationInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:integrationInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:integrationInstance, field:'destination')}</td>
                        
                            <td>${fieldValue(bean:integrationInstance, field:'event')}</td>
                        
                            <td>${fieldValue(bean:integrationInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:integrationInstance, field:'source')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Integration.count()}" />
            </div>
        </div>
    </body>
</html>
