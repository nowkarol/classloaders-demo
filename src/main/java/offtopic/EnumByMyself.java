package offtopic;

public class EnumByMyself {
    static EnumByMyself A;
    static EnumByMyself B;
    static EnumByMyself C;

    static{
        A = new EnumByMyself();
        B = new EnumByMyself();
        C = new EnumByMyself();
        System.out.println("Static code");
    }
    {
        System.out.println("Instance code");
    }

    EnumByMyself() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {

    }
}
