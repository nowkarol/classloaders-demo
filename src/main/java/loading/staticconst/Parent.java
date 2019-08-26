package loading.staticconst;

public class Parent {
    static{
        System.out.println("Parent class loaded");
    }

    public static final String GREETING = "hello";
    // try to remove final
}
