package com.programmingtalents.android.sharedpref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // High Score
        final TextView highScore = (TextView) findViewById(R.id.high_score_text);
        highScore.setText(SharedPrefManager.getIntPrefVal(this, Constants.HIGH_SCORE)+"");
        //Game Score
        final TextView gameScore = (TextView) findViewById(R.id.game_score_text);
        gameScore.setText(String.valueOf("0"));

        // Play Button
        final Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Random r = new Random();
                int val = r.nextInt(1000);
                gameScore.setText(String.valueOf(val));

                // Get Stored High Score
                if (val > SharedPrefManager.getIntPrefVal(MainActivity.this, Constants.HIGH_SCORE)) {

                    // Get and edit high score
			        SharedPrefManager.setIntPrefVal(MainActivity.this, Constants.HIGH_SCORE, val);
                    highScore.setText(String.valueOf(val));

                }
            }
        });

        // Reset Button
        final Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Set high score to 0
			    SharedPrefManager.setIntPrefVal(MainActivity.this, Constants.HIGH_SCORE,0);
                highScore.setText(String.valueOf("0"));
                gameScore.setText(String.valueOf("0"));

            }
        });

    }

}
