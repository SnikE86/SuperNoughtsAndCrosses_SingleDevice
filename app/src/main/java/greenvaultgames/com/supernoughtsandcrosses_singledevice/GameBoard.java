package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 16/09/2015.
 */

class IntPair {
    int _x;
    int _y;
    IntPair(int x, int y) {_x=x;_y=y;}

    public void SetPair( int x, int y){_x=x;_y=y;}
}

public class GameBoard extends Activity {

    private enum Player{ PlayerNull, Player1, Player2}

    private Player _currPlayer;

    private LastMoveDetails _lastMove;

    private ArrayList<char[]> _gameBoardMoves;

    private List<Player> _boardsWon;

    private ArrayList<IntPair> _winningButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        setupGameBoards();

        setupGameBoardMoves();

        setupWinningButtons();

        _currPlayer = Player.Player1;

        _lastMove = new LastMoveDetails( 0, 0, 0, true);

        colourAllButtonsNextMoveColour();
    }

    private void setupGameBoards(){
        _boardsWon = new ArrayList<>(9);

        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
        _boardsWon.add(Player.PlayerNull);
    }

    private void setupGameBoardMoves(){
        _gameBoardMoves = new ArrayList<>(9);

        char[] board1 = new char[9];
        char[] board2 = new char[9];
        char[] board3 = new char[9];
        char[] board4 = new char[9];
        char[] board5 = new char[9];
        char[] board6 = new char[9];
        char[] board7 = new char[9];
        char[] board8 = new char[9];
        char[] board9 = new char[9];

        _gameBoardMoves.add(board1);
        _gameBoardMoves.add(board2);
        _gameBoardMoves.add(board3);
        _gameBoardMoves.add(board4);
        _gameBoardMoves.add(board5);
        _gameBoardMoves.add(board6);
        _gameBoardMoves.add(board7);
        _gameBoardMoves.add(board8);
        _gameBoardMoves.add(board9);
    }

    private void setupWinningButtons(){
        _winningButtons = new ArrayList<>(9);

        IntPair board1 = new IntPair(0,0);
        IntPair board2 = new IntPair(0,0);
        IntPair board3 = new IntPair(0,0);
        IntPair board4 = new IntPair(0,0);
        IntPair board5 = new IntPair(0,0);
        IntPair board6 = new IntPair(0,0);
        IntPair board7 = new IntPair(0,0);
        IntPair board8 = new IntPair(0,0);
        IntPair board9 = new IntPair(0,0);

        _winningButtons.add(board1);
        _winningButtons.add(board2);
        _winningButtons.add(board3);
        _winningButtons.add(board4);
        _winningButtons.add(board5);
        _winningButtons.add(board6);
        _winningButtons.add(board7);
        _winningButtons.add(board8);
        _winningButtons.add(board9);
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;

        int buttonId = button.getId();

        int gameBoard = getGameBoard( buttonId);
        int gameButton = getGameButton( buttonId);

        if( button.getText() == "") {
            if (boardIsInPlay(gameBoard)) {
                if (_currPlayer == Player.Player1) {
                    button.setText("X");

                    addGameBoardMove(gameBoard, gameButton, 'X');

                    onPlayerMove(buttonId, gameBoard, gameButton);

                    _currPlayer = Player.Player2;
                } else {
                    button.setText("O");

                    addGameBoardMove( gameBoard, gameButton, 'O');

                    onPlayerMove(buttonId, gameBoard, gameButton);

                    _currPlayer = Player.Player1;
                }
            }
        }

        if( checkIfGameWon( gameBoard)){
            if( _currPlayer == Player.Player1){
                Toast toast = Toast.makeText(this, "Game won! Congrats" + Player.Player2.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
            else if( _currPlayer == Player.Player2){
                Toast toast = Toast.makeText(this, "Game won! Congrats" + Player.Player1.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    private void addGameBoardMove(int gameBoard, int gameButton, char move) {
        char[] board = _gameBoardMoves.get(gameBoard - 1);

        board[gameButton - 1] = move;
    }

    private boolean boardIsInPlay(int gameBoard) {
        return _lastMove.nextMoveIsFree || _lastMove.lastGameButton == gameBoard;
    }

    private void onPlayerMove(int buttonId, int gameBoard, int gameButton) {
        if( gameBoardIsFull( gameButton)){
            _lastMove = new LastMoveDetails( buttonId, gameBoard, gameButton, true);

            colourAllButtonsNextMoveColour();
        }
        else{
            _lastMove = new LastMoveDetails( buttonId, gameBoard, gameButton, false);

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
        if( _boardsWon.get(0) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b1_1); colourButtonDefaultButtonColour(R.id.b1_2); colourButtonDefaultButtonColour(R.id.b1_3);
            colourButtonDefaultButtonColour(R.id.b1_4); colourButtonDefaultButtonColour(R.id.b1_5); colourButtonDefaultButtonColour(R.id.b1_6);
            colourButtonDefaultButtonColour(R.id.b1_7); colourButtonDefaultButtonColour(R.id.b1_8); colourButtonDefaultButtonColour(R.id.b1_9);
        }
        if( _boardsWon.get(1) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b2_1); colourButtonDefaultButtonColour(R.id.b2_2); colourButtonDefaultButtonColour(R.id.b2_3);
            colourButtonDefaultButtonColour(R.id.b2_4); colourButtonDefaultButtonColour(R.id.b2_5); colourButtonDefaultButtonColour(R.id.b2_6);
            colourButtonDefaultButtonColour(R.id.b2_7); colourButtonDefaultButtonColour(R.id.b2_8); colourButtonDefaultButtonColour(R.id.b2_9);
        }
        if( _boardsWon.get(2) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b3_1); colourButtonDefaultButtonColour(R.id.b3_2); colourButtonDefaultButtonColour(R.id.b3_3);
            colourButtonDefaultButtonColour(R.id.b3_4); colourButtonDefaultButtonColour(R.id.b3_5); colourButtonDefaultButtonColour(R.id.b3_6);
            colourButtonDefaultButtonColour(R.id.b3_7); colourButtonDefaultButtonColour(R.id.b3_8); colourButtonDefaultButtonColour(R.id.b3_9);
        }
        if( _boardsWon.get(3) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b4_1); colourButtonDefaultButtonColour(R.id.b4_2); colourButtonDefaultButtonColour(R.id.b4_3);
            colourButtonDefaultButtonColour(R.id.b4_4); colourButtonDefaultButtonColour(R.id.b4_5); colourButtonDefaultButtonColour(R.id.b4_6);
            colourButtonDefaultButtonColour(R.id.b4_7); colourButtonDefaultButtonColour(R.id.b4_8); colourButtonDefaultButtonColour(R.id.b4_9);
        }
        if( _boardsWon.get(4) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b5_1); colourButtonDefaultButtonColour(R.id.b5_2); colourButtonDefaultButtonColour(R.id.b5_3);
            colourButtonDefaultButtonColour(R.id.b5_4); colourButtonDefaultButtonColour(R.id.b5_5); colourButtonDefaultButtonColour(R.id.b5_6);
            colourButtonDefaultButtonColour(R.id.b5_7); colourButtonDefaultButtonColour(R.id.b5_8); colourButtonDefaultButtonColour(R.id.b5_9);
        }
        if( _boardsWon.get(5) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b6_1); colourButtonDefaultButtonColour(R.id.b6_2); colourButtonDefaultButtonColour(R.id.b6_3);
            colourButtonDefaultButtonColour(R.id.b6_4); colourButtonDefaultButtonColour(R.id.b6_5); colourButtonDefaultButtonColour(R.id.b6_6);
            colourButtonDefaultButtonColour(R.id.b6_7); colourButtonDefaultButtonColour(R.id.b6_8); colourButtonDefaultButtonColour(R.id.b6_9);
        }
        if( _boardsWon.get(6) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b7_1); colourButtonDefaultButtonColour(R.id.b7_2); colourButtonDefaultButtonColour(R.id.b7_3);
            colourButtonDefaultButtonColour(R.id.b7_4); colourButtonDefaultButtonColour(R.id.b7_5); colourButtonDefaultButtonColour(R.id.b7_6);
            colourButtonDefaultButtonColour(R.id.b7_7); colourButtonDefaultButtonColour(R.id.b7_8); colourButtonDefaultButtonColour(R.id.b7_9);
        }
        if( _boardsWon.get(7) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b8_1); colourButtonDefaultButtonColour(R.id.b8_2); colourButtonDefaultButtonColour(R.id.b8_3);
            colourButtonDefaultButtonColour(R.id.b8_4); colourButtonDefaultButtonColour(R.id.b8_5); colourButtonDefaultButtonColour(R.id.b8_6);
            colourButtonDefaultButtonColour(R.id.b8_7); colourButtonDefaultButtonColour(R.id.b8_8); colourButtonDefaultButtonColour(R.id.b8_9);
        }
        if( _boardsWon.get(8) == Player.PlayerNull){
            colourButtonDefaultButtonColour(R.id.b9_1); colourButtonDefaultButtonColour(R.id.b9_2); colourButtonDefaultButtonColour(R.id.b9_3);
            colourButtonDefaultButtonColour(R.id.b9_4); colourButtonDefaultButtonColour(R.id.b9_5); colourButtonDefaultButtonColour(R.id.b9_6);
            colourButtonDefaultButtonColour(R.id.b9_7); colourButtonDefaultButtonColour(R.id.b9_8); colourButtonDefaultButtonColour(R.id.b9_9);
        }

        colourWinningBoards();
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

        button.setBackgroundColor(getResources().getColor(R.color.nextMoveButtonColour));
    }

    private void colourButtonDefaultButtonColour(int buttonId) {
        Button button = (Button) findViewById( buttonId);

        button.setBackgroundColor(getResources().getColor(R.color.defaultButtonColour));
    }

    private void colourButtonPlayer1WonColour(int buttonId){
        Button button = (Button) findViewById( buttonId);

        button.setBackgroundColor(getResources().getColor(R.color.Player1WonBoardColour));
    }

    private void colourButtonPlayer2WonColour(int buttonId){
        Button button = (Button) findViewById( buttonId);

        button.setBackgroundColor(getResources().getColor(R.color.Player2WonBoardColour));
    }

    private void colourWinningBoards(){
        colourPlayer1WinningBoards();
        colourPlayer2WinningBoards();
    }

    private void colourPlayer1WinningBoards(){
        if( _boardsWon.get(0) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b1_1); colourButtonPlayer1WonColour(R.id.b1_2); colourButtonPlayer1WonColour(R.id.b1_3);
            colourButtonPlayer1WonColour(R.id.b1_4); colourButtonPlayer1WonColour(R.id.b1_5); colourButtonPlayer1WonColour(R.id.b1_6);
            colourButtonPlayer1WonColour(R.id.b1_7); colourButtonPlayer1WonColour(R.id.b1_8); colourButtonPlayer1WonColour(R.id.b1_9);
        }
        if( _boardsWon.get(1) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b2_1); colourButtonPlayer1WonColour(R.id.b2_2); colourButtonPlayer1WonColour(R.id.b2_3);
            colourButtonPlayer1WonColour(R.id.b2_4); colourButtonPlayer1WonColour(R.id.b2_5); colourButtonPlayer1WonColour(R.id.b2_6);
            colourButtonPlayer1WonColour(R.id.b2_7); colourButtonPlayer1WonColour(R.id.b2_8); colourButtonPlayer1WonColour(R.id.b2_9);
        }
        if( _boardsWon.get(2) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b3_1); colourButtonPlayer1WonColour(R.id.b3_2); colourButtonPlayer1WonColour(R.id.b3_3);
            colourButtonPlayer1WonColour(R.id.b3_4); colourButtonPlayer1WonColour(R.id.b3_5); colourButtonPlayer1WonColour(R.id.b3_6);
            colourButtonPlayer1WonColour(R.id.b3_7); colourButtonPlayer1WonColour(R.id.b3_8); colourButtonPlayer1WonColour(R.id.b3_9);
        }
        if( _boardsWon.get(3) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b4_1); colourButtonPlayer1WonColour(R.id.b4_2); colourButtonPlayer1WonColour(R.id.b4_3);
            colourButtonPlayer1WonColour(R.id.b4_4); colourButtonPlayer1WonColour(R.id.b4_5); colourButtonPlayer1WonColour(R.id.b4_6);
            colourButtonPlayer1WonColour(R.id.b4_7); colourButtonPlayer1WonColour(R.id.b4_8); colourButtonPlayer1WonColour(R.id.b4_9);
        }
        if( _boardsWon.get(4) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b5_1); colourButtonPlayer1WonColour(R.id.b5_2); colourButtonPlayer1WonColour(R.id.b5_3);
            colourButtonPlayer1WonColour(R.id.b5_4); colourButtonPlayer1WonColour(R.id.b5_5); colourButtonPlayer1WonColour(R.id.b5_6);
            colourButtonPlayer1WonColour(R.id.b5_7); colourButtonPlayer1WonColour(R.id.b5_8); colourButtonPlayer1WonColour(R.id.b5_9);
        }
        if( _boardsWon.get(5) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b6_1); colourButtonPlayer1WonColour(R.id.b6_2); colourButtonPlayer1WonColour(R.id.b6_3);
            colourButtonPlayer1WonColour(R.id.b6_4); colourButtonPlayer1WonColour(R.id.b6_5); colourButtonPlayer1WonColour(R.id.b6_6);
            colourButtonPlayer1WonColour(R.id.b6_7); colourButtonPlayer1WonColour(R.id.b6_8); colourButtonPlayer1WonColour(R.id.b6_9);
        }
        if( _boardsWon.get(6) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b7_1); colourButtonPlayer1WonColour(R.id.b7_2); colourButtonPlayer1WonColour(R.id.b7_3);
            colourButtonPlayer1WonColour(R.id.b7_4); colourButtonPlayer1WonColour(R.id.b7_5); colourButtonPlayer1WonColour(R.id.b7_6);
            colourButtonPlayer1WonColour(R.id.b7_7); colourButtonPlayer1WonColour(R.id.b7_8); colourButtonPlayer1WonColour(R.id.b7_9);
        }
        if( _boardsWon.get(7) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b8_1); colourButtonPlayer1WonColour(R.id.b8_2); colourButtonPlayer1WonColour(R.id.b8_3);
            colourButtonPlayer1WonColour(R.id.b8_4); colourButtonPlayer1WonColour(R.id.b8_5); colourButtonPlayer1WonColour(R.id.b8_6);
            colourButtonPlayer1WonColour(R.id.b8_7); colourButtonPlayer1WonColour(R.id.b8_8); colourButtonPlayer1WonColour(R.id.b8_9);
        }
        if( _boardsWon.get(8) == Player.Player1){
            colourButtonPlayer1WonColour(R.id.b9_1); colourButtonPlayer1WonColour(R.id.b9_2); colourButtonPlayer1WonColour(R.id.b9_3);
            colourButtonPlayer1WonColour(R.id.b9_4); colourButtonPlayer1WonColour(R.id.b9_5); colourButtonPlayer1WonColour(R.id.b9_6);
            colourButtonPlayer1WonColour(R.id.b9_7); colourButtonPlayer1WonColour(R.id.b9_8); colourButtonPlayer1WonColour(R.id.b9_9);
        }
    }

    private void colourPlayer2WinningBoards(){
        if( _boardsWon.get(0) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b1_1); colourButtonPlayer2WonColour(R.id.b1_2); colourButtonPlayer2WonColour(R.id.b1_3);
            colourButtonPlayer2WonColour(R.id.b1_4); colourButtonPlayer2WonColour(R.id.b1_5); colourButtonPlayer2WonColour(R.id.b1_6);
            colourButtonPlayer2WonColour(R.id.b1_7); colourButtonPlayer2WonColour(R.id.b1_8); colourButtonPlayer2WonColour(R.id.b1_9);
        }
        if( _boardsWon.get(1) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b2_1); colourButtonPlayer2WonColour(R.id.b2_2); colourButtonPlayer2WonColour(R.id.b2_3);
            colourButtonPlayer2WonColour(R.id.b2_4); colourButtonPlayer2WonColour(R.id.b2_5); colourButtonPlayer2WonColour(R.id.b2_6);
            colourButtonPlayer2WonColour(R.id.b2_7); colourButtonPlayer2WonColour(R.id.b2_8); colourButtonPlayer2WonColour(R.id.b2_9);
        }
        if( _boardsWon.get(2) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b3_1); colourButtonPlayer2WonColour(R.id.b3_2); colourButtonPlayer2WonColour(R.id.b3_3);
            colourButtonPlayer2WonColour(R.id.b3_4); colourButtonPlayer2WonColour(R.id.b3_5); colourButtonPlayer2WonColour(R.id.b3_6);
            colourButtonPlayer2WonColour(R.id.b3_7); colourButtonPlayer2WonColour(R.id.b3_8); colourButtonPlayer2WonColour(R.id.b3_9);
        }
        if( _boardsWon.get(3) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b4_1); colourButtonPlayer2WonColour(R.id.b4_2); colourButtonPlayer2WonColour(R.id.b4_3);
            colourButtonPlayer2WonColour(R.id.b4_4); colourButtonPlayer2WonColour(R.id.b4_5); colourButtonPlayer2WonColour(R.id.b4_6);
            colourButtonPlayer2WonColour(R.id.b4_7); colourButtonPlayer2WonColour(R.id.b4_8); colourButtonPlayer2WonColour(R.id.b4_9);
        }
        if( _boardsWon.get(4) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b5_1); colourButtonPlayer2WonColour(R.id.b5_2); colourButtonPlayer2WonColour(R.id.b5_3);
            colourButtonPlayer2WonColour(R.id.b5_4); colourButtonPlayer2WonColour(R.id.b5_5); colourButtonPlayer2WonColour(R.id.b5_6);
            colourButtonPlayer2WonColour(R.id.b5_7); colourButtonPlayer2WonColour(R.id.b5_8); colourButtonPlayer2WonColour(R.id.b5_9);
        }
        if( _boardsWon.get(5) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b6_1); colourButtonPlayer2WonColour(R.id.b6_2); colourButtonPlayer2WonColour(R.id.b6_3);
            colourButtonPlayer2WonColour(R.id.b6_4); colourButtonPlayer2WonColour(R.id.b6_5); colourButtonPlayer2WonColour(R.id.b6_6);
            colourButtonPlayer2WonColour(R.id.b6_7); colourButtonPlayer2WonColour(R.id.b6_8); colourButtonPlayer2WonColour(R.id.b6_9);
        }
        if( _boardsWon.get(6) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b7_1); colourButtonPlayer2WonColour(R.id.b7_2); colourButtonPlayer2WonColour(R.id.b7_3);
            colourButtonPlayer2WonColour(R.id.b7_4); colourButtonPlayer2WonColour(R.id.b7_5); colourButtonPlayer2WonColour(R.id.b7_6);
            colourButtonPlayer2WonColour(R.id.b7_7); colourButtonPlayer2WonColour(R.id.b7_8); colourButtonPlayer2WonColour(R.id.b7_9);
        }
        if( _boardsWon.get(7) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b8_1); colourButtonPlayer2WonColour(R.id.b8_2); colourButtonPlayer2WonColour(R.id.b8_3);
            colourButtonPlayer2WonColour(R.id.b8_4); colourButtonPlayer2WonColour(R.id.b8_5); colourButtonPlayer2WonColour(R.id.b8_6);
            colourButtonPlayer2WonColour(R.id.b8_7); colourButtonPlayer2WonColour(R.id.b8_8); colourButtonPlayer2WonColour(R.id.b8_9);
        }
        if( _boardsWon.get(8) == Player.Player2){
            colourButtonPlayer2WonColour(R.id.b9_1); colourButtonPlayer2WonColour(R.id.b9_2); colourButtonPlayer2WonColour(R.id.b9_3);
            colourButtonPlayer2WonColour(R.id.b9_4); colourButtonPlayer2WonColour(R.id.b9_5); colourButtonPlayer2WonColour(R.id.b9_6);
            colourButtonPlayer2WonColour(R.id.b9_7); colourButtonPlayer2WonColour(R.id.b9_8); colourButtonPlayer2WonColour(R.id.b9_9);
        }
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

    private boolean checkIfGameWon( int game_board){
        checkBoard( game_board);

        return ( diagonalsWon() || verticalsWon() || horizontalsWon());
    }

    private void checkBoard( int game_board){
        if( _boardsWon.get(game_board - 1) == Player.PlayerNull) {
            if (boardDiagonalsWon(game_board) || boardVerticalsWon(game_board) || boardHorizontalsWon(game_board)) {
                _boardsWon.set(game_board - 1, _currPlayer);

                Toast toast = Toast.makeText(this, "Board " + game_board + " won by: " + _currPlayer.toString(), Toast.LENGTH_LONG);
                toast.show();

                colourWinningBoards();
            }
        }
    }

    private boolean boardDiagonalsWon( int game_board){
        boolean result = false;

        char[] board = _gameBoardMoves.get( game_board - 1);

        if(board[ 0] == board[ 4] && board[ 4] == board[ 8] && board[8] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair(getIdForGameButton1(game_board), getIdForGameButton9(game_board));

            RelativeLayout rl_gameboard =(RelativeLayout)findViewById(R.id.rl_gameboard);

            Button button1 = (Button)findViewById(getIdForGameButton1(game_board));
            Button button2 = (Button)findViewById(getIdForGameButton9(game_board));

            DrawRedLineView drawView = new DrawRedLineView(this,button1,button2);
            rl_gameboard.addView(drawView);
        }

        if(board[ 2] == board[ 4] && board[ 4] == board[ 6] && board[6] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton3(game_board), getIdForGameButton7(game_board));
        }

        return result;
    }

    private boolean boardVerticalsWon( int game_board){
        boolean result = false;

        char[] board = _gameBoardMoves.get( game_board - 1);

        if(board[ 0] == board[ 3] && board[ 3] == board[ 6] && board[6] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton1(game_board), getIdForGameButton7(game_board));
        }
        if(board[ 1] == board[ 4] && board[ 4] == board[ 7] && board[7] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton2(game_board), getIdForGameButton8(game_board));
        }
        if(board[ 2] == board[ 5] && board[ 5] == board[ 8] && board[8] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton3(game_board), getIdForGameButton9(game_board));
        }

        return result;
    }

    private boolean boardHorizontalsWon( int game_board){
        boolean result = false;

        char[] board = _gameBoardMoves.get( game_board - 1);

        if(board[ 0] == board[ 1] && board[ 1] == board[ 2] && board[2] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton1(game_board), getIdForGameButton3(game_board));
        }
        if(board[ 3] == board[ 4] && board[ 4] == board[ 5] && board[5] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton4(game_board), getIdForGameButton6(game_board));
        }
        if(board[ 6] == board[ 7] && board[ 7] == board[ 8] && board[8] != '\u0000'){
            result = true;

            IntPair winningButtons = _winningButtons.get(game_board - 1);

            winningButtons.SetPair( getIdForGameButton7(game_board), getIdForGameButton9(game_board));
        }

        return result;
    }

    private boolean diagonalsWon(){
        return ((_boardsWon.get(0) == _boardsWon.get(4) && _boardsWon.get(4) == _boardsWon.get(8) && _boardsWon.get(8) != Player.PlayerNull)
              ||(_boardsWon.get(2) == _boardsWon.get(4) && _boardsWon.get(4) == _boardsWon.get(6) && _boardsWon.get(6) != Player.PlayerNull));
    }

    private boolean verticalsWon(){
        return  ((_boardsWon.get(0) == _boardsWon.get(3) && _boardsWon.get(3) == _boardsWon.get(6) && _boardsWon.get(6) != Player.PlayerNull)
               ||(_boardsWon.get(1) == _boardsWon.get(4) && _boardsWon.get(4) == _boardsWon.get(7) && _boardsWon.get(7) != Player.PlayerNull)
               ||(_boardsWon.get(2) == _boardsWon.get(5) && _boardsWon.get(5) == _boardsWon.get(8) && _boardsWon.get(8) != Player.PlayerNull));
    }

    private boolean horizontalsWon(){
        return  ((_boardsWon.get( 0) == _boardsWon.get( 1) && _boardsWon.get( 1) ==_boardsWon.get( 2) && _boardsWon.get(2) != Player.PlayerNull)
               ||(_boardsWon.get( 3) == _boardsWon.get( 4) && _boardsWon.get( 4) ==_boardsWon.get( 5) && _boardsWon.get(5) != Player.PlayerNull)
               ||(_boardsWon.get( 6) == _boardsWon.get( 7) && _boardsWon.get( 7) ==_boardsWon.get( 8) && _boardsWon.get(8) != Player.PlayerNull));
    }

    private int getIdForGameButton1(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_1;
            case 2: return R.id.b2_1;
            case 3: return R.id.b3_1;
            case 4: return R.id.b4_1;
            case 5: return R.id.b5_1;
            case 6: return R.id.b6_1;
            case 7: return R.id.b7_1;
            case 8: return R.id.b8_1;
            case 9: return R.id.b9_1;
            default: return 0;
        }
    }

    private int getIdForGameButton2(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_2;
            case 2: return R.id.b2_2;
            case 3: return R.id.b3_2;
            case 4: return R.id.b4_2;
            case 5: return R.id.b5_2;
            case 6: return R.id.b6_2;
            case 7: return R.id.b7_2;
            case 8: return R.id.b8_2;
            case 9: return R.id.b9_2;
            default: return 0;
        }
    }

    private int getIdForGameButton3(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_3;
            case 2: return R.id.b2_3;
            case 3: return R.id.b3_3;
            case 4: return R.id.b4_3;
            case 5: return R.id.b5_3;
            case 6: return R.id.b6_3;
            case 7: return R.id.b7_3;
            case 8: return R.id.b8_3;
            case 9: return R.id.b9_3;
            default: return 0;
        }
    }

    private int getIdForGameButton4(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_4;
            case 2: return R.id.b2_4;
            case 3: return R.id.b3_4;
            case 4: return R.id.b4_4;
            case 5: return R.id.b5_4;
            case 6: return R.id.b6_4;
            case 7: return R.id.b7_4;
            case 8: return R.id.b8_4;
            case 9: return R.id.b9_4;
            default: return 0;
        }
    }

    private int getIdForGameButton5(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_5;
            case 2: return R.id.b2_5;
            case 3: return R.id.b3_5;
            case 4: return R.id.b4_5;
            case 5: return R.id.b5_5;
            case 6: return R.id.b6_5;
            case 7: return R.id.b7_5;
            case 8: return R.id.b8_5;
            case 9: return R.id.b9_5;
            default: return 0;
        }
    }

    private int getIdForGameButton6(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_6;
            case 2: return R.id.b2_6;
            case 3: return R.id.b3_6;
            case 4: return R.id.b4_6;
            case 5: return R.id.b5_6;
            case 6: return R.id.b6_6;
            case 7: return R.id.b7_6;
            case 8: return R.id.b8_6;
            case 9: return R.id.b9_6;
            default: return 0;
        }
    }

    private int getIdForGameButton7(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_7;
            case 2: return R.id.b2_7;
            case 3: return R.id.b3_7;
            case 4: return R.id.b4_7;
            case 5: return R.id.b5_7;
            case 6: return R.id.b6_7;
            case 7: return R.id.b7_7;
            case 8: return R.id.b8_7;
            case 9: return R.id.b9_7;
            default: return 0;
        }
    }

    private int getIdForGameButton8(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_8;
            case 2: return R.id.b2_8;
            case 3: return R.id.b3_8;
            case 4: return R.id.b4_8;
            case 5: return R.id.b5_8;
            case 6: return R.id.b6_8;
            case 7: return R.id.b7_8;
            case 8: return R.id.b8_8;
            case 9: return R.id.b9_8;
            default: return 0;
        }
    }

    private int getIdForGameButton9(int gameBoard){
        switch (gameBoard){
            case 1: return R.id.b1_9;
            case 2: return R.id.b2_9;
            case 3: return R.id.b3_9;
            case 4: return R.id.b4_9;
            case 5: return R.id.b5_9;
            case 6: return R.id.b6_9;
            case 7: return R.id.b7_9;
            case 8: return R.id.b8_9;
            case 9: return R.id.b9_9;
            default: return 0;
        }
    }
}

