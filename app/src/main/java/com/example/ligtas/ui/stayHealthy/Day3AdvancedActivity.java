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

public class Day3AdvancedActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day3AdvancedBackButton;
    AppCompatButton day3Ex1AdvancedStartButton, day3Ex2AdvancedStartButton, day3Ex3AdvancedStartButton, day3Ex4AdvancedStartButton;
    AppCompatButton day3Ex5AdvancedStartButton, day3Ex6AdvancedStartButton, day3Ex7AdvancedStartButton, day3Ex8AdvancedStartButton, day3Ex9AdvancedStartButton;
    AppCompatButton day3Ex1AdvancedNextButton, day3Ex2AdvancedNextButton, day3Ex3AdvancedNextButton, day3Ex4AdvancedNextButton;
    AppCompatButton day3Ex5AdvancedNextButton, day3Ex6AdvancedNextButton, day3Ex7AdvancedNextButton, day3Ex8AdvancedNextButton, day3Ex9AdvancedNextButton;
    AppCompatImageView aboutDay3Ex1AdvancedButton, aboutDay3Ex2AdvancedButton, aboutDay3Ex3AdvancedButton, aboutDay3Ex4AdvancedButton, aboutDay3Ex5AdvancedButton;
    AppCompatImageView aboutDay3Ex6AdvancedButton, aboutDay3Ex7AdvancedButton, aboutDay3Ex8AdvancedButton, aboutDay3Ex9AdvancedButton;
    AppCompatImageView advanced_day3_ex1_photo, advanced_day3_ex2_photo, advanced_day3_ex3_photo, advanced_day3_ex4_photo, advanced_day3_ex5_photo;
    AppCompatImageView advanced_day3_ex6_photo, advanced_day3_ex7_photo, advanced_day3_ex8_photo, advanced_day3_ex9_photo;
    FrameLayout advanced_day3_ex1_layout, advanced_day3_ex2_layout, advanced_day3_ex3_layout, advanced_day3_ex4_layout, advanced_day3_ex5_layout;
    FrameLayout advanced_day3_ex6_layout, advanced_day3_ex7_layout, advanced_day3_ex8_layout, advanced_day3_ex9_layout;
    FrameLayout advanced_day3_rest1_layout, advanced_day3_rest2_layout, advanced_day3_rest3_layout, advanced_day3_rest4_layout;
    FrameLayout advanced_day3_rest5_layout, advanced_day3_rest6_layout, advanced_day3_rest7_layout, advanced_day3_rest8_layout;
    AppCompatButton day3Rest1AdvancedStartButton, day3Rest2AdvancedStartButton, day3Rest3AdvancedStartButton, day3Rest4AdvancedStartButton;
    AppCompatButton day3Rest5AdvancedStartButton, day3Rest6AdvancedStartButton, day3Rest7AdvancedStartButton, day3Rest8AdvancedStartButton;
    AppCompatButton day3Rest1AdvancedFinishButton, day3Rest2AdvancedFinishButton, day3Rest3AdvancedFinishButton, day3Rest4AdvancedFinishButton;
    AppCompatButton day3Rest5AdvancedFinishButton, day3Rest6AdvancedFinishButton, day3Rest7AdvancedFinishButton, day3Rest8AdvancedFinishButton;
    AppCompatTextView timer_advanced_day3_ex3, timer_advanced_day3_ex4, timer_advanced_day3_ex5, timer_advanced_day3_ex8, timer_advanced_day3_ex9;
    AppCompatTextView timer_advanced_day3_rest1, timer_advanced_day3_rest2, timer_advanced_day3_rest3, timer_advanced_day3_rest4;
    AppCompatTextView timer_advanced_day3_rest5, timer_advanced_day3_rest6, timer_advanced_day3_rest7, timer_advanced_day3_rest8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_advanced);

        day3AdvancedBackButton = findViewById(R.id.day3AdvancedBackButton);

        aboutDay3Ex1AdvancedButton = findViewById(R.id.aboutDay3Ex1AdvancedButton);
        aboutDay3Ex2AdvancedButton = findViewById(R.id.aboutDay3Ex2AdvancedButton);
        aboutDay3Ex3AdvancedButton = findViewById(R.id.aboutDay3Ex3AdvancedButton);
        aboutDay3Ex4AdvancedButton = findViewById(R.id.aboutDay3Ex4AdvancedButton);
        aboutDay3Ex5AdvancedButton = findViewById(R.id.aboutDay3Ex5AdvancedButton);
        aboutDay3Ex6AdvancedButton = findViewById(R.id.aboutDay3Ex6AdvancedButton);
        aboutDay3Ex7AdvancedButton = findViewById(R.id.aboutDay3Ex7AdvancedButton);
        aboutDay3Ex8AdvancedButton = findViewById(R.id.aboutDay3Ex8AdvancedButton);
        aboutDay3Ex9AdvancedButton = findViewById(R.id.aboutDay3Ex9AdvancedButton);

        day3Ex1AdvancedStartButton = findViewById(R.id.day3Ex1AdvancedStartButton);
        day3Ex2AdvancedStartButton = findViewById(R.id.day3Ex2AdvancedStartButton);
        day3Ex3AdvancedStartButton = findViewById(R.id.day3Ex3AdvancedStartButton);
        day3Ex4AdvancedStartButton = findViewById(R.id.day3Ex4AdvancedStartButton);
        day3Ex5AdvancedStartButton = findViewById(R.id.day3Ex5AdvancedStartButton);
        day3Ex6AdvancedStartButton = findViewById(R.id.day3Ex6AdvancedStartButton);
        day3Ex7AdvancedStartButton = findViewById(R.id.day3Ex7AdvancedStartButton);
        day3Ex8AdvancedStartButton = findViewById(R.id.day3Ex8AdvancedStartButton);
        day3Ex9AdvancedStartButton = findViewById(R.id.day3Ex9AdvancedStartButton);

        day3Ex1AdvancedNextButton = findViewById(R.id.day3Ex1AdvancedNextButton);
        day3Ex2AdvancedNextButton = findViewById(R.id.day3Ex2AdvancedNextButton);
        day3Ex3AdvancedNextButton = findViewById(R.id.day3Ex3AdvancedNextButton);
        day3Ex4AdvancedNextButton = findViewById(R.id.day3Ex4AdvancedNextButton);
        day3Ex5AdvancedNextButton = findViewById(R.id.day3Ex5AdvancedNextButton);
        day3Ex6AdvancedNextButton = findViewById(R.id.day3Ex6AdvancedNextButton);
        day3Ex7AdvancedNextButton = findViewById(R.id.day3Ex7AdvancedNextButton);
        day3Ex8AdvancedNextButton = findViewById(R.id.day3Ex8AdvancedNextButton);
        day3Ex9AdvancedNextButton = findViewById(R.id.day3Ex9AdvancedNextButton);

        advanced_day3_ex1_layout = findViewById(R.id.advanced_day3_ex1_layout);
        advanced_day3_ex2_layout = findViewById(R.id.advanced_day3_ex2_layout);
        advanced_day3_ex3_layout = findViewById(R.id.advanced_day3_ex3_layout);
        advanced_day3_ex4_layout = findViewById(R.id.advanced_day3_ex4_layout);
        advanced_day3_ex5_layout = findViewById(R.id.advanced_day3_ex5_layout);
        advanced_day3_ex6_layout = findViewById(R.id.advanced_day3_ex6_layout);
        advanced_day3_ex7_layout = findViewById(R.id.advanced_day3_ex7_layout);
        advanced_day3_ex8_layout = findViewById(R.id.advanced_day3_ex8_layout);
        advanced_day3_ex9_layout = findViewById(R.id.advanced_day3_ex9_layout);

        advanced_day3_rest1_layout = findViewById(R.id.advanced_day3_rest1_layout);
        advanced_day3_rest2_layout = findViewById(R.id.advanced_day3_rest2_layout);
        advanced_day3_rest3_layout = findViewById(R.id.advanced_day3_rest3_layout);
        advanced_day3_rest4_layout = findViewById(R.id.advanced_day3_rest4_layout);
        advanced_day3_rest5_layout = findViewById(R.id.advanced_day3_rest5_layout);
        advanced_day3_rest6_layout = findViewById(R.id.advanced_day3_rest6_layout);
        advanced_day3_rest7_layout = findViewById(R.id.advanced_day3_rest7_layout);
        advanced_day3_rest8_layout = findViewById(R.id.advanced_day3_rest8_layout);

        day3Rest1AdvancedStartButton = findViewById(R.id.day3Rest1AdvancedStartButton);
        day3Rest2AdvancedStartButton = findViewById(R.id.day3Rest2AdvancedStartButton);
        day3Rest3AdvancedStartButton = findViewById(R.id.day3Rest3AdvancedStartButton);
        day3Rest4AdvancedStartButton = findViewById(R.id.day3Rest4AdvancedStartButton);
        day3Rest5AdvancedStartButton = findViewById(R.id.day3Rest5AdvancedStartButton);
        day3Rest6AdvancedStartButton = findViewById(R.id.day3Rest6AdvancedStartButton);
        day3Rest7AdvancedStartButton = findViewById(R.id.day3Rest7AdvancedStartButton);
        day3Rest8AdvancedStartButton = findViewById(R.id.day3Rest8AdvancedStartButton);

        day3Rest1AdvancedFinishButton = findViewById(R.id.day3Rest1AdvancedFinishButton);
        day3Rest2AdvancedFinishButton = findViewById(R.id.day3Rest2AdvancedFinishButton);
        day3Rest3AdvancedFinishButton = findViewById(R.id.day3Rest3AdvancedFinishButton);
        day3Rest4AdvancedFinishButton = findViewById(R.id.day3Rest4AdvancedFinishButton);
        day3Rest5AdvancedFinishButton = findViewById(R.id.day3Rest5AdvancedFinishButton);
        day3Rest6AdvancedFinishButton = findViewById(R.id.day3Rest6AdvancedFinishButton);
        day3Rest7AdvancedFinishButton = findViewById(R.id.day3Rest7AdvancedFinishButton);
        day3Rest8AdvancedFinishButton = findViewById(R.id.day3Rest8AdvancedFinishButton);

        advanced_day3_ex1_photo = findViewById(R.id.advanced_day3_ex1_photo);
        advanced_day3_ex2_photo = findViewById(R.id.advanced_day3_ex2_photo);
        advanced_day3_ex3_photo = findViewById(R.id.advanced_day3_ex3_photo);
        advanced_day3_ex4_photo = findViewById(R.id.advanced_day3_ex4_photo);
        advanced_day3_ex5_photo = findViewById(R.id.advanced_day3_ex5_photo);
        advanced_day3_ex6_photo = findViewById(R.id.advanced_day3_ex6_photo);
        advanced_day3_ex7_photo = findViewById(R.id.advanced_day3_ex7_photo);
        advanced_day3_ex8_photo = findViewById(R.id.advanced_day3_ex8_photo);
        advanced_day3_ex9_photo = findViewById(R.id.advanced_day3_ex9_photo);

        timer_advanced_day3_ex3 = findViewById(R.id.timer_advanced_day3_ex3);
        timer_advanced_day3_ex4 = findViewById(R.id.timer_advanced_day3_ex4);
        timer_advanced_day3_ex5 = findViewById(R.id.timer_advanced_day3_ex5);
        timer_advanced_day3_ex8 = findViewById(R.id.timer_advanced_day3_ex8);
        timer_advanced_day3_ex9 = findViewById(R.id.timer_advanced_day3_ex9);

        timer_advanced_day3_rest1 = findViewById(R.id.timer_advanced_day3_rest1);
        timer_advanced_day3_rest2 = findViewById(R.id.timer_advanced_day3_rest2);
        timer_advanced_day3_rest3 = findViewById(R.id.timer_advanced_day3_rest3);
        timer_advanced_day3_rest4 = findViewById(R.id.timer_advanced_day3_rest4);
        timer_advanced_day3_rest5 = findViewById(R.id.timer_advanced_day3_rest5);
        timer_advanced_day3_rest6 = findViewById(R.id.timer_advanced_day3_rest6);
        timer_advanced_day3_rest7 = findViewById(R.id.timer_advanced_day3_rest7);
        timer_advanced_day3_rest8 = findViewById(R.id.timer_advanced_day3_rest8);

        Glide.with(this).load(R.drawable.lateral_leg_raises_exercise).into(advanced_day3_ex1_photo);
        Glide.with(this).load(R.drawable.marching_glute_bridge_exercise).into(advanced_day3_ex2_photo);
        Glide.with(this).load(R.drawable.hip_bridges).into(advanced_day3_ex3_photo);
        Glide.with(this).load(R.drawable.bicycle_crunches).into(advanced_day3_ex4_photo);
        Glide.with(this).load(R.drawable.alternating_knee_to_chests).into(advanced_day3_ex5_photo);
        Glide.with(this).load(R.drawable.side_plank_dips).into(advanced_day3_ex6_photo);
        Glide.with(this).load(R.drawable.v_ups).into(advanced_day3_ex7_photo);
        Glide.with(this).load(R.drawable.dead_bugs).into(advanced_day3_ex8_photo);
        Glide.with(this).load(R.drawable.sit_ups_to_twists).into(advanced_day3_ex9_photo);

        day3AdvancedBackButton.setOnClickListener(this);

        day3Ex1AdvancedStartButton.setOnClickListener(this);
        day3Ex2AdvancedStartButton.setOnClickListener(this);
        day3Ex3AdvancedStartButton.setOnClickListener(this);
        day3Ex4AdvancedStartButton.setOnClickListener(this);
        day3Ex5AdvancedStartButton.setOnClickListener(this);
        day3Ex6AdvancedStartButton.setOnClickListener(this);
        day3Ex7AdvancedStartButton.setOnClickListener(this);
        day3Ex8AdvancedStartButton.setOnClickListener(this);
        day3Ex9AdvancedStartButton.setOnClickListener(this);

        day3Ex1AdvancedNextButton.setOnClickListener(this);
        day3Ex2AdvancedNextButton.setOnClickListener(this);
        day3Ex3AdvancedNextButton.setOnClickListener(this);
        day3Ex4AdvancedNextButton.setOnClickListener(this);
        day3Ex5AdvancedNextButton.setOnClickListener(this);
        day3Ex6AdvancedNextButton.setOnClickListener(this);
        day3Ex7AdvancedNextButton.setOnClickListener(this);
        day3Ex8AdvancedNextButton.setOnClickListener(this);
        day3Ex9AdvancedNextButton.setOnClickListener(this);

        aboutDay3Ex1AdvancedButton.setOnClickListener(this);
        aboutDay3Ex2AdvancedButton.setOnClickListener(this);
        aboutDay3Ex3AdvancedButton.setOnClickListener(this);
        aboutDay3Ex4AdvancedButton.setOnClickListener(this);
        aboutDay3Ex5AdvancedButton.setOnClickListener(this);
        aboutDay3Ex6AdvancedButton.setOnClickListener(this);
        aboutDay3Ex7AdvancedButton.setOnClickListener(this);
        aboutDay3Ex8AdvancedButton.setOnClickListener(this);
        aboutDay3Ex9AdvancedButton.setOnClickListener(this);

        day3Rest1AdvancedStartButton.setOnClickListener(this);
        day3Rest2AdvancedStartButton.setOnClickListener(this);
        day3Rest3AdvancedStartButton.setOnClickListener(this);
        day3Rest4AdvancedStartButton.setOnClickListener(this);
        day3Rest5AdvancedStartButton.setOnClickListener(this);
        day3Rest6AdvancedStartButton.setOnClickListener(this);
        day3Rest7AdvancedStartButton.setOnClickListener(this);
        day3Rest8AdvancedStartButton.setOnClickListener(this);

        day3Rest1AdvancedFinishButton.setOnClickListener(this);
        day3Rest2AdvancedFinishButton.setOnClickListener(this);
        day3Rest3AdvancedFinishButton.setOnClickListener(this);
        day3Rest4AdvancedFinishButton.setOnClickListener(this);
        day3Rest5AdvancedFinishButton.setOnClickListener(this);
        day3Rest6AdvancedFinishButton.setOnClickListener(this);
        day3Rest7AdvancedFinishButton.setOnClickListener(this);
        day3Rest8AdvancedFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day3AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

            case R.id.day3AdvancedBackButton:
                onBackPressed();
                break;

            case R.id.day3Ex1AdvancedStartButton:
                advanced_day3_ex1_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex1AdvancedStartButton.setVisibility(View.GONE);
                day3Ex1AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex1AdvancedNextButton:
                advanced_day3_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest1AdvancedStartButton:
                advanced_day3_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest1AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest1.setText("00:00");
                        day3Rest1AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest1AdvancedFinishButton:
                advanced_day3_rest1_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex2AdvancedStartButton:
                advanced_day3_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex2AdvancedStartButton.setVisibility(View.GONE);
                day3Ex2AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex2AdvancedNextButton:
                advanced_day3_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest2AdvancedStartButton:
                advanced_day3_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest2AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest2.setText("00:00");
                        day3Rest2AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest2AdvancedFinishButton:
                advanced_day3_rest2_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex3AdvancedStartButton:
                advanced_day3_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex3AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_ex3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_ex3.setText("00:00");
                        day3Ex3AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex3AdvancedNextButton:
                advanced_day3_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest3AdvancedStartButton:
                advanced_day3_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest3AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest3.setText("00:00");
                        day3Rest3AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest3AdvancedFinishButton:
                advanced_day3_rest3_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex4AdvancedStartButton:
                advanced_day3_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_ex4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_ex4.setText("00:00");
                        day3Ex4AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex4AdvancedNextButton:
                advanced_day3_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest4AdvancedStartButton:
                advanced_day3_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest4AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest4.setText("00:00");
                        day3Rest4AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest4AdvancedFinishButton:
                advanced_day3_rest4_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex5AdvancedStartButton:
                advanced_day3_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_ex5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_ex5.setText("00:00");
                        day3Ex5AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex5AdvancedNextButton:
                advanced_day3_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest5AdvancedStartButton:
                advanced_day3_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest5AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest5.setText("00:00");
                        day3Rest5AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest5AdvancedFinishButton:
                advanced_day3_rest5_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex6AdvancedStartButton:
                advanced_day3_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex6AdvancedStartButton.setVisibility(View.GONE);
                day3Ex6AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex6AdvancedNextButton:
                advanced_day3_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest6AdvancedStartButton:
                advanced_day3_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest6AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest6.setText("00:00");
                        day3Rest6AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest6AdvancedFinishButton:
                advanced_day3_rest6_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex7AdvancedStartButton:
                advanced_day3_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex7AdvancedStartButton.setVisibility(View.GONE);
                day3Ex7AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex7AdvancedNextButton:
                advanced_day3_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest7AdvancedStartButton:
                advanced_day3_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest7AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest7.setText("00:00");
                        day3Rest7AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest7AdvancedFinishButton:
                advanced_day3_rest7_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex8AdvancedStartButton:
                advanced_day3_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex8AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_ex8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_ex8.setText("00:00");
                        day3Ex8AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex8AdvancedNextButton:
                advanced_day3_rest8_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest8AdvancedStartButton:
                advanced_day3_rest8_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest8AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_rest8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_rest8.setText("00:00");
                        day3Rest8AdvancedFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Rest8AdvancedFinishButton:
                advanced_day3_rest8_layout.setVisibility(View.GONE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                advanced_day3_ex9_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex9AdvancedStartButton:
                advanced_day3_ex9_layout.setVisibility(View.VISIBLE);
                advanced_day3_ex1_layout.setVisibility(View.GONE);
                advanced_day3_ex2_layout.setVisibility(View.GONE);
                advanced_day3_ex3_layout.setVisibility(View.GONE);
                advanced_day3_ex4_layout.setVisibility(View.GONE);
                advanced_day3_ex5_layout.setVisibility(View.GONE);
                advanced_day3_ex6_layout.setVisibility(View.GONE);
                advanced_day3_ex7_layout.setVisibility(View.GONE);
                advanced_day3_ex8_layout.setVisibility(View.GONE);
                day3Ex9AdvancedStartButton.setVisibility(View.GONE);
                new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_advanced_day3_ex9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_advanced_day3_ex9.setText("00:00");
                        day3Ex9AdvancedNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day3Ex9AdvancedNextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3AdvancedActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3AdvancedActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3AdvancedActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

            case R.id.aboutDay3Ex1AdvancedButton:
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

            case R.id.aboutDay3Ex2AdvancedButton:
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

            case R.id.aboutDay3Ex3AdvancedButton:
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

            case R.id.aboutDay3Ex4AdvancedButton:
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

            case R.id.aboutDay3Ex5AdvancedButton:
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

            case R.id.aboutDay3Ex6AdvancedButton:
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

            case R.id.aboutDay3Ex7AdvancedButton:
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

            case R.id.aboutDay3Ex8AdvancedButton:
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

            case R.id.aboutDay3Ex9AdvancedButton:
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