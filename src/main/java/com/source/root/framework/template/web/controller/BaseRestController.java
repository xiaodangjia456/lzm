package com.source.root.framework.template.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 瀹氫箟鏍囧噯鐨剅est鏂规硶瑙勮寖锛屼互瀹炵幇rest缁熶竴鏍囧噯锛屽苟鍙互閬垮厤瀛愮被閲嶅缂栧啓@RequestMapping
 * 瀛愮被瑕佸疄鐜版煇鍔熻兘鍙渶瑕嗙洊 璇ユ柟娉曞嵆鍙� 娉ㄦ剰: 瑕嗙洊鏃惰浣跨敤@Override,浠ョ‘淇濅笉浼氬彂鐢熼敊璇�
 * 
 * <font color="red">frameset 妗嗘灦椤甸」鐩娇鐢�/font>
 * 
 * @copyright {@xiaodangjia456@163.com}
 * @author guosj
 * @version 2013-1-15 涓婂崍09:53:44
 * @param <Entity>
 * @param <PK>
 */
public class BaseRestController<Entity, PK> {

	/**
	 * @Title: index
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @param model
	 * @return: String
	 */
	@RequestMapping(value = "/get/pre")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: 最新数据
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/get/news/by/bg/{id}")
	public String getNewsData(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: showDetail
	 * @Description: TODO
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 *             : Entity
	 */
	@RequestMapping(value = "/showDetail/{id}")
	public String showDetail(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: show
	 * @Description: TODO
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 *             : Entity
	 */
	@RequestMapping(value = "/{id}")
	public Entity show(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		throw new UnsupportedOperationException("not implement");
	}


	/**
	 * @Title: _new
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 *             : String
	 */
	@RequestMapping(value = "/post/pre")
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: create
	 * @Description: TODO
	 * @param entity
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 *             : String
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String create(Entity entity, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: edit
	 * @Description: TODO
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 *             : String
	 */
	@RequestMapping(value = "/{id}/put/pre")
	public String edit(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: update
	 * @Description: TODO
	 * @param id
	 * @param entity
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 *             : String
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public String update(@PathVariable("id") PK id, Entity entity, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: delete
	 * @Description: TODO
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return: String
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: batchDelete
	 * @Description: TODO
	 * @param items
	 * @param request
	 * @param response
	 * @param model
	 * @return: String
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String batchDelete(@RequestParam("items") PK[] items, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		throw new UnsupportedOperationException("not implement");
	}

}
