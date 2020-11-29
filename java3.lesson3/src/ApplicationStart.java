import java.io.IOException;

public class ApplicationStart {
    public static void main(String[] args) throws IOException {

        Application application = new Application("task2/GroupCars.txt");
        application.goingTo(0);
        application.readFile();
        application.pointerPosition(1800);
    }
}
