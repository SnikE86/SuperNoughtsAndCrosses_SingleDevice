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

public class DrawRedLineView extends View {
    Paint paint = new Paint();
    View startView;
    View endView;

    public DrawRedLineView(Context context,View startView,View endView) {
        super(context);
        paint.setColor(Color.RED);
        this.startView = startView;
        this.endView = endView;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(startView.getX()+25, startView.getY()+50, endView.getX()+25, endView.getY(), paint);
    }

}
