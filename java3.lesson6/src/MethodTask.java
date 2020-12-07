
import java.util.Arrays;


public class MethodTask {
    public static final int[] array1 =  {1, 2, 4, 4, 1, 3, 4, 1, 7};
    public static final int[] array2 =  {1, 2, 1, 1, 1, 3, 1, 2, 7};
    public static final int[] array3 =  {6, 8};
    public static final int[] array4 =  {5, 2, 5, 5, 4, 3, 5, 2, 7};
    public static final int[] array5 =  {7, 6, 9};
    public static void main(String[] args) {
        try {
            System.out.println(check(array1));
            System.out.println(Arrays.toString(task2(array1)));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    public static int[] task2(int[] arr){
        int [] result = null;
        int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) {
                    count++;
                    result = new int[arr.length - i - 1];
                    for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                        if (arr[j] == 4) continue;
                        result[k] = arr[j];
                    }


                }

                }
        if(count == 0) {
            throw new RuntimeException("Array index not find '4'");
        }

            return result;
    }
    public static boolean check(int[] arr){
        for (int i = 0; i < arr.length; i++) {
           if(arr[i] == 1 || arr[i] == 4){
               return true;
           }
        }return false;
    }

        }






