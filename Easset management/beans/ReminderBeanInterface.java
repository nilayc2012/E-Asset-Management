package com.beans;

import javax.ejb.Remote;
@Remote
public interface ReminderBeanInterface 
{
	public String getAndSendMessage(String msg);
}
