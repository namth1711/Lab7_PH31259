package com.namth.lab7_ph31259;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Fan extends AppCompatActivity {

    private ImageView fan;
    private Button fastBtn, mediumBtn, slowBtn, offBtn;
    private Animation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan);

        fan = findViewById(R.id.fan);
        fastBtn = findViewById(R.id.fast_btn);
        mediumBtn = findViewById(R.id.medium_btn);
        slowBtn = findViewById(R.id.slow_btn);
        offBtn = findViewById(R.id.off_btn);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.fan_rotate);
        offBtn.performClick();
        fastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFastClick(fan);
            }
        });
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMediumClick(fan);
            }
        });
        slowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSlowClick(fan);
            }
        });
        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offClick();
            }
        });
    }
   /* private void startClick(long time){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                fan.animate().rotation(360)
                        .setDuration(time)
                        .withEndAction(this)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        };
        fan.animate()
                .rotation(360)
                .setDuration(time)
                .withEndAction(run)
                .setInterpolator(new LinearInterpolator())
                .start();
    }*/
    public void offClick() {
        fan.clearAnimation();
    }

    public void onFastClick(View view) {
        fan.clearAnimation();
        rotateAnimation.setDuration(300);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        fan.startAnimation(rotateAnimation);
    }

    public void onMediumClick(View view) {
        fan.clearAnimation();
        rotateAnimation.setDuration(600);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        fan.startAnimation(rotateAnimation);
    }

    public void onSlowClick(View view) {
        fan.clearAnimation();
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        fan.startAnimation(rotateAnimation);
    }


}