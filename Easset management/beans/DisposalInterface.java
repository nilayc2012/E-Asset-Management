package com.beans;
import java.util.*;
import javax.ejb.Remote;
@Remote
public interface DisposalInterface 
{
	public 	ArrayList<Asset> getAssetData();
	public boolean deleteAsset(String assetId);
}
