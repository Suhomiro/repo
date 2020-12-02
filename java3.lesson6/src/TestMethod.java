import org.junit.Assert;
import org.junit.Test;

public class TestMethod {
    @Test
public void methodTaskTest1(){
        MethodTask methodTask = new MethodTask();
        Assert.assertNotNull(methodTask.task2(MethodTask.array1));
    }
    @Test
    public void methodTaskTest2(){
        MethodTask methodTask = new MethodTask();
        Assert.assertNotNull(methodTask.task2(MethodTask.array2));
    }
    @Test
    public void methodTaskTest3(){
        MethodTask methodTask = new MethodTask();
        Assert.assertNotNull(methodTask.task2(MethodTask.array3));
    }
    @Test
    public void methodTaskTest4(){
        MethodTask methodTask = new MethodTask();
        Assert.assertNotNull(methodTask.task2(MethodTask.array4));
    }
    @Test
    public void methodTaskTest5(){
        MethodTask methodTask = new MethodTask();
        Assert.assertNotNull(methodTask.task2(MethodTask.array5));
    }
}
