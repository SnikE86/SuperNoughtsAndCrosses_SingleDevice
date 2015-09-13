package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean Player1;

    LastMoveDetails lastMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player1 = true;

        lastMove = new LastMoveDetails( 0, 0, 0, true);

        colourAllButtonsNextMoveColour();
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;

        int buttonId = button.getId();

        int gameBoard = getGameBoard( buttonId);
        int gameButton = getGameButton( buttonId);

        if( button.getText() == ""){
            if( boardIsInPlay( gameBoard)){
                if( Player1){
                    button.setText("X");

                    Player1 = false;
                }
                else{
                    button.setText("O");

                    Player1 = true;
                }

                onPlayerMove( buttonId, gameBoard, gameButton);
            }
        }
    }

    private boolean boardIsInPlay(int gameBoard) {
        if( lastMove.nextMoveIsFree){
            return true;
        }
        else return lastMove.lastGameButton == gameBoard;
    }

    private void onPlayerMove(int buttonId, int gameBoard, int gameButton) {
        setupNextMove( buttonId, gameBoard, gameButton);

        checkForBoardWins();
    }

    private void checkForBoardWins() {
        if( boardWon(lastMove.lastGameBoard)){
            //TODO
        }
    }

    private boolean boardWon(int gameBoard) {
        return false;
    }

    private void setupNextMove(int buttonId, int gameBoard, int gameButton) {
        if( gameBoardIsFull( gameButton)){
            lastMove = new LastMoveDetails( buttonId, gameBoard, gameButton, true);

            colourAllButtonsNextMoveColour();
        }
        else{
            lastMove = new LastMoveDetails( buttonId, gameBoard, gameButton, false);

            colourPlayableMoves( gameButton);
        }
    }

    private void colourAllButtonsNextMoveColour() {
        colourButtonNextMoveColour(R.id.b1_1);        colourButtonNextMoveColour(R.id.b1_2);        colourButtonNextMoveColour(R.id.b1_3);
        colourButtonNextMoveColour(R.id.b1_4);        colourButtonNextMoveColour(R.id.b1_5);        colourButtonNextMoveColour(R.id.b1_6);
        colourButtonNextMoveColour(R.id.b1_7);        colourButtonNextMoveColour(R.id.b1_8);        colourButtonNextMoveColour(R.id.b1_9);

        colourButtonNextMoveColour(R.id.b2_1);        colourButtonNextMoveColour(R.id.b2_2);        colourButtonNextMoveColour(R.id.b2_3);
        colourButtonNextMoveColour(R.id.b2_4);        colourButtonNextMoveColour(R.id.b2_5);        colourButtonNextMoveColour(R.id.b2_6);
        colourButtonNextMoveColour(R.id.b2_7);        colourButtonNextMoveColour(R.id.b2_8);        colourButtonNextMoveColour(R.id.b2_9);

        colourButtonNextMoveColour(R.id.b3_1);        colourButtonNextMoveColour(R.id.b3_2);        colourButtonNextMoveColour(R.id.b3_3);
        colourButtonNextMoveColour(R.id.b3_4);        colourButtonNextMoveColour(R.id.b3_5);        colourButtonNextMoveColour(R.id.b3_6);
        colourButtonNextMoveColour(R.id.b3_7);        colourButtonNextMoveColour(R.id.b3_8);        colourButtonNextMoveColour(R.id.b3_9);

        colourButtonNextMoveColour(R.id.b4_1);        colourButtonNextMoveColour(R.id.b4_2);        colourButtonNextMoveColour(R.id.b4_3);
        colourButtonNextMoveColour(R.id.b4_4);        colourButtonNextMoveColour(R.id.b4_5);        colourButtonNextMoveColour(R.id.b4_6);
        colourButtonNextMoveColour(R.id.b4_7);        colourButtonNextMoveColour(R.id.b4_8);        colourButtonNextMoveColour(R.id.b4_9);

        colourButtonNextMoveColour(R.id.b5_1);        colourButtonNextMoveColour(R.id.b5_2);        colourButtonNextMoveColour(R.id.b5_3);
        colourButtonNextMoveColour(R.id.b5_4);        colourButtonNextMoveColour(R.id.b5_5);        colourButtonNextMoveColour(R.id.b5_6);
        colourButtonNextMoveColour(R.id.b5_7);        colourButtonNextMoveColour(R.id.b5_8);        colourButtonNextMoveColour(R.id.b5_9);

        colourButtonNextMoveColour(R.id.b6_1);        colourButtonNextMoveColour(R.id.b6_2);        colourButtonNextMoveColour(R.id.b6_3);
        colourButtonNextMoveColour(R.id.b6_4);        colourButtonNextMoveColour(R.id.b6_5);        colourButtonNextMoveColour(R.id.b6_6);
        colourButtonNextMoveColour(R.id.b6_7);        colourButtonNextMoveColour(R.id.b6_8);        colourButtonNextMoveColour(R.id.b6_9);

        colourButtonNextMoveColour(R.id.b7_1);        colourButtonNextMoveColour(R.id.b7_2);        colourButtonNextMoveColour(R.id.b7_3);
        colourButtonNextMoveColour(R.id.b7_4);        colourButtonNextMoveColour(R.id.b7_5);        colourButtonNextMoveColour(R.id.b7_6);
        colourButtonNextMoveColour(R.id.b7_7);        colourButtonNextMoveColour(R.id.b7_8);        colourButtonNextMoveColour(R.id.b7_9);

        colourButtonNextMoveColour(R.id.b8_1);        colourButtonNextMoveColour(R.id.b8_2);        colourButtonNextMoveColour(R.id.b8_3);
        colourButtonNextMoveColour(R.id.b8_4);        colourButtonNextMoveColour(R.id.b8_5);        colourButtonNextMoveColour(R.id.b8_6);
        colourButtonNextMoveColour(R.id.b8_7);        colourButtonNextMoveColour(R.id.b8_8);        colourButtonNextMoveColour(R.id.b8_9);

        colourButtonNextMoveColour(R.id.b9_1);        colourButtonNextMoveColour(R.id.b9_2);        colourButtonNextMoveColour(R.id.b9_3);
        colourButtonNextMoveColour(R.id.b9_4);        colourButtonNextMoveColour(R.id.b9_5);        colourButtonNextMoveColour(R.id.b9_6);
        colourButtonNextMoveColour(R.id.b9_7);        colourButtonNextMoveColour(R.id.b9_8);        colourButtonNextMoveColour(R.id.b9_9);
    }

    private void colourAllButtonsDefaultButtonColour() {
        colourButtonDefaultButtonColour(R.id.b1_1); colourButtonDefaultButtonColour(R.id.b1_2); colourButtonDefaultButtonColour(R.id.b1_3);
        colourButtonDefaultButtonColour(R.id.b1_4); colourButtonDefaultButtonColour(R.id.b1_5); colourButtonDefaultButtonColour(R.id.b1_6);
        colourButtonDefaultButtonColour(R.id.b1_7); colourButtonDefaultButtonColour(R.id.b1_8); colourButtonDefaultButtonColour(R.id.b1_9);

        colourButtonDefaultButtonColour(R.id.b2_1); colourButtonDefaultButtonColour(R.id.b2_2); colourButtonDefaultButtonColour(R.id.b2_3);
        colourButtonDefaultButtonColour(R.id.b2_4); colourButtonDefaultButtonColour(R.id.b2_5); colourButtonDefaultButtonColour(R.id.b2_6);
        colourButtonDefaultButtonColour(R.id.b2_7); colourButtonDefaultButtonColour(R.id.b2_8); colourButtonDefaultButtonColour(R.id.b2_9);

        colourButtonDefaultButtonColour(R.id.b3_1); colourButtonDefaultButtonColour(R.id.b3_2); colourButtonDefaultButtonColour(R.id.b3_3);
        colourButtonDefaultButtonColour(R.id.b3_4); colourButtonDefaultButtonColour(R.id.b3_5); colourButtonDefaultButtonColour(R.id.b3_6);
        colourButtonDefaultButtonColour(R.id.b3_7); colourButtonDefaultButtonColour(R.id.b3_8); colourButtonDefaultButtonColour(R.id.b3_9);

        colourButtonDefaultButtonColour(R.id.b4_1); colourButtonDefaultButtonColour(R.id.b4_2); colourButtonDefaultButtonColour(R.id.b4_3);
        colourButtonDefaultButtonColour(R.id.b4_4); colourButtonDefaultButtonColour(R.id.b4_5); colourButtonDefaultButtonColour(R.id.b4_6);
        colourButtonDefaultButtonColour(R.id.b4_7); colourButtonDefaultButtonColour(R.id.b4_8); colourButtonDefaultButtonColour(R.id.b4_9);

        colourButtonDefaultButtonColour(R.id.b5_1); colourButtonDefaultButtonColour(R.id.b5_2); colourButtonDefaultButtonColour(R.id.b5_3);
        colourButtonDefaultButtonColour(R.id.b5_4); colourButtonDefaultButtonColour(R.id.b5_5); colourButtonDefaultButtonColour(R.id.b5_6);
        colourButtonDefaultButtonColour(R.id.b5_7); colourButtonDefaultButtonColour(R.id.b5_8); colourButtonDefaultButtonColour(R.id.b5_9);

        colourButtonDefaultButtonColour(R.id.b6_1); colourButtonDefaultButtonColour(R.id.b6_2); colourButtonDefaultButtonColour(R.id.b6_3);
        colourButtonDefaultButtonColour(R.id.b6_4); colourButtonDefaultButtonColour(R.id.b6_5); colourButtonDefaultButtonColour(R.id.b6_6);
        colourButtonDefaultButtonColour(R.id.b6_7); colourButtonDefaultButtonColour(R.id.b6_8); colourButtonDefaultButtonColour(R.id.b6_9);

        colourButtonDefaultButtonColour(R.id.b7_1); colourButtonDefaultButtonColour(R.id.b7_2); colourButtonDefaultButtonColour(R.id.b7_3);
        colourButtonDefaultButtonColour(R.id.b7_4); colourButtonDefaultButtonColour(R.id.b7_5); colourButtonDefaultButtonColour(R.id.b7_6);
        colourButtonDefaultButtonColour(R.id.b7_7); colourButtonDefaultButtonColour(R.id.b7_8); colourButtonDefaultButtonColour(R.id.b7_9);

        colourButtonDefaultButtonColour(R.id.b8_1); colourButtonDefaultButtonColour(R.id.b8_2); colourButtonDefaultButtonColour(R.id.b8_3);
        colourButtonDefaultButtonColour(R.id.b8_4); colourButtonDefaultButtonColour(R.id.b8_5); colourButtonDefaultButtonColour(R.id.b8_6);
        colourButtonDefaultButtonColour(R.id.b8_7); colourButtonDefaultButtonColour(R.id.b8_8); colourButtonDefaultButtonColour(R.id.b8_9);

        colourButtonDefaultButtonColour(R.id.b9_1); colourButtonDefaultButtonColour(R.id.b9_2); colourButtonDefaultButtonColour(R.id.b9_3);
        colourButtonDefaultButtonColour(R.id.b9_4); colourButtonDefaultButtonColour(R.id.b9_5); colourButtonDefaultButtonColour(R.id.b9_6);
        colourButtonDefaultButtonColour(R.id.b9_7); colourButtonDefaultButtonColour(R.id.b9_8); colourButtonDefaultButtonColour(R.id.b9_9);
    }

    private void colourPlayableMoves(int gameBoard) {
        colourAllButtonsDefaultButtonColour();

        switch (gameBoard){
            case 1:
                colourButtonNextMoveColour(R.id.b1_1); colourButtonNextMoveColour(R.id.b1_2); colourButtonNextMoveColour(R.id.b1_3);
                colourButtonNextMoveColour(R.id.b1_4); colourButtonNextMoveColour(R.id.b1_5); colourButtonNextMoveColour(R.id.b1_6);
                colourButtonNextMoveColour(R.id.b1_7); colourButtonNextMoveColour(R.id.b1_8); colourButtonNextMoveColour(R.id.b1_9);
                break;
            case 2:
                colourButtonNextMoveColour(R.id.b2_1); colourButtonNextMoveColour(R.id.b2_2); colourButtonNextMoveColour(R.id.b2_3);
                colourButtonNextMoveColour(R.id.b2_4); colourButtonNextMoveColour(R.id.b2_5); colourButtonNextMoveColour(R.id.b2_6);
                colourButtonNextMoveColour(R.id.b2_7); colourButtonNextMoveColour(R.id.b2_8); colourButtonNextMoveColour(R.id.b2_9);
                break;
            case 3:
                colourButtonNextMoveColour(R.id.b3_1); colourButtonNextMoveColour(R.id.b3_2); colourButtonNextMoveColour(R.id.b3_3);
                colourButtonNextMoveColour(R.id.b3_4); colourButtonNextMoveColour(R.id.b3_5); colourButtonNextMoveColour(R.id.b3_6);
                colourButtonNextMoveColour(R.id.b3_7); colourButtonNextMoveColour(R.id.b3_8); colourButtonNextMoveColour(R.id.b3_9);
                break;
            case 4:
                colourButtonNextMoveColour(R.id.b4_1); colourButtonNextMoveColour(R.id.b4_2); colourButtonNextMoveColour(R.id.b4_3);
                colourButtonNextMoveColour(R.id.b4_4); colourButtonNextMoveColour(R.id.b4_5); colourButtonNextMoveColour(R.id.b4_6);
                colourButtonNextMoveColour(R.id.b4_7); colourButtonNextMoveColour(R.id.b4_8); colourButtonNextMoveColour(R.id.b4_9);
                break;
            case 5:
                colourButtonNextMoveColour(R.id.b5_1); colourButtonNextMoveColour(R.id.b5_2); colourButtonNextMoveColour(R.id.b5_3);
                colourButtonNextMoveColour(R.id.b5_4); colourButtonNextMoveColour(R.id.b5_5); colourButtonNextMoveColour(R.id.b5_6);
                colourButtonNextMoveColour(R.id.b5_7); colourButtonNextMoveColour(R.id.b5_8); colourButtonNextMoveColour(R.id.b5_9);
                break;
            case 6:
                colourButtonNextMoveColour(R.id.b6_1); colourButtonNextMoveColour(R.id.b6_2); colourButtonNextMoveColour(R.id.b6_3);
                colourButtonNextMoveColour(R.id.b6_4); colourButtonNextMoveColour(R.id.b6_5); colourButtonNextMoveColour(R.id.b6_6);
                colourButtonNextMoveColour(R.id.b6_7); colourButtonNextMoveColour(R.id.b6_8); colourButtonNextMoveColour(R.id.b6_9);
                break;
            case 7:
                colourButtonNextMoveColour(R.id.b7_1); colourButtonNextMoveColour(R.id.b7_2); colourButtonNextMoveColour(R.id.b7_3);
                colourButtonNextMoveColour(R.id.b7_4); colourButtonNextMoveColour(R.id.b7_5); colourButtonNextMoveColour(R.id.b7_6);
                colourButtonNextMoveColour(R.id.b7_7); colourButtonNextMoveColour(R.id.b7_8); colourButtonNextMoveColour(R.id.b7_9);
                break;
            case 8:
                colourButtonNextMoveColour(R.id.b8_1); colourButtonNextMoveColour(R.id.b8_2); colourButtonNextMoveColour(R.id.b8_3);
                colourButtonNextMoveColour(R.id.b8_4); colourButtonNextMoveColour(R.id.b8_5); colourButtonNextMoveColour(R.id.b8_6);
                colourButtonNextMoveColour(R.id.b8_7); colourButtonNextMoveColour(R.id.b8_8); colourButtonNextMoveColour(R.id.b8_9);
                break;
            case 9:
                colourButtonNextMoveColour(R.id.b9_1); colourButtonNextMoveColour(R.id.b9_2); colourButtonNextMoveColour(R.id.b9_3);
                colourButtonNextMoveColour(R.id.b9_4); colourButtonNextMoveColour(R.id.b9_5); colourButtonNextMoveColour(R.id.b9_6);
                colourButtonNextMoveColour(R.id.b9_7); colourButtonNextMoveColour(R.id.b9_8); colourButtonNextMoveColour(R.id.b9_9);
                break;
        }
    }

    private void colourButtonNextMoveColour(int buttonId) {
        Button button = (Button) findViewById( buttonId);

        //button.setBackgroundColor(Color.parseColor("@color/nextMoveColour"));
        button.setBackgroundColor(getResources().getColor(R.color.nextMoveButtonColour));
    }

    private void colourButtonDefaultButtonColour(int buttonId) {
        Button button = (Button) findViewById( buttonId);

        //button.setBackgroundColor(Color.parseColor("@color/defaultButtonColour"));
        button.setBackgroundColor(getResources().getColor(R.color.defaultButtonColour));
    }

    private boolean gameBoardIsFull(int gameButton) {
        switch (gameButton){
            case 1:
                return (   buttonHasBeenPlayed(R.id.b1_1) && buttonHasBeenPlayed( R.id.b1_2) && buttonHasBeenPlayed( R.id.b1_3)
                        && buttonHasBeenPlayed(R.id.b1_4) && buttonHasBeenPlayed( R.id.b1_5) && buttonHasBeenPlayed( R.id.b1_6)
                        && buttonHasBeenPlayed(R.id.b1_7) && buttonHasBeenPlayed( R.id.b1_8) && buttonHasBeenPlayed( R.id.b1_9));
            case 2:
                return (   buttonHasBeenPlayed(R.id.b2_1) && buttonHasBeenPlayed( R.id.b2_2) && buttonHasBeenPlayed( R.id.b2_3)
                        && buttonHasBeenPlayed(R.id.b2_4) && buttonHasBeenPlayed( R.id.b2_5) && buttonHasBeenPlayed( R.id.b2_6)
                        && buttonHasBeenPlayed(R.id.b2_7) && buttonHasBeenPlayed( R.id.b2_8) && buttonHasBeenPlayed( R.id.b2_9));
            case 3:
                return (   buttonHasBeenPlayed(R.id.b3_1) && buttonHasBeenPlayed( R.id.b3_2) && buttonHasBeenPlayed( R.id.b3_3)
                        && buttonHasBeenPlayed(R.id.b3_4) && buttonHasBeenPlayed( R.id.b3_5) && buttonHasBeenPlayed( R.id.b3_6)
                        && buttonHasBeenPlayed(R.id.b3_7) && buttonHasBeenPlayed( R.id.b3_8) && buttonHasBeenPlayed( R.id.b3_9));
            case 4:
                return (   buttonHasBeenPlayed(R.id.b4_1) && buttonHasBeenPlayed( R.id.b4_2) && buttonHasBeenPlayed( R.id.b4_3)
                        && buttonHasBeenPlayed(R.id.b4_4) && buttonHasBeenPlayed( R.id.b4_5) && buttonHasBeenPlayed( R.id.b4_6)
                        && buttonHasBeenPlayed(R.id.b4_7) && buttonHasBeenPlayed( R.id.b4_8) && buttonHasBeenPlayed( R.id.b4_9));
            case 5:
                return (   buttonHasBeenPlayed(R.id.b5_1) && buttonHasBeenPlayed( R.id.b5_2) && buttonHasBeenPlayed( R.id.b5_3)
                        && buttonHasBeenPlayed(R.id.b5_4) && buttonHasBeenPlayed( R.id.b5_5) && buttonHasBeenPlayed( R.id.b5_6)
                        && buttonHasBeenPlayed(R.id.b5_7) && buttonHasBeenPlayed( R.id.b5_8) && buttonHasBeenPlayed( R.id.b5_9));
            case 6:
                return (   buttonHasBeenPlayed(R.id.b6_1) && buttonHasBeenPlayed( R.id.b6_2) && buttonHasBeenPlayed( R.id.b6_3)
                        && buttonHasBeenPlayed(R.id.b6_4) && buttonHasBeenPlayed( R.id.b6_5) && buttonHasBeenPlayed( R.id.b6_6)
                        && buttonHasBeenPlayed(R.id.b6_7) && buttonHasBeenPlayed( R.id.b6_8) && buttonHasBeenPlayed( R.id.b6_9));
            case 7:
                return (   buttonHasBeenPlayed(R.id.b7_1) && buttonHasBeenPlayed( R.id.b7_2) && buttonHasBeenPlayed( R.id.b7_3)
                        && buttonHasBeenPlayed(R.id.b7_4) && buttonHasBeenPlayed( R.id.b7_5) && buttonHasBeenPlayed( R.id.b7_6)
                        && buttonHasBeenPlayed(R.id.b7_7) && buttonHasBeenPlayed( R.id.b7_8) && buttonHasBeenPlayed( R.id.b7_9));
            case 8:
                return (   buttonHasBeenPlayed(R.id.b8_1) && buttonHasBeenPlayed( R.id.b8_2) && buttonHasBeenPlayed( R.id.b8_3)
                        && buttonHasBeenPlayed(R.id.b8_4) && buttonHasBeenPlayed( R.id.b8_5) && buttonHasBeenPlayed( R.id.b8_6)
                        && buttonHasBeenPlayed(R.id.b8_7) && buttonHasBeenPlayed( R.id.b8_8) && buttonHasBeenPlayed( R.id.b8_9));
            case 9:
                return (   buttonHasBeenPlayed(R.id.b9_1) && buttonHasBeenPlayed( R.id.b9_2) && buttonHasBeenPlayed( R.id.b9_3)
                        && buttonHasBeenPlayed(R.id.b9_4) && buttonHasBeenPlayed( R.id.b9_5) && buttonHasBeenPlayed( R.id.b9_6)
                        && buttonHasBeenPlayed(R.id.b9_7) && buttonHasBeenPlayed( R.id.b9_8) && buttonHasBeenPlayed( R.id.b9_9));
            default: return false;
        }
    }

    private boolean buttonHasBeenPlayed(int buttonId) {
        Button button = (Button) findViewById( buttonId);

        return button.getText() != "";
    }

    private int getGameBoard( int buttonId){
        switch (buttonId){
            case R.id.b1_1: case R.id.b1_2: case R.id.b1_3:
            case R.id.b1_4: case R.id.b1_5: case R.id.b1_6:
            case R.id.b1_7: case R.id.b1_8: case R.id.b1_9:
                return 1;
            case R.id.b2_1: case R.id.b2_2: case R.id.b2_3:
            case R.id.b2_4: case R.id.b2_5: case R.id.b2_6:
            case R.id.b2_7: case R.id.b2_8: case R.id.b2_9:
                return 2;
            case R.id.b3_1: case R.id.b3_2: case R.id.b3_3:
            case R.id.b3_4: case R.id.b3_5: case R.id.b3_6:
            case R.id.b3_7: case R.id.b3_8: case R.id.b3_9:
                return 3;
            case R.id.b4_1: case R.id.b4_2: case R.id.b4_3:
            case R.id.b4_4: case R.id.b4_5: case R.id.b4_6:
            case R.id.b4_7: case R.id.b4_8: case R.id.b4_9:
                return 4;
            case R.id.b5_1: case R.id.b5_2: case R.id.b5_3:
            case R.id.b5_4: case R.id.b5_5: case R.id.b5_6:
            case R.id.b5_7: case R.id.b5_8: case R.id.b5_9:
                return 5;
            case R.id.b6_1: case R.id.b6_2: case R.id.b6_3:
            case R.id.b6_4: case R.id.b6_5: case R.id.b6_6:
            case R.id.b6_7: case R.id.b6_8: case R.id.b6_9:
                return 6;
            case R.id.b7_1: case R.id.b7_2: case R.id.b7_3:
            case R.id.b7_4: case R.id.b7_5: case R.id.b7_6:
            case R.id.b7_7: case R.id.b7_8: case R.id.b7_9:
                return 7;
            case R.id.b8_1: case R.id.b8_2: case R.id.b8_3:
            case R.id.b8_4: case R.id.b8_5: case R.id.b8_6:
            case R.id.b8_7: case R.id.b8_8: case R.id.b8_9:
                return 8;
            case R.id.b9_1: case R.id.b9_2: case R.id.b9_3:
            case R.id.b9_4: case R.id.b9_5: case R.id.b9_6:
            case R.id.b9_7: case R.id.b9_8: case R.id.b9_9:
                return 9;
            default:
                return 0;
        }
    }

    private int getGameButton( int buttonId){
        switch (buttonId){
            case R.id.b1_1: case R.id.b2_1: case R.id.b3_1:
            case R.id.b4_1: case R.id.b5_1: case R.id.b6_1:
            case R.id.b7_1: case R.id.b8_1: case R.id.b9_1:
                return 1;
            case R.id.b1_2: case R.id.b2_2: case R.id.b3_2:
            case R.id.b4_2: case R.id.b5_2: case R.id.b6_2:
            case R.id.b7_2: case R.id.b8_2: case R.id.b9_2:
                return 2;
            case R.id.b1_3: case R.id.b2_3: case R.id.b3_3:
            case R.id.b4_3: case R.id.b5_3: case R.id.b6_3:
            case R.id.b7_3: case R.id.b8_3: case R.id.b9_3:
                return 3;
            case R.id.b1_4: case R.id.b2_4: case R.id.b3_4:
            case R.id.b4_4: case R.id.b5_4: case R.id.b6_4:
            case R.id.b7_4: case R.id.b8_4: case R.id.b9_4:
                return 4;
            case R.id.b1_5: case R.id.b2_5: case R.id.b3_5:
            case R.id.b4_5: case R.id.b5_5: case R.id.b6_5:
            case R.id.b7_5: case R.id.b8_5: case R.id.b9_5:
                return 5;
            case R.id.b1_6: case R.id.b2_6: case R.id.b3_6:
            case R.id.b4_6: case R.id.b5_6: case R.id.b6_6:
            case R.id.b7_6: case R.id.b8_6: case R.id.b9_6:
                return 6;
            case R.id.b1_7: case R.id.b2_7: case R.id.b3_7:
            case R.id.b4_7: case R.id.b5_7: case R.id.b6_7:
            case R.id.b7_7: case R.id.b8_7: case R.id.b9_7:
                return 7;
            case R.id.b1_8: case R.id.b2_8: case R.id.b3_8:
            case R.id.b4_8: case R.id.b5_8: case R.id.b6_8:
            case R.id.b7_8: case R.id.b8_8: case R.id.b9_8:
                return 8;
            case R.id.b1_9: case R.id.b2_9: case R.id.b3_9:
            case R.id.b4_9: case R.id.b5_9: case R.id.b6_9:
            case R.id.b7_9: case R.id.b8_9: case R.id.b9_9:
                return 9;
            default:
                return 0;
        }
    }

}