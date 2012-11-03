package com.tabuk.sandbox.reporting.form;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileForm  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MultipartFile> uploadedFiles;

	public List<MultipartFile> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<MultipartFile> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}
	
	
	
}
