package com.tabuk.sandbox.reporting.bean;

import java.io.Serializable;

public class Policy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String policyName;
	
	private Preferences preferences;
	
	
	private FamilySelection familySelection;
	
	private IndividualPluginSelection individualPluginSelection;

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
	}

	public FamilySelection getFamilySelection() {
		return familySelection;
	}

	public void setFamilySelection(FamilySelection familySelection) {
		this.familySelection = familySelection;
	}

	public IndividualPluginSelection getIndividualPluginSelection() {
		return individualPluginSelection;
	}

	public void setIndividualPluginSelection(
			IndividualPluginSelection individualPluginSelection) {
		this.individualPluginSelection = individualPluginSelection;
	}
	
	

}
