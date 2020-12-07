
<%--
- list.jsp
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

<acme:list >
	<acme:list-column code="supplier.request.list.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="supplier.request.list.label.creationMoment" path="creationMoment" width="20%"/>
	<acme:list-column code="supplier.request.list.label.item" path="item.title" width="20%" sortable="false"/>
	<acme:list-column code="supplier.request.list.label.buyer" path="buyer.email" width="20%" sortable="false"/>
	<acme:list-column code="supplier.request.list.label.item.isnew" path="item.isNew" width="20%" sortable="false"/>
</acme:list>
