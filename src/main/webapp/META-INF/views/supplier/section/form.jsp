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
	<acme:form-hidden path="item.id"/>
	<acme:form-textbox code="supplier.section.form.label.item" path="item.title" readonly="true"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-integer code="supplier.section.form.label.index" path="index" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="supplier.section.form.label.title" path="title"/>
	<acme:form-textarea code="supplier.section.form.label.description" path="description"/>
	<acme:form-url code="supplier.section.form.label.photo" path="photo"/>
	
	<acme:form-submit test="${command == 'create'}" code="supplier.section.form.button.create"	action="/supplier/section/create"/>
	<acme:form-submit test="${command != 'create' and status != 'PUBLISHED'}" code="supplier.section.form.button.update" action="/supplier/section/update"/>
	<acme:form-submit test="${command != 'create' and status != 'PUBLISHED'}" code="supplier.section.form.button.delete" action="/supplier/section/delete"/>
	<acme:form-return code="supplier.section.show.button.return"/>
</acme:form>
