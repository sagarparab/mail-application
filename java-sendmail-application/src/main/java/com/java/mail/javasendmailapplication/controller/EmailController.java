package com.java.mail.javasendmailapplication.controller;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.mail.javasendmailapplication.service.EmailService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/mail")
public class EmailController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	EmailService emailService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public JSONObject sendMail(@RequestBody JSONObject output) {
		JSONObject json = new JSONObject();
		JSONObject encrypttDataResponse = new JSONObject();
		JSONObject encrypttData = new JSONObject();
		String sendMailResponse = "";
		logger.info("EmailController sendMail() start");
		try {
				String userName = (String) output.get("userName");
				String Surname = (String) output.get("surname");
				

				if ((!userName.isEmpty() && userName != null) && (!Surname.isEmpty() && Surname != null)) {
					
					sendMailResponse = emailService.sendMail(userName, Surname );
					logger.info("sendMailResponse====" +sendMailResponse);
					if (!sendMailResponse.isEmpty() && !("RECORDNOTSAVED").equals(sendMailResponse)
							&& !("RECORDEXIST").equals(sendMailResponse)) {
						json.put("status", "SUCCESS");
						json.put("refNo", sendMailResponse);
						json.put("statusDesc",
								"Your mail has been raised successfull : " + sendMailResponse);
					} else if (("RECORDNOTSAVED").equals(sendMailResponse)) {
						json.put("status", "FAILURE");
						json.put("errorDesc", "Due to technical issue unable to process your request");
					} else if (("RECORDEXIST").equals(sendMailResponse)) {
						json.put("status", "FAILURE");
						json.put("errorDesc", "Duplicate Request");
					}
				} else {
					json.put("status", "FAILURE");
					json.put("errorDesc", "Please enter all mandatory values");
				}
			
		} catch (Exception e) {
			logger.info("EmailController sendMail() Exception" + e.getMessage());
			json.put("status", "FAILURE");
			json.put("errorDesc", "Due to technical issue unable to process your request");
		}
		logger.info("EmailController sendMail() json : " + json);
	
		encrypttData.put("data", json);
	
		logger.info("EmailController sendMail() encrypttDataResponse : " + encrypttDataResponse);
		logger.info("EmailController sendMail() End");
		return encrypttData;
	}


}
