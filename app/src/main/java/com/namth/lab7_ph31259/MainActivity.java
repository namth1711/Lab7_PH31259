package com.namth.lab7_ph31259;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView wellcom =findViewById(R.id.txt_wellcome);
        ImageView logo = findViewById(R.id.logo);
        Animation anim_wellcome = AnimationUtils.loadAnimation(this,R.anim.wellcome);
        Animation anim_logo = AnimationUtils.loadAnimation(this, R.anim.animlogo);
        logo.startAnimation(anim_logo);
        wellcom.startAnimation(anim_wellcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Fan.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}