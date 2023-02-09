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

public class Day2AdvancedActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day2AdvancedBackButton;
    AppCompatButton day2Ex1AdvancedStartButton, day2Ex2AdvancedStartButton, day2Ex3AdvancedStartButton, day2Ex4AdvancedStartButton;
    AppCompatButton day2Ex5AdvancedStartButton, day2Ex6AdvancedStartButton, day2Ex7AdvancedStartButton, day2Ex8AdvancedStartButton;
    AppCompatButton day2Ex1AdvancedNextButton, day2Ex2AdvancedNextButton, day2Ex3AdvancedNextButton, day2Ex4AdvancedNextButton;
    AppCompatButton day2Ex5AdvancedNextButton, day2Ex6AdvancedNextButton, day2Ex7AdvancedNextButton, day2Ex8AdvancedNextButton;
    AppCompatImageView aboutDay2Ex1AdvancedButton, aboutDay2Ex2AdvancedButton, aboutDay2Ex3AdvancedButton, aboutDay2Ex4AdvancedButton;
    AppCompatImageView aboutDay2Ex5AdvancedButton, aboutDay2Ex6AdvancedButton, aboutDay2Ex7AdvancedButton, aboutDay2Ex8AdvancedButton;
    AppCompatImageView advanced_day2_ex1_photo, advanced_day2_ex2_photo, advanced_day2_ex3_photo, advanced_day2_ex4_photo;
    AppCompatImageView advanced_day2_ex5_photo, advanced_day2_ex6_photo, advanced_day2_ex7_photo, advanced_day2_ex8_photo;
    FrameLayout advanced_day2_ex1_layout, advanced_day2_ex2_layout, advanced_day2_ex3_layout, advanced_day2_ex4_layout;
    FrameLayout advanced_day2_ex5_layout, advanced_day2_ex6_layout, advanced_day2_ex7_layout, advanced_day2_ex8_layout;
    FrameLayout advanced_day2_rest1_layout, advanced_day2_rest2_layout, advanced_day2_rest3_layout;
    FrameLayout advanced_day2_rest4_layout, advanced_day2_rest5_layout, advanced_day2_rest6_layout, advanced_day2_rest7_layout;
    AppCompatButton day2Rest1AdvancedStartButton, day2Rest2AdvancedStartButton, day2Rest3AdvancedStartButton;
    AppCompatButton day2Rest4AdvancedStartButton, day2Rest5AdvancedStartButton, day2Rest6AdvancedStartButton, day2Rest7AdvancedStartButton;
    AppCompatButton day2Rest1AdvancedFinishButton, day2Rest2AdvancedFinishButton, day2Rest3AdvancedFinishButton;
    AppCompatButton day2Rest4AdvancedFinishButton, day2Rest5AdvancedFinishButton, day2Rest6AdvancedFinishButton, day2Rest7AdvancedFinishButton;
    AppCompatTextView timer_advanced_day2_ex3, timer_advanced_day2_ex7;
    AppCompatTextView timer_advanced_day2_rest1, timer_advanced_day2_rest2, timer_advanced_day2_rest3;
    AppCompatTextView timer_advanced_day2_rest4, timer_advanced_day2_rest5, timer_advanced_day2_rest6, timer_advanced_day2_rest7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_advanced);

        day2AdvancedBackButton = findViewById(R.id.day2AdvancedBackButton);

        day2Ex1AdvancedStartButton = findViewById(R.id.day2Ex1AdvancedStartButton);
        day2Ex2AdvancedStartButton = findViewById(R.id.day2Ex2AdvancedStartButton);
        day2Ex3AdvancedStartButton = findViewById(R.id.day2Ex3AdvancedStartButton);
        day2Ex4AdvancedStartButton = findViewById(R.id.day2Ex4AdvancedStartButton);
        day2Ex5AdvancedStartButton = findViewById(R.id.day2Ex5AdvancedStartButton);
        day2Ex6AdvancedStartButton = findViewById(R.id.day2Ex6AdvancedStartButton);
        day2Ex7AdvancedStartButton = findViewById(R.id.day2Ex7AdvancedStartButton);
        day2Ex8AdvancedStartButton = findViewById(R.id.day2Ex8AdvancedStartButton);

        day2Ex1AdvancedNextButton = findViewById(R.id.day2Ex1AdvancedNextButton);
        day2Ex2AdvancedNextButton = findViewById(R.id.day2Ex2AdvancedNextButton);
        day2Ex3AdvancedNextButton = findViewById(R.id.day2Ex3AdvancedNextButton);
        day2Ex4AdvancedNextButton = findViewById(R.id.day2Ex4AdvancedNextButton);
        day2Ex5AdvancedNextButton = findViewById(R.id.day2Ex5AdvancedNextButton);
        day2Ex6AdvancedNextButton = findViewById(R.id.day2Ex6AdvancedNextButton);
        day2Ex7AdvancedNextButton = findViewById(R.id.day2Ex7AdvancedNextButton);
        day2Ex8AdvancedNextButton = findViewById(R.id.day2Ex8AdvancedNextButton);

        aboutDay2Ex1AdvancedButton = findViewById(R.id.aboutDay2Ex1AdvancedButton);
        aboutDay2Ex2AdvancedButton = findViewById(R.id.aboutDay2Ex2AdvancedButton);
        aboutDay2Ex3AdvancedButton = findViewById(R.id.aboutDay2Ex3AdvancedButton);
        aboutDay2Ex4AdvancedButton = findViewById(R.id.aboutDay2Ex4AdvancedButton);
        aboutDay2Ex5AdvancedButton = findViewById(R.id.aboutDay2Ex5AdvancedButton);
        aboutDay2Ex6AdvancedButton = findViewById(R.id.aboutDay2Ex6AdvancedButton);
        aboutDay2Ex7AdvancedButton = findViewById(R.id.aboutDay2Ex7AdvancedButton);
        aboutDay2Ex8AdvancedButton = findViewById(R.id.aboutDay2Ex8AdvancedButton);

        advanced_day2_ex1_layout = findViewById(R.id.advanced_day2_ex1_layout);
        advanced_day2_ex2_layout = findViewById(R.id.advanced_day2_ex2_layout);
        advanced_day2_ex3_layout = findViewById(R.id.advanced_day2_ex3_layout);
        advanced_day2_ex4_layout = findViewById(R.id.advanced_day2_ex4_layout);
        advanced_day2_ex5_layout = findViewById(R.id.advanced_day2_ex5_layout);
        advanced_day2_ex6_layout = findViewById(R.id.advanced_day2_ex6_layout);
        advanced_day2_ex7_layout = findViewById(R.id.advanced_day2_ex7_layout);
        advanced_day2_ex8_layout = findViewById(R.id.advanced_day2_ex8_layout);

        advanced_day2_ex1_photo = findViewById(R.id.advanced_day2_ex1_photo);
        advanced_day2_ex2_photo = findViewById(R.id.advanced_day2_ex2_photo);
        advanced_day2_ex3_photo = findViewById(R.id.advanced_day2_ex3_photo);
        advanced_day2_ex4_photo = findViewById(R.id.advanced_day2_ex4_photo);
        advanced_day2_ex5_photo = findViewById(R.id.advanced_day2_ex5_photo);
        advanced_day2_ex6_photo = findViewById(R.id.advanced_day2_ex6_photo);
        advanced_day2_ex7_photo = findViewById(R.id.advanced_day2_ex7_photo);
        advanced_day2_ex8_photo = findViewById(R.id.advanced_day2_ex8_photo);

        advanced_day2_rest1_layout = findViewById(R.id.advanced_day2_rest1_layout);
        advanced_day2_rest2_layout = findViewById(R.id.advanced_day2_rest2_layout);
        advanced_day2_rest3_layout = findViewById(R.id.advanced_day2_rest3_layout);
        advanced_day2_rest4_layout = findViewById(R.id.advanced_day2_rest4_layout);
        advanced_day2_rest5_layout = findViewById(R.id.advanced_day2_rest5_layout);
        advanced_day2_rest6_layout = findViewById(R.id.advanced_day2_rest6_layout);
        advanced_day2_rest7_layout = findViewById(R.id.advanced_day2_rest7_layout);

        day2Rest1AdvancedStartButton = findViewById(R.id.day2Rest1AdvancedStartButton);
        day2Rest2AdvancedStartButton = findViewById(R.id.day2Rest2AdvancedStartButton);
        day2Rest3AdvancedStartButton = findViewById(R.id.day2Rest3AdvancedStartButton);
        day2Rest4AdvancedStartButton = findViewById(R.id.day2Rest4AdvancedStartButton);
        day2Rest5AdvancedStartButton = findViewById(R.id.day2Rest5AdvancedStartButton);
        day2Rest6AdvancedStartButton = findViewById(R.id.day2Rest6AdvancedStartButton);
        day2Rest7AdvancedStartButton = findViewById(R.id.day2Rest7AdvancedStartButton);

        day2Rest1AdvancedFinishButton = findViewById(R.id.day2Rest1AdvancedFinishButton);
        day2Rest2AdvancedFinishButton = findViewById(R.id.day2Rest2AdvancedFinishButton);
        day2Rest3AdvancedFinishButton = findViewById(R.id.day2Rest3AdvancedFinishButton);
        day2Rest4AdvancedFinishButton = findViewById(R.id.day2Rest4AdvancedFinishButton);
        day2Rest5AdvancedFinishButton = findViewById(R.id.day2Rest5AdvancedFinishButton);
        day2Rest6AdvancedFinishButton = findViewById(R.id.day2Rest6AdvancedFinishButton);
        day2Rest7AdvancedFinishButton = findViewById(R.id.day2Rest7AdvancedFinishButton);

        timer_advanced_day2_ex3 = findViewById(R.id.timer_advanced_day2_ex3);
        timer_advanced_day2_ex7 = findViewById(R.id.timer_advanced_day2_ex7);

        timer_advanced_day2_rest1 = findViewById(R.id.timer_advanced_day2_rest1);
        timer_advanced_day2_rest2 = findViewById(R.id.timer_advanced_day2_rest2);
        timer_advanced_day2_rest3 = findViewById(R.id.timer_advanced_day2_rest3);
        timer_advanced_day2_rest4 = findViewById(R.id.timer_advanced_day2_rest4);
        timer_advanced_day2_rest5 = findViewById(R.id.timer_advanced_day2_rest5);
        timer_advanced_day2_rest6 = findViewById(R.id.timer_advanced_day2_rest6);
        timer_advanced_day2_rest7 = findViewById(R.id.timer_advanced_day2_rest7);

        Glide.with(this).load(R.drawable.reverse_lunges_exercise).into(advanced_day2_ex1_photo);
        Glide.with(this).load(R.drawable.squats_exercise).into(advanced_day2_ex2_photo);
        Glide.with(this).load(R.drawable.high_knees_exercise).into(advanced_day2_ex3_photo);
        Glide.with(this).load(R.drawable.side_lunges_exercise).into(advanced_day2_ex4_photo);
        Glide.with(this).load(R.drawable.side_step_squats_exercise).into(advanced_day2_ex5_photo);
        Glide.with(this).load(R.drawable.forward_to_reverse_lunges_exercise).into(advanced_day2_ex6_photo);
        Glide.with(this).load(R.drawable.jump_squats).into(advanced_day2_ex7_photo);
        Glide.with(this).load(R.drawable.jumping_lunges).into(advanced_day2_ex8_photo);


        day2AdvancedBackButton.setOnClickListener(this);

        day2Ex1AdvancedStartButton.setOnClickListener(this);
        day2Ex2AdvancedStartButton.setOnClickListener(this);
        day2Ex3AdvancedStartButton.setOnClickListener(this);
        day2Ex4AdvancedStartButton.setOnClickListener(this);
        day2Ex5AdvancedStartButton.setOnClickListener(this);
        day2Ex6AdvancedStartButton.setOnClickListener(this);
        day2Ex7AdvancedStartButton.setOnClickListener(this);
        day2Ex8AdvancedStartButton.setOnClickListener(this);

        day2Ex1AdvancedNextButton.setOnClickListener(this);
        day2Ex2AdvancedNextButton.setOnClickListener(this);
        day2Ex3AdvancedNextButton.setOnClickListener(this);
        day2Ex4AdvancedNextButton.setOnClickListener(this);
        day2Ex5AdvancedNextButton.setOnClickListener(this);
        day2Ex6AdvancedNextButton.setOnClickListener(this);
        day2Ex7AdvancedNextButton.setOnClickListener(this);
        day2Ex8AdvancedNextButton.setOnClickListener(this);

        aboutDay2Ex1AdvancedButton.setOnClickListener(this);
        aboutDay2Ex2AdvancedButton.setOnClickListener(this);
        aboutDay2Ex3AdvancedButton.setOnClickListener(this);
        aboutDay2Ex4AdvancedButton.setOnClickListener(this);
        aboutDay2Ex5AdvancedButton.setOnClickListener(this);
        aboutDay2Ex6AdvancedButton.setOnClickListener(this);
        aboutDay2Ex7AdvancedButton.setOnClickListener(this);
        aboutDay2Ex8AdvancedButton.setOnClickListener(this);

        day2Rest1AdvancedStartButton.setOnClickListener(this);
        day2Rest2AdvancedStartButton.setOnClickListener(this);
        day2Rest3AdvancedStartButton.setOnClickListener(this);
        day2Rest4AdvancedStartButton.setOnClickListener(this);
        day2Rest5AdvancedStartButton.setOnClickListener(this);
        day2Rest6AdvancedStartButton.setOnClickListener(this);
        day2Rest7AdvancedStartButton.setOnClickListener(this);

        day2Rest1AdvancedFinishButton.setOnClickListener(this);
        day2Rest2AdvancedFinishButton.setOnClickListener(this);
        day2Rest3AdvancedFinishButton.setOnClickListener(this);
        day2Rest4AdvancedFinishButton.setOnClickListener(this);
        day2Rest5AdvancedFinishButton.setOnClickListener(this);
        day2Rest6AdvancedFinishButton.setOnClickListener(this);
        day2Rest7AdvancedFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day2AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

            case R.id.day2AdvancedBackButton:
                onBackPressed();
                break;

            case R.id.day2Ex1AdvancedStartButton:
                advanced_day2_ex1_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex1AdvancedStartButton.setVisibility(View.GONE);
                day2Ex1AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex1AdvancedNextButton:
                advanced_day2_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest1AdvancedStartButton:
                advanced_day2_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest1AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest1.setText("00:00");
                        day2Rest1AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest1AdvancedFinishButton:
                advanced_day2_rest1_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex2AdvancedStartButton:
                advanced_day2_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex2AdvancedStartButton.setVisibility(View.GONE);
                day2Ex2AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex2AdvancedNextButton:
                advanced_day2_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest2AdvancedStartButton:
                advanced_day2_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest2AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest2.setText("00:00");
                        day2Rest2AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest2AdvancedFinishButton:
                advanced_day2_rest2_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex3AdvancedStartButton:
                advanced_day2_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex3AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_ex3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_ex3.setText("00:00");
                        day2Ex3AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Ex3AdvancedNextButton:
                advanced_day2_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest3AdvancedStartButton:
                advanced_day2_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest3AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest3.setText("00:00");
                        day2Rest3AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest3AdvancedFinishButton:
                advanced_day2_rest3_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex4AdvancedStartButton:
                advanced_day2_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex4AdvancedStartButton.setVisibility(View.GONE);
                day2Ex4AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex4AdvancedNextButton:
                advanced_day2_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest4AdvancedStartButton:
                advanced_day2_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest4.setText("00:00");
                        day2Rest4AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest4AdvancedFinishButton:
                advanced_day2_rest4_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex5AdvancedStartButton:
                advanced_day2_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex5AdvancedStartButton.setVisibility(View.GONE);
                day2Ex5AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex5AdvancedNextButton:
                advanced_day2_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest5AdvancedStartButton:
                advanced_day2_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest5.setText("00:00");
                        day2Rest5AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest5AdvancedFinishButton:
                advanced_day2_rest5_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex6AdvancedStartButton:
                advanced_day2_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex6AdvancedStartButton.setVisibility(View.GONE);
                day2Ex6AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex6AdvancedNextButton:
                advanced_day2_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest6AdvancedStartButton:
                advanced_day2_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest6AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest6.setText("00:00");
                        day2Rest6AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest6AdvancedFinishButton:
                advanced_day2_rest6_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex7AdvancedStartButton:
                advanced_day2_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex7AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_ex7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_ex7.setText("00:00");
                        day2Ex7AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Ex7AdvancedNextButton:
                advanced_day2_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest7AdvancedStartButton:
                advanced_day2_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest7AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day2_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day2_rest7.setText("00:00");
                        day2Rest7AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day2Rest7AdvancedFinishButton:
                advanced_day2_rest7_layout.setVisibility(View.GONE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                advanced_day2_ex8_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex8AdvancedStartButton:
                advanced_day2_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day2_ex1_layout.setVisibility(View.GONE);
                advanced_day2_ex2_layout.setVisibility(View.GONE);
                advanced_day2_ex3_layout.setVisibility(View.GONE);
                advanced_day2_ex4_layout.setVisibility(View.GONE);
                advanced_day2_ex5_layout.setVisibility(View.GONE);
                advanced_day2_ex6_layout.setVisibility(View.GONE);
                advanced_day2_ex7_layout.setVisibility(View.GONE);
                day2Ex8AdvancedStartButton.setVisibility(View.GONE);
                day2Ex8AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex8AdvancedNextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 2")) {

                                                                    Toast.makeText(Day2AdvancedActivity.this, "You're already done for day 2!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 2").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day2AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 2")) {

                                                                    Toast.makeText(Day2AdvancedActivity.this, "You're already done for day 2!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 2").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day2AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 2")) {

                                                                    Toast.makeText(Day2AdvancedActivity.this, "You're already done for day 2!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 2").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day2AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

            case R.id.aboutDay2Ex1AdvancedButton:
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

            case R.id.aboutDay2Ex2AdvancedButton:
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

            case R.id.aboutDay2Ex3AdvancedButton:
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

            case R.id.aboutDay2Ex4AdvancedButton:
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

            case R.id.aboutDay2Ex5AdvancedButton:
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

            case R.id.aboutDay2Ex6AdvancedButton:
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

            case R.id.aboutDay2Ex7AdvancedButton:
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

            case R.id.aboutDay2Ex8AdvancedButton:
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