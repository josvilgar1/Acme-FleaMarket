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
	<!-- //TODO: Cambiar -->
	<acme:form-textbox code="administrator.dashboard.form.lable.ratioJobWithXxx" path="ratioItemWithXxx" />
	<acme:form-textbox code="administrator.dashboard.form.lable.ratioXxxWithTicker" path="ratioRequestsWithLink" />
	<acme:form-textbox code="administrator.dashboard.form.lable.ratioRequestsWithTickerAndPass" path="ratioRequestsWithLinkAndPass" />
	

	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>
