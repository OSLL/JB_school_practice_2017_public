package java_examples.oop_examples.polimorphism;


public class PolymorphismExample {
    public static void main(String[] args) {
        Mammal monkey = new Monkey();
        Mammal horse = new Horse();
        monkey.sleep();
        horse.sleep();

    }
}
