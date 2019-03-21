package com.source.root.framework.template.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.source.root.framework.comm.pager.Query;

/**
 * @ClassName: BaseDaoImpl
 * @Description: TODO(閺夆晜鐟╅崳鐑芥偨閵娿倗顏遍柛娆嶅劥閻︿粙骞撹箛姘墯閺夆晜鐟ら柌婊呯尵閼姐倖鐣卞ù锝嗙矌閺侊拷
 * @author MR.Guo xiaodangjia456@163.com
 * @date 2014妤犵儑鎷烽柡鍫嫹2闁哄喛鎷峰☉鎾愁儏瀹曪拷:49:09
 * 
 * @param <E>
 * @param <PK>
 */
@SuppressWarnings({ "unchecked", "deprecation" })
public abstract class BaseDaoImpl<E, PK extends Serializable> extends
		SqlMapClientDaoSupport implements IBaseDao<E, PK> {

	/**
	 * @Title: setRWSqlMapClient
	 * @Description: TODO
	 * @param sqlMapClient
	 *            : void
	 */
	@Autowired
	public void setRWSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}

	// ==闁瑰灝绉崇紞鏃堟儍閸曨偒鍤犻悹鐑囨嫹
	private final Class<E> clazz;

	/**
	 * @Description: TODO
	 * @param clazz
	 */
	public BaseDaoImpl(Class<E> clazz) {
		this.clazz = clazz;
	}

	// ==xml sql閻庤鐭粻鐔烘喆閸曨喖鐦�
	/**
	 * @Title: getTableName
	 * @Description: TODO
	 * @return: String
	 */
	private String getTableName() {
		return clazz.getSimpleName() + ".";
	}

	/**
	 * @Title: getById
	 * @Description: TODO
	 * @return: String
	 */
	private String _getByMaxId() {
		return "getByMaxId";
	}

	/**
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#getById(java.io.Serializable)
	 */
	public E getByMaxId() {
		return queryObject(_getByMaxId());
	}

	/**
	 * @Title: getById
	 * @Description: TODO
	 * @return: String
	 */
	private String getById() {
		return "getById";
	}

	/**
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#getById(java.io.Serializable)
	 */
	public E getById(PK id) {
		return queryObject(getById(), id);
	}

	/**
	 * @Title: getByQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String getByQuery() {
		return "getByQuery";
	}

	/**
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#getById(java.io.Serializable)
	 */
	public E getByQuery(Query query) {
		return queryObject(getByQuery(), query);
	}

	/**
	 * @Title: deleteById
	 * @Description: TODO
	 * @return: String
	 */
	private String deleteById() {
		return "deleteById";
	}

	/**
	 * <p>
	 * Title: deleteById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @see com.ams.source.framework.template.dao.IBaseDao#deleteById(java.io.Serializable)
	 */
	@Transactional
	public boolean deleteById(PK id) {
		boolean result = delete(deleteById(), id);
		return result;
	}

	/**
	 * @Title: deleteByQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String deleteByQuery() {
		return "deleteByQuery";
	}

	/**
	 * <p>
	 * Title: deleteById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @see com.ams.source.framework.template.dao.IBaseDao#deleteById(java.io.Serializable)
	 */
	@Transactional
	public boolean deleteByQuery(Query query) {
		boolean result = delete(deleteByQuery(), query);
		return result;
	}

	/**
	 * @Title: getInsertQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String save() {
		return "save";
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
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#save(java.lang.Object)
	 */
	@Transactional
	public boolean save(E entity) {
		boolean result = insert(save(), entity);
		return result;
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
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#save(java.lang.Object)
	 */
	@Transactional
	public boolean saveNotNull(E entity) {
		boolean result = insert(saveNotNull(), entity);
		return result;
	}

	/**
	 * @Title: getInsertQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String saveNotNull() {
		return "saveNotNull";
	}

	/**
	 * @Title: update
	 * @Description: TODO
	 * @return: String
	 */
	private String update() {
		return "update";
	}

	/**
	 * <p>
	 * Title: update
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param entity
	 * @see com.ams.source.framework.template.dao.IBaseDao#update(java.lang.Object)
	 */
	@Transactional
	public boolean update(E entity) {
		boolean result = update(update(), entity);
		return result;
	}

	/**
	 * @Title: updateById
	 * @Description: TODO
	 * @return: String
	 */
	private String updateById() {
		return "updateById";
	}

	/**
	 * <p>
	 * Title: updateById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param entity
	 * @see com.ams.source.framework.template.dao.IBaseDao#update(java.lang.Object)
	 */
	@Transactional
	public boolean updateById(E entity) {
		boolean result = update(updateById(), entity);
		return result;
	}

	/**
	 * @Title: getAllQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String findAll() {
		return "findAll";
	}

	/**
	 * <p>
	 * Title: findAll
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#findAll()
	 */
	public List<E> findAll(Query query) {
		return queryList(findAll(), query);
	}

	/**
	 * @Title: getAllQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String findPage() {
		return "findPage";
	}

	/**
	 * <p>
	 * Title: findPage
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#findAll()
	 */
	public List<E> findPage(Query query) {
		return queryList(findPage(), query);
	}

	/**
	 * @Title: getCountQuery
	 * @Description: TODO
	 * @return: String
	 */
	private String getCountByQuery() {
		return "getCountByQuery";
	}

	/**
	 * <p>
	 * Title: getCountByQuery
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#findAll()
	 */
	public int getCountByQuery(Query query) {
		return getCountForM(getCountByQuery(), query);
	}

	/**
	 * <p>
	 * Title: isExist
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.ams.source.framework.template.dao.IBaseDao#findAll()
	 */
	public boolean isExist(Query query) {
		return isExistByQuery(getCountByQuery(), query);
	}

	/**
	 * @Title: _uniqueResult
	 * @Description: TODO
	 * @param result
	 * @return: E
	 */
	private E _uniqueResult(List<E> result) {
		if (result != null && result.size() != 0) {
			return (E) result.get(0);
		}
		return null;
	}

	/**
	 * @Title: queryList
	 * @Description: TODO
	 * @param statementName
	 * @return: List<E>
	 */
	protected List<E> queryList(String statementName) {
		return (List<E>) getSqlMapClientTemplate().queryForList(
				getTableName() + statementName);
	}

	/**
	 * 闁哄秷顬冨畵渚�蓟閵夘煈鍤勯柟绋挎矗閹躲倝宕仦鍓у帣濞戞搩浜滈惈姗�箑瑜嶉敓鑺ユ交閺傛寧绀�紒妤嬬畱閹酣寮堕垾鍙夘偨闁汇劌瀚崹顏嗘偘閿燂拷
	 * 
	 * @param statementName
	 *            ,paraObject
	 * @return
	 */
	protected List<E> queryList(String statementName, Object paraObject) {
		return (List<E>) getSqlMapClientTemplate().queryForList(
				getTableName() + statementName, paraObject);
	}

	/**
	 * 闁哄秷顬冨畵渚�蓟閵夘煈鍤勯柟绋挎矗閹躲倝宕仦鍓у帣濞戞搩浜滈惈姗�箑瑜嶉敓鑺ユ交閺傛寧绀�紒妤嬬畱閹酣寮堕垾鍙夘偨闁汇劌瀚崹顏嗘偘閿熺禉r> 閺夆晜鏌ㄥú鏍拷绾懓鏉藉☉鎾虫惈鐢偊鎮介悢濂夊殸閻犵儑鎷�
	 * 
	 * @param statementName
	 *            ,paraObject
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected List nativeQueryList(String statementName, Object paraObject) {
		return getSqlMapClientTemplate().queryForList(
				getTableName() + statementName, paraObject);
	}

	/**
	 * 闁圭瑳鍡╂斀闁告帞濞�▍搴ㄥ箰閸ワ附濮�
	 * 
	 * @param statementName
	 * @param paraObject
	 */
	protected boolean delete(String statementName, Object paraObject) {
		int result = getSqlMapClientTemplate().delete(
				getTableName() + statementName, paraObject);
		return result == 1 ? true : false;
	}

	/**
	 * 闁圭瑳鍡╂斀闁圭粯甯掗崣鍡涘箰閸ワ附濮�
	 * 
	 * @param statementName
	 * @param paraObject
	 */
	protected boolean insert(String statementName, Object paraObject) {
		getSqlMapClientTemplate().insert(getTableName() + statementName,
				paraObject);
		return true;
	}

	/**
	 * 闁圭瑳鍡╂斀闁哄洤鐡ㄩ弻濠囧箰閸ワ附濮�
	 * 
	 * @param statementName
	 * @param paraObject
	 */
	protected boolean update(String statementName, Object paraObject) {
		int result = getSqlMapClientTemplate().update(
				getTableName() + statementName, paraObject);
		return result == 1 ? true : false;
	}

	/**
	 * 闁哄秷顬冨畵渚�蓟閵夘煈鍤勯柟绋挎矗閹躲倖娼婚弬鎸庣閻庣數顢婇挅锟�
	 * 
	 * @param statementName
	 * @return
	 */
	protected E queryObject(String statementName) {
		return _uniqueResult(queryList(statementName));
	}

	/**
	 * 闁哄秷顬冨畵渚�蓟閵夘煈鍤勯柟绋挎矗閹躲倝宕仦鍓у帣濞戞搩浜滈惈姗�箑瑜嶉敓鑺ユ交閺傛寧绀�紒妤嬬畱閹酣寮堕垾鍙夘偨闁汇劌瀚顔炬寬閿燂拷
	 * 
	 * @param statementName
	 *            ,propertyValue
	 * @return
	 */
	protected E queryObject(String statementName, Object paraObject) {
		return _uniqueResult(queryList(statementName, paraObject));
	}

	/**
	 * 闁哄秷顬冨畵渚�蓟閵夘煈鍤勯柟绋挎矗閹躲倝宕仦鍓у帣濞戞搩浜滈惈姗�箑瑜嶉敓浠嬫⒖閸℃鍊ら悗鐢殿攰閽栧嫭娼婚弬鎸庣缂佹绠戦幃搴ㄥ级閳ュ弶顐介柣銊ュ椤曨喚鎸掗敓锟�
	 * 
	 * @param statementName
	 *            ,propertyValue
	 * @return
	 */
	protected Object nativeQueryObject(String statementName, Object paraObject) {
		return getSqlMapClientTemplate().queryForObject(
				getTableName() + statementName, paraObject);
	}

	/**
	 * 閺夆晜鏌ㄥú鏍拷閻熸壆瀹夐柡灞诲劥椤曟鎯冮崟顕呭敹鐟滅増娲戦柌婊堝极鐢喚绀夊☉鎾存尫鐠愮喓鎲撮敐鍛瀫闁炽儲绮嶅ǎ顔碱煥缁櫢鎷峰銈呮贡濞蹭即寮憴鍕�
	 * 
	 * @param statementName
	 * @return
	 * @author Mr.Guo
	 * @version 2013-1-23 濞戞挸顑呭畷锟�:30:59
	 */
	protected int getCountForM(String statementName, Object object) {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				getTableName() + statementName, object);
		return count;
	}

	/**
	 * 閺夆晜鏌ㄥú鏍拷閻熸壆瀹夐柡灞诲劥椤曟鎯冮崟顕呭敹鐟滅増娲戦柌婊堝极鐢喚绀夊☉鎾存尫鐠愮喓鎲撮敐鍛瀫闁炽儲绮嶅ǎ顔碱煥缁櫢鎷峰銈呮贡濞蹭即寮憴鍕�
	 * 
	 * @param statementName
	 * @return
	 * @author Mr.Guo
	 * @version 2013-1-23 濞戞挸顑呭畷锟�:30:59
	 */
	protected int getCountResult(String statementName) {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				getTableName() + statementName);
		return count;
	}

	protected boolean isExistByQuery(String statementName, Object object) {
		boolean flag = false;
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				getTableName() + statementName, object);
		if (count > 0) {
			flag = true;
		}
		return flag;
	}

}
