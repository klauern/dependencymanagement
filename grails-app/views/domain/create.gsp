<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Domain</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Domain List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Domain</h1>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${domain}">
                <div class="errors">
                    <g:renderErrors bean="${domain}" as="list" />
                </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
