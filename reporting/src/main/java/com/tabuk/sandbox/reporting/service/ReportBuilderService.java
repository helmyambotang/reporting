package com.tabuk.sandbox.reporting.service;

import java.io.IOException;
import java.util.List;

import com.tabuk.sandbox.reporting.bean.ReportHost;

public interface ReportBuilderService {

	byte[] buildReport(List<ReportHost> datas) throws IOException;
}
