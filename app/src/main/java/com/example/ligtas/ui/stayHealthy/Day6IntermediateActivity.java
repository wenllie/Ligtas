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

public class Day6IntermediateActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day6IntermediateBackButton;
    AppCompatButton day6Ex1IntermediateStartButton, day6Ex2IntermediateStartButton, day6Ex3IntermediateStartButton, day6Ex4IntermediateStartButton;
    AppCompatButton day6Ex5IntermediateStartButton, day6Ex6IntermediateStartButton, day6Ex7IntermediateStartButton, day6Ex8IntermediateStartButton;
    AppCompatButton day6Ex1IntermediateNextButton, day6Ex2IntermediateNextButton, day6Ex3IntermediateNextButton, day6Ex4IntermediateNextButton;
    AppCompatButton day6Ex5IntermediateNextButton, day6Ex6IntermediateNextButton, day6Ex7IntermediateNextButton, day6Ex8IntermediateNextButton;
    AppCompatImageView aboutDay6Ex1IntermediateButton, aboutDay6Ex6IntermediateButton, aboutDay6Ex3IntermediateButton, aboutDay6Ex4IntermediateButton;
    AppCompatImageView aboutDay6Ex5IntermediateButton, aboutDay6Ex2IntermediateButton, aboutDay6Ex7IntermediateButton, aboutDay6Ex8IntermediateButton;
    AppCompatImageView intermediate_day6_ex1_photo, intermediate_day6_ex2_photo, intermediate_day6_ex3_photo, intermediate_day6_ex4_photo;
    AppCompatImageView intermediate_day6_ex5_photo, intermediate_day6_ex6_photo, intermediate_day6_ex7_photo, intermediate_day6_ex8_photo;
    FrameLayout intermediate_day6_ex1_layout, intermediate_day6_ex2_layout, intermediate_day6_ex3_layout, intermediate_day6_ex4_layout;
    FrameLayout intermediate_day6_ex5_layout, intermediate_day6_ex6_layout, intermediate_day6_ex7_layout, intermediate_day6_ex8_layout;
    FrameLayout intermediate_day6_rest1_layout, intermediate_day6_rest2_layout, intermediate_day6_rest3_layout;
    FrameLayout intermediate_day6_rest4_layout, intermediate_day6_rest5_layout, intermediate_day6_rest6_layout, intermediate_day6_rest7_layout;
    AppCompatButton day6Rest1IntermediateStartButton, day6Rest2IntermediateStartButton, day6Rest3IntermediateStartButton;
    AppCompatButton day6Rest4IntermediateStartButton, day6Rest5IntermediateStartButton, day6Rest6IntermediateStartButton, day6Rest7IntermediateStartButton;
    AppCompatButton day6Rest1IntermediateFinishButton, day6Rest2IntermediateFinishButton, day6Rest3IntermediateFinishButton;
    AppCompatButton day6Rest4IntermediateFinishButton, day6Rest5IntermediateFinishButton, day6Rest6IntermediateFinishButton, day6Rest7IntermediateFinishButton;
    AppCompatTextView timer_intermediate_day6_ex3, timer_intermediate_day6_ex7;
    AppCompatTextView timer_intermediate_day6_rest1, timer_intermediate_day6_rest2, timer_intermediate_day6_rest3, timer_intermediate_day6_rest4;
    AppCompatTextView timer_intermediate_day6_rest5, timer_intermediate_day6_rest6, timer_intermediate_day6_rest7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_intermediate);

        day6IntermediateBackButton = findViewById(R.id.day6IntermediateBackButton);

        day6Ex1IntermediateStartButton = findViewById(R.id.day6Ex1IntermediateStartButton);
        day6Ex2IntermediateStartButton = findViewById(R.id.day6Ex2IntermediateStartButton);
        day6Ex3IntermediateStartButton = findViewById(R.id.day6Ex3IntermediateStartButton);
        day6Ex4IntermediateStartButton = findViewById(R.id.day6Ex4IntermediateStartButton);
        day6Ex5IntermediateStartButton = findViewById(R.id.day6Ex5IntermediateStartButton);
        day6Ex6IntermediateStartButton = findViewById(R.id.day6Ex6IntermediateStartButton);
        day6Ex7IntermediateStartButton = findViewById(R.id.day6Ex7IntermediateStartButton);
        day6Ex8IntermediateStartButton = findViewById(R.id.day6Ex8IntermediateStartButton);

        day6Ex1IntermediateNextButton = findViewById(R.id.day6Ex1IntermediateNextButton);
        day6Ex2IntermediateNextButton = findViewById(R.id.day6Ex2IntermediateNextButton);
        day6Ex3IntermediateNextButton = findViewById(R.id.day6Ex3IntermediateNextButton);
        day6Ex4IntermediateNextButton = findViewById(R.id.day6Ex4IntermediateNextButton);
        day6Ex5IntermediateNextButton = findViewById(R.id.day6Ex5IntermediateNextButton);
        day6Ex6IntermediateNextButton = findViewById(R.id.day6Ex6IntermediateNextButton);
        day6Ex7IntermediateNextButton = findViewById(R.id.day6Ex7IntermediateNextButton);
        day6Ex8IntermediateNextButton = findViewById(R.id.day6Ex8IntermediateNextButton);

        aboutDay6Ex1IntermediateButton = findViewById(R.id.aboutDay6Ex1IntermediateButton);
        aboutDay6Ex2IntermediateButton = findViewById(R.id.aboutDay6Ex2IntermediateButton);
        aboutDay6Ex3IntermediateButton = findViewById(R.id.aboutDay6Ex3IntermediateButton);
        aboutDay6Ex4IntermediateButton = findViewById(R.id.aboutDay6Ex4IntermediateButton);
        aboutDay6Ex5IntermediateButton = findViewById(R.id.aboutDay6Ex5IntermediateButton);
        aboutDay6Ex6IntermediateButton = findViewById(R.id.aboutDay6Ex6IntermediateButton);
        aboutDay6Ex7IntermediateButton = findViewById(R.id.aboutDay6Ex7IntermediateButton);
        aboutDay6Ex8IntermediateButton = findViewById(R.id.aboutDay6Ex8IntermediateButton);

        intermediate_day6_ex1_layout = findViewById(R.id.intermediate_day6_ex1_layout);
        intermediate_day6_ex2_layout = findViewById(R.id.intermediate_day6_ex2_layout);
        intermediate_day6_ex3_layout = findViewById(R.id.intermediate_day6_ex3_layout);
        intermediate_day6_ex4_layout = findViewById(R.id.intermediate_day6_ex4_layout);
        intermediate_day6_ex5_layout = findViewById(R.id.intermediate_day6_ex5_layout);
        intermediate_day6_ex6_layout = findViewById(R.id.intermediate_day6_ex6_layout);
        intermediate_day6_ex7_layout = findViewById(R.id.intermediate_day6_ex7_layout);
        intermediate_day6_ex8_layout = findViewById(R.id.intermediate_day6_ex8_layout);

        intermediate_day6_ex1_photo = findViewById(R.id.intermediate_day6_ex1_photo);
        intermediate_day6_ex2_photo = findViewById(R.id.intermediate_day6_ex2_photo);
        intermediate_day6_ex3_photo = findViewById(R.id.intermediate_day6_ex3_photo);
        intermediate_day6_ex4_photo = findViewById(R.id.intermediate_day6_ex4_photo);
        intermediate_day6_ex5_photo = findViewById(R.id.intermediate_day6_ex5_photo);
        intermediate_day6_ex6_photo = findViewById(R.id.intermediate_day6_ex6_photo);
        intermediate_day6_ex7_photo = findViewById(R.id.intermediate_day6_ex7_photo);
        intermediate_day6_ex8_photo = findViewById(R.id.intermediate_day6_ex8_photo);

        intermediate_day6_rest1_layout = findViewById(R.id.intermediate_day6_rest1_layout);
        intermediate_day6_rest2_layout = findViewById(R.id.intermediate_day6_rest2_layout);
        intermediate_day6_rest3_layout = findViewById(R.id.intermediate_day6_rest3_layout);
        intermediate_day6_rest4_layout = findViewById(R.id.intermediate_day6_rest4_layout);
        intermediate_day6_rest5_layout = findViewById(R.id.intermediate_day6_rest5_layout);
        intermediate_day6_rest6_layout = findViewById(R.id.intermediate_day6_rest6_layout);
        intermediate_day6_rest7_layout = findViewById(R.id.intermediate_day6_rest7_layout);

        day6Rest1IntermediateStartButton = findViewById(R.id.day6Rest1IntermediateStartButton);
        day6Rest2IntermediateStartButton = findViewById(R.id.day6Rest2IntermediateStartButton);
        day6Rest3IntermediateStartButton = findViewById(R.id.day6Rest3IntermediateStartButton);
        day6Rest4IntermediateStartButton = findViewById(R.id.day6Rest4IntermediateStartButton);
        day6Rest5IntermediateStartButton = findViewById(R.id.day6Rest5IntermediateStartButton);
        day6Rest6IntermediateStartButton = findViewById(R.id.day6Rest6IntermediateStartButton);
        day6Rest7IntermediateStartButton = findViewById(R.id.day6Rest7IntermediateStartButton);

        day6Rest1IntermediateFinishButton = findViewById(R.id.day6Rest1IntermediateFinishButton);
        day6Rest2IntermediateFinishButton = findViewById(R.id.day6Rest2IntermediateFinishButton);
        day6Rest3IntermediateFinishButton = findViewById(R.id.day6Rest3IntermediateFinishButton);
        day6Rest4IntermediateFinishButton = findViewById(R.id.day6Rest4IntermediateFinishButton);
        day6Rest5IntermediateFinishButton = findViewById(R.id.day6Rest5IntermediateFinishButton);
        day6Rest6IntermediateFinishButton = findViewById(R.id.day6Rest6IntermediateFinishButton);
        day6Rest7IntermediateFinishButton = findViewById(R.id.day6Rest7IntermediateFinishButton);

        timer_intermediate_day6_ex3 = findViewById(R.id.timer_intermediate_day6_ex3);
        timer_intermediate_day6_ex7 = findViewById(R.id.timer_intermediate_day6_ex7);

        timer_intermediate_day6_rest1 = findViewById(R.id.timer_intermediate_day6_rest1);
        timer_intermediate_day6_rest2 = findViewById(R.id.timer_intermediate_day6_rest2);
        timer_intermediate_day6_rest3 = findViewById(R.id.timer_intermediate_day6_rest3);
        timer_intermediate_day6_rest4 = findViewById(R.id.timer_intermediate_day6_rest4);
        timer_intermediate_day6_rest5 = findViewById(R.id.timer_intermediate_day6_rest5);
        timer_intermediate_day6_rest6 = findViewById(R.id.timer_intermediate_day6_rest6);
        timer_intermediate_day6_rest7 = findViewById(R.id.timer_intermediate_day6_rest7);

        Glide.with(this).load(R.drawable.reverse_lunges_exercise).into(intermediate_day6_ex1_photo);
        Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day6_ex2_photo);
        Glide.with(this).load(R.drawable.high_knees_exercise).into(intermediate_day6_ex3_photo);
        Glide.with(this).load(R.drawable.side_lunges_exercise).into(intermediate_day6_ex4_photo);
        Glide.with(this).load(R.drawable.side_step_squats_exercise).into(intermediate_day6_ex5_photo);
        Glide.with(this).load(R.drawable.forward_to_reverse_lunges_exercise).into(intermediate_day6_ex6_photo);
        Glide.with(this).load(R.drawable.jump_squats).into(intermediate_day6_ex7_photo);
        Glide.with(this).load(R.drawable.jumping_lunges).into(intermediate_day6_ex8_photo);

        day6IntermediateBackButton.setOnClickListener(this);

        day6Ex1IntermediateStartButton.setOnClickListener(this);
        day6Ex2IntermediateStartButton.setOnClickListener(this);
        day6Ex3IntermediateStartButton.setOnClickListener(this);
        day6Ex4IntermediateStartButton.setOnClickListener(this);
        day6Ex5IntermediateStartButton.setOnClickListener(this);
        day6Ex6IntermediateStartButton.setOnClickListener(this);
        day6Ex7IntermediateStartButton.setOnClickListener(this);
        day6Ex8IntermediateStartButton.setOnClickListener(this);

        day6Ex1IntermediateNextButton.setOnClickListener(this);
        day6Ex2IntermediateNextButton.setOnClickListener(this);
        day6Ex3IntermediateNextButton.setOnClickListener(this);
        day6Ex4IntermediateNextButton.setOnClickListener(this);
        day6Ex5IntermediateNextButton.setOnClickListener(this);
        day6Ex6IntermediateNextButton.setOnClickListener(this);
        day6Ex7IntermediateNextButton.setOnClickListener(this);
        day6Ex8IntermediateNextButton.setOnClickListener(this);

        aboutDay6Ex1IntermediateButton.setOnClickListener(this);
        aboutDay6Ex2IntermediateButton.setOnClickListener(this);
        aboutDay6Ex3IntermediateButton.setOnClickListener(this);
        aboutDay6Ex4IntermediateButton.setOnClickListener(this);
        aboutDay6Ex5IntermediateButton.setOnClickListener(this);
        aboutDay6Ex6IntermediateButton.setOnClickListener(this);
        aboutDay6Ex7IntermediateButton.setOnClickListener(this);
        aboutDay6Ex8IntermediateButton.setOnClickListener(this);

        day6Rest1IntermediateStartButton.setOnClickListener(this);
        day6Rest2IntermediateStartButton.setOnClickListener(this);
        day6Rest3IntermediateStartButton.setOnClickListener(this);
        day6Rest4IntermediateStartButton.setOnClickListener(this);
        day6Rest5IntermediateStartButton.setOnClickListener(this);
        day6Rest6IntermediateStartButton.setOnClickListener(this);
        day6Rest7IntermediateStartButton.setOnClickListener(this);

        day6Rest1IntermediateFinishButton.setOnClickListener(this);
        day6Rest2IntermediateFinishButton.setOnClickListener(this);
        day6Rest3IntermediateFinishButton.setOnClickListener(this);
        day6Rest4IntermediateFinishButton.setOnClickListener(this);
        day6Rest5IntermediateFinishButton.setOnClickListener(this);
        day6Rest6IntermediateFinishButton.setOnClickListener(this);
        day6Rest7IntermediateFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your exercise?\n\nNote: If you cancel your exercise, your data won't be save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent toStayHealthy = new Intent(Day6IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

            case R.id.day6IntermediateBackButton:
                onBackPressed();
                break;

            case R.id.day6Ex1IntermediateStartButton:
                intermediate_day6_ex1_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex1IntermediateStartButton.setVisibility(View.GONE);
                day6Ex1IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex1IntermediateNextButton:
                intermediate_day6_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest1IntermediateStartButton:
                intermediate_day6_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest1IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest1.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest1.setText("00:00");
                        day6Rest1IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest1IntermediateFinishButton:
                intermediate_day6_rest1_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);

                break;

            case R.id.day6Ex2IntermediateStartButton:
                intermediate_day6_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex2IntermediateStartButton.setVisibility(View.GONE);
                day6Ex2IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex2IntermediateNextButton:
                intermediate_day6_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest2IntermediateStartButton:
                intermediate_day6_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest2IntermediateStartButton.setVisibility(View.GONE);

                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest2.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest2.setText("00:00");
                        day6Rest2IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest2IntermediateFinishButton:
                intermediate_day6_rest2_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex3IntermediateStartButton:
                intermediate_day6_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex3IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_ex3.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_ex3.setText("00:00");
                        day6Ex3IntermediateNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Ex3IntermediateNextButton:
                intermediate_day6_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest3IntermediateStartButton:
                intermediate_day6_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest3IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest3.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest3.setText("00:00");
                        day6Rest3IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest3IntermediateFinishButton:
                intermediate_day6_rest3_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex4IntermediateStartButton:
                intermediate_day6_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex4IntermediateStartButton.setVisibility(View.GONE);
                day6Ex4IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex4IntermediateNextButton:
                intermediate_day6_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest4IntermediateStartButton:
                intermediate_day6_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest4IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest4.setText(f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest4.setText("00:00");
                        day6Rest4IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest4IntermediateFinishButton:
                intermediate_day6_rest4_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex5IntermediateStartButton:
                intermediate_day6_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex5IntermediateStartButton.setVisibility(View.GONE);
                day6Ex5IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex5IntermediateNextButton:
                intermediate_day6_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest5IntermediateStartButton:
                intermediate_day6_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest5IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest5.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest5.setText("00:00");
                        day6Rest5IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest5IntermediateFinishButton:
                intermediate_day6_rest5_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex6IntermediateStartButton:
                intermediate_day6_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex6IntermediateStartButton.setVisibility(View.GONE);
                day6Ex6IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex6IntermediateNextButton:
                intermediate_day6_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest6IntermediateStartButton:
                intermediate_day6_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest6IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest6.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest6.setText("00:00");
                        day6Rest6IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest6IntermediateFinishButton:
                intermediate_day6_rest6_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex7IntermediateStartButton:
                intermediate_day6_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex7IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_ex7.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_ex7.setText("00:00");
                        day6Ex7IntermediateNextButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Ex7IntermediateNextButton:
                intermediate_day6_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest7IntermediateStartButton:
                intermediate_day6_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest7IntermediateStartButton.setVisibility(View.GONE);
                new CountDownTimer(26000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        timer_intermediate_day6_rest7.setText(f.format(min) + ":" + f.format(sec));

                    }
                    // When the task is over it will print 00:00:00 there
                    public void onFinish() {
                        timer_intermediate_day6_rest7.setText("00:00");
                        day6Rest7IntermediateFinishButton.setVisibility(View.VISIBLE);
                    }
                }.start();
                break;

            case R.id.day6Rest7IntermediateFinishButton:
                intermediate_day6_rest7_layout.setVisibility(View.GONE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                intermediate_day6_ex8_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex8IntermediateStartButton:
                intermediate_day6_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day6_ex1_layout.setVisibility(View.GONE);
                intermediate_day6_ex2_layout.setVisibility(View.GONE);
                intermediate_day6_ex3_layout.setVisibility(View.GONE);
                intermediate_day6_ex4_layout.setVisibility(View.GONE);
                intermediate_day6_ex5_layout.setVisibility(View.GONE);
                intermediate_day6_ex6_layout.setVisibility(View.GONE);
                intermediate_day6_ex7_layout.setVisibility(View.GONE);
                day6Ex8IntermediateStartButton.setVisibility(View.GONE);
                day6Ex8IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex8IntermediateNextButton:

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

                                                            Toast.makeText(Day6IntermediateActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                            Toast.makeText(Day6IntermediateActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 6")) {

                                                                    Toast.makeText(Day6IntermediateActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

            case R.id.aboutDay6Ex1IntermediateButton:
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

            case R.id.aboutDay6Ex2IntermediateButton:
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

            case R.id.aboutDay6Ex3IntermediateButton:
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

            case R.id.aboutDay6Ex4IntermediateButton:
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

            case R.id.aboutDay6Ex5IntermediateButton:
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

            case R.id.aboutDay6Ex6IntermediateButton:
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

            case R.id.aboutDay6Ex7IntermediateButton:
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

            case R.id.aboutDay6Ex8IntermediateButton:
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