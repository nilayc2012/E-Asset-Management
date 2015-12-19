package com.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface AllocDeallocInterface 
{
	public 	ArrayList<Asset> getAssetData();
	public String allocAsset(String assetId,String username);
	public int deallocAsset(String assetId,String username);
	public ArrayList<Asset> getAllocAssetData(String username);
	public boolean doReserve(String assetId,String username);
}
