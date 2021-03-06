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
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.item.form.label.ticker" path="ticker"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="authenticated.item.form.label.creationMoment" 
			path="creationMoment" 
			readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="authenticated.item.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.item.form.label.itemCategory" path="itemCategory"/>
	<acme:form-textarea code="authenticated.item.form.label.description" path="description"/>
	<acme:form-money code="authenticated.item.form.label.price" path="price"/>
	<acme:form-url code="authenticated.item.form.label.photo" path="photo"/>
	<acme:form-url code="authenticated.item.form.label.link" path="link"/>
	
	<acme:form-textarea code="authenticated.item.form.label.description" path="description"/>
	
	<acme:form-submit method="get" code="authenticated.item.form.button.list.message.create" action="/authenticated/message/create?itemId=${id}"/>
	<acme:form-submit method="get" code="authenticated.item.form.button.list.section" action="/authenticated/section/list?item.id=${id}" />
	<acme:form-submit method="get" code="authenticated.item.form.button.list.message" action="/authenticated/message/list?item.id=${id}" />
	<acme:form-submit method="get" code="authenticated.item.form.button.list.auditrecord" action="/authenticated/auditrecord/list?id=${id}"/>
	
	<security:authorize access="hasRole('Buyer')">
	    <acme:form-submit method="get" code="authenticated.item.form.button.create.request" action="/buyer/request/create?itemId=${id}"/>
	</security:authorize>
	
	<acme:form-return code="authenticated.item.show.button.return"/>
</acme:form>
