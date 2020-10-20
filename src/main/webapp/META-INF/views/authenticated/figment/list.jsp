<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.figment.list.label.title" path="title"/>
	<acme:list-column code="authenticated.figment.list.label.inventor" path="inventor"/>
	<acme:list-column code="authenticated.figment.list.label.description" path="description"/>
</acme:list>