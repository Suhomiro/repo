import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        process(TestClass.class);
    }

    public static void process(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList();
        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {
                int prioritate = o.getAnnotation(Test.class).priority();
                if (prioritate < 1 || prioritate > 10) {
                    throw new RuntimeException("Priority false");
                }
                list.add(o);
            }
        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });
        for (Method o: methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("BeforeSuite false");
                list.add(0, o);
            }
        }
        for (Method o: methods) {
            if(o.isAnnotationPresent(AfterSuite.class)){
                if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("AfterSuit false");
                    list.add(o);
                }
            }

        for (Method o: list) {
        o.invoke(null);
        }
    }
}
