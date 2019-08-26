package res;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class AllResources {
    private static int printCounter;
    public static void main(String[] args) {
        printStream(AllResources.class.getResourceAsStream("fromClass"));   //1
        // file:/programowanie/classloaders/target/classes/res/fromClass
        printStream(AllResources.class.getResourceAsStream("/fromClass"));  //2
        // file:/programowanie/classloaders/target/classes/fromClass
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("fromClass"));   //3
        // file:/programowanie/classloaders/target/classes/fromClass
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("/fromClass"));  //4
        // file:/fromClass


        printStream(AllResources.class.getResourceAsStream("fromResources"));   //5
        // file:/programowanie/classloaders/target/classes/res/fromResources
        printStream(AllResources.class.getResourceAsStream("/fromResources"));  //6T
        // file:/programowanie/classloaders/target/classes/fromResources
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("fromResources"));   //7T
        // file:/programowanie/classloaders/target/classes/fromResources
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("/fromResources"));  //8
        // file:/fromResources



        printStream(AllResources.class.getResourceAsStream("res/fromNestedClass"));  //9
        // file:/programowanie/classloaders/target/classes/res/res/fromNestedClass
        printStream(AllResources.class.getResourceAsStream("/res/fromNestedClass")); //10
        // file:/programowanie/classloaders/target/classes/res/fromNestedClass
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("res/fromNestedClass"));  //11
        // file:/programowanie/classloaders/target/classes/res/fromNestedClass
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("/res/fromNestedClass")); //12
        // file:/res/fromNestedClass


        printStream(AllResources.class.getResourceAsStream("res/fromNestedResources"));  //13
        // file:/programowanie/classloaders/target/classes/res/res/fromNestedResources
        printStream(AllResources.class.getResourceAsStream("/res/fromNestedResources")); //14T
        // file:/programowanie/classloaders/target/classes/res/fromNestedResources
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("res/fromNestedResources"));  //15T
        // file:/programowanie/classloaders/target/classes/res/fromNestedResources
        printStream(ClassLoader.getSystemClassLoader().getResourceAsStream("/res/fromNestedResources")); //16
        // file:/res/fromNestedResources
    }


    static void printStream(InputStream inputStream) {
        System.out.print("Line " + ++printCounter + " ");
        String result = null;
        if (inputStream != null) {
            result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining());
        }
        System.out.println(result);
    }
}
