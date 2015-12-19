package com.beans;

import javax.ejb.Stateless;
import java.sql.*;
@Stateless(mappedName="checkuser")
public class LoginBean implements LoginInterface
{

	@Override
	public boolean checkUser(String username, String password, String userType) 
	{
		boolean flag=false;
		try
		{
			int count=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) from user_details where username='"+username+"' and password='"+password+"' and usertype='"+userType+"'");
			if(rs.next())
			{
				count=rs.getInt(1);
				if(count!=0)
				{
					flag=true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
}
