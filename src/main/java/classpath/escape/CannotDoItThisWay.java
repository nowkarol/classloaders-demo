package classpath.escape;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

public class CannotDoItThisWay {
    // place text file on somewhere above your project
    public static void main(String[] args) throws Exception {
        URL empty = CannotDoItThisWay.class.getResource("../../../../../../../programowanie/test/");
        System.out.println("URL is " + empty);

        File file = new File("../../../../../../../programowanie/test/");
        System.out.println("File is ");
        System.out.println(Files.readAllLines(file.toPath()));
    }
}
