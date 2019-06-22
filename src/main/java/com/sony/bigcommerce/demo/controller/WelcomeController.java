package com.sony.bigcommerce.demo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	Logger logger = LoggerFactory.getLogger(WelcomeController.class);
@Autowired	 
MessageSource messageSource;

@RequestMapping("/")
public String root ()
{
	logger.info("testing messages " + messageSource.getMessage("test.message",null,  Locale.ENGLISH));
	return messageSource.getMessage("test.message",null,  Locale.ENGLISH);
	
}
}
