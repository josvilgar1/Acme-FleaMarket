<%--
- form.jsp
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

<acme:form-errors path="haveErrors"/>
<acme:form readonly="${status == 'PUBLISHED'}">
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="supplier.item.form.label.ticker" path="ticker" readonly="true"/>
	</jstl:if>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="supplier.item.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="supplier.item.form.label.title" path="title"/>
	<acme:form-textbox code="supplier.item.form.label.itemCategory" path="itemCategory"/>
	<acme:form-textarea code="supplier.item.form.label.description" path="description"/>
	<acme:form-money code="supplier.item.form.label.price" path="price"/>
	<acme:form-url code="supplier.item.form.label.photo" path="photo"/>
	<acme:form-url code="supplier.item.form.label.link" path="link"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-select code="supplier.item.form.label.status" path="status">
			<acme:form-option code="supplier.item.form.label.status.draft" value="DRAFT" selected="${status != 'PUBLISHED'}"/>
			<acme:form-option code="supplier.item.form.label.status.published" value="PUBLISHED" selected="${status == 'PUBLISHED'}"/>
		</acme:form-select>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" code="supplier.item.form.button.create"	action="/supplier/item/create"/>
	<acme:form-submit test="${command != 'create' and status != 'PUBLISHED'}" code="supplier.item.form.button.update" action="/supplier/item/update"/>
	<acme:form-submit test="${command != 'create'}" code="supplier.item.form.button.delete" action="/supplier/item/delete"/>
	
	<jstl:if test="${command != 'create'}">
		<jstl:choose>
			<jstl:when test="${haveSections}">
				<acme:form-submit method="get" code="supplier.item.form.button.list.section" action="/supplier/section/list?item.id=${id}" />
			</jstl:when>
			<jstl:otherwise>
				<acme:form-submit method="get" code="supplier.item.form.button.create.section" action="/supplier/section/create?item.id=${id}" />
			</jstl:otherwise>
		</jstl:choose>
		<acme:form-submit method="get" code="supplier.item.form.button.list.message" action="/authenticated/message/list?item.id=${id}" />
		<acme:form-submit method="get" code="supplier.item.show.button.list.auditrecord" action="/authenticated/auditrecord/list?id=${id}"/>
	</jstl:if>

	<acme:form-return code="supplier.item.show.button.return"/>
</acme:form>
