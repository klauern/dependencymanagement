

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Edit Zone</title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
      <span class="menuButton"><g:link class="list" action="list">Zone List</g:link></span>
      <span class="menuButton"><g:link class="create" action="create">New Zone</g:link></span>
    </div>
    <div class="body">
      <h1>Edit Zone</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${zoneInstance}">
        <div class="errors">
          <g:renderErrors bean="${zoneInstance}" as="list" />
        </div>
      </g:hasErrors>
      <g:form method="post" >
        <input type="hidden" name="id" value="${zoneInstance?.id}" />
        <div class="dialog">
          <table>
            <tbody>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="zone_type">Zonetype:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'zone_type','errors')}">
                  <g:select id="zone_type" name="zone_type" from="${zoneInstance.constraints.zone_type.inList}" value="${zoneInstance.zone_type}" ></g:select>
                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="domains">Domains:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'domains','errors')}">
<<<<<<< HEAD:grails-app/views/zone/edit.gsp
                  
<ul>
<g:each var="d" in="${zoneInstance?.domains?}">
    <li><g:link controller="domain" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="domain" params="['zone.id':zoneInstance?.id]" action="create">Add Domain</g:link>
=======
                  
<ul>
<g:each var="d" in="${zoneInstance?.domains?}">
    <li><g:link controller="domain" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="domain" params="['zone.id':zoneInstance?.id]" action="create">Add Domain</g:link>
>>>>>>> 9b2ae8e0c1d717947cf4056dcf6178d8c261cd3f:grails-app/views/zone/edit.gsp

                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="zone_name">Zonename:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'zone_name','errors')}">
                  <input type="text" id="zone_name" name="zone_name" value="${fieldValue(bean:zoneInstance,field:'zone_name')}"/>
                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="zone_usage">Zoneusage:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:zoneInstance,field:'zone_usage','errors')}">
                  <input type="text" id="zone_usage" name="zone_usage" value="${fieldValue(bean:zoneInstance,field:'zone_usage')}"/>
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
