<%/**
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
 */%>

<%@ include file="/html/init.jsp" %>

<%
long userGroupId = ParamUtil.getLong(request, "userGroupId");
String userGroupName = UserGroupLocalServiceUtil.getUserGroup(userGroupId).getName();
String backURL = ParamUtil.getString(request, "redirect");

List<DLUser> dlUsers = DLUsageReports.getUsageForUsersByUserGroup(userGroupId);
long totalSize = DLUsageReports.getTotalUserUsageByDLUserList(dlUsers);
String userGroupTotalHumanReadableSize = DLUsageReportsUtil.convertToHumanReadableSize(totalSize);
String percentTotalUsed = DLUsageReports.getPercentTotalUsedByGroupIdAndSize(userGroupId, totalSize);
%>

<liferay-ui:header backURL="<%=backURL%>" title="<%=userGroupName%>" />

<div class="aui-layout" >
	<div class="aui-column aui-w33">
		<h3><liferay-ui:message key="total-usage"></liferay-ui:message></h3>
		<p><%=userGroupTotalHumanReadableSize%></p>
	</div>
	<div class="aui-column aui-w33">
		<h3><liferay-ui:message key="total-allocated"></liferay-ui:message></h3>
		<p>100 GB</p>
	</div>
	<div class="aui-column aui-w33">
		<h3><liferay-ui:message key="percent-total-used"></liferay-ui:message></h3>
		<p><%=percentTotalUsed%></p>
	</div>
</div>
	
<div class="view-report-search-container">
	<liferay-ui:search-container emptyResultsMessage="no-users-were-found" delta="25">
	   	<liferay-ui:search-container-results>
	   	<%
	   		Collections.sort(dlUsers, Collections.reverseOrder());
	   			   	
	   			    results = ListUtil.subList(dlUsers, searchContainer.getStart(), searchContainer.getEnd());
	   			    total = dlUsers.size();
	   		
	   			    pageContext.setAttribute("results", results);
	   			    pageContext.setAttribute("total", total);
	   	%>
	   	</liferay-ui:search-container-results>
	
	   	<liferay-ui:search-container-row
	   		className="org.gnenc.dlusagereports.model.DLUser"
	   		keyProperty="usage"
	   		modelVar="dlUser">
	
		    <liferay-ui:search-container-column-text
		        name="name"
		        property="name"
		        />
	
		    <liferay-ui:search-container-column-text
		        name="usage"
		        value="<%=DLUsageReportsUtil.convertToHumanReadableSize(dlUser.getUsage()) %>"
		        />
	
	      </liferay-ui:search-container-row>
	
	      <liferay-ui:search-iterator />
	
	</liferay-ui:search-container>
</div>
