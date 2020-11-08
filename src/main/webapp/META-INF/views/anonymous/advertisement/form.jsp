<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.advertisement.show.label.title" path="title"/>
	<acme:form-textbox code="anonymous.advertisement.show.label.picture" path="picture"/>
	<acme:form-textbox code="anonymous.advertisement.show.label.moment" path="moment"/>
	<acme:form-textbox code="anonymous.advertisement.show.label.inicialDate" path="inicialDate"/>
	<acme:form-textbox code="anonymous.advertisement.show.label.finalDate" path="finalDate"/>
	<acme:form-textarea code="anonymous.advertisement.show.label.text" path="text"/>
	<acme:form-textarea code="anonymous.advertisement.show.label.volumeDiscounts" path="volumeDiscounts"/>
	<acme:form-textbox code="anonymous.advertisement.show.label.picture" path="picture"/>
	
	<acme:form-return code="anonymous.advertisement.show.button.return"/>
</acme:form>