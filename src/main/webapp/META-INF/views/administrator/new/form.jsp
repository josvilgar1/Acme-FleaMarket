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

<acme:form>
	<acme:form-textbox code="administrator.new.form.label.category" path="category"/>
	<acme:form-url code="administrator.new.form.label.headerPicture" path="headerPicture"/>
	<acme:form-textbox code="administrator.new.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="administrator.new.form.label.creationMoment" 
			path="creationMoment"
			readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.new.form.label.deadlineMoment" path="deadlineMoment"/>
	<acme:form-textarea code="administrator.new.form.label.body" path="body"/>
	<acme:form-textbox code="administrator.new.form.label.links" path="links"/>
	<jstl:if test="${command == 'create'}">
		<acme:form-checkbox code="administrator.new.form.label.confirmation" path="confirmation"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.new.form.button.create" 
		action="/administrator/new/create"/>
  	<acme:form-return code="administrator.new.form.button.return"/>
</acme:form>
