package com.skysoft.restapi.restapiproject.hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	
	@GetMapping(path = "/hello")
	public String getHello() {
		return "hello world";
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
