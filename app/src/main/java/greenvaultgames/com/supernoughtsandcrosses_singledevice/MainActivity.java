package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        android.os.Handler handle = new android.os.Handler();

        handle.postDelayed(new Runnable(){
            public void run(){
                launchGameBoard();
            }
        }, 3000);
    }

    public void launchGameBoard(){
        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);
    }

}