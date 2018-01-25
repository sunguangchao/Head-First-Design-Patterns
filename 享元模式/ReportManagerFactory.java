package com.sungc.xiang;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

	Map<String, IReportManager> financialReport = new HashMap<String, IReportManager>();
	Map<String, IReportManager> employeeReport = new HashMap<String, IReportManager>();
	
	IReportManager getFinancialReport(String tenantId) {
		//通过租户ID获取享元
		IReportManager r = financialReport.get(tenantId);
		if (r == null) {
			//维护已创建的享元对象
			r = new FinancialReportManager(tenantId);
			financialReport.put(tenantId, r);
		}
		return r;
	}
	
	IReportManager getEmployeeReport(String tenantId) {
		IReportManager r = employeeReport.get(tenantId);
		if (r == null) {
			r = new EmployeeReportManager(tenantId);
			employeeReport.put(tenantId, r);
		}
		return r;
	}
	
	public static void main(String[] args) {
		ReportManagerFactory rmf = new ReportManagerFactory();
		IReportManager rm = rmf.getFinancialReport("A");
		System.out.println(rm.createReport());
	}
}
