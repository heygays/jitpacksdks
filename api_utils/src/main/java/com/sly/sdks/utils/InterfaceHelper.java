package com.sly.sdks.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 有些接口在uts中实现的时候编译不通过，一直提示方法实现错误，应该是方法参数类型的问题，
 * 所以只有这样曲线处理一下
 */
public class InterfaceHelper {
    //uts中实现InvocationHandler接口就会报错，提示invoke方法参数类型各种不对
    public abstract static class MyInvocationHandler implements InvocationHandler {
        private Object proxy;
        private Method method;
        private ArrayList<Object> args = new ArrayList<>();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            this.proxy = proxy;
            this.method = method;
            if (args != null) {
                Collections.addAll(this.args, args);
            }
            return this.myInvoke();
        }

        abstract Object myInvoke();

        public Object getProxy() {
            return proxy;
        }

        public Method getMethod() {
            return method;
        }

        public ArrayList<Object> getArgs() {
            return args;
        }
    }
}
