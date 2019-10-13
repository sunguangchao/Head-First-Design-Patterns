package 享元模式;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

	Map<String, IReportManager> financialReport = new HashMap<String, IReportManager>();
	Map<String, IReportManager> employeeReport = new HashMap<String, IReportManager>();
	
	IReportManager getFinancialReport(String tenantId) {
		//ͨ���⻧ID��ȡ��Ԫ
		IReportManager r = financialReport.get(tenantId);
		if (r == null) {
			//ά���Ѵ�������Ԫ����
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
