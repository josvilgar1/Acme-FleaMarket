<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.advertisement.list.label.title" path="title"/>
	<acme:list-column code="authenticated.advertisement.list.label.finalDate" path="finalDate"/>
	<acme:list-column code="authenticated.advertisement.list.label.text" path="text"/>
</acme:list>