

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
            <g:hasErrors bean="${domainInstance}">
            <div class="errors">
                <g:renderErrors bean="${domainInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domain_description">Domaindescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'domain_description','errors')}">
                                    <input type="text" id="domain_description" name="domain_description" value="${fieldValue(bean:domainInstance,field:'domain_description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domain_name">Domainname:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'domain_name','errors')}">
                                    <input type="text" id="domain_name" name="domain_name" value="${fieldValue(bean:domainInstance,field:'domain_name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="zone">Zone:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:domainInstance,field:'zone','errors')}">
                                    <g:select optionKey="id" from="${Zone.list()}" name="zone.id" value="${domainInstance?.zone?.id}" ></g:select>
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
