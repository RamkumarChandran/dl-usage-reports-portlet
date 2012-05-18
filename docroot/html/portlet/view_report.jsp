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
long userGroupId = ParamUtil.getLong(request, "userGroupId");
String userGroupName = UserGroupLocalServiceUtil.getUserGroup(userGroupId).getName();
String backURL = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header backURL="<%= backURL %>" title="<%= userGroupName %>" />

<liferay-ui:search-container emptyResultsMessage="no-users-were-found" delta="25">
   	<liferay-ui:search-container-results>
   	<%
	   	List<DLUser> tempResults = DLUsageReports.getUsageForUsersByUserGroup(userGroupId);
	   	Collections.sort(tempResults, Collections.reverseOrder());
	   	
	    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
	    total = tempResults.size();

	    pageContext.setAttribute("results", results);
	    pageContext.setAttribute("total", total);
    %>
   	</liferay-ui:search-container-results>

   	<liferay-ui:search-container-row
   		className="org.gnenc.liferay.model.DLUser"
   		keyProperty="usage"
   		modelVar="user">

	    <liferay-ui:search-container-column-text
	        name="name"
	        property="name"
	        />

	    <liferay-ui:search-container-column-text
	        name="usage"
	        value="<%=user.getHumanReadableUsage() %>"
	        />

      </liferay-ui:search-container-row>

      <liferay-ui:search-iterator />

</liferay-ui:search-container>

