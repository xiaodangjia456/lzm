package com.source.root.framework.interceptor;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.source.root.manager.entity.User;

public class Ams_Interceptor extends HandlerInterceptorAdapter {

	// Log4j
	// private static Logger logger = Logger.getLogger(Ams_Interceptor.class);

	/**
	 * afterCompletion()鏂规硶鍦―ispatcherServlet瀹屽叏澶勭悊瀹岃姹傚悗琚皟鐢�
	 * 
	 * afterCompletion()锛氳繖涓柟娉曞湪DispatcherServlet瀹屽叏澶勭悊瀹岃姹傚悗琚皟鐢紝
	 * 鍙互鍦ㄨ鏂规硶涓繘琛屼竴浜涜祫婧愭竻鐞嗙殑鎿嶄綔銆�
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("afterCompletion.....");
	}

	/**
	 * postHandle()鏂规硶鍦ㄤ笟鍔″鐞嗗櫒澶勭悊璇锋眰涔嬪悗琚皟鐢�
	 * 
	 * postHandle()锛氳繖涓柟娉曞湪涓氬姟澶勭悊鍣ㄥ鐞嗗畬璇锋眰鍚庯紝浣嗘槸DispatcherServlet鍚戝鎴风杩斿洖璇锋眰鍓嶈
	 * 璋冪敤锛� 鍦ㄨ鏂规硶涓鐢ㄦ埛璇锋眰request杩涜澶勭悊銆�
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("postHandle.....");
	}

	/**
	 * preHandle()鏂规硶鍦ㄤ笟鍔″鐞嗗櫒澶勭悊璇锋眰涔嬪墠琚皟鐢�
	 * 
	 * preHandle()锛氳繖涓柟娉曞湪涓氬姟澶勭悊鍣ㄥ鐞嗚姹備箣鍓嶈璋冪敤锛屽湪璇ユ柟娉曚腑瀵圭敤鎴疯姹俽equest杩涜澶勭悊銆�
	 * 濡傛灉绋嬪簭鍛樺喅瀹氳鎷︽埅鍣ㄥ璇锋眰杩涜鎷︽埅澶勭悊鍚庤繕瑕佽皟鐢ㄥ叾浠栫殑鎷︽埅鍣紝
	 * 鎴栬�鏄笟鍔″鐞嗗櫒鍘昏繘琛屽鐞嗭紝鍒欒繑鍥瀟rue锛涘
	 * 鏋滅▼搴忓憳鍐冲畾涓嶉渶瑕佸啀璋冪敤鍏朵粬鐨勭粍浠跺幓澶勭悊璇锋眰锛屽垯杩斿洖false銆�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		response.setContentType("application/x-www-form-urlencoded;charset=utf-8");
		// 璁剧疆椤甸潰涓嶇紦瀛�
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");

		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("text", "html", Charset.forName("utf-8"));
		headers.setContentType(mediaType);

		String indexUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String nowUrl = request.getRequestURL().toString();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if (indexUrl == nowUrl || nowUrl.equals(indexUrl)) {
				response.sendRedirect(indexUrl);
				return false;
			}
			String id = user.getId().toString();
			if (id != null && !"".equals(id)) {
				return true;
			}
		} else {
			if (nowUrl.contains("/min/default/login")
					|| nowUrl.contains("/min/default/tologin")
					|| nowUrl.contains("/min/default/register")
					|| nowUrl.contains("/min/default/current/validatecode")
					|| nowUrl.contains("/RandomValidateCode")) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/min/default/tologin");
				return false;
			}
		}
		return false;
	}
}
