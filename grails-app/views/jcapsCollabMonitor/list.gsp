

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>JcapsCollabMonitor List</title>
   </head>
   <body>
      <div class="nav">
         <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
         <span class="menuButton"><g:link class="create" action="create">New JcapsCollabMonitor</g:link></span>
         <span class="menuButton"><g:link action="refresh_collabs">Refresh All</g:link></span>
      </div>
      <div class="body">
         <h1>JcapsCollabMonitor List</h1>
         <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
         </g:if>
         <div class="list">
            <table>
               <thead>
                  <tr>
                     <g:sortableColumn property="id" title="Id" />
                     <g:sortableColumn property="short_name" title="Shortname" />
                     <g:sortableColumn property="collab_instances" title="Collabinstances" />
                     <g:sortableColumn property="dateCreated" title="Date Created" />
                     <th>Domain</th>
                     <g:sortableColumn property="lastUpdated" title="Last Updated" />
                  </tr>
               </thead>
               <tbody>
                  <g:each in="${jcapsCollabMonitorList}" status="i" var="jcapsCollabMonitor">
                     <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <td><g:link action="show" id="${jcapsCollabMonitor.id}">${fieldValue(bean:jcapsCollabMonitor, field:'id')}</g:link></td>
                        <td>${fieldValue(bean:jcapsCollabMonitor, field:'short_name')}</td>
                        <td>${fieldValue(bean:jcapsCollabMonitor, field:'collab_instances')}</td>
                        <td>${fieldValue(bean:jcapsCollabMonitor, field:'dateCreated')}</td>
                        <td>${fieldValue(bean:jcapsCollabMonitor, field:'domain')}</td>
                        <td>${fieldValue(bean:jcapsCollabMonitor, field:'lastUpdated')}</td>
                     </tr>
                  </g:each>
               </tbody>
            </table>
         </div>
         <div class="paginateButtons">
            <g:paginate total="${JcapsCollabMonitor.count()}" />
         </div>
      </div>
   </body>
</html>
