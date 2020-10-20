<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.material.show.label.title" path="title"/>
	<acme:form-textbox code="anonymous.material.show.label.providerName" path="providerName"/>
	<acme:form-textbox code="anonymous.material.show.label.homePage" path="homePage"/>
	<acme:form-textbox code="anonymous.material.show.label.stars" path="stars"/>
	<acme:form-textarea code="anonymous.material.show.label.description" path="description"/>
	
	<acme:form-return code="anonymous.material.show.button.return"/>
</acme:form>
