package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.app.Activity;
import android.widget.Button;
import android.widget.Toast;

import greenvaultgames.com.supernoughtsandcrosses_singledevice.GameBoard.Player;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 23/09/2015.
 */
public class GameBoardModel {

    private Activity activity;
    private GameDataStore dataStore;
    private DrawWinningLinesInterface drawLines;

    public GameBoardModel( Activity aActivity, GameDataStore aDataStore, DrawWinningLinesInterface aDrawLines){
        activity = aActivity;
        dataStore = aDataStore;
        drawLines = aDrawLines;
    }

    public boolean gameBoardIsFull(int gameButton) {
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

    public boolean buttonHasBeenPlayed(int buttonId) {
        Button button = (Button) activity.findViewById( buttonId);

        return button.getText() != "";
    }

    public boolean boardIsInPlay(int gameBoard) {
        return dataStore._lastMove.nextMoveIsFree || dataStore._lastMove.lastGameButton == gameBoard;
    }

    public int getGameBoard( int buttonId){
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

    public int getGameButton( int buttonId){
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

    public boolean checkIfGameWon( int game_board){
        checkBoard( game_board);

        return ( diagonalsWon() || verticalsWon() || horizontalsWon());
    }

    public boolean checkBoard( int game_board){
        if( dataStore._boardsWon.get(game_board - 1) == Player.PlayerNull) {
            if (boardDiagonalsWon(game_board) || boardVerticalsWon(game_board) || boardHorizontalsWon(game_board)) {
                dataStore._boardsWon.set(game_board - 1, dataStore._currPlayer);

                Toast toast = Toast.makeText(activity, "Board " + game_board + " won by: " + dataStore.get_currPlayerAsString(), Toast.LENGTH_LONG);
                toast.show();

                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public boolean boardDiagonalsWon( int game_board){
        boolean result = false;

        char[] board = dataStore._gameBoardMoves.get( game_board - 1);

        if(board[ 0] == board[ 4] && board[ 4] == board[ 8] && board[8] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton1(game_board), getIdForGameButton9(game_board));
        }

        if(board[ 2] == board[ 4] && board[ 4] == board[ 6] && board[6] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton3(game_board), getIdForGameButton7(game_board));
        }

        return result;
    }

    private boolean boardVerticalsWon( int game_board){
        boolean result = false;

        char[] board = dataStore._gameBoardMoves.get( game_board - 1);

        if(board[ 0] == board[ 3] && board[ 3] == board[ 6] && board[6] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton1(game_board), getIdForGameButton7(game_board));
        }
        if(board[ 1] == board[ 4] && board[ 4] == board[ 7] && board[7] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton2(game_board), getIdForGameButton8(game_board));
        }
        if(board[ 2] == board[ 5] && board[ 5] == board[ 8] && board[8] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton3(game_board), getIdForGameButton9(game_board));
        }

        return result;
    }

    private boolean boardHorizontalsWon( int game_board){
        boolean result = false;

        char[] board = dataStore._gameBoardMoves.get( game_board - 1);

        if(board[ 0] == board[ 1] && board[ 1] == board[ 2] && board[2] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton1(game_board), getIdForGameButton3(game_board));
        }
        if(board[ 3] == board[ 4] && board[ 4] == board[ 5] && board[5] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton4(game_board), getIdForGameButton6(game_board));
        }
        if(board[ 6] == board[ 7] && board[ 7] == board[ 8] && board[8] != '\u0000'){
            result = true;

            drawLines.drawWinLine_board(getIdForGameButton7(game_board), getIdForGameButton9(game_board));
        }

        return result;
    }

    private boolean diagonalsWon(){
        boolean result = false;

        if(dataStore._boardsWon.get(0) == dataStore._boardsWon.get(4) && dataStore._boardsWon.get(4) == dataStore._boardsWon.get(8) && dataStore._boardsWon.get(8) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(1, 9);
        }
        if(dataStore._boardsWon.get(2) == dataStore._boardsWon.get(4) && dataStore._boardsWon.get(4) == dataStore._boardsWon.get(6) &&dataStore. _boardsWon.get(6) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(3, 7);
        }

        return result;
    }

    private boolean verticalsWon(){
        boolean result = false;

        if(dataStore._boardsWon.get(0) == dataStore._boardsWon.get(3) && dataStore._boardsWon.get(3) == dataStore._boardsWon.get(6) && dataStore._boardsWon.get(6) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(1, 7);
        }
        if(dataStore._boardsWon.get(1) == dataStore._boardsWon.get(4) && dataStore._boardsWon.get(4) == dataStore._boardsWon.get(7) && dataStore._boardsWon.get(7) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(2, 8);
        }
        if(dataStore._boardsWon.get(2) == dataStore._boardsWon.get(5) && dataStore._boardsWon.get(5) == dataStore._boardsWon.get(8) && dataStore._boardsWon.get(8) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(3, 9);
        }

        return result;
    }

    private boolean horizontalsWon(){
        boolean result = false;

        if(dataStore._boardsWon.get( 0) == dataStore._boardsWon.get( 1) && dataStore._boardsWon.get( 1) == dataStore._boardsWon.get( 2) && dataStore._boardsWon.get(2) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(1, 3);
        }
        if(dataStore._boardsWon.get( 3) == dataStore._boardsWon.get( 4) &&dataStore. _boardsWon.get( 4) == dataStore._boardsWon.get( 5) && dataStore._boardsWon.get(5) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(4, 6);
        }
        if(dataStore._boardsWon.get( 6) == dataStore._boardsWon.get( 7) && dataStore._boardsWon.get( 7) == dataStore._boardsWon.get( 8) && dataStore._boardsWon.get(8) != Player.PlayerNull){
            result = true;

            drawLines.drawWinLine_game(7, 9);
        }

        return result;
    }

    public int getIdForGameButton1(int gameBoard){
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

    public int getIdForGameButton2(int gameBoard){
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

    public int getIdForGameButton3(int gameBoard){
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

    public int getIdForGameButton4(int gameBoard){
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

    public int getIdForGameButton5(int gameBoard){
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

    public int getIdForGameButton6(int gameBoard){
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

    public int getIdForGameButton7(int gameBoard){
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

    public int getIdForGameButton8(int gameBoard){
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

    public int getIdForGameButton9(int gameBoard){
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
            default:
                return 0;
        }
    }
}
