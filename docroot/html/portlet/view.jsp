<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ include file="/html/init.jsp" %>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
long companyId = PortalUtil.getCompanyId(request);
List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserGroups(companyId);		 
%>

<liferay-ui:search-container emptyResultsMessage="no-user-groups-were-found" delta="5">
   	<liferay-ui:search-container-results>
   	<%
	    results = ListUtil.subList(userGroups, searchContainer.getStart(), searchContainer.getEnd());
	    total = userGroups.size();

	    pageContext.setAttribute("results", results);
	    pageContext.setAttribute("total", total);
    %>
   	</liferay-ui:search-container-results>

   	<liferay-ui:search-container-row
   		className="com.liferay.portal.model.UserGroup"
   		keyProperty="userGroupId"
   		modelVar="userGroup">

	   <portlet:renderURL var="rowURL">
			<portlet:param name="redirect" value="<%= searchContainer.getIteratorURL().toString() %>" />
			<portlet:param name="userGroupId" value="<%= String.valueOf(userGroup.getUserGroupId()) %>" />
			<portlet:param name="jspPage" value="/html/portlet/view_report.jsp" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="name"
			property="name"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="description"
			property="description"
		/>
		
		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="usage"
			value="<%=DLUsageReportsUtil.convertToHumanReadableSize(
					DLUsageReports.getTotalUserUsageByUserGroupId(userGroup.getUserGroupId())) %>"
		/>
		
		<liferay-ui:search-container-column-jsp
        		path="/html/portlet/user_groups/admin_actions.jsp"
        		align="right"
	    />

      </liferay-ui:search-container-row>

      <liferay-ui:search-iterator />

</liferay-ui:search-container>