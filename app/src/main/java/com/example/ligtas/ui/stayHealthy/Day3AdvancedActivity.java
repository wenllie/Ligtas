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
        Intent toStayHealthy = new Intent(Day3AdvancedActivity.this, AdvancedWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
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
                day3Rest1AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Rest2AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Ex3AdvancedNextButton.setVisibility(View.VISIBLE);
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
                day3Rest3AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Ex4AdvancedNextButton.setVisibility(View.VISIBLE);
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
                day3Rest4AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Ex5AdvancedNextButton.setVisibility(View.VISIBLE);
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
                day3Rest5AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Rest6AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Rest7AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Ex8AdvancedNextButton.setVisibility(View.VISIBLE);
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
                day3Rest8AdvancedFinishButton.setVisibility(View.VISIBLE);
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
                day3Ex9AdvancedNextButton.setVisibility(View.VISIBLE);
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
                final DialogPlus about = DialogPlus.newDialog(Day3AdvancedActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }
}