

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Domain</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Domain List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Domain</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Domain</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${domain}">
            <div class="errors">
                <g:renderErrors bean="${domain}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${domain?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="servername">Servername:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domain,field:'servername','errors')}">
                                    <g:select optionKey="id" from="${JcapsServer.list()}" name="servername.id" value="${domain?.servername?.id}" ></g:select>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="port">Port:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domain,field:'port','errors')}">
                                    <input type="text" id="port" name="port" value="${fieldValue(bean:domain,field:'port')}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="alias">Alias:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domain,field:'alias','errors')}">
                                    <input type="text" id="alias" name="alias" value="${fieldValue(bean:domain,field:'alias')}"/>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="collabs">Collabs:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domain,field:'collabs','errors')}">

<ul>
<g:each var="c" in="${domain?.collabs?}">
    <li><g:link controller="jcapsCollabMonitor" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="jcapsCollabMonitor" params="['domain.id':domain?.id]" action="create">Add JcapsCollabMonitor</g:link>

                                </td>
                            </tr>
<!--
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domain,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${domain?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domain,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${domain?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr>
-->
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
