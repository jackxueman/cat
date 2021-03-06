package com.dianping.cat.report.page.statistics.task.heavy;

import java.util.Comparator;

import com.dianping.cat.home.heavy.entity.HeavyCache;
import com.dianping.cat.home.heavy.entity.HeavyCall;
import com.dianping.cat.home.heavy.entity.HeavyReport;
import com.dianping.cat.home.heavy.entity.HeavySql;
import com.dianping.cat.home.heavy.entity.Service;
import com.dianping.cat.home.heavy.entity.Url;
import com.dianping.cat.home.heavy.transform.DefaultMerger;

public class HeavyReportMerger extends DefaultMerger {

	public HeavyReportMerger(HeavyReport heavyReport) {
		super(heavyReport);
	}

	@Override
	protected void mergeHeavyCache(HeavyCache old, HeavyCache heavyCache) {
		super.mergeHeavyCache(old, heavyCache);
	}

	@Override
	protected void mergeHeavyCall(HeavyCall old, HeavyCall heavyCall) {
		super.mergeHeavyCall(old, heavyCall);
	}

	@Override
	protected void mergeHeavyReport(HeavyReport old, HeavyReport heavyReport) {
		super.mergeHeavyReport(old, heavyReport);
	}

	@Override
	protected void mergeHeavySql(HeavySql old, HeavySql heavySql) {
		super.mergeHeavySql(old, heavySql);
	}

	@Override
	protected void mergeService(Service old, Service service) {
		old.setKey(service.getKey());
		if (service.getCount() > old.getCount()) {
			old.setCount(service.getCount());
		}
		old.setDomain(service.getDomain());
		old.setLogview(service.getLogview());
		old.setName(service.getName());
	}

	@Override
	protected void mergeUrl(Url old, Url url) {
		old.setKey(url.getKey());
		if (url.getCount() > old.getCount()) {
			old.setCount(url.getCount());
		}
		old.setDomain(url.getDomain());
		old.setLogview(url.getLogview());
		old.setName(url.getName());
	}

	public static class ServiceComparator implements Comparator<Service> {

		@Override
		public int compare(Service o1, Service o2) {
			return (int) (o2.getCount() - o1.getCount());
		}
	}

	public static class UrlComparator implements Comparator<Url> {

		@Override
		public int compare(Url o1, Url o2) {
			return (int) (o2.getCount() - o1.getCount());
		}
	}
}
