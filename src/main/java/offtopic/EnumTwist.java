package offtopic;

 public enum EnumTwist {

    A(), B(), C();

    EnumTwist() {
        System.out.println("Constructor");
    }

    {
        System.out.println("Instance code of enum");
    }

    static {
        System.out.println("Static code of enum");
    }

    public static void main(String[] args) {
        EnumTwist a = EnumTwist.A;
    }
}
