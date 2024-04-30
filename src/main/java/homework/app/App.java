package homework.app;

import homework.field.Field;
import homework.field.FieldProcessor;

public class App {
    public static void main(String[] args) {
        FieldProcessor boxProcessor = new FieldProcessor(new Field());
        boxProcessor.startGame();
    }
}