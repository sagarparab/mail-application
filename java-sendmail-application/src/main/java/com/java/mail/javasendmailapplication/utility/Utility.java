package com.java.mail.javasendmailapplication.utility;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Utility {
	
		private static final Logger LOGGER = Logger.getLogger(Utility.class);
		
		
		private static final String ALPHANUMERICSTRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		public static String generateRandomAlphaNumericCode(int count) {
			SecureRandom secureRandom=new SecureRandom();
			StringBuilder builder = new StringBuilder();
			int startcount = count;
			while (startcount-- != 0) {
				LOGGER.info("Utility generateRandomAlphaNumericCode() Strat");
				try {
					int number = secureRandom.nextInt(ALPHANUMERICSTRING.length());
					builder.append(ALPHANUMERICSTRING.charAt(number));
				} catch (Exception e) {
					LOGGER.info("Utility Exception at generateRandomAlphaNumericCode()"+e.getMessage());
				}
			}
			LOGGER.info("Utility generateRandomAlphaNumericCode() End");
			return builder.toString();
		}
		
		public static String getCurrentDateTime(String Pattern) {
			String strDate="";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Pattern);
	    	LocalDateTime now = LocalDateTime.now();
	    	strDate=dtf.format(now);
			return strDate.toString();
		}	
}


