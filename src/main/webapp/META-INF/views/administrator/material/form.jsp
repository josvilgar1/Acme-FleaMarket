<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	<acme:form-textbox code="administrator.form.material.label.title" path="title"/>
	<acme:form-textbox code="administrator.form.material.label.providerName" path="providerName"/>
	<acme:form-url code="administrator.form.material.label.homePage" path="homePage"/>
	<acme:form-integer code="administrator.form.material.label.stars" path="stars"/>
	<acme:form-textarea code="administrator.form.material.label.description" path="description"/>

	<acme:form-submit test ="${command=='show' }" code="administrator.form.material.label.button.update" action="/administrator/material/update"/>
	<acme:form-submit test ="${command=='show' }" code="administrator.form.material.label.button.delete" action="/administrator/material/delete"/>
	<acme:form-submit test ="${command=='create'}" code="administrator.form.material.label.button.create" action="/administrator/material/create"/>
	<acme:form-submit test ="${command=='update' }" code="administrator.form.material.label.button.update" action="/administrator/material/update"/>
	<acme:form-submit test ="${command=='delete' }" code="administrator.form.material.label.button.delete" action="/administrator/material/delete"/>
  	
  	<acme:form-return code="administrator.form.material.label.button.return"/>
</acme:form>