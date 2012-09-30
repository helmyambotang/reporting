package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class IndividualPluginSelection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<PluginItem> pluginItems;


	public List<PluginItem> getPluginItems() {
		return pluginItems;
	}


	public void setPluginItems(List<PluginItem> pluginItems) {
		this.pluginItems = pluginItems;
	}

}
