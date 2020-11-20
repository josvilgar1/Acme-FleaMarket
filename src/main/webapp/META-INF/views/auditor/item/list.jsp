<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list >
	<acme:list-column code="auditor.item.list.label.title" path="title" width="30%"/>
	<acme:list-column code="auditor.item.list.label.itemCategory" path="itemCategory" width="40%"/>
	<acme:list-column code="auditor.item.list.label.price" path="price" width="30%"/>
</acme:list>