<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="auditor.item.form.label.ticker" path="ticker"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="auditor.item.form.label.creationMoment" 
			path="creationMoment" 
			readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="auditor.item.form.label.title" path="title"/>
	<acme:form-textbox code="auditor.item.form.label.itemCategory" path="itemCategory"/>
	<acme:form-textarea code="auditor.item.form.label.description" path="description"/>
	<acme:form-money code="auditor.item.form.label.price" path="price"/>
	<acme:form-textbox code="auditor.item.form.label.photo" path="photo"/>
	<acme:form-textbox code="auditor.item.form.label.link" path="link"/>
	
	<acme:form-submit method="get" code="auditor.item.form.button.list.section" action="/authenticated/section/list?item.id=${id}" />
	<acme:form-submit method="get" code="auditor.item.form.button.list.message" action="/authenticated/message/list?item.id=${id}" />
	<acme:form-submit method="get" code="auditor.item.form.button.list.auditrecord" action="/authenticated/auditrecord/list?id=${id}"/>
	<acme:form-return code="auditor.item.show.button.return"/>
</acme:form>
