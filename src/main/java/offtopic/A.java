package offtopic;

public class A extends B{
    String greeting = "hello";
    {
        System.out.println(greeting);
        greeting = "A";
        System.out.println("Instance code of A");
    }

    A() {
        super(print("During call to super of A"));
        System.out.println("Accessing instance variable:" + greeting);
        System.out.println("End of A Constructor");
    }


    private static Void print(String a) {
        System.out.println(a);
        return null;
    }

    public static void main(String[] args) {
        new A();
    }
}

class B{
    String greeting;

    {
        greeting = "B";
        System.out.println("Instance code of B");
    }
    B(Void a) {
        System.out.println("Constructor of B");
    }
}




