package com.beans;

import javax.ejb.Stateless;
import java.sql.*;
@Stateless(mappedName="addAsset")
public class AdditionBean implements AdditionInterface
{

	@Override
	public boolean addAsset(String assetName, String assetDesc,String assetType) 
	{
		try
		{
			int assetId=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			PreparedStatement pstmt=con.prepareStatement("select max(asset_id) from assets");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				assetId=rs.getInt(1)+1;
			}
			
			pstmt=con.prepareStatement("insert into assets values(?,?,?,?,?,?)");
			pstmt.setInt(1,assetId);
			pstmt.setString(2,assetName);
			pstmt.setString(3,assetDesc);
			pstmt.setString(4,assetType);
			pstmt.setString(5,"false");
			pstmt.setString(6,"false");
			pstmt.executeUpdate();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public static void main(String[] args) {
		AdditionBean ab=new AdditionBean();
		ab.addAsset("java","java book","book");
	}
}
