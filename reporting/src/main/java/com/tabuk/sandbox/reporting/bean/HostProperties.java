package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.Map;

public class HostProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> tags;

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

}
