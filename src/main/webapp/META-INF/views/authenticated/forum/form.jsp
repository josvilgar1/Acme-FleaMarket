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
	<acme:form-textbox code="authenticated.forum.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.forum.form.label.item" path="item.title"/>
	
	<acme:form-submit method="get" code="authenticated.forum.form.button.list.message" action="/authenticated/message/list?itemId=${itemId}" />
	<acme:form-return code="authenticated.forum.show.button.return"/>
</acme:form>
