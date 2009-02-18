<html>
<head>
  <title>Grails Dependency Managment Suite for EAI</title>
  <meta name="layout" content="main" />
</head>
<body>
  <h1 style="margin-left:20px;">Welcome to EAI Dependency Management Utility (DMU)</h1>
  <p style="margin-left:20px;width:80%">This applicaition allos for someone on-call to
    successfully traverse the many integrations that are associated with EAI and our vendors.  Please
  look at the many controllers below to get started working with it.</p></br>

  <div class="dialog" style="margin-left:20px;width:70%;">
    <ul>
      <li><g:link controller="application">Application Creation/Modification</g:link></li>
      <li><g:link controller="intdetail">Integration Details</g:link></li>
      <li><g:link controller="event">Events</g:link></li>
      <li><g:link controller="contact">Contact Details for Support</g:link></li>
      <li><g:link controller="zone">Solaris/Windows, etc. Zones</g:link></li>
      <li><g:link controller="domain">Server Domains</g:link></li>
      <li><g:link controller="port">Port Connectivity Information</g:link></li>
      <li><g:link controller="support">Support Information</g:link></li>
      <li><g:link controller="integration">Integration Overview</g:link></li>
      <!-- IntDetailController
EventController
ApplicationController
ContactController
ZoneController
DomainController
IntegrationController
PortController
SupportController
-->

    </ul>
  </div>
</br>
<p>IN case I missed anything, for debugging, we're regenerating the domain listing automatically for consistency.</p>
  <div class="dialog" style="margin-left:20px;width:60%;">
    <ul>
      <g:each var="c" in="${grailsApplication.controllerClasses}">
        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
      </g:each>
    </ul>
  </div>

</body>
</html>