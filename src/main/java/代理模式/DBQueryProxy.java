package 代理模式;


public class DBQueryProxy implements IDBQuery{

	private DBQuery real = null;
	@Override
	public String request() {
		// ��������Ҫ��ʱ�򣬴������󣬴������̿��ܺ���
		if (real == null) {
			real = new DBQuery();
		}
		return real.request();
	}
	public static void main(String[] args) {
		IDBQuery query = new DBQueryProxy();
		String string = query.request();
		System.out.println(string);
	}

}
