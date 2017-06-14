import java.util.LinkedList;
import java.util.List;

public class Button implements Observable {
    private List<Observer> observers;
    private String text;

    public Button() {
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(text);
    }

    public void clickButton(){
        System.out.println("Кнопка нажата!");
        text = "HELLO!";
        notifyObservers();
    }
}
