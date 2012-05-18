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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.gnenc.dlusagereports.service.AllocatedStorageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Drew A. Blessing
 */
public class AllocatedStorageClp extends BaseModelImpl<AllocatedStorage>
	implements AllocatedStorage {
	public AllocatedStorageClp() {
	}

	public Class<?> getModelClass() {
		return AllocatedStorage.class;
	}

	public String getModelClassName() {
		return AllocatedStorage.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getTotalBytes() {
		return _totalBytes;
	}

	public void setTotalBytes(long totalBytes) {
		_totalBytes = totalBytes;
	}

	public long getModifiedUserId() {
		return _ModifiedUserId;
	}

	public void setModifiedUserId(long ModifiedUserId) {
		_ModifiedUserId = ModifiedUserId;
	}

	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_ModifiedUserUuid);
	}

	public void setModifiedUserUuid(String ModifiedUserUuid) {
		_ModifiedUserUuid = ModifiedUserUuid;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAllocatedStorage() {
		throw new UnsupportedOperationException();
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AllocatedStorageLocalServiceUtil.addAllocatedStorage(this);
		}
		else {
			AllocatedStorageLocalServiceUtil.updateAllocatedStorage(this);
		}
	}

	@Override
	public AllocatedStorage toEscapedModel() {
		return (AllocatedStorage)Proxy.newProxyInstance(AllocatedStorage.class.getClassLoader(),
			new Class[] { AllocatedStorage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AllocatedStorageClp clone = new AllocatedStorageClp();

		clone.setId(getId());
		clone.setTotalBytes(getTotalBytes());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(AllocatedStorage allocatedStorage) {
		int value = 0;

		if (getId() < allocatedStorage.getId()) {
			value = -1;
		}
		else if (getId() > allocatedStorage.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AllocatedStorageClp allocatedStorage = null;

		try {
			allocatedStorage = (AllocatedStorageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = allocatedStorage.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", totalBytes=");
		sb.append(getTotalBytes());
		sb.append(", ModifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gnenc.dlusagereports.model.AllocatedStorage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalBytes</column-name><column-value><![CDATA[");
		sb.append(getTotalBytes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _totalBytes;
	private long _ModifiedUserId;
	private String _ModifiedUserUuid;
	private Date _modifiedDate;
}