package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.app.Activity;
import android.widget.Button;
import greenvaultgames.com.supernoughtsandcrosses_singledevice.GameBoard.Player;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 23/09/2015.
 */
public class ButtonColourResolver {
    private Activity activity;
    private GameDataStore dataStore;
    private GameBoardModel model;

    public ButtonColourResolver(Activity aActivity, GameDataStore aDataStore, GameBoardModel aModel) {
        activity = aActivity;
        dataStore = aDataStore;
        model = aModel;
    }

    public void resolveColoursAfterMove(){
        if( model.gameBoardIsFull(dataStore._lastMove.lastGameButton)){
            colourAllButtonsNextMoveColour();
        }
        else{
            colourWinningBoards();

            colourPlayableMoves(dataStore._lastMove.lastGameButton);
        }
    }

    public void colourAllButtonsNextMoveColour() {
        colourButtonNextMoveColour(R.id.b1_1);
        colourButtonNextMoveColour(R.id.b1_2);
        colourButtonNextMoveColour(R.id.b1_3);
        colourButtonNextMoveColour(R.id.b1_4);
        colourButtonNextMoveColour(R.id.b1_5);
        colourButtonNextMoveColour(R.id.b1_6);
        colourButtonNextMoveColour(R.id.b1_7);
        colourButtonNextMoveColour(R.id.b1_8);
        colourButtonNextMoveColour(R.id.b1_9);

        colourButtonNextMoveColour(R.id.b2_1);
        colourButtonNextMoveColour(R.id.b2_2);
        colourButtonNextMoveColour(R.id.b2_3);
        colourButtonNextMoveColour(R.id.b2_4);
        colourButtonNextMoveColour(R.id.b2_5);
        colourButtonNextMoveColour(R.id.b2_6);
        colourButtonNextMoveColour(R.id.b2_7);
        colourButtonNextMoveColour(R.id.b2_8);
        colourButtonNextMoveColour(R.id.b2_9);

        colourButtonNextMoveColour(R.id.b3_1);
        colourButtonNextMoveColour(R.id.b3_2);
        colourButtonNextMoveColour(R.id.b3_3);
        colourButtonNextMoveColour(R.id.b3_4);
        colourButtonNextMoveColour(R.id.b3_5);
        colourButtonNextMoveColour(R.id.b3_6);
        colourButtonNextMoveColour(R.id.b3_7);
        colourButtonNextMoveColour(R.id.b3_8);
        colourButtonNextMoveColour(R.id.b3_9);

        colourButtonNextMoveColour(R.id.b4_1);
        colourButtonNextMoveColour(R.id.b4_2);
        colourButtonNextMoveColour(R.id.b4_3);
        colourButtonNextMoveColour(R.id.b4_4);
        colourButtonNextMoveColour(R.id.b4_5);
        colourButtonNextMoveColour(R.id.b4_6);
        colourButtonNextMoveColour(R.id.b4_7);
        colourButtonNextMoveColour(R.id.b4_8);
        colourButtonNextMoveColour(R.id.b4_9);

        colourButtonNextMoveColour(R.id.b5_1);
        colourButtonNextMoveColour(R.id.b5_2);
        colourButtonNextMoveColour(R.id.b5_3);
        colourButtonNextMoveColour(R.id.b5_4);
        colourButtonNextMoveColour(R.id.b5_5);
        colourButtonNextMoveColour(R.id.b5_6);
        colourButtonNextMoveColour(R.id.b5_7);
        colourButtonNextMoveColour(R.id.b5_8);
        colourButtonNextMoveColour(R.id.b5_9);

        colourButtonNextMoveColour(R.id.b6_1);
        colourButtonNextMoveColour(R.id.b6_2);
        colourButtonNextMoveColour(R.id.b6_3);
        colourButtonNextMoveColour(R.id.b6_4);
        colourButtonNextMoveColour(R.id.b6_5);
        colourButtonNextMoveColour(R.id.b6_6);
        colourButtonNextMoveColour(R.id.b6_7);
        colourButtonNextMoveColour(R.id.b6_8);
        colourButtonNextMoveColour(R.id.b6_9);

        colourButtonNextMoveColour(R.id.b7_1);
        colourButtonNextMoveColour(R.id.b7_2);
        colourButtonNextMoveColour(R.id.b7_3);
        colourButtonNextMoveColour(R.id.b7_4);
        colourButtonNextMoveColour(R.id.b7_5);
        colourButtonNextMoveColour(R.id.b7_6);
        colourButtonNextMoveColour(R.id.b7_7);
        colourButtonNextMoveColour(R.id.b7_8);
        colourButtonNextMoveColour(R.id.b7_9);

        colourButtonNextMoveColour(R.id.b8_1);
        colourButtonNextMoveColour(R.id.b8_2);
        colourButtonNextMoveColour(R.id.b8_3);
        colourButtonNextMoveColour(R.id.b8_4);
        colourButtonNextMoveColour(R.id.b8_5);
        colourButtonNextMoveColour(R.id.b8_6);
        colourButtonNextMoveColour(R.id.b8_7);
        colourButtonNextMoveColour(R.id.b8_8);
        colourButtonNextMoveColour(R.id.b8_9);

        colourButtonNextMoveColour(R.id.b9_1);
        colourButtonNextMoveColour(R.id.b9_2);
        colourButtonNextMoveColour(R.id.b9_3);
        colourButtonNextMoveColour(R.id.b9_4);
        colourButtonNextMoveColour(R.id.b9_5);
        colourButtonNextMoveColour(R.id.b9_6);
        colourButtonNextMoveColour(R.id.b9_7);
        colourButtonNextMoveColour(R.id.b9_8);
        colourButtonNextMoveColour(R.id.b9_9);
    }

    private void colourAllButtonsDefaultButtonColour() {
        if (dataStore._boardsWon.get(0) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b1_1);
            colourButtonDefaultButtonColour(R.id.b1_2);
            colourButtonDefaultButtonColour(R.id.b1_3);
            colourButtonDefaultButtonColour(R.id.b1_4);
            colourButtonDefaultButtonColour(R.id.b1_5);
            colourButtonDefaultButtonColour(R.id.b1_6);
            colourButtonDefaultButtonColour(R.id.b1_7);
            colourButtonDefaultButtonColour(R.id.b1_8);
            colourButtonDefaultButtonColour(R.id.b1_9);
        }
        if (dataStore._boardsWon.get(1) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b2_1);
            colourButtonDefaultButtonColour(R.id.b2_2);
            colourButtonDefaultButtonColour(R.id.b2_3);
            colourButtonDefaultButtonColour(R.id.b2_4);
            colourButtonDefaultButtonColour(R.id.b2_5);
            colourButtonDefaultButtonColour(R.id.b2_6);
            colourButtonDefaultButtonColour(R.id.b2_7);
            colourButtonDefaultButtonColour(R.id.b2_8);
            colourButtonDefaultButtonColour(R.id.b2_9);
        }
        if (dataStore._boardsWon.get(2) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b3_1);
            colourButtonDefaultButtonColour(R.id.b3_2);
            colourButtonDefaultButtonColour(R.id.b3_3);
            colourButtonDefaultButtonColour(R.id.b3_4);
            colourButtonDefaultButtonColour(R.id.b3_5);
            colourButtonDefaultButtonColour(R.id.b3_6);
            colourButtonDefaultButtonColour(R.id.b3_7);
            colourButtonDefaultButtonColour(R.id.b3_8);
            colourButtonDefaultButtonColour(R.id.b3_9);
        }
        if (dataStore._boardsWon.get(3) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b4_1);
            colourButtonDefaultButtonColour(R.id.b4_2);
            colourButtonDefaultButtonColour(R.id.b4_3);
            colourButtonDefaultButtonColour(R.id.b4_4);
            colourButtonDefaultButtonColour(R.id.b4_5);
            colourButtonDefaultButtonColour(R.id.b4_6);
            colourButtonDefaultButtonColour(R.id.b4_7);
            colourButtonDefaultButtonColour(R.id.b4_8);
            colourButtonDefaultButtonColour(R.id.b4_9);
        }
        if (dataStore._boardsWon.get(4) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b5_1);
            colourButtonDefaultButtonColour(R.id.b5_2);
            colourButtonDefaultButtonColour(R.id.b5_3);
            colourButtonDefaultButtonColour(R.id.b5_4);
            colourButtonDefaultButtonColour(R.id.b5_5);
            colourButtonDefaultButtonColour(R.id.b5_6);
            colourButtonDefaultButtonColour(R.id.b5_7);
            colourButtonDefaultButtonColour(R.id.b5_8);
            colourButtonDefaultButtonColour(R.id.b5_9);
        }
        if (dataStore._boardsWon.get(5) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b6_1);
            colourButtonDefaultButtonColour(R.id.b6_2);
            colourButtonDefaultButtonColour(R.id.b6_3);
            colourButtonDefaultButtonColour(R.id.b6_4);
            colourButtonDefaultButtonColour(R.id.b6_5);
            colourButtonDefaultButtonColour(R.id.b6_6);
            colourButtonDefaultButtonColour(R.id.b6_7);
            colourButtonDefaultButtonColour(R.id.b6_8);
            colourButtonDefaultButtonColour(R.id.b6_9);
        }
        if (dataStore._boardsWon.get(6) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b7_1);
            colourButtonDefaultButtonColour(R.id.b7_2);
            colourButtonDefaultButtonColour(R.id.b7_3);
            colourButtonDefaultButtonColour(R.id.b7_4);
            colourButtonDefaultButtonColour(R.id.b7_5);
            colourButtonDefaultButtonColour(R.id.b7_6);
            colourButtonDefaultButtonColour(R.id.b7_7);
            colourButtonDefaultButtonColour(R.id.b7_8);
            colourButtonDefaultButtonColour(R.id.b7_9);
        }
        if (dataStore._boardsWon.get(7) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b8_1);
            colourButtonDefaultButtonColour(R.id.b8_2);
            colourButtonDefaultButtonColour(R.id.b8_3);
            colourButtonDefaultButtonColour(R.id.b8_4);
            colourButtonDefaultButtonColour(R.id.b8_5);
            colourButtonDefaultButtonColour(R.id.b8_6);
            colourButtonDefaultButtonColour(R.id.b8_7);
            colourButtonDefaultButtonColour(R.id.b8_8);
            colourButtonDefaultButtonColour(R.id.b8_9);
        }
        if (dataStore._boardsWon.get(8) == Player.PlayerNull) {
            colourButtonDefaultButtonColour(R.id.b9_1);
            colourButtonDefaultButtonColour(R.id.b9_2);
            colourButtonDefaultButtonColour(R.id.b9_3);
            colourButtonDefaultButtonColour(R.id.b9_4);
            colourButtonDefaultButtonColour(R.id.b9_5);
            colourButtonDefaultButtonColour(R.id.b9_6);
            colourButtonDefaultButtonColour(R.id.b9_7);
            colourButtonDefaultButtonColour(R.id.b9_8);
            colourButtonDefaultButtonColour(R.id.b9_9);
        }

        colourWinningBoards();
    }

    private void colourWinningBoards(){
        colourPlayer1WinningBoards();
        colourPlayer2WinningBoards();
    }

    private void colourPlayer1WinningBoards() {
        if (dataStore._boardsWon.get(0) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b1_1);
            colourButtonPlayer1WonColour(R.id.b1_2);
            colourButtonPlayer1WonColour(R.id.b1_3);
            colourButtonPlayer1WonColour(R.id.b1_4);
            colourButtonPlayer1WonColour(R.id.b1_5);
            colourButtonPlayer1WonColour(R.id.b1_6);
            colourButtonPlayer1WonColour(R.id.b1_7);
            colourButtonPlayer1WonColour(R.id.b1_8);
            colourButtonPlayer1WonColour(R.id.b1_9);
        }
        if (dataStore._boardsWon.get(1) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b2_1);
            colourButtonPlayer1WonColour(R.id.b2_2);
            colourButtonPlayer1WonColour(R.id.b2_3);
            colourButtonPlayer1WonColour(R.id.b2_4);
            colourButtonPlayer1WonColour(R.id.b2_5);
            colourButtonPlayer1WonColour(R.id.b2_6);
            colourButtonPlayer1WonColour(R.id.b2_7);
            colourButtonPlayer1WonColour(R.id.b2_8);
            colourButtonPlayer1WonColour(R.id.b2_9);
        }
        if (dataStore._boardsWon.get(2) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b3_1);
            colourButtonPlayer1WonColour(R.id.b3_2);
            colourButtonPlayer1WonColour(R.id.b3_3);
            colourButtonPlayer1WonColour(R.id.b3_4);
            colourButtonPlayer1WonColour(R.id.b3_5);
            colourButtonPlayer1WonColour(R.id.b3_6);
            colourButtonPlayer1WonColour(R.id.b3_7);
            colourButtonPlayer1WonColour(R.id.b3_8);
            colourButtonPlayer1WonColour(R.id.b3_9);
        }
        if (dataStore._boardsWon.get(3) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b4_1);
            colourButtonPlayer1WonColour(R.id.b4_2);
            colourButtonPlayer1WonColour(R.id.b4_3);
            colourButtonPlayer1WonColour(R.id.b4_4);
            colourButtonPlayer1WonColour(R.id.b4_5);
            colourButtonPlayer1WonColour(R.id.b4_6);
            colourButtonPlayer1WonColour(R.id.b4_7);
            colourButtonPlayer1WonColour(R.id.b4_8);
            colourButtonPlayer1WonColour(R.id.b4_9);
        }
        if (dataStore._boardsWon.get(4) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b5_1);
            colourButtonPlayer1WonColour(R.id.b5_2);
            colourButtonPlayer1WonColour(R.id.b5_3);
            colourButtonPlayer1WonColour(R.id.b5_4);
            colourButtonPlayer1WonColour(R.id.b5_5);
            colourButtonPlayer1WonColour(R.id.b5_6);
            colourButtonPlayer1WonColour(R.id.b5_7);
            colourButtonPlayer1WonColour(R.id.b5_8);
            colourButtonPlayer1WonColour(R.id.b5_9);
        }
        if (dataStore._boardsWon.get(5) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b6_1);
            colourButtonPlayer1WonColour(R.id.b6_2);
            colourButtonPlayer1WonColour(R.id.b6_3);
            colourButtonPlayer1WonColour(R.id.b6_4);
            colourButtonPlayer1WonColour(R.id.b6_5);
            colourButtonPlayer1WonColour(R.id.b6_6);
            colourButtonPlayer1WonColour(R.id.b6_7);
            colourButtonPlayer1WonColour(R.id.b6_8);
            colourButtonPlayer1WonColour(R.id.b6_9);
        }
        if (dataStore._boardsWon.get(6) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b7_1);
            colourButtonPlayer1WonColour(R.id.b7_2);
            colourButtonPlayer1WonColour(R.id.b7_3);
            colourButtonPlayer1WonColour(R.id.b7_4);
            colourButtonPlayer1WonColour(R.id.b7_5);
            colourButtonPlayer1WonColour(R.id.b7_6);
            colourButtonPlayer1WonColour(R.id.b7_7);
            colourButtonPlayer1WonColour(R.id.b7_8);
            colourButtonPlayer1WonColour(R.id.b7_9);
        }
        if (dataStore._boardsWon.get(7) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b8_1);
            colourButtonPlayer1WonColour(R.id.b8_2);
            colourButtonPlayer1WonColour(R.id.b8_3);
            colourButtonPlayer1WonColour(R.id.b8_4);
            colourButtonPlayer1WonColour(R.id.b8_5);
            colourButtonPlayer1WonColour(R.id.b8_6);
            colourButtonPlayer1WonColour(R.id.b8_7);
            colourButtonPlayer1WonColour(R.id.b8_8);
            colourButtonPlayer1WonColour(R.id.b8_9);
        }
        if (dataStore._boardsWon.get(8) == Player.Player1) {
            colourButtonPlayer1WonColour(R.id.b9_1);
            colourButtonPlayer1WonColour(R.id.b9_2);
            colourButtonPlayer1WonColour(R.id.b9_3);
            colourButtonPlayer1WonColour(R.id.b9_4);
            colourButtonPlayer1WonColour(R.id.b9_5);
            colourButtonPlayer1WonColour(R.id.b9_6);
            colourButtonPlayer1WonColour(R.id.b9_7);
            colourButtonPlayer1WonColour(R.id.b9_8);
            colourButtonPlayer1WonColour(R.id.b9_9);
        }
    }

    private void colourPlayer2WinningBoards() {
        if (dataStore._boardsWon.get(0) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b1_1);
            colourButtonPlayer2WonColour(R.id.b1_2);
            colourButtonPlayer2WonColour(R.id.b1_3);
            colourButtonPlayer2WonColour(R.id.b1_4);
            colourButtonPlayer2WonColour(R.id.b1_5);
            colourButtonPlayer2WonColour(R.id.b1_6);
            colourButtonPlayer2WonColour(R.id.b1_7);
            colourButtonPlayer2WonColour(R.id.b1_8);
            colourButtonPlayer2WonColour(R.id.b1_9);
        }
        if (dataStore._boardsWon.get(1) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b2_1);
            colourButtonPlayer2WonColour(R.id.b2_2);
            colourButtonPlayer2WonColour(R.id.b2_3);
            colourButtonPlayer2WonColour(R.id.b2_4);
            colourButtonPlayer2WonColour(R.id.b2_5);
            colourButtonPlayer2WonColour(R.id.b2_6);
            colourButtonPlayer2WonColour(R.id.b2_7);
            colourButtonPlayer2WonColour(R.id.b2_8);
            colourButtonPlayer2WonColour(R.id.b2_9);
        }
        if (dataStore._boardsWon.get(2) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b3_1);
            colourButtonPlayer2WonColour(R.id.b3_2);
            colourButtonPlayer2WonColour(R.id.b3_3);
            colourButtonPlayer2WonColour(R.id.b3_4);
            colourButtonPlayer2WonColour(R.id.b3_5);
            colourButtonPlayer2WonColour(R.id.b3_6);
            colourButtonPlayer2WonColour(R.id.b3_7);
            colourButtonPlayer2WonColour(R.id.b3_8);
            colourButtonPlayer2WonColour(R.id.b3_9);
        }
        if (dataStore._boardsWon.get(3) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b4_1);
            colourButtonPlayer2WonColour(R.id.b4_2);
            colourButtonPlayer2WonColour(R.id.b4_3);
            colourButtonPlayer2WonColour(R.id.b4_4);
            colourButtonPlayer2WonColour(R.id.b4_5);
            colourButtonPlayer2WonColour(R.id.b4_6);
            colourButtonPlayer2WonColour(R.id.b4_7);
            colourButtonPlayer2WonColour(R.id.b4_8);
            colourButtonPlayer2WonColour(R.id.b4_9);
        }
        if (dataStore._boardsWon.get(4) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b5_1);
            colourButtonPlayer2WonColour(R.id.b5_2);
            colourButtonPlayer2WonColour(R.id.b5_3);
            colourButtonPlayer2WonColour(R.id.b5_4);
            colourButtonPlayer2WonColour(R.id.b5_5);
            colourButtonPlayer2WonColour(R.id.b5_6);
            colourButtonPlayer2WonColour(R.id.b5_7);
            colourButtonPlayer2WonColour(R.id.b5_8);
            colourButtonPlayer2WonColour(R.id.b5_9);
        }
        if (dataStore._boardsWon.get(5) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b6_1);
            colourButtonPlayer2WonColour(R.id.b6_2);
            colourButtonPlayer2WonColour(R.id.b6_3);
            colourButtonPlayer2WonColour(R.id.b6_4);
            colourButtonPlayer2WonColour(R.id.b6_5);
            colourButtonPlayer2WonColour(R.id.b6_6);
            colourButtonPlayer2WonColour(R.id.b6_7);
            colourButtonPlayer2WonColour(R.id.b6_8);
            colourButtonPlayer2WonColour(R.id.b6_9);
        }
        if (dataStore._boardsWon.get(6) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b7_1);
            colourButtonPlayer2WonColour(R.id.b7_2);
            colourButtonPlayer2WonColour(R.id.b7_3);
            colourButtonPlayer2WonColour(R.id.b7_4);
            colourButtonPlayer2WonColour(R.id.b7_5);
            colourButtonPlayer2WonColour(R.id.b7_6);
            colourButtonPlayer2WonColour(R.id.b7_7);
            colourButtonPlayer2WonColour(R.id.b7_8);
            colourButtonPlayer2WonColour(R.id.b7_9);
        }
        if (dataStore._boardsWon.get(7) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b8_1);
            colourButtonPlayer2WonColour(R.id.b8_2);
            colourButtonPlayer2WonColour(R.id.b8_3);
            colourButtonPlayer2WonColour(R.id.b8_4);
            colourButtonPlayer2WonColour(R.id.b8_5);
            colourButtonPlayer2WonColour(R.id.b8_6);
            colourButtonPlayer2WonColour(R.id.b8_7);
            colourButtonPlayer2WonColour(R.id.b8_8);
            colourButtonPlayer2WonColour(R.id.b8_9);
        }
        if (dataStore._boardsWon.get(8) == Player.Player2) {
            colourButtonPlayer2WonColour(R.id.b9_1);
            colourButtonPlayer2WonColour(R.id.b9_2);
            colourButtonPlayer2WonColour(R.id.b9_3);
            colourButtonPlayer2WonColour(R.id.b9_4);
            colourButtonPlayer2WonColour(R.id.b9_5);
            colourButtonPlayer2WonColour(R.id.b9_6);
            colourButtonPlayer2WonColour(R.id.b9_7);
            colourButtonPlayer2WonColour(R.id.b9_8);
            colourButtonPlayer2WonColour(R.id.b9_9);
        }
    }

    private void colourPlayableMoves(int gameBoard) {
        colourAllButtonsDefaultButtonColour();

        switch (gameBoard) {
            case 1:
                colourButtonNextMoveColour(R.id.b1_1);
                colourButtonNextMoveColour(R.id.b1_2);
                colourButtonNextMoveColour(R.id.b1_3);
                colourButtonNextMoveColour(R.id.b1_4);
                colourButtonNextMoveColour(R.id.b1_5);
                colourButtonNextMoveColour(R.id.b1_6);
                colourButtonNextMoveColour(R.id.b1_7);
                colourButtonNextMoveColour(R.id.b1_8);
                colourButtonNextMoveColour(R.id.b1_9);
                break;
            case 2:
                colourButtonNextMoveColour(R.id.b2_1);
                colourButtonNextMoveColour(R.id.b2_2);
                colourButtonNextMoveColour(R.id.b2_3);
                colourButtonNextMoveColour(R.id.b2_4);
                colourButtonNextMoveColour(R.id.b2_5);
                colourButtonNextMoveColour(R.id.b2_6);
                colourButtonNextMoveColour(R.id.b2_7);
                colourButtonNextMoveColour(R.id.b2_8);
                colourButtonNextMoveColour(R.id.b2_9);
                break;
            case 3:
                colourButtonNextMoveColour(R.id.b3_1);
                colourButtonNextMoveColour(R.id.b3_2);
                colourButtonNextMoveColour(R.id.b3_3);
                colourButtonNextMoveColour(R.id.b3_4);
                colourButtonNextMoveColour(R.id.b3_5);
                colourButtonNextMoveColour(R.id.b3_6);
                colourButtonNextMoveColour(R.id.b3_7);
                colourButtonNextMoveColour(R.id.b3_8);
                colourButtonNextMoveColour(R.id.b3_9);
                break;
            case 4:
                colourButtonNextMoveColour(R.id.b4_1);
                colourButtonNextMoveColour(R.id.b4_2);
                colourButtonNextMoveColour(R.id.b4_3);
                colourButtonNextMoveColour(R.id.b4_4);
                colourButtonNextMoveColour(R.id.b4_5);
                colourButtonNextMoveColour(R.id.b4_6);
                colourButtonNextMoveColour(R.id.b4_7);
                colourButtonNextMoveColour(R.id.b4_8);
                colourButtonNextMoveColour(R.id.b4_9);
                break;
            case 5:
                colourButtonNextMoveColour(R.id.b5_1);
                colourButtonNextMoveColour(R.id.b5_2);
                colourButtonNextMoveColour(R.id.b5_3);
                colourButtonNextMoveColour(R.id.b5_4);
                colourButtonNextMoveColour(R.id.b5_5);
                colourButtonNextMoveColour(R.id.b5_6);
                colourButtonNextMoveColour(R.id.b5_7);
                colourButtonNextMoveColour(R.id.b5_8);
                colourButtonNextMoveColour(R.id.b5_9);
                break;
            case 6:
                colourButtonNextMoveColour(R.id.b6_1);
                colourButtonNextMoveColour(R.id.b6_2);
                colourButtonNextMoveColour(R.id.b6_3);
                colourButtonNextMoveColour(R.id.b6_4);
                colourButtonNextMoveColour(R.id.b6_5);
                colourButtonNextMoveColour(R.id.b6_6);
                colourButtonNextMoveColour(R.id.b6_7);
                colourButtonNextMoveColour(R.id.b6_8);
                colourButtonNextMoveColour(R.id.b6_9);
                break;
            case 7:
                colourButtonNextMoveColour(R.id.b7_1);
                colourButtonNextMoveColour(R.id.b7_2);
                colourButtonNextMoveColour(R.id.b7_3);
                colourButtonNextMoveColour(R.id.b7_4);
                colourButtonNextMoveColour(R.id.b7_5);
                colourButtonNextMoveColour(R.id.b7_6);
                colourButtonNextMoveColour(R.id.b7_7);
                colourButtonNextMoveColour(R.id.b7_8);
                colourButtonNextMoveColour(R.id.b7_9);
                break;
            case 8:
                colourButtonNextMoveColour(R.id.b8_1);
                colourButtonNextMoveColour(R.id.b8_2);
                colourButtonNextMoveColour(R.id.b8_3);
                colourButtonNextMoveColour(R.id.b8_4);
                colourButtonNextMoveColour(R.id.b8_5);
                colourButtonNextMoveColour(R.id.b8_6);
                colourButtonNextMoveColour(R.id.b8_7);
                colourButtonNextMoveColour(R.id.b8_8);
                colourButtonNextMoveColour(R.id.b8_9);
                break;
            case 9:
                colourButtonNextMoveColour(R.id.b9_1);
                colourButtonNextMoveColour(R.id.b9_2);
                colourButtonNextMoveColour(R.id.b9_3);
                colourButtonNextMoveColour(R.id.b9_4);
                colourButtonNextMoveColour(R.id.b9_5);
                colourButtonNextMoveColour(R.id.b9_6);
                colourButtonNextMoveColour(R.id.b9_7);
                colourButtonNextMoveColour(R.id.b9_8);
                colourButtonNextMoveColour(R.id.b9_9);
                break;
        }
    }

    private void colourButtonNextMoveColour(int buttonId) {
        Button button = (Button) activity.findViewById(buttonId);

        button.setBackgroundColor(activity.getResources().getColor(R.color.nextMoveButtonColour));
    }

    private void colourButtonDefaultButtonColour(int buttonId) {
        Button button = (Button) activity.findViewById(buttonId);

        button.setBackgroundColor(activity.getResources().getColor(R.color.defaultButtonColour));
    }

    private void colourButtonPlayer1WonColour(int buttonId) {
        Button button = (Button) activity.findViewById(buttonId);

        button.setBackgroundColor(activity.getResources().getColor(R.color.Player1Colour));
    }

    private void colourButtonPlayer2WonColour(int buttonId) {
        Button button = (Button) activity.findViewById(buttonId);

        button.setBackgroundColor(activity.getResources().getColor(R.color.Player2Colour));
    }
}