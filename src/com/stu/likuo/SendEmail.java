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
	// �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
    public static String myEmailAccount = "likuo139329@sina.com";
    public static String myEmailPassword = "likuo139329";
    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ���ʽΪ: smtp.xxx.com
    // ����163����� SMTP ��������ַΪ: smtp.163.com
    public static String myEmailSMTPHost = "smtp.sina.com";
 
    public static MimeMessage sendMail(String receiver,String subject,String content) throws Exception{
		 // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.host", myEmailSMTPHost);        // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ������֤���������������ʵ���й�

    	 Session session = Session.getDefaultInstance(props);
         session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
    	MimeMessage message = new MimeMessage(session);
    	// 2. From: ������
        message.setFrom(new InternetAddress(myEmailAccount, "����", "UTF-8"));
     // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver, "���", "UTF-8"));
    	   // 4. Subject: �ʼ�����
        message.setSubject(subject, "UTF-8");
    	 message.setContent(content, "text/html;charset=UTF-8");
    	// 6. ���÷���ʱ��
         message.setSentDate(new Date());
         // 4. ���� Session ��ȡ�ʼ��������
         Transport transport = session.getTransport();
         // 5. ʹ�� �����˺� �� ���� �����ʼ�������
         //    ������֤����������� message �еķ���������һ�£����򱨴�
         transport.connect(myEmailAccount, myEmailPassword);

         // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
         transport.sendMessage(message, message.getAllRecipients());

         // 7. �ر�����
         transport.close();
         return message;
    }
   public static void main(String args[]) throws Exception{
    	  sendMail("2631524571@qq.com","���","��γɹ���");
   }
}

