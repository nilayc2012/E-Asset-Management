package com.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable; 

import javax.jms.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 

import javax.ejb.MessageDriven; 
import javax.jms.JMSException; 
import javax.jms.Message; 
import javax.jms.MessageListener; 
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage; 
import javax.ejb.ActivationConfigProperty; 
@MessageDriven( 
activationConfig = { 
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") , 
@ActivationConfigProperty(propertyName="connectionFactoryJndiName",propertyValue="connectionFactory1"), 
@ActivationConfigProperty(propertyName="destinationJndiName", propertyValue="RemQ") 
} 
,mappedName="RemQ" 
) 
public class ReminderConsumer implements MessageListener
{
	public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory"; 
	public final static String JMS_FACTORY="connectionFactory1"; 
	public final static String QUEUE="RemQ"; 
	private QueueConnectionFactory qconFactory; 
	private QueueConnection qcon; 
	private QueueSession qsession; 
	private QueueReceiver qreceiver; 
	private Queue queue; 
	private boolean quit = false; 

	public void onMessage(Message msg) 
	{ 
		try 
		{ 
			String msgText; 
			synchronized (this) {
				
			
			if (msg instanceof TextMessage) 
			{ 
				msgText = ((TextMessage)msg).getText(); 
			} 
			else 
			{ 
				msgText = msg.toString(); 
			} 

			String message=msgText;
			System.out.println(message);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select username from borrower");
			CallableStatement cstmt=con.prepareCall("{call due_opr(?)}");
			while(rs.next())
			{
				String username=rs.getString(1);
				cstmt.setString(1,username);
				cstmt.execute();
			}
		}}
	catch (JMSException jmse) 
	{ 
	jmse.printStackTrace(); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	}
	
	public void init(Context ctx, String queueName) throws NamingException, JMSException 
	{ 
	qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY); 
	qcon = qconFactory.createQueueConnection(); 
	qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE); 
	queue = (Queue) ctx.lookup(queueName); 
	qreceiver = qsession.createReceiver(queue); 
	qreceiver.setMessageListener(this); 
	qcon.start(); 
	} 

	public void close()throws JMSException 
	{ 
	qreceiver.close(); 
	qsession.close(); 
	qcon.close(); 
	} 

	} 


