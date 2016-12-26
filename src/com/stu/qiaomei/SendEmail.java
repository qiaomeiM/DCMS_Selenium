/**
 * ���ܣ������ʼ�
 */
package com.stu.qiaomei;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;	

public class SendEmail {
	
    public static void send(String receiveAccount,String emailSubject,String emailContent) throws Exception {
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

        // 3.1 ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

        // 3.2 From: ������
        message.setFrom(new InternetAddress("my_stage_qm@sina.com", "SIXTY__ONE", "UTF-8"));

        // 3.3 To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveAccount, "Solum omnium lumen", "UTF-8"));

        // 3.4 Subject: �ʼ�����
        message.setSubject(emailSubject, "UTF-8");

		// 3.5 Content: �ʼ����ģ�����ʹ��html��ǩ��
        message.setContent(emailContent, "text/html;charset=UTF-8");
        
        // 3.6 ���÷���ʱ��
        message.setSentDate(new Date());

        // 3.7 ��������
        message.saveChanges();

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
}