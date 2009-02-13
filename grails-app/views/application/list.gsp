

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Application List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Application</g:link></span>
        </div>
        <div class="body">
            <h1>Application List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="application_description" title="Applicationdescription" />
                        
                   	        <g:sortableColumn property="application_name" title="Applicationname" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <th>Supportinformation</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${applicationInstanceList}" status="i" var="applicationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${applicationInstance.id}">${fieldValue(bean:applicationInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:applicationInstance, field:'application_description')}</td>
                        
                            <td>${fieldValue(bean:applicationInstance, field:'application_name')}</td>
                        
                            <td>${fieldValue(bean:applicationInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:applicationInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:applicationInstance, field:'support_information')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Application.count()}" />
            </div>
        </div>
    </body>
</html>
