package reflection;

import reflection.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private Object instantiatedObject;
    private Method[] declaredMethods;


    public Runner(){}

    public void run(Class<?> cls) throws Exception{
        instantiatedObject =  cls.getConstructor().newInstance();
        declaredMethods = cls.getDeclaredMethods();


        for (Method beforeClass : Annotations.getAnnotatedMethods(Annotations.BEFORE_CLASS.getCls(), declaredMethods))
            beforeClass.invoke(instantiatedObject);
        for (Method test : Annotations.getAnnotatedMethods(Annotations.TEST.getCls(), declaredMethods)) {

            for (Method before : Annotations.getAnnotatedMethods(Annotations.BEFORE.getCls(), declaredMethods))
                before.invoke(instantiatedObject);

            parseTestMethodWithParameters(test);

            for (Method after : Annotations.getAnnotatedMethods(Annotations.AFTER.getCls(), declaredMethods))
                after.invoke(instantiatedObject);
        }


        for (Method afterClass : Annotations.getAnnotatedMethods(Annotations.AFTER_CLASS.getCls(), declaredMethods))
            afterClass.invoke(instantiatedObject);
    }

    private void parseTestMethodWithParameters(Method method){
        Test annotation = method.getAnnotation(Test.class);
        try {
            method.invoke(instantiatedObject);
        }catch (Exception e){
            Class<? extends Throwable> expectedException = annotation.expectedException();
            String expectedMessage = annotation.expectedMessage();

            Class<? extends Throwable> actualException = e.getCause().getClass();
            String actualMessage = e.getCause().getMessage();

            if (!expectedException.equals(actualException) || !expectedMessage.equals(actualMessage)){
                e.getCause().printStackTrace();
            }
        }
    }
    private enum Annotations{
        BEFORE_CLASS(BeforeAll.class){},
        BEFORE(Before.class),
        TEST(Test.class),
        AFTER(After.class),
        AFTER_CLASS(AfterAll.class);

        private Class<? extends Annotation> cls;

         Annotations(Class<? extends Annotation> cls){
            this.cls = cls;
        }

        public Class<? extends Annotation> getCls() {
            return cls;
        }

        public static List<Method> getAnnotatedMethods(Class<? extends Annotation> cls, Method[] declaredMethods){
            List<Method> annotatedMethods = new ArrayList<>();
            for (Method method : declaredMethods)
                if (method.isAnnotationPresent(cls))
                    annotatedMethods.add(method);
            return annotatedMethods;
        }

    }

}
