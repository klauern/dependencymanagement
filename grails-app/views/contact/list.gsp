

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Contact List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Contact</g:link></span>
        </div>
        <div class="body">
            <h1>Contact List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="email" title="Email" />
                        
                   	        <g:sortableColumn property="work_phone" title="Workphone" />
                        
                   	        <g:sortableColumn property="full_name" title="Fullname" />
                        
                   	        <g:sortableColumn property="mobile_phone" title="Mobilephone" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${contactInstanceList}" status="i" var="contactInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${contactInstance.id}">${fieldValue(bean:contactInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:contactInstance, field:'email')}</td>
                        
                            <td>${fieldValue(bean:contactInstance, field:'work_phone')}</td>
                        
                            <td>${fieldValue(bean:contactInstance, field:'full_name')}</td>
                        
                            <td>${fieldValue(bean:contactInstance, field:'mobile_phone')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${contactInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
