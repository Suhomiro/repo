import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static File pack1 = new File("task1");
    private static File task1 = new File("task1/test1.txt");
    private static String txtTask1 = "Ferrari, Renault, Mercedes, BMW, Audi, Honda";

    private static File pack2 = new File("task2");
    private static File task2_1 = new File("task2/Ferrari.txt");
    private static File task2_2 = new File("task2/Renault.txt");
    private static File task2_3 = new File("task2/Audi.txt");
    private static File task2_4 = new File("task2/BMW.txt");
    private static File task2_5 = new File("task2/Mercedes.txt");
    private static File groupCars = new File("task2/GroupCars.txt");

    public static void main(String[] args) throws IOException {
        pack1.mkdirs();
        task1.createNewFile();
        readFile(task1);
        writeFile(task1, false, txtTask1);
        pack2.mkdirs();
        task2_1.createNewFile();
        task2_2.createNewFile();
        task2_3.createNewFile();
        task2_4.createNewFile();
        task2_5.createNewFile();

        ArrayList<InputStream> arrIn = new ArrayList<>();
        arrIn.add(new FileInputStream("task2/Ferrari.txt"));
        arrIn.add(new FileInputStream("task2/Mercedes.txt"));
        arrIn.add(new FileInputStream("task2/Renault.txt"));
        arrIn.add(new FileInputStream("task2/Audi.txt"));
        arrIn.add(new FileInputStream("task2/BMW.txt"));
        groupedFiles(arrIn,groupCars);


    }
    private static void groupedFiles(List list, File file){
       try(SequenceInputStream in = new SequenceInputStream(Collections.enumeration(list));
        FileOutputStream out = new FileOutputStream(file)) {
           int x;
           while ((x = in.read()) != 0) {
               out.write((char) x);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    private static void writeFile(File file, boolean append, String string){
        try(FileWriter writer = new FileWriter(file, append)){
            writer.write(string);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void readFile(File file){
        try(FileInputStream fis = new FileInputStream(file)){
            int x;
            while((x = fis.read()) != -1){

                System.out.print((char)x);
            }
        }
        catch(IOException e){

            e.printStackTrace();
        }

    }
}

