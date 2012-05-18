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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="org.gnenc.liferay.portlet.DLUsageReports" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>

<portlet:defineObjects />

This is the <b>Document Library Usage Reports</b> portlet.

<%
ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//long size = DLUsageReports.totalSizeByCompanyId(themeDisplay.getCompanyId());
Map<User,Long> reportMap = DLUsageReports.getUsageForUsersByUserGroup(15204);
Iterator i = reportMap.entrySet().iterator();
while (i.hasNext()) {
	Map.Entry<User,Long> entry = (Map.Entry<User,Long>)i.next();
	%><%=entry.getKey().getFullName()%> is using <%=entry.getValue() %> bytes <%
}
%>