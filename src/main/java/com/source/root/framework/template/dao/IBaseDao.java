package com.source.root.framework.template.dao;

import java.io.Serializable;
import java.util.List;

import com.source.root.framework.comm.pager.Query;

public interface IBaseDao<E, PK extends Serializable> {

	/**
	 * 鏍规嵁Id 鏌ヨ
	 * @Title: getByMaxId
	 * @Description: TODO
	 * @param id
	 * @return: E
	 */
	public E getByMaxId();
	
	/**
	 * 鏍规嵁Id 鏌ヨ
	 * @Title: getById
	 * @Description: TODO
	 * @param id
	 * @return: E
	 */
	public E getById(PK id);
	
	/**
	 * 鏍规嵁鍏朵粬鏉′欢鏌ヨ
	 * @Title: getByQuery
	 * @Description: TODO
	 * @param id
	 * @return: E
	 */
	public E getByQuery(Query query);

	/**
	 * 鏍规嵁id 鍒犻櫎
	 * @Title: deleteById
	 * @Description: TODO
	 * @param id
	 *            : void
	 */
	public boolean deleteById(PK id);
	
	/**
	 * 鏍规嵁鍏朵粬鏉′欢鍒犻櫎
	 * @Title: deleteByQuery
	 * @Description: TODO
	 * @param id
	 *            : void
	 */
	public boolean deleteByQuery(Query query);

	/**
	 * 淇濆瓨
	 * @Title: save
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean save(E entity);
	
	/**
	 * 淇濆瓨
	 * @Title: save
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean saveNotNull(E entity);

	/**
	 * 鍏ㄩ儴淇敼
	 * @Title: update
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean update(E entity);
	
	/**
	 * 鏍规嵁id 淇敼鏌愪簺瀛楁
	 * @Title: updateById
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean updateById(E entity);
	
	/**
	 * 甯︽潯浠�鍏ㄩ儴鏌ヨ
	 * @Title: findAll
	 * @Description: TODO
	 * @return: List<E>
	 */
	public List<E> findAll(Query query);
	
	/**
	 * 甯︽潯浠�鍒嗛〉
	 * @Title: findPage
	 * @Description: TODO
	 * @return: List<E>
	 */
	public List<E> findPage(Query query);

	/**
	 * 甯︽潯浠舵煡璇㈡�涓暟
	 * @Title: getCountByQuery
	 * @Description: TODO
	 * @return: int
	 */
	public int getCountByQuery(Query query);
	
	/**
	 * 鏄惁瀛樺湪
	 * @Title: isExist
	 * @Description: TODO
	 * @param propertyName
	 * @param propertyValue
	 * @return: boolean
	 */
	public boolean isExist(Query query);

}
