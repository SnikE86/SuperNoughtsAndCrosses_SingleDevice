package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import java.util.ArrayList;
import java.util.List;

import greenvaultgames.com.supernoughtsandcrosses_singledevice.GameBoard.Player;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 23/09/2015.
 */
public class GameDataStore {
    public Player _currPlayer;

    public LastMoveDetails _lastMove;

    public ArrayList<char[]> _gameBoardMoves;

    public List<Player> _boardsWon;


    public GameDataStore(){
        _currPlayer = Player.Player1;
        _lastMove = new LastMoveDetails( 0, 0, 0, true);

        setupGameBoards();
        setupGameBoardMoves();
    }

    public String get_currPlayerAsString(){
        return _currPlayer.toString();
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
}
