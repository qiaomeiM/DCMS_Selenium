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
	 * ����������һ������ı���ͼƬ�������ĸ����ʼ�
	 * @author LiuZhuo
	 **/
		//�����˵���������루�滻Ϊ�Լ�����������룩
		public static String myEmailAccount = "15232179903@163.com";
		public static String myEmailPassword = "lzjm123";		
		//�����˵�SMTP��������ַ������׼ȷ����ͬ�ʼ���������ַ��ͬ��һ���ʽΪ��smtp.xxx.com
		//����163�����SMTP��������ַΪ��smtp.163.com
		public static String myEmailSMTPHost = "smtp.163.com";		
		//�ռ�������
		public static String receiveMailAccount;	
		public static void main(){
		}
	/**
	 * ����һ�⸴���ʼ����ı�+������
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 * */
		public static MimeMessage sendMail(String receiver,String subject,String content) throws UnsupportedEncodingException, MessagingException {
			// TODO Auto-generated method stub
			 // 1. ������������, ���������ʼ��������Ĳ�������
	        Properties props = new Properties();                    // ��������
	        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
	        props.setProperty("mail.host", myEmailSMTPHost);        // �����˵������ SMTP ��������ַ
	        props.setProperty("mail.smtp.auth", "true");            // ������֤���������������ʵ���й�
	        // 2. �������ô����Ự����, ���ں��ʼ�����������
	        Session session = Session.getDefaultInstance(props);
	        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
			//1.�����ʼ�����
			MimeMessage message = new MimeMessage(session);			
			//2.From:������
			message.setFrom(new InternetAddress(myEmailAccount,"�ҵĲ����ʼ���̫������","UTF-8"));
			
			//3.To:�ռ���
			message.addRecipient(RecipientType.TO,new InternetAddress(receiver,"�ҵĲ����ʼ���̫������ ","UTF-8"));
			
			//4.Subject:�ʼ�����
			message.setSubject("TEST�ʼ����⣨�ı�+ͼƬ+������","UTF-8");
			
			/**
			 * �������ʼ����ݵĴ�����
			 * */
			//6.�����ı����ڵ㡱
			MimeBodyPart text = new MimeBodyPart();						
			//9.���������ڵ�
			MimeBodyPart attachment = new MimeBodyPart();
			DataHandler dh2 = new DataHandler(new FileDataSource("F:\\TestZip\\test-output.zip"));//��ȡ�����ļ�
			attachment.setDataHandler(dh2);														//������������ӵ��ڵ�
			attachment.setFileName(MimeUtility.decodeText(dh2.getName()));						//���ø������ļ�������Ҫ���룩
			
			//10.�����ı��͸����Ĺ�ϵ���ϳ�һ����Ļ�Ͻڵ㣬/Multipart��
			MimeMultipart mm = new MimeMultipart();
			mm.addBodyPart(attachment);			//����ж�����������Դ������������
			mm.setSubType("mixed");				//��Ϲ�ϵ
			
			//11.���������ʼ��Ĺ�ϵ�������Ļ�Ͻڵ���Ϊ�ʼ���������ӵ��ʼ�����
			message.setContent(mm);
			
			//12.���÷���ʱ��
			message.setSentDate(new Date());
			
			//13.�����������������
			message.saveChanges();	
			return message;
		}
}
