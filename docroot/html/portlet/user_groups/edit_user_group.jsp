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
<%--<jsp:useBean id="allocated_storage" 
	type="org.gnenc.dlusagereports.model.AllocatedStorage" scope="request" 
	/> 
--%>

<%
AllocatedStorage storage = (AllocatedStorage)request.getAttribute("allocated_storage");
String backURL = ParamUtil.getString(request, "redirect");

if (storage == null) {
	storage = new AllocatedStorageImpl();

}
%>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/portlet/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updateAllocatedStorage" var="updateUrl" />

<liferay-ui:header backURL="<%=backURL%>" title="update-allocated-storage" />

<aui:form name="form" action="<%=updateUrl.toString() %>" method="post">
	<aui:input name="userGroupId" value="<%=storage.getId() %>" type="hidden" />
	<aui:input name="allocatedStorage" size="60"
			value="<%=storage.getAllocatedStorage() %>" />
			
	<aui:button-row>
					<aui:button type="submit" />
					<aui:button
      					type="cancel"
        				value="Cancel"
        				onClick="<%=cancelURL %>"
    				/>
				</aui:button-row>
</aui:form>
