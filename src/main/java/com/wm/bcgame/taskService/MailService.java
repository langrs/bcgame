package com.wm.bcgame.taskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author LZM
 * @description
 * @date 10:23 2018/9/19
 * @mondified
 **/
@Service
public class MailService {
	private static Logger logger = LoggerFactory.getLogger(MailService.class);
	@Autowired
	JavaMailSender mailSender;

//	@Autowired
//	TemplateEngine templateEngine;

	public boolean sendSimpleEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content)  {

		long startTimestamp = System.currentTimeMillis();
		logger.info("Start send mail to {}",receiver);

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(deliver);
			message.setTo(receiver);
			message.setCc(carbonCopy);
			message.setSubject(subject);
			message.setText(content);
			mailSender.send(message);
			logger.info("Send mail success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
			return true;
		} catch (MailException e) {
			logger.error("Send mail failed, error message is : {} \n", e.getMessage());
			e.printStackTrace();
			return false;
//			throw e;
		}
	}

}
