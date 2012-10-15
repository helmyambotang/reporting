package com.tabuk.sandbox.reporting.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tabuk.sandbox.reporting.bean.NesusClientData;
import com.tabuk.sandbox.reporting.service.ReportBuilderService;
import com.tabuk.sandbox.reporting.service.UnmarshallNesusXmlService;

@Controller
public class NessusFileUploadController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final UnmarshallNesusXmlService unmarshallNesusXmlService;

	private final ReportBuilderService reportBuilderService;

	@Autowired
	public NessusFileUploadController(
			UnmarshallNesusXmlService unmarshallNesusXmlService,
			ReportBuilderService reportBuilderService) {
		this.unmarshallNesusXmlService = unmarshallNesusXmlService;
		this.reportBuilderService = reportBuilderService;
	}

	@RequestMapping("/view")
	public ModelAndView handleRequest() {
		ModelAndView mav = new ModelAndView("upload");
		return mav;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void handleFormUpload(
			@RequestParam("uploadedFile") MultipartFile file, HttpServletResponse response)
			throws IOException, MarshalException, ValidationException {
		File upLoadedfile = new File(file.getOriginalFilename());
		upLoadedfile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(upLoadedfile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		NesusClientData nesusClientData = unmarshallNesusXmlService.parse(upLoadedfile);
		byte[] report = this.reportBuilderService.buildReport(nesusClientData.getReport().getReportHosts());
		response.setBufferSize(report.length);
		response.setContentType("application/docx");
		response.setHeader("Content-Disposition","attachment; filename=generated.docx");
		response.getOutputStream().write(report);
		response.flushBuffer();
	}

}
