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

public class Day6AdvancedActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day6AdvancedBackButton;
    AppCompatButton day6Ex1AdvancedStartButton, day6Ex2AdvancedStartButton, day6Ex3AdvancedStartButton, day6Ex4AdvancedStartButton;
    AppCompatButton day6Ex5AdvancedStartButton, day6Ex6AdvancedStartButton, day6Ex7AdvancedStartButton, day6Ex8AdvancedStartButton;
    AppCompatButton day6Ex1AdvancedNextButton, day6Ex2AdvancedNextButton, day6Ex3AdvancedNextButton, day6Ex4AdvancedNextButton;
    AppCompatButton day6Ex5AdvancedNextButton, day6Ex6AdvancedNextButton, day6Ex7AdvancedNextButton, day6Ex8AdvancedNextButton;
    AppCompatImageView aboutDay6Ex1AdvancedButton, aboutDay6Ex6AdvancedButton, aboutDay6Ex3AdvancedButton, aboutDay6Ex4AdvancedButton;
    AppCompatImageView aboutDay6Ex5AdvancedButton, aboutDay6Ex2AdvancedButton, aboutDay6Ex7AdvancedButton, aboutDay6Ex8AdvancedButton;
    AppCompatImageView advanced_day6_ex1_photo, advanced_day6_ex2_photo, advanced_day6_ex3_photo, advanced_day6_ex4_photo;
    AppCompatImageView advanced_day6_ex5_photo, advanced_day6_ex6_photo, advanced_day6_ex7_photo, advanced_day6_ex8_photo;
    FrameLayout advanced_day6_ex1_layout, advanced_day6_ex2_layout, advanced_day6_ex3_layout, advanced_day6_ex4_layout;
    FrameLayout advanced_day6_ex5_layout, advanced_day6_ex6_layout, advanced_day6_ex7_layout, advanced_day6_ex8_layout;
    FrameLayout advanced_day6_rest1_layout, advanced_day6_rest2_layout, advanced_day6_rest3_layout;
    FrameLayout advanced_day6_rest4_layout, advanced_day6_rest5_layout, advanced_day6_rest6_layout, advanced_day6_rest7_layout;
    AppCompatButton day6Rest1AdvancedStartButton, day6Rest2AdvancedStartButton, day6Rest3AdvancedStartButton;
    AppCompatButton day6Rest4AdvancedStartButton, day6Rest5AdvancedStartButton, day6Rest6AdvancedStartButton, day6Rest7AdvancedStartButton;
    AppCompatButton day6Rest1AdvancedFinishButton, day6Rest2AdvancedFinishButton, day6Rest3AdvancedFinishButton;
    AppCompatButton day6Rest4AdvancedFinishButton, day6Rest5AdvancedFinishButton, day6Rest6AdvancedFinishButton, day6Rest7AdvancedFinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_advanced);

        day6AdvancedBackButton = findViewById(R.id.day6AdvancedBackButton);

        day6Ex1AdvancedStartButton = findViewById(R.id.day6Ex1AdvancedStartButton);
        day6Ex2AdvancedStartButton = findViewById(R.id.day6Ex2AdvancedStartButton);
        day6Ex3AdvancedStartButton = findViewById(R.id.day6Ex3AdvancedStartButton);
        day6Ex4AdvancedStartButton = findViewById(R.id.day6Ex4AdvancedStartButton);
        day6Ex5AdvancedStartButton = findViewById(R.id.day6Ex5AdvancedStartButton);
        day6Ex6AdvancedStartButton = findViewById(R.id.day6Ex6AdvancedStartButton);
        day6Ex7AdvancedStartButton = findViewById(R.id.day6Ex7AdvancedStartButton);
        day6Ex8AdvancedStartButton = findViewById(R.id.day6Ex8AdvancedStartButton);

        day6Ex1AdvancedNextButton = findViewById(R.id.day6Ex1AdvancedNextButton);
        day6Ex2AdvancedNextButton = findViewById(R.id.day6Ex2AdvancedNextButton);
        day6Ex3AdvancedNextButton = findViewById(R.id.day6Ex3AdvancedNextButton);
        day6Ex4AdvancedNextButton = findViewById(R.id.day6Ex4AdvancedNextButton);
        day6Ex5AdvancedNextButton = findViewById(R.id.day6Ex5AdvancedNextButton);
        day6Ex6AdvancedNextButton = findViewById(R.id.day6Ex6AdvancedNextButton);
        day6Ex7AdvancedNextButton = findViewById(R.id.day6Ex7AdvancedNextButton);
        day6Ex8AdvancedNextButton = findViewById(R.id.day6Ex8AdvancedNextButton);

        aboutDay6Ex1AdvancedButton = findViewById(R.id.aboutDay6Ex1AdvancedButton);
        aboutDay6Ex2AdvancedButton = findViewById(R.id.aboutDay6Ex2AdvancedButton);
        aboutDay6Ex3AdvancedButton = findViewById(R.id.aboutDay6Ex3AdvancedButton);
        aboutDay6Ex4AdvancedButton = findViewById(R.id.aboutDay6Ex4AdvancedButton);
        aboutDay6Ex5AdvancedButton = findViewById(R.id.aboutDay6Ex5AdvancedButton);
        aboutDay6Ex6AdvancedButton = findViewById(R.id.aboutDay6Ex6AdvancedButton);
        aboutDay6Ex7AdvancedButton = findViewById(R.id.aboutDay6Ex7AdvancedButton);
        aboutDay6Ex8AdvancedButton = findViewById(R.id.aboutDay6Ex8AdvancedButton);

        advanced_day6_ex1_layout = findViewById(R.id.advanced_day6_ex1_layout);
        advanced_day6_ex2_layout = findViewById(R.id.advanced_day6_ex2_layout);
        advanced_day6_ex3_layout = findViewById(R.id.advanced_day6_ex3_layout);
        advanced_day6_ex4_layout = findViewById(R.id.advanced_day6_ex4_layout);
        advanced_day6_ex5_layout = findViewById(R.id.advanced_day6_ex5_layout);
        advanced_day6_ex6_layout = findViewById(R.id.advanced_day6_ex6_layout);
        advanced_day6_ex7_layout = findViewById(R.id.advanced_day6_ex7_layout);
        advanced_day6_ex8_layout = findViewById(R.id.advanced_day6_ex8_layout);

        advanced_day6_ex1_photo = findViewById(R.id.advanced_day6_ex1_photo);
        advanced_day6_ex2_photo = findViewById(R.id.advanced_day6_ex2_photo);
        advanced_day6_ex3_photo = findViewById(R.id.advanced_day6_ex3_photo);
        advanced_day6_ex4_photo = findViewById(R.id.advanced_day6_ex4_photo);
        advanced_day6_ex5_photo = findViewById(R.id.advanced_day6_ex5_photo);
        advanced_day6_ex6_photo = findViewById(R.id.advanced_day6_ex6_photo);
        advanced_day6_ex7_photo = findViewById(R.id.advanced_day6_ex7_photo);
        advanced_day6_ex8_photo = findViewById(R.id.advanced_day6_ex8_photo);

        advanced_day6_rest1_layout = findViewById(R.id.advanced_day6_rest1_layout);
        advanced_day6_rest2_layout = findViewById(R.id.advanced_day6_rest2_layout);
        advanced_day6_rest3_layout = findViewById(R.id.advanced_day6_rest3_layout);
        advanced_day6_rest4_layout = findViewById(R.id.advanced_day6_rest4_layout);
        advanced_day6_rest5_layout = findViewById(R.id.advanced_day6_rest5_layout);
        advanced_day6_rest6_layout = findViewById(R.id.advanced_day6_rest6_layout);
        advanced_day6_rest7_layout = findViewById(R.id.advanced_day6_rest7_layout);

        day6Rest1AdvancedStartButton = findViewById(R.id.day6Rest1AdvancedStartButton);
        day6Rest2AdvancedStartButton = findViewById(R.id.day6Rest2AdvancedStartButton);
        day6Rest3AdvancedStartButton = findViewById(R.id.day6Rest3AdvancedStartButton);
        day6Rest4AdvancedStartButton = findViewById(R.id.day6Rest4AdvancedStartButton);
        day6Rest5AdvancedStartButton = findViewById(R.id.day6Rest5AdvancedStartButton);
        day6Rest6AdvancedStartButton = findViewById(R.id.day6Rest6AdvancedStartButton);
        day6Rest7AdvancedStartButton = findViewById(R.id.day6Rest7AdvancedStartButton);

        day6Rest1AdvancedFinishButton = findViewById(R.id.day6Rest1AdvancedFinishButton);
        day6Rest2AdvancedFinishButton = findViewById(R.id.day6Rest2AdvancedFinishButton);
        day6Rest3AdvancedFinishButton = findViewById(R.id.day6Rest3AdvancedFinishButton);
        day6Rest4AdvancedFinishButton = findViewById(R.id.day6Rest4AdvancedFinishButton);
        day6Rest5AdvancedFinishButton = findViewById(R.id.day6Rest5AdvancedFinishButton);
        day6Rest6AdvancedFinishButton = findViewById(R.id.day6Rest6AdvancedFinishButton);
        day6Rest7AdvancedFinishButton = findViewById(R.id.day6Rest7AdvancedFinishButton);

        Glide.with(this).load(R.drawable.reverse_lunges_exercise).into(advanced_day6_ex1_photo);
        Glide.with(this).load(R.drawable.squats_exercise).into(advanced_day6_ex2_photo);
        Glide.with(this).load(R.drawable.high_knees_exercise).into(advanced_day6_ex3_photo);
        Glide.with(this).load(R.drawable.side_lunges_exercise).into(advanced_day6_ex4_photo);
        Glide.with(this).load(R.drawable.side_step_squats_exercise).into(advanced_day6_ex5_photo);
        Glide.with(this).load(R.drawable.forward_to_reverse_lunges_exercise).into(advanced_day6_ex6_photo);
        Glide.with(this).load(R.drawable.jump_squats).into(advanced_day6_ex7_photo);
        Glide.with(this).load(R.drawable.jumping_lunges).into(advanced_day6_ex8_photo);

        day6AdvancedBackButton.setOnClickListener(this);

        day6Ex1AdvancedStartButton.setOnClickListener(this);
        day6Ex2AdvancedStartButton.setOnClickListener(this);
        day6Ex3AdvancedStartButton.setOnClickListener(this);
        day6Ex4AdvancedStartButton.setOnClickListener(this);
        day6Ex5AdvancedStartButton.setOnClickListener(this);
        day6Ex6AdvancedStartButton.setOnClickListener(this);
        day6Ex7AdvancedStartButton.setOnClickListener(this);
        day6Ex8AdvancedStartButton.setOnClickListener(this);

        day6Ex1AdvancedNextButton.setOnClickListener(this);
        day6Ex2AdvancedNextButton.setOnClickListener(this);
        day6Ex3AdvancedNextButton.setOnClickListener(this);
        day6Ex4AdvancedNextButton.setOnClickListener(this);
        day6Ex5AdvancedNextButton.setOnClickListener(this);
        day6Ex6AdvancedNextButton.setOnClickListener(this);
        day6Ex7AdvancedNextButton.setOnClickListener(this);
        day6Ex8AdvancedNextButton.setOnClickListener(this);

        aboutDay6Ex1AdvancedButton.setOnClickListener(this);
        aboutDay6Ex2AdvancedButton.setOnClickListener(this);
        aboutDay6Ex3AdvancedButton.setOnClickListener(this);
        aboutDay6Ex4AdvancedButton.setOnClickListener(this);
        aboutDay6Ex5AdvancedButton.setOnClickListener(this);
        aboutDay6Ex6AdvancedButton.setOnClickListener(this);
        aboutDay6Ex7AdvancedButton.setOnClickListener(this);
        aboutDay6Ex8AdvancedButton.setOnClickListener(this);

        day6Rest1AdvancedStartButton.setOnClickListener(this);
        day6Rest2AdvancedStartButton.setOnClickListener(this);
        day6Rest3AdvancedStartButton.setOnClickListener(this);
        day6Rest4AdvancedStartButton.setOnClickListener(this);
        day6Rest5AdvancedStartButton.setOnClickListener(this);
        day6Rest6AdvancedStartButton.setOnClickListener(this);
        day6Rest7AdvancedStartButton.setOnClickListener(this);

        day6Rest1AdvancedFinishButton.setOnClickListener(this);
        day6Rest2AdvancedFinishButton.setOnClickListener(this);
        day6Rest3AdvancedFinishButton.setOnClickListener(this);
        day6Rest4AdvancedFinishButton.setOnClickListener(this);
        day6Rest5AdvancedFinishButton.setOnClickListener(this);
        day6Rest6AdvancedFinishButton.setOnClickListener(this);
        day6Rest7AdvancedFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(Day6AdvancedActivity.this, AdvancedWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.day6AdvancedBackButton:
                onBackPressed();
                break;

            case R.id.day6Ex1AdvancedStartButton:
                advanced_day6_ex1_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex1AdvancedStartButton.setVisibility(View.GONE);
                day6Ex1AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex1AdvancedNextButton:
                advanced_day6_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest1AdvancedStartButton:
                advanced_day6_rest1_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest1AdvancedStartButton.setVisibility(View.GONE);
                day6Rest1AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest1AdvancedFinishButton:
                advanced_day6_rest1_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex2AdvancedStartButton:
                advanced_day6_ex2_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex2AdvancedStartButton.setVisibility(View.GONE);
                day6Ex2AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex2AdvancedNextButton:
                advanced_day6_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest2AdvancedStartButton:
                advanced_day6_rest2_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest2AdvancedStartButton.setVisibility(View.GONE);
                day6Rest2AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest2AdvancedFinishButton:
                advanced_day6_rest2_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex3AdvancedStartButton:
                advanced_day6_ex3_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex3AdvancedStartButton.setVisibility(View.GONE);
                day6Ex3AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex3AdvancedNextButton:
                advanced_day6_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest3AdvancedStartButton:
                advanced_day6_rest3_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest3AdvancedStartButton.setVisibility(View.GONE);
                day6Rest3AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest3AdvancedFinishButton:
                advanced_day6_rest3_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex4AdvancedStartButton:
                advanced_day6_ex4_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex4AdvancedStartButton.setVisibility(View.GONE);
                day6Ex4AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex4AdvancedNextButton:
                advanced_day6_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest4AdvancedStartButton:
                advanced_day6_rest4_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest4AdvancedStartButton.setVisibility(View.GONE);
                day6Rest4AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest4AdvancedFinishButton:
                advanced_day6_rest4_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex5AdvancedStartButton:
                advanced_day6_ex5_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex5AdvancedStartButton.setVisibility(View.GONE);
                day6Ex5AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex5AdvancedNextButton:
                advanced_day6_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest5AdvancedStartButton:
                advanced_day6_rest5_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest5AdvancedStartButton.setVisibility(View.GONE);
                day6Rest5AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest5AdvancedFinishButton:
                advanced_day6_rest5_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex6AdvancedStartButton:
                advanced_day6_ex6_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex6AdvancedStartButton.setVisibility(View.GONE);
                day6Ex6AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex6AdvancedNextButton:
                advanced_day6_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest6AdvancedStartButton:
                advanced_day6_rest6_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest6AdvancedStartButton.setVisibility(View.GONE);
                day6Rest6AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest6AdvancedFinishButton:
                advanced_day6_rest6_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Ex7AdvancedStartButton:
                advanced_day6_ex7_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Ex7AdvancedStartButton.setVisibility(View.GONE);
                day6Ex7AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex7AdvancedNextButton:
                advanced_day6_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day6Rest7AdvancedStartButton:
                advanced_day6_rest7_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.GONE);
                day6Rest7AdvancedStartButton.setVisibility(View.GONE);
                day6Rest7AdvancedFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Rest7AdvancedFinishButton:
                advanced_day6_rest7_layout.setVisibility(View.GONE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                advanced_day6_ex8_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex8AdvancedStartButton:
                advanced_day6_ex8_layout.setVisibility(View.VISIBLE);
                advanced_day6_ex1_layout.setVisibility(View.GONE);
                advanced_day6_ex2_layout.setVisibility(View.GONE);
                advanced_day6_ex3_layout.setVisibility(View.GONE);
                advanced_day6_ex4_layout.setVisibility(View.GONE);
                advanced_day6_ex5_layout.setVisibility(View.GONE);
                advanced_day6_ex6_layout.setVisibility(View.GONE);
                advanced_day6_ex7_layout.setVisibility(View.GONE);
                day6Ex8AdvancedStartButton.setVisibility(View.GONE);
                day6Ex8AdvancedNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day6Ex8AdvancedNextButton:

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

                                                            Toast.makeText(Day6AdvancedActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                            Toast.makeText(Day6AdvancedActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                        } else {



                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6AdvancedActivity.this, AdvancedWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 6")) {

                                                                    Toast.makeText(Day6AdvancedActivity.this, "You're already done for day 6!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Advanced").child("Day 6").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day6AdvancedActivity.this, AdvancedWorkoutActivity.class);
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