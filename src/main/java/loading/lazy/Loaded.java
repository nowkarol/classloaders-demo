package loading.lazy;

public class Loaded {
    static {
        System.out.println("Loaded loaded");
    }

    public static void method() {
        System.out.println("Static method was called");
    }
}
