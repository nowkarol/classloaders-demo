package fewClassLoaders;

public class SomeClass {
    static{
        System.out.println("SomeClass loaded by:" + SomeClass.class.getClassLoader());
    }
}
