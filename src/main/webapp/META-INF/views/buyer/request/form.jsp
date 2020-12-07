<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form-errors path="haveErrors"/>
<acme:form>
	<acme:form-hidden path="item.id"/>
	<jstl:if test="${command !='create'}">
		<acme:form-textbox code="authenticated.advertisement.show.label.process" path="process"/>
		<acme:form-textbox code="authenticated.advertisement.show.label.ticker" path="ticker"/>
		<acme:form-moment code="authenticated.advertisement.show.label.creationMoment" path="creationMoment"/>
		<acme:form-textarea code="authenticated.advertisement.show.label.justification" path="justification"/>
	</jstl:if>
	<acme:form-integer code="authenticated.advertisement.show.label.quantity" path="quantity"/>
	<acme:form-textarea code="authenticated.advertisement.show.label.notes" path="notes"/>
	
	<jstl:if test="${command !='create'}">
		<acme:form-textbox code="authenticated.advertisement.show.label.buyer-email" path="buyer.email"/>
		<acme:form-textbox code="authenticated.advertisement.show.label.item-title" path="item.title"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" code="buyer.item.form.button.create" action="/buyer/request/create"/>
	
	<acme:form-return code="authenticated.advertisement.show.button.return"/>
</acme:form>