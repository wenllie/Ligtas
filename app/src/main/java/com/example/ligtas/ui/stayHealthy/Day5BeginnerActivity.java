package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.DialogInterface;
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

public class Day5BeginnerActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day5BackButton;
    AppCompatButton day5Ex1StartButton, day5Ex2StartButton, day5Ex3StartButton, day5Ex4StartButton, day5Ex5StartButton, day5Ex6StartButton, day5Ex7StartButton, day5Ex8StartButton, day5Ex9StartButton;
    AppCompatButton day5Ex1NextButton, day5Ex2NextButton, day5Ex3NextButton, day5Ex4NextButton, day5Ex5NextButton, day5Ex6NextButton, day5Ex7NextButton, day5Ex8NextButton, day5Ex9NextButton;
    AppCompatImageView aboutDay5Ex1BeginnerButton, aboutDay5Ex2BeginnerButton, aboutDay5Ex3BeginnerButton, aboutDay5Ex4BeginnerButton, aboutDay5Ex5BeginnerButton;
    AppCompatImageView aboutDay5Ex6BeginnerButton, aboutDay5Ex7BeginnerButton, aboutDay5Ex8BeginnerButton, aboutDay5Ex9BeginnerButton;
    AppCompatImageView beginner_day5_ex1_photo, beginner_day5_ex2_photo, beginner_day5_ex3_photo, beginner_day5_ex4_photo, beginner_day5_ex5_photo;
    AppCompatImageView beginner_day5_ex6_photo, beginner_day5_ex7_photo, beginner_day5_ex8_photo, beginner_day5_ex9_photo;
    FrameLayout beginner_day5_ex1_layout, beginner_day5_ex2_layout, beginner_day5_ex3_layout, beginner_day5_ex4_layout, beginner_day5_ex5_layout;
    FrameLayout beginner_day5_ex6_layout, beginner_day5_ex7_layout, beginner_day5_ex8_layout, beginner_day5_ex9_layout;
    FrameLayout beginner_day5_rest1_layout, beginner_day5_rest2_layout, beginner_day5_rest3_layout, beginner_day5_rest4_layout;
    FrameLayout beginner_day5_rest5_layout, beginner_day5_rest6_layout, beginner_day5_rest7_layout, beginner_day5_rest8_layout;
    AppCompatButton day5Rest1StartButton, day5Rest2StartButton, day5Rest3StartButton, day5Rest4StartButton;
    AppCompatButton day5Rest5StartButton, day5Rest6StartButton, day5Rest7StartButton, day5Rest8StartButton;
    AppCompatButton day5Rest1FinishButton, day5Rest2FinishButton, day5Rest3FinishButton, day5Rest4FinishButton;
    AppCompatButton day5Rest5FinishButton, day5Rest6FinishButton, day5Rest7FinishButton, day5Rest8FinishButton;
    AppCompatTextView timer_beginner_day5_ex4, timer_beginner_day5_ex5, timer_beginner_day5_ex9;
    AppCompatTextView timer_beginner_day5_rest1, timer_beginner_day5_rest2, timer_beginner_day5_rest3, timer_beginner_day5_rest4;
    AppCompatTextView timer_beginner_day5_rest5, timer_beginner_day5_rest6, timer_beginner_day5_rest7, timer_beginner_day5_rest8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5_beginner);

        day5BackButton = findViewById(R.id.day5BackButton);

        aboutDay5Ex1BeginnerButton = findViewById(R.id.aboutDay5Ex1BeginnerButton);
        aboutDay5Ex2BeginnerButton = findViewById(R.id.aboutDay5Ex2BeginnerButton);
        aboutDay5Ex3BeginnerButton = findViewById(R.id.aboutDay5Ex3BeginnerButton);
        aboutDay5Ex4BeginnerButton = findViewById(R.id.aboutDay5Ex4BeginnerButton);
        aboutDay5Ex5BeginnerButton = findViewById(R.id.aboutDay5Ex5BeginnerButton);
        aboutDay5Ex6BeginnerButton = findViewById(R.id.aboutDay5Ex6BeginnerButton);
        aboutDay5Ex7BeginnerButton = findViewById(R.id.aboutDay5Ex7BeginnerButton);
        aboutDay5Ex8BeginnerButton = findViewById(R.id.aboutDay5Ex8BeginnerButton);
        aboutDay5Ex9BeginnerButton = findViewById(R.id.aboutDay5Ex9BeginnerButton);

        day5Ex1StartButton = findViewById(R.id.day5Ex1StartButton);
        day5Ex2StartButton = findViewById(R.id.day5Ex2StartButton);
        day5Ex3StartButton = findViewById(R.id.day5Ex3StartButton);
        day5Ex4StartButton = findViewById(R.id.day5Ex4StartButton);
        day5Ex5StartButton = findViewById(R.id.day5Ex5StartButton);
        day5Ex6StartButton = findViewById(R.id.day5Ex6StartButton);
        day5Ex7StartButton = findViewById(R.id.day5Ex7StartButton);
        day5Ex8StartButton = findViewById(R.id.day5Ex8StartButton);
        day5Ex9StartButton = findViewById(R.id.day5Ex9StartButton);

        day5Ex1NextButton = findViewById(R.id.day5Ex1NextButton);
        day5Ex2NextButton = findViewById(R.id.day5Ex2NextButton);
        day5Ex3NextButton = findViewById(R.id.day5Ex3NextButton);
        day5Ex4NextButton = findViewById(R.id.day5Ex4NextButton);
        day5Ex5NextButton = findViewById(R.id.day5Ex5NextButton);
        day5Ex6NextButton = findViewById(R.id.day5Ex6NextButton);
        day5Ex7NextButton = findViewById(R.id.day5Ex7NextButton);
        day5Ex8NextButton = findViewById(R.id.day5Ex8NextButton);
        day5Ex9NextButton = findViewById(R.id.day5Ex9NextButton);

        beginner_day5_ex1_layout = findViewById(R.id.beginner_day5_ex1_layout);
        beginner_day5_ex2_layout = findViewById(R.id.beginner_day5_ex2_layout);
        beginner_day5_ex3_layout = findViewById(R.id.beginner_day5_ex3_layout);
        beginner_day5_ex4_layout = findViewById(R.id.beginner_day5_ex4_layout);
        beginner_day5_ex5_layout = findViewById(R.id.beginner_day5_ex5_layout);
        beginner_day5_ex6_layout = findViewById(R.id.beginner_day5_ex6_layout);
        beginner_day5_ex7_layout = findViewById(R.id.beginner_day5_ex7_layout);
        beginner_day5_ex8_layout = findViewById(R.id.beginner_day5_ex8_layout);
        beginner_day5_ex9_layout = findViewById(R.id.beginner_day5_ex9_layout);

        beginner_day5_rest1_layout = findViewById(R.id.beginner_day5_rest1_layout);
        beginner_day5_rest2_layout = findViewById(R.id.beginner_day5_rest2_layout);
        beginner_day5_rest3_layout = findViewById(R.id.beginner_day5_rest3_layout);
        beginner_day5_rest4_layout = findViewById(R.id.beginner_day5_rest4_layout);
        beginner_day5_rest5_layout = findViewById(R.id.beginner_day5_rest5_layout);
        beginner_day5_rest6_layout = findViewById(R.id.beginner_day5_rest6_layout);
        beginner_day5_rest7_layout = findViewById(R.id.beginner_day5_rest7_layout);
        beginner_day5_rest8_layout = findViewById(R.id.beginner_day5_rest8_layout);

        day5Rest1StartButton = findViewById(R.id.day5Rest1StartButton);
        day5Rest2StartButton = findViewById(R.id.day5Rest2StartButton);
        day5Rest3StartButton = findViewById(R.id.day5Rest3StartButton);
        day5Rest4StartButton = findViewById(R.id.day5Rest4StartButton);
        day5Rest5StartButton = findViewById(R.id.day5Rest5StartButton);
        day5Rest6StartButton = findViewById(R.id.day5Rest6StartButton);
        day5Rest7StartButton = findViewById(R.id.day5Rest7StartButton);
        day5Rest8StartButton = findViewById(R.id.day5Rest8StartButton);

        day5Rest1FinishButton = findViewById(R.id.day5Rest1FinishButton);
        day5Rest2FinishButton = findViewById(R.id.day5Rest2FinishButton);
        day5Rest3FinishButton = findViewById(R.id.day5Rest3FinishButton);
        day5Rest4FinishButton = findViewById(R.id.day5Rest4FinishButton);
        day5Rest5FinishButton = findViewById(R.id.day5Rest5FinishButton);
        day5Rest6FinishButton = findViewById(R.id.day5Rest6FinishButton);
        day5Rest7FinishButton = findViewById(R.id.day5Rest7FinishButton);
        day5Rest8FinishButton = findViewById(R.id.day5Rest8FinishButton);

        beginner_day5_ex1_photo = findViewById(R.id.beginner_day5_ex1_photo);
        beginner_day5_ex2_photo = findViewById(R.id.beginner_day5_ex2_photo);
        beginner_day5_ex3_photo = findViewById(R.id.beginner_day5_ex3_photo);
        beginner_day5_ex4_photo = findViewById(R.id.beginner_day5_ex4_photo);
        beginner_day5_ex5_photo = findViewById(R.id.beginner_day5_ex5_photo);
        beginner_day5_ex6_photo = findViewById(R.id.beginner_day5_ex6_photo);
        beginner_day5_ex7_photo = findViewById(R.id.beginner_day5_ex7_photo);
        beginner_day5_ex8_photo = findViewById(R.id.beginner_day5_ex8_photo);
        beginner_day5_ex9_photo = findViewById(R.id.beginner_day5_ex9_photo);

        timer_beginner_day5_ex4 = findViewById(R.id.timer_beginner_day5_ex4);
        timer_beginner_day5_ex5 = findViewById(R.id.timer_beginner_day5_ex5);
        timer_beginner_day5_ex9 = findViewById(R.id.timer_beginner_day5_ex9);

        timer_beginner_day5_rest1 = findViewById(R.id.timer_beginner_day5_rest1);
        timer_beginner_day5_rest2 = findViewById(R.id.timer_beginner_day5_rest2);
        timer_beginner_day5_rest3 = findViewById(R.id.timer_beginner_day5_rest3);
        timer_beginner_day5_rest4 = findViewById(R.id.timer_beginner_day5_rest4);
        timer_beginner_day5_rest5 = findViewById(R.id.timer_beginner_day5_rest5);
        timer_beginner_day5_rest6 = findViewById(R.id.timer_beginner_day5_rest6);
        timer_beginner_day5_rest7 = findViewById(R.id.timer_beginner_day5_rest7);
        timer_beginner_day5_rest8 = findViewById(R.id.timer_beginner_day5_rest8);

        Glide.with(this).load(R.drawable.spider_man_mountain_climbers_exercise).into(beginner_day5_ex1_photo);
        Glide.with(this).load(R.drawable.donkey_kicks_exercise).into(beginner_day5_ex2_photo);
        Glide.with(this).load(R.drawable.wide_grip_push_ups_exercise).into(beginner_day5_ex3_photo);
        Glide.with(this).load(R.drawable.plank_jacks_exercise).into(beginner_day5_ex4_photo);
        Glide.with(this).load(R.drawable.lateral_plank_walks_exercise).into(beginner_day5_ex5_photo);
        Glide.with(this).load(R.drawable.push_ups).into(beginner_day5_ex6_photo);
        Glide.with(this).load(R.drawable.plank_ups).into(beginner_day5_ex7_photo);
        Glide.with(this).load(R.drawable.side_leg_kickbacks).into(beginner_day5_ex8_photo);
        Glide.with(this).load(R.drawable.plank_taps).into(beginner_day5_ex9_photo);

        day5BackButton.setOnClickListener(this);

        day5Ex1StartButton.setOnClickListener(this);
        day5Ex2StartButton.setOnClickListener(this);
        day5Ex3StartButton.setOnClickListener(this);
        day5Ex4StartButton.setOnClickListener(this);
        day5Ex5StartButton.setOnClickListener(this);
        day5Ex6StartButton.setOnClickListener(this);
        day5Ex7StartButton.setOnClickListener(this);
        day5Ex8StartButton.setOnClickListener(this);
        day5Ex9StartButton.setOnClickListener(this);

        day5Ex1NextButton.setOnClickListener(this);
        day5Ex2NextButton.setOnClickListener(this);
        day5Ex3NextButton.setOnClickListener(this);
        day5Ex4NextButton.setOnClickListener(this);
        day5Ex5NextButton.setOnClickListener(this);
        day5Ex6NextButton.setOnClickListener(this);
        day5Ex7NextButton.setOnClickListener(this);
        day5Ex8NextButton.setOnClickListener(this);
        day5Ex9NextButton.setOnClickListener(this);

        aboutDay5Ex1BeginnerButton.setOnClickListener(this);
        aboutDay5Ex2BeginnerButton.setOnClickListener(this);
        aboutDay5Ex3BeginnerButton.setOnClickListener(this);
        aboutDay5Ex4BeginnerButton.setOnClickListener(this);
        aboutDay5Ex5BeginnerButton.setOnClickListener(this);
        aboutDay5Ex6BeginnerButton.setOnClickListener(this);
        aboutDay5Ex7BeginnerButton.setOnClickListener(this);
        aboutDay5Ex8BeginnerButton.setOnClickListener(this);
        aboutDay5Ex9BeginnerButton.setOnClickListener(this);

        day5Rest1StartButton.setOnClickListener(this);
        day5Rest2StartButton.setOnClickListener(this);
        day5Rest3StartButton.setOnClickListener(this);
        day5Rest4StartButton.setOnClickListener(this);
        day5Rest5StartButton.setOnClickListener(this);
        day5Rest6StartButton.setOnClickListener(this);
        day5Rest7StartButton.setOnClickListener(this);
        day5Rest8StartButton.setOnClickListener(this);

        day5Rest1FinishButton.setOnClickListener(this);
        day5Rest2FinishButton.setOnClickListener(this);
        day5Rest3FinishButton.setOnClickListener(this);
        day5Rest4FinishButton.setOnClickListener(this);
        day5Rest5FinishButton.setOnClickListener(this);
        day5Rest6FinishButton.setOnClickListener(this);
        day5Rest7FinishButton.setOnClickListener(this);
        day5Rest8FinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day5BeginnerActivity.this, BeginnerWorkoutActivity.class);
                        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(toStayHealthy);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.day5BackButton:
                onBackPressed();
                break;

            case R.id.day5Ex1StartButton:
                beginner_day5_ex1_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex1StartButton.setVisibility(View.GONE);
                day5Ex1NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex1NextButton:
                beginner_day5_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest1StartButton:
                beginner_day5_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest1StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest1.setText("00:00");
                        day5Rest1FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest1FinishButton:
                beginner_day5_rest1_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex2StartButton:
                beginner_day5_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex2StartButton.setVisibility(View.GONE);
                day5Ex2NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex2NextButton:
                beginner_day5_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest2StartButton:
                beginner_day5_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest2StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest2.setText("00:00");
                        day5Rest2FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest2FinishButton:
                beginner_day5_rest2_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex3StartButton:
                beginner_day5_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex3StartButton.setVisibility(View.GONE);
                day5Ex3NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex3NextButton:
                beginner_day5_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest3StartButton:
                beginner_day5_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest3StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest3.setText("00:00");
                        day5Rest3FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest3FinishButton:
                beginner_day5_rest3_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex4StartButton:
                beginner_day5_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex4StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_ex4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_ex4.setText("00:00");
                        day5Ex4NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex4NextButton:
                beginner_day5_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest4StartButton:
                beginner_day5_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest4StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest4.setText("00:00");
                        day5Rest4FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest4FinishButton:
                beginner_day5_rest4_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex5StartButton:
                beginner_day5_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex5StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_ex5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_ex5.setText("00:00");
                        day5Ex5NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex5NextButton:
                beginner_day5_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest5StartButton:
                beginner_day5_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest5StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest5.setText("00:00");
                        day5Rest5FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest5FinishButton:
                beginner_day5_rest5_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex6StartButton:
                beginner_day5_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex6StartButton.setVisibility(View.GONE);
                day5Ex6NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex6NextButton:
                beginner_day5_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest6StartButton:
                beginner_day5_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest6StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest6.setText("00:00");
                        day5Rest6FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest6FinishButton:
                beginner_day5_rest6_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex7StartButton:
                beginner_day5_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex7StartButton.setVisibility(View.GONE);
                day5Ex7NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex7NextButton:
                beginner_day5_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest7StartButton:
                beginner_day5_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest7StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest7.setText("00:00");
                        day5Rest7FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest7FinishButton:
                beginner_day5_rest7_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex8StartButton:
                beginner_day5_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex8StartButton.setVisibility(View.GONE);
                day5Ex8NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex8NextButton:
                beginner_day5_rest8_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest8StartButton:
                beginner_day5_rest8_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest8StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_rest8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_rest8.setText("00:00");
                        day5Rest8FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest8FinishButton:
                beginner_day5_rest8_layout.setVisibility(View.GONE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                beginner_day5_ex9_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex9StartButton:
                beginner_day5_ex9_layout.setVisibility(View.VISIBLE);
                beginner_day5_ex1_layout.setVisibility(View.GONE);
                beginner_day5_ex2_layout.setVisibility(View.GONE);
                beginner_day5_ex3_layout.setVisibility(View.GONE);
                beginner_day5_ex4_layout.setVisibility(View.GONE);
                beginner_day5_ex5_layout.setVisibility(View.GONE);
                beginner_day5_ex6_layout.setVisibility(View.GONE);
                beginner_day5_ex7_layout.setVisibility(View.GONE);
                beginner_day5_ex8_layout.setVisibility(View.GONE);
                day5Ex9StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day5_ex9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day5_ex9.setText("00:00");
                        day5Ex9NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex9NextButton:

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

                                                        if (typeKey.equalsIgnoreCase("Beginner")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5BeginnerActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                        if (typeKey.equalsIgnoreCase("Beginner")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5BeginnerActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                        if (typeKey.equalsIgnoreCase("Beginner")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5BeginnerActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

            case R.id.aboutDay5Ex1BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Spider-man Mountain Climbers")
                        .setMessage("•\tStart in a high plank.\n" +
                                "•\tDrive your right knee out and up toward your right tricep. As you do, turn your head to watch your knee meet your arm.\n" +
                                "•\tAlternate sides as fast as you can while still maintaining a sturdy plank and keeping your torso in place.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex2BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Donkey Kicks")
                        .setMessage("•\tStart on all fours.\n" +
                                "•\tPull your right knee toward your chest, keeping your foot flexed.\n" +
                                "•\tThen, kick your right leg up behind you and toward the sky, then back down, keeping your knee bent and foot flexed.\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex3BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Wide-grip Push-ups")
                        .setMessage("•\tStart in a high plank position with your hands flat on the floor a little bit wider than shoulder-width apart, wrists under shoulders.\n" +
                                "•\tKeeping your body in one long line, bend your arms and lower yourself as close to the floor as you can.\n" +
                                "•\tPush back up to start.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex4BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Plank Jacks")
                        .setMessage("•\tStart in high plank.\n" +
                                "•\tKeeping your core engaged, jump your feet out and in (like jumping jacks).\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex5BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Lateral Plank Walks")
                        .setMessage("•\tStart in a high plank with your shoulders above your wrists and abs tight.\n" +
                                "•\tStep your right foot and right hand to the right, immediately following with your left foot and left hand. Take a few \"steps\" in one direction, then walk in the opposite direction.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex6BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Push-ups")
                        .setMessage("•\tStart in a high plank position with your hands flat on the floor about shoulder-width apart, wrists under shoulders.\n" +
                                "•\tKeeping your body in one long line, bend your arms and lower yourself as close to the floor as you can. Your elbows should be at about a 45-degree angle to your torso.\n" +
                                "•\tPush back up to start.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex7BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Plank-ups")
                        .setMessage("•\tStart in a high plank. Bend one arm to bring the elbow and forearm to the floor.\n" +
                                "•\tBring the other arm down so you are in a forearm plank.\n" +
                                "•\tPush back up to the start position, placing each hand where your elbows were.\n" +
                                "•\tRepeat this pattern, alternating which side you lower first with each rep.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex8BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Single-leg Kickbacks")
                        .setMessage("•\tStart on all fours with your knees under your hips and hands under your shoulders.\n" +
                                "•\tLift your left leg and flex your foot as you kick it back behind you and straighten your leg.\n" +
                                "•\tReturn to start.\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay5Ex9BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Plank taps")
                        .setMessage("•\tStart in a high plank with your feet hip-width apart.\n" +
                                "•\tTap each hand to the opposite shoulder while engaging your core to keep the hips as still as possible.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

        }

    }
}