package com.java.mail.javasendmailapplication.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.java.mail.javasendmailapplication.dao.EmailDaoI;
import com.java.mail.javasendmailapplication.model.EmailDTO;
import com.java.mail.javasendmailapplication.utility.Utility;

@Service
public class EmailServiceImpl implements EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private EmailDaoI emailDao;
	
	/** The email sender. */
	@Autowired
	public JavaMailSender emailSender;

	@Value("${bcc.mail.id}")
	private String yonoBccMailId;

	@Value("${from.mail.id}")
	private String yonoFromMailId;

	@Value("${cms.mail.id}")
	private String yonoCMSMailId;


	
	
	@Override
	public String sendMail(String userName, String surname) {

		String response = "";
		//EmailDTO email = new EmailDTO();
		logger.info("EmailServiceImpl sendMail() Start");
		try {
			
			
			String refNo = Utility.generateRandomAlphaNumericCode(4);
			String date = Utility.getCurrentDateTime("dd-MMM-yy");
			String raisedDateTime = Utility.getCurrentDateTime("dd/MM/yyyy");
			
			String toEmailId = null;
			String emailId = null;
			String senderKey = null;
			String ReceiverKey = null;
			
			String body = null;
			String refNOandDate = refNo + date;
			
			Map<String , String> sender = new HashMap<>();
			sender.put("1", "testing20201011@gmail.com");
			sender.put("2", "testing20201012@gmail.com");
			sender.put("3", "testing20201013@gmail.com");
			sender.put("4", "testing20201014@gmail.com");
			sender.put("5", "testing20201015@gmail.com");
			
			//This mails and bosy should come from the database
			Map<String , String> receiver = new HashMap<>();
			receiver.put("1", "testing20201011@yahoo.com");
			receiver.put("2", "testing20201012@yahoo.com");
			receiver.put("3", "testing20201013@yahoo.com");
			receiver.put("4", "testing20201014@yahoo.com");
			receiver.put("5", "testing20201015@yahoo.com");
			
			Map<String , String> mailBody = new HashMap<>();
			receiver.put("1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris leo risus, malesuada pretium enim at, mollis fermentum est. Aliquam magna diam, fermentum eget consequat varius, accumsan non lacus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget nisi pellentesque, mollis lectus gravida, egestas leo. Suspendisse rutrum nunc eget purus eleifend, ut cursus turpis consequat. Mauris vulputate ultrices ante, non tempus mi efficitur ut. Aenean a ante scelerisque, fringilla sapien vitae, dictum leo. Nam vel ullamcorper purus. Curabitur vestibulum felis id urna euismod volutpat. Cras iaculis bibendum lorem, hendrerit gravida enim fermentum ornare. Nullam est tortor, ultrices non malesuada vel, cursus sed tortor. Praesent id purus elementum, rhoncus enim sed, luctus mauris.");
			receiver.put("2", "Curabitur quis semper dolor, vel mattis lorem. Aenean elit dolor, egestas at malesuada ac, pulvinar sit amet arcu. Nam finibus urna ac turpis convallis, vitae sodales nisi cursus. Donec eleifend ullamcorper est, eget efficitur sapien eleifend nec. Mauris auctor erat at tellus aliquam gravida tempor fermentum sapien. Etiam non congue lacus. Vestibulum hendrerit justo at libero ultricies, quis laoreet turpis accumsan. Praesent ut sem vel erat posuere ultricies. Vestibulum lacinia malesuada nisi, ut dapibus justo eleifend quis. Aliquam erat volutpat.");
			receiver.put("3", "Nunc vel volutpat magna, at venenatis ligula. In malesuada non arcu efficitur gravida. Etiam malesuada mauris id consectetur dapibus. Nam molestie leo eget libero sodales, non ullamcorper dolor condimentum. Donec sed turpis dui. Suspendisse a dapibus purus. Nunc metus nunc, convallis quis gravida et, pellentesque sit amet orci. Maecenas gravida hendrerit tincidunt. Ut scelerisque et orci ut commodo. Fusce vitae mollis nibh. Donec a mauris sagittis eros imperdiet euismod. Duis et lacus urna. Sed lacinia scelerisque ullamcorper.");
			receiver.put("4", "Vestibulum nec nunc urna. Integer egestas est ac aliquam fermentum. Morbi egestas nisi eu quam viverra, vitae fermentum mauris mattis. Integer et sapien urna. Proin et leo scelerisque, venenatis est non, hendrerit urna. Maecenas ut sodales ipsum. Suspendisse vehicula odio at ligula interdum, ut sodales lacus vulputate. Mauris egestas metus sed pellentesque eleifend. Morbi lacinia mauris sed aliquam efficitur. Nulla sed finibus ligula. Aliquam id massa nisl. Fusce a orci vehicula, imperdiet mauris nec, cursus metus. Proin rhoncus tincidunt dui et viverra. Nulla facilisi.");
			receiver.put("5", "Morbi magna diam, aliquam a luctus quis, interdum vitae ipsum. Ut eget tortor risus. Vivamus eu nibh sagittis, consectetur diam et, euismod mi. Suspendisse ultrices lorem et massa ornare, vitae laoreet odio condimentum. Duis et felis vel arcu lacinia sollicitudin. Aenean vel odio felis. Etiam blandit velit eros, et dapibus ante ultrices ac. Integer posuere eu urna cursus sagittis. Quisque mattis feugiat ligula ultricies facilisis. Ut nec quam nec dui commodo pretium rhoncus a magna. Pellentesque mauris augue, cursus ac augue id, efficitur vestibulum erat. Vestibulum nec lacus eu orci elementum ullamcorper. Donec et eros at lorem egestas laoreet et eget justo. Proin volutpat, tellus eu imperdiet luctus, ex nibh laoreet leo, at tincidunt lorem risus accumsan urna.");
			
			 for (Map.Entry me : sender.entrySet()) {
				 emailId = me.getValue().toString();
				 body = mailBody.get(me.getKey().toString());
		          for (Map.Entry me1 : receiver.entrySet()) {
		        	  toEmailId = me1.getValue().toString();
			          sendMailToUser(userName, surname,raisedDateTime,refNOandDate,emailId,body,toEmailId,me.getKey().toString() ,me1.getKey().toString());
						String daoResponse = emailDao.sendMailSave(userName, surname,raisedDateTime,refNOandDate);
						if (daoResponse != null) {
							response = refNOandDate;
						} else {
							response = "RECORDNOTSAVED";
						}
			        }
		        }

				// Sending mail to User
				
		} catch (Exception e) {
			logger.info("EmailServiceImpl sendMail()" + e.getMessage());
		}
		logger.info("EmailServiceImpl sendMail() End");
		return response;
	
	}
	private void sendMailToUser(String userName, String surname, String raisedDateTime, String refNOandDate,String emailId , String body ,String toEmailId,String senderKey ,String ReceiverKey) {

		logger.info("EmailServiceImpl sendMailToUser(): Start");
		EmailDTO email = new EmailDTO();
		email.setTo(toEmailId);
		email.setFrom(emailId);
		email.setHTMLContent(true);
		email.setSubject("Sender name : "+senderKey +" "+ userName +" "+ surname +" "+ReceiverKey);
		email.setBody(body);

		// Sending Mail
		sendMail(email);
		logger.info("EmailServiceImpl sendMailToUser(): End");
		
	
		
	}
	private void sendMail(EmailDTO email) {
		logger.info("Inside sendMail()");
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String fromEmailId = email.getFrom();
			String toEmailId = email.getTo();
			String bccEmailId = email.getBcc();
			String ccEmailId = email.getCc();
			helper.setFrom(fromEmailId);
			helper.setTo(toEmailId);
			if ((ccEmailId != null && ccEmailId != "") && !toEmailId.equals(ccEmailId)) {
				helper.setCc(ccEmailId);
			} else {
				logger.info("No CC email id provided.");
			}
			helper.setBcc(bccEmailId);
			helper.setSubject(email.getSubject());
			helper.setText(email.getBody(), email.isHTMLContent());
			logger.info("Sending email, From: " + fromEmailId + ", To: " + toEmailId + ", BCC: " + bccEmailId + ", CC: "
					+ ccEmailId);
			emailSender.send(message);
			logger.info("Email sent successfully.");
		} catch (MailException | MessagingException ex) {
			logger.error("Exception while sending email: " + ex);
		}
		logger.info("Exit sendMail()");
	}

}
