<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.advertisement.show.label.title" path="title"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.picture" path="picture"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.moment" path="moment"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.inicialDate" path="inicialDate"/>
	<acme:form-textbox code="authenticated.advertisement.show.label.finalDate" path="finalDate"/>
	<acme:form-textarea code="authenticated.advertisement.show.label.text" path="text"/>
	<acme:form-textarea code="authenticated.advertisement.show.label.volumeDiscounts" path="volumeDiscounts"/>
	<acme:form-url code="authenticated.advertisement.show.label.picture" path="picture"/>
	
	<acme:form-return code="authenticated.advertisement.show.button.return"/>
</acme:form>