package linking.fail;

public class FailOnFirstTime {
    private  static int attempt = 0;
    static{
        System.out.println("Trying to load FailOnFirstTime");
        if (attempt++ % 2 != 1){
            throw new RuntimeException("This load failed");
        }
        System.out.println("FailOnFirstTime loaded");
    }
}
