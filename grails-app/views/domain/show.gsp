

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>Show Domain</title>
   </head>
   <body>
      <div class="nav">
         <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
         <span class="menuButton"><g:link class="list" action="list">Domain List</g:link></span>
         <span class="menuButton"><g:link class="create" action="create">New Domain</g:link></span>
      </div>
      <div class="body">
         <h1>Show Domain</h1>
         <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
         </g:if>
         <div class="dialog">
            <table>
               <tbody>
                  <tr class="prop">
                     <td valign="top" class="name">Id:</td>
                     <td valign="top" class="value">${fieldValue(bean:domain, field:'id')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Servername:</td>
                     <td valign="top" class="value"><g:link controller="jcapsServer" action="show" id="${domain?.servername?.id}">${domain?.servername?.encodeAsHTML()}</g:link></td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Port:</td>
                     <td valign="top" class="value">${fieldValue(bean:domain, field:'port')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Alias:</td>
                     <td valign="top" class="value">${fieldValue(bean:domain, field:'alias')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Collabs:</td>
                     <td  valign="top" style="text-align:left;" class="value">
                        <ul>
                           <g:each var="c" in="${domain.collabs}">
                              <li><g:link controller="jcapsCollabMonitor" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
                           </g:each>
                        </ul>
                     </td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Date Created:</td>
                     <td valign="top" class="value">${fieldValue(bean:domain, field:'dateCreated')}</td>
                  </tr>

                  <tr class="prop">
                     <td valign="top" class="name">Last Updated:</td>
                     <td valign="top" class="value">${fieldValue(bean:domain, field:'lastUpdated')}</td>
                  </tr>

               </tbody>
            </table>
         </div>
         <div class="buttons">
            <g:form>
               <input type="hidden" name="id" value="${domain?.id}" />
               <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
               <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
            </g:form>
         </div>
      </div>
   </body>
</html>
