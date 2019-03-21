package com.source.root.framework.comm.util.email;

public class SendEmailUtil {

	private static String SERVERHOST = "smtp.qq.com";
	private static String SERVERPORT = "587";
	private static boolean VALIDATE = true;
	private static String USERNAME = "714446726@qq.com";
	private static String PASSWORD = "guoshuaijun";

	public static boolean sendEmail(String ToAddress, String Title,
			String content) {
		boolean result = false;
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(SERVERHOST);
		mailInfo.setMailServerPort(SERVERPORT);
		mailInfo.setValidate(VALIDATE);
		mailInfo.setUserName(USERNAME);
		mailInfo.setPassword(PASSWORD);// 您的邮箱密码
		mailInfo.setFromAddress(USERNAME);
		mailInfo.setToAddress(ToAddress);
		mailInfo.setSubject(Title);
		mailInfo.setContent(content);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		result = sms.sendTextMail(mailInfo);
		return result;
	}
	
	public static void main(String[] args) {
		boolean a = sendEmail("188816675@qq.com", "测试" , "测试内容");
		System.out.println(a);
	}

}
