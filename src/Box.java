import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box {
    private static Double[] orangeFruit = {1.0,1.0,1.0,1.0,1.0};
    private static Double[] appleFruit = {1.0, 1.0, 1.0, 1.0, 1.0};
    private static final double appleWeight = 1.5;
    private static final double orangeWeight = 1.0;

    public static void main(String[] args) {
        Apple appleBox = new Apple(appleFruit);
        Orange orangeBox = new Orange(orangeFruit);
        System.out.println("Orange box weight: " + orangeBox.getWeight(orangeWeight));
        System.out.println("Apple box weight: " + appleBox.getWeight(appleWeight));
        System.out.println("Boxes weight are: " + compare(appleBox.getWeight(appleWeight), orangeBox.getWeight(orangeWeight)));
        System.out.println("Orange box empty: " + orangeBox.clear());
        System.out.println("Apple box empty: " + appleBox.clear());
        System.out.println(Arrays.toString(appleBox.setFruit(orangeFruit)));
        System.out.println(Arrays.toString(orangeBox.setFruit(appleFruit)));
    }
    private static boolean compare(Object orange, Object apple){
        if(orange.equals(apple)){
            return true;
        }
        return false;
    }

}
