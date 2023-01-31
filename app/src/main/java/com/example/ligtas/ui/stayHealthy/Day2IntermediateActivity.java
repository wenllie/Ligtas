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

public class Day2IntermediateActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day2IntermediateBackButton;
    AppCompatButton day2Ex1IntermediateStartButton, day2Ex2IntermediateStartButton, day2Ex3IntermediateStartButton, day2Ex4IntermediateStartButton;
    AppCompatButton day2Ex5IntermediateStartButton, day2Ex6IntermediateStartButton, day2Ex7IntermediateStartButton, day2Ex8IntermediateStartButton;
    AppCompatButton day2Ex1IntermediateNextButton, day2Ex2IntermediateNextButton, day2Ex3IntermediateNextButton, day2Ex4IntermediateNextButton;
    AppCompatButton day2Ex5IntermediateNextButton, day2Ex6IntermediateNextButton, day2Ex7IntermediateNextButton, day2Ex8IntermediateNextButton;
    AppCompatImageView aboutDay2Ex1IntermediateButton, aboutDay2Ex2IntermediateButton, aboutDay2Ex3IntermediateButton, aboutDay2Ex4IntermediateButton;
    AppCompatImageView aboutDay2Ex5IntermediateButton, aboutDay2Ex6IntermediateButton, aboutDay2Ex7IntermediateButton, aboutDay2Ex8IntermediateButton;
    AppCompatImageView intermediate_day2_ex1_photo, intermediate_day2_ex2_photo, intermediate_day2_ex3_photo, intermediate_day2_ex4_photo;
    AppCompatImageView intermediate_day2_ex5_photo, intermediate_day2_ex6_photo, intermediate_day2_ex7_photo, intermediate_day2_ex8_photo;
    FrameLayout intermediate_day2_ex1_layout, intermediate_day2_ex2_layout, intermediate_day2_ex3_layout, intermediate_day2_ex4_layout;
    FrameLayout intermediate_day2_ex5_layout, intermediate_day2_ex6_layout, intermediate_day2_ex7_layout, intermediate_day2_ex8_layout;
    FrameLayout intermediate_day2_rest1_layout, intermediate_day2_rest2_layout, intermediate_day2_rest3_layout;
    FrameLayout intermediate_day2_rest4_layout, intermediate_day2_rest5_layout, intermediate_day2_rest6_layout, intermediate_day2_rest7_layout;
    AppCompatButton day2Rest1IntermediateStartButton, day2Rest2IntermediateStartButton, day2Rest3IntermediateStartButton;
    AppCompatButton day2Rest4IntermediateStartButton, day2Rest5IntermediateStartButton, day2Rest6IntermediateStartButton, day2Rest7IntermediateStartButton;
    AppCompatButton day2Rest1IntermediateFinishButton, day2Rest2IntermediateFinishButton, day2Rest3IntermediateFinishButton;
    AppCompatButton day2Rest4IntermediateFinishButton, day2Rest5IntermediateFinishButton, day2Rest6IntermediateFinishButton, day2Rest7IntermediateFinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_intermediate);

        day2IntermediateBackButton = findViewById(R.id.day2IntermediateBackButton);

        day2Ex1IntermediateStartButton = findViewById(R.id.day2Ex1IntermediateStartButton);
        day2Ex2IntermediateStartButton = findViewById(R.id.day2Ex2IntermediateStartButton);
        day2Ex3IntermediateStartButton = findViewById(R.id.day2Ex3IntermediateStartButton);
        day2Ex4IntermediateStartButton = findViewById(R.id.day2Ex4IntermediateStartButton);
        day2Ex5IntermediateStartButton = findViewById(R.id.day2Ex5IntermediateStartButton);
        day2Ex6IntermediateStartButton = findViewById(R.id.day2Ex6IntermediateStartButton);
        day2Ex7IntermediateStartButton = findViewById(R.id.day2Ex7IntermediateStartButton);
        day2Ex8IntermediateStartButton = findViewById(R.id.day2Ex8IntermediateStartButton);

        day2Ex1IntermediateNextButton = findViewById(R.id.day2Ex1IntermediateNextButton);
        day2Ex2IntermediateNextButton = findViewById(R.id.day2Ex2IntermediateNextButton);
        day2Ex3IntermediateNextButton = findViewById(R.id.day2Ex3IntermediateNextButton);
        day2Ex4IntermediateNextButton = findViewById(R.id.day2Ex4IntermediateNextButton);
        day2Ex5IntermediateNextButton = findViewById(R.id.day2Ex5IntermediateNextButton);
        day2Ex6IntermediateNextButton = findViewById(R.id.day2Ex6IntermediateNextButton);
        day2Ex7IntermediateNextButton = findViewById(R.id.day2Ex7IntermediateNextButton);
        day2Ex8IntermediateNextButton = findViewById(R.id.day2Ex8IntermediateNextButton);

        aboutDay2Ex1IntermediateButton = findViewById(R.id.aboutDay2Ex1IntermediateButton);
        aboutDay2Ex2IntermediateButton = findViewById(R.id.aboutDay2Ex2IntermediateButton);
        aboutDay2Ex3IntermediateButton = findViewById(R.id.aboutDay2Ex3IntermediateButton);
        aboutDay2Ex4IntermediateButton = findViewById(R.id.aboutDay2Ex4IntermediateButton);
        aboutDay2Ex5IntermediateButton = findViewById(R.id.aboutDay2Ex5IntermediateButton);
        aboutDay2Ex6IntermediateButton = findViewById(R.id.aboutDay2Ex6IntermediateButton);
        aboutDay2Ex7IntermediateButton = findViewById(R.id.aboutDay2Ex7IntermediateButton);
        aboutDay2Ex8IntermediateButton = findViewById(R.id.aboutDay2Ex8IntermediateButton);

        intermediate_day2_ex1_layout = findViewById(R.id.intermediate_day2_ex1_layout);
        intermediate_day2_ex2_layout = findViewById(R.id.intermediate_day2_ex2_layout);
        intermediate_day2_ex3_layout = findViewById(R.id.intermediate_day2_ex3_layout);
        intermediate_day2_ex4_layout = findViewById(R.id.intermediate_day2_ex4_layout);
        intermediate_day2_ex5_layout = findViewById(R.id.intermediate_day2_ex5_layout);
        intermediate_day2_ex6_layout = findViewById(R.id.intermediate_day2_ex6_layout);
        intermediate_day2_ex7_layout = findViewById(R.id.intermediate_day2_ex7_layout);
        intermediate_day2_ex8_layout = findViewById(R.id.intermediate_day2_ex8_layout);

        intermediate_day2_ex1_photo = findViewById(R.id.intermediate_day2_ex1_photo);
        intermediate_day2_ex2_photo = findViewById(R.id.intermediate_day2_ex2_photo);
        intermediate_day2_ex3_photo = findViewById(R.id.intermediate_day2_ex3_photo);
        intermediate_day2_ex4_photo = findViewById(R.id.intermediate_day2_ex4_photo);
        intermediate_day2_ex5_photo = findViewById(R.id.intermediate_day2_ex5_photo);
        intermediate_day2_ex6_photo = findViewById(R.id.intermediate_day2_ex6_photo);
        intermediate_day2_ex7_photo = findViewById(R.id.intermediate_day2_ex7_photo);
        intermediate_day2_ex8_photo = findViewById(R.id.intermediate_day2_ex8_photo);

        intermediate_day2_rest1_layout = findViewById(R.id.intermediate_day2_rest1_layout);
        intermediate_day2_rest2_layout = findViewById(R.id.intermediate_day2_rest2_layout);
        intermediate_day2_rest3_layout = findViewById(R.id.intermediate_day2_rest3_layout);
        intermediate_day2_rest4_layout = findViewById(R.id.intermediate_day2_rest4_layout);
        intermediate_day2_rest5_layout = findViewById(R.id.intermediate_day2_rest5_layout);
        intermediate_day2_rest6_layout = findViewById(R.id.intermediate_day2_rest6_layout);
        intermediate_day2_rest7_layout = findViewById(R.id.intermediate_day2_rest7_layout);

        day2Rest1IntermediateStartButton = findViewById(R.id.day2Rest1IntermediateStartButton);
        day2Rest2IntermediateStartButton = findViewById(R.id.day2Rest2IntermediateStartButton);
        day2Rest3IntermediateStartButton = findViewById(R.id.day2Rest3IntermediateStartButton);
        day2Rest4IntermediateStartButton = findViewById(R.id.day2Rest4IntermediateStartButton);
        day2Rest5IntermediateStartButton = findViewById(R.id.day2Rest5IntermediateStartButton);
        day2Rest6IntermediateStartButton = findViewById(R.id.day2Rest6IntermediateStartButton);
        day2Rest7IntermediateStartButton = findViewById(R.id.day2Rest7IntermediateStartButton);

        day2Rest1IntermediateFinishButton = findViewById(R.id.day2Rest1IntermediateFinishButton);
        day2Rest2IntermediateFinishButton = findViewById(R.id.day2Rest2IntermediateFinishButton);
        day2Rest3IntermediateFinishButton = findViewById(R.id.day2Rest3IntermediateFinishButton);
        day2Rest4IntermediateFinishButton = findViewById(R.id.day2Rest4IntermediateFinishButton);
        day2Rest5IntermediateFinishButton = findViewById(R.id.day2Rest5IntermediateFinishButton);
        day2Rest6IntermediateFinishButton = findViewById(R.id.day2Rest6IntermediateFinishButton);
        day2Rest7IntermediateFinishButton = findViewById(R.id.day2Rest7IntermediateFinishButton);

        Glide.with(this).load(R.drawable.reverse_lunges_exercise).into(intermediate_day2_ex1_photo);
        Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day2_ex2_photo);
        Glide.with(this).load(R.drawable.high_knees_exercise).into(intermediate_day2_ex3_photo);
        Glide.with(this).load(R.drawable.side_lunges_exercise).into(intermediate_day2_ex4_photo);
        Glide.with(this).load(R.drawable.side_step_squats_exercise).into(intermediate_day2_ex5_photo);
        Glide.with(this).load(R.drawable.forward_to_reverse_lunges_exercise).into(intermediate_day2_ex6_photo);
        Glide.with(this).load(R.drawable.jump_squats).into(intermediate_day2_ex7_photo);
        Glide.with(this).load(R.drawable.jumping_lunges).into(intermediate_day2_ex8_photo);


        day2IntermediateBackButton.setOnClickListener(this);

        day2Ex1IntermediateStartButton.setOnClickListener(this);
        day2Ex2IntermediateStartButton.setOnClickListener(this);
        day2Ex3IntermediateStartButton.setOnClickListener(this);
        day2Ex4IntermediateStartButton.setOnClickListener(this);
        day2Ex5IntermediateStartButton.setOnClickListener(this);
        day2Ex6IntermediateStartButton.setOnClickListener(this);
        day2Ex7IntermediateStartButton.setOnClickListener(this);
        day2Ex8IntermediateStartButton.setOnClickListener(this);

        day2Ex1IntermediateNextButton.setOnClickListener(this);
        day2Ex2IntermediateNextButton.setOnClickListener(this);
        day2Ex3IntermediateNextButton.setOnClickListener(this);
        day2Ex4IntermediateNextButton.setOnClickListener(this);
        day2Ex5IntermediateNextButton.setOnClickListener(this);
        day2Ex6IntermediateNextButton.setOnClickListener(this);
        day2Ex7IntermediateNextButton.setOnClickListener(this);
        day2Ex8IntermediateNextButton.setOnClickListener(this);

        aboutDay2Ex1IntermediateButton.setOnClickListener(this);
        aboutDay2Ex2IntermediateButton.setOnClickListener(this);
        aboutDay2Ex3IntermediateButton.setOnClickListener(this);
        aboutDay2Ex4IntermediateButton.setOnClickListener(this);
        aboutDay2Ex5IntermediateButton.setOnClickListener(this);
        aboutDay2Ex6IntermediateButton.setOnClickListener(this);
        aboutDay2Ex7IntermediateButton.setOnClickListener(this);
        aboutDay2Ex8IntermediateButton.setOnClickListener(this);

        day2Rest1IntermediateStartButton.setOnClickListener(this);
        day2Rest2IntermediateStartButton.setOnClickListener(this);
        day2Rest3IntermediateStartButton.setOnClickListener(this);
        day2Rest4IntermediateStartButton.setOnClickListener(this);
        day2Rest5IntermediateStartButton.setOnClickListener(this);
        day2Rest6IntermediateStartButton.setOnClickListener(this);
        day2Rest7IntermediateStartButton.setOnClickListener(this);

        day2Rest1IntermediateFinishButton.setOnClickListener(this);
        day2Rest2IntermediateFinishButton.setOnClickListener(this);
        day2Rest3IntermediateFinishButton.setOnClickListener(this);
        day2Rest4IntermediateFinishButton.setOnClickListener(this);
        day2Rest5IntermediateFinishButton.setOnClickListener(this);
        day2Rest6IntermediateFinishButton.setOnClickListener(this);
        day2Rest7IntermediateFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(Day2IntermediateActivity.this, IntermediateWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.day2IntermediateBackButton:
                onBackPressed();
                break;

            case R.id.day2Ex1IntermediateStartButton:
                intermediate_day2_ex1_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex1IntermediateStartButton.setVisibility(View.GONE);
                day2Ex1IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex1IntermediateNextButton:
                intermediate_day2_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest1IntermediateStartButton:
                intermediate_day2_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest1IntermediateStartButton.setVisibility(View.GONE);
                day2Rest1IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest1IntermediateFinishButton:
                intermediate_day2_rest1_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex2IntermediateStartButton:
                intermediate_day2_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex2IntermediateStartButton.setVisibility(View.GONE);
                day2Ex2IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex2IntermediateNextButton:
                intermediate_day2_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest2IntermediateStartButton:
                intermediate_day2_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest2IntermediateStartButton.setVisibility(View.GONE);
                day2Rest2IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest2IntermediateFinishButton:
                intermediate_day2_rest2_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex3IntermediateStartButton:
                intermediate_day2_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex3IntermediateStartButton.setVisibility(View.GONE);
                day2Ex3IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex3IntermediateNextButton:
                intermediate_day2_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest3IntermediateStartButton:
                intermediate_day2_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest3IntermediateStartButton.setVisibility(View.GONE);
                day2Rest3IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest3IntermediateFinishButton:
                intermediate_day2_rest3_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex4IntermediateStartButton:
                intermediate_day2_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex4IntermediateStartButton.setVisibility(View.GONE);
                day2Ex4IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex4IntermediateNextButton:
                intermediate_day2_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest4IntermediateStartButton:
                intermediate_day2_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest4IntermediateStartButton.setVisibility(View.GONE);
                day2Rest4IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest4IntermediateFinishButton:
                intermediate_day2_rest4_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex5IntermediateStartButton:
                intermediate_day2_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex5IntermediateStartButton.setVisibility(View.GONE);
                day2Ex5IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex5IntermediateNextButton:
                intermediate_day2_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest5IntermediateStartButton:
                intermediate_day2_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest5IntermediateStartButton.setVisibility(View.GONE);
                day2Rest5IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest5IntermediateFinishButton:
                intermediate_day2_rest5_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex6IntermediateStartButton:
                intermediate_day2_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex6IntermediateStartButton.setVisibility(View.GONE);
                day2Ex6IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex6IntermediateNextButton:
                intermediate_day2_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest6IntermediateStartButton:
                intermediate_day2_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest6IntermediateStartButton.setVisibility(View.GONE);
                day2Rest6IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest6IntermediateFinishButton:
                intermediate_day2_rest6_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Ex7IntermediateStartButton:
                intermediate_day2_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Ex7IntermediateStartButton.setVisibility(View.GONE);
                day2Ex7IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex7IntermediateNextButton:
                intermediate_day2_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                break;

            case R.id.day2Rest7IntermediateStartButton:
                intermediate_day2_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.GONE);
                day2Rest7IntermediateStartButton.setVisibility(View.GONE);
                day2Rest7IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Rest7IntermediateFinishButton:
                intermediate_day2_rest7_layout.setVisibility(View.GONE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                intermediate_day2_ex8_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex8IntermediateStartButton:
                intermediate_day2_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day2_ex1_layout.setVisibility(View.GONE);
                intermediate_day2_ex2_layout.setVisibility(View.GONE);
                intermediate_day2_ex3_layout.setVisibility(View.GONE);
                intermediate_day2_ex4_layout.setVisibility(View.GONE);
                intermediate_day2_ex5_layout.setVisibility(View.GONE);
                intermediate_day2_ex6_layout.setVisibility(View.GONE);
                intermediate_day2_ex7_layout.setVisibility(View.GONE);
                day2Ex8IntermediateStartButton.setVisibility(View.GONE);
                day2Ex8IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day2Ex8IntermediateNextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 2")) {

                                                                    Toast.makeText(Day2IntermediateActivity.this, "You're already done for day 2!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 2").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day2IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 2")) {

                                                                    Toast.makeText(Day2IntermediateActivity.this, "You're already done for day 2!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 2").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day2IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 2")) {

                                                                    Toast.makeText(Day2IntermediateActivity.this, "You're already done for day 2!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 2").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day2IntermediateActivity.this, IntermediateWorkoutActivity.class);
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