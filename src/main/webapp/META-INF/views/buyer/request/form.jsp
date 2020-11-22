<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.advertisement.show.label.ticker" path="ticker"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.quantity" path="quantity"/>
	<acme:form-textarea code="authenticated.advertisement.show.label.notes" path="notes"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.buyer-email" path="buyer.email"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.item-title" path="item.title"/>
	
	<acme:form-return code="authenticated.advertisement.show.button.return"/>
</acme:form>