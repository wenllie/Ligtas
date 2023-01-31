package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ligtas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Day1AdvancedActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day1AdvancedBackButton;
    AppCompatButton day1Ex1AdvancedStartButton, day1Ex2AdvancedStartButton, day1Ex3AdvancedStartButton, day1Ex4AdvancedStartButton, day1Ex5AdvancedStartButton;
    AppCompatButton day1Ex6AdvancedStartButton, day1Ex7AdvancedStartButton, day1Ex8AdvancedStartButton, day1Ex9AdvancedStartButton, day1Ex10AdvancedStartButton;
    AppCompatButton day1Ex1AdvancedNextButton, day1Ex2AdvancedNextButton, day1Ex3AdvancedNextButton, day1Ex4AdvancedNextButton, day1Ex5AdvancedNextButton;
    AppCompatButton day1Ex6AdvancedNextButton, day1Ex7AdvancedNextButton, day1Ex8AdvancedNextButton, day1Ex9AdvancedNextButton, day1Ex10AdvancedNextButton;
    AppCompatImageView aboutDay1Ex1AdvancedButton, aboutDay1Ex2AdvancedButton, aboutDay1Ex3AdvancedButton, aboutDay1Ex4AdvancedButton, aboutDay1Ex5AdvancedButton;
    AppCompatImageView aboutDay1Ex6AdvancedButton, aboutDay1Ex7AdvancedButton, aboutDay1Ex8AdvancedButton, aboutDay1Ex9AdvancedButton, aboutDay1Ex10AdvancedButton;
    AppCompatImageView advanced_day1_ex1_photo, advanced_day1_ex2_photo, advanced_day1_ex3_photo, advanced_day1_ex4_photo, advanced_day1_ex5_photo;
    AppCompatImageView advanced_day1_ex6_photo, advanced_day1_ex7_photo, advanced_day1_ex8_photo, advanced_day1_ex9_photo, advanced_day1_ex10_photo;
    FrameLayout advanced_day1_ex1_layout, advanced_day1_ex2_layout, advanced_day1_ex3_layout, advanced_day1_ex4_layout, advanced_day1_ex5_layout;
    FrameLayout advanced_day1_ex6_layout, advanced_day1_ex7_layout, advanced_day1_ex8_layout, advanced_day1_ex9_layout, advanced_day1_ex10_layout;
    FrameLayout advanced_day1_rest1_layout, advanced_day1_rest2_layout, advanced_day1_rest3_layout, advanced_day1_rest4_layout;
    FrameLayout advanced_day1_rest5_layout, advanced_day1_rest6_layout, advanced_day1_rest7_layout, advanced_day1_rest8_layout, advanced_day1_rest9_layout;
    AppCompatButton day1Rest1AdvancedStartButton, day1Rest2AdvancedStartButton, day1Rest3AdvancedStartButton, day1Rest4AdvancedStartButton;
    AppCompatButton day1Rest5AdvancedStartButton, day1Rest6AdvancedStartButton, day1Rest7AdvancedStartButton, day1Rest8AdvancedStartButton, day1Rest9AdvancedStartButton;
    AppCompatButton day1Rest1AdvancedFinishButton, day1Rest2AdvancedFinishButton, day1Rest3AdvancedFinishButton, day1Rest4AdvancedFinishButton;
    AppCompatButton day1Rest5AdvancedFinishButton, day1Rest6AdvancedFinishButton, day1Rest7AdvancedFinishButton, day1Rest8AdvancedFinishButton, day1Rest9AdvancedFinishButton;
    AppCompatTextView timer_advanced_day1_ex2, timer_advanced_day1_ex4, timer_advanced_day1_ex5, timer_advanced_day1_ex6, timer_advanced_day1_ex8, timer_advanced_day1_ex9;
    AppCompatTextView timer_advanced_day1_rest1, timer_advanced_day1_rest2, timer_advanced_day1_rest3, timer_advanced_day1_rest4;
    AppCompatTextView timer_advanced_day1_rest5, timer_advanced_day1_rest6, timer_advanced_day1_rest7, timer_advanced_day1_rest8, timer_advanced_day1_rest9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_advanced);

        day1AdvancedBackButton = findViewById(R.id.day1AdvancedBackButton);

        aboutDay1Ex1AdvancedButton = findViewById(R.id.aboutDay1Ex1AdvancedButton);
        aboutDay1Ex2AdvancedButton = findViewById(R.id.aboutDay1Ex2AdvancedButton);
        aboutDay1Ex3AdvancedButton = findViewById(R.id.aboutDay1Ex3AdvancedButton);
        aboutDay1Ex4AdvancedButton = findViewById(R.id.aboutDay1Ex4AdvancedButton);
        aboutDay1Ex5AdvancedButton = findViewById(R.id.aboutDay1Ex5AdvancedButton);
        aboutDay1Ex6AdvancedButton = findViewById(R.id.aboutDay1Ex6AdvancedButton);
        aboutDay1Ex7AdvancedButton = findViewById(R.id.aboutDay1Ex7AdvancedButton);
        aboutDay1Ex8AdvancedButton = findViewById(R.id.aboutDay1Ex8AdvancedButton);
        aboutDay1Ex9AdvancedButton = findViewById(R.id.aboutDay1Ex9AdvancedButton);
        aboutDay1Ex10AdvancedButton = findViewById(R.id.aboutDay1Ex10AdvancedButton);

        day1Ex1AdvancedStartButton = findViewById(R.id.day1Ex1AdvancedStartButton);
        day1Ex2AdvancedStartButton = findViewById(R.id.day1Ex2AdvancedStartButton);
        day1Ex3AdvancedStartButton = findViewById(R.id.day1Ex3AdvancedStartButton);
        day1Ex4AdvancedStartButton = findViewById(R.id.day1Ex4AdvancedStartButton);
        day1Ex5AdvancedStartButton = findViewById(R.id.day1Ex5AdvancedStartButton);
        day1Ex6AdvancedStartButton = findViewById(R.id.day1Ex6AdvancedStartButton);
        day1Ex7AdvancedStartButton = findViewById(R.id.day1Ex7AdvancedStartButton);
        day1Ex8AdvancedStartButton = findViewById(R.id.day1Ex8AdvancedStartButton);
        day1Ex9AdvancedStartButton = findViewById(R.id.day1Ex9AdvancedStartButton);
        day1Ex10AdvancedStartButton = findViewById(R.id.day1Ex10AdvancedStartButton);

        day1Ex1AdvancedNextButton = findViewById(R.id.day1Ex1AdvancedNextButton);
        day1Ex2AdvancedNextButton = findViewById(R.id.day1Ex2AdvancedNextButton);
        day1Ex3AdvancedNextButton = findViewById(R.id.day1Ex3AdvancedNextButton);
        day1Ex4AdvancedNextButton = findViewById(R.id.day1Ex4AdvancedNextButton);
        day1Ex5AdvancedNextButton = findViewById(R.id.day1Ex5AdvancedNextButton);
        day1Ex6AdvancedNextButton = findViewById(R.id.day1Ex6AdvancedNextButton);
        day1Ex7AdvancedNextButton = findViewById(R.id.day1Ex7AdvancedNextButton);
        day1Ex8AdvancedNextButton = findViewById(R.id.day1Ex8AdvancedNextButton);
        day1Ex9AdvancedNextButton = findViewById(R.id.day1Ex9AdvancedNextButton);
        day1Ex10AdvancedNextButton = findViewById(R.id.day1Ex10AdvancedNextButton);

        advanced_day1_ex1_layout = findViewById(R.id.advanced_day1_ex1_layout);
        advanced_day1_ex2_layout = findViewById(R.id.advanced_day1_ex2_layout);
        advanced_day1_ex3_layout = findViewById(R.id.advanced_day1_ex3_layout);
        advanced_day1_ex4_layout = findViewById(R.id.advanced_day1_ex4_layout);
        advanced_day1_ex5_layout = findViewById(R.id.advanced_day1_ex5_layout);
        advanced_day1_ex6_layout = findViewById(R.id.advanced_day1_ex6_layout);
        advanced_day1_ex7_layout = findViewById(R.id.advanced_day1_ex7_layout);
        advanced_day1_ex8_layout = findViewById(R.id.advanced_day1_ex8_layout);
        advanced_day1_ex9_layout = findViewById(R.id.advanced_day1_ex9_layout);
        advanced_day1_ex10_layout = findViewById(R.id.advanced_day1_ex10_layout);

        advanced_day1_rest1_layout = findViewById(R.id.advanced_day1_rest1_layout);
        advanced_day1_rest2_layout = findViewById(R.id.advanced_day1_rest2_layout);
        advanced_day1_rest3_layout = findViewById(R.id.advanced_day1_rest3_layout);
        advanced_day1_rest4_layout = findViewById(R.id.advanced_day1_rest4_layout);
        advanced_day1_rest5_layout = findViewById(R.id.advanced_day1_rest5_layout);
        advanced_day1_rest6_layout = findViewById(R.id.advanced_day1_rest6_layout);
        advanced_day1_rest7_layout = findViewById(R.id.advanced_day1_rest7_layout);
        advanced_day1_rest8_layout = findViewById(R.id.advanced_day1_rest8_layout);
        advanced_day1_rest9_layout = findViewById(R.id.advanced_day1_rest9_layout);

        day1Rest1AdvancedStartButton = findViewById(R.id.day1Rest1AdvancedStartButton);
        day1Rest2AdvancedStartButton = findViewById(R.id.day1Rest2AdvancedStartButton);
        day1Rest3AdvancedStartButton = findViewById(R.id.day1Rest3AdvancedStartButton);
        day1Rest4AdvancedStartButton = findViewById(R.id.day1Rest4AdvancedStartButton);
        day1Rest5AdvancedStartButton = findViewById(R.id.day1Rest5AdvancedStartButton);
        day1Rest6AdvancedStartButton = findViewById(R.id.day1Rest6AdvancedStartButton);
        day1Rest7AdvancedStartButton = findViewById(R.id.day1Rest7AdvancedStartButton);
        day1Rest8AdvancedStartButton = findViewById(R.id.day1Rest8AdvancedStartButton);
        day1Rest9AdvancedStartButton = findViewById(R.id.day1Rest9AdvancedStartButton);

        day1Rest1AdvancedFinishButton = findViewById(R.id.day1Rest1AdvancedFinishButton);
        day1Rest2AdvancedFinishButton = findViewById(R.id.day1Rest2AdvancedFinishButton);
        day1Rest3AdvancedFinishButton = findViewById(R.id.day1Rest3AdvancedFinishButton);
        day1Rest4AdvancedFinishButton = findViewById(R.id.day1Rest4AdvancedFinishButton);
        day1Rest5AdvancedFinishButton = findViewById(R.id.day1Rest5AdvancedFinishButton);
        day1Rest6AdvancedFinishButton = findViewById(R.id.day1Rest6AdvancedFinishButton);
        day1Rest7AdvancedFinishButton = findViewById(R.id.day1Rest7AdvancedFinishButton);
        day1Rest8AdvancedFinishButton = findViewById(R.id.day1Rest8AdvancedFinishButton);
        day1Rest9AdvancedFinishButton = findViewById(R.id.day1Rest9AdvancedFinishButton);

        advanced_day1_ex1_photo = findViewById(R.id.advanced_day1_ex1_photo);
        advanced_day1_ex2_photo = findViewById(R.id.advanced_day1_ex2_photo);
        advanced_day1_ex3_photo = findViewById(R.id.advanced_day1_ex3_photo);
        advanced_day1_ex4_photo = findViewById(R.id.advanced_day1_ex4_photo);
        advanced_day1_ex5_photo = findViewById(R.id.advanced_day1_ex5_photo);
        advanced_day1_ex6_photo = findViewById(R.id.advanced_day1_ex6_photo);
        advanced_day1_ex7_photo = findViewById(R.id.advanced_day1_ex7_photo);
        advanced_day1_ex8_photo = findViewById(R.id.advanced_day1_ex8_photo);
        advanced_day1_ex9_photo = findViewById(R.id.advanced_day1_ex9_photo);
        advanced_day1_ex10_photo = findViewById(R.id.advanced_day1_ex10_photo);

        timer_advanced_day1_ex2 = findViewById(R.id.timer_advanced_day1_ex2);
        timer_advanced_day1_ex4 = findViewById(R.id.timer_advanced_day1_ex4);
        timer_advanced_day1_ex5 = findViewById(R.id.timer_advanced_day1_ex5);
        timer_advanced_day1_ex6 = findViewById(R.id.timer_advanced_day1_ex6);
        timer_advanced_day1_ex8 = findViewById(R.id.timer_advanced_day1_ex8);
        timer_advanced_day1_ex9 = findViewById(R.id.timer_advanced_day1_ex9);

        timer_advanced_day1_rest1 = findViewById(R.id.timer_advanced_day1_rest1);
        timer_advanced_day1_rest2 = findViewById(R.id.timer_advanced_day1_rest2);
        timer_advanced_day1_rest3 = findViewById(R.id.timer_advanced_day1_rest3);
        timer_advanced_day1_rest4 = findViewById(R.id.timer_advanced_day1_rest4);
        timer_advanced_day1_rest5 = findViewById(R.id.timer_advanced_day1_rest5);
        timer_advanced_day1_rest6 = findViewById(R.id.timer_advanced_day1_rest6);
        timer_advanced_day1_rest7 = findViewById(R.id.timer_advanced_day1_rest7);
        timer_advanced_day1_rest8 = findViewById(R.id.timer_advanced_day1_rest8);
        timer_advanced_day1_rest9 = findViewById(R.id.timer_advanced_day1_rest9);

        Glide.with(this).load(R.drawable.squats_exercise).into(advanced_day1_ex1_photo);
        Glide.with(this).load(R.drawable.high_knees_exercise).into(advanced_day1_ex2_photo);
        Glide.with(this).load(R.drawable.reverse_lunges_exercise).into(advanced_day1_ex3_photo);
        Glide.with(this).load(R.drawable.plank_jacks_exercise).into(advanced_day1_ex4_photo);
        Glide.with(this).load(R.drawable.skater_hops_exercise).into(advanced_day1_ex5_photo);
        Glide.with(this).load(R.drawable.side_lunges_exercise).into(advanced_day1_ex6_photo);
        Glide.with(this).load(R.drawable.push_ups).into(advanced_day1_ex7_photo);
        Glide.with(this).load(R.drawable.bicycle_crunches).into(advanced_day1_ex8_photo);
        Glide.with(this).load(R.drawable.mountain_climbers).into(advanced_day1_ex9_photo);
        Glide.with(this).load(R.drawable.donkey_kicks_exercise).into(advanced_day1_ex10_photo);


        day1AdvancedBackButton.setOnClickListener(this);

        day1Ex1AdvancedStartButton.setOnClickListener(this);
        day1Ex2AdvancedStartButton.setOnClickListener(this);
        day1Ex3AdvancedStartButton.setOnClickListener(this);
        day1Ex4AdvancedStartButton.setOnClickListener(this);
        day1Ex5AdvancedStartButton.setOnClickListener(this);
        day1Ex6AdvancedStartButton.setOnClickListener(this);
        day1Ex7AdvancedStartButton.setOnClickListener(this);
        day1Ex8AdvancedStartButton.setOnClickListener(this);
        day1Ex9AdvancedStartButton.setOnClickListener(this);
        day1Ex10AdvancedStartButton.setOnClickListener(this);

        day1Ex1AdvancedNextButton.setOnClickListener(this);
        day1Ex2AdvancedNextButton.setOnClickListener(this);
        day1Ex3AdvancedNextButton.setOnClickListener(this);
        day1Ex4AdvancedNextButton.setOnClickListener(this);
        day1Ex5AdvancedNextButton.setOnClickListener(this);
        day1Ex6AdvancedNextButton.setOnClickListener(this);
        day1Ex7AdvancedNextButton.setOnClickListener(this);
        day1Ex8AdvancedNextButton.setOnClickListener(this);
        day1Ex9AdvancedNextButton.setOnClickListener(this);
        day1Ex10AdvancedNextButton.setOnClickListener(this);

        aboutDay1Ex1AdvancedButton.setOnClickListener(this);
        aboutDay1Ex2AdvancedButton.setOnClickListener(this);
        aboutDay1Ex3AdvancedButton.setOnClickListener(this);
        aboutDay1Ex4AdvancedButton.setOnClickListener(this);
        aboutDay1Ex5AdvancedButton.setOnClickListener(this);
        aboutDay1Ex6AdvancedButton.setOnClickListener(this);
        aboutDay1Ex7AdvancedButton.setOnClickListener(this);
        aboutDay1Ex8AdvancedButton.setOnClickListener(this);
        aboutDay1Ex9AdvancedButton.setOnClickListener(this);
        aboutDay1Ex10AdvancedButton.setOnClickListener(this);

        day1Rest1AdvancedStartButton.setOnClickListener(this);
        day1Rest2AdvancedStartButton.setOnClickListener(this);
        day1Rest3AdvancedStartButton.setOnClickListener(this);
        day1Rest4AdvancedStartButton.setOnClickListener(this);
        day1Rest5AdvancedStartButton.setOnClickListener(this);
        day1Rest6AdvancedStartButton.setOnClickListener(this);
        day1Rest7AdvancedStartButton.setOnClickListener(this);
        day1Rest8AdvancedStartButton.setOnClickListener(this);
        day1Rest9AdvancedStartButton.setOnClickListener(this);

        day1Rest1AdvancedFinishButton.setOnClickListener(this);
        day1Rest2AdvancedFinishButton.setOnClickListener(this);
        day1Rest3AdvancedFinishButton.setOnClickListener(this);
        day1Rest4AdvancedFinishButton.setOnClickListener(this);
        day1Rest5AdvancedFinishButton.setOnClickListener(this);
        day1Rest6AdvancedFinishButton.setOnClickListener(this);
        day1Rest7AdvancedFinishButton.setOnClickListener(this);
        day1Rest8AdvancedFinishButton.setOnClickListener(this);
        day1Rest9AdvancedFinishButton.setOnClickListener(this);
        
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(Day1AdvancedActivity.this, AdvancedWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.day1AdvancedBackButton:
                onBackPressed();
                break;

            case R.id.day1Ex1AdvancedStartButton:
                advanced_day1_ex1_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex1AdvancedStartButton.setVisibility(View.GONE);
                day1Ex1AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex1AdvancedNextButton:
                advanced_day1_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest1StartButton:
                advanced_day1_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest1AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest1.setText("00:00");
                        day1Rest1AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest1FinishButton:
                advanced_day1_rest1_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex2StartButton:
                advanced_day1_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex2AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_ex2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_ex2.setText("00:00");
                        day1Ex2AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Ex2NextButton:
                advanced_day1_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest2StartButton:
                advanced_day1_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest2AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest2.setText("00:00");
                        day1Rest2AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest2FinishButton:
                advanced_day1_rest2_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex3StartButton:
                advanced_day1_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex3AdvancedStartButton.setVisibility(View.GONE);
                day1Ex3AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex3NextButton:
                advanced_day1_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest3StartButton:
                advanced_day1_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest3AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest3.setText("00:00");
                        day1Rest3AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest3FinishButton:
                advanced_day1_rest3_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex4StartButton:
                advanced_day1_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_ex4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_ex4.setText("00:00");
                        day1Ex4AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Ex4NextButton:
                advanced_day1_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest4StartButton:
                advanced_day1_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest4.setText("00:00");
                        day1Rest4AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest4FinishButton:
                advanced_day1_rest4_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex5StartButton:
                advanced_day1_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_ex5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_ex5.setText("00:00");
                        day1Ex5AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Ex5NextButton:
                advanced_day1_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest5StartButton:
                advanced_day1_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest5.setText("00:00");
                        day1Rest5AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest5FinishButton:
                advanced_day1_rest5_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex6StartButton:
                advanced_day1_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex6AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_ex6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_ex6.setText("00:00");
                        day1Ex6AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Ex6NextButton:
                advanced_day1_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest6StartButton:
                advanced_day1_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest6AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest6.setText("00:00");
                        day1Rest6AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest6FinishButton:
                advanced_day1_rest6_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex7StartButton:
                advanced_day1_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex7AdvancedStartButton.setVisibility(View.GONE);
                day1Ex7AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex7NextButton:
                advanced_day1_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest7StartButton:
                advanced_day1_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest7AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest7.setText("00:00");
                        day1Rest7AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest7FinishButton:
                advanced_day1_rest7_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex8StartButton:
                advanced_day1_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex8AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_ex8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_ex8.setText("00:00");
                        day1Ex8AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Ex8NextButton:
                advanced_day1_rest8_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest8StartButton:
                advanced_day1_rest8_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest8AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest8.setText("00:00");
                        day1Rest8AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest8FinishButton:
                advanced_day1_rest8_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex9StartButton:
                advanced_day1_ex9_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex9AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_ex9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_ex9.setText("00:00");
                        day1Ex9AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Ex9NextButton:
                advanced_day1_rest9_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Rest9StartButton:
                advanced_day1_rest9_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest9AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day1_rest9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day1_rest9.setText("00:00");
                        day1Rest9AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day1Rest9AdvancedFinishButton:
                advanced_day1_rest9_layout.setVisibility(View.GONE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                advanced_day1_ex10_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex10AdvancedStartButton:
                advanced_day1_ex10_layout.setVisibility(View.VISIBLE);
                advanced_day1_ex1_layout.setVisibility(View.GONE);
                advanced_day1_ex2_layout.setVisibility(View.GONE);
                advanced_day1_ex3_layout.setVisibility(View.GONE);
                advanced_day1_ex4_layout.setVisibility(View.GONE);
                advanced_day1_ex5_layout.setVisibility(View.GONE);
                advanced_day1_ex6_layout.setVisibility(View.GONE);
                advanced_day1_ex7_layout.setVisibility(View.GONE);
                advanced_day1_ex8_layout.setVisibility(View.GONE);
                advanced_day1_ex9_layout.setVisibility(View.GONE);
                day1Ex10AdvancedStartButton.setVisibility(View.GONE);
                day1Ex10AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex10AdvancedNextButton:

                DatabaseReference workoutReference = FirebaseDatabase.getInstance().getReference().child("Users");

                workoutReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {

                        for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                            String userTypeKey = userTypeSnap.getKey();

                            if (userTypeKey.equalsIgnoreCase("Employees")) {

                                for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                    String idNumberKey = idNumberSnap.getKey();

                                    for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                        String userIdKey = userIdSnap.getKey();

                                        if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                            for (DataSnapshot workoutSnap : userIdSnap.getChildren()) {

                                                String workoutkey = workoutSnap.getKey();

                                                if (workoutkey.equalsIgnoreCase("Workouts")) {

                                                    for (DataSnapshot typeSnap : workoutSnap.getChildren()) {

                                                        String typeKey = typeSnap.getKey();

                                                        if (typeKey.equalsIgnoreCase("Advanced")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 1")) {

                                                                    Toast.makeText(Day1AdvancedActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }
                                                        }
                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1AdvancedActivity.this, AdvancedWorkoutActivity.class);
                                                    toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(toStayHealthy);
                                                    finish();
                                                }

                                            }

                                        }

                                    }

                                }

                            } else if (userTypeKey.equalsIgnoreCase("Students")) {

                                for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                    String idNumberKey = idNumberSnap.getKey();

                                    for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                        String userIdKey = userIdSnap.getKey();

                                        if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                            for (DataSnapshot workoutSnap : userIdSnap.getChildren()) {

                                                String workoutkey = workoutSnap.getKey();

                                                if (workoutkey.equalsIgnoreCase("Workouts")) {

                                                    for (DataSnapshot typeSnap : workoutSnap.getChildren()) {

                                                        String typeKey = typeSnap.getKey();

                                                        if (typeKey.equalsIgnoreCase("Advanced")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 1")) {

                                                                    Toast.makeText(Day1AdvancedActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }
                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1AdvancedActivity.this, AdvancedWorkoutActivity.class);
                                                    toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(toStayHealthy);
                                                    finish();
                                                }

                                            }

                                        }

                                    }

                                }

                            } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                                for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                    String idNumberKey = idNumberSnap.getKey();

                                    for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                        String userIdKey = userIdSnap.getKey();

                                        if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                            for (DataSnapshot workoutSnap : userIdSnap.getChildren()) {

                                                String workoutkey = workoutSnap.getKey();

                                                if (workoutkey.equalsIgnoreCase("Workouts")) {

                                                    for (DataSnapshot typeSnap : workoutSnap.getChildren()) {

                                                        String typeKey = typeSnap.getKey();

                                                        if (typeKey.equalsIgnoreCase("Advanced")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 1")) {

                                                                    Toast.makeText(Day1AdvancedActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1AdvancedActivity.this, AdvancedWorkoutActivity.class);
                                                    toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(toStayHealthy);
                                                    finish();
                                                }

                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }
                });
                break;

            case R.id.aboutDay1Ex1AdvancedButton:
                final DialogPlus about = DialogPlus.newDialog(Day1AdvancedActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }
}