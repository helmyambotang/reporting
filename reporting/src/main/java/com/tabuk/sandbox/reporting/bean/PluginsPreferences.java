package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class PluginsPreferences implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
