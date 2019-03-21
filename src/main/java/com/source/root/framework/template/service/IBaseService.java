package com.source.root.framework.template.service;

import java.io.Serializable;
import java.util.List;

import com.source.root.framework.comm.pager.Query;

/**
 * @ClassName: IBaseService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author MR.Guo xiaodangjia456@163.com
 * @date 2014年4月22日 下午2:40:46
 * 
 * @param <E>
 * @param <PK>
 */
public interface IBaseService<E, PK extends Serializable> {

	/**
	 * 根据Id 查询
	 * 
	 * @Title: getByMaxId
	 * @Description: TODO
	 * @param id
	 * @return: E
	 */
	public E getByMaxId();

	/**
	 * 根据Id 查询
	 * 
	 * @Title: getById
	 * @Description: TODO
	 * @param id
	 * @return: E
	 */
	public E getById(PK id);

	/**
	 * 根据其他条件查询
	 * 
	 * @Title: getByQuery
	 * @Description: TODO
	 * @param id
	 * @return: E
	 */
	public E getByQuery(Query query);

	/**
	 * 根据id 删除
	 * 
	 * @Title: deleteById
	 * @Description: TODO
	 * @param id
	 *            : void
	 */
	public boolean deleteById(PK id);

	/**
	 * 根据其他条件删除
	 * 
	 * @Title: deleteByQuery
	 * @Description: TODO
	 * @param id
	 *            : void
	 */
	public boolean deleteByQuery(Query query);

	/**
	 * 保存
	 * 
	 * @Title: save
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean save(E entity);

	/**
	 * 保存
	 * 
	 * @Title: save
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean saveNotNull(E entity);

	/**
	 * 全部修改
	 * 
	 * @Title: update
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean update(E entity);

	/**
	 * 根据id 修改某些字段
	 * 
	 * @Title: updateById
	 * @Description: TODO
	 * @param entity
	 *            : void
	 */
	public boolean updateById(E entity);

	/**
	 * 带条件 全部查询
	 * 
	 * @Title: findAll
	 * @Description: TODO
	 * @return: List<E>
	 */
	public List<E> findAll(Query query);

	/**
	 * 带条件 分页
	 * 
	 * @Title: findPage
	 * @Description: TODO
	 * @return: List<E>
	 */
	public List<E> findPage(Query query);

	/**
	 * 带条件查询总个数
	 * 
	 * @Title: getCountByQuery
	 * @Description: TODO
	 * @return: int
	 */
	public int getCountByQuery(Query query);

	/**
	 * 是否存在
	 * 
	 * @Title: isExist
	 * @Description: TODO
	 * @param propertyName
	 * @param propertyValue
	 * @return: boolean
	 */
	public boolean isExist(Query query);

}
