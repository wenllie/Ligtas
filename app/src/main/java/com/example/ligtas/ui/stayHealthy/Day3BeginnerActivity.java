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

public class Day3BeginnerActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day3BackButton;
    AppCompatButton day3Ex1StartButton, day3Ex2StartButton, day3Ex3StartButton, day3Ex4StartButton, day3Ex5StartButton, day3Ex6StartButton, day3Ex7StartButton, day3Ex8StartButton, day3Ex9StartButton;
    AppCompatButton day3Ex1NextButton, day3Ex2NextButton, day3Ex3NextButton, day3Ex4NextButton, day3Ex5NextButton, day3Ex6NextButton, day3Ex7NextButton, day3Ex8NextButton, day3Ex9NextButton;
    AppCompatImageView aboutDay3Ex1BeginnerButton, aboutDay3Ex2BeginnerButton, aboutDay3Ex3BeginnerButton, aboutDay3Ex4BeginnerButton, aboutDay3Ex5BeginnerButton;
    AppCompatImageView aboutDay3Ex6BeginnerButton, aboutDay3Ex7BeginnerButton, aboutDay3Ex8BeginnerButton, aboutDay3Ex9BeginnerButton;
    AppCompatImageView beginner_day3_ex1_photo, beginner_day3_ex2_photo, beginner_day3_ex3_photo, beginner_day3_ex4_photo, beginner_day3_ex5_photo;
    AppCompatImageView beginner_day3_ex6_photo, beginner_day3_ex7_photo, beginner_day3_ex8_photo, beginner_day3_ex9_photo;
    FrameLayout beginner_day3_ex1_layout, beginner_day3_ex2_layout, beginner_day3_ex3_layout, beginner_day3_ex4_layout, beginner_day3_ex5_layout;
    FrameLayout beginner_day3_ex6_layout, beginner_day3_ex7_layout, beginner_day3_ex8_layout, beginner_day3_ex9_layout;
    FrameLayout beginner_day3_rest1_layout, beginner_day3_rest2_layout, beginner_day3_rest3_layout, beginner_day3_rest4_layout;
    FrameLayout beginner_day3_rest5_layout, beginner_day3_rest6_layout, beginner_day3_rest7_layout, beginner_day3_rest8_layout;
    AppCompatButton day3Rest1StartButton, day3Rest2StartButton, day3Rest3StartButton, day3Rest4StartButton;
    AppCompatButton day3Rest5StartButton, day3Rest6StartButton, day3Rest7StartButton, day3Rest8StartButton;
    AppCompatButton day3Rest1FinishButton, day3Rest2FinishButton, day3Rest3FinishButton, day3Rest4FinishButton;
    AppCompatButton day3Rest5FinishButton, day3Rest6FinishButton, day3Rest7FinishButton, day3Rest8FinishButton;
    AppCompatTextView timer_beginner_day3_ex3, timer_beginner_day3_ex4, timer_beginner_day3_ex5, timer_beginner_day3_ex8, timer_beginner_day3_ex9;
    AppCompatTextView timer_beginner_day3_rest1, timer_beginner_day3_rest2, timer_beginner_day3_rest3, timer_beginner_day3_rest4;
    AppCompatTextView timer_beginner_day3_rest5, timer_beginner_day3_rest6, timer_beginner_day3_rest7, timer_beginner_day3_rest8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_beginner);

        day3BackButton = findViewById(R.id.day3BackButton);

        aboutDay3Ex1BeginnerButton = findViewById(R.id.aboutDay3Ex1BeginnerButton);
        aboutDay3Ex2BeginnerButton = findViewById(R.id.aboutDay3Ex2BeginnerButton);
        aboutDay3Ex3BeginnerButton = findViewById(R.id.aboutDay3Ex3BeginnerButton);
        aboutDay3Ex4BeginnerButton = findViewById(R.id.aboutDay3Ex4BeginnerButton);
        aboutDay3Ex5BeginnerButton = findViewById(R.id.aboutDay3Ex5BeginnerButton);
        aboutDay3Ex6BeginnerButton = findViewById(R.id.aboutDay3Ex6BeginnerButton);
        aboutDay3Ex7BeginnerButton = findViewById(R.id.aboutDay3Ex7BeginnerButton);
        aboutDay3Ex8BeginnerButton = findViewById(R.id.aboutDay3Ex8BeginnerButton);
        aboutDay3Ex9BeginnerButton = findViewById(R.id.aboutDay3Ex9BeginnerButton);

        day3Ex1StartButton = findViewById(R.id.day3Ex1StartButton);
        day3Ex2StartButton = findViewById(R.id.day3Ex2StartButton);
        day3Ex3StartButton = findViewById(R.id.day3Ex3StartButton);
        day3Ex4StartButton = findViewById(R.id.day3Ex4StartButton);
        day3Ex5StartButton = findViewById(R.id.day3Ex5StartButton);
        day3Ex6StartButton = findViewById(R.id.day3Ex6StartButton);
        day3Ex7StartButton = findViewById(R.id.day3Ex7StartButton);
        day3Ex8StartButton = findViewById(R.id.day3Ex8StartButton);
        day3Ex9StartButton = findViewById(R.id.day3Ex9StartButton);

        day3Ex1NextButton = findViewById(R.id.day3Ex1NextButton);
        day3Ex2NextButton = findViewById(R.id.day3Ex2NextButton);
        day3Ex3NextButton = findViewById(R.id.day3Ex3NextButton);
        day3Ex4NextButton = findViewById(R.id.day3Ex4NextButton);
        day3Ex5NextButton = findViewById(R.id.day3Ex5NextButton);
        day3Ex6NextButton = findViewById(R.id.day3Ex6NextButton);
        day3Ex7NextButton = findViewById(R.id.day3Ex7NextButton);
        day3Ex8NextButton = findViewById(R.id.day3Ex8NextButton);
        day3Ex9NextButton = findViewById(R.id.day3Ex9NextButton);

        beginner_day3_ex1_layout = findViewById(R.id.beginner_day3_ex1_layout);
        beginner_day3_ex2_layout = findViewById(R.id.beginner_day3_ex2_layout);
        beginner_day3_ex3_layout = findViewById(R.id.beginner_day3_ex3_layout);
        beginner_day3_ex4_layout = findViewById(R.id.beginner_day3_ex4_layout);
        beginner_day3_ex5_layout = findViewById(R.id.beginner_day3_ex5_layout);
        beginner_day3_ex6_layout = findViewById(R.id.beginner_day3_ex6_layout);
        beginner_day3_ex7_layout = findViewById(R.id.beginner_day3_ex7_layout);
        beginner_day3_ex8_layout = findViewById(R.id.beginner_day3_ex8_layout);
        beginner_day3_ex9_layout = findViewById(R.id.beginner_day3_ex9_layout);

        beginner_day3_rest1_layout = findViewById(R.id.beginner_day3_rest1_layout);
        beginner_day3_rest2_layout = findViewById(R.id.beginner_day3_rest2_layout);
        beginner_day3_rest3_layout = findViewById(R.id.beginner_day3_rest3_layout);
        beginner_day3_rest4_layout = findViewById(R.id.beginner_day3_rest4_layout);
        beginner_day3_rest5_layout = findViewById(R.id.beginner_day3_rest5_layout);
        beginner_day3_rest6_layout = findViewById(R.id.beginner_day3_rest6_layout);
        beginner_day3_rest7_layout = findViewById(R.id.beginner_day3_rest7_layout);
        beginner_day3_rest8_layout = findViewById(R.id.beginner_day3_rest8_layout);

        day3Rest1StartButton = findViewById(R.id.day3Rest1StartButton);
        day3Rest2StartButton = findViewById(R.id.day3Rest2StartButton);
        day3Rest3StartButton = findViewById(R.id.day3Rest3StartButton);
        day3Rest4StartButton = findViewById(R.id.day3Rest4StartButton);
        day3Rest5StartButton = findViewById(R.id.day3Rest5StartButton);
        day3Rest6StartButton = findViewById(R.id.day3Rest6StartButton);
        day3Rest7StartButton = findViewById(R.id.day3Rest7StartButton);
        day3Rest8StartButton = findViewById(R.id.day3Rest8StartButton);

        day3Rest1FinishButton = findViewById(R.id.day3Rest1FinishButton);
        day3Rest2FinishButton = findViewById(R.id.day3Rest2FinishButton);
        day3Rest3FinishButton = findViewById(R.id.day3Rest3FinishButton);
        day3Rest4FinishButton = findViewById(R.id.day3Rest4FinishButton);
        day3Rest5FinishButton = findViewById(R.id.day3Rest5FinishButton);
        day3Rest6FinishButton = findViewById(R.id.day3Rest6FinishButton);
        day3Rest7FinishButton = findViewById(R.id.day3Rest7FinishButton);
        day3Rest8FinishButton = findViewById(R.id.day3Rest8FinishButton);

        beginner_day3_ex1_photo = findViewById(R.id.beginner_day3_ex1_photo);
        beginner_day3_ex2_photo = findViewById(R.id.beginner_day3_ex2_photo);
        beginner_day3_ex3_photo = findViewById(R.id.beginner_day3_ex3_photo);
        beginner_day3_ex4_photo = findViewById(R.id.beginner_day3_ex4_photo);
        beginner_day3_ex5_photo = findViewById(R.id.beginner_day3_ex5_photo);
        beginner_day3_ex6_photo = findViewById(R.id.beginner_day3_ex6_photo);
        beginner_day3_ex7_photo = findViewById(R.id.beginner_day3_ex7_photo);
        beginner_day3_ex8_photo = findViewById(R.id.beginner_day3_ex8_photo);
        beginner_day3_ex9_photo = findViewById(R.id.beginner_day3_ex9_photo);

        timer_beginner_day3_ex3 = findViewById(R.id.timer_beginner_day3_ex3);
        timer_beginner_day3_ex4 = findViewById(R.id.timer_beginner_day3_ex4);
        timer_beginner_day3_ex5 = findViewById(R.id.timer_beginner_day3_ex5);
        timer_beginner_day3_ex8 = findViewById(R.id.timer_beginner_day3_ex8);
        timer_beginner_day3_ex9 = findViewById(R.id.timer_beginner_day3_ex9);

        timer_beginner_day3_rest1 = findViewById(R.id.timer_beginner_day3_rest1);
        timer_beginner_day3_rest2 = findViewById(R.id.timer_beginner_day3_rest2);
        timer_beginner_day3_rest3 = findViewById(R.id.timer_beginner_day3_rest3);
        timer_beginner_day3_rest4 = findViewById(R.id.timer_beginner_day3_rest4);
        timer_beginner_day3_rest5 = findViewById(R.id.timer_beginner_day3_rest5);
        timer_beginner_day3_rest6 = findViewById(R.id.timer_beginner_day3_rest6);
        timer_beginner_day3_rest7 = findViewById(R.id.timer_beginner_day3_rest7);
        timer_beginner_day3_rest8 = findViewById(R.id.timer_beginner_day3_rest8);

        Glide.with(this).load(R.drawable.lateral_leg_raises_exercise).into(beginner_day3_ex1_photo);
        Glide.with(this).load(R.drawable.marching_glute_bridge_exercise).into(beginner_day3_ex2_photo);
        Glide.with(this).load(R.drawable.hip_bridges).into(beginner_day3_ex3_photo);
        Glide.with(this).load(R.drawable.bicycle_crunches).into(beginner_day3_ex4_photo);
        Glide.with(this).load(R.drawable.alternating_knee_to_chests).into(beginner_day3_ex5_photo);
        Glide.with(this).load(R.drawable.side_plank_dips).into(beginner_day3_ex6_photo);
        Glide.with(this).load(R.drawable.v_ups).into(beginner_day3_ex7_photo);
        Glide.with(this).load(R.drawable.dead_bugs).into(beginner_day3_ex8_photo);
        Glide.with(this).load(R.drawable.sit_ups_to_twists).into(beginner_day3_ex9_photo);

        day3BackButton.setOnClickListener(this);

        day3Ex1StartButton.setOnClickListener(this);
        day3Ex2StartButton.setOnClickListener(this);
        day3Ex3StartButton.setOnClickListener(this);
        day3Ex4StartButton.setOnClickListener(this);
        day3Ex5StartButton.setOnClickListener(this);
        day3Ex6StartButton.setOnClickListener(this);
        day3Ex7StartButton.setOnClickListener(this);
        day3Ex8StartButton.setOnClickListener(this);
        day3Ex9StartButton.setOnClickListener(this);

        day3Ex1NextButton.setOnClickListener(this);
        day3Ex2NextButton.setOnClickListener(this);
        day3Ex3NextButton.setOnClickListener(this);
        day3Ex4NextButton.setOnClickListener(this);
        day3Ex5NextButton.setOnClickListener(this);
        day3Ex6NextButton.setOnClickListener(this);
        day3Ex7NextButton.setOnClickListener(this);
        day3Ex8NextButton.setOnClickListener(this);
        day3Ex9NextButton.setOnClickListener(this);

        aboutDay3Ex1BeginnerButton.setOnClickListener(this);
        aboutDay3Ex2BeginnerButton.setOnClickListener(this);
        aboutDay3Ex3BeginnerButton.setOnClickListener(this);
        aboutDay3Ex4BeginnerButton.setOnClickListener(this);
        aboutDay3Ex5BeginnerButton.setOnClickListener(this);
        aboutDay3Ex6BeginnerButton.setOnClickListener(this);
        aboutDay3Ex7BeginnerButton.setOnClickListener(this);
        aboutDay3Ex8BeginnerButton.setOnClickListener(this);
        aboutDay3Ex9BeginnerButton.setOnClickListener(this);

        day3Rest1StartButton.setOnClickListener(this);
        day3Rest2StartButton.setOnClickListener(this);
        day3Rest3StartButton.setOnClickListener(this);
        day3Rest4StartButton.setOnClickListener(this);
        day3Rest5StartButton.setOnClickListener(this);
        day3Rest6StartButton.setOnClickListener(this);
        day3Rest7StartButton.setOnClickListener(this);
        day3Rest8StartButton.setOnClickListener(this);

        day3Rest1FinishButton.setOnClickListener(this);
        day3Rest2FinishButton.setOnClickListener(this);
        day3Rest3FinishButton.setOnClickListener(this);
        day3Rest4FinishButton.setOnClickListener(this);
        day3Rest5FinishButton.setOnClickListener(this);
        day3Rest6FinishButton.setOnClickListener(this);
        day3Rest7FinishButton.setOnClickListener(this);
        day3Rest8FinishButton.setOnClickListener(this);
        
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day3BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

            case R.id.day3BackButton:
                onBackPressed();
                break;

            case R.id.day3Ex1StartButton:
                beginner_day3_ex1_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex1StartButton.setVisibility(View.GONE);
                day3Ex1NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex1NextButton:
                beginner_day3_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest1StartButton:
                beginner_day3_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest1StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest1.setText("00:00");
                        day3Rest1FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest1FinishButton:
                beginner_day3_rest1_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex2StartButton:
                beginner_day3_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex2StartButton.setVisibility(View.GONE);
                day3Ex2NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex2NextButton:
                beginner_day3_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest2StartButton:
                beginner_day3_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest2StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest2.setText("00:00");
                        day3Rest2FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest2FinishButton:
                beginner_day3_rest2_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex3StartButton:
                beginner_day3_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex3StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_ex3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_ex3.setText("00:00");
                        day3Ex3NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex3NextButton:
                beginner_day3_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest3StartButton:
                beginner_day3_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest3StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest3.setText("00:00");
                        day3Rest3FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest3FinishButton:
                beginner_day3_rest3_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex4StartButton:
                beginner_day3_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex4StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_ex4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_ex4.setText("00:00");
                        day3Ex4NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex4NextButton:
                beginner_day3_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest4StartButton:
                beginner_day3_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest4StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest4.setText("00:00");
                        day3Rest4FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest4FinishButton:
                beginner_day3_rest4_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex5StartButton:
                beginner_day3_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex5StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_ex5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_ex5.setText("00:00");
                        day3Ex5NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex5NextButton:
                beginner_day3_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest5StartButton:
                beginner_day3_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest5StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest5.setText("00:00");
                        day3Rest5FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest5FinishButton:
                beginner_day3_rest5_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex6StartButton:
                beginner_day3_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex6StartButton.setVisibility(View.GONE);
                day3Ex6NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex6NextButton:
                beginner_day3_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest6StartButton:
                beginner_day3_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest6StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest6.setText("00:00");
                        day3Rest6FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest6FinishButton:
                beginner_day3_rest6_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex7StartButton:
                beginner_day3_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex7StartButton.setVisibility(View.GONE);
                day3Ex7NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex7NextButton:
                beginner_day3_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest7StartButton:
                beginner_day3_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest7StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest7.setText("00:00");
                        day3Rest7FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest7FinishButton:
                beginner_day3_rest7_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex8StartButton:
                beginner_day3_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex8StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_ex8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_ex8.setText("00:00");
                        day3Ex8NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex8NextButton:
                beginner_day3_rest8_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest8StartButton:
                beginner_day3_rest8_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest8StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_rest8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_rest8.setText("00:00");
                        day3Rest8FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest8FinishButton:
                beginner_day3_rest8_layout.setVisibility(View.GONE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                beginner_day3_ex9_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex9StartButton:
                beginner_day3_ex9_layout.setVisibility(View.VISIBLE);
                beginner_day3_ex1_layout.setVisibility(View.GONE);
                beginner_day3_ex2_layout.setVisibility(View.GONE);
                beginner_day3_ex3_layout.setVisibility(View.GONE);
                beginner_day3_ex4_layout.setVisibility(View.GONE);
                beginner_day3_ex5_layout.setVisibility(View.GONE);
                beginner_day3_ex6_layout.setVisibility(View.GONE);
                beginner_day3_ex7_layout.setVisibility(View.GONE);
                beginner_day3_ex8_layout.setVisibility(View.GONE);
                day3Ex9StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day3_ex9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day3_ex9.setText("00:00");
                        day3Ex9NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex9NextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3BeginnerActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3BeginnerActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3BeginnerActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

            case R.id.aboutDay3Ex1BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Lateral Leg Raises")
                        .setMessage("•\tLie on your side, legs extended.\n" +
                                "•\tLift your top leg 45 degrees, then lower slowly.\n" +
                                "•\tDo 5 lifts with your toe flexed, 5 with your toe pointed, and 5 with your toe pointed toward the ceiling.\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex2BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Marching Glute Bridge")
                        .setMessage("•\tLie faceup on your mat with your knees bent and feet flat on the floor. Lift your hips off the mat into a bridge.\n" +
                                "•\tKeeping your right knee bent, lift your right foot off the floor. Try to keep your hips still.\n" +
                                "•\tHold for five seconds. Slowly lower your right foot to the ground but keep your hips lifted.\n" +
                                "•\tLift your left foot off the ground to repeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex3BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Hip Bridges")
                        .setMessage("•\tStart lying flat on your back, your knees bent and your heels a few inches away from your butt. Your feet should be about hip-distance apart.\n" +
                                "•\tLift your hips up, then lower them back to the ground.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex4BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Bicycle Crunches")
                        .setMessage("•\tSit on floor with your knees bent, feet lifted, and your hands behind head.\n" +
                                "•\tKeep your chest up and back straight as you lean back to engage your abs.\n" +
                                "•\tTwist to bring your right elbow to your left knee, straightening your right leg.\n" +
                                "•\tAlternate sides with control.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex5BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Alternating Knee-to-chests")
                        .setMessage("•\tLie on your back and extend one leg out a few inches off the ground. Hold the opposite knee into your chest.\n" +
                                "•\tSwitch legs, bringing your nose to the knee that is in toward your chest each time.\n" +
                                "•\tKeep your lower back down, head lifted off the ground, and abs engaged.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex6BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Side Plank Dips")
                        .setMessage("•\tStart in a side plank, with your left foot stacked on top of your right and your body in a straight line.\n" +
                                "•\tDrop your hips toward the floor and raise back to starting position (or a little higher, if you can).\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex7BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("V-Ups")
                        .setMessage("•\tLie faceup with your arms and legs extended and resting on the floor.\n" +
                                "•\tKeep your abs tight and lift your hands and feet to meet over your torso, rolling your core as you sit up.\n" +
                                "•\tLower your arms and legs back to the floor.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex8BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Dead Bugs")
                        .setMessage("•\tLie on your back with your arms at shoulder level raised toward the ceiling. Bring your legs up into tabletop position (knees bent 90 degrees and stacked over your hips).\n" +
                                "•\tSlowly extend your right leg out straight, while simultaneously dropping your left arm overhead. Keep both a few inches from the ground.\n" +
                                "•\tBring your arm and leg back to the starting position.\n" +
                                "•\tRepeat on the other side, extending your left leg and your right arm.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay3Ex9BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Sit-Ups to Twists")
                        .setMessage("•\tLie on your back with your knees bent and feet flat to the floor.\n" +
                                "•\tPlace your hands behind your head, engage your core and do a full sit-up. At the top of the sit-up, bring your right elbow to your left knee and twist your body toward that side.\n" +
                                "•\tLower back down to start.\n" +
                                "•\tRepeat this movement alternating sides each time.\n")
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