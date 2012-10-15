package com.tabuk.sandbox.reporting.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableWordBuilderTest {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private final String TEMPLATE_FILE = "src/test/resources/template.docx";
	private final String GENERATED_FILE = "src/test/resources/generated.docx";
	
	@Test
	public void buildDocx() throws FileNotFoundException, IOException{
		final int rows  = 2;
		final int columns = 5;
		XWPFDocument document = new XWPFDocument(new FileInputStream(TEMPLATE_FILE)); 
		XWPFTable table = document.createTable(rows,columns);
		table.getRow(0).getCell(0).setText("REF");
		table.getRow(0).getCell(1).setText("Vulnerability");
		table.getRow(0).getCell(2).setText("Severity");
		table.getRow(0).getCell(3).setText("ip's");
		table.getRow(0).getCell(4).setText("total");
		FileOutputStream out = new FileOutputStream(GENERATED_FILE);
        document.write(out);
        out.close();
	}

}
