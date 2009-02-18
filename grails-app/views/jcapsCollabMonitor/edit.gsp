

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>Edit JcapsCollabMonitor</title>
   </head>
   <body>
      <div class="nav">
         <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
         <span class="menuButton"><g:link class="list" action="list">JcapsCollabMonitor List</g:link></span>
         <span class="menuButton"><g:link class="create" action="create">New JcapsCollabMonitor</g:link></span>
      </div>
      <div class="body">
         <h1>Edit JcapsCollabMonitor</h1>
         <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
         </g:if>
         <g:hasErrors bean="${jcapsCollabMonitor}">
            <div class="errors">
               <g:renderErrors bean="${jcapsCollabMonitor}" as="list" />
            </div>
         </g:hasErrors>
         <g:form method="post" >
            <input type="hidden" name="id" value="${jcapsCollabMonitor?.id}" />
            <div class="dialog">
               <table>
                  <tbody>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="short_name">Shortname:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'short_name','errors')}">
                           <input type="text" id="short_name" name="short_name" value="${fieldValue(bean:jcapsCollabMonitor,field:'short_name')}"/>
                        </td>
                     </tr>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="collab_instances">Collabinstances:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'collab_instances','errors')}">
                           <input type="text" id="collab_instances" name="collab_instances" value="${fieldValue(bean:jcapsCollabMonitor,field:'collab_instances')}" />
                        </td>
                     </tr>
<!--
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="dateCreated">Date Created:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'dateCreated','errors')}">
                           <g:datePicker name="dateCreated" value="${jcapsCollabMonitor?.dateCreated}" ></g:datePicker>
                        </td>
                     </tr>
-->
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="domain">Domain:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'domain','errors')}">
                           <g:select optionKey="id" from="${Domain.list()}" name="domain.id" value="${jcapsCollabMonitor?.domain?.id}" ></g:select>
                        </td>
                     </tr>
<!--
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="lastUpdated">Last Updated:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'lastUpdated','errors')}">
                           <g:datePicker name="lastUpdated" value="${jcapsCollabMonitor?.lastUpdated}" ></g:datePicker>
                        </td>
                     </tr>
-->
                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="monitoring_MBean_name">Monitoring MB eanname:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'monitoring_MBean_name','errors')}">
                           <input type="text" id="monitoring_MBean_name" name="monitoring_MBean_name" value="${fieldValue(bean:jcapsCollabMonitor,field:'monitoring_MBean_name')}"/>
                        </td>
                     </tr>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="num_msg_in_process">Nummsginprocess:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'num_msg_in_process','errors')}">
                           <input type="text" id="num_msg_in_process" name="num_msg_in_process" value="${fieldValue(bean:jcapsCollabMonitor,field:'num_msg_in_process')}" />
                        </td>
                     </tr>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="num_msg_processed">Nummsgprocessed:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'num_msg_processed','errors')}">
                           <input type="text" id="num_msg_processed" name="num_msg_processed" value="${fieldValue(bean:jcapsCollabMonitor,field:'num_msg_processed')}"/>
                        </td>
                     </tr>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="since">Since:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'since','errors')}">
                           <g:datePicker name="since" value="${jcapsCollabMonitor?.since}" ></g:datePicker>
                        </td>
                     </tr>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="status">Status:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'status','errors')}">
                           <input type="text" id="status" name="status" value="${fieldValue(bean:jcapsCollabMonitor,field:'status')}"/>
                        </td>
                     </tr>

                     <tr class="prop">
                        <td valign="top" class="name">
                           <label for="stoppable">Stoppable:</label>
                        </td>
                        <td valign="top" class="value ${hasErrors(bean:jcapsCollabMonitor,field:'stoppable','errors')}">
                           <g:checkBox name="stoppable" value="${jcapsCollabMonitor?.stoppable}" ></g:checkBox>
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
