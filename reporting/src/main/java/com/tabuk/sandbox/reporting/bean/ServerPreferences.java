package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class ServerPreferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<Preference> preferences;


	public List<Preference> getPreferences() {
		return preferences;
	}


	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
	
	

}
