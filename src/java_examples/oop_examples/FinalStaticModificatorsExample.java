package java_examples.oop_examples;

public class FinalStaticModificatorsExample {

    private static int i = 0;
    private final String msg = "HELLO, WORLD!";

    public final void sayHi() {

        System.out.println(msg);
    }

    public static void main(String[] args) {
        System.out.println(i);
    }

}
