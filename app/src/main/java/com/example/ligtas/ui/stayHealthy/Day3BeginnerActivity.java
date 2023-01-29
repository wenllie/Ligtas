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
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

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
        Intent toStayHealthy = new Intent(Day3BeginnerActivity.this, BeginnerWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
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
                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex1_photo);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex2_photo);
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
                day3Rest1FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex3_photo);
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
                day3Rest2FinishButton.setVisibility(View.VISIBLE);
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
                day3Ex3NextButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex4_photo);
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
                day3Rest3FinishButton.setVisibility(View.VISIBLE);
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
                day3Ex4NextButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex5_photo);
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
                day3Rest4FinishButton.setVisibility(View.VISIBLE);
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
                day3Ex5NextButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex6_photo);
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
                day3Rest5FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex7_photo);
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
                day3Rest6FinishButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex8_photo);
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
                day3Rest7FinishButton.setVisibility(View.VISIBLE);
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
                day3Ex8NextButton.setVisibility(View.VISIBLE);
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

                Glide.with(this).load(R.drawable.squats_exercise).into(beginner_day3_ex9_photo);
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
                day3Rest8FinishButton.setVisibility(View.VISIBLE);
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
                day3Ex9NextButton.setVisibility(View.VISIBLE);
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

                                                    for (DataSnapshot daySnap : workoutSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            Toast.makeText(Day3BeginnerActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Day 3").child("Result").setValue("Completed");
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

                                                    for (DataSnapshot daySnap : workoutSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            Toast.makeText(Day3BeginnerActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Day 3").child("Result").setValue("Completed");
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

                                                    for (DataSnapshot daySnap : workoutSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            Toast.makeText(Day3BeginnerActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Day 3").child("Result").setValue("Completed");
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
                final DialogPlus about = DialogPlus.newDialog(Day3BeginnerActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }
}