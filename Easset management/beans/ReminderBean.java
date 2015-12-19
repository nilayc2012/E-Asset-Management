package com.beans;

import java.util.Hashtable;

import javax.ejb.Stateless;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

@Stateless(mappedName="ReminderBean")
public class ReminderBean implements ReminderBeanInterface
{

	@Override
	public String getAndSendMessage(String usermsg) 
	{
		try{
			Hashtable env = new Hashtable(); 
			env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory"); 
			env.put(Context.PROVIDER_URL, "t3://localhost:7001"); 
		    Context ic =new InitialContext(env);
		    
			QueueConnectionFactory qfac=(QueueConnectionFactory) ic.lookup("connectionFactory1");
			QueueConnection qcon = qfac.createQueueConnection();
			 QueueSession qsession=qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE); 
			 Queue queue = (Queue) ic.lookup("RemQ"); 
			 QueueSender qsender=qsession.createSender(queue);
			 TextMessage msg = qsession.createTextMessage(); 
			 msg.setText(usermsg);
			 qsender.send(msg);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return "done";
	}
	
}
