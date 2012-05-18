package org.gnenc.liferay.portlet;

import java.util.ArrayList;
import java.util.List;

import org.gnenc.liferay.model.DLUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DLUsageReports extends MVCPortlet {
	public static List<DLUser> getUsageForUsersByUserGroup(long userGroupId) throws SystemException, PortalException {
		List<DLUser> usage = new ArrayList<DLUser>();
		List<User> users = UserLocalServiceUtil.getUserGroupUsers(userGroupId);
		for (User user : users) {
			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(DLFileEntry.class,
							PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("userId").eq(new Long(user.getUserId())))
					.add(PropertyFactoryUtil.forName("groupId").eq(new Long(user.getGroupId())))
					.setProjection(ProjectionFactoryUtil.sum("size"));
			long totalSize = totalSize(query);
			usage.add(new DLUser(totalSize, user.getFullName()));
		}
		
		return usage;
	}
	
	public static long getTotalUsageByUserGroupId(long companyId) throws SystemException {

		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DLFileEntry.class,
						PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("companyId").eq(new Long(companyId)))
				.setProjection(ProjectionFactoryUtil.sum("size"));
		long totalSize = totalSize(query);
		if (_log.isDebugEnabled())
			_log.debug("totalSizeByCompanyId for companyId " + companyId + " = "
					+ totalSize);
		return totalSize;
	}

	public static long totalSizeByCompanyIdAndGroupId(long companyId, long groupId)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DLFileEntry.class,
						PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("companyId").eq(new Long(companyId)))
				.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)))
				.setProjection(ProjectionFactoryUtil.sum("size"));
		long totalSize = totalSize(query);
		if (_log.isDebugEnabled())
			_log.debug("totalSizeByCompanyIdAndGroupId for companyId " + companyId + " and groupId " + groupId + " = "
					+ totalSize);
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
	
	private static Log _log = LogFactoryUtil.getLog(DLUsageReports.class);
}
