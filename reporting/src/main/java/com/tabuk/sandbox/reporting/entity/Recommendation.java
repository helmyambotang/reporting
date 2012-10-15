package com.tabuk.sandbox.reporting.entity;

import java.io.Serializable;
import java.util.List;

public class Recommendation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String vulnarability;
	
	private List<String> affectedHost;
	
	private String description;
	
	private String impact;
	
	private String riskFactor;
	
	private String recommendation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVulnarability() {
		return vulnarability;
	}

	public void setVulnarability(String vulnarability) {
		this.vulnarability = vulnarability;
	}

	public List<String> getAffectedHost() {
		return affectedHost;
	}

	public void setAffectedHost(List<String> affectedHost) {
		this.affectedHost = affectedHost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(String riskFactor) {
		this.riskFactor = riskFactor;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	
	

}
