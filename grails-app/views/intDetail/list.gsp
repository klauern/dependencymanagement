

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IntDetail List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IntDetail</g:link></span>
        </div>
        <div class="body">
            <h1>IntDetail List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Connection</th>
                   	    
                   	        <g:sortableColumn property="connection_name" title="Connectionname" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="direction" title="Direction" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${intDetailInstanceList}" status="i" var="intDetailInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${intDetailInstance.id}">${fieldValue(bean:intDetailInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:intDetailInstance, field:'connection')}</td>
                        
                            <td>${fieldValue(bean:intDetailInstance, field:'connection_name')}</td>
                        
                            <td>${fieldValue(bean:intDetailInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:intDetailInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:intDetailInstance, field:'direction')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${IntDetail.count()}" />
            </div>
        </div>
    </body>
</html>
