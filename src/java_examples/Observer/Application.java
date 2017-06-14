
public class Application {

    public static void main(String[] args) {
        Button button = new Button();
        TextEdit textEdit = new TextEdit(button);
        textEdit.printText();
        button.clickButton();
        textEdit.printText();
    }


}
