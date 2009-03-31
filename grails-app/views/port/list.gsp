

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Port List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Port</g:link></span>
        </div>
        <div class="body">
            <h1>Port List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Domain</th>
                   	    
                   	        <g:sortableColumn property="port_number" title="Portnumber" />
                        
                   	        <g:sortableColumn property="port_use_description" title="Portusedescription" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${portInstanceList}" status="i" var="portInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${portInstance.id}">${fieldValue(bean:portInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:portInstance, field:'domain')}</td>
                        
                            <td>${fieldValue(bean:portInstance, field:'port_number')}</td>
                        
                            <td>${fieldValue(bean:portInstance, field:'port_use_description')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${portInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
