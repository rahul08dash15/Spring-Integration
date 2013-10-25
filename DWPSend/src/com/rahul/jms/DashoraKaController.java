package com.rahul.jms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashoraKaController {

@RequestMapping("/")	
	public String home() throws NamingException, JMSException{
	System.out.println("home");
	System.out.println("In home");
	ApplicationContext factory = new ClassPathXmlApplicationContext("SIBeanConfig.xml");
	MessageSender sender = (MessageSender) factory.getBean("messageSender");
	Map map = new HashMap();
	System.out.println("Calling");
	map.put("Name", "Why God Why");
	sender.send(map);

	
/*	InitialContext initCtx = new InitialContext();
	Context envContext = (Context) initCtx.lookup("java:comp/env");
	ConnectionFactory connectionFactory = (ConnectionFactory) envContext.lookup("jms/ConnectionFactory");
	Connection connection = connectionFactory.createConnection();
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	Destination destination = session.createTopic("jms/topic/MyTopic");
	MessageProducer producer = session.createProducer(destination);
	TextMessage msg=session.createTextMessage();
	msg.setText("Message sent");
	producer.send(msg);*/

	
	
	System.out.println("Call ho gaya");
		return "home";
	}


}
