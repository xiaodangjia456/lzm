package com.source.root.framework.template.service;

import java.io.Serializable;
import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;

/**
 * @ClassName: BaseServiceImpl
 * @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)
 * @author MR.Guo xiaodangjia456@163.com
 * @date 2014骞�鏈�2鏃�涓嬪崍2:41:42
 * 
 * @param <E>
 * @param <PK>
 */
@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<E, PK extends Serializable> implements
		IBaseService<E, PK> {

	/**
	 * @Title: getBaseDao
	 * @Description: TODO
	 * @return: IBaseDao
	 */
	@SuppressWarnings("rawtypes")
	protected abstract IBaseDao getBaseDao();

	/**
	 * 鏍规嵁鏈�ぇId 鏌ヨ
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#getById(java.io.Serializable)
	 */
	public E getByMaxId() {
		return (E) getBaseDao().getByMaxId();
	}

	/**
	 * 鏍规嵁Id 鏌ヨ
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#getById(java.io.Serializable)
	 */
	public E getById(PK id) {
		return (E) getBaseDao().getById(id);
	}

	/**
	 * 鏍规嵁鍏朵粬鏉′欢鏌ヨ
	 * <p>
	 * Title: getByQuery
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#getById(java.io.Serializable)
	 */
	public E getByQuery(Query query) {
		return (E) getBaseDao().getByQuery(query);
	}

	/**
	 * 鏍规嵁id 鍒犻櫎
	 * <p>
	 * Title: deleteById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @see com.ams.source.framework.template.service.IBaseService#deleteById(java.io.Serializable)
	 */
	public boolean deleteById(PK id) {
		return getBaseDao().deleteById(id);
	}

	/**
	 * 鏍规嵁鍏朵粬鏉′欢鍒犻櫎
	 * <p>
	 * Title: deleteById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @see com.ams.source.framework.template.service.IBaseService#deleteById(java.io.Serializable)
	 */
	public boolean deleteByQuery(Query query) {
		return getBaseDao().deleteByQuery(query);
	}

	/**
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param entity
	 * @see com.ams.source.framework.template.service.IBaseService#save(java.lang.Object)
	 */
	public boolean save(E entity) {
		return getBaseDao().save(entity);
	}

	/**
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param entity
	 * @see com.ams.source.framework.template.service.IBaseService#save(java.lang.Object)
	 */
	public boolean saveNotNull(E entity) {
		return getBaseDao().saveNotNull(entity);
	}

	/**
	 * 鍏ㄩ儴淇敼
	 * <p>
	 * Title: update
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param entity
	 * @see com.ams.source.framework.template.service.IBaseService#update(java.lang.Object)
	 */
	public boolean update(E entity) {
		return getBaseDao().update(entity);
	}

	/**
	 * 鏍规嵁id 淇敼鏌愪簺瀛楁
	 * <p>
	 * Title: updateById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param entity
	 * @see com.ams.source.framework.template.service.IBaseService#update(java.lang.Object)
	 */
	public boolean updateById(E entity) {
		return getBaseDao().updateById(entity);
	}

	/**
	 * 鍏ㄩ儴鏌ヨ
	 * <p>
	 * Title: findAll
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#findAll()
	 */
	public List<E> findAll(Query query) {
		return getBaseDao().findAll(query);
	}

	/**
	 * 甯︽潯浠�鍒嗛〉
	 * <p>
	 * Title: findPage
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#findAll()
	 */
	public List<E> findPage(Query query) {
		return getBaseDao().findPage(query);
	}

	/**
	 * 甯︽潯浠舵煡璇㈡�涓暟
	 * <p>
	 * Title: getCount
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#getCount()
	 */
	public int getCountByQuery(Query query) {
		return getBaseDao().getCountByQuery(query);
	}

	/**
	 * 鏄惁瀛樺湪
	 * <p>
	 * Title: isExist
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @see com.ams.source.framework.template.service.IBaseService#isExist(java.lang.String,
	 *      java.lang.Object)
	 */
	public boolean isExist(Query query) {
		return getBaseDao().isExist(query);
	}

}
