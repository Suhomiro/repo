import org.junit.Assert;
import org.junit.Test;

public class TestCheckMethod {
    @Test
    public void checkMethodTest1(){
        MethodTask methodTask = new MethodTask();
        Assert.assertTrue(methodTask.check(MethodTask.array1));
    }
    @Test
    public void checkMethodTest2(){
        MethodTask methodTask = new MethodTask();
        Assert.assertTrue(MethodTask.check(methodTask.array2));
    }
    @Test
    public void checkMethodTest3(){
        MethodTask methodTask = new MethodTask();
        Assert.assertTrue(MethodTask.check(methodTask.array3));
    }
    @Test
    public void checkMethodTest4(){
        MethodTask methodTask = new MethodTask();
        Assert.assertTrue(MethodTask.check(methodTask.array4));
    }
    @Test
    public void checkMethodTest5(){
        MethodTask methodTask = new MethodTask();
        Assert.assertTrue(MethodTask.check(methodTask.array5));
    }
}
