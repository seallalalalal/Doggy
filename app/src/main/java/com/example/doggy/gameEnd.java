package com.example.doggy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class gameEnd extends AppCompatActivity {
    int point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        Intent intent = getIntent();
        point = intent.getIntExtra("point", 0);
        TextView finalPoint = (TextView)findViewById(R.id.text_view_finalPoint);
        finalPoint.setText(String.valueOf(point));
        finalPoint.setTextColor(Color.BLACK);
        finalPoint.setTextSize(50);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.end);
        mp.start();
    }
    public void onclickPlayAgain(View view){
        Intent intentA = new Intent(this, gameStart.class);
        startActivity(intentA);
    }
    public void onclickBackToMain(View view){
        Intent intentB = new Intent(this, MainActivity.class);
        startActivity(intentB);
    }

}