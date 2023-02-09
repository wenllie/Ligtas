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

public class Day5IntermediateActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day5IntermediateBackButton;
    AppCompatButton day5Ex1IntermediateStartButton, day5Ex2IntermediateStartButton, day5Ex3IntermediateStartButton, day5Ex4IntermediateStartButton;
    AppCompatButton day5Ex5IntermediateStartButton, day5Ex6IntermediateStartButton, day5Ex7IntermediateStartButton, day5Ex8IntermediateStartButton, day5Ex9IntermediateStartButton;
    AppCompatButton day5Ex1IntermediateNextButton, day5Ex2IntermediateNextButton, day5Ex3IntermediateNextButton, day5Ex4IntermediateNextButton;
    AppCompatButton day5Ex5IntermediateNextButton, day5Ex6IntermediateNextButton, day5Ex7IntermediateNextButton, day5Ex8IntermediateNextButton, day5Ex9IntermediateNextButton;
    AppCompatImageView aboutDay5Ex1IntermediateButton, aboutDay5Ex2IntermediateButton, aboutDay5Ex3IntermediateButton, aboutDay5Ex4IntermediateButton, aboutDay5Ex5IntermediateButton;
    AppCompatImageView aboutDay5Ex6IntermediateButton, aboutDay5Ex7IntermediateButton, aboutDay5Ex8IntermediateButton, aboutDay5Ex9IntermediateButton;
    AppCompatImageView intermediate_day5_ex1_photo, intermediate_day5_ex2_photo, intermediate_day5_ex3_photo, intermediate_day5_ex4_photo, intermediate_day5_ex5_photo;
    AppCompatImageView intermediate_day5_ex6_photo, intermediate_day5_ex7_photo, intermediate_day5_ex8_photo, intermediate_day5_ex9_photo;
    FrameLayout intermediate_day5_ex1_layout, intermediate_day5_ex2_layout, intermediate_day5_ex3_layout, intermediate_day5_ex4_layout, intermediate_day5_ex5_layout;
    FrameLayout intermediate_day5_ex6_layout, intermediate_day5_ex7_layout, intermediate_day5_ex8_layout, intermediate_day5_ex9_layout;
    FrameLayout intermediate_day5_rest1_layout, intermediate_day5_rest2_layout, intermediate_day5_rest3_layout, intermediate_day5_rest4_layout;
    FrameLayout intermediate_day5_rest5_layout, intermediate_day5_rest6_layout, intermediate_day5_rest7_layout, intermediate_day5_rest8_layout;
    AppCompatButton day5Rest1IntermediateStartButton, day5Rest2IntermediateStartButton, day5Rest3IntermediateStartButton, day5Rest4IntermediateStartButton;
    AppCompatButton day5Rest5IntermediateStartButton, day5Rest6IntermediateStartButton, day5Rest7IntermediateStartButton, day5Rest8IntermediateStartButton;
    AppCompatButton day5Rest1IntermediateFinishButton, day5Rest2IntermediateFinishButton, day5Rest3IntermediateFinishButton, day5Rest4IntermediateFinishButton;
    AppCompatButton day5Rest5IntermediateFinishButton, day5Rest6IntermediateFinishButton, day5Rest7IntermediateFinishButton, day5Rest8IntermediateFinishButton;
    AppCompatTextView timer_intermediate_day5_ex4, timer_intermediate_day5_ex5, timer_intermediate_day5_ex9;
    AppCompatTextView timer_intermediate_day5_rest1, timer_intermediate_day5_rest2, timer_intermediate_day5_rest3, timer_intermediate_day5_rest4;
    AppCompatTextView timer_intermediate_day5_rest5, timer_intermediate_day5_rest6, timer_intermediate_day5_rest7, timer_intermediate_day5_rest8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5_intermediate);

        day5IntermediateBackButton = findViewById(R.id.day5IntermediateBackButton);

        aboutDay5Ex1IntermediateButton = findViewById(R.id.aboutDay5Ex1IntermediateButton);
        aboutDay5Ex2IntermediateButton = findViewById(R.id.aboutDay5Ex2IntermediateButton);
        aboutDay5Ex3IntermediateButton = findViewById(R.id.aboutDay5Ex3IntermediateButton);
        aboutDay5Ex4IntermediateButton = findViewById(R.id.aboutDay5Ex4IntermediateButton);
        aboutDay5Ex5IntermediateButton = findViewById(R.id.aboutDay5Ex5IntermediateButton);
        aboutDay5Ex6IntermediateButton = findViewById(R.id.aboutDay5Ex6IntermediateButton);
        aboutDay5Ex7IntermediateButton = findViewById(R.id.aboutDay5Ex7IntermediateButton);
        aboutDay5Ex8IntermediateButton = findViewById(R.id.aboutDay5Ex8IntermediateButton);
        aboutDay5Ex9IntermediateButton = findViewById(R.id.aboutDay5Ex9IntermediateButton);

        day5Ex1IntermediateStartButton = findViewById(R.id.day5Ex1IntermediateStartButton);
        day5Ex2IntermediateStartButton = findViewById(R.id.day5Ex2IntermediateStartButton);
        day5Ex3IntermediateStartButton = findViewById(R.id.day5Ex3IntermediateStartButton);
        day5Ex4IntermediateStartButton = findViewById(R.id.day5Ex4IntermediateStartButton);
        day5Ex5IntermediateStartButton = findViewById(R.id.day5Ex5IntermediateStartButton);
        day5Ex6IntermediateStartButton = findViewById(R.id.day5Ex6IntermediateStartButton);
        day5Ex7IntermediateStartButton = findViewById(R.id.day5Ex7IntermediateStartButton);
        day5Ex8IntermediateStartButton = findViewById(R.id.day5Ex8IntermediateStartButton);
        day5Ex9IntermediateStartButton = findViewById(R.id.day5Ex9IntermediateStartButton);

        day5Ex1IntermediateNextButton = findViewById(R.id.day5Ex1IntermediateNextButton);
        day5Ex2IntermediateNextButton = findViewById(R.id.day5Ex2IntermediateNextButton);
        day5Ex3IntermediateNextButton = findViewById(R.id.day5Ex3IntermediateNextButton);
        day5Ex4IntermediateNextButton = findViewById(R.id.day5Ex4IntermediateNextButton);
        day5Ex5IntermediateNextButton = findViewById(R.id.day5Ex5IntermediateNextButton);
        day5Ex6IntermediateNextButton = findViewById(R.id.day5Ex6IntermediateNextButton);
        day5Ex7IntermediateNextButton = findViewById(R.id.day5Ex7IntermediateNextButton);
        day5Ex8IntermediateNextButton = findViewById(R.id.day5Ex8IntermediateNextButton);
        day5Ex9IntermediateNextButton = findViewById(R.id.day5Ex9IntermediateNextButton);

        intermediate_day5_ex1_layout = findViewById(R.id.intermediate_day5_ex1_layout);
        intermediate_day5_ex2_layout = findViewById(R.id.intermediate_day5_ex2_layout);
        intermediate_day5_ex3_layout = findViewById(R.id.intermediate_day5_ex3_layout);
        intermediate_day5_ex4_layout = findViewById(R.id.intermediate_day5_ex4_layout);
        intermediate_day5_ex5_layout = findViewById(R.id.intermediate_day5_ex5_layout);
        intermediate_day5_ex6_layout = findViewById(R.id.intermediate_day5_ex6_layout);
        intermediate_day5_ex7_layout = findViewById(R.id.intermediate_day5_ex7_layout);
        intermediate_day5_ex8_layout = findViewById(R.id.intermediate_day5_ex8_layout);
        intermediate_day5_ex9_layout = findViewById(R.id.intermediate_day5_ex9_layout);

        intermediate_day5_rest1_layout = findViewById(R.id.intermediate_day5_rest1_layout);
        intermediate_day5_rest2_layout = findViewById(R.id.intermediate_day5_rest2_layout);
        intermediate_day5_rest3_layout = findViewById(R.id.intermediate_day5_rest3_layout);
        intermediate_day5_rest4_layout = findViewById(R.id.intermediate_day5_rest4_layout);
        intermediate_day5_rest5_layout = findViewById(R.id.intermediate_day5_rest5_layout);
        intermediate_day5_rest6_layout = findViewById(R.id.intermediate_day5_rest6_layout);
        intermediate_day5_rest7_layout = findViewById(R.id.intermediate_day5_rest7_layout);
        intermediate_day5_rest8_layout = findViewById(R.id.intermediate_day5_rest8_layout);

        day5Rest1IntermediateStartButton = findViewById(R.id.day5Rest1IntermediateStartButton);
        day5Rest2IntermediateStartButton = findViewById(R.id.day5Rest2IntermediateStartButton);
        day5Rest3IntermediateStartButton = findViewById(R.id.day5Rest3IntermediateStartButton);
        day5Rest4IntermediateStartButton = findViewById(R.id.day5Rest4IntermediateStartButton);
        day5Rest5IntermediateStartButton = findViewById(R.id.day5Rest5IntermediateStartButton);
        day5Rest6IntermediateStartButton = findViewById(R.id.day5Rest6IntermediateStartButton);
        day5Rest7IntermediateStartButton = findViewById(R.id.day5Rest7IntermediateStartButton);
        day5Rest8IntermediateStartButton = findViewById(R.id.day5Rest8IntermediateStartButton);

        day5Rest1IntermediateFinishButton = findViewById(R.id.day5Rest1IntermediateFinishButton);
        day5Rest2IntermediateFinishButton = findViewById(R.id.day5Rest2IntermediateFinishButton);
        day5Rest3IntermediateFinishButton = findViewById(R.id.day5Rest3IntermediateFinishButton);
        day5Rest4IntermediateFinishButton = findViewById(R.id.day5Rest4IntermediateFinishButton);
        day5Rest5IntermediateFinishButton = findViewById(R.id.day5Rest5IntermediateFinishButton);
        day5Rest6IntermediateFinishButton = findViewById(R.id.day5Rest6IntermediateFinishButton);
        day5Rest7IntermediateFinishButton = findViewById(R.id.day5Rest7IntermediateFinishButton);
        day5Rest8IntermediateFinishButton = findViewById(R.id.day5Rest8IntermediateFinishButton);

        intermediate_day5_ex1_photo = findViewById(R.id.intermediate_day5_ex1_photo);
        intermediate_day5_ex2_photo = findViewById(R.id.intermediate_day5_ex2_photo);
        intermediate_day5_ex3_photo = findViewById(R.id.intermediate_day5_ex3_photo);
        intermediate_day5_ex4_photo = findViewById(R.id.intermediate_day5_ex4_photo);
        intermediate_day5_ex5_photo = findViewById(R.id.intermediate_day5_ex5_photo);
        intermediate_day5_ex6_photo = findViewById(R.id.intermediate_day5_ex6_photo);
        intermediate_day5_ex7_photo = findViewById(R.id.intermediate_day5_ex7_photo);
        intermediate_day5_ex8_photo = findViewById(R.id.intermediate_day5_ex8_photo);
        intermediate_day5_ex9_photo = findViewById(R.id.intermediate_day5_ex9_photo);

        timer_intermediate_day5_ex4 = findViewById(R.id.timer_intermediate_day5_ex4);
        timer_intermediate_day5_ex5 = findViewById(R.id.timer_intermediate_day5_ex5);
        timer_intermediate_day5_ex9 = findViewById(R.id.timer_intermediate_day5_ex9);

        timer_intermediate_day5_rest1 = findViewById(R.id.timer_intermediate_day5_rest1);
        timer_intermediate_day5_rest2 = findViewById(R.id.timer_intermediate_day5_rest2);
        timer_intermediate_day5_rest3 = findViewById(R.id.timer_intermediate_day5_rest3);
        timer_intermediate_day5_rest4 = findViewById(R.id.timer_intermediate_day5_rest4);
        timer_intermediate_day5_rest5 = findViewById(R.id.timer_intermediate_day5_rest5);
        timer_intermediate_day5_rest6 = findViewById(R.id.timer_intermediate_day5_rest6);
        timer_intermediate_day5_rest7 = findViewById(R.id.timer_intermediate_day5_rest7);
        timer_intermediate_day5_rest8 = findViewById(R.id.timer_intermediate_day5_rest8);

        Glide.with(this).load(R.drawable.spider_man_mountain_climbers_exercise).into(intermediate_day5_ex1_photo);
        Glide.with(this).load(R.drawable.donkey_kicks_exercise).into(intermediate_day5_ex2_photo);
        Glide.with(this).load(R.drawable.wide_grip_push_ups_exercise).into(intermediate_day5_ex3_photo);
        Glide.with(this).load(R.drawable.plank_jacks_exercise).into(intermediate_day5_ex4_photo);
        Glide.with(this).load(R.drawable.lateral_plank_walks_exercise).into(intermediate_day5_ex5_photo);
        Glide.with(this).load(R.drawable.push_ups).into(intermediate_day5_ex6_photo);
        Glide.with(this).load(R.drawable.plank_ups).into(intermediate_day5_ex7_photo);
        Glide.with(this).load(R.drawable.side_leg_kickbacks).into(intermediate_day5_ex8_photo);
        Glide.with(this).load(R.drawable.plank_taps).into(intermediate_day5_ex9_photo);

        day5IntermediateBackButton.setOnClickListener(this);

        day5Ex1IntermediateStartButton.setOnClickListener(this);
        day5Ex2IntermediateStartButton.setOnClickListener(this);
        day5Ex3IntermediateStartButton.setOnClickListener(this);
        day5Ex4IntermediateStartButton.setOnClickListener(this);
        day5Ex5IntermediateStartButton.setOnClickListener(this);
        day5Ex6IntermediateStartButton.setOnClickListener(this);
        day5Ex7IntermediateStartButton.setOnClickListener(this);
        day5Ex8IntermediateStartButton.setOnClickListener(this);
        day5Ex9IntermediateStartButton.setOnClickListener(this);

        day5Ex1IntermediateNextButton.setOnClickListener(this);
        day5Ex2IntermediateNextButton.setOnClickListener(this);
        day5Ex3IntermediateNextButton.setOnClickListener(this);
        day5Ex4IntermediateNextButton.setOnClickListener(this);
        day5Ex5IntermediateNextButton.setOnClickListener(this);
        day5Ex6IntermediateNextButton.setOnClickListener(this);
        day5Ex7IntermediateNextButton.setOnClickListener(this);
        day5Ex8IntermediateNextButton.setOnClickListener(this);
        day5Ex9IntermediateNextButton.setOnClickListener(this);

        aboutDay5Ex1IntermediateButton.setOnClickListener(this);
        aboutDay5Ex2IntermediateButton.setOnClickListener(this);
        aboutDay5Ex3IntermediateButton.setOnClickListener(this);
        aboutDay5Ex4IntermediateButton.setOnClickListener(this);
        aboutDay5Ex5IntermediateButton.setOnClickListener(this);
        aboutDay5Ex6IntermediateButton.setOnClickListener(this);
        aboutDay5Ex7IntermediateButton.setOnClickListener(this);
        aboutDay5Ex8IntermediateButton.setOnClickListener(this);
        aboutDay5Ex9IntermediateButton.setOnClickListener(this);

        day5Rest1IntermediateStartButton.setOnClickListener(this);
        day5Rest2IntermediateStartButton.setOnClickListener(this);
        day5Rest3IntermediateStartButton.setOnClickListener(this);
        day5Rest4IntermediateStartButton.setOnClickListener(this);
        day5Rest5IntermediateStartButton.setOnClickListener(this);
        day5Rest6IntermediateStartButton.setOnClickListener(this);
        day5Rest7IntermediateStartButton.setOnClickListener(this);
        day5Rest8IntermediateStartButton.setOnClickListener(this);

        day5Rest1IntermediateFinishButton.setOnClickListener(this);
        day5Rest2IntermediateFinishButton.setOnClickListener(this);
        day5Rest3IntermediateFinishButton.setOnClickListener(this);
        day5Rest4IntermediateFinishButton.setOnClickListener(this);
        day5Rest5IntermediateFinishButton.setOnClickListener(this);
        day5Rest6IntermediateFinishButton.setOnClickListener(this);
        day5Rest7IntermediateFinishButton.setOnClickListener(this);
        day5Rest8IntermediateFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day5IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

            case R.id.day5IntermediateBackButton:
                onBackPressed();
                break;

            case R.id.day5Ex1IntermediateStartButton:
                intermediate_day5_ex1_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex1IntermediateStartButton.setVisibility(View.GONE);
                day5Ex1IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex1IntermediateNextButton:
                intermediate_day5_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest1IntermediateStartButton:
                intermediate_day5_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest1IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest1.setText("00:00");
                        day5Rest1IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest1IntermediateFinishButton:
                intermediate_day5_rest1_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex2IntermediateStartButton:
                intermediate_day5_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex2IntermediateStartButton.setVisibility(View.GONE);
                day5Ex2IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex2IntermediateNextButton:
                intermediate_day5_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest2IntermediateStartButton:
                intermediate_day5_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest2IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest2.setText("00:00");
                        day5Rest2IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest2IntermediateFinishButton:
                intermediate_day5_rest2_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex3IntermediateStartButton:
                intermediate_day5_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex3IntermediateStartButton.setVisibility(View.GONE);
                day5Ex3IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex3IntermediateNextButton:
                intermediate_day5_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest3IntermediateStartButton:
                intermediate_day5_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest3IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest3.setText("00:00");
                        day5Rest3IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest3IntermediateFinishButton:
                intermediate_day5_rest3_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex4IntermediateStartButton:
                intermediate_day5_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex4IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_ex4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_ex4.setText("00:00");
                        day5Ex4IntermediateNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex4IntermediateNextButton:
                intermediate_day5_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest4IntermediateStartButton:
                intermediate_day5_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest4IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest4.setText("00:00");
                        day5Rest4IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest4IntermediateFinishButton:
                intermediate_day5_rest4_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex5IntermediateStartButton:
                intermediate_day5_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex5IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_ex5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_ex5.setText("00:00");
                        day5Ex5IntermediateNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex5IntermediateNextButton:
                intermediate_day5_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest5IntermediateStartButton:
                intermediate_day5_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest5IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest5.setText("00:00");
                        day5Rest5IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest5IntermediateFinishButton:
                intermediate_day5_rest5_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex6IntermediateStartButton:
                intermediate_day5_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex6IntermediateStartButton.setVisibility(View.GONE);
                day5Ex6IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex6IntermediateNextButton:
                intermediate_day5_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest6IntermediateStartButton:
                intermediate_day5_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest6IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest6.setText("00:00");
                        day5Rest6IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest6IntermediateFinishButton:
                intermediate_day5_rest6_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex7IntermediateStartButton:
                intermediate_day5_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex7IntermediateStartButton.setVisibility(View.GONE);
                day5Ex7IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex7IntermediateNextButton:
                intermediate_day5_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest7IntermediateStartButton:
                intermediate_day5_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest7IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest7.setText("00:00");
                        day5Rest7IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest7IntermediateFinishButton:
                intermediate_day5_rest7_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Ex8IntermediateStartButton:
                intermediate_day5_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Ex8IntermediateStartButton.setVisibility(View.GONE);
                day5Ex8IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex8IntermediateNextButton:
                intermediate_day5_rest8_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day5Rest8IntermediateStartButton:
                intermediate_day5_rest8_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.GONE);
                day5Rest8IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_rest8.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_rest8.setText("00:00");
                        day5Rest8IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Rest8IntermediateFinishButton:
                intermediate_day5_rest8_layout.setVisibility(View.GONE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                intermediate_day5_ex9_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day5Ex9IntermediateStartButton:
                intermediate_day5_ex9_layout.setVisibility(View.VISIBLE);
                intermediate_day5_ex1_layout.setVisibility(View.GONE);
                intermediate_day5_ex2_layout.setVisibility(View.GONE);
                intermediate_day5_ex3_layout.setVisibility(View.GONE);
                intermediate_day5_ex4_layout.setVisibility(View.GONE);
                intermediate_day5_ex5_layout.setVisibility(View.GONE);
                intermediate_day5_ex6_layout.setVisibility(View.GONE);
                intermediate_day5_ex7_layout.setVisibility(View.GONE);
                intermediate_day5_ex8_layout.setVisibility(View.GONE);
                day5Ex9IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day5_ex9.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day5_ex9.setText("00:00");
                        day5Ex9IntermediateNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day5Ex9IntermediateNextButton:

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

                                                        if (typeKey.equalsIgnoreCase("Intermediate")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5IntermediateActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                        if (typeKey.equalsIgnoreCase("Intermediate")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5IntermediateActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                        if (typeKey.equalsIgnoreCase("Intermediate")) {

                                                            for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                                String dayKey = daySnap.getKey();

                                                                if (dayKey.equalsIgnoreCase("Day 5")) {

                                                                    Toast.makeText(Day5IntermediateActivity.this, "You're already done for day 5!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 5").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day5IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

            case R.id.aboutDay5Ex1IntermediateButton:
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

            case R.id.aboutDay5Ex2IntermediateButton:
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

            case R.id.aboutDay5Ex3IntermediateButton:
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

            case R.id.aboutDay5Ex4IntermediateButton:
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

            case R.id.aboutDay5Ex5IntermediateButton:
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

            case R.id.aboutDay5Ex6IntermediateButton:
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

            case R.id.aboutDay5Ex7IntermediateButton:
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

            case R.id.aboutDay5Ex8IntermediateButton:
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

            case R.id.aboutDay5Ex9IntermediateButton:
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