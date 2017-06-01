package java_examples.oop_examples;

public class Monkey implements MammalInterface {
    private String name;

    public void sleep() { // Этот метод обязательно должен быть реализован!
        System.out.println("zzzzzzzz");
    }

    public boolean getIsCheeksPresent(){
        return isCheeksPresent; // все поля интерфейса доступны наследникам
    }
}
