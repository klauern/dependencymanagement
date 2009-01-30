

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Zone List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Zone</g:link></span>
        </div>
        <div class="body">
            <h1>Zone List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <g:sortableColumn property="zone_name" title="Zonename" />
                        
                   	        <g:sortableColumn property="zone_type" title="Zonetype" />
                        
                   	        <g:sortableColumn property="zone_usage" title="Zoneusage" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${zoneInstanceList}" status="i" var="zoneInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${zoneInstance.id}">${fieldValue(bean:zoneInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:zoneInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:zoneInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:zoneInstance, field:'zone_name')}</td>
                        
                            <td>${fieldValue(bean:zoneInstance, field:'zone_type')}</td>
                        
                            <td>${fieldValue(bean:zoneInstance, field:'zone_usage')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Zone.count()}" />
            </div>
        </div>
    </body>
</html>
