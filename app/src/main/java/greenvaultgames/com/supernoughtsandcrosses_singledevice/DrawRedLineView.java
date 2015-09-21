package greenvaultgames.com.supernoughtsandcrosses_singledevice;

/**
 * SuperNoughtsAndCrosses_SingleDevice
 * Created by michael on 20/09/2015.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

enum WinType{wtBoard, wtGame}

public class DrawRedLineView extends View {
    Paint paint = new Paint();
    View _startView;
    View _endView;
    WinType _winType;

    public DrawRedLineView(Context context,View startView,View endView) {
        super(context);
        paint.setColor(Color.RED);
        _startView = startView;
        _endView = endView;
    }

    public void setWinType( WinType winType){
        _winType = winType;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth( getPaintStrokeWidth());

        canvas.drawLine(_startView.getX() + (_startView.getWidth() / 2),
                        _startView.getY() + (_startView.getHeight() / 2),
                        _endView.getX() + (_endView.getWidth() / 2),
                        _endView.getY() + (_endView.getHeight() / 2),
                        paint);
    }

    private float getPaintStrokeWidth(){
        switch (_winType){
            case wtBoard: return 5;
            case wtGame:  return 20;
            default:      return 0;
        }
    }

}
