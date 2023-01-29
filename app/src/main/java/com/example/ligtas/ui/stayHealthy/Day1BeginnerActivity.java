package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public class Day1BeginnerActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day1BackButton;
    AppCompatButton day1Ex1StartButton, day1Ex2StartButton, day1Ex3StartButton, day1Ex4StartButton, day1Ex5StartButton, day1Ex6StartButton, day1Ex7StartButton, day1Ex8StartButton, day1Ex9StartButton, day1Ex10StartButton;
    AppCompatButton day1Ex1NextButton, day1Ex2NextButton, day1Ex3NextButton, day1Ex4NextButton, day1Ex5NextButton, day1Ex6NextButton, day1Ex7NextButton, day1Ex8NextButton, day1Ex9NextButton, day1Ex10NextButton;
    AppCompatImageView aboutDay1Ex1BeginnerButton, aboutDay1Ex2BeginnerButton, aboutDay1Ex3BeginnerButton, aboutDay1Ex4BeginnerButton, aboutDay1Ex5BeginnerButton;
    AppCompatImageView aboutDay1Ex6BeginnerButton, aboutDay1Ex7BeginnerButton, aboutDay1Ex8BeginnerButton, aboutDay1Ex9BeginnerButton, aboutDay1Ex10BeginnerButton;
    AppCompatImageView beginner_day1_ex1_photo, beginner_day1_ex2_photo, beginner_day1_ex3_photo, beginner_day1_ex4_photo, beginner_day1_ex5_photo;
    AppCompatImageView beginner_day1_ex6_photo, beginner_day1_ex7_photo, beginner_day1_ex8_photo, beginner_day1_ex9_photo, beginner_day1_ex10_photo;
    FrameLayout beginner_day1_ex1_layout, beginner_day1_ex2_layout, beginner_day1_ex3_layout, beginner_day1_ex4_layout, beginner_day1_ex5_layout;
    FrameLayout beginner_day1_ex6_layout, beginner_day1_ex7_layout, beginner_day1_ex8_layout, beginner_day1_ex9_layout, beginner_day1_ex10_layout;
    FrameLayout beginner_day1_rest1_layout, beginner_day1_rest2_layout, beginner_day1_rest3_layout, beginner_day1_rest4_layout;
    FrameLayout beginner_day1_rest5_layout, beginner_day1_rest6_layout, beginner_day1_rest7_layout, beginner_day1_rest8_layout, beginner_day1_rest9_layout;
    AppCompatButton day1Rest1StartButton, day1Rest2StartButton, day1Rest3StartButton, day1Rest4StartButton;
    AppCompatButton day1Rest5StartButton, day1Rest6StartButton, day1Rest7StartButton, day1Rest8StartButton, day1Rest9StartButton;
    AppCompatButton day1Rest1FinishButton, day1Rest2FinishButton, day1Rest3FinishButton, day1Rest4FinishButton;
    AppCompatButton day1Rest5FinishButton, day1Rest6FinishButton, day1Rest7FinishButton, day1Rest8FinishButton, day1Rest9FinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_beginner);

        day1BackButton = findViewById(R.id.day1BackButton);

        aboutDay1Ex1BeginnerButton = findViewById(R.id.aboutDay1Ex1BeginnerButton);
        aboutDay1Ex2BeginnerButton = findViewById(R.id.aboutDay1Ex2BeginnerButton);
        aboutDay1Ex3BeginnerButton = findViewById(R.id.aboutDay1Ex3BeginnerButton);
        aboutDay1Ex4BeginnerButton = findViewById(R.id.aboutDay1Ex4BeginnerButton);
        aboutDay1Ex5BeginnerButton = findViewById(R.id.aboutDay1Ex5BeginnerButton);
        aboutDay1Ex6BeginnerButton = findViewById(R.id.aboutDay1Ex6BeginnerButton);
        aboutDay1Ex7BeginnerButton = findViewById(R.id.aboutDay1Ex7BeginnerButton);
        aboutDay1Ex8BeginnerButton = findViewById(R.id.aboutDay1Ex8BeginnerButton);
        aboutDay1Ex9BeginnerButton = findViewById(R.id.aboutDay1Ex9BeginnerButton);
        aboutDay1Ex10BeginnerButton = findViewById(R.id.aboutDay1Ex10BeginnerButton);

        day1Ex1StartButton = findViewById(R.id.day1Ex1StartButton);
        day1Ex2StartButton = findViewById(R.id.day1Ex2StartButton);
        day1Ex3StartButton = findViewById(R.id.day1Ex3StartButton);
        day1Ex4StartButton = findViewById(R.id.day1Ex4StartButton);
        day1Ex5StartButton = findViewById(R.id.day1Ex5StartButton);
        day1Ex6StartButton = findViewById(R.id.day1Ex6StartButton);
        day1Ex7StartButton = findViewById(R.id.day1Ex7StartButton);
        day1Ex8StartButton = findViewById(R.id.day1Ex8StartButton);
        day1Ex9StartButton = findViewById(R.id.day1Ex9StartButton);
        day1Ex10StartButton = findViewById(R.id.day1Ex10StartButton);

        day1Ex1NextButton = findViewById(R.id.day1Ex1NextButton);
        day1Ex2NextButton = findViewById(R.id.day1Ex2NextButton);
        day1Ex3NextButton = findViewById(R.id.day1Ex3NextButton);
        day1Ex4NextButton = findViewById(R.id.day1Ex4NextButton);
        day1Ex5NextButton = findViewById(R.id.day1Ex5NextButton);
        day1Ex6NextButton = findViewById(R.id.day1Ex6NextButton);
        day1Ex7NextButton = findViewById(R.id.day1Ex7NextButton);
        day1Ex8NextButton = findViewById(R.id.day1Ex8NextButton);
        day1Ex9NextButton = findViewById(R.id.day1Ex9NextButton);
        day1Ex10NextButton = findViewById(R.id.day1Ex10NextButton);

        beginner_day1_ex1_layout = findViewById(R.id.beginner_day1_ex1_layout);
        beginner_day1_ex2_layout = findViewById(R.id.beginner_day1_ex2_layout);
        beginner_day1_ex3_layout = findViewById(R.id.beginner_day1_ex3_layout);
        beginner_day1_ex4_layout = findViewById(R.id.beginner_day1_ex4_layout);
        beginner_day1_ex5_layout = findViewById(R.id.beginner_day1_ex5_layout);
        beginner_day1_ex6_layout = findViewById(R.id.beginner_day1_ex6_layout);
        beginner_day1_ex7_layout = findViewById(R.id.beginner_day1_ex7_layout);
        beginner_day1_ex8_layout = findViewById(R.id.beginner_day1_ex8_layout);
        beginner_day1_ex9_layout = findViewById(R.id.beginner_day1_ex9_layout);
        beginner_day1_ex10_layout = findViewById(R.id.beginner_day1_ex10_layout);

        beginner_day1_rest1_layout = findViewById(R.id.beginner_day1_rest1_layout);
        beginner_day1_rest2_layout = findViewById(R.id.beginner_day1_rest2_layout);
        beginner_day1_rest3_layout = findViewById(R.id.beginner_day1_rest3_layout);
        beginner_day1_rest4_layout = findViewById(R.id.beginner_day1_rest4_layout);
        beginner_day1_rest5_layout = findViewById(R.id.beginner_day1_rest5_layout);
        beginner_day1_rest6_layout = findViewById(R.id.beginner_day1_rest6_layout);
        beginner_day1_rest7_layout = findViewById(R.id.beginner_day1_rest7_layout);
        beginner_day1_rest8_layout = findViewById(R.id.beginner_day1_rest8_layout);
        beginner_day1_rest9_layout = findViewById(R.id.beginner_day1_rest9_layout);

        day1Rest1StartButton = findViewById(R.id.day1Rest1StartButton);
        day1Rest2StartButton = findViewById(R.id.day1Rest2StartButton);
        day1Rest3StartButton = findViewById(R.id.day1Rest3StartButton);
        day1Rest4StartButton = findViewById(R.id.day1Rest4StartButton);
        day1Rest5StartButton = findViewById(R.id.day1Rest5StartButton);
        day1Rest6StartButton = findViewById(R.id.day1Rest6StartButton);
        day1Rest7StartButton = findViewById(R.id.day1Rest7StartButton);
        day1Rest8StartButton = findViewById(R.id.day1Rest8StartButton);
        day1Rest9StartButton = findViewById(R.id.day1Rest9StartButton);

        day1Rest1FinishButton = findViewById(R.id.day1Rest1FinishButton);
        day1Rest2FinishButton = findViewById(R.id.day1Rest2FinishButton);
        day1Rest3FinishButton = findViewById(R.id.day1Rest3FinishButton);
        day1Rest4FinishButton = findViewById(R.id.day1Rest4FinishButton);
        day1Rest5FinishButton = findViewById(R.id.day1Rest5FinishButton);
        day1Rest6FinishButton = findViewById(R.id.day1Rest6FinishButton);
        day1Rest7FinishButton = findViewById(R.id.day1Rest7FinishButton);
        day1Rest8FinishButton = findViewById(R.id.day1Rest8FinishButton);
        day1Rest9FinishButton = findViewById(R.id.day1Rest9FinishButton);

        beginner_day1_ex1_photo = findViewById(R.id.beginner_day1_ex1_photo);
        beginner_day1_ex2_photo = findViewById(R.id.beginner_day1_ex2_photo);
        beginner_day1_ex3_photo = findViewById(R.id.beginner_day1_ex3_photo);
        beginner_day1_ex4_photo = findViewById(R.id.beginner_day1_ex4_photo);
        beginner_day1_ex5_photo = findViewById(R.id.beginner_day1_ex5_photo);
        beginner_day1_ex6_photo = findViewById(R.id.beginner_day1_ex6_photo);
        beginner_day1_ex7_photo = findViewById(R.id.beginner_day1_ex7_photo);
        beginner_day1_ex8_photo = findViewById(R.id.beginner_day1_ex8_photo);
        beginner_day1_ex9_photo = findViewById(R.id.beginner_day1_ex9_photo);
        beginner_day1_ex10_photo = findViewById(R.id.beginner_day1_ex10_photo);


        day1BackButton.setOnClickListener(this);

        day1Ex1StartButton.setOnClickListener(this);
        day1Ex2StartButton.setOnClickListener(this);
        day1Ex3StartButton.setOnClickListener(this);
        day1Ex4StartButton.setOnClickListener(this);
        day1Ex5StartButton.setOnClickListener(this);
        day1Ex6StartButton.setOnClickListener(this);
        day1Ex7StartButton.setOnClickListener(this);
        day1Ex8StartButton.setOnClickListener(this);
        day1Ex9StartButton.setOnClickListener(this);
        day1Ex10StartButton.setOnClickListener(this);

        day1Ex1NextButton.setOnClickListener(this);
        day1Ex2NextButton.setOnClickListener(this);
        day1Ex3NextButton.setOnClickListener(this);
        day1Ex4NextButton.setOnClickListener(this);
        day1Ex5NextButton.setOnClickListener(this);
        day1Ex6NextButton.setOnClickListener(this);
        day1Ex7NextButton.setOnClickListener(this);
        day1Ex8NextButton.setOnClickListener(this);
        day1Ex9NextButton.setOnClickListener(this);
        day1Ex10NextButton.setOnClickListener(this);

        aboutDay1Ex1BeginnerButton.setOnClickListener(this);
        aboutDay1Ex2BeginnerButton.setOnClickListener(this);
        aboutDay1Ex3BeginnerButton.setOnClickListener(this);
        aboutDay1Ex4BeginnerButton.setOnClickListener(this);
        aboutDay1Ex5BeginnerButton.setOnClickListener(this);
        aboutDay1Ex6BeginnerButton.setOnClickListener(this);
        aboutDay1Ex7BeginnerButton.setOnClickListener(this);
        aboutDay1Ex8BeginnerButton.setOnClickListener(this);
        aboutDay1Ex9BeginnerButton.setOnClickListener(this);
        aboutDay1Ex10BeginnerButton.setOnClickListener(this);

        day1Rest1StartButton.setOnClickListener(this);
        day1Rest2StartButton.setOnClickListener(this);
        day1Rest3StartButton.setOnClickListener(this);
        day1Rest4StartButton.setOnClickListener(this);
        day1Rest5StartButton.setOnClickListener(this);
        day1Rest6StartButton.setOnClickListener(this);
        day1Rest7StartButton.setOnClickListener(this);
        day1Rest8StartButton.setOnClickListener(this);
        day1Rest9StartButton.setOnClickListener(this);

        day1Rest1FinishButton.setOnClickListener(this);
        day1Rest2FinishButton.setOnClickListener(this);
        day1Rest3FinishButton.setOnClickListener(this);
        day1Rest4FinishButton.setOnClickListener(this);
        day1Rest5FinishButton.setOnClickListener(this);
        day1Rest6FinishButton.setOnClickListener(this);
        day1Rest7FinishButton.setOnClickListener(this);
        day1Rest8FinishButton.setOnClickListener(this);
        day1Rest9FinishButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(Day1BeginnerActivity.this, BeginnerWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.day1BackButton:
                onBackPressed();
                break;

            case R.id.day1Ex1StartButton:
                beginner_day1_ex1_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex1_photo);
                day1Ex1StartButton.setVisibility(View.GONE);
                day1Ex1NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex1NextButton:
                beginner_day1_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex2_photo);
                break;

            case R.id.day1Rest1StartButton:
                beginner_day1_rest1_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest1StartButton.setVisibility(View.GONE);
                day1Rest1FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest1FinishButton:
                beginner_day1_rest1_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex2StartButton:
                beginner_day1_ex2_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex2StartButton.setVisibility(View.GONE);
                day1Ex2NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex2NextButton:
                beginner_day1_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex3_photo);
                break;

            case R.id.day1Rest2StartButton:
                beginner_day1_rest2_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest2StartButton.setVisibility(View.GONE);
                day1Rest2FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest2FinishButton:
                beginner_day1_rest2_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex3StartButton:
                beginner_day1_ex3_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex3StartButton.setVisibility(View.GONE);
                day1Ex3NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex3NextButton:
                beginner_day1_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex4_photo);
                break;

            case R.id.day1Rest3StartButton:
                beginner_day1_rest3_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest3StartButton.setVisibility(View.GONE);
                day1Rest3FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest3FinishButton:
                beginner_day1_rest3_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex4StartButton:
                beginner_day1_ex4_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex4StartButton.setVisibility(View.GONE);
                day1Ex4NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex4NextButton:
                beginner_day1_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex5_photo);
                break;

            case R.id.day1Rest4StartButton:
                beginner_day1_rest4_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest4StartButton.setVisibility(View.GONE);
                day1Rest4FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest4FinishButton:
                beginner_day1_rest4_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex5StartButton:
                beginner_day1_ex5_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex5StartButton.setVisibility(View.GONE);
                day1Ex5NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex5NextButton:
                beginner_day1_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex6_photo);
                break;

            case R.id.day1Rest5StartButton:
                beginner_day1_rest5_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest5StartButton.setVisibility(View.GONE);
                day1Rest5FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest5FinishButton:
                beginner_day1_rest5_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex6StartButton:
                beginner_day1_ex6_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex6StartButton.setVisibility(View.GONE);
                day1Ex6NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex6NextButton:
                beginner_day1_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex7_photo);
                break;

            case R.id.day1Rest6StartButton:
                beginner_day1_rest6_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest6StartButton.setVisibility(View.GONE);
                day1Rest6FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest6FinishButton:
                beginner_day1_rest6_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex7StartButton:
                beginner_day1_ex7_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex7StartButton.setVisibility(View.GONE);
                day1Ex7NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex7NextButton:
                beginner_day1_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex8_photo);
                break;

            case R.id.day1Rest7StartButton:
                beginner_day1_rest7_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest7StartButton.setVisibility(View.GONE);
                day1Rest7FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest7FinishButton:
                beginner_day1_rest7_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex8StartButton:
                beginner_day1_ex8_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex8StartButton.setVisibility(View.GONE);
                day1Ex8NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex8NextButton:
                beginner_day1_rest8_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex9_photo);
                break;

            case R.id.day1Rest8StartButton:
                beginner_day1_rest8_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest8StartButton.setVisibility(View.GONE);
                day1Rest8FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest8FinishButton:
                beginner_day1_rest8_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex9StartButton:
                beginner_day1_ex9_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex9StartButton.setVisibility(View.GONE);
                day1Ex9NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex9NextButton:
                beginner_day1_rest9_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day1_ex10_photo);
                break;

            case R.id.day1Rest9StartButton:
                beginner_day1_rest9_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest9StartButton.setVisibility(View.GONE);
                day1Rest9FinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest9FinishButton:
                beginner_day1_rest9_layout.setVisibility(View.GONE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                beginner_day1_ex10_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex10StartButton:
                beginner_day1_ex10_layout.setVisibility(View.VISIBLE);
                beginner_day1_ex1_layout.setVisibility(View.GONE);
                beginner_day1_ex2_layout.setVisibility(View.GONE);
                beginner_day1_ex3_layout.setVisibility(View.GONE);
                beginner_day1_ex4_layout.setVisibility(View.GONE);
                beginner_day1_ex5_layout.setVisibility(View.GONE);
                beginner_day1_ex6_layout.setVisibility(View.GONE);
                beginner_day1_ex7_layout.setVisibility(View.GONE);
                beginner_day1_ex8_layout.setVisibility(View.GONE);
                beginner_day1_ex9_layout.setVisibility(View.GONE);
                day1Ex10StartButton.setVisibility(View.GONE);
                day1Ex10NextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex10NextButton:

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

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            Toast.makeText(Day1BeginnerActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            Toast.makeText(Day1BeginnerActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

                                                    for (DataSnapshot daySnap : workoutSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            Toast.makeText(Day1BeginnerActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1BeginnerActivity.this, BeginnerWorkoutActivity.class);
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

            case R.id.aboutDay1Ex1BeginnerButton:
                final DialogPlus about = DialogPlus.newDialog(Day1BeginnerActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }
}