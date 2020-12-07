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
	<acme:form-textbox code="supplier.request.form.label.ticker" path="ticker" readonly="true"/>
	<acme:form-moment code="supplier.request.form.label.creationMoment" path="creationMoment" readonly="true"/>
	<acme:form-textbox code="supplier.request.form.label.item" path="item.title" readonly="true"/>
	<acme:form-textbox code="supplier.request.form.label.buyer" path="buyer.email" readonly="true"/>
	<acme:form-integer code="supplier.request.form.label.quantity" path="quantity" readonly="true"/>
	<acme:form-textarea code="supplier.request.form.label.notes" path="notes" readonly="true"/>
	<acme:form-checkbox code="supplier.request.form.label.item.isnew" path="item.isNew" readonly="true"/>
	
	<acme:form-select code="supplier.request.form.label.process" path="process">
			<acme:form-option code="supplier.request.form.label.process.pending" value="PENDING" selected="${process == 'PENDING'}"/>
			<acme:form-option code="supplier.request.form.label.process.accepted" value="ACCEPTED" selected="${process == 'ACCEPTED'}"/>
			<acme:form-option code="supplier.request.form.label.process.rejected" value="REJECTED" selected="${process == 'REJECTED'}"/>
		</acme:form-select>
	<acme:form-textarea code="supplier.request.form.label.item.justification" path="justification"/>
	
	<acme:form-submit test="${command != 'create' and process == 'PENDING'}" code="supplier.request.form.button.update" action="/supplier/request/update"/>
	
	<acme:form-return code="supplier.request.show.button.return"/>
</acme:form>
