package 设计模式之禅.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target = null;
    public MyInvocationHandler(Object _object){
        this.target = _object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
