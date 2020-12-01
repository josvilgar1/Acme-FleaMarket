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
	<acme:form-textbox code="authenticated.buyer.form.label.email" path="email"/>
	<acme:form-textbox code="authenticated.buyer.form.label.phone" path="phone"/>
	<acme:form-textbox code="authenticated.buyer.form.label.address" path="address"/>
	<acme:form-textbox code="authenticated.buyer.form.label.creditCardNumber" path="creditCardNumber"/>
	<acme:form-textbox code="authenticated.buyer.form.label.creditCardName" path="creditCardName"/>
	<acme:form-textbox code="authenticated.buyer.form.label.creditCardMonth" path="creditCardMonth"/>
	<acme:form-textbox code="authenticated.buyer.form.label.creditCardYear" path="creditCardYear"/>
	<acme:form-textbox code="authenticated.buyer.form.label.creditCardCVV" path="creditCardCVV"/>
	<acme:form-textbox code="authenticated.buyer.form.label.creditCardType" path="creditCardType"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.buyer.form.button.create" action="/authenticated/buyer/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.buyer.form.button.update" action="/authenticated/buyer/update"/>
	<acme:form-return code="authenticated.buyer.form.button.return"/>
</acme:form>
