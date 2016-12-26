/**
 * Created by likuo on 2016/12/15
 */
package com.stu.likuo;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    public static String myEmailAccount = "likuo139329@sina.com";
    public static String myEmailPassword = "likuo139329";
    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.sina.com";
 
    public static MimeMessage sendMail(String receiver,String subject,String content) throws Exception{
		 // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.host", myEmailSMTPHost);        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 请求认证，参数名称与具体实现有关

    	 Session session = Session.getDefaultInstance(props);
         session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
    	MimeMessage message = new MimeMessage(session);
    	// 2. From: 发件人
        message.setFrom(new InternetAddress(myEmailAccount, "李阔", "UTF-8"));
     // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver, "李娅", "UTF-8"));
    	   // 4. Subject: 邮件主题
        message.setSubject(subject, "UTF-8");
    	 message.setContent(content, "text/html;charset=UTF-8");
    	// 6. 设置发件时间
         message.setSentDate(new Date());
         // 4. 根据 Session 获取邮件传输对象
         Transport transport = session.getTransport();
         // 5. 使用 邮箱账号 和 密码 连接邮件服务器
         //    这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
         transport.connect(myEmailAccount, myEmailPassword);

         // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
         transport.sendMessage(message, message.getAllRecipients());

         // 7. 关闭连接
         transport.close();
         return message;
    }
   public static void main(String args[]) throws Exception{
    	  sendMail("2631524571@qq.com","你好","这次成功了");
   }
}

