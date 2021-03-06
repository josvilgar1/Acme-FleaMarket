<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.toolsheet.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.toolsheet.form.label.providerName" path="providerName" />
	<acme:form-textarea code="authenticated.toolsheet.form.label.description" path="description"/>
	<acme:form-url code="authenticated.toolsheet.form.label.homePage" path="homePage"/>
	<acme:form-integer code="authenticated.toolsheet.form.label.stars" path="stars" placeholder="[0-5]"/>
	
  	<acme:form-return code="authenticated.toolsheet.form.button.return"/>
</acme:form>
