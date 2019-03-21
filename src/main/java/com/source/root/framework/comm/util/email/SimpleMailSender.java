package com.source.root.framework.comm.util.email;   
  
import java.util.Date;    
import java.util.Properties;   
import javax.mail.Address;    
import javax.mail.BodyPart;    
import javax.mail.Message;    
import javax.mail.MessagingException;    
import javax.mail.Multipart;    
import javax.mail.Session;    
import javax.mail.Transport;    
import javax.mail.internet.InternetAddress;    
import javax.mail.internet.MimeBodyPart;    
import javax.mail.internet.MimeMessage;    
import javax.mail.internet.MimeMultipart;    
  
/**   
* 绠�崟閭欢锛堜笉甯﹂檮浠剁殑閭欢锛夊彂閫佸櫒   
http://www.bt285.cn BT涓嬭浇
*/    
public class SimpleMailSender  {    
/**   
  * 浠ユ枃鏈牸寮忓彂閫侀偖浠�  
  * @param mailInfo 寰呭彂閫佺殑閭欢鐨勪俊鎭�  
  */    
    public boolean sendTextMail(MailSenderInfo mailInfo) {    
      // 鍒ゆ柇鏄惁闇�韬唤璁よ瘉    
      MyAuthenticator authenticator = null;    
      Properties pro = mailInfo.getProperties();   
      if (mailInfo.isValidate()) {    
      // 濡傛灉闇�韬唤璁よ瘉锛屽垯鍒涘缓涓�釜瀵嗙爜楠岃瘉鍣�   
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());    
      }   
      // 鏍规嵁閭欢浼氳瘽灞炴�鍜屽瘑鐮侀獙璇佸櫒鏋勯�涓�釜鍙戦�閭欢鐨剆ession    
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
      try {    
      // 鏍规嵁session鍒涘缓涓�釜閭欢娑堟伅    
      Message mailMessage = new MimeMessage(sendMailSession);    
      // 鍒涘缓閭欢鍙戦�鑰呭湴鍧�   
      Address from = new InternetAddress(mailInfo.getFromAddress());    
      // 璁剧疆閭欢娑堟伅鐨勫彂閫佽�    
      mailMessage.setFrom(from);    
      // 鍒涘缓閭欢鐨勬帴鏀惰�鍦板潃锛屽苟璁剧疆鍒伴偖浠舵秷鎭腑    
      Address to = new InternetAddress(mailInfo.getToAddress());    
      mailMessage.setRecipient(Message.RecipientType.TO,to);    
      // 璁剧疆閭欢娑堟伅鐨勪富棰�   
      mailMessage.setSubject(mailInfo.getSubject());    
      // 璁剧疆閭欢娑堟伅鍙戦�鐨勬椂闂�   
      mailMessage.setSentDate(new Date());    
      // 璁剧疆閭欢娑堟伅鐨勪富瑕佸唴瀹�   
      String mailContent = mailInfo.getContent();    
      mailMessage.setText(mailContent);    
      // 鍙戦�閭欢    
      Transport.send(mailMessage);   
      return true;    
      } catch (MessagingException ex) {    
          ex.printStackTrace();    
      }    
      return false;    
    }    
       
    /**   
      * 浠TML鏍煎紡鍙戦�閭欢   
      * @param mailInfo 寰呭彂閫佺殑閭欢淇℃伅   
      */    
    public static boolean sendHtmlMail(MailSenderInfo mailInfo){    
      // 鍒ゆ柇鏄惁闇�韬唤璁よ瘉    
      MyAuthenticator authenticator = null;   
      Properties pro = mailInfo.getProperties();   
      //濡傛灉闇�韬唤璁よ瘉锛屽垯鍒涘缓涓�釜瀵嗙爜楠岃瘉鍣�    
      if (mailInfo.isValidate()) {    
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());   
      }    
      // 鏍规嵁閭欢浼氳瘽灞炴�鍜屽瘑鐮侀獙璇佸櫒鏋勯�涓�釜鍙戦�閭欢鐨剆ession    
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
      try {    
      // 鏍规嵁session鍒涘缓涓�釜閭欢娑堟伅    
      Message mailMessage = new MimeMessage(sendMailSession);    
      // 鍒涘缓閭欢鍙戦�鑰呭湴鍧�   
      Address from = new InternetAddress(mailInfo.getFromAddress());    
      // 璁剧疆閭欢娑堟伅鐨勫彂閫佽�    
      mailMessage.setFrom(from);    
      // 鍒涘缓閭欢鐨勬帴鏀惰�鍦板潃锛屽苟璁剧疆鍒伴偖浠舵秷鎭腑    
      Address to = new InternetAddress(mailInfo.getToAddress());    
      // Message.RecipientType.TO灞炴�琛ㄧず鎺ユ敹鑰呯殑绫诲瀷涓篢O    
      mailMessage.setRecipient(Message.RecipientType.TO,to);    
      // 璁剧疆閭欢娑堟伅鐨勪富棰�   
      mailMessage.setSubject(mailInfo.getSubject());    
      // 璁剧疆閭欢娑堟伅鍙戦�鐨勬椂闂�   
      mailMessage.setSentDate(new Date());    
      // MiniMultipart绫绘槸涓�釜瀹瑰櫒绫伙紝鍖呭惈MimeBodyPart绫诲瀷鐨勫璞�   
      Multipart mainPart = new MimeMultipart();    
      // 鍒涘缓涓�釜鍖呭惈HTML鍐呭鐨凪imeBodyPart    
      BodyPart html = new MimeBodyPart();    
      // 璁剧疆HTML鍐呭    
      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");    
      mainPart.addBodyPart(html);    
      // 灏哅iniMultipart瀵硅薄璁剧疆涓洪偖浠跺唴瀹�   
      mailMessage.setContent(mainPart);    
      // 鍙戦�閭欢    
      Transport.send(mailMessage);    
      return true;    
      } catch (MessagingException ex) {    
          ex.printStackTrace();    
      }    
      return false;    
    }    
}   