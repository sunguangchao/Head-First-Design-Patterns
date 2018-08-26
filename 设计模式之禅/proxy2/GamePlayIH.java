package design_pattern.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {
    Class clazz = null;
    Object obj = null;
    public GamePlayIH(Object _obj){
        this.obj = _obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object reslut = method.invoke(this.obj, args);
        if(method.getName().equalsIgnoreCase("login")){
            System.out.println("有人在用我的账号登录");
        }
        return reslut;
    }
}
