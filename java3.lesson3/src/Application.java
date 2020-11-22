

import java.io.IOException;
import java.io.RandomAccessFile;

public class Application {

    RandomAccessFile file;
    String link;

    Application(String link){
        this.link = link;
    }
    public long goingTo(int positon) throws IOException {
        file = new RandomAccessFile(link, "r");
        file.seek(positon);
        long pointer = file.getFilePointer();
        file.close();
        return pointer;
    }
    public void readFile() throws IOException {
        file = new RandomAccessFile(link, "r");
        byte[] arr = new byte[500];
        int x;
        while((x = file.read(arr)) > 0){
            System.out.print(new String(arr, 0, "UTF-8"));
        }
        file.close();

    }
    public void pointerPosition (int position) throws IOException {
        file = new RandomAccessFile(link, "r");
        file.seek(position);
        byte[] arr = new byte[500];
        int x;
        while((x = file.read(arr)) > 0){
            System.out.print(new String(arr,0,"UTF-8"));
        }
        file.close();

    }




}


