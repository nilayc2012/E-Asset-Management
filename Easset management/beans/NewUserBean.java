package com.beans;
import java.sql.*;
import javax.ejb.Stateless;

@Stateless(mappedName="storeInDB")
public class NewUserBean implements NewUserInterface
{

	@Override
	public String storeInDB(String username, String password, String userType) 
	{
		int flag=0;
		int count=0,count1=0;
		String data=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs;
			if(userType.equals("admin"))
			{
				rs=stmt.executeQuery("select count(*) from user_details where usertype='admin'");
			
				if(rs.next())
				{
					count=rs.getInt(1);
				}
			
				if(count==0)
				{
					PreparedStatement pstmt=con.prepareStatement("insert into user_details values(?,?,?,?)");
					pstmt.setString(1,username);
					pstmt.setString(2,password);
					pstmt.setString(3,userType);
					pstmt.setString(4,"false");
					flag=pstmt.executeUpdate();
					data="done";
				}
				
				else
				{
					data="not done";
				}
			
			}
		
			else if(userType.equals("borrower"))
			{
				rs=stmt.executeQuery("select count(*) from user_details where username='"+username+"'");
				if(rs.next())
				{
					count1=rs.getInt(1);
				}
			
				if(count1==0)
				{
					PreparedStatement pstmt=con.prepareStatement("insert into user_details values(?,?,?,?)");
					pstmt.setString(1,username);
					pstmt.setString(2,password);
					pstmt.setString(3,userType);
					pstmt.setString(4,"false");
					flag=pstmt.executeUpdate();
					data="done";
				}
				else
				{
					data="user exists";
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
}
