package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class ReportHost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private HostProperties hostProperties;
	
	private List<ReportItem> reportItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HostProperties getHostProperties() {
		return hostProperties;
	}

	public void setHostProperties(HostProperties hostProperties) {
		this.hostProperties = hostProperties;
	}

	public List<ReportItem> getReportItems() {
		return reportItems;
	}

	public void setReportItems(List<ReportItem> reportItems) {
		this.reportItems = reportItems;
	}

}
