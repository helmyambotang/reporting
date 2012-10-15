package com.tabuk.sandbox.reporting.form;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileForm {

	private MultipartFile uploadedFile;

	public MultipartFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(MultipartFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	
}
