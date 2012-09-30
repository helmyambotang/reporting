package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<ReportHost> reportHosts;


	public List<ReportHost> getReportHosts() {
		return reportHosts;
	}


	public void setReportHosts(List<ReportHost> reportHosts) {
		this.reportHosts = reportHosts;
	}

}
