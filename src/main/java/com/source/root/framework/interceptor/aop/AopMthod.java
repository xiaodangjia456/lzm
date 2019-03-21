package com.source.root.framework.interceptor.aop;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.source.root.framework.comm.pager.ConditionParams;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.other.RMSAuthorityUtile;
import com.source.root.manager.entity.Logs;
import com.source.root.manager.service.LogsService;

public class AopMthod {
	@Autowired
	private LogsService logsService;
	@Autowired
	private RMSAuthorityUtile RMSAuthorityUtile;

	private static Logger logger = Logger.getLogger(AopMthod.class);

	@SuppressWarnings("unused")
	public void beforeMthod(JoinPoint call) {
		// 获取目标对象对应的类名
		String className = call.getTarget().getClass().getName();
		// 获取目标对象上正在执行的方法名
		String methodName = call.getSignature().getName();
		// System.out.println("前置通知:" + className + "类的" + methodName +
		// "方法开始了");
	}

	public void afterMthod(JoinPoint call) {
		// 获取目标对象对应的类名
		// String className = call.getTarget().getClass().getName();
		String _className = call.getTarget().getClass().getSimpleName().replaceAll("DaoImpl", "");
		// 获取目标对象上正在执行的方法名
		String methodName = call.getSignature().getName();
		if (CheckClassNameFilter.checkClassName(_className)) {
			if (methodName == "save" || methodName.equals("save") || methodName == "saveNotNull"
					|| methodName.equals("saveNotNull")) {
				Logs logs = new Logs();
				Object[] obj = call.getArgs();
				Gson gson = new Gson();
				String param = "添加数据：" + gson.toJson(obj);
				if ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes() != null) {
					HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest();
					if (request != null) {
						String ipAddr = RMSAuthorityUtile.getIpAddr(request);
						logs = resultLogs(request, methodName, _className, param, ipAddr);
					} else {
						logs.setCreatTime(new Date());
						logs.setIpAddr("server");
						logs.setMethod(methodName);
						logs.setRecord(param);
						logs.setTableName(_className);
						logs.setUser("系统");
					}
				} else {
					logs.setCreatTime(new Date());
					logs.setIpAddr("server");
					logs.setMethod(methodName);
					logs.setRecord(param);
					logs.setTableName(_className);
					logs.setUser("系统");
				}
				logsService.save(logs);

				String logMsg = logs.getUser() + "对" + _className + "表添加数据，具体参数：" + gson.toJson(obj);
				logger.error(logMsg);

			} else if (methodName == "updateById" || methodName.equals("updateById") || methodName == "update"
					|| methodName.equals("update")) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				String ipAddr = RMSAuthorityUtile.getIpAddr(request);
				Object[] obj = call.getArgs();
				Gson gson = new Gson();
				String param = "修改数据：" + gson.toJson(obj);

				Logs logs = resultLogs(request, methodName, _className, param, ipAddr);
				logsService.save(logs);

				String logMsg = logs.getUser() + "对" + _className + "表修改数据，具体参数：" + gson.toJson(obj);
				logger.error(logMsg);
			} else if (methodName == "deleteById" || methodName.equals("deleteById")) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				String ipAddr = RMSAuthorityUtile.getIpAddr(request);
				Object[] obj = call.getArgs();
				String param = "";
				for (Object o : obj) {
					param += o + ",";
				}
				param = "删除数据Id：" + param.substring(0, param.length() - 1);

				Logs logs = resultLogs(request, methodName, _className, param, ipAddr);
				logsService.save(logs);

				String logMsg = logs.getUser() + "对" + _className + "表删除数据，具体参数：" + param;
				logger.error(logMsg);
			} else if (methodName == "deleteByQuery" || methodName.equals("deleteByQuery")) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				String ipAddr = RMSAuthorityUtile.getIpAddr(request);
				Object[] obj = call.getArgs();
				String param = "";
				for (Object o : obj) {
					Query query = (Query) o;
					List<ConditionParams> list = query.getAndCondition();

					Gson gson = new Gson();
					Type type = new TypeToken<List<ConditionParams>>() {
					}.getType();
					param += gson.toJson(list, type) + ",";
				}
				param = "删除数据：" + param.substring(0, param.length() - 1);

				Logs logs = resultLogs(request, methodName, _className, param, ipAddr);
				logsService.save(logs);

				String logMsg = logs.getUser() + "对" + _className + "表删除数据，具体参数：" + param;
				logger.error(logMsg);
			}
		}
	}

	public Logs resultLogs(HttpServletRequest request, String methodName, String _className, String param,
			String ipAddr) {
		Logs logs = new Logs();
		String userId = "";
		String userName = "";
		if (RMSAuthorityUtile.loginUserID(request) != null) {
			userId = String.valueOf(RMSAuthorityUtile.loginUserID(request));
			userName = RMSAuthorityUtile.loginName(request);
		}
		logs.setCreatTime(new Date());
		logs.setMethod(methodName);
		logs.setTableName(_className);
		logs.setRecord(param);
		if (userId != null && !userId.isEmpty()) {
			logs.setUser("id:" + userId + ",name:" + userName);
		} else {
			logs.setUser("系统");
		}
		logs.setIpAddr(ipAddr);

		return logs;
	}

	@SuppressWarnings("unused")
	public void finalMthod(JoinPoint call) {
		// 获取目标对象对应的类名
		String className = call.getTarget().getClass().getName();
		// 获取目标对象上正在执行的方法名
		String methodName = call.getSignature().getName();
		// System.out.println("最终通知:" + className + "类的" + methodName + "最终消息");
	}
}
