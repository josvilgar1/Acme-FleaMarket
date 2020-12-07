<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.figment.show.label.title" path="title"/>
	<acme:form-textbox code="authenticated.figment.show.label.inventor" path="inventor"/>
	<acme:form-moment code="authenticated.figment.show.label.moment" path="moment"/>
	<acme:form-money code="administrator.form.figment.label.rangeMin" path="rangeMin"/>
	<acme:form-money code="administrator.form.figment.label.rangeMax" path="rangeMax"/>
	<acme:form-textarea code="authenticated.figment.show.label.description" path="description"/>

	
	<acme:form-return code="authenticated.figment.show.button.return"/>
</acme:form>