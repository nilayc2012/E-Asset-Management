package com.beans;


import javax.ejb.Remote;

@Remote
public interface ProducerBeanRemote {
	
	public String getAndSendMessage(String msg);

}
