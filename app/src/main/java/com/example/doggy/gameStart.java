package com.example.doggy;

import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class gameStart extends AppCompatActivity {
    int[] arr = {-1,-1,-1,-1,-1};
    int shootButton = -1;
    int[][] showArr = new int[5][3];
    int point = 0;
    int level = 10;
    static int interval = 30;
    static Timer timer;
    MediaPlayer correct;
    MediaPlayer wrong;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);


        findViewById(R.id.searchImageButton1).setEnabled(false);

        findViewById(R.id.searchImageButton2).setEnabled(false);

        findViewById(R.id.searchImageButton2).setEnabled(false);
        correct = MediaPlayer.create(this, R.raw.correct);
        wrong = MediaPlayer.create(this, R.raw.wrong);

        mp = MediaPlayer.create(this, R.raw.backgoundmusic);
        mp.start();
        Random r1 = new Random();
        for(int i = 0; i < 5; i++){
            arr[i] = r1.nextInt(3);

        }
        showArr[0][0] = R.id.imageview00;
        showArr[0][1] = R.id.imageview01;
        showArr[0][2] = R.id.imageview02;
        showArr[1][0] = R.id.imageview10;
        showArr[1][1] = R.id.imageview11;
        showArr[1][2] = R.id.imageview12;
        showArr[2][0] = R.id.imageview20;
        showArr[2][1] = R.id.imageview21;
        showArr[2][2] = R.id.imageview22;
        showArr[3][0] = R.id.imageview30;
        showArr[3][1] = R.id.imageview31;
        showArr[3][2] = R.id.imageview32;
        showArr[4][0] = R.id.imageview40;
        showArr[4][1] = R.id.imageview41;
        showArr[4][2] = R.id.imageview42;

        show();
        new CountDownTimer(4000, 1000) {
            TextView readyTimer = (TextView)findViewById(R.id.text_view_ready);
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished/1000 == 1){
                    readyTimer.setText("Start!");
                    readyTimer.setTextSize(100);
                    readyTimer.setTextColor(Color.RED);
                }
                else{
                    readyTimer.setText("" + (millisUntilFinished / 1000 - 1));
                    readyTimer.setTextSize(200);
                    readyTimer.setTextColor(Color.RED);
                }
            }

            public void onFinish() {
                readyTimer.setVisibility(View.INVISIBLE);
                findViewById(R.id.searchImageButton1).setEnabled(true);
                findViewById(R.id.searchImageButton2).setEnabled(true);
                findViewById(R.id.searchImageButton3).setEnabled(true);
                new CountDownTimer(31000, 1000) {
                    TextView showTimer = (TextView)findViewById(R.id.text_view_timer);
                    public void onTick(long millisUntilFinished) {
                        showTimer.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        toGameEnd();
                    }
                }.start();
            }
        }.start();
    }
    public void show(){
        if(point < 500)
            level = 10;
        else if(point >= 500 && point < 1500)
            level = 20;
        else if(point >= 1500 && point < 3000)
            level = 30;
        else
            level=50;
        if(point == 460){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[0][i]);
                a.setImageResource(R.drawable.dog2);
            }
        }
        else if(point == 470){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[1][i]);
                a.setImageResource(R.drawable.dog2);
            }
        }
        else if(point == 480){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[2][i]);
                a.setImageResource(R.drawable.dog2);
            }
        }
        else if(point == 490){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[3][i]);
                a.setImageResource(R.drawable.dog2);
            }
        }
        else if(point == 500){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[4][i]);
                a.setImageResource(R.drawable.dog2);
            }
        }
        else if(point == 1420){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[0][i]);
                a.setImageResource(R.drawable.dog3);
            }
        }
        else if(point == 1440){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[1][i]);
                a.setImageResource(R.drawable.dog3);
            }
        }
        else if(point == 1460){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[2][i]);
                a.setImageResource(R.drawable.dog3);
            }
        }
        else if(point == 1480){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[3][i]);
                a.setImageResource(R.drawable.dog3);
            }
        }
        else if(point == 1500){
            for(int i = 0; i < 3; i++){
                ImageView a = (ImageView)  findViewById(showArr[4][i]);
                a.setImageResource(R.drawable.dog3);
            }
        }

        for(int i = 0; i < showArr.length; i++){
            for(int j = 0; j < showArr[0].length; j++){
                if(arr[i] == j)
                    findViewById(showArr[i][j]).setVisibility(View.VISIBLE);
                else
                    findViewById(showArr[i][j]).setVisibility(View.INVISIBLE);
            }
        }

        TextView showPoint =  (TextView)findViewById(R.id.text_view_point);
        showPoint.setText(String.valueOf(point));

    }
    public void check(){

        Random r1 = new Random();
        if(arr[4] == shootButton){
            point += level;
            for(int i = 4; i > 0; i--)
                arr[i] = arr[i-1];
            arr[0] = r1.nextInt(3);
        }

        show();
    }


    public void onclickShoot1(View view) {
        shootButton = 0;
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);;
        check();
    }
    public void onclickShoot2(View view) {
        shootButton = 1;
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);;
        check();

    }
    public void onclickShoot3(View view) {
        shootButton = 2;
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);;
        check();

    }
    public void toGameEnd(){
        mp.setOnCompletionListener(mCompletionListener);
        mp.stop();
        mp.release();
        Intent intent = new Intent(this, gameEnd.class);
        intent.putExtra("point", point);
        startActivity(intent);
    }
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }};

    private void releaseMediaPlayer() {
        try {
            if (mp != null) {
                if (mp.isPlaying())
                    mp.stop();
                mp.release();
                mp = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}