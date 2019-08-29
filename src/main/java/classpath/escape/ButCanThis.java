package classpath.escape;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ButCanThis {
    // place text file on somewhere above your project
    public static void main(String[] args) throws Exception {
        URL symlinkUrl = ButCanThis.class.getResource("/symlink");
        System.out.println("URL is " + symlinkUrl);

        new BufferedReader(new InputStreamReader(symlinkUrl.openStream()))
                .lines()
                .forEach(System.out::println);
    }
}
