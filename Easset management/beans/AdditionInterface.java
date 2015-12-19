package com.beans;

import javax.ejb.Remote;

@Remote
public interface AdditionInterface {
	public boolean addAsset(String assetName,String assetDesc,String assetType);
}
