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

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Day6BeginnerActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day6BackButton;
    AppCompatButton day6Ex1StartButton, day6Ex2StartButton, day6Ex3StartButton, day6Ex4StartButton, day6Ex5StartButton, day6Ex6StartButton, day6Ex7StartButton, day6Ex8StartButton;
    AppCompatButton day6Ex1NextButton, day6Ex2NextButton, day6Ex3NextButton, day6Ex4NextButton, day6Ex5NextButton, day6Ex6NextButton, day6Ex7NextButton, day6Ex8NextButton;
    AppCompatImageView aboutDay6Ex1BeginnerButton, aboutDay6Ex6BeginnerButton, aboutDay6Ex3BeginnerButton, aboutDay6Ex4BeginnerButton;
    AppCompatImageView aboutDay6Ex5BeginnerButton, aboutDay6Ex2BeginnerButton, aboutDay6Ex7BeginnerButton, aboutDay6Ex8BeginnerButton;
    AppCompatImageView beginner_day6_ex1_photo, beginner_day6_ex2_photo, beginner_day6_ex3_photo, beginner_day6_ex4_photo;
    AppCompatImageView beginner_day6_ex5_photo, beginner_day6_ex6_photo, beginner_day6_ex7_photo, beginner_day6_ex8_photo;
    FrameLayout beginner_day6_ex1_layout, beginner_day6_ex2_layout, beginner_day6_ex3_layout, beginner_day6_ex4_layout;
    FrameLayout beginner_day6_ex5_layout, beginner_day6_ex6_layout, beginner_day6_ex7_layout, beginner_day6_ex8_layout;
    FrameLayout beginner_day6_rest1_layout, beginner_day6_rest2_layout, beginner_day6_rest3_layout;
    FrameLayout beginner_day6_rest4_layout, beginner_day6_rest5_layout, beginner_day6_rest6_layout, beginner_day6_rest7_layout;
    AppCompatButton day6Rest1StartButton, day6Rest2StartButton, day6Rest3StartButton;
    AppCompatButton day6Rest4StartButton, day6Rest5StartButton, day6Rest6StartButton, day6Rest7StartButton;
    AppCompatButton day6Rest1FinishButton, day6Rest2FinishButton, day6Rest3FinishButton;
    AppCompatButton day6Rest4FinishButton, day6Rest5FinishButton, day6Rest6FinishButton, day6Rest7FinishButton;
    AppCompatTextView timer_beginner_day6_ex3, timer_beginner_day6_ex7;
    AppCompatTextView timer_beginner_day6_rest1, timer_beginner_day6_rest2, timer_beginner_day6_rest3, timer_beginner_day6_rest4;
    AppCompatTextView timer_beginner_day6_rest5, timer_beginner_day6_rest6, timer_beginner_day6_rest7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_beginner);

        day6BackButton = findViewById(R.id.day6BackButton);

        day6Ex1StartButton = findViewById(R.id.day6Ex1StartButton);
        day6Ex2StartButton = findViewById(R.id.day6Ex2StartButton);
        day6Ex3StartButton = findViewById(R.id.day6Ex3StartButton);
        day6Ex4StartButton = findViewById(R.id.day6Ex4StartButton);
        day6Ex5StartButton = findViewById(R.id.day6Ex5StartButton);
        day6Ex6StartButton = findViewById(R.id.day6Ex6StartButton);
        day6Ex7StartButton = findViewById(R.id.day6Ex7StartButton);
        day6Ex8StartButton = findViewById(R.id.day6Ex8StartButton);

        day6Ex1NextButton = findViewById(R.id.day6Ex1NextButton);
        day6Ex2NextButton = findViewById(R.id.day6Ex2NextButton);
        day6Ex3NextButton = findViewById(R.id.day6Ex3NextButton);
        day6Ex4NextButton = findViewById(R.id.day6Ex4NextButton);
        day6Ex5NextButton = findViewById(R.id.day6Ex5NextButton);
        day6Ex6NextButton = findViewById(R.id.day6Ex6NextButton);
        day6Ex7NextButton = findViewById(R.id.day6Ex7NextButton);
        day6Ex8NextButton = findViewById(R.id.day6Ex8NextButton);

        aboutDay6Ex1BeginnerButton = findViewById(R.id.aboutDay6Ex1BeginnerButton);
        aboutDay6Ex2BeginnerButton = findViewById(R.id.aboutDay6Ex2BeginnerButton);
        aboutDay6Ex3BeginnerButton = findViewById(R.id.aboutDay6Ex3BeginnerButton);
        aboutDay6Ex4BeginnerButton = findViewById(R.id.aboutDay6Ex4BeginnerButton);
        aboutDay6Ex5BeginnerButton = findViewById(R.id.aboutDay6Ex5BeginnerButton);
        aboutDay6Ex6BeginnerButton = findViewById(R.id.aboutDay6Ex6BeginnerButton);
        aboutDay6Ex7BeginnerButton = findViewById(R.id.aboutDay6Ex7BeginnerButton);
        aboutDay6Ex8BeginnerButton = findViewById(R.id.aboutDay6Ex8BeginnerButton);

        beginner_day6_ex1_layout = findViewById(R.id.beginner_day6_ex1_layout);
        beginner_day6_ex2_layout = findViewById(R.id.beginner_day6_ex2_layout);
        beginner_day6_ex3_layout = findViewById(R.id.beginner_day6_ex3_layout);
        beginner_day6_ex4_layout = findViewById(R.id.beginner_day6_ex4_layout);
        beginner_day6_ex5_layout = findViewById(R.id.beginner_day6_ex5_layout);
        beginner_day6_ex6_layout = findViewById(R.id.beginner_day6_ex6_layout);
        beginner_day6_ex7_layout = findViewById(R.id.beginner_day6_ex7_layout);
        beginner_day6_ex8_layout = findViewById(R.id.beginner_day6_ex8_layout);

        beginner_day6_ex1_photo = findViewById(R.id.beginner_day6_ex1_photo);
        beginner_day6_ex2_photo = findViewById(R.id.beginner_day6_ex2_photo);
        beginner_day6_ex3_photo = findViewById(R.id.beginner_day6_ex3_photo);
        beginner_day6_ex4_photo = findViewById(R.id.beginner_day6_ex4_photo);
        beginner_day6_ex5_photo = findViewById(R.id.beginner_day6_ex5_photo);
        beginner_day6_ex6_photo = findViewById(R.id.beginner_day6_ex6_photo);
        beginner_day6_ex7_photo = findViewById(R.id.beginner_day6_ex7_photo);
        beginner_day6_ex8_photo = findViewById(R.id.beginner_day6_ex8_photo);

        beginner_day6_rest1_layout = findViewById(R.id.beginner_day6_rest1_layout);
        beginner_day6_rest2_layout = findViewById(R.id.beginner_day6_rest2_layout);
        beginner_day6_rest3_layout = findViewById(R.id.beginner_day6_rest3_layout);
        beginner_day6_rest4_layout = findViewById(R.id.beginner_day6_rest4_layout);
        beginner_day6_rest5_layout = findViewById(R.id.beginner_day6_rest5_layout);
        beginner_day6_rest6_layout = findViewById(R.id.beginner_day6_rest6_layout);
        beginner_day6_rest7_layout = findViewById(R.id.beginner_day6_rest7_layout);

        day6Rest1StartButton = findViewById(R.id.day6Rest1StartButton);
        day6Rest2StartButton = findViewById(R.id.day6Rest2StartButton);
        day6Rest3StartButton = findViewById(R.id.day6Rest3StartButton);
        day6Rest4StartButton = findViewById(R.id.day6Rest4StartButton);
        day6Rest5StartButton = findViewById(R.id.day6Rest5StartButton);
        day6Rest6StartButton = findViewById(R.id.day6Rest6StartButton);
        day6Rest7StartButton = findViewById(R.id.day6Rest7StartButton);

        day6Rest1FinishButton = findViewById(R.id.day6Rest1FinishButton);
        day6Rest2FinishButton = findViewById(R.id.day6Rest2FinishButton);
        day6Rest3FinishButton = findViewById(R.id.day6Rest3FinishButton);
        day6Rest4FinishButton = findViewById(R.id.day6Rest4FinishButton);
        day6Rest5FinishButton = findViewById(R.id.day6Rest5FinishButton);
        day6Rest6FinishButton = findViewById(R.id.day6Rest6FinishButton);
        day6Rest7FinishButton = findViewById(R.id.day6Rest7FinishButton);

        timer_beginner_day6_ex3 = findViewById(R.id.timer_beginner_day6_ex3);
        timer_beginner_day6_ex7 = findViewById(R.id.timer_beginner_day6_ex7);

        timer_beginner_day6_rest1 = findViewById(R.id.timer_beginner_day6_rest1);
        timer_beginner_day6_rest2 = findViewById(R.id.timer_beginner_day6_rest2);
        timer_beginner_day6_rest3 = findViewById(R.id.timer_beginner_day6_rest3);
        timer_beginner_day6_rest4 = findViewById(R.id.timer_beginner_day6_rest4);
        timer_beginner_day6_rest5 = findViewById(R.id.timer_beginner_day6_rest5);
        timer_beginner_day6_rest6 = findViewById(R.id.timer_beginner_day6_rest6);
        timer_beginner_day6_rest7 = findViewById(R.id.timer_beginner_day6_rest7);

        Glide.with(this).load(R.drawable.reverse_lunges_exercise).into(beginner_day6_ex1_photo);
        Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex2_photo);
        Glide.with(this).load(R.drawable.high_knees_exercise).into(beginner_day6_ex3_photo);
        Glide.with(this).load(R.drawable.side_lunges_exercise).into(beginner_day6_ex4_photo);
        Glide.with(this).load(R.drawable.side_step_squats_exercise).into(beginner_day6_ex5_photo);
        Glide.with(this).load(R.drawable.forward_to_reverse_lunges_exercise).into(beginner_day6_ex6_photo);
        Glide.with(this).load(R.drawable.jump_squats).into(beginner_day6_ex7_photo);
        Glide.with(this).load(R.drawable.jumping_lunges).into(beginner_day6_ex8_photo);

        day6BackButton.setOnClickListener(this);

        day6Ex1StartButton.setOnClickListener(this);
        day6Ex2StartButton.setOnClickListener(this);
        day6Ex3StartButton.setOnClickListener(this);
        day6Ex4StartButton.setOnClickListener(this);
        day6Ex5StartButton.setOnClickListener(this);
        day6Ex6StartButton.setOnClickListener(this);
        day6Ex7StartButton.setOnClickListener(this);
        day6Ex8StartButton.setOnClickListener(this);

        day6Ex1NextButton.setOnClickListener(this);
        day6Ex2NextButton.setOnClickListener(this);
        day6Ex3NextButton.setOnClickListener(this);
        day6Ex4NextButton.setOnClickListener(this);
        day6Ex5NextButton.setOnClickListener(this);
        day6Ex6NextButton.setOnClickListener(this);
        day6Ex7NextButton.setOnClickListener(this);
        day6Ex8NextButton.setOnClickListener(this);

        aboutDay6Ex1BeginnerButton.setOnClickListener(this);
        aboutDay6Ex2BeginnerButton.setOnClickListener(this);
        aboutDay6Ex3BeginnerButton.setOnClickListener(this);
        aboutDay6Ex4BeginnerButton.setOnClickListener(this);
        aboutDay6Ex5BeginnerButton.setOnClickListener(this);
        aboutDay6Ex6BeginnerButton.setOnClickListener(this);
        aboutDay6Ex7BeginnerButton.setOnClickListener(this);
        aboutDay6Ex8BeginnerButton.setOnClickListener(this);

        day6Rest1StartButton.setOnClickListener(this);
        day6Rest2StartButton.setOnClickListener(this);
        day6Rest3StartButton.setOnClickListener(this);
        day6Rest4StartButton.setOnClickListener(this);
        day6Rest5StartButton.setOnClickListener(this);
        day6Rest6StartButton.setOnClickListener(this);
        day6Rest7StartButton.setOnClickListener(this);

        day6Rest1FinishButton.setOnClickListener(this);
        day6Rest2FinishButton.setOnClickListener(this);
        day6Rest3FinishButton.setOnClickListener(this);
        day6Rest4FinishButton.setOnClickListener(this);
        day6Rest5FinishButton.setOnClickListener(this);
        day6Rest6FinishButton.setOnClickListener(this);
        day6Rest7FinishButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day6BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

            case R.id.day6BackButton:
                onBackPressed();
                break;

            case R.id.day6Ex1StartButton:
                beginner_day6_ex1_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex1StartButton.setVisibility(View.GONE);
                day6Ex1NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex1NextButton:
                beginner_day6_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest1StartButton:
                beginner_day6_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest1StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest1.setText("00:00");
                        day6Rest1FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest1FinishButton:
                beginner_day6_rest1_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);

                break;

            case R.id.day6Ex2StartButton:
                beginner_day6_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex2StartButton.setVisibility(View.GONE);
                day6Ex2NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex2NextButton:
                beginner_day6_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest2StartButton:
                beginner_day6_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest2StartButton.setVisibility(View.GONE);

                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest2.setText("00:00");
                        day6Rest2FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest2FinishButton:
                beginner_day6_rest2_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex3StartButton:
                beginner_day6_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex3StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_ex3.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_ex3.setText("00:00");
                        day6Ex3NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Ex3NextButton:
                beginner_day6_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest3StartButton:
                beginner_day6_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest3StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest3.setText("00:00");
                        day6Rest3FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest3FinishButton:
                beginner_day6_rest3_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex4StartButton:
                beginner_day6_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex4StartButton.setVisibility(View.GONE);
                day6Ex4NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex4NextButton:
                beginner_day6_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest4StartButton:
                beginner_day6_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest4StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest4.setText("00:00");
                        day6Rest4FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest4FinishButton:
                beginner_day6_rest4_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex5StartButton:
                beginner_day6_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex5StartButton.setVisibility(View.GONE);
                day6Ex5NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex5NextButton:
                beginner_day6_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest5StartButton:
                beginner_day6_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest5StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest5.setText("00:00");
                        day6Rest5FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest5FinishButton:
                beginner_day6_rest5_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex6StartButton:
                beginner_day6_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex6StartButton.setVisibility(View.GONE);
                day6Ex6NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex6NextButton:
                beginner_day6_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest6StartButton:
                beginner_day6_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest6StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest6.setText("00:00");
                        day6Rest6FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest6FinishButton:
                beginner_day6_rest6_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex7StartButton:
                beginner_day6_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex7StartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_ex7.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_beginner_day6_ex7.setText("00:00");
                        day6Ex7NextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Ex7NextButton:
                beginner_day6_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest7StartButton:
                beginner_day6_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest7StartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_beginner_day6_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00:00 there
                    public void onFinish() {
                        timer_beginner_day6_rest7.setText("00:00");
                        day6Rest7FinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest7FinishButton:
                beginner_day6_rest7_layout.setVisibility(View.GONE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                beginner_day6_ex8_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex8StartButton:
                beginner_day6_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day6_ex1_layout.setVisibility(View.GONE);
                beginner_day6_ex2_layout.setVisibility(View.GONE);
                beginner_day6_ex3_layout.setVisibility(View.GONE);
                beginner_day6_ex4_layout.setVisibility(View.GONE);
                beginner_day6_ex5_layout.setVisibility(View.GONE);
                beginner_day6_ex6_layout.setVisibility(View.GONE);
                beginner_day6_ex7_layout.setVisibility(View.GONE);
                day6Ex8StartButton.setVisibility(View.GONE);
                day6Ex8NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex8NextButton:

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

                                                    for (DataSnapshot daySnap : workoutSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            Toast.makeText(Day6BeginnerActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                    for (DataSnapshot daySnap : workoutSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            Toast.makeText(Day6BeginnerActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 6")) {

                                                                    Toast.makeText(Day6BeginnerActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Beginner").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

            case R.id.aboutDay6Ex1BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Reverse Lunges")
                        .setMessage("•\tStart standing with your feet about shoulder-width apart.\n" +
                                "•\tStep backwards with your left foot, landing on the ball of your foot and bending your knees to create two 90-degree angles.\n" +
                                "•\tPush through your right heel to return to standing.\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex2BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Squats")
                        .setMessage("•\tStand with your feet about shoulder-width apart and slightly turned out with your weight in your heels.\n" +
                                "•\tHinge your hips to sit your butt back and bend your knees until your thighs are parallel to the ground.\n" +
                                "•\tDrive through your heels to stand back up straight. Squeeze your butt and keep your core tight as you stand.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex3BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("High Knees")
                        .setMessage("•\tStand with your feet hip-width apart.\n" +
                                "•\tRun in place, bringing your knees up toward your chest as high as possible while pumping your arms.\n" +
                                "•\tKeep your chest lifted, core engaged, and land lightly on the balls of your feet.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex4BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Side Lunges")
                        .setMessage("•\tStand with your feet hip-width apart.\n" +
                                "•\tTake a big step out to your right. Bend your knee and push your butt back to do a side lunge. Keep your chest lifted and core tight.\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex5BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Side Step Squats")
                        .setMessage("•\tStand tall with your feet together and hands on your hips.\n" +
                                "•\tStep your right foot to the right, so your feet are just wider than shoulder-width apart.\n" +
                                "•\tDrop your butt back and bend your knees to lower into a squat.\n" +
                                "•\tStraighten your knees and bring your foot back to the starting position.\n" +
                                "•\tRepeat on the other side.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex6BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Forward to Reverse Lunges")
                        .setMessage("•\tStand with your feet hip-width apart.\n" +
                                "•\tStep forward with your left foot into a forward lunge, with both knees bent so that your knees so that the front thigh is parallel to the floor and the back knee is about two inches from the floor.\n" +
                                "•\tPush off your front foot, hover your foot as you stand straight up, and immediately step back into a reverse lunge.\n" +
                                "•\tDrive through your front foot to stand back up.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex7BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Jump Squats")
                        .setMessage("•\tStand with your feet slightly wider than hip-distance apart.\n" +
                                "•\tSit your butt back and bend your knees to drop into a squat, keeping your chest upright.\n" +
                                "•\tJump up into the air as high as you can and straighten out your legs.\n" +
                                "•\tLand back on the floor with soft knees.\n")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;

            case R.id.aboutDay6Ex8BeginnerButton:
                new AlertDialog.Builder(this)
                        .setTitle("Jumping Lunges")
                        .setMessage("•\tStart in a lunge with your left leg forward, hands at your sides. Bend both knees to 90 degrees, keeping your abs tight and back straight.\n" +
                                "•\tSwing arms to propel your body up, straightening your legs. Land back in a lunge and continue jumping.\n" +
                                "•\tRepeat on the other side.\n")
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