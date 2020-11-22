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
	<acme:form-textbox code="authenticated.item.form.label.photo" path="photo"/>
	<acme:form-textbox code="authenticated.item.form.label.link" path="link"/>
	
	<acme:form-return code="authenticated.item.show.button.return"/>
</acme:form>
