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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Drew A. Blessing
 * @generated
 */
public class AllocatedStorageSoap implements Serializable {
	public static AllocatedStorageSoap toSoapModel(AllocatedStorage model) {
		AllocatedStorageSoap soapModel = new AllocatedStorageSoap();

		soapModel.setId(model.getId());
		soapModel.setTotalBytes(model.getTotalBytes());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AllocatedStorageSoap[] toSoapModels(AllocatedStorage[] models) {
		AllocatedStorageSoap[] soapModels = new AllocatedStorageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AllocatedStorageSoap[][] toSoapModels(
		AllocatedStorage[][] models) {
		AllocatedStorageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AllocatedStorageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AllocatedStorageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AllocatedStorageSoap[] toSoapModels(
		List<AllocatedStorage> models) {
		List<AllocatedStorageSoap> soapModels = new ArrayList<AllocatedStorageSoap>(models.size());

		for (AllocatedStorage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AllocatedStorageSoap[soapModels.size()]);
	}

	public AllocatedStorageSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _id;
	private long _totalBytes;
	private long _ModifiedUserId;
	private Date _modifiedDate;
}