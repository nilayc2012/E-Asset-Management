package com.beans;



import java.util.Hashtable;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Session Bean implementation class ProducerBean
 */
@Stateless(mappedName = "producerbean")
public class ProducerBean implements ProducerBeanRemote {

	@Override
	public String getAndSendMessage(String usermsg) {
		// TODO Auto-generated method stub
		try{
		Hashtable env = new Hashtable(); 
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory"); 
		env.put(Context.PROVIDER_URL, "t3://localhost:7001"); 
	    Context ic =new InitialContext(env);
	    
		QueueConnectionFactory qfac=(QueueConnectionFactory) ic.lookup("connectionFactory");
		QueueConnection qcon = qfac.createQueueConnection();
		 QueueSession qsession=qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE); 
		 Queue queue = (Queue) ic.lookup("TestQ"); 
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
