package com.skysoft.restapi.restapiproject.hello;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	MessageSource messageSource;
	
	public HelloController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@GetMapping(path = "/hello")
	public String getHello() {
		return "hello world";
	}
		

	@GetMapping(path = "/hello-i18n")
	public String getHelloIN() {
				Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,"Default", locale);

	}
	
	@GetMapping(path = "/hello-bean")
	public HelloBean getHelloBean() {
		return new HelloBean("Hello");
	}
	
	@GetMapping(path="/hello/{name}")
	public HelloBean hello(@PathVariable String name) {
		
		return new HelloBean(String.format("Hello %s",name));
	}
	
	
	
	
	
}
