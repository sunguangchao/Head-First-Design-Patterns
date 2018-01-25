package com.sungc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDBQueryHandler implements InvocationHandler{
	DBQuery real = null;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if (real == null) {
			real = new DBQuery();
		}
		return real.request();
	}
	
	/**
	 * 得到动态生成的代理类
	 * @return
	 */
	public static IDBQuery createJdkProxy() {
		IDBQuery proxy = (IDBQuery)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] {IDBQuery.class}, new JdkDBQueryHandler());
		return proxy;
	}
	
	

}
