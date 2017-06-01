package java_examples.oop_examples.polimorphism;


public class Monkey extends Mammal {
    private String name;

    public void sleep() { // Этот метод обязательно должен быть реализован!
        System.out.println("zzzzzzzz");
    }

}
