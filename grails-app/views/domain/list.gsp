

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Domain List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Domain</g:link></span>
        </div>
        <div class="body">
            <h1>Domain List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="domain_description" title="Domaindescription" />
                        
                   	        <g:sortableColumn property="domain_name" title="Domainname" />
                        
                   	        <th>Zone</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${domainInstanceList}" status="i" var="domainInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${domainInstance.id}">${fieldValue(bean:domainInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:domainInstance, field:'domain_description')}</td>
                        
                            <td>${fieldValue(bean:domainInstance, field:'domain_name')}</td>
                        
                            <td>${fieldValue(bean:domainInstance, field:'zone')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${domainInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
