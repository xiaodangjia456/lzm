package com.source.root.framework.template.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 瀹氫箟鏍囧噯鐨剅est鏂规硶瑙勮寖锛屼互瀹炵幇rest缁熶竴鏍囧噯锛屽苟鍙互閬垮厤瀛愮被閲嶅缂栧啓@RequestMapping 瀛愮被瑕佸疄鐜版煇鍔熻兘鍙渶瑕嗙洊 璇ユ柟娉曞嵆鍙� 娉ㄦ剰:
 * 瑕嗙洊鏃惰浣跨敤@Override,浠ョ‘淇濅笉浼氬彂鐢熼敊璇�
 * 
 * <font color="red">frameset 妗嗘灦椤甸」鐩娇鐢�/font>
 * 
 * @copyright {@xiaodangjia456@163.com}
 * @author guosj
 * @version 2013-1-15 涓婂崍09:53:44
 * @param <Entity>
 * @param <PK>
 */
public class BaseFrameworkController<Entity, PK> {

	/**
	 * @Title: show
	 * @Description: TODO
	 * @param id
	 * @return: Entity
	 */
	@RequestMapping(value = "/{id}", produces = { "text/javascript;charset=UTF-8" })
	public
	Entity show(@PathVariable("id") PK id) {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: _new
	 * @Description: TODO
	 * @param model
	 * @return: String
	 */
	@RequestMapping(value = "/post/pre", produces = { "text/javascript;charset=UTF-8" })
	public String _new(Model model) {
		throw new UnsupportedOperationException("not implement");
	}

	/**
	 * @Title: edit
	 * @Description: TODO
	 * @param id
	 * @param model
	 * @return: String
	 */
	@RequestMapping(value = "/{id}/put/pre", produces = { "text/javascript;charset=GBK" })
	public String edit(@PathVariable("id") PK id, Model model) {
		throw new UnsupportedOperationException("not implement");
	}

}
