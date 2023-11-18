package com.skysoft.restapi.restapiproject.hello;

import java.beans.JavaBean;


public class HelloBean {
private String msg;

public HelloBean(String msg) {
	this.msg=msg;
}


public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}


@Override
	public String toString() {
	return "HelloWorldBean [msg=" + msg + "]";
	}

}
