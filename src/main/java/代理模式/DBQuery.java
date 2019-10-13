package 代理模式;

public class DBQuery implements IDBQuery{

	public DBQuery() {
		// TODO Auto-generated constructor stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String request() {
		// TODO Auto-generated method stub
		return "Request String";
	}
	

}
