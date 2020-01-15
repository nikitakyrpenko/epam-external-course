package practice.lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //final A a = new A();

        final Class<A> aClass = A.class;
        final Constructor<A> constructor =  aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        final A a = constructor.newInstance();
        //a.method();
        final Method method = aClass.getDeclaredMethod("method");
        method.setAccessible(true);
        final Object invoke = method.invoke(a);

        final Method staticMethod = aClass.getDeclaredMethod("staticMethod");
        staticMethod.setAccessible(true);
        staticMethod.invoke(aClass.getClass());

    }
}

class A{

    private A(){

    }

    private void method(){
        System.out.println("non- static method");
    }

    private static void staticMethod(){
        System.out.println("static method");
    }
}
