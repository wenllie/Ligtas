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
        Intent toStayHealthy = new Intent(Day5IntermediateActivity.this, IntermediateWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
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
                day5Rest1IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Rest2IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Rest3IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Ex4IntermediateNextButton.setVisibility(View.VISIBLE);
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
                day5Rest4IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Ex5IntermediateNextButton.setVisibility(View.VISIBLE);
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
                day5Rest5IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Rest6IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Rest7IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Rest8IntermediateFinishButton.setVisibility(View.VISIBLE);
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
                day5Ex9IntermediateNextButton.setVisibility(View.VISIBLE);
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
                final DialogPlus about = DialogPlus.newDialog(Day5IntermediateActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }
}