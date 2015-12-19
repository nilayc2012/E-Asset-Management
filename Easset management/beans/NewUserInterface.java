package com.beans;

import javax.ejb.Remote;
@Remote
public interface NewUserInterface 
{
	public String storeInDB(String username,String password,String userType);
}
