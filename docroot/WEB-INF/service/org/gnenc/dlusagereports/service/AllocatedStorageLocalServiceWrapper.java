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

package org.gnenc.dlusagereports.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AllocatedStorageLocalService}.
 * </p>
 *
 * @author    Drew A. Blessing
 * @see       AllocatedStorageLocalService
 * @generated
 */
public class AllocatedStorageLocalServiceWrapper
	implements AllocatedStorageLocalService,
		ServiceWrapper<AllocatedStorageLocalService> {
	public AllocatedStorageLocalServiceWrapper(
		AllocatedStorageLocalService allocatedStorageLocalService) {
		_allocatedStorageLocalService = allocatedStorageLocalService;
	}

	/**
	* Adds the AllocatedStorage to the database. Also notifies the appropriate model listeners.
	*
	* @param allocatedStorage the AllocatedStorage
	* @return the AllocatedStorage that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.dlusagereports.model.AllocatedStorage addAllocatedStorage(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.addAllocatedStorage(allocatedStorage);
	}

	/**
	* Creates a new AllocatedStorage with the primary key. Does not add the AllocatedStorage to the database.
	*
	* @param id the primary key for the new AllocatedStorage
	* @return the new AllocatedStorage
	*/
	public org.gnenc.dlusagereports.model.AllocatedStorage createAllocatedStorage(
		long id) {
		return _allocatedStorageLocalService.createAllocatedStorage(id);
	}

	/**
	* Deletes the AllocatedStorage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the AllocatedStorage
	* @throws PortalException if a AllocatedStorage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAllocatedStorage(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_allocatedStorageLocalService.deleteAllocatedStorage(id);
	}

	/**
	* Deletes the AllocatedStorage from the database. Also notifies the appropriate model listeners.
	*
	* @param allocatedStorage the AllocatedStorage
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAllocatedStorage(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		_allocatedStorageLocalService.deleteAllocatedStorage(allocatedStorage);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.gnenc.dlusagereports.model.AllocatedStorage fetchAllocatedStorage(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.fetchAllocatedStorage(id);
	}

	/**
	* Returns the AllocatedStorage with the primary key.
	*
	* @param id the primary key of the AllocatedStorage
	* @return the AllocatedStorage
	* @throws PortalException if a AllocatedStorage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.dlusagereports.model.AllocatedStorage getAllocatedStorage(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.getAllocatedStorage(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the AllocatedStorages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of AllocatedStorages
	* @param end the upper bound of the range of AllocatedStorages (not inclusive)
	* @return the range of AllocatedStorages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.dlusagereports.model.AllocatedStorage> getAllocatedStorages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.getAllocatedStorages(start, end);
	}

	/**
	* Returns the number of AllocatedStorages.
	*
	* @return the number of AllocatedStorages
	* @throws SystemException if a system exception occurred
	*/
	public int getAllocatedStoragesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.getAllocatedStoragesCount();
	}

	/**
	* Updates the AllocatedStorage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param allocatedStorage the AllocatedStorage
	* @return the AllocatedStorage that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.dlusagereports.model.AllocatedStorage updateAllocatedStorage(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.updateAllocatedStorage(allocatedStorage);
	}

	/**
	* Updates the AllocatedStorage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param allocatedStorage the AllocatedStorage
	* @param merge whether to merge the AllocatedStorage with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the AllocatedStorage that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.dlusagereports.model.AllocatedStorage updateAllocatedStorage(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorageLocalService.updateAllocatedStorage(allocatedStorage,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _allocatedStorageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_allocatedStorageLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AllocatedStorageLocalService getWrappedAllocatedStorageLocalService() {
		return _allocatedStorageLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAllocatedStorageLocalService(
		AllocatedStorageLocalService allocatedStorageLocalService) {
		_allocatedStorageLocalService = allocatedStorageLocalService;
	}

	public AllocatedStorageLocalService getWrappedService() {
		return _allocatedStorageLocalService;
	}

	public void setWrappedService(
		AllocatedStorageLocalService allocatedStorageLocalService) {
		_allocatedStorageLocalService = allocatedStorageLocalService;
	}

	private AllocatedStorageLocalService _allocatedStorageLocalService;
}