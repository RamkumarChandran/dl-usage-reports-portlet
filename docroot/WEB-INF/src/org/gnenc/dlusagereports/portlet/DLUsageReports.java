package org.gnenc.dlusagereports.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.gnenc.dlusagereports.model.AllocatedStorage;
import org.gnenc.dlusagereports.model.DLUser;
import org.gnenc.dlusagereports.service.AllocatedStorageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DLUsageReports extends MVCPortlet {
	public static List<DLUser> getUsageForUsersByUserGroup(long userGroupId) 
			throws SystemException, PortalException {
		List<DLUser> dlUsers = new ArrayList<DLUser>();
		List<User> users = UserLocalServiceUtil.getUserGroupUsers(userGroupId);
		for (User user : users) {
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(DLFileEntry.class,
							PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("userId").eq(
							new Long(user.getUserId())))
					.add(PropertyFactoryUtil.forName("groupId").eq(
							new Long(user.getGroupId())))
					.setProjection(ProjectionFactoryUtil.sum("size"));
			long totalSize = totalSize(query);
			dlUsers.add(new DLUser(totalSize, user.getFullName()));
		}
		
		return dlUsers;
	}
	
	public static long getTotalUserUsageByUserGroupId(long userGroupId) 
			throws SystemException, PortalException {
		List<DLUser> dlUsers = getUsageForUsersByUserGroup(userGroupId);
		
		return getSumOfDLUserList(dlUsers);
	}
	
	public static long getTotalUserUsageByDLUserList(List<DLUser> dlUsers) {
		return getSumOfDLUserList(dlUsers);
	}
	
	public static String getPercentTotalUsedByGroupIdAndSize(long groupId, long size) {
		return "1%";
	}
	
	public static void editAllocatedStorage(ActionRequest request, ActionResponse response) 
			throws SystemException {
		long userGroupId = ParamUtil.getLong(request, "userGroupId");

		if (Validator.isNotNull(userGroupId)) {
			AllocatedStorage allocatedStorage = AllocatedStorageLocalServiceUtil
					.fetchAllocatedStorage(userGroupId);
			request.setAttribute("allocated_storage", allocatedStorage);
			response.setRenderParameter("jspPage", editAllocatedStorageJSP);

		}
	}
	
	public static void updateAllocatedStorage(ActionRequest request, ActionResponse response) {
		
	}

	private static long getSumOfDLUserList(List<DLUser> dlUsers) {
		long totalSize = 0;
		
		for (DLUser dlUser : dlUsers) {
			totalSize += dlUser.getUsage();
		}
		
		return totalSize;
	}

	private static long totalSize(DynamicQuery query) throws SystemException {
		@SuppressWarnings("unchecked")
		List<Object> result = DLFileEntryLocalServiceUtil.dynamicQuery(query);
		if(result != null && result.size() > 0 && result.get(0) != null) {
			return (Long) result.get(0);
		} else {
			return 0;
		}
	}
	
	private static String editAllocatedStorageJSP = "/html/portlet/user_groups/edit_user_group.jsp";
}
