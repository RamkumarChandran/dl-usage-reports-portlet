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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gnenc.dlusagereports.NoSuchAllocatedStorageException;
import org.gnenc.dlusagereports.model.AllocatedStorage;
import org.gnenc.dlusagereports.model.impl.AllocatedStorageImpl;
import org.gnenc.dlusagereports.model.impl.AllocatedStorageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the AllocatedStorage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew A. Blessing
 * @see AllocatedStoragePersistence
 * @see AllocatedStorageUtil
 * @generated
 */
public class AllocatedStoragePersistenceImpl extends BasePersistenceImpl<AllocatedStorage>
	implements AllocatedStoragePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AllocatedStorageUtil} to access the AllocatedStorage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AllocatedStorageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
			AllocatedStorageModelImpl.FINDER_CACHE_ENABLED,
			AllocatedStorageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
			AllocatedStorageModelImpl.FINDER_CACHE_ENABLED,
			AllocatedStorageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
			AllocatedStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the AllocatedStorage in the entity cache if it is enabled.
	 *
	 * @param allocatedStorage the AllocatedStorage
	 */
	public void cacheResult(AllocatedStorage allocatedStorage) {
		EntityCacheUtil.putResult(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
			AllocatedStorageImpl.class, allocatedStorage.getPrimaryKey(),
			allocatedStorage);

		allocatedStorage.resetOriginalValues();
	}

	/**
	 * Caches the AllocatedStorages in the entity cache if it is enabled.
	 *
	 * @param allocatedStorages the AllocatedStorages
	 */
	public void cacheResult(List<AllocatedStorage> allocatedStorages) {
		for (AllocatedStorage allocatedStorage : allocatedStorages) {
			if (EntityCacheUtil.getResult(
						AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
						AllocatedStorageImpl.class,
						allocatedStorage.getPrimaryKey()) == null) {
				cacheResult(allocatedStorage);
			}
			else {
				allocatedStorage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all AllocatedStorages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AllocatedStorageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AllocatedStorageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the AllocatedStorage.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllocatedStorage allocatedStorage) {
		EntityCacheUtil.removeResult(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
			AllocatedStorageImpl.class, allocatedStorage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AllocatedStorage> allocatedStorages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AllocatedStorage allocatedStorage : allocatedStorages) {
			EntityCacheUtil.removeResult(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
				AllocatedStorageImpl.class, allocatedStorage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new AllocatedStorage with the primary key. Does not add the AllocatedStorage to the database.
	 *
	 * @param id the primary key for the new AllocatedStorage
	 * @return the new AllocatedStorage
	 */
	public AllocatedStorage create(long id) {
		AllocatedStorage allocatedStorage = new AllocatedStorageImpl();

		allocatedStorage.setNew(true);
		allocatedStorage.setPrimaryKey(id);

		return allocatedStorage;
	}

	/**
	 * Removes the AllocatedStorage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the AllocatedStorage
	 * @return the AllocatedStorage that was removed
	 * @throws org.gnenc.dlusagereports.NoSuchAllocatedStorageException if a AllocatedStorage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AllocatedStorage remove(long id)
		throws NoSuchAllocatedStorageException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the AllocatedStorage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the AllocatedStorage
	 * @return the AllocatedStorage that was removed
	 * @throws org.gnenc.dlusagereports.NoSuchAllocatedStorageException if a AllocatedStorage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AllocatedStorage remove(Serializable primaryKey)
		throws NoSuchAllocatedStorageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AllocatedStorage allocatedStorage = (AllocatedStorage)session.get(AllocatedStorageImpl.class,
					primaryKey);

			if (allocatedStorage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllocatedStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(allocatedStorage);
		}
		catch (NoSuchAllocatedStorageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AllocatedStorage removeImpl(AllocatedStorage allocatedStorage)
		throws SystemException {
		allocatedStorage = toUnwrappedModel(allocatedStorage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, allocatedStorage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(allocatedStorage);

		return allocatedStorage;
	}

	@Override
	public AllocatedStorage updateImpl(
		org.gnenc.dlusagereports.model.AllocatedStorage allocatedStorage,
		boolean merge) throws SystemException {
		allocatedStorage = toUnwrappedModel(allocatedStorage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, allocatedStorage, merge);

			allocatedStorage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
			AllocatedStorageImpl.class, allocatedStorage.getPrimaryKey(),
			allocatedStorage);

		return allocatedStorage;
	}

	protected AllocatedStorage toUnwrappedModel(
		AllocatedStorage allocatedStorage) {
		if (allocatedStorage instanceof AllocatedStorageImpl) {
			return allocatedStorage;
		}

		AllocatedStorageImpl allocatedStorageImpl = new AllocatedStorageImpl();

		allocatedStorageImpl.setNew(allocatedStorage.isNew());
		allocatedStorageImpl.setPrimaryKey(allocatedStorage.getPrimaryKey());

		allocatedStorageImpl.setId(allocatedStorage.getId());
		allocatedStorageImpl.setTotalBytes(allocatedStorage.getTotalBytes());
		allocatedStorageImpl.setModifiedUserId(allocatedStorage.getModifiedUserId());
		allocatedStorageImpl.setModifiedDate(allocatedStorage.getModifiedDate());

		return allocatedStorageImpl;
	}

	/**
	 * Returns the AllocatedStorage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the AllocatedStorage
	 * @return the AllocatedStorage
	 * @throws com.liferay.portal.NoSuchModelException if a AllocatedStorage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AllocatedStorage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the AllocatedStorage with the primary key or throws a {@link org.gnenc.dlusagereports.NoSuchAllocatedStorageException} if it could not be found.
	 *
	 * @param id the primary key of the AllocatedStorage
	 * @return the AllocatedStorage
	 * @throws org.gnenc.dlusagereports.NoSuchAllocatedStorageException if a AllocatedStorage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AllocatedStorage findByPrimaryKey(long id)
		throws NoSuchAllocatedStorageException, SystemException {
		AllocatedStorage allocatedStorage = fetchByPrimaryKey(id);

		if (allocatedStorage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchAllocatedStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return allocatedStorage;
	}

	/**
	 * Returns the AllocatedStorage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the AllocatedStorage
	 * @return the AllocatedStorage, or <code>null</code> if a AllocatedStorage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AllocatedStorage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the AllocatedStorage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the AllocatedStorage
	 * @return the AllocatedStorage, or <code>null</code> if a AllocatedStorage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AllocatedStorage fetchByPrimaryKey(long id)
		throws SystemException {
		AllocatedStorage allocatedStorage = (AllocatedStorage)EntityCacheUtil.getResult(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
				AllocatedStorageImpl.class, id);

		if (allocatedStorage == _nullAllocatedStorage) {
			return null;
		}

		if (allocatedStorage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				allocatedStorage = (AllocatedStorage)session.get(AllocatedStorageImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (allocatedStorage != null) {
					cacheResult(allocatedStorage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AllocatedStorageModelImpl.ENTITY_CACHE_ENABLED,
						AllocatedStorageImpl.class, id, _nullAllocatedStorage);
				}

				closeSession(session);
			}
		}

		return allocatedStorage;
	}

	/**
	 * Returns all the AllocatedStorages.
	 *
	 * @return the AllocatedStorages
	 * @throws SystemException if a system exception occurred
	 */
	public List<AllocatedStorage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<AllocatedStorage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<AllocatedStorage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AllocatedStorage> list = (List<AllocatedStorage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ALLOCATEDSTORAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALLOCATEDSTORAGE.concat(AllocatedStorageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AllocatedStorage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AllocatedStorage>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the AllocatedStorages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AllocatedStorage allocatedStorage : findAll()) {
			remove(allocatedStorage);
		}
	}

	/**
	 * Returns the number of AllocatedStorages.
	 *
	 * @return the number of AllocatedStorages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALLOCATEDSTORAGE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the AllocatedStorage persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gnenc.dlusagereports.model.AllocatedStorage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AllocatedStorage>> listenersList = new ArrayList<ModelListener<AllocatedStorage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AllocatedStorage>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AllocatedStorageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AllocatedStoragePersistence.class)
	protected AllocatedStoragePersistence allocatedStoragePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ALLOCATEDSTORAGE = "SELECT allocatedStorage FROM AllocatedStorage allocatedStorage";
	private static final String _SQL_COUNT_ALLOCATEDSTORAGE = "SELECT COUNT(allocatedStorage) FROM AllocatedStorage allocatedStorage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "allocatedStorage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AllocatedStorage exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AllocatedStoragePersistenceImpl.class);
	private static AllocatedStorage _nullAllocatedStorage = new AllocatedStorageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AllocatedStorage> toCacheModel() {
				return _nullAllocatedStorageCacheModel;
			}
		};

	private static CacheModel<AllocatedStorage> _nullAllocatedStorageCacheModel = new CacheModel<AllocatedStorage>() {
			public AllocatedStorage toEntityModel() {
				return _nullAllocatedStorage;
			}
		};
}