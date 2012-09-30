package com.tabuk.sandbox.reporting.web.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NessusFileUploadController {

	@RequestMapping("/view")
	public ModelAndView handleRequest() {
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") Part file) throws IOException {
		String filename = getFileName(file);
		InputStream inputStream = file.getInputStream();
		return "redirect:view";
	}
	
	private String getFileName(Part part) {
	    String partHeader = part.getHeader("content-disposition");
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	      if (cd.trim().startsWith("filename")) {
	        return cd.substring(cd.indexOf('=') + 1).trim()
	            .replace("\"", "");
	      }
	    }
	    return null;

	  }

}
