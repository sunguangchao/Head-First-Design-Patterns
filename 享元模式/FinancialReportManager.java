package com.sungc.xiang;

public class FinancialReportManager implements IReportManager{

	protected String tenantId = null;
	public FinancialReportManager(String tenantId) {
		// TODO Auto-generated constructor stub
		this.tenantId = tenantId;
	}
	@Override
	public String createReport() {
		// TODO Auto-generated method stub
		return "This is a financial report";
	}
	

}
