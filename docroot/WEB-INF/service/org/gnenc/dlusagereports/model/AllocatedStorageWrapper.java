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

package org.gnenc.dlusagereports.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AllocatedStorage}.
 * </p>
 *
 * @author    Drew A. Blessing
 * @see       AllocatedStorage
 * @generated
 */
public class AllocatedStorageWrapper implements AllocatedStorage,
	ModelWrapper<AllocatedStorage> {
	public AllocatedStorageWrapper(AllocatedStorage allocatedStorage) {
		_allocatedStorage = allocatedStorage;
	}

	public Class<?> getModelClass() {
		return AllocatedStorage.class;
	}

	public String getModelClassName() {
		return AllocatedStorage.class.getName();
	}

	/**
	* Returns the primary key of this AllocatedStorage.
	*
	* @return the primary key of this AllocatedStorage
	*/
	public long getPrimaryKey() {
		return _allocatedStorage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this AllocatedStorage.
	*
	* @param primaryKey the primary key of this AllocatedStorage
	*/
	public void setPrimaryKey(long primaryKey) {
		_allocatedStorage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this AllocatedStorage.
	*
	* @return the ID of this AllocatedStorage
	*/
	public long getId() {
		return _allocatedStorage.getId();
	}

	/**
	* Sets the ID of this AllocatedStorage.
	*
	* @param id the ID of this AllocatedStorage
	*/
	public void setId(long id) {
		_allocatedStorage.setId(id);
	}

	/**
	* Returns the total bytes of this AllocatedStorage.
	*
	* @return the total bytes of this AllocatedStorage
	*/
	public long getTotalBytes() {
		return _allocatedStorage.getTotalBytes();
	}

	/**
	* Sets the total bytes of this AllocatedStorage.
	*
	* @param totalBytes the total bytes of this AllocatedStorage
	*/
	public void setTotalBytes(long totalBytes) {
		_allocatedStorage.setTotalBytes(totalBytes);
	}

	/**
	* Returns the modified user ID of this AllocatedStorage.
	*
	* @return the modified user ID of this AllocatedStorage
	*/
	public long getModifiedUserId() {
		return _allocatedStorage.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this AllocatedStorage.
	*
	* @param ModifiedUserId the modified user ID of this AllocatedStorage
	*/
	public void setModifiedUserId(long ModifiedUserId) {
		_allocatedStorage.setModifiedUserId(ModifiedUserId);
	}

	/**
	* Returns the modified user uuid of this AllocatedStorage.
	*
	* @return the modified user uuid of this AllocatedStorage
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _allocatedStorage.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this AllocatedStorage.
	*
	* @param ModifiedUserUuid the modified user uuid of this AllocatedStorage
	*/
	public void setModifiedUserUuid(java.lang.String ModifiedUserUuid) {
		_allocatedStorage.setModifiedUserUuid(ModifiedUserUuid);
	}

	/**
	* Returns the modified date of this AllocatedStorage.
	*
	* @return the modified date of this AllocatedStorage
	*/
	public java.util.Date getModifiedDate() {
		return _allocatedStorage.getModifiedDate();
	}

	/**
	* Sets the modified date of this AllocatedStorage.
	*
	* @param modifiedDate the modified date of this AllocatedStorage
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_allocatedStorage.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _allocatedStorage.isNew();
	}

	public void setNew(boolean n) {
		_allocatedStorage.setNew(n);
	}

	public boolean isCachedModel() {
		return _allocatedStorage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_allocatedStorage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _allocatedStorage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _allocatedStorage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_allocatedStorage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _allocatedStorage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_allocatedStorage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AllocatedStorageWrapper((AllocatedStorage)_allocatedStorage.clone());
	}

	public int compareTo(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage) {
		return _allocatedStorage.compareTo(allocatedStorage);
	}

	@Override
	public int hashCode() {
		return _allocatedStorage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.gnenc.dlusagereports.model.AllocatedStorage> toCacheModel() {
		return _allocatedStorage.toCacheModel();
	}

	public org.gnenc.dlusagereports.model.AllocatedStorage toEscapedModel() {
		return new AllocatedStorageWrapper(_allocatedStorage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _allocatedStorage.toString();
	}

	public java.lang.String toXmlString() {
		return _allocatedStorage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_allocatedStorage.persist();
	}

	public long getAllocatedStorage() {
		return _allocatedStorage.getAllocatedStorage();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AllocatedStorage getWrappedAllocatedStorage() {
		return _allocatedStorage;
	}

	public AllocatedStorage getWrappedModel() {
		return _allocatedStorage;
	}

	public void resetOriginalValues() {
		_allocatedStorage.resetOriginalValues();
	}

	private AllocatedStorage _allocatedStorage;
}