

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>JcapsServer List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New JcapsServer</g:link></span>
        </div>
        <div class="body">
            <h1>JcapsServer List</h1>
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
                        
                   	        <g:sortableColumn property="servername" title="Servername" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${jcapsServerList}" status="i" var="jcapsServer">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${jcapsServer.id}">${fieldValue(bean:jcapsServer, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:jcapsServer, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:jcapsServer, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:jcapsServer, field:'servername')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${JcapsServer.count()}" />
            </div>
        </div>
    </body>
</html>
