

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Port</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Port List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Port</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${portInstance}">
            <div class="errors">
                <g:renderErrors bean="${portInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domain">Domain:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:portInstance,field:'domain','errors')}">
                                    <g:select optionKey="id" from="${Domain.list()}" name="domain.id" value="${portInstance?.domain?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="port_number">Portnumber:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:portInstance,field:'port_number','errors')}">
                                    <input type="text" id="port_number" name="port_number" value="${fieldValue(bean:portInstance,field:'port_number')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="port_use_description">Portusedescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:portInstance,field:'port_use_description','errors')}">
                                    <input type="text" id="port_use_description" name="port_use_description" value="${fieldValue(bean:portInstance,field:'port_use_description')}"/>
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
