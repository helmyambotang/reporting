package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;

public class Preferences implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ServerPreferences serverPreferences;
	
	private PluginsPreferences pluginsPreferences;

	public ServerPreferences getServerPreferences() {
		return serverPreferences;
	}

	public void setServerPreferences(ServerPreferences serverPreferences) {
		this.serverPreferences = serverPreferences;
	}

	public PluginsPreferences getPluginsPreferences() {
		return pluginsPreferences;
	}

	public void setPluginsPreferences(PluginsPreferences pluginsPreferences) {
		this.pluginsPreferences = pluginsPreferences;
	}
	
	

	
}
