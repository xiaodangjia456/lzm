package com.source.root.framework.template.web.controller;

import java.io.PrintWriter;

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
public class BaseRestEasyController<Entity, PK> {

	/**
	 * @Title: index
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @param model
	 * @return: String
	 */
	@RequestMapping(value = "/get/pre")
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		throw new UnsupportedOperationException("not implement");
	}
	
	/**
	 * @Title: getNewsData
	 * @param entity
	 * @param request
	 * @param response
	 * @param printWriter
	 * @throws Exception
	 */
	@RequestMapping(value = "/get/news/by/bg/{id}")
	public void getNewsData(@PathVariable("id") PK id,
			HttpServletRequest request, HttpServletResponse response
			, PrintWriter printWriter)
					throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: show
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{id}")
	public Entity show(@PathVariable("id") PK id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: showDetail
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/showDetail/{id}")
	public String showDetail(@PathVariable("id") PK id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: _new
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/post/pre")
	public String _new(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: create
	 * @param entity
	 * @param request
	 * @param response
	 * @param printWriter
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void create(Entity entity, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter)
			throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: edit
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{id}/put/pre")
	public String edit(@PathVariable("id") PK id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: update
	 * @param id
	 * @param entity
	 * @param request
	 * @param response
	 * @param printWriter
	 * @throws Exception
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") PK id, Entity entity,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) throws Exception {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: delete
	 * @param id
	 * @param request
	 * @param response
	 * @param printWriter
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") PK id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: batchDelete
	 * @param items
	 * @param request
	 * @param response
	 * @param printWriter
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void batchDelete(@RequestParam("items") PK[] items,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		throw new UnsupportedOperationException("not implement");
	}

}
