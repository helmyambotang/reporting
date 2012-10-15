package com.tabuk.sandbox.reporting.service;

import java.util.List;

import com.tabuk.sandbox.reporting.bean.ReportHost;
import com.tabuk.sandbox.reporting.entity.Host;
import com.tabuk.sandbox.reporting.entity.Plugin;


public interface ReportEntityResolver {
	
	List<Plugin> resolveToPluginClass(List<ReportHost> datas);
	
	
	List<Host> resolveToHostClass(List<ReportHost> datas);
}
