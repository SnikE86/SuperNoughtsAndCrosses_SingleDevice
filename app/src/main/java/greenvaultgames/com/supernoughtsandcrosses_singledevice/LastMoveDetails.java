package greenvaultgames.com.supernoughtsandcrosses_singledevice;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 13/09/2015.
 */
public class LastMoveDetails {
    public int lastButtonId;

    public int lastGameBoard;

    public int lastGameButton;

    public boolean nextMoveIsFree;

    public LastMoveDetails(int aLastButtonId, int aLastGameBoard, int aLastGameButton, boolean aNextMoveIsFree){
        lastButtonId = aLastButtonId;
        lastGameBoard = aLastGameBoard;
        lastGameButton = aLastGameButton;
        nextMoveIsFree = aNextMoveIsFree;
    }
}
