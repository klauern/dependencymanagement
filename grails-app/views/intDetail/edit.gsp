

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Edit IntDetail</title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
      <span class="menuButton"><g:link class="list" action="list">IntDetail List</g:link></span>
      <span class="menuButton"><g:link class="create" action="create">New IntDetail</g:link></span>
    </div>
    <div class="body">
      <h1>Edit IntDetail</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${intDetailInstance}">
        <div class="errors">
          <g:renderErrors bean="${intDetailInstance}" as="list" />
        </div>
      </g:hasErrors>
      <g:form method="post" >
        <input type="hidden" name="id" value="${intDetailInstance?.id}" />
        <div class="dialog">
          <table>
            <tbody>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="direction">Direction:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:intDetailInstance,field:'direction','errors')}">
                  <g:select id="direction" name="direction" from="${intDetailInstance.constraints.direction.inList}" value="${intDetailInstance.direction}" ></g:select>
                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="connection">Connection:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:intDetailInstance,field:'connection','errors')}">
                  <g:select optionKey="id" from="${Port.list()}" name="connection.id" value="${intDetailInstance?.connection?.id}" ></g:select>
                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="connection_name">Connectionname:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:intDetailInstance,field:'connection_name','errors')}">
                  <input type="text" id="connection_name" name="connection_name" value="${fieldValue(bean:intDetailInstance,field:'connection_name')}"/>
                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="description">Description:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:intDetailInstance,field:'description','errors')}">
                  <input type="text" id="description" name="description" value="${fieldValue(bean:intDetailInstance,field:'description')}"/>
                </td>
              </tr>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="username">Username:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:intDetailInstance,field:'username','errors')}">
                  <input type="text" id="username" name="username" value="${fieldValue(bean:intDetailInstance,field:'username')}"/>
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
