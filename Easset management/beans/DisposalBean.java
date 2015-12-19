package com.beans;

import java.util.*;
import javax.ejb.Stateless;

import java.io.PrintWriter;
import java.sql.*;

@Stateless(mappedName="disposal")
public class DisposalBean implements DisposalInterface
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
	public boolean deleteAsset(String assetId) 
	{
		boolean flag=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select issued from assets where asset_id="+assetId);
			if(rs.next())
			{
				String issued=rs.getString(1);
				if(issued.equals("true"))
				{
					flag=false;
				}
				else
				{
					rs=stmt.executeQuery("select asset_id,asset_name,asset_type,asset_desc from assets where asset_id="+assetId);
					while(rs.next())
					{
						stmt.executeUpdate("insert into asset_history values("+rs.getString(1)+",'"+rs.getString(2)+"','"+rs.getString(3)+"','"+rs.getString(4)+"')");
					}
					stmt.executeUpdate("delete from assets where asset_Id="+assetId);
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
