<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="buyer.request.list.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="buyer.request.list.label.creationMoment" path="creationMoment" width="20%"/>
	<acme:list-column code="buyer.request.list.label.quantity" path="quantity" width="20%"/>
	<acme:list-column code="buyer.request.list.label.item-title" path="item.title" width="20%"/>
</acme:list>