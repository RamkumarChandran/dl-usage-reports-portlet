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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the AllocatedStorage service. Represents a row in the &quot;DLUsage_AllocatedStorage&quot; database table, with each column mapped to a property of this class.
 *
 * @author Drew A. Blessing
 * @see AllocatedStorageModel
 * @see org.gnenc.dlusagereports.model.impl.AllocatedStorageImpl
 * @see org.gnenc.dlusagereports.model.impl.AllocatedStorageModelImpl
 * @generated
 */
public interface AllocatedStorage extends AllocatedStorageModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.gnenc.dlusagereports.model.impl.AllocatedStorageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public long getAllocatedStorage();
}