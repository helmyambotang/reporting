package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class FamilySelection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<FamilyItem> familyItems;


	public List<FamilyItem> getFamilyItems() {
		return familyItems;
	}


	public void setFamilyItems(List<FamilyItem> familyItems) {
		this.familyItems = familyItems;
	}
	
	

}
