package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;
import java.util.List;

public class ReportItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String port;
	
	private String svcName;
	
	private String protocol;
	
	private String severity;
	
	private String pluginId;
	
	private String pluginName;
	
	private String pluginFamily;
	
	private List<String> bids;
	
	private String canvasPackage;
	
	private List<String> cves;
	
	private String cvssBaseScore;
	
	private String cvssTemporalScore;
	
	private String cvssTemporalVector;
	
	private String cvssVector;
	
	private String cpe;
	
	private String description;
	
	private String expoloitAvailable;
	
	private String exploitFrameworkCanvas;
	
	private String exploitFrameworkCore;
	
	private String exploitFrameworkMetasploit;
	
	private String exploitabilityEase;
	
	private String metasploitName;
	
	private String patchPublicationDate;
	
	private String pluginModificationDate;
	
	private String pluginPublicationDate;
	
	private String pluginType;
	
	private String pluginVersion;
	
	private String riskFactor;
	
	private List<String> seeAlsos;
	
	private String solution;
	
	private String synopsis;
	
	private List<String> xrefs;
	
	private String vulnPublicationDate;
	
	private String pluginOutput;

	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSvcName() {
		return svcName;
	}

	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getPluginId() {
		return pluginId;
	}

	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public String getPluginFamily() {
		return pluginFamily;
	}

	public void setPluginFamily(String pluginFamily) {
		this.pluginFamily = pluginFamily;
	}

	public List<String> getBids() {
		return bids;
	}

	public void setBids(List<String> bids) {
		this.bids = bids;
	}

	public String getCanvasPackage() {
		return canvasPackage;
	}

	public void setCanvasPackage(String canvasPackage) {
		this.canvasPackage = canvasPackage;
	}

	public List<String> getCves() {
		return cves;
	}

	public void setCves(List<String> cves) {
		this.cves = cves;
	}

	public String getCvssBaseScore() {
		return cvssBaseScore;
	}

	public void setCvssBaseScore(String cvssBaseScore) {
		this.cvssBaseScore = cvssBaseScore;
	}

	public String getCvssTemporalScore() {
		return cvssTemporalScore;
	}

	public void setCvssTemporalScore(String cvssTemporalScore) {
		this.cvssTemporalScore = cvssTemporalScore;
	}

	public String getCvssTemporalVector() {
		return cvssTemporalVector;
	}

	public void setCvssTemporalVector(String cvssTemporalVector) {
		this.cvssTemporalVector = cvssTemporalVector;
	}

	public String getCvssVector() {
		return cvssVector;
	}

	public void setCvssVector(String cvssVector) {
		this.cvssVector = cvssVector;
	}

	public String getCpe() {
		return cpe;
	}

	public void setCpe(String cpe) {
		this.cpe = cpe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpoloitAvailable() {
		return expoloitAvailable;
	}

	public void setExpoloitAvailable(String expoloitAvailable) {
		this.expoloitAvailable = expoloitAvailable;
	}
	
	public String getExploitFrameworkCanvas() {
		return exploitFrameworkCanvas;
	}

	public void setExploitFrameworkCanvas(String exploitFrameworkCanvas) {
		this.exploitFrameworkCanvas = exploitFrameworkCanvas;
	}

	public String getExploitFrameworkCore() {
		return exploitFrameworkCore;
	}

	public void setExploitFrameworkCore(String exploitFrameworkCore) {
		this.exploitFrameworkCore = exploitFrameworkCore;
	}

	public String getExploitFrameworkMetasploit() {
		return exploitFrameworkMetasploit;
	}

	public void setExploitFrameworkMetasploit(String exploitFrameworkMetasploit) {
		this.exploitFrameworkMetasploit = exploitFrameworkMetasploit;
	}

	public String getExploitabilityEase() {
		return exploitabilityEase;
	}

	public void setExploitabilityEase(String exploitabilityEase) {
		this.exploitabilityEase = exploitabilityEase;
	}
	
	public String getMetasploitName() {
		return metasploitName;
	}

	public void setMetasploitName(String metasploitName) {
		this.metasploitName = metasploitName;
	}

	public String getPatchPublicationDate() {
		return patchPublicationDate;
	}

	public void setPatchPublicationDate(String patchPublicationDate) {
		this.patchPublicationDate = patchPublicationDate;
	}

	public String getPluginModificationDate() {
		return pluginModificationDate;
	}

	public void setPluginModificationDate(String pluginModificationDate) {
		this.pluginModificationDate = pluginModificationDate;
	}

	public String getPluginPublicationDate() {
		return pluginPublicationDate;
	}

	public void setPluginPublicationDate(String pluginPublicationDate) {
		this.pluginPublicationDate = pluginPublicationDate;
	}

	public String getPluginType() {
		return pluginType;
	}

	public void setPluginType(String pluginType) {
		this.pluginType = pluginType;
	}

	public String getPluginVersion() {
		return pluginVersion;
	}

	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	public String getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(String riskFactor) {
		this.riskFactor = riskFactor;
	}

	public List<String> getSeeAlsos() {
		return seeAlsos;
	}

	public void setSeeAlsos(List<String> seeAlsos) {
		this.seeAlsos = seeAlsos;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	
	public List<String> getXrefs() {
		return xrefs;
	}

	public void setXrefs(List<String> xrefs) {
		this.xrefs = xrefs;
	}

	public String getVulnPublicationDate() {
		return vulnPublicationDate;
	}

	public void setVulnPublicationDate(String vulnPublicationDate) {
		this.vulnPublicationDate = vulnPublicationDate;
	}

	public String getPluginOutput() {
		return pluginOutput;
	}

	public void setPluginOutput(String pluginOutput) {
		this.pluginOutput = pluginOutput;
	}

}
