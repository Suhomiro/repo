public class TestClass {
    @BeforeSuite
    public static void start(){
        System.out.println("START");
    }
    @Test(priority = 1)
    public static void methodThree(){
        System.out.println("3");
    }
    @Test(priority = 4)
    public static void methodTwo(){
        System.out.println("2");
    }
    @Test(priority = 2)
    public static void methodOne(){
        System.out.println("1");
    }
    @AfterSuite
    public static void stop(){
        System.out.println("STOP");
    }
}
