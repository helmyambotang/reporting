package com.tabuk.sandbox.reporting.entity;

import java.io.Serializable;

public class Host implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hostIp;
	
	private String hostName;
	
	private String segment;

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}
	
	
	

}
