

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>Edit JcapsServer</title>
   </head>
   <body>
      <div class="nav">
         <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
         <span class="menuButton"><g:link class="list" action="list">JcapsServer List</g:link></span>
         <span class="menuButton"><g:link class="create" action="create">New JcapsServer</g:link></span>
      </div>
      <div class="body">
         <h1>Edit JcapsServer</h1>
         <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
         </g:if>
         <g:hasErrors bean="${jcapsServer}">
            <div class="errors">
               <g:renderErrors bean="${jcapsServer}" as="list" />
            </div>
         </g:hasErrors>
         <g:form method="post" >
            <input type="hidden" name="id" value="${jcapsServer?.id}" />
            <div class="dialog">
               <table>
                  <tbody>
<!--
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="dateCreated">Date Created:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsServer,field:'dateCreated','errors')}">
                           <g:datePicker name="dateCreated" value="${jcapsServer?.dateCreated}" ></g:datePicker>
                        </td>
                     </tr>
-->
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="domains">Domains:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsServer,field:'domains','errors')}">

                           <ul>
                              <g:each var="d" in="${jcapsServer?.domains?}">
                                 <li><g:link controller="domain" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
                              </g:each>
                           </ul>
                           <g:link controller="domain" params="['jcapsServer.id':jcapsServer?.id]" action="create">Add Domain</g:link>

                        </td>
                     </tr>
<!--
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="lastUpdated">Last Updated:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsServer,field:'lastUpdated','errors')}">
                           <g:datePicker name="lastUpdated" value="${jcapsServer?.lastUpdated}" ></g:datePicker>
                        </td>
                     </tr>
-->
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="servername">Servername:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsServer,field:'servername','errors')}">
                           <input type="text" id="servername" name="servername" value="${fieldValue(bean:jcapsServer,field:'servername')}"/>
                        </td>
                     </tr>

                  </tbody>
               </table>
            </div>
            <div class="buttons">
               <span class="button"><g:actionSubmit class="save" value="Update" /></span>
               <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
            </div>
         </g:form>
      </div>
   </body>
</html>
