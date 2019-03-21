<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/comm/_comm.jsp"%>
<title>林之牧物联网</title>
</head>
<body>
	<%
		String nowUrl = request.getRequestURL().toString();
		if (nowUrl.contains("app")) {
			String url = request.getContextPath() + "/min/default/tologin";
			response.sendRedirect(url);
		} else {
			String url = request.getContextPath() + "/min/default/tologin";
			response.sendRedirect(url);
		}
	%>
</body>
</html>