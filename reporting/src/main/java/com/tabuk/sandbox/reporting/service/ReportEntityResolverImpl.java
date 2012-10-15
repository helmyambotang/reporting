package com.tabuk.sandbox.reporting.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.tabuk.sandbox.reporting.bean.HostProperties;
import com.tabuk.sandbox.reporting.bean.ReportHost;
import com.tabuk.sandbox.reporting.bean.ReportItem;
import com.tabuk.sandbox.reporting.entity.Host;
import com.tabuk.sandbox.reporting.entity.Plugin;


public class ReportEntityResolverImpl implements ReportEntityResolver {

	final private Map<String, Integer> validSeverity;

	
	public ReportEntityResolverImpl(Map<String, Integer> validSeverity) {
		this.validSeverity = validSeverity;
	}

	@Override
	public List<Plugin> resolveToPluginClass(List<ReportHost> reportHosts) {
		List<Plugin> plugins = new ArrayList<>();
		Plugin plugin = null;
		for(ReportHost reportHost : reportHosts){
			List<ReportItem> reportItems = reportHost.getReportItems();
			if(CollectionUtils.isNotEmpty(reportItems)){
				for(ReportItem reportItem : reportItems){
					String severity = reportItem.getRiskFactor();
					if(org.springframework.util.CollectionUtils.contains(validSeverity.keySet().iterator(), severity)){
						plugin = new Plugin();
						plugin.setName(reportItem.getPluginName());
						plugin.setPluginId(reportItem.getPluginId());
						plugin.setOrder(validSeverity.get(severity));
						plugin.setRef("Int-");
						plugins.add(plugin);
					}
				}
			}
		}
		Collections.sort(plugins);
		return plugins;
	}

	@Override
	public List<Host> resolveToHostClass(List<ReportHost> reportHosts) {
		List<Host> hosts = new ArrayList<>();
		Host host = null;
		for(ReportHost reportHost : reportHosts){
			HostProperties details = reportHost.getHostProperties();
			host = new Host();
			host.setHostIp(details.getTags().get("host-ip"));
			host.setHostName(details.getTags().get("host-fqdn"));
			hosts.add(host);
		}
		return hosts;
	}

}
