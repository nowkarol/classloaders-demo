package linking;

public class LoadedClass {
    static{
        System.out.println("LoadedClass loaded");
    }

    private static LinkedClass linkedClass = new LinkedClass();
}
