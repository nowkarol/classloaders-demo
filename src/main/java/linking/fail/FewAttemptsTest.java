package linking.fail;

public class FewAttemptsTest {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("linking.fail.FailOnFirstTime");
        } catch (Throwable t){}
        System.out.println("Trying second time");
        Class.forName("linking.fail.FailOnFirstTime");
    }
}
