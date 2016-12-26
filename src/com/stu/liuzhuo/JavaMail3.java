package com.stu.liuzhuo;
/**
 * 
 * @author LiuZhuo
 * 
 * */
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class JavaMail3 {
	/**
	 * 创建并发送一封包含文本、图片、附件的复杂邮件
	 * @author LiuZhuo
	 **/
		//发件人的邮箱和密码（替换为自己的邮箱和密码）
		public static String myEmailAccount = "15232179903@163.com";
		public static String myEmailPassword = "lzjm123";		
		//发件人的SMTP服务器地址，必须准确，不同邮件服务器地址不同，一般格式为：smtp.xxx.com
		//网易163邮箱的SMTP服务器地址为：smtp.163.com
		public static String myEmailSMTPHost = "smtp.163.com";		
		//收件人邮箱
		public static String receiveMailAccount;	
		public static void main(){
		}
	/**
	 * 创建一封复杂邮件（文本+附件）
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * */
		public static MimeMessage sendMail(String receiver,String subject,String content) throws UnsupportedEncodingException, MessagingException {
			// TODO Auto-generated method stub
			 // 1. 创建参数配置, 用于连接邮件服务器的参数配置
	        Properties props = new Properties();                    // 参数配置
	        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
	        props.setProperty("mail.host", myEmailSMTPHost);        // 发件人的邮箱的 SMTP 服务器地址
	        props.setProperty("mail.smtp.auth", "true");            // 请求认证，参数名称与具体实现有关
	        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
	        Session session = Session.getDefaultInstance(props);
	        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
			//1.创建邮件对象
			MimeMessage message = new MimeMessage(session);			
			//2.From:发件人
			message.setFrom(new InternetAddress(myEmailAccount,"我的测试邮件—太公钓鱼","UTF-8"));
			
			//3.To:收件人
			message.addRecipient(RecipientType.TO,new InternetAddress(receiver,"我的测试邮件—太公钓鱼 ","UTF-8"));
			
			//4.Subject:邮件主题
			message.setSubject("TEST邮件主题（文本+图片+附件）","UTF-8");
			
			/**
			 * 下面是邮件内容的创建：
			 * */
			//6.创建文本“节点”
			MimeBodyPart text = new MimeBodyPart();						
			//9.创建附件节点
			MimeBodyPart attachment = new MimeBodyPart();
			DataHandler dh2 = new DataHandler(new FileDataSource("F:\\TestZip\\test-output.zip"));//读取本地文件
			attachment.setDataHandler(dh2);														//将附件数据添加到节点
			attachment.setFileName(MimeUtility.decodeText(dh2.getName()));						//设置附件的文件名（需要编码）
			
			//10.设置文本和附件的关系（合成一个大的混合节点，/Multipart）
			MimeMultipart mm = new MimeMultipart();
			mm.addBodyPart(attachment);			//如果有多个附件，可以创建多个多次添加
			mm.setSubType("mixed");				//混合关系
			
			//11.设置整个邮件的关系（将最红的混合节点作为邮件的内容添加到邮件对象）
			message.setContent(mm);
			
			//12.设置发件时间
			message.setSentDate(new Date());
			
			//13.保存上面的所有设置
			message.saveChanges();	
			return message;
		}
}
