package com.rahul.jms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCaller {
public static void main(String[] args) {
	ApplicationContext factory = new ClassPathXmlApplicationContext("SIBeanConfig.xml");
	MessageConsumer sender = (MessageConsumer) factory.getBean("messageConsumer");
	
	
	
//	Map map =	(Map) sender.receive();
//	System.out.println("received"+map.get("Name"));
	while(true){
	System.out.println("received"+sender.receive());
	}
}
}