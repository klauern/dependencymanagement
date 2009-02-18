

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>Show JcapsCollabMonitor</title>
   </head>
   <body>
      <div class="nav">
         <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
         <span class="menuButton"><g:link class="list" action="list">JcapsCollabMonitor List</g:link></span>
         <span class="menuButton"><g:link class="create" action="create">New JcapsCollabMonitor</g:link></span>
      </div>
      <div class="body">
         <h1>Show JcapsCollabMonitor</h1>
         <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
         </g:if>
         <div class="dialog">
            <table>
               <tbody>

                  <tr class="prop">
                     <td valign="top" class="name">Id:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'id')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Shortname:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'short_name')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Collabinstances:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'collab_instances')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Date Created:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'dateCreated')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Domain:</td>
                     <td valign="top" class="value"><g:link controller="domain" action="show" id="${jcapsCollabMonitor?.domain?.id}">${jcapsCollabMonitor?.domain?.encodeAsHTML()}</g:link></td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Last Updated:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'lastUpdated')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Monitoring MB eanname:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'monitoring_MBean_name')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Nummsginprocess:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'num_msg_in_process')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Nummsgprocessed:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'num_msg_processed')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Since:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'since')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Status:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'status')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Stoppable:</td>
                     <td valign="top" class="value">${fieldValue(bean:jcapsCollabMonitor, field:'stoppable')}</td>
                  </tr>

               </tbody>
            </table>
         </div>
         <div class="buttons">
            <g:form>
               <input type="hidden" name="id" value="${jcapsCollabMonitor?.id}" />
               <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
               <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
               <span class="button"><g:actionSubmit class="start" value="Start" action="start"/></span>
               <span class="button"><g:actionSubmit class="stop" value="Stop" action="stop"/></span>
               <span class="button"><g:actionSubmit class="refresh" value="Refresh" action="refresh"/></span>
            </g:form>
         </div>
      </div>
   </body>
</html>
