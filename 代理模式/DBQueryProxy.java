package com.sungc.proxy;


public class DBQueryProxy implements IDBQuery{

	private DBQuery real = null;
	@Override
	public String request() {
		// 在真正需要的时候，创建对象，创建过程可能很慢
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
