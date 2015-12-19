package com.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface ReportInterface 
{
	public ArrayList<Asset> categoryWiseAsset(String assetType);
	
	public ArrayList<Transaction> specUser(String username);
	
	public ArrayList<Transaction> dueList();
	
	public ArrayList<Transaction> fineList();
	
	public ArrayList<String> asstTypeList();
	
	public ArrayList<String> userTypeList();
	
	public ArrayList<Transaction> byDayList(String date);
	
	public ArrayList<Transaction> byMonthList(String month);
	
	public ArrayList<Transaction> byPeriodList(String date1,String date2);
	
}
