package loadEverything;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class CannotDoThat {

    public static void main(String[] args) throws Exception {

        ClassLoader customStringCl = getCustomStringLoader();

        Object o = Class.forName("java.lang.String", true, customStringCl).newInstance();
        System.out.println(o);
    }

    private static ClassLoader getCustomStringLoader() {
        return new ClassLoader(getNullLoader()) {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if (name.equals("java.lang.String")){
                    try {
                        URL urlWithClasses = new URL("file", "", System.getProperty("user.dir") + "/target/classes/java/lang/String.class");
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        InputStream inputStream = urlWithClasses.openStream();
                        int result;
                        while ((result = inputStream.read()) != -1){
                            baos.write(result);
                        }
                        baos.flush();
                        byte[] classInArray = baos.toByteArray();
                        return defineClass("java.lang.String", classInArray , 0, classInArray.length);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                return super.loadClass(name);
            }

            @Override
            public String toString() {
                return "Custom String Class Loader";
            }
        };
    }

    static ClassLoader getNullLoader(){
        return new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                throw new ClassNotFoundException("Won't load this class");
            }
        };
    }
}
