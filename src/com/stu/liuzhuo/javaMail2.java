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
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class javaMail2 {
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
	
	//�ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
	public static String receiveMailAccount = "15232179903@163.com";
	
	
	public static void main(String[] args) throws Exception{
		//1.�����������ã����������ʼ��������Ĳ�������
		Properties props = new Properties();						//��������
		props.setProperty("mail.transport.protocol", "smtp");		//ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.setProperty("mail.host", myEmailSMTPHost);			//�����˵������SMTP��������ַ
		props.setProperty("mail.smtp.auth", "true");				//������֤���������������ʵ���й�
		
		//2.�������ô����ػ��������ں��ʼ�����������
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); 									//����λdebugģʽ�����Բ鿴��ϸ�ķ���log
		
		//3.����һ���ʼ�
		MimeMessage message = createMimeMessage(session,myEmailAccount,receiveMailAccount);
		//Ҳ���Ա��浽���ز鿴
		//message.writeTo(file_out_put_stream);
		
		//4.����Session ��ȡ�ʼ��������
		Transport transport = session.getTransport();
		
		//5.ʹ�������˺ź����������ʼ�������
		//	������֤�����������message�еķ���������һֱ�����򱨴�
		transport.connect(myEmailAccount,myEmailPassword);
		
		//6.�����ʼ����������е��ռ���ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ��ˣ������ˣ�������
		transport.sendMessage(message,message.getAllRecipients());
		
		//7.�ر�����
		transport.close();	
	}
/**
 * ����һ�⸴���ʼ����ı�+ͼƬ+������
 * @throws MessagingException 
 * @throws UnsupportedEncodingException 
 * */
	private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		//1.�����ʼ�����
		MimeMessage message = new MimeMessage(session);
		
		//2.From:������
		message.setFrom(new InternetAddress(sendMail,"�ҵĲ����ʼ���̫������","UTF-8"));
		
		//3.To:�ռ���
		message.addRecipient(RecipientType.TO,new InternetAddress(receiveMail,"�ҵĲ����ʼ���̫������ ","UTF-8"));
		
		//4.Subject:�ʼ�����
		message.setSubject("TEST�ʼ����⣨�ı�+ͼƬ+������","UTF-8");
		
		/**
		 * �������ʼ����ݵĴ�����
		 * */
		//5.����ͼƬ���ڵ㡱
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("D:\\1myschool\\1.jpg"));	//��ȡ�����ļ�
		image.setDataHandler(dh); 					//��ͼƬ������ӵ����ڵ㡱
		image.setContentID("image_fairy_tail");		//Ϊ���ڵ㡱����һ��Ψһ�ı�ţ����ı����ڵ㡱�����ø�ID��
		
		//6.�����ı����ڵ㡱
		MimeBodyPart text = new MimeBodyPart();
		//�������ͼƬ�ķ�ʽ�ǽ�����ͼƬ�������ʼ������У�ʵ����Ҳ������http���ӵ���ʽ�������ͼƬ
		text.setContent("����һ��ͼƬ<br/><img src='cid:image_fairy_tail'/>","text/html;charset=UTF-8");
		
		//7.���ı�+ͼƬ�������ı���ͼƬ���ڵ㡱�Ĺ�ϵ�����ı���ͼƬ���ڵ㡱�ϳ�һ����ϡ��ڵ㡱��
		MimeMultipart mm_text_image = new MimeMultipart ();
		mm_text_image.addBodyPart(text);
		mm_text_image.addBodyPart(image);
		mm_text_image.setSubType("related"); 	//������ϵ
		
		//8.���ı�+ͼƬ �Ļ�Ͻڵ㣬��װ��һ����ͨ�ڵ�
		//	������ӵ��ʼ���Content���ɶ��BodyPart��ɵ�Multipart������������Ҫ����BodyPart
		//	 ����� mm_text_image ���� BodyPart, ����Ҫ�� mm_text_image ��װ��һ�� BodyPart
		MimeBodyPart text_image = new MimeBodyPart();
		text_image.setContent(mm_text_image);
		
		//9.���������ڵ�
		MimeBodyPart attachment = new MimeBodyPart();
		DataHandler dh2 = new DataHandler(new FileDataSource("D:\\1myschool\\����A��.docx"));//��ȡ�����ļ�
		attachment.setDataHandler(dh2);														//������������ӵ��ڵ�
		attachment.setFileName(MimeUtility.decodeText(dh2.getName()));						//���ø������ļ�������Ҫ���룩
		
		//10.���ã��ı�+ͼƬ���͸����Ĺ�ϵ���ϳ�һ����Ļ�Ͻڵ㣬/Multipart��
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text_image);
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
