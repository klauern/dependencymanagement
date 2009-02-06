

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Edit Contact</title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
      <span class="menuButton"><g:link class="list" action="list">Contact List</g:link></span>
      <span class="menuButton"><g:link class="create" action="create">New Contact</g:link></span>
    </div>
    <div class="body">
      <h1>Edit Contact</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${contactInstance}">
        <div class="errors">
          <g:renderErrors bean="${contactInstance}" as="list" />
        </div>
      </g:hasErrors>
      <g:form method="post" >
        <input type="hidden" name="id" value="${contactInstance?.id}" />
        <div class="dialog">
          <table>
            <tbody>
              
              <tr class="prop">
                <td valign="top" class="name">
                  <label for="name">Name:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:contactInstance,field:'name','errors')}">
                  <input type="text" id="name" name="name" value="${fieldValue(bean:contactInstance,field:'name')}"/>
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
