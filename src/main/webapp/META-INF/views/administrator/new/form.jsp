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
	<acme:form-textbox code="anonymous.administrator.form.label.category" path="category"/>
	<acme:form-url code="anonymous.administrator.form.label.headerPicture" path="headerPicture"/>
	<acme:form-textbox code="anonymous.administrator.form.label.title" path="title"/>
	<acme:form-moment code="anonymous.administrator.form.label.creationMoment" path="creationMoment"/>
	<acme:form-moment code="anonymous.administrator.form.label.deadlineMoment" path="deadlineMoment"/>
	<acme:form-textarea code="anonymous.administrator.form.label.body" path="body"/>
	<acme:form-textbox code="anonymous.administrator.form.label.links" path="links"/>
	
  	<acme:form-return code="anonymous.administrator.form.button.return"/>
</acme:form>
