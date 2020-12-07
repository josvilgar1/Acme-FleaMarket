<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form-errors path="outOfPeriod"/>
<br/>
<acme:form readonly="false">
	<acme:form-textbox code="administrator.form.advertisement.label.title" path="title"/>
	<acme:form-url code="administrator.form.advertisement.label.picture" path="picture"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="administrator.form.advertisement.label.moment" path="moment" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.form.advertisement.label.inicialDate" path="inicialDate"/>
	<acme:form-moment code="administrator.form.advertisement.label.finalDate" path="finalDate"/>
	<acme:form-textarea code="administrator.form.advertisement.label.text" path="text"/>
	<acme:form-textbox code="administrator.form.advertisement.label.volumeDiscounts" path="volumeDiscounts"/>

	<acme:form-submit test ="${command=='show' }" code="administrator.form.advertisement.label.button.update" action="/administrator/advertisement/update"/>
	<acme:form-submit test ="${command=='show' }" code="administrator.form.advertisement.label.button.delete" action="/administrator/advertisement/delete"/>
	<acme:form-submit test ="${command=='create'}" code="administrator.form.advertisement.label.button.create" action="/administrator/advertisement/create"/>
	<acme:form-submit test ="${command=='update' }" code="administrator.form.advertisement.label.button.update" action="/administrator/advertisement/update"/>
	<acme:form-submit test ="${command=='delete' }" code="administrator.form.advertisement.label.button.delete" action="/administrator/advertisement/delete"/>
  	
  	<acme:form-return code="administrator.form.advertisement.label.button.return"/>
</acme:form>