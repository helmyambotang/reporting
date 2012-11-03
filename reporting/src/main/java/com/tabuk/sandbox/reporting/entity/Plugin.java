package com.tabuk.sandbox.reporting.entity;

import java.io.Serializable;
import java.util.Map;

public class Plugin implements Serializable, Comparable<Plugin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pluginId;

	private String name;

	private String ref;

	private String severity;

	private int order;
	
	private Map<String, Integer> hosts;

	public String getPluginId() {
		return pluginId;
	}

	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public Map<String, Integer> getHosts() {
		return hosts;
	}

	public void setHosts(Map<String, Integer> hosts) {
		this.hosts = hosts;
	}

	@Override
	public int compareTo(Plugin plugin) {

		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		int result = EQUAL;

		if (this.order < plugin.getOrder())
			result = BEFORE;
		else if (this.order > plugin.getOrder())
			result = AFTER;
		
		return result;
	}

}
