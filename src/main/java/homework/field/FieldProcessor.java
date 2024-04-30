package homework.field;

import homework.app.Constants;
import homework.app.Winner;

public class FieldProcessor {
    Field field;

    public FieldProcessor(Field box) {
        this.field = box;
    }

    public void startGame() {
        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            showCurrentState();
            field.clearBox();

            if (isGameOver()) break;

            userStep();

            if (isLine(Constants.USER_SYMBOL)) {
                field.setWinner(Winner.WON);
            } else if (!field.isBoxAvailable()) {
                field.setWinner(Winner.DRAW);
            } else {
                botStep();
                if (isLine(Constants.BOT_SYMBOL)) {
                    field.setWinner(Winner.LOST);
                }
            }
        }
    }

    private boolean isGameOver() {
        Winner winner = field.getWinner();
        if (winner == Winner.WON) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == Winner.LOST) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == Winner.DRAW) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    private void botStep() {
        char[] box = field.getBox();
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * Constants.NUMBER_CELLS + 1);
            if (box[rand - 1] != Constants.USER_SYMBOL && box[rand - 1] != Constants.BOT_SYMBOL) {
                box[rand - 1] = Constants.BOT_SYMBOL;
                break;
            }
        }
    }

    private void userStep() {
        byte input;
        char[] box = field.getBox();
        while (true) {
            input = Constants.SCAN.nextByte();
            if (input > 0 && input <= Constants.NUMBER_CELLS) {
                if (box[input - 1] == Constants.USER_SYMBOL || box[input - 1] == Constants.BOT_SYMBOL)
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = Constants.USER_SYMBOL;
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private void showCurrentState() {
        char[] box = field.getBox();
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private boolean isLine(char symbol) {
        char[] box = field.getBox();
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) || (box[3] == symbol && box[4] == symbol && box[5] == symbol) || (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) || (box[1] == symbol && box[4] == symbol && box[7] == symbol) || (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

}
