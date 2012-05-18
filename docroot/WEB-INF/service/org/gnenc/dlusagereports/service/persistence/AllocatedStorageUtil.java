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

package org.gnenc.dlusagereports.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gnenc.dlusagereports.model.AllocatedStorage;

import java.util.List;

/**
 * The persistence utility for the AllocatedStorage service. This utility wraps {@link AllocatedStoragePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew A. Blessing
 * @see AllocatedStoragePersistence
 * @see AllocatedStoragePersistenceImpl
 * @generated
 */
public class AllocatedStorageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AllocatedStorage allocatedStorage) {
		getPersistence().clearCache(allocatedStorage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AllocatedStorage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AllocatedStorage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AllocatedStorage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AllocatedStorage update(AllocatedStorage allocatedStorage,
		boolean merge) throws SystemException {
		return getPersistence().update(allocatedStorage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AllocatedStorage update(AllocatedStorage allocatedStorage,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(allocatedStorage, merge, serviceContext);
	}

	/**
	* Caches the AllocatedStorage in the entity cache if it is enabled.
	*
	* @param allocatedStorage the AllocatedStorage
	*/
	public static void cacheResult(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage) {
		getPersistence().cacheResult(allocatedStorage);
	}

	/**
	* Caches the AllocatedStorages in the entity cache if it is enabled.
	*
	* @param allocatedStorages the AllocatedStorages
	*/
	public static void cacheResult(
		java.util.List<org.gnenc.dlusagereports.model.AllocatedStorage> allocatedStorages) {
		getPersistence().cacheResult(allocatedStorages);
	}

	/**
	* Creates a new AllocatedStorage with the primary key. Does not add the AllocatedStorage to the database.
	*
	* @param id the primary key for the new AllocatedStorage
	* @return the new AllocatedStorage
	*/
	public static org.gnenc.dlusagereports.model.AllocatedStorage create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the AllocatedStorage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the AllocatedStorage
	* @return the AllocatedStorage that was removed
	* @throws org.gnenc.dlusagereports.NoSuchAllocatedStorageException if a AllocatedStorage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.dlusagereports.model.AllocatedStorage remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.dlusagereports.NoSuchAllocatedStorageException {
		return getPersistence().remove(id);
	}

	public static org.gnenc.dlusagereports.model.AllocatedStorage updateImpl(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(allocatedStorage, merge);
	}

	/**
	* Returns the AllocatedStorage with the primary key or throws a {@link org.gnenc.dlusagereports.NoSuchAllocatedStorageException} if it could not be found.
	*
	* @param id the primary key of the AllocatedStorage
	* @return the AllocatedStorage
	* @throws org.gnenc.dlusagereports.NoSuchAllocatedStorageException if a AllocatedStorage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.dlusagereports.model.AllocatedStorage findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.dlusagereports.NoSuchAllocatedStorageException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the AllocatedStorage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the AllocatedStorage
	* @return the AllocatedStorage, or <code>null</code> if a AllocatedStorage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.dlusagereports.model.AllocatedStorage fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the AllocatedStorages.
	*
	* @return the AllocatedStorages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.dlusagereports.model.AllocatedStorage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gnenc.dlusagereports.model.AllocatedStorage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the AllocatedStorages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of AllocatedStorages
	* @param end the upper bound of the range of AllocatedStorages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of AllocatedStorages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.dlusagereports.model.AllocatedStorage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the AllocatedStorages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of AllocatedStorages.
	*
	* @return the number of AllocatedStorages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AllocatedStoragePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AllocatedStoragePersistence)PortletBeanLocatorUtil.locate(org.gnenc.dlusagereports.service.ClpSerializer.getServletContextName(),
					AllocatedStoragePersistence.class.getName());

			ReferenceRegistry.registerReference(AllocatedStorageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(AllocatedStoragePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(AllocatedStorageUtil.class,
			"_persistence");
	}

	private static AllocatedStoragePersistence _persistence;
}