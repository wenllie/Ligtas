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

public class Day5AdvancedActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day5AdvancedBackButton;
    AppCompatButton day5Ex1AdvancedStartButton, day5Ex2AdvancedStartButton, day5Ex3AdvancedStartButton, day5Ex4AdvancedStartButton;
    AppCompatButton day5Ex5AdvancedStartButton, day5Ex6AdvancedStartButton, day5Ex7AdvancedStartButton, day5Ex8AdvancedStartButton, day5Ex9AdvancedStartButton;
    AppCompatButton day5Ex1AdvancedNextButton, day5Ex2AdvancedNextButton, day5Ex3AdvancedNextButton, day5Ex4AdvancedNextButton;
    AppCompatButton day5Ex5AdvancedNextButton, day5Ex6AdvancedNextButton, day5Ex7AdvancedNextButton, day5Ex8AdvancedNextButton, day5Ex9AdvancedNextButton;
    AppCompatImageView aboutDay5Ex1AdvancedButton, aboutDay5Ex2AdvancedButton, aboutDay5Ex3AdvancedButton, aboutDay5Ex4AdvancedButton, aboutDay5Ex5AdvancedButton;
    AppCompatImageView aboutDay5Ex6AdvancedButton, aboutDay5Ex7AdvancedButton, aboutDay5Ex8AdvancedButton, aboutDay5Ex9AdvancedButton;
    AppCompatImageView advanced_day5_ex1_photo, advanced_day5_ex2_photo, advanced_day5_ex3_photo, advanced_day5_ex4_photo, advanced_day5_ex5_photo;
    AppCompatImageView advanced_day5_ex6_photo, advanced_day5_ex7_photo, advanced_day5_ex8_photo, advanced_day5_ex9_photo;
    FrameLayout advanced_day5_ex1_layout, advanced_day5_ex2_layout, advanced_day5_ex3_layout, advanced_day5_ex4_layout, advanced_day5_ex5_layout;
    FrameLayout advanced_day5_ex6_layout, advanced_day5_ex7_layout, advanced_day5_ex8_layout, advanced_day5_ex9_layout;
    FrameLayout advanced_day5_rest1_layout, advanced_day5_rest2_layout, advanced_day5_rest3_layout, advanced_day5_rest4_layout;
    FrameLayout advanced_day5_rest5_layout, advanced_day5_rest6_layout, advanced_day5_rest7_layout, advanced_day5_rest8_layout;
    AppCompatButton day5Rest1AdvancedStartButton, day5Rest2AdvancedStartButton, day5Rest3AdvancedStartButton, day5Rest4AdvancedStartButton;
    AppCompatButton day5Rest5AdvancedStartButton, day5Rest6AdvancedStartButton, day5Rest7AdvancedStartButton, day5Rest8AdvancedStartButton;
    AppCompatButton day5Rest1AdvancedFinishButton, day5Rest2AdvancedFinishButton, day5Rest3AdvancedFinishButton, day5Rest4AdvancedFinishButton;
    AppCompatButton day5Rest5AdvancedFinishButton, day5Rest6AdvancedFinishButton, day5Rest7AdvancedFinishButton, day5Rest8AdvancedFinishButton;
    AppCompatTextView timer_advanced_day5_ex4, timer_advanced_day5_ex5, timer_advanced_day5_ex9;
    AppCompatTextView timer_advanced_day5_rest1, timer_advanced_day5_rest2, timer_advanced_day5_rest3, timer_advanced_day5_rest4;
    AppCompatTextView timer_advanced_day5_rest5, timer_advanced_day5_rest6, timer_advanced_day5_rest7, timer_advanced_day5_rest8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5_advanced);

        day5AdvancedBackButton = findViewById(R.id.day5AdvancedBackButton);

        aboutDay5Ex1AdvancedButton = findViewById(R.id.aboutDay5Ex1AdvancedButton);
        aboutDay5Ex2AdvancedButton = findViewById(R.id.aboutDay5Ex2AdvancedButton);
        aboutDay5Ex3AdvancedButton = findViewById(R.id.aboutDay5Ex3AdvancedButton);
        aboutDay5Ex4AdvancedButton = findViewById(R.id.aboutDay5Ex4AdvancedButton);
        aboutDay5Ex5AdvancedButton = findViewById(R.id.aboutDay5Ex5AdvancedButton);
        aboutDay5Ex6AdvancedButton = findViewById(R.id.aboutDay5Ex6AdvancedButton);
        aboutDay5Ex7AdvancedButton = findViewById(R.id.aboutDay5Ex7AdvancedButton);
        aboutDay5Ex8AdvancedButton = findViewById(R.id.aboutDay5Ex8AdvancedButton);
        aboutDay5Ex9AdvancedButton = findViewById(R.id.aboutDay5Ex9AdvancedButton);

        day5Ex1AdvancedStartButton = findViewById(R.id.day5Ex1AdvancedStartButton);
        day5Ex2AdvancedStartButton = findViewById(R.id.day5Ex2AdvancedStartButton);
        day5Ex3AdvancedStartButton = findViewById(R.id.day5Ex3AdvancedStartButton);
        day5Ex4AdvancedStartButton = findViewById(R.id.day5Ex4AdvancedStartButton);
        day5Ex5AdvancedStartButton = findViewById(R.id.day5Ex5AdvancedStartButton);
        day5Ex6AdvancedStartButton = findViewById(R.id.day5Ex6AdvancedStartButton);
        day5Ex7AdvancedStartButton = findViewById(R.id.day5Ex7AdvancedStartButton);
        day5Ex8AdvancedStartButton = findViewById(R.id.day5Ex8AdvancedStartButton);
        day5Ex9AdvancedStartButton = findViewById(R.id.day5Ex9AdvancedStartButton);

        day5Ex1AdvancedNextButton = findViewById(R.id.day5Ex1AdvancedNextButton);
        day5Ex2AdvancedNextButton = findViewById(R.id.day5Ex2AdvancedNextButton);
        day5Ex3AdvancedNextButton = findViewById(R.id.day5Ex3AdvancedNextButton);
        day5Ex4AdvancedNextButton = findViewById(R.id.day5Ex4AdvancedNextButton);
        day5Ex5AdvancedNextButton = findViewById(R.id.day5Ex5AdvancedNextButton);
        day5Ex6AdvancedNextButton = findViewById(R.id.day5Ex6AdvancedNextButton);
        day5Ex7AdvancedNextButton = findViewById(R.id.day5Ex7AdvancedNextButton);
        day5Ex8AdvancedNextButton = findViewById(R.id.day5Ex8AdvancedNextButton);
        day5Ex9AdvancedNextButton = findViewById(R.id.day5Ex9AdvancedNextButton);

        advanced_day5_ex1_layout = findViewById(R.id.advanced_day5_ex1_layout);
        advanced_day5_ex2_layout = findViewById(R.id.advanced_day5_ex2_layout);
        advanced_day5_ex3_layout = findViewById(R.id.advanced_day5_ex3_layout);
        advanced_day5_ex4_layout = findViewById(R.id.advanced_day5_ex4_layout);
        advanced_day5_ex5_layout = findViewById(R.id.advanced_day5_ex5_layout);
        advanced_day5_ex6_layout = findViewById(R.id.advanced_day5_ex6_layout);
        advanced_day5_ex7_layout = findViewById(R.id.advanced_day5_ex7_layout);
        advanced_day5_ex8_layout = findViewById(R.id.advanced_day5_ex8_layout);
        advanced_day5_ex9_layout = findViewById(R.id.advanced_day5_ex9_layout);

        advanced_day5_rest1_layout = findViewById(R.id.advanced_day5_rest1_layout);
        advanced_day5_rest2_layout = findViewById(R.id.advanced_day5_rest2_layout);
        advanced_day5_rest3_layout = findViewById(R.id.advanced_day5_rest3_layout);
        advanced_day5_rest4_layout = findViewById(R.id.advanced_day5_rest4_layout);
        advanced_day5_rest5_layout = findViewById(R.id.advanced_day5_rest5_layout);
        advanced_day5_rest6_layout = findViewById(R.id.advanced_day5_rest6_layout);
        advanced_day5_rest7_layout = findViewById(R.id.advanced_day5_rest7_layout);
        advanced_day5_rest8_layout = findViewById(R.id.advanced_day5_rest8_layout);

        day5Rest1AdvancedStartButton = findViewById(R.id.day5Rest1AdvancedStartButton);
        day5Rest2AdvancedStartButton = findViewById(R.id.day5Rest2AdvancedStartButton);
        day5Rest3AdvancedStartButton = findViewById(R.id.day5Rest3AdvancedStartButton);
        day5Rest4AdvancedStartButton = findViewById(R.id.day5Rest4AdvancedStartButton);
        day5Rest5AdvancedStartButton = findViewById(R.id.day5Rest5AdvancedStartButton);
        day5Rest6AdvancedStartButton = findViewById(R.id.day5Rest6AdvancedStartButton);
        day5Rest7AdvancedStartButton = findViewById(R.id.day5Rest7AdvancedStartButton);
        day5Rest8AdvancedStartButton = findViewById(R.id.day5Rest8AdvancedStartButton);

        day5Rest1AdvancedFinishButton = findViewById(R.id.day5Rest1AdvancedFinishButton);
        day5Rest2AdvancedFinishButton = findViewById(R.id.day5Rest2AdvancedFinishButton);
        day5Rest3AdvancedFinishButton = findViewById(R.id.day5Rest3AdvancedFinishButton);
        day5Rest4AdvancedFinishButton = findViewById(R.id.day5Rest4AdvancedFinishButton);
        day5Rest5AdvancedFinishButton = findViewById(R.id.day5Rest5AdvancedFinishButton);
        day5Rest6AdvancedFinishButton = findViewById(R.id.day5Rest6AdvancedFinishButton);
        day5Rest7AdvancedFinishButton = findViewById(R.id.day5Rest7AdvancedFinishButton);
        day5Rest8AdvancedFinishButton = findViewById(R.id.day5Rest8AdvancedFinishButton);

        advanced_day5_ex1_photo = findViewById(R.id.advanced_day5_ex1_photo);
        advanced_day5_ex2_photo = findViewById(R.id.advanced_day5_ex2_photo);
        advanced_day5_ex3_photo = findViewById(R.id.advanced_day5_ex3_photo);
        advanced_day5_ex4_photo = findViewById(R.id.advanced_day5_ex4_photo);
        advanced_day5_ex5_photo = findViewById(R.id.advanced_day5_ex5_photo);
        advanced_day5_ex6_photo = findViewById(R.id.advanced_day5_ex6_photo);
        advanced_day5_ex7_photo = findViewById(R.id.advanced_day5_ex7_photo);
        advanced_day5_ex8_photo = findViewById(R.id.advanced_day5_ex8_photo);
        advanced_day5_ex9_photo = findViewById(R.id.advanced_day5_ex9_photo);

        timer_advanced_day5_ex4 = findViewById(R.id.timer_advanced_day5_ex4);
        timer_advanced_day5_ex5 = findViewById(R.id.timer_advanced_day5_ex5);
        timer_advanced_day5_ex9 = findViewById(R.id.timer_advanced_day5_ex9);

        timer_advanced_day5_rest1 = findViewById(R.id.timer_advanced_day5_rest1);
        timer_advanced_day5_rest2 = findViewById(R.id.timer_advanced_day5_rest2);
        timer_advanced_day5_rest3 = findViewById(R.id.timer_advanced_day5_rest3);
        timer_advanced_day5_rest4 = findViewById(R.id.timer_advanced_day5_rest4);
        timer_advanced_day5_rest5 = findViewById(R.id.timer_advanced_day5_rest5);
        timer_advanced_day5_rest6 = findViewById(R.id.timer_advanced_day5_rest6);
        timer_advanced_day5_rest7 = findViewById(R.id.timer_advanced_day5_rest7);
        timer_advanced_day5_rest8 = findViewById(R.id.timer_advanced_day5_rest8);

        Glide.with(this).load(R.drawable.spider_man_mountain_climbers_exercise).into(advanced_day5_ex1_photo);
        Glide.with(this).load(R.drawable.donkey_kicks_exercise).into(advanced_day5_ex2_photo);
        Glide.with(this).load(R.drawable.wide_grip_push_ups_exercise).into(advanced_day5_ex3_photo);
        Glide.with(this).load(R.drawable.plank_jacks_exercise).into(advanced_day5_ex4_photo);
        Glide.with(this).load(R.drawable.lateral_plank_walks_exercise).into(advanced_day5_ex5_photo);
        Glide.with(this).load(R.drawable.push_ups).into(advanced_day5_ex6_photo);
        Glide.with(this).load(R.drawable.plank_ups).into(advanced_day5_ex7_photo);
        Glide.with(this).load(R.drawable.side_leg_kickbacks).into(advanced_day5_ex8_photo);
        Glide.with(this).load(R.drawable.plank_taps).into(advanced_day5_ex9_photo);

        day5AdvancedBackButton.setOnClickListener(this);

        day5Ex1AdvancedStartButton.setOnClickListener(this);
        day5Ex2AdvancedStartButton.setOnClickListener(this);
        day5Ex3AdvancedStartButton.setOnClickListener(this);
        day5Ex4AdvancedStartButton.setOnClickListener(this);
        day5Ex5AdvancedStartButton.setOnClickListener(this);
        day5Ex6AdvancedStartButton.setOnClickListener(this);
        day5Ex7AdvancedStartButton.setOnClickListener(this);
        day5Ex8AdvancedStartButton.setOnClickListener(this);
        day5Ex9AdvancedStartButton.setOnClickListener(this);

        day5Ex1AdvancedNextButton.setOnClickListener(this);
        day5Ex2AdvancedNextButton.setOnClickListener(this);
        day5Ex3AdvancedNextButton.setOnClickListener(this);
        day5Ex4AdvancedNextButton.setOnClickListener(this);
        day5Ex5AdvancedNextButton.setOnClickListener(this);
        day5Ex6AdvancedNextButton.setOnClickListener(this);
        day5Ex7AdvancedNextButton.setOnClickListener(this);
        day5Ex8AdvancedNextButton.setOnClickListener(this);
        day5Ex9AdvancedNextButton.setOnClickListener(this);

        aboutDay5Ex1AdvancedButton.setOnClickListener(this);
        aboutDay5Ex2AdvancedButton.setOnClickListener(this);
        aboutDay5Ex3AdvancedButton.setOnClickListener(this);
        aboutDay5Ex4AdvancedButton.setOnClickListener(this);
        aboutDay5Ex5AdvancedButton.setOnClickListener(this);
        aboutDay5Ex6AdvancedButton.setOnClickListener(this);
        aboutDay5Ex7AdvancedButton.setOnClickListener(this);
        aboutDay5Ex8AdvancedButton.setOnClickListener(this);
        aboutDay5Ex9AdvancedButton.setOnClickListener(this);

        day5Rest1AdvancedStartButton.setOnClickListener(this);
        day5Rest2AdvancedStartButton.setOnClickListener(this);
        day5Rest3AdvancedStartButton.setOnClickListener(this);
        day5Rest4AdvancedStartButton.setOnClickListener(this);
        day5Rest5AdvancedStartButton.setOnClickListener(this);
        day5Rest6AdvancedStartButton.setOnClickListener(this);
        day5Rest7AdvancedStartButton.setOnClickListener(this);
        day5Rest8AdvancedStartButton.setOnClickListener(this);

        day5Rest1AdvancedFinishButton.setOnClickListener(this);
        day5Rest2AdvancedFinishButton.setOnClickListener(this);
        day5Rest3AdvancedFinishButton.setOnClickListener(this);
        day5Rest4AdvancedFinishButton.setOnClickListener(this);
        day5Rest5AdvancedFinishButton.setOnClickListener(this);
        day5Rest6AdvancedFinishButton.setOnClickListener(this);
        day5Rest7AdvancedFinishButton.setOnClickListener(this);
        day5Rest8AdvancedFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day5AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

            case R.id.day5AdvancedBackButton:
                onBackPressed();
                break;

            case R.id.day5Ex1AdvancedStartButton:
                advanced_day5_ex1_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex1AdvancedStartButton.setVisibility(View.GONE);
                day5Ex1AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex1AdvancedNextButton:
                advanced_day5_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest1AdvancedStartButton:
                advanced_day5_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest1AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest1.setText("00:00");
                        day5Rest1AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest1AdvancedFinishButton:
                advanced_day5_rest1_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex2AdvancedStartButton:
                advanced_day5_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex2AdvancedStartButton.setVisibility(View.GONE);
                day5Ex2AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex2AdvancedNextButton:
                advanced_day5_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest2AdvancedStartButton:
                advanced_day5_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest2AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest2.setText("00:00");
                        day5Rest2AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest2AdvancedFinishButton:
                advanced_day5_rest2_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex3AdvancedStartButton:
                advanced_day5_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex3AdvancedStartButton.setVisibility(View.GONE);
                day5Ex3AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex3AdvancedNextButton:
                advanced_day5_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest3AdvancedStartButton:
                advanced_day5_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest3AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest3.setText("00:00");
                        day5Rest3AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest3AdvancedFinishButton:
                advanced_day5_rest3_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex4AdvancedStartButton:
                advanced_day5_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_ex4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_ex4.setText("00:00");
                        day5Ex4AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex4AdvancedNextButton:
                advanced_day5_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest4AdvancedStartButton:
                advanced_day5_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest4.setText("00:00");
                        day5Rest4AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest4AdvancedFinishButton:
                advanced_day5_rest4_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex5AdvancedStartButton:
                advanced_day5_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_ex5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_ex5.setText("00:00");
                        day5Ex5AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex5AdvancedNextButton:
                advanced_day5_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest5AdvancedStartButton:
                advanced_day5_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest5.setText("00:00");
                        day5Rest5AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest5AdvancedFinishButton:
                advanced_day5_rest5_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex6AdvancedStartButton:
                advanced_day5_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex6AdvancedStartButton.setVisibility(View.GONE);
                day5Ex6AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex6AdvancedNextButton:
                advanced_day5_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest6AdvancedStartButton:
                advanced_day5_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest6AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest6.setText("00:00");
                        day5Rest6AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest6AdvancedFinishButton:
                advanced_day5_rest6_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex7AdvancedStartButton:
                advanced_day5_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex7AdvancedStartButton.setVisibility(View.GONE);
                day5Ex7AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex7AdvancedNextButton:
                advanced_day5_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest7AdvancedStartButton:
                advanced_day5_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest7AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest7.setText("00:00");
                        day5Rest7AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest7AdvancedFinishButton:
                advanced_day5_rest7_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex8AdvancedStartButton:
                advanced_day5_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex8AdvancedStartButton.setVisibility(View.GONE);
                day5Ex8AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex8AdvancedNextButton:
                advanced_day5_rest8_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest8AdvancedStartButton:
                advanced_day5_rest8_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest8AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_rest8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_rest8.setText("00:00");
                        day5Rest8AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest8AdvancedFinishButton:
                advanced_day5_rest8_layout.setVisibility(View.GONE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                advanced_day5_ex9_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex9AdvancedStartButton:
                advanced_day5_ex9_layout.setVisibility(View.VISIBLE);
                advanced_day5_ex1_layout.setVisibility(View.GONE);
                advanced_day5_ex2_layout.setVisibility(View.GONE);
                advanced_day5_ex3_layout.setVisibility(View.GONE);
                advanced_day5_ex4_layout.setVisibility(View.GONE);
                advanced_day5_ex5_layout.setVisibility(View.GONE);
                advanced_day5_ex6_layout.setVisibility(View.GONE);
                advanced_day5_ex7_layout.setVisibility(View.GONE);
                advanced_day5_ex8_layout.setVisibility(View.GONE);
                day5Ex9AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day5_ex9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day5_ex9.setText("00:00");
                        day5Ex9AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex9AdvancedNextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5AdvancedActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5AdvancedActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5AdvancedActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

            case R.id.aboutDay5Ex1AdvancedButton:
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

            case R.id.aboutDay5Ex2AdvancedButton:
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

            case R.id.aboutDay5Ex3AdvancedButton:
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

            case R.id.aboutDay5Ex4AdvancedButton:
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

            case R.id.aboutDay5Ex5AdvancedButton:
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

            case R.id.aboutDay5Ex6AdvancedButton:
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

            case R.id.aboutDay5Ex7AdvancedButton:
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

            case R.id.aboutDay5Ex8AdvancedButton:
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

            case R.id.aboutDay5Ex9AdvancedButton:
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