<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list >
	<acme:list-column code="administrator.list.figment.label.title" path="title" width="25%" />
	<acme:list-column code="administrator.list.figment.label.inventor" path="inventor" width="25%"/>			
	<acme:list-column code="administrator.list.figment.label.description" path="description" width="50%"/>		
</acme:list>

<acme:form>
	<acme:form-submit 
		method="get" 
		code="administrator.form.figment.label.button.create" 
		action="/administrator/figment/create"/>
</acme:form>
