package greenvaultgames.com.supernoughtsandcrosses_singledevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;

        int buttonId = button.getId();

        int gameBoard = getGameBoard( buttonId);
        int gameButton = getGameButton( buttonId);

        Toast.makeText(getApplicationContext(), "gameBoard: " + Integer.toString(gameBoard) + "gameButton: " + Integer.toString(gameButton),
                Toast.LENGTH_SHORT).show();
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