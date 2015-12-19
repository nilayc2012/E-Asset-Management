package com.beans;

import javax.ejb.Remote;

@Remote
public interface LoginInterface 
{
	public boolean checkUser(String username,String password,String userType);
}
