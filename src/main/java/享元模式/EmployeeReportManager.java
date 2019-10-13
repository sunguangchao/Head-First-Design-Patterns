package 享元模式;

public class EmployeeReportManager implements IReportManager{

	protected String tenantId = null;
	
	public EmployeeReportManager(String tenantId) {
		// TODO Auto-generated constructor stub
		this.tenantId = tenantId;
	}
	@Override
	public String createReport() {
		// TODO Auto-generated method stub
		return "This is a employee report";
	}

}
