package com.example.ligtas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ligtas.ui.settings.ThemePref;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME_OUT = 3500;
    FirebaseUser user;

    ThemePref themePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        themePref = new ThemePref(this);
        if (themePref.loadNightModeState() == 2){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else if (themePref.loadNightModeState() == 1){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView powered = findViewById(R.id.splashLogo);
        LottieAnimationView animated = findViewById(R.id.animated);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(200);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(2500);
        fadeOut.setDuration(3000);

        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);


        powered.setAnimation(animation);
        animated.setAnimation(animation);

        user = FirebaseAuth.getInstance().getCurrentUser();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = null;
                if (user != null) {

                    intent = new Intent(SplashActivity.this, UserNavigationActivity.class);//if login

                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                } else {

                    intent = new Intent(SplashActivity.this, MainActivity.class);//if not login

                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}