package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
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
        Intent toStayHealthy = new Intent(Day6BeginnerActivity.this, BeginnerWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
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
                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex1_photo);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex2_photo);
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
                day6Rest1FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex3_photo);
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
                day6Rest2FinishButton.setVisibility(View.VISIBLE);
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
                day6Ex3NextButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex4_photo);
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
                day6Rest3FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex5_photo);
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
                day6Rest4FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex6_photo);
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
                day6Rest5FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex7_photo);
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
                day6Rest6FinishButton.setVisibility(View.VISIBLE);
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
                day6Ex7NextButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day6_ex8_photo);
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
                day6Rest7FinishButton.setVisibility(View.VISIBLE);
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
        }
    }
}