package com.stu.qiaomei;

import java.io.FileOutputStream;
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

import org.openqa.jetty.servlet.SessionDump;

	/**
	 * ����������һ������ı���ͼƬ�������ĸ����ʼ�
	 *
	 */
	public class SendPicEmail {
		public static void sendEmail(String receiveAccount,String Subject) throws UnsupportedEncodingException, MessagingException{
	    // �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
	    String myEmailAccount = "my_stage_qm@sina.com";
	    String myEmailPassword = "qm1995";

	    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ���ʽΪ: smtp.xxx.com
	    // ����163����� SMTP ��������ַΪ: smtp.163.com
	    String myEmailSMTPHost = "smtp.sina.com";

	    // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
	    String receiveMailAccount = receiveAccount;

	        // 1. ������������, ���������ʼ��������Ĳ�������
	        Properties props = new Properties();                    // ��������
	        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
	        props.setProperty("mail.host", myEmailSMTPHost);        // �����˵������ SMTP ��������ַ
	        props.setProperty("mail.smtp.auth", "true");            // ������֤���������������ʵ���й�

	        // 2. �������ô����Ự����, ���ں��ʼ�����������
	        Session session = Session.getDefaultInstance(props);
	        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

	        // 3. ����һ���ʼ�
	        // 3.1 �����ʼ�����
	        MimeMessage message = new MimeMessage(session);
	        // 3.2 From: ������
	        String sendMail = null;
	        message.setFrom(new InternetAddress(sendMail, "QiaoMomo", "UTF-8"));
	        // 3.3 To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        String receiveMail = null;
	        message.addRecipient(RecipientType.TO, new InternetAddress(receiveMail, "QiaoMei", "UTF-8"));
	        // 3.4 Subject: �ʼ�����
	        message.setSubject("���Ա���", "UTF-8");

	        /*
	         * �������ʼ����ݵĴ���:
	         */

	        //3.5 ����ͼƬ���ڵ㡱
	        MimeBodyPart image = new MimeBodyPart();
	        DataHandler dh = new DataHandler(new FileDataSource("D:/20161220-174105.jpg")); // ��ȡ�����ļ�
	        image.setDataHandler(dh);                   // ��ͼƬ������ӵ����ڵ㡱
	        image.setContentID("image_wallpaper");     // Ϊ���ڵ㡱����һ��Ψһ��ţ����ı����ڵ㡱�����ø�ID��

	        // 3.6 �����ı����ڵ㡱
	        MimeBodyPart text = new MimeBodyPart();
	        //�������ͼƬ�ķ�ʽ�ǽ�����ͼƬ�������ʼ�������, ʵ����Ҳ������ http ���ӵ���ʽ�������ͼƬ
	        text.setContent("���Խ��<br/><img src='cid:image_wallpaper'/>", "text/html;charset=UTF-8");

	        // 3.7 ���ı�+ͼƬ������ �ı� �� ͼƬ ���ڵ㡱�Ĺ�ϵ���� �ı� �� ͼƬ ���ڵ㡱�ϳ�һ����ϡ��ڵ㡱��
	        MimeMultipart mm_text_image = new MimeMultipart();
	        mm_text_image.addBodyPart(text);
	        mm_text_image.addBodyPart(image);
	        mm_text_image.setSubType("related");    // ������ϵ

	        // 3.8 �� �ı�+ͼƬ �Ļ�ϡ��ڵ㡱��װ��һ����ͨ���ڵ㡱
	        //    ������ӵ��ʼ��� Content ���ɶ�� BodyPart ��ɵ� Multipart, ����������Ҫ���� BodyPart,
	        //    ����� mm_text_image ���� BodyPart, ����Ҫ�� mm_text_image ��װ��һ�� BodyPart
	        MimeBodyPart text_image = new MimeBodyPart();
	        text_image.setContent(mm_text_image);

	        // 3.9 �����������ڵ㡱
	        MimeBodyPart attachment = new MimeBodyPart();
	        DataHandler dh2 = new DataHandler(new FileDataSource("D:/Eclipse/Project_DCMS/test-output/TestResult.html"));  // ��ȡ�����ļ�
	        attachment.setDataHandler(dh2);                                             // ������������ӵ����ڵ㡱
	        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));              // ���ø������ļ�������Ҫ���룩

	        // 3.10 ���ã��ı�+ͼƬ���� ���� �Ĺ�ϵ���ϳ�һ����Ļ�ϡ��ڵ㡱 / Multipart ��
	        MimeMultipart mm = new MimeMultipart();
	        mm.addBodyPart(text_image);
	        mm.addBodyPart(attachment);     // ����ж�����������Դ������������
	        mm.setSubType("mixed");         // ��Ϲ�ϵ

	        // 3.11 ���������ʼ��Ĺ�ϵ�������յĻ�ϡ��ڵ㡱��Ϊ�ʼ���������ӵ��ʼ�����
	        message.setContent(mm);

	        // 3.12 ���÷���ʱ��
	        message.setSentDate(new Date());

	        // 3.13 �����������������
	        message.saveChanges();


	        // Ҳ���Ա��ֵ����ز鿴
	        // message.writeTo(file_out_put_stream);

	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();

	        // 5. ʹ�� �����˺� �� ���� �����ʼ�������
	        //    ������֤����������� message �еķ���������һ�£����򱨴�
	        transport.connect(myEmailAccount, myEmailPassword);

	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());

	        // 7. �ر�����
	        transport.close();
	    }
//		public static void main(args[]){
//			sendEmail("1075994955@qq.com", "Test Result");
//		}
	}

