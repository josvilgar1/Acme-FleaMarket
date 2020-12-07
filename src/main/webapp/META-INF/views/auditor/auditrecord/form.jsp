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

<acme:form>
	<acme:form-hidden path="item.id"/>
	<acme:form-textbox readonly="true" code="auditor.auditrecord.form.label.item" path="item.title"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="auditor.auditrecord.form.label.creationMoment" 
			path="creationMoment" 
			readonly="true"/>
		<acme:form-textbox code="auditor.auditrecord.form.label.auditor.firm" path="auditor.firm"/>
	</jstl:if>
	<acme:form-textbox code="auditor.auditrecord.form.label.title" path="title"/>
	<acme:form-textarea code="auditor.auditrecord.form.label.body" path="body"/>
	
	<acme:form-select code="supplier.item.form.label.status" path="status">
		<acme:form-option code="supplier.item.form.label.status.draft" value="DRAFT" selected="${status != 'PUBLISHED'}"/>
		<acme:form-option code="supplier.item.form.label.status.published" value="PUBLISHED" selected="${status == 'PUBLISHED'}"/>
	</acme:form-select>
	
	 <acme:form-submit 
	 	test = "${(command=='show' || command=='update') && status!='PUBLISHED'}" 
  		code="auditor.auditrecord.form.button.update" 
  		action="/auditor/auditrecord/update"/>
  		
  	<acme:form-submit test="${command == 'create'}" code="auditor.auditrecord.form.button.create" action="/auditor/auditrecord/create"/>

	<acme:form-return code="auditor.auditrecord.form.button.return"/>
</acme:form>
