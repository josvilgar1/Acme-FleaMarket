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
	<acme:form-textbox code="anonymous.authenticated.form.label.category" path="category"/>
	<acme:form-url code="anonymous.authenticated.form.label.headerPicture" path="headerPicture"/>
	<acme:form-textbox code="anonymous.authenticated.form.label.title" path="title"/>
	<acme:form-moment code="anonymous.authenticated.form.label.creationMoment" path="creationMoment"/>
	<acme:form-moment code="anonymous.authenticated.form.label.deadlineMoment" path="deadlineMoment"/>
	<acme:form-textarea code="anonymous.authenticated.form.label.body" path="body"/>
	<acme:form-url code="anonymous.authenticated.form.label.links" path="links"/>
	
  	<acme:form-return code="anonymous.authenticated.form.button.return"/>
</acme:form>
