<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list >
	<acme:list-column code="administrator.list.advertisement.label.title" path="title" width="25%" />
	<acme:list-column code="administrator.list.advertisement.label.inicialDate" path="inicialDate" width="25%"/>			
	<acme:list-column code="administrator.list.advertisement.label.finalDate" path="finalDate" width="25%"/>		
</acme:list>

<acme:form>
	<acme:form-submit 
		method="get" 
		code="administrator.form.advertisement.label.button.create" 
		action="/administrator/advertisement/create"/>
</acme:form>