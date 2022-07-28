package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.context.Constants;


/**
 *
 * @author Omprakash darsi
 */

public class EmailConfig{
	
	public static String dateName = null;

	public static Boolean  ReportEmail() throws Exception {
		boolean sendMail = Boolean.parseBoolean(TestProperties.getProperty("mail.sendmail"));
		if (sendMail) {
			LoggerUtil.info("Sending Mail.............................");
			dateName = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
			String host = TestProperties.getProperty("mail.host");
			String port = TestProperties.getProperty("mail.port");
			String Password = TestProperties.getProperty("mail.password");
			String from = TestProperties.getProperty("mail.user");
			String toAddress =TestProperties.getProperty("mail.to");
			String ccAddress =TestProperties.getProperty("mail.cc");
			String filename1 =  System.getProperty("user.dir") + "/ExtentReports/AutomationTestReport.html";
			String mailSubject = Constants.MAIL_SUBJECT;
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.socketFactory.port" , port);
			props.put("mail.smtp.starttls.enable" , "true");
			props.put("mail.smtp.ssl.trust", host);
			Session session = Session.getInstance(props, null);
			//session.setDebug(true);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress( TestProperties.getProperty("mail.from")));
			message.setRecipients(Message.RecipientType.TO, toAddress);
			message.setRecipients(Message.RecipientType.CC, ccAddress);
			message.setSubject(mailSubject + " | " + new SimpleDateFormat("MM-dd-yyyy").format(new Date()));

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Dear Team," + '\n' + '\n' + "Pls, find the attached Automation Test Report Summary for your reference." +'\n' + '\n' + '\n'+ "Kindly, download to view the report" );
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			BodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source2 = new FileDataSource(filename1);
			messageBodyPart2.setDataHandler(new DataHandler(source2));
			messageBodyPart2.setFileName("JinglebidTestAutomationReport.html");
			multipart.addBodyPart(messageBodyPart2);

			message.setContent(multipart);

			try {
				Transport tr = session.getTransport("smtp");
				tr.connect(host,from, Password);
				tr.sendMessage(message, message.getAllRecipients());
				LoggerUtil.info("Mail Sent Successfully");
				tr.close();
				return true;
			} catch (SendFailedException e) {
				System.out.println(e.getMessage());
				LoggerUtil.error("Mail NOT Sent Successfully");
				return false;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			LoggerUtil.info("Mail sending toggel is set to false");
			return false;
		}
	}
  
}