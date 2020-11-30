<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
	
		<!-- ANONYMOUS -->
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.material.list" action="/anonymous/material/list"/>
			<acme:menu-suboption code="master.menu.anonymous.advertisement.list" action="/anonymous/advertisement/list"/>
			<acme:menu-suboption code="master.menu.anonymous.new.activate" action="/anonymous/new/list-active"/>
			<acme:menu-suboption code="master.menu.anonymous.toolsheet.list" action="/anonymous/toolsheet/list"/>
		</acme:menu-option>
		
		<!-- ADMINISTRATOR -->
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.new.list" action="/administrator/new/list"/>
			<acme:menu-suboption code="master.menu.administrator.materialsheets" action="/administrator/material/list"/>
			<acme:menu-suboption code="master.menu.administrator.toolsheet.list" action="/administrator/toolsheet/list"/>
			<acme:menu-suboption code="master.menu.administrator.advertisements" action="/administrator/advertisement/list"/>
			<acme:menu-suboption code="master.menu.administrator.suggestion.list" action="/administrator/suggestion/list"/>
			<acme:menu-suboption code="master.menu.administrator.figments" action="/administrator/figment/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.spam" action="/administrator/spam/list"/>
			<acme:menu-suboption code="master.menu.administrator.newCategory" action="/administrator/new-category/list"/>
			<acme:menu-suboption code="master.menu.administrator.itemCategory" action="/administrator/item-category/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>
		
		<!-- SUPPLIER -->
		<acme:menu-option code="master.menu.supplier" access="hasRole('Supplier')">
			<acme:menu-suboption code="master.menu.supplier.item.list" action="/supplier/item/list"/>
			<acme:menu-suboption code="master.menu.supplier.request.list" action="/supplier/request/list"/>
		</acme:menu-option>
		
		<!-- AUDITOR -->
		<acme:menu-option code="master.menu.auditor" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.auditor.list.have" action="/auditor/item/list-have"/>
			<acme:menu-suboption code="master.menu.auditor.list.not.have" action="/auditor/item/list-not-have"/>
		</acme:menu-option>
			
		<!-- BUYER -->
		<acme:menu-option code="master.menu.buyer" access="hasRole('Buyer')">
			<acme:menu-suboption code="master.menu.buyer.list.request" action="/buyer/request/list"/>
		</acme:menu-option>
		
		
		<!-- AUTHENTICATED -->
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.material.list" action="/authenticated/material/list"/>
			<acme:menu-suboption code="master.menu.authenticated.advertisement.list" action="/authenticated/advertisement/list"/>
			<acme:menu-suboption code="master.menu.authenticated.new.activate" action="/authenticated/new/list-active"/>
			<acme:menu-suboption code="master.menu.authenticated.toolsheet.list" action="/authenticated/toolsheet/list"/>
		    <acme:menu-separator/>
      		<acme:menu-suboption code="master.menu.authenticated.item.list" action="/authenticated/item/list"/>
      		<acme:menu-suboption code="master.menu.authenticated.suggestion.list" action="/authenticated/suggestion/list"/>
			<acme:menu-suboption code="master.menu.authenticated.figment.list" action="/authenticated/figment/list"/>
			<acme:menu-separator/>
      		<acme:menu-suboption code="master.menu.authenticated.forum.list" action="/authenticated/forum/list"/>
		</acme:menu-option>

		<!-- PROVIDER -->
		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<!-- CONSUMER -->
		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

