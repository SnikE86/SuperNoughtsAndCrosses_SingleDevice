package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
//import greenvaultgames.com.supernoughtsandcrosses_singledevice.GameDataStore.Player;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 16/09/2015.
 */



public class GameBoard extends Activity implements DrawWinningLinesInterface{

    public enum Player{ PlayerNull, Player1, Player2}

    private GameBoardModel model;

    private GameDataStore dataStore = new GameDataStore();

    private ButtonColourResolver colourResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        setPlayerTurn();

//        dataStore = new GameDataStore();
//        dataStore = aDataStore;

        model = new GameBoardModel(this, dataStore, this);

        colourResolver = new ButtonColourResolver(this, dataStore, model);

        colourResolver.colourAllButtonsNextMoveColour();
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;

        int buttonId = button.getId();

        int gameBoard = model.getGameBoard(buttonId);
        int gameButton = model.getGameButton(buttonId);

        if( button.getText() == "") {
            if (model.boardIsInPlay(gameBoard)) {
                if (dataStore._currPlayer == Player.Player1) {
                    button.setText("X");

                    addGameBoardMove(gameBoard, gameButton, 'X');

                    onPlayerMove(buttonId, gameBoard, gameButton);

                    dataStore._currPlayer = Player.Player2;

                    setPlayerTurn();
                } else {
                    button.setText("O");

                    addGameBoardMove( gameBoard, gameButton, 'O');

                    onPlayerMove(buttonId, gameBoard, gameButton);

                    dataStore._currPlayer = Player.Player1;

                    setPlayerTurn();
                }

                colourResolver.resolveColoursAfterMove();
            }
        }

        if( model.checkIfGameWon(gameBoard)){
            if( dataStore._currPlayer == Player.Player1){
                Toast toast = Toast.makeText(this, "Game won! Congrats" + Player.Player2.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
            else if( dataStore._currPlayer == Player.Player2){
                Toast toast = Toast.makeText(this, "Game won! Congrats" + Player.Player1.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    private void addGameBoardMove(int gameBoard, int gameButton, char move) {
        char[] board = dataStore._gameBoardMoves.get(gameBoard - 1);

        board[gameButton - 1] = move;
    }

    private void onPlayerMove(int buttonId, int gameBoard, int gameButton) {
        if( model.gameBoardIsFull(gameButton)){
            dataStore._lastMove = new LastMoveDetails( buttonId, gameBoard, gameButton, true);
        }
        else{
            dataStore._lastMove = new LastMoveDetails( buttonId, gameBoard, gameButton, false);
        }
    }

    public void drawWinLine_board(int buttonId1, int buttonId2){
        drawWinLine(buttonId1, buttonId2, WinType.wtBoard);
    }

    public void drawWinLine_game(int gameBoard1, int gameBoard2) {
        drawWinLine(model.getIdForGameButton5(gameBoard1), model.getIdForGameButton5(gameBoard2), WinType.wtGame);
    }

    private void drawWinLine( int buttonId1, int buttonId2, WinType winType){
        RelativeLayout rl_gameboard =(RelativeLayout)findViewById(R.id.rl_gameboard);

        Button button1 = (Button)findViewById(buttonId1);
        Button button2 = (Button)findViewById(buttonId2);

        DrawRedLineView drawView = new DrawRedLineView(this,button1,button2);

        drawView.setWinType(winType);

        rl_gameboard.addView(drawView);

        drawView.setElevation(10);
    }

    private void setPlayerTurn(){

        TextView player1Text = (TextView)findViewById(R.id.player1Text);
        TextView player2Text = (TextView)findViewById(R.id.player2Text);

        switch (dataStore._currPlayer) {
            case Player1: player1Text.setEnabled(true);  player2Text.setEnabled(false); break;
            case Player2: player1Text.setEnabled(false); player2Text.setEnabled(true); break;
        }
    }
}

