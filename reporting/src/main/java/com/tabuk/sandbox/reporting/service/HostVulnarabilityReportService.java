package com.tabuk.sandbox.reporting.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tabuk.sandbox.reporting.bean.ReportHost;
import com.tabuk.sandbox.reporting.entity.Host;
import com.tabuk.sandbox.reporting.entity.Plugin;



public class HostVulnarabilityReportService implements ReportBuilderService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String TEMPLATE_FILE = "template.docx";
	
	private final ReportEntityResolver reportHostResolver;
	
	
	public HostVulnarabilityReportService(
			ReportEntityResolver reportHostResolver) {
		this.reportHostResolver = reportHostResolver;
	}


	@Override
	public byte[] buildReport(List<ReportHost> reportHosts) throws IOException {
		logger.info(getClass().getClassLoader().getResource(TEMPLATE_FILE).getPath());
		FileInputStream input = new FileInputStream(getClass().getClassLoader().getResource(TEMPLATE_FILE).getPath());
		XWPFDocument document = new XWPFDocument(input);
		doGenerateScopeOfWorkTable(document, reportHosts);
		
		return null;
	}
	
	private void doGenerateScopeOfWorkTable(final XWPFDocument document, final List<ReportHost> reportHosts){
		List<Host> hosts = reportHostResolver.resolveToHostClass(reportHosts);
		final int columns = 3;
		final int rows = reportHosts.size() + 1;	
		XWPFParagraph paragraphOne = document.createParagraph();
		XWPFRun paragraphOneRunOne = paragraphOne.createRun();
	    paragraphOneRunOne.setText("Scope of Work");
	    paragraphOneRunOne.addBreak();
		XWPFTable table = document.createTable(rows, columns);
		doGenerateScopeOfWorkListHeader(table);
		int no = 1;
		for(Host host : hosts){
			table.getRow(no).getCell(0).setText(String.valueOf(no));
			table.getRow(no).getCell(1).setText(host.getHostIp() + " (" + host.getHostName() + ")");
			CTTextDirection direction = table.getRow(no).getCell(1).getCTTc().addNewTcPr().addNewTextDirection();
			direction.setVal(STTextDirection.BT_LR);
			table.getRow(no).getCell(2).setText(host.getSegment());
			no = no + 1;
		}
	}
	
	private void doGenerateScopeOfWorkListHeader(final XWPFTable table){
		table.getRow(0).getCell(0).setText("No.");
		table.getRow(0).getCell(1).setText("Hosts");
		table.getRow(0).getCell(2).setText("Network Segment");
		for(XWPFTableCell cell : table.getRow(0).getTableCells()){
			CTTcPr tcpr = cell.getCTTc().addNewTcPr();
			CTVerticalJc va = tcpr.addNewVAlign();
			CTShd ctshd = tcpr.addNewShd();
			XWPFParagraph para = cell.getParagraphs().get(0);
			XWPFRun xwpfRun = para.createRun();
			xwpfRun.setFontFamily("Arial");
			va.setVal(STVerticalJc.CENTER);
			ctshd.setFill("D3D3D3");
		}
		XWPFTableRow row  = table.getRow(0);
		CTTrPr trPr = row.getCtRow().addNewTrPr();
		CTHeight ht = trPr.addNewTrHeight();
    	ht.setVal(BigInteger.valueOf(360));
	}
	
	
	private void tableHeaderStyle(XWPFTable table) {
		int column = 0;
		int last = table.getRow(0).getTableCells().size();
		for (XWPFTableCell cell : table.getRow(0).getTableCells()) {
			if (column < 3 || column > last -2) {
				CTTcPr tcpr = cell.getCTTc().addNewTcPr();
				CTVerticalJc va = tcpr.addNewVAlign();
				va.setVal(STVerticalJc.CENTER);
				CTShd ctshd = tcpr.addNewShd();
				ctshd.setColor("auto");
				ctshd.setVal(STShd.CLEAR);
				ctshd.setFill("D3D3D3");
				XWPFParagraph para = cell.getParagraphs().get(0);
				XWPFRun rh = para.createRun();
				rh.setFontSize(10);
				rh.setFontFamily("Arial");
				rh.setBold(true);
				para.setAlignment(ParagraphAlignment.CENTER);
			}
			column = column + 1;
		}
	}
	
		
		
	
	private List<Host> prepareFindinst(List<ReportHost> reportHosts){
		List<Plugin> plugins = reportHostResolver.resolveToPluginClass(reportHosts);
		return null;
	}
	
	private Map<String, String> assignVulnarabilityToHost(List<ReportHost> reportHosts){
		Map<String, Integer> columnMap = new LinkedHashMap<>();
		for (ReportHost reportHost : reportHosts) {
			
		}
		return null;
	}

}
