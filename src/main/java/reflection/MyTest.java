package reflection;


import reflection.annotations.*;

public class MyTest {

    public static String test = "";

    @Before
    public void init(){
        System.out.println("init");
    }

    @BeforeAll
    public static void beforeClass(){
        test = "before class method";
        System.out.println(test);
    }

    @Test(expectedException = ArithmeticException.class, expectedMessage = "defaultino")
    public void test1(){
        throw new ArithmeticException("default");

    }

    @AfterAll
    public static void afterClass(){
        test = "after class method";
        System.out.println(test);
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @After
    public void destroy(){
        System.out.println("destroy");
    }

    public void notAnnotatedMethod(){
        System.out.println("Not annotated method");
    }




}
