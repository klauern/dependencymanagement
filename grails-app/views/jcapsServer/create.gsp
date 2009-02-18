

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>Create JcapsServer</title>
   </head>
   <body>
      <div class="nav">
         <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
         <span class="menuButton"><g:link class="list" action="list">JcapsServer List</g:link></span>
      </div>
      <div class="body">
         <h1>Create JcapsServer</h1>
         <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
         </g:if>
         <g:hasErrors bean="${jcapsServer}">
            <div class="errors">
               <g:renderErrors bean="${jcapsServer}" as="list" />
            </div>
         </g:hasErrors>
         <g:form action="save" method="post" >
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
               <span class="button"><input class="save" type="submit" value="Create" /></span>
            </div>
         </g:form>
      </div>
   </body>
</html>
