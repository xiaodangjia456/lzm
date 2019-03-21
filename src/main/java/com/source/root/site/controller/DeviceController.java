
package com.source.root.site.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.source.root.framework.comm.objectsutil.RWReturnObject;
import com.source.root.framework.comm.pager.ConditionParams;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.framework.template.web.other.RMSAuthorityUtile;
import com.source.root.manager.entity.Dictionary;
import com.source.root.manager.entity.User;
import com.source.root.manager.service.DictionaryService;
import com.source.root.manager.service.UserService;
import com.source.root.site.entity.Device;
import com.source.root.site.service.DeviceService;

@Controller
@RequestMapping("/device")
public class DeviceController extends BaseRestEasyController<Device, java.lang.Integer> {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private RMSAuthorityUtile RMSAuthority;
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private UserService userService;

	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}

	/** 列表 */
	@Override
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		String deviceName = request.getParameter("deviceName");
		String deviceCode = request.getParameter("deviceCode");
		String siteId = request.getParameter("siteId");
		String showCount = request.getParameter("showCount");
		String currentPage = request.getParameter("currentPage");
		Query query = new Query();
		if (deviceName != null && !deviceName.isEmpty()) {
			query.addAndCondition("deviceName", ConditionParams.LK, deviceName);
		}
		if (deviceCode != null && !deviceCode.isEmpty()) {
			query.addAndCondition("deviceCode", ConditionParams.LK, deviceCode);
		}
		query.addAndCondition("siteId", siteId);
		int totalResult = deviceService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Device> list = deviceService.findPage(query);
		if (list != null) {
			for (Device d : list) {
				User user = userService.getById(d.getOperater());
				d.setUser(user);
				Dictionary dictionary = dictionaryService.getById(d.getDeviceType());
				d.setDictionary(dictionary);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		model.addAttribute("siteId", siteId);
		model.addAttribute("deviceName", deviceName);
		model.addAttribute("deviceCode", deviceCode);
		return "site_device/device/list";
	}

	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Device> list = deviceService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (Device entity : list) {
				resultJson += entity.getJson() + ",";
			}
			resultJson = resultJson.substring(0, resultJson.length() - 1) + "]";
			printWriter.write(resultJson);
		} else {
			printWriter.write("");
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String siteId = request.getParameter("siteId");
		model.addAttribute("siteId", siteId);

		Device device = (Device) deviceService.getById(id);
		User user = userService.getById(device.getOperater());
		device.setUser(user);
		Dictionary dictionary = dictionaryService.getById(device.getDeviceType());
		device.setDictionary(dictionary);
		model.addAttribute("item", device);
		return "site_device/device/show";
	}

	/** 显示 */
	@Override
	public Device show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Device device = (Device) deviceService.getById(id);
		model.addAttribute("device", device);
		return device;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		// 站点ID
		String siteId = request.getParameter("siteId");		
		model.addAttribute("siteId", siteId);
		// 设备信息
		model.addAttribute("item", new Device());
		// 设备类型
		Query query = new Query();
		query.addAndCondition("type", "'D_LX'");
		List<Dictionary> d_list = dictionaryService.findAll(query);
		model.addAttribute("d_list", d_list);
		return "site_device/device/add";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Device device, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter)
			throws Exception {
		int id = RMSAuthority.loginUserID(request);
		device.setCreateTime(new Date());
		device.setOperater(id);
		boolean result = deviceService.saveNotNull(device);
		if (result) {
			printWriter.write(new RWReturnObject(200, "添加数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "添加数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 编辑 */
	@Override
	public String edit(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {

		String siteId = request.getParameter("siteId");
		model.addAttribute("siteId", siteId);

		Device device = (Device) deviceService.getById(id);
		model.addAttribute("item", device);

		Query query = new Query();
		query.addAndCondition("type", "'D_LX'");
		List<Dictionary> d_list = dictionaryService.findAll(query);
		model.addAttribute("d_list", d_list);
		return "site_device/device/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, Device device, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) throws Exception {
		boolean result = deviceService.updateById(device);
		if (result) {
			printWriter.write(new RWReturnObject(200, "修改数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "修改数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 删除 */
	@Override
	public void delete(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		boolean result = deviceService.deleteById(id);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 批量删除 */
	@Override
	public void batchDelete(@RequestParam("items") java.lang.Integer[] items, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		String ids = "";
		for (int i = 0; i < items.length; i++) {
			ids += String.valueOf(items[i]) + ",";
		}
		ids = ids.substring(0, ids.length() - 1);
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.IN, ids);
		boolean result = deviceService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

}
