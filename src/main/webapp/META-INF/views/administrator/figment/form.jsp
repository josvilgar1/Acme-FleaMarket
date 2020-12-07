<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	<acme:form-textbox code="administrator.form.figment.label.title" path="title"/>
	<acme:form-textbox code="administrator.form.figment.label.inventor" path="inventor"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="authenticated.figment.show.label.moment" path="moment" readonly="true"/>
	</jstl:if>
	<acme:form-money code="administrator.form.figment.label.rangeMin" path="rangeMin"/>
	<acme:form-money code="administrator.form.figment.label.rangeMax" path="rangeMax"/>
	<acme:form-textarea code="administrator.form.figment.label.description" path="description"/>

	<acme:form-submit test ="${command=='show' }" code="administrator.form.figment.label.button.update" action="/administrator/figment/update"/>
	<acme:form-submit test ="${command=='show' }" code="administrator.form.figment.label.button.delete" action="/administrator/figment/delete"/>
	<acme:form-submit test ="${command=='create'}" code="administrator.form.figment.label.button.create" action="/administrator/figment/create"/>
	<acme:form-submit test ="${command=='update' }" code="administrator.form.figment.label.button.update" action="/administrator/figment/update"/>
	<acme:form-submit test ="${command=='delete' }" code="administrator.form.figment.label.button.delete" action="/administrator/figment/delete"/>
  	
  	<acme:form-return code="administrator.form.figment.label.button.return"/>
</acme:form>