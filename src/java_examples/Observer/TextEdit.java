public class TextEdit implements Observer {

    private Button button;
    private String text;

    public TextEdit(Button button) {
        this.button = button;
        this.button.registerObserver(this);
    }

    @Override
    public void update(String text) {
        this.text = text;
    }

    public void printText(){
        System.out.println("Текст в текстовом поле: " + text);
    }
}
