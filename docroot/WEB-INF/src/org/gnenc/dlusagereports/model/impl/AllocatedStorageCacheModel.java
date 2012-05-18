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

package org.gnenc.dlusagereports.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.gnenc.dlusagereports.model.AllocatedStorage;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AllocatedStorage in entity cache.
 *
 * @author Drew A. Blessing
 * @see AllocatedStorage
 * @generated
 */
public class AllocatedStorageCacheModel implements CacheModel<AllocatedStorage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", totalBytes=");
		sb.append(totalBytes);
		sb.append(", ModifiedUserId=");
		sb.append(ModifiedUserId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public AllocatedStorage toEntityModel() {
		AllocatedStorageImpl allocatedStorageImpl = new AllocatedStorageImpl();

		allocatedStorageImpl.setId(id);
		allocatedStorageImpl.setTotalBytes(totalBytes);
		allocatedStorageImpl.setModifiedUserId(ModifiedUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			allocatedStorageImpl.setModifiedDate(null);
		}
		else {
			allocatedStorageImpl.setModifiedDate(new Date(modifiedDate));
		}

		allocatedStorageImpl.resetOriginalValues();

		return allocatedStorageImpl;
	}

	public long id;
	public long totalBytes;
	public long ModifiedUserId;
	public long modifiedDate;
}