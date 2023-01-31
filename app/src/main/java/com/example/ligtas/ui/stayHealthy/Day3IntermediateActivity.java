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

public class Day3IntermediateActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView day3IntermediateBackButton;
    AppCompatButton day3Ex1IntermediateStartButton, day3Ex2IntermediateStartButton, day3Ex3IntermediateStartButton, day3Ex4IntermediateStartButton;
    AppCompatButton day3Ex5IntermediateStartButton, day3Ex6IntermediateStartButton, day3Ex7IntermediateStartButton, day3Ex8IntermediateStartButton, day3Ex9IntermediateStartButton;
    AppCompatButton day3Ex1IntermediateNextButton, day3Ex2IntermediateNextButton, day3Ex3IntermediateNextButton, day3Ex4IntermediateNextButton;
    AppCompatButton day3Ex5IntermediateNextButton, day3Ex6IntermediateNextButton, day3Ex7IntermediateNextButton, day3Ex8IntermediateNextButton, day3Ex9IntermediateNextButton;
    AppCompatImageView aboutDay3Ex1IntermediateButton, aboutDay3Ex2IntermediateButton, aboutDay3Ex3IntermediateButton, aboutDay3Ex4IntermediateButton, aboutDay3Ex5IntermediateButton;
    AppCompatImageView aboutDay3Ex6IntermediateButton, aboutDay3Ex7IntermediateButton, aboutDay3Ex8IntermediateButton, aboutDay3Ex9IntermediateButton;
    AppCompatImageView intermediate_day3_ex1_photo, intermediate_day3_ex2_photo, intermediate_day3_ex3_photo, intermediate_day3_ex4_photo, intermediate_day3_ex5_photo;
    AppCompatImageView intermediate_day3_ex6_photo, intermediate_day3_ex7_photo, intermediate_day3_ex8_photo, intermediate_day3_ex9_photo;
    FrameLayout intermediate_day3_ex1_layout, intermediate_day3_ex2_layout, intermediate_day3_ex3_layout, intermediate_day3_ex4_layout, intermediate_day3_ex5_layout;
    FrameLayout intermediate_day3_ex6_layout, intermediate_day3_ex7_layout, intermediate_day3_ex8_layout, intermediate_day3_ex9_layout;
    FrameLayout intermediate_day3_rest1_layout, intermediate_day3_rest2_layout, intermediate_day3_rest3_layout, intermediate_day3_rest4_layout;
    FrameLayout intermediate_day3_rest5_layout, intermediate_day3_rest6_layout, intermediate_day3_rest7_layout, intermediate_day3_rest8_layout;
    AppCompatButton day3Rest1IntermediateStartButton, day3Rest2IntermediateStartButton, day3Rest3IntermediateStartButton, day3Rest4IntermediateStartButton;
    AppCompatButton day3Rest5IntermediateStartButton, day3Rest6IntermediateStartButton, day3Rest7IntermediateStartButton, day3Rest8IntermediateStartButton;
    AppCompatButton day3Rest1IntermediateFinishButton, day3Rest2IntermediateFinishButton, day3Rest3IntermediateFinishButton, day3Rest4IntermediateFinishButton;
    AppCompatButton day3Rest5IntermediateFinishButton, day3Rest6IntermediateFinishButton, day3Rest7IntermediateFinishButton, day3Rest8IntermediateFinishButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_intermediate);

        day3IntermediateBackButton = findViewById(R.id.day3IntermediateBackButton);

        aboutDay3Ex1IntermediateButton = findViewById(R.id.aboutDay3Ex1IntermediateButton);
        aboutDay3Ex2IntermediateButton = findViewById(R.id.aboutDay3Ex2IntermediateButton);
        aboutDay3Ex3IntermediateButton = findViewById(R.id.aboutDay3Ex3IntermediateButton);
        aboutDay3Ex4IntermediateButton = findViewById(R.id.aboutDay3Ex4IntermediateButton);
        aboutDay3Ex5IntermediateButton = findViewById(R.id.aboutDay3Ex5IntermediateButton);
        aboutDay3Ex6IntermediateButton = findViewById(R.id.aboutDay3Ex6IntermediateButton);
        aboutDay3Ex7IntermediateButton = findViewById(R.id.aboutDay3Ex7IntermediateButton);
        aboutDay3Ex8IntermediateButton = findViewById(R.id.aboutDay3Ex8IntermediateButton);
        aboutDay3Ex9IntermediateButton = findViewById(R.id.aboutDay3Ex9IntermediateButton);

        day3Ex1IntermediateStartButton = findViewById(R.id.day3Ex1IntermediateStartButton);
        day3Ex2IntermediateStartButton = findViewById(R.id.day3Ex2IntermediateStartButton);
        day3Ex3IntermediateStartButton = findViewById(R.id.day3Ex3IntermediateStartButton);
        day3Ex4IntermediateStartButton = findViewById(R.id.day3Ex4IntermediateStartButton);
        day3Ex5IntermediateStartButton = findViewById(R.id.day3Ex5IntermediateStartButton);
        day3Ex6IntermediateStartButton = findViewById(R.id.day3Ex6IntermediateStartButton);
        day3Ex7IntermediateStartButton = findViewById(R.id.day3Ex7IntermediateStartButton);
        day3Ex8IntermediateStartButton = findViewById(R.id.day3Ex8IntermediateStartButton);
        day3Ex9IntermediateStartButton = findViewById(R.id.day3Ex9IntermediateStartButton);

        day3Ex1IntermediateNextButton = findViewById(R.id.day3Ex1IntermediateNextButton);
        day3Ex2IntermediateNextButton = findViewById(R.id.day3Ex2IntermediateNextButton);
        day3Ex3IntermediateNextButton = findViewById(R.id.day3Ex3IntermediateNextButton);
        day3Ex4IntermediateNextButton = findViewById(R.id.day3Ex4IntermediateNextButton);
        day3Ex5IntermediateNextButton = findViewById(R.id.day3Ex5IntermediateNextButton);
        day3Ex6IntermediateNextButton = findViewById(R.id.day3Ex6IntermediateNextButton);
        day3Ex7IntermediateNextButton = findViewById(R.id.day3Ex7IntermediateNextButton);
        day3Ex8IntermediateNextButton = findViewById(R.id.day3Ex8IntermediateNextButton);
        day3Ex9IntermediateNextButton = findViewById(R.id.day3Ex9IntermediateNextButton);

        intermediate_day3_ex1_layout = findViewById(R.id.intermediate_day3_ex1_layout);
        intermediate_day3_ex2_layout = findViewById(R.id.intermediate_day3_ex2_layout);
        intermediate_day3_ex3_layout = findViewById(R.id.intermediate_day3_ex3_layout);
        intermediate_day3_ex4_layout = findViewById(R.id.intermediate_day3_ex4_layout);
        intermediate_day3_ex5_layout = findViewById(R.id.intermediate_day3_ex5_layout);
        intermediate_day3_ex6_layout = findViewById(R.id.intermediate_day3_ex6_layout);
        intermediate_day3_ex7_layout = findViewById(R.id.intermediate_day3_ex7_layout);
        intermediate_day3_ex8_layout = findViewById(R.id.intermediate_day3_ex8_layout);
        intermediate_day3_ex9_layout = findViewById(R.id.intermediate_day3_ex9_layout);

        intermediate_day3_rest1_layout = findViewById(R.id.intermediate_day3_rest1_layout);
        intermediate_day3_rest2_layout = findViewById(R.id.intermediate_day3_rest2_layout);
        intermediate_day3_rest3_layout = findViewById(R.id.intermediate_day3_rest3_layout);
        intermediate_day3_rest4_layout = findViewById(R.id.intermediate_day3_rest4_layout);
        intermediate_day3_rest5_layout = findViewById(R.id.intermediate_day3_rest5_layout);
        intermediate_day3_rest6_layout = findViewById(R.id.intermediate_day3_rest6_layout);
        intermediate_day3_rest7_layout = findViewById(R.id.intermediate_day3_rest7_layout);
        intermediate_day3_rest8_layout = findViewById(R.id.intermediate_day3_rest8_layout);

        day3Rest1IntermediateStartButton = findViewById(R.id.day3Rest1IntermediateStartButton);
        day3Rest2IntermediateStartButton = findViewById(R.id.day3Rest2IntermediateStartButton);
        day3Rest3IntermediateStartButton = findViewById(R.id.day3Rest3IntermediateStartButton);
        day3Rest4IntermediateStartButton = findViewById(R.id.day3Rest4IntermediateStartButton);
        day3Rest5IntermediateStartButton = findViewById(R.id.day3Rest5IntermediateStartButton);
        day3Rest6IntermediateStartButton = findViewById(R.id.day3Rest6IntermediateStartButton);
        day3Rest7IntermediateStartButton = findViewById(R.id.day3Rest7IntermediateStartButton);
        day3Rest8IntermediateStartButton = findViewById(R.id.day3Rest8IntermediateStartButton);

        day3Rest1IntermediateFinishButton = findViewById(R.id.day3Rest1IntermediateFinishButton);
        day3Rest2IntermediateFinishButton = findViewById(R.id.day3Rest2IntermediateFinishButton);
        day3Rest3IntermediateFinishButton = findViewById(R.id.day3Rest3IntermediateFinishButton);
        day3Rest4IntermediateFinishButton = findViewById(R.id.day3Rest4IntermediateFinishButton);
        day3Rest5IntermediateFinishButton = findViewById(R.id.day3Rest5IntermediateFinishButton);
        day3Rest6IntermediateFinishButton = findViewById(R.id.day3Rest6IntermediateFinishButton);
        day3Rest7IntermediateFinishButton = findViewById(R.id.day3Rest7IntermediateFinishButton);
        day3Rest8IntermediateFinishButton = findViewById(R.id.day3Rest8IntermediateFinishButton);

        intermediate_day3_ex1_photo = findViewById(R.id.intermediate_day3_ex1_photo);
        intermediate_day3_ex2_photo = findViewById(R.id.intermediate_day3_ex2_photo);
        intermediate_day3_ex3_photo = findViewById(R.id.intermediate_day3_ex3_photo);
        intermediate_day3_ex4_photo = findViewById(R.id.intermediate_day3_ex4_photo);
        intermediate_day3_ex5_photo = findViewById(R.id.intermediate_day3_ex5_photo);
        intermediate_day3_ex6_photo = findViewById(R.id.intermediate_day3_ex6_photo);
        intermediate_day3_ex7_photo = findViewById(R.id.intermediate_day3_ex7_photo);
        intermediate_day3_ex8_photo = findViewById(R.id.intermediate_day3_ex8_photo);
        intermediate_day3_ex9_photo = findViewById(R.id.intermediate_day3_ex9_photo);

        Glide.with(this).load(R.drawable.lateral_leg_raises_exercise).into(intermediate_day3_ex1_photo);
        Glide.with(this).load(R.drawable.marching_glute_bridge_exercise).into(intermediate_day3_ex2_photo);
        Glide.with(this).load(R.drawable.hip_bridges).into(intermediate_day3_ex3_photo);
        Glide.with(this).load(R.drawable.bicycle_crunches).into(intermediate_day3_ex4_photo);
        Glide.with(this).load(R.drawable.alternating_knee_to_chests).into(intermediate_day3_ex5_photo);
        Glide.with(this).load(R.drawable.side_plank_dips).into(intermediate_day3_ex6_photo);
        Glide.with(this).load(R.drawable.v_ups).into(intermediate_day3_ex7_photo);
        Glide.with(this).load(R.drawable.dead_bugs).into(intermediate_day3_ex8_photo);
        Glide.with(this).load(R.drawable.sit_ups_to_twists).into(intermediate_day3_ex9_photo);

        day3IntermediateBackButton.setOnClickListener(this);

        day3Ex1IntermediateStartButton.setOnClickListener(this);
        day3Ex2IntermediateStartButton.setOnClickListener(this);
        day3Ex3IntermediateStartButton.setOnClickListener(this);
        day3Ex4IntermediateStartButton.setOnClickListener(this);
        day3Ex5IntermediateStartButton.setOnClickListener(this);
        day3Ex6IntermediateStartButton.setOnClickListener(this);
        day3Ex7IntermediateStartButton.setOnClickListener(this);
        day3Ex8IntermediateStartButton.setOnClickListener(this);
        day3Ex9IntermediateStartButton.setOnClickListener(this);

        day3Ex1IntermediateNextButton.setOnClickListener(this);
        day3Ex2IntermediateNextButton.setOnClickListener(this);
        day3Ex3IntermediateNextButton.setOnClickListener(this);
        day3Ex4IntermediateNextButton.setOnClickListener(this);
        day3Ex5IntermediateNextButton.setOnClickListener(this);
        day3Ex6IntermediateNextButton.setOnClickListener(this);
        day3Ex7IntermediateNextButton.setOnClickListener(this);
        day3Ex8IntermediateNextButton.setOnClickListener(this);
        day3Ex9IntermediateNextButton.setOnClickListener(this);

        aboutDay3Ex1IntermediateButton.setOnClickListener(this);
        aboutDay3Ex2IntermediateButton.setOnClickListener(this);
        aboutDay3Ex3IntermediateButton.setOnClickListener(this);
        aboutDay3Ex4IntermediateButton.setOnClickListener(this);
        aboutDay3Ex5IntermediateButton.setOnClickListener(this);
        aboutDay3Ex6IntermediateButton.setOnClickListener(this);
        aboutDay3Ex7IntermediateButton.setOnClickListener(this);
        aboutDay3Ex8IntermediateButton.setOnClickListener(this);
        aboutDay3Ex9IntermediateButton.setOnClickListener(this);

        day3Rest1IntermediateStartButton.setOnClickListener(this);
        day3Rest2IntermediateStartButton.setOnClickListener(this);
        day3Rest3IntermediateStartButton.setOnClickListener(this);
        day3Rest4IntermediateStartButton.setOnClickListener(this);
        day3Rest5IntermediateStartButton.setOnClickListener(this);
        day3Rest6IntermediateStartButton.setOnClickListener(this);
        day3Rest7IntermediateStartButton.setOnClickListener(this);
        day3Rest8IntermediateStartButton.setOnClickListener(this);

        day3Rest1IntermediateFinishButton.setOnClickListener(this);
        day3Rest2IntermediateFinishButton.setOnClickListener(this);
        day3Rest3IntermediateFinishButton.setOnClickListener(this);
        day3Rest4IntermediateFinishButton.setOnClickListener(this);
        day3Rest5IntermediateFinishButton.setOnClickListener(this);
        day3Rest6IntermediateFinishButton.setOnClickListener(this);
        day3Rest7IntermediateFinishButton.setOnClickListener(this);
        day3Rest8IntermediateFinishButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(Day3IntermediateActivity.this, IntermediateWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.day3IntermediateBackButton:
                onBackPressed();
                break;

            case R.id.day3Ex1IntermediateStartButton:
                intermediate_day3_ex1_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex1IntermediateStartButton.setVisibility(View.GONE);
                day3Ex1IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex1IntermediateNextButton:
                intermediate_day3_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest1IntermediateStartButton:
                intermediate_day3_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest1IntermediateStartButton.setVisibility(View.GONE);
                day3Rest1IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest1IntermediateFinishButton:
                intermediate_day3_rest1_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex2IntermediateStartButton:
                intermediate_day3_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex2IntermediateStartButton.setVisibility(View.GONE);
                day3Ex2IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex2IntermediateNextButton:
                intermediate_day3_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest2IntermediateStartButton:
                intermediate_day3_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest2IntermediateStartButton.setVisibility(View.GONE);
                day3Rest2IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest2IntermediateFinishButton:
                intermediate_day3_rest2_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex3IntermediateStartButton:
                intermediate_day3_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex3IntermediateStartButton.setVisibility(View.GONE);
                day3Ex3IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex3IntermediateNextButton:
                intermediate_day3_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest3IntermediateStartButton:
                intermediate_day3_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest3IntermediateStartButton.setVisibility(View.GONE);
                day3Rest3IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest3IntermediateFinishButton:
                intermediate_day3_rest3_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex4IntermediateStartButton:
                intermediate_day3_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex4IntermediateStartButton.setVisibility(View.GONE);
                day3Ex4IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex4IntermediateNextButton:
                intermediate_day3_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest4IntermediateStartButton:
                intermediate_day3_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest4IntermediateStartButton.setVisibility(View.GONE);
                day3Rest4IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest4IntermediateFinishButton:
                intermediate_day3_rest4_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex5IntermediateStartButton:
                intermediate_day3_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex5IntermediateStartButton.setVisibility(View.GONE);
                day3Ex5IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex5IntermediateNextButton:
                intermediate_day3_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest5IntermediateStartButton:
                intermediate_day3_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest5IntermediateStartButton.setVisibility(View.GONE);
                day3Rest5IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest5IntermediateFinishButton:
                intermediate_day3_rest5_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex6IntermediateStartButton:
                intermediate_day3_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex6IntermediateStartButton.setVisibility(View.GONE);
                day3Ex6IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex6IntermediateNextButton:
                intermediate_day3_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest6IntermediateStartButton:
                intermediate_day3_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest6IntermediateStartButton.setVisibility(View.GONE);
                day3Rest6IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest6IntermediateFinishButton:
                intermediate_day3_rest6_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex7IntermediateStartButton:
                intermediate_day3_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex7IntermediateStartButton.setVisibility(View.GONE);
                day3Ex7IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex7IntermediateNextButton:
                intermediate_day3_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest7IntermediateStartButton:
                intermediate_day3_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest7IntermediateStartButton.setVisibility(View.GONE);
                day3Rest7IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest7IntermediateFinishButton:
                intermediate_day3_rest7_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Ex8IntermediateStartButton:
                intermediate_day3_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Ex8IntermediateStartButton.setVisibility(View.GONE);
                day3Ex8IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex8IntermediateNextButton:
                intermediate_day3_rest8_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                break;

            case R.id.day3Rest8IntermediateStartButton:
                intermediate_day3_rest8_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.GONE);
                day3Rest8IntermediateStartButton.setVisibility(View.GONE);
                day3Rest8IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Rest8IntermediateFinishButton:
                intermediate_day3_rest8_layout.setVisibility(View.GONE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                intermediate_day3_ex9_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex9IntermediateStartButton:
                intermediate_day3_ex9_layout.setVisibility(View.VISIBLE);
                intermediate_day3_ex1_layout.setVisibility(View.GONE);
                intermediate_day3_ex2_layout.setVisibility(View.GONE);
                intermediate_day3_ex3_layout.setVisibility(View.GONE);
                intermediate_day3_ex4_layout.setVisibility(View.GONE);
                intermediate_day3_ex5_layout.setVisibility(View.GONE);
                intermediate_day3_ex6_layout.setVisibility(View.GONE);
                intermediate_day3_ex7_layout.setVisibility(View.GONE);
                intermediate_day3_ex8_layout.setVisibility(View.GONE);
                day3Ex9IntermediateStartButton.setVisibility(View.GONE);
                day3Ex9IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day3Ex9IntermediateNextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3IntermediateActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3IntermediateActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 3")) {

                                                                    Toast.makeText(Day3IntermediateActivity.this, "You're already done for day 3!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 3").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day3IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

            case R.id.aboutDay3Ex1IntermediateButton:
                final DialogPlus about = DialogPlus.newDialog(Day3IntermediateActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }

}