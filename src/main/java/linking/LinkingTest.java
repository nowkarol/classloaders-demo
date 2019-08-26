package linking;

public class LinkingTest {
    public static void main(String[] args) throws Exception {
        Class.forName("linking.LoadedClass");
//        Class.forName("linking.LoadedClass", false, ClassLoader.getSystemClassLoader());
//        Class<?> classDefinition = ClassLoader.getSystemClassLoader().loadClass("linking.LoadedClass");
//        classDefinition.newInstance();
    }
}
