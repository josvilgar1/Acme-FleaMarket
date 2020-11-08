<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list >
	<acme:list-column code="administrator.list.material.label.title" path="title" width="25%" />
	<acme:list-column code="administrator.list.material.label.providerName" path="providerName" width="25%"/>			
	<acme:list-column code="administrator.list.material.label.stars" path="stars" width="25%"/>		
</acme:list>

<acme:form>
	<acme:form-submit 
		method="get" 
		code="administrator.form.material.label.button.create" 
		action="/administrator/material/create"/>
</acme:form>
