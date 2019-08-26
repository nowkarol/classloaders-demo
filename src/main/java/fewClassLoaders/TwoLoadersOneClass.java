package fewClassLoaders;

import java.lang.reflect.Method;

import sun.misc.Launcher;

public class TwoLoadersOneClass {
    public static void main(String[] args) throws Exception {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        ClassLoader otherSystemLoader = getAnotherSystemCL();
        Class<?> fromFirstLoader = systemLoader.loadClass("fewClassLoaders.SomeClass");
        Class<?> fromSecondLoader = otherSystemLoader.loadClass("fewClassLoaders.SomeClass");

        System.out.println("Two classes are the same: " + fromFirstLoader.equals(fromSecondLoader));

        Object firtSomeClass = fromFirstLoader.newInstance();
        Object secondSomeClass = fromSecondLoader.newInstance();
        SomeClass willSucceed = (SomeClass) firtSomeClass;
        System.out.println("After casting first class");

        SomeClass willFail = (SomeClass) secondSomeClass;
        System.out.println("After casting second class");

//        SomeClass someClass = new SomeClass(); // replace first system CL
    }

    public static ClassLoader getAnotherSystemCL() throws Exception {
        Class<?> declaredClass = Launcher.class.getDeclaredClasses()[2];
        Method getAppClassLoader = declaredClass.getMethod("getAppClassLoader", ClassLoader.class);
        getAppClassLoader.setAccessible(true);
        return (ClassLoader) getAppClassLoader.invoke(null, ClassLoader.getSystemClassLoader().getParent());
    }

}
