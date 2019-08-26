package java.lang;

public class String {
    public static final boolean CUSTOM = true;

    static{
        System.out.println("Custom String loaded");
    }

    @Override
    public String toString() {
        return "this is CustomString described using normal String";
    }
}
