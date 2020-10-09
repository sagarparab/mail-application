package com.java.mail.javasendmailapplication.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDaoImpl implements EmailDaoI{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailDaoImpl.class);
	
	private static final String ADD_EMAIL = "insert into EMAIL_APPLICATION(USER_NAME,SURNAME,RAISETIME,REFNUMBER ) values(?,?,sysdate,?)";

	@Override
	public String sendMailSave(String userName, String surname, String raisedDateTime, String refNOandDate) {

		String response = "";
		logger.info(" EmailDaoImpl sendMailSave() starts");
		try {
			Object[] param = { userName, surname, raisedDateTime, refNOandDate};
			int count = jdbcTemplate.update(ADD_EMAIL, param);
			if (count > 0) {
				response = "SUCCESS";
			} else {
				response = null;
			}
		} catch (Exception e) {
			logger.info("EmailDaoImpl sendMailSave()" + e.getMessage());
		}
		logger.info("sendMailSave() End");
		return response;
	
	}

}
