package com.example.fourth.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import com.example.fourth.Connections.Calls;
import com.football.match.R;
import com.kaiguanjs.SplashLietener;
import com.kaiguanjs.utils.YQCUtils;

public class Splash extends Activity {

    Handler handler;
    Calls calls;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        YQCUtils.splashAction(this, new SplashLietener() {
            @Override
            public void startMySplash(int version, String downUrl) {
               CALL();
               loop();
            }
        });

    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(calls.loadListStandings() == null && calls.loadListVideo() == null && calls.loadListScore() == null
                        && calls.loadListBansa() == null && calls.loadListTeams() == null){
                    loop();
                }else{
                    Intent intent=new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }
    public void loop(){
        startTimer();
    }

    public void CALL()
    {
        calls = new Calls(this);
        calls.clearData();
        calls.loadScore();
        calls.loadTeams();
        calls.loadStandings();
        calls.loadVideo();
        calls.loadBansa();
    }
}