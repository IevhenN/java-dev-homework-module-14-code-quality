package homework.field;

import homework.app.Constants;
import homework.app.Winner;

public class Field {

    private final char[] box;
    private boolean boxEmpty;
    private Winner winner;

    public Field() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boxEmpty = false;
        winner = Winner.DURING;
    }

    public char[] getBox() {
        return box;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public boolean isBoxEmpty() {
        return boxEmpty;
    }

    public void setBoxEmpty(boolean boxEmpty) {
        this.boxEmpty = boxEmpty;
    }

    public void clearBox() {
        if (!isBoxEmpty()) {
            for (byte i = 0; i < Constants.NUMBER_CELLS; i++)
                box[i] = ' ';
            setBoxEmpty(true);
        }
    }

    public boolean isBoxAvailable() {
        boolean boxAvailable = false;

        for (byte i = 0; i < Constants.NUMBER_CELLS; i++) {
            if (box[i] != Constants.USER_SYMBOL && box[i] != Constants.BOT_SYMBOL) {
                boxAvailable = true;
                break;
            }
        }
        return boxAvailable;
    }
}
