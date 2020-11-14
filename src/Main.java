import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
   private static final String[] symbol = {"1", "2", "3", "4", "5"};

    public static void main(String[] args) {
        indexChange(symbol);
        arrayToList(symbol);
    }

    private static void indexChange(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String change1 = array[2];
            String change2 = array[0];
            array[0] = change1;
            array[2] = change2;
                System.out.println(array[i]);
            }
        }
        private static void arrayToList(String[] array){
        List<String> list = Arrays.asList(array);
            System.out.println(list);
        }
    }


