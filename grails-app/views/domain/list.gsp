

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
                     <th>Servername</th>
                     <g:sortableColumn property="port" title="Port" />
                     <g:sortableColumn property="alias" title="Alias" />
                     <g:sortableColumn property="dateCreated" title="Date Created" />
                     <g:sortableColumn property="lastUpdated" title="Last Updated" />
                  </tr>
               </thead>
               <tbody>
                  <g:each in="${domainList}" status="i" var="domain">
                     <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <td><g:link action="show" id="${domain.id}">${fieldValue(bean:domain, field:'id')}</g:link></td>
                        <td>${fieldValue(bean:domain, field:'servername')}</td>
                        <td>${fieldValue(bean:domain, field:'port')}</td>
                        <td>${fieldValue(bean:domain, field:'alias')}</td>
                        <td>${fieldValue(bean:domain, field:'dateCreated')}</td>
                        <td>${fieldValue(bean:domain, field:'lastUpdated')}</td>
                     </tr>
                  </g:each>
               </tbody>
            </table>
         </div>
         <div class="paginateButtons">
            <g:paginate total="${Domain.count()}" />
         </div>
      </div>
   </body>
</html>
