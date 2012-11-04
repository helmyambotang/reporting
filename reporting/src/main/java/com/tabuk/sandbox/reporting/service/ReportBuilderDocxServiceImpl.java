package com.tabuk.sandbox.reporting.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tabuk.sandbox.reporting.bean.HostProperties;
import com.tabuk.sandbox.reporting.bean.ReportHost;
import com.tabuk.sandbox.reporting.bean.ReportItem;
import com.tabuk.sandbox.reporting.entity.Recommendation;

@Service
public class ReportBuilderDocxServiceImpl implements ReportBuilderService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final String TEMPLATE_FILE = "template.docx";

	//private final String GEN_REPORT = "generated.docx";

	@Override
	public byte[] buildReport(List<ReportHost> datas) throws IOException {
		FileInputStream input = new FileInputStream(getClass().getClassLoader()
				.getResource(TEMPLATE_FILE).getPath());
		logger.info(getClass().getClassLoader().getResource(TEMPLATE_FILE).getPath());
		XWPFDocument document = new XWPFDocument(input);
		doGenerateScopeOfWorkTable(document, datas);
		Map<String, List<Recommendation>> recommendations = doGenerateFindings(document,datas);
		doGenerateRecommendations(document, recommendations);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		document.write(out);
		out.flush();
		out.close();
		return out.toByteArray();
	}

	private void doGenerateScopeOfWorkTable(XWPFDocument document,
			List<ReportHost> reportHosts) {
		final int columns = 3;
		final int rows = reportHosts.size() + 1;
		XWPFParagraph paragraphOne = document.createParagraph();
		XWPFRun paragraphOneRunOne = paragraphOne.createRun();
		paragraphOneRunOne.setText("Scope of Work");
		paragraphOneRunOne.addBreak();
		XWPFTable table = document.createTable(rows, columns);
		table.getRow(0).getCell(0).setText("No.");
		table.getRow(0).getCell(1).setText("Hosts");
		table.getRow(0).getCell(2).setText("Network Segment");
		int no = 1;
		for (ReportHost reportHost : reportHosts) {
			HostProperties details = reportHost.getHostProperties();
			String name = details.getTags().get("host-fqdn");
			String ip = details.getTags().get("host-ip");
			String colText = ip
					+ (!StringUtils.isBlank(name) ? " (" + name + ")" : "");
			table.getRow(no).getCell(0).setText(String.valueOf(no));
			table.getRow(no).getCell(1).setText(colText);
			no = no + 1;
		}
		tableHeaderStyle(table);
	}

	private Map<String, List<Recommendation>> doGenerateFindings(XWPFDocument document,
			List<ReportHost> reportHosts) {
		int noOfHost = reportHosts.size();
		int columns = noOfHost + 4;
		int rows = 1;
		Map<String, List<String>> vulnarabilities = populateIssues(reportHosts);
		Map<String, List<ReportItem>> plugins = resolvePlugins(reportHosts);
		rows = rows + vulnarabilities.keySet().size();
		XWPFParagraph paragraphOne = document.createParagraph();
		XWPFRun paragraphOneRunOne = paragraphOne.createRun();
		paragraphOneRunOne.setText("Findings");
		paragraphOneRunOne.addBreak();
		XWPFTable table = document.createTable(rows, columns);
		table.getRow(0).getCell(0).setText("Ref");
		table.getRow(0).getCell(1).setText("Vulnerability");
		table.getRow(0).getCell(2).setText("Severity");
		int i = 3;
		Map<String, Integer> columnMap = new LinkedHashMap<>();
		for (ReportHost reportHost : reportHosts) {
			HostProperties details = reportHost.getHostProperties();
			String name = details.getTags().get("host-fqdn");
			String ip = details.getTags().get("host-ip");
			String colText = ip
					+ (!StringUtils.isBlank(name) ? " (" + name + ")" : "");
			XWPFTableCell cell = table.getRow(0).getCell(i);
			CTTcPr tcpr = cell.getCTTc().addNewTcPr();
			CTTextDirection direction = tcpr.addNewTextDirection();
			direction.setVal(STTextDirection.BT_LR);
			CTShd ctshd = tcpr.addNewShd();
			ctshd.setColor("auto");
			ctshd.setVal(STShd.CLEAR);
			ctshd.setFill("D3D3D3");
			cell.setText(colText);
			columnMap.put(ip, Integer.valueOf(i));
			i = i + 1;
		}
		table.getRow(0).getCell(columns - 1).setText("Total");
		tableHeaderStyle(table);
		Map<String, List<Recommendation>> recommendations = populateFindings(table,reportHosts, vulnarabilities, columnMap, plugins);
		return recommendations;
	}

	private void doGenerateRecommendations(XWPFDocument document,
			Map<String, List<Recommendation>> groupedRecommendations) {
		int columns = 2;
		final String[] OUT = { "High", "Medium", "Low" };
		for(String type : OUT){
			XWPFParagraph paragraphOne = document.createParagraph();
			XWPFRun paragraphOneRunOne = paragraphOne.createRun();
			paragraphOneRunOne.setText("Recommendations - " + type);
			List<Recommendation> recommendations = groupedRecommendations.get(type);
			int row = 0;
			paragraphOneRunOne.addBreak();
			XWPFTable table = document.createTable(recommendations.size() * 6, columns);
			if(CollectionUtils.isNotEmpty(recommendations)){
				for (Recommendation recommendation : recommendations) {
					table.getRow(row).getCell(0).setText(recommendation.getId());
					table.getRow(row).getCell(1).setText(recommendation.getVulnarability());
					tableHeaderStyleRecommondation(table, recommendation.getRiskFactor(), row);
					row = row + 1;
					table.getRow(row).getCell(0).setText("Affected Hosts");
					String hosts = StringUtils.EMPTY;
					for (String host : recommendation.getAffectedHost()) {
						hosts = hosts + host + ",\n";
					}
					table.getRow(row).getCell(1).setText(hosts);
					row = row + 1;
					table.getRow(row).getCell(0).setText("Description");
					table.getRow(row).getCell(1).setText(recommendation.getDescription());
					row = row + 1;
					table.getRow(row).getCell(0).setText("Impact");
					table.getRow(row).getCell(1).setText(recommendation.getImpact());
					row = row + 1;
					table.getRow(row).getCell(0).setText("Risk");
					table.getRow(row).getCell(1)
							.setText(recommendation.getRiskFactor());
					row = row + 1;
					table.getRow(row).getCell(0).setText("Recommendation");
					table.getRow(row).getCell(1).setText(recommendation.getRecommendation());
					row = row + 1;
				}
				XWPFParagraph next = document.createParagraph();
				XWPFRun nextRun = next.createRun();
				nextRun.addBreak();
			}
		}
	}
	
	private void tableHeaderStyleRecommondation(XWPFTable table, String riskFactor, int row) {
		for (XWPFTableCell cell : table.getRow(row).getTableCells()) {
			CTTcPr tcpr = cell.getCTTc().addNewTcPr();
			CTVerticalJc va = tcpr.addNewVAlign();
			va.setVal(STVerticalJc.CENTER);
			CTShd ctshd = tcpr.addNewShd();
			ctshd.setColor("auto");
			ctshd.setVal(STShd.CLEAR);
			String color = "FFFFFF";
			if("high".equalsIgnoreCase(riskFactor)){
				color = "FF0000";
			}else if("medium".equalsIgnoreCase(riskFactor)){
				color = "FFA500";
			}else if("low".equalsIgnoreCase(riskFactor)){
				color = "FFFF00";
			}
			ctshd.setFill(color);
			XWPFParagraph para = cell.getParagraphs().get(0);
			XWPFRun rh = para.createRun();
			rh.setFontSize(10);
			rh.setFontFamily("Arial");
			rh.setBold(true);
			para.setAlignment(ParagraphAlignment.CENTER);
		}
	}

	private Map<String, List<ReportItem>> resolvePlugins(
			List<ReportHost> reportHosts) {
		Map<String, List<ReportItem>> sortedReports = new LinkedHashMap<>();
		for (ReportHost reportHost : reportHosts) {
			for (ReportItem reportItem : reportHost.getReportItems()) {
				String sevierity = reportItem.getRiskFactor();
				List<ReportItem> reportItems = sortedReports.get(sevierity);
				if (CollectionUtils.isEmpty(reportItems)) {
					reportItems = new ArrayList<>();
				}
				boolean found = false;
				for (ReportItem entity : reportItems) {
					if (entity.getPluginId().equals(reportItem.getPluginId())) {
						found = true;
						break;
					}
				}
				if (!found) {
					reportItems.add(reportItem);
				}
				sortedReports.put(sevierity, reportItems);
			}
		}
		return sortedReports;
	}

	private Map<String, List<String>> populateIssues(
			List<ReportHost> reportHosts) {
		Map<String, List<String>> vulnaribilities = new LinkedHashMap<>();
		for (ReportHost reportHost : reportHosts) {
			String hostIp = reportHost.getName();
			for (ReportItem reportItem : reportHost.getReportItems()) {
				if (!StringUtils.equalsIgnoreCase("NONE",
						reportItem.getRiskFactor())) {
					String vulnaribility = reportItem.getPluginId();
					List<String> hosts = vulnaribilities.get(vulnaribility);
					if (CollectionUtils.isEmpty(hosts)) {
						hosts = new ArrayList<>();
					}
					boolean found = false;
					for (String host : hosts) {
						if (hostIp.equals(host)) {
							found = true;
							break;
						}
					}
					if (!found) {
						hosts.add(hostIp);
					}
					vulnaribilities.put(vulnaribility, hosts);
				}
			}
		}
		return vulnaribilities;
	}

	private Map<String, List<Recommendation>> populateFindings(XWPFTable table,
			List<ReportHost> reportHosts,
			Map<String, List<String>> vulnaribilities,
			Map<String, Integer> columnMap,
			Map<String, List<ReportItem>> plugins) {

		final String[] OUT = { "High", "Medium", "Low" };
		List<ReportItem> sortedItems = new ArrayList<>();
		for (String riskFactor : OUT) {
			if (CollectionUtils.isNotEmpty(plugins.get(riskFactor))) {
				sortedItems.addAll(plugins.get(riskFactor));
			}
		}
		int i = 1;
		Map<String, List<Recommendation>> groupedRecommendations = new LinkedHashMap<>();
		List<Recommendation> recommendations = null;
		Recommendation recommendation = null;
		for (ReportItem reportItem : sortedItems) {
			recommendations = groupedRecommendations.get(reportItem.getRiskFactor());
			if(recommendations == null){
				recommendations = new ArrayList<>();
			}
			recommendation = new Recommendation();
			int total = 0;
			table.getRow(i).getCell(0).setText("Int-" + i);
			recommendation.setId("Int-" + i);
			table.getRow(i).getCell(1).setText(reportItem.getPluginName());
			recommendation.setVulnarability(reportItem.getPluginName());
			table.getRow(i).getCell(2).setText(reportItem.getRiskFactor());
			recommendation.setRiskFactor(reportItem.getRiskFactor());
			List<String> hosts = vulnaribilities.get(reportItem.getPluginId());
			recommendation.setAffectedHost(hosts);
			for (String host : hosts) {
				Integer columnIndex = columnMap.get(host);
				if (columnIndex != null) {
					table.getRow(i).getCell(columnIndex).setText("X");
					total = total + 1;
				}
			}
			table.getRow(i).getCell(table.getRow(i).getTableCells().size() - 1)
					.setText(Integer.toString(total));
			recommendation.setDescription(reportItem.getDescription());
			recommendation.setRecommendation(reportItem.getSolution());
			recommendation.setImpact(reportItem.getSynopsis() + "\r\nSee Also:\r\n");
			if(CollectionUtils.isNotEmpty(reportItem.getSeeAlsos())){
				for (String seeAlso : reportItem.getSeeAlsos()) {
					recommendation.setImpact(recommendation.getImpact() + seeAlso
							+ "\n");
				}
			}
			recommendations.add(recommendation);
			groupedRecommendations.put(reportItem.getRiskFactor(), recommendations);
			i = i + 1;
		}
		return groupedRecommendations;
	}

	private void tableHeaderStyle(XWPFTable table) {
		int column = 0;
		int last = table.getRow(0).getTableCells().size();
		for (XWPFTableCell cell : table.getRow(0).getTableCells()) {
			if (column < 3 || column > last - 2) {
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

}
