package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;
import java.util.Date;

import javax.ejb.Stateless;

import java.sql.*;;

@Stateless(mappedName="AllocDealloc")
public class AllocDeallocBean implements AllocDeallocInterface
{

	@Override
	public ArrayList<Asset> getAssetData() 
	{

		ArrayList<Asset> assetList=new ArrayList<Asset>();
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select asset_id,asset_name,asset_desc,asset_type from assets order by asset_id");
			Asset asstObj;
			while(rs.next())
			{
				asstObj=new Asset();
				asstObj.setAssetId(rs.getInt(1));
				asstObj.setAssetName(rs.getString(2));
				asstObj.setAssetDesc(rs.getString(3));
				asstObj.setAssetType(rs.getString(4));
				assetList.add(asstObj);
			}
				
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return assetList;
	}

	@Override
	public String allocAsset(String assetId,String username) 
	{
		String flag="false";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			ResultSet rs=stmt.executeQuery("select issued from assets where asset_id="+assetId);
			
			
			if(rs.next())
			{
				String issued=rs.getString(1);
				ResultSet rs1=stmt1.executeQuery("select blocked from user_details where username='"+username+"'");
				
				if(rs1.next())
				{
					String blocked=rs1.getString(1);
					
					if(blocked.equals("true"))
					{
						flag="false1";
					}
				
				
					else
					{
						
						if(issued.equals("true"))
						{
							flag="false";
						}
				
						else
						{
							rs=stmt.executeQuery("select asset_name,asset_type from assets where asset_id="+assetId);
							if(rs.next())
							{
								stmt.executeUpdate("insert into borrower(username,asset_id,asset_name,asset_type,issue_date,returning_date) values('"+username+"',"+assetId+",'"+rs.getString(1)+"','"+rs.getString(2)+"',sysdate,sysdate+15)");
							}
							stmt.executeUpdate("update assets set issued='true' where asset_id="+assetId);
							flag="true";
						}
					}
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deallocAsset(String assetId,String username) 
	{
		int fine=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			Date dt;
			ResultSet rs=stmt.executeQuery("select returning_date from borrower where username='"+username+"' and asset_id="+assetId);
			if(rs.next())
			{
				dt=rs.getDate(1);
				Date dt1=new Date();
				CallableStatement cst=con.prepareCall("{call trans_opr(?,?,?)}");
				
				if(dt1.after(dt))
				{
					int days=(dt.getMonth()*30)+dt.getDate();
					int	days1=(dt1.getMonth()*30)+dt1.getDate();
					int diff=days1-days;
					fine=diff*50;
					System.out.println(fine);
					cst.setString(1,username);
					cst.setInt(2,fine);
					int aid=Integer.parseInt(assetId);
					System.out.println(aid);
					cst.setInt(3,aid);
					cst.execute();
					stmt.executeQuery("delete from borrower where username='"+username+"' and asset_id="+assetId);
					stmt.executeUpdate("update assets set issued='false' where asset_id="+assetId);
					stmt.executeUpdate("update user_details set blocked='false' where username='"+username+"'");
				}
				else
				{
					cst.setString(1,username);
					cst.setInt(2,fine);
					int aid=Integer.parseInt(assetId);
					System.out.println(aid);
					cst.setInt(3,aid);
					cst.execute();
					stmt.executeQuery("delete from borrower where username='"+username+"' and asset_id="+assetId);
					stmt.executeUpdate("update assets set issued='false' where asset_id="+assetId);
				}
			
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fine;
	}

	@Override
	public ArrayList<Asset> getAllocAssetData(String username) 
	{
		ArrayList<Asset> asstList=new ArrayList<Asset>();
		
		try
		{
			Asset asstObj;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			ResultSet rs,rs1;
			rs=stmt.executeQuery("select asset_id from borrower where username='"+username+"'");
			
			while(rs.next())
			{
				int asset_Id=rs.getInt(1);
				System.out.println(asset_Id);
				rs1=stmt1.executeQuery("select asset_id,asset_name,asset_desc,asset_type from assets where asset_id="+asset_Id);
				if(rs1.next())
				{
					asstObj=new Asset();
					asstObj.setAssetId(rs1.getInt(1));
					asstObj.setAssetName(rs1.getString(2));
					asstObj.setAssetDesc(rs1.getString(3));
					asstObj.setAssetType(rs1.getString(4));
					asstList.add(asstObj);
				}
				
			}	
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return asstList;
		
	}

	@Override
	public boolean doReserve(String assetId, String username) 
	{
		boolean flag=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select reserved from assets where asset_id="+assetId);
			if(rs.next())
			{
				String reserved=rs.getString(1);
				if(reserved.equals("false"))
				{
					stmt.executeUpdate("update assets set reserved='"+username+"' where asset_id="+assetId);
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void main(String[] args) {
		AllocDeallocBean ab=new AllocDeallocBean();
		String flag=ab.allocAsset("3","amit");
		System.out.println(flag);
	}
}
