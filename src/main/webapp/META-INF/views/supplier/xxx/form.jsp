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
	<acme:form-textbox code="supplier.xxx.form.label.item" path="item.title" readonly="true"/>
	<acme:form-textbox code="supplier.xxx.form.label.text" path="text" />
	<acme:form-money code="supplier.xxx.form.label.pricemin" path="priceMin"/>
	<acme:form-money code="supplier.xxx.form.label.pricemax" path="priceMax"/>
	<acme:form-textbox code="supplier.xxx.form.label.code" path="code"/>
	
	<acme:form-submit test="${command == 'create'}" code="supplier.xxx.form.button.create"	action="/supplier/xxx/create"/>
	<acme:form-submit test="${command != 'create'}" code="supplier.xxx.form.button.update" action="/supplier/xxx/update"/>
	<acme:form-submit test="${command != 'create'}" code="supplier.xxx.form.button.delete" action="/supplier/xxx/delete"/>
	<acme:form-return code="supplier.xxx.show.button.return"/>
</acme:form>
