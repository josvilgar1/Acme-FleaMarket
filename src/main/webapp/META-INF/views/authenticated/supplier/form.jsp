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
	<acme:form-textbox code="authenticated.supplier.form.label.company" path="company"/>
	<acme:form-url code="authenticated.supplier.form.label.homePage" path="homePage"/>
	<acme:form-textbox code="authenticated.supplier.form.label.itemCategory" path="itemCategory"/>
	<acme:form-textbox code="authenticated.supplier.form.label.description" path="description"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.supplier.form.button.create" action="/authenticated/supplier/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.supplier.form.button.update" action="/authenticated/supplier/update"/>
	<acme:form-return code="authenticated.supplier.form.button.return"/>
</acme:form>
