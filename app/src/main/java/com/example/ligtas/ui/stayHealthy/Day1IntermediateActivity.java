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

public class Day1IntermediateActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView day1IntermediateBackButton;
    AppCompatButton day1Ex1IntermediateStartButton, day1Ex2IntermediateStartButton, day1Ex3IntermediateStartButton, day1Ex4IntermediateStartButton, day1Ex5IntermediateStartButton;
    AppCompatButton day1Ex6IntermediateStartButton, day1Ex7IntermediateStartButton, day1Ex8IntermediateStartButton, day1Ex9IntermediateStartButton, day1Ex10IntermediateStartButton;
    AppCompatButton day1Ex1IntermediateNextButton, day1Ex2IntermediateNextButton, day1Ex3IntermediateNextButton, day1Ex4IntermediateNextButton, day1Ex5IntermediateNextButton;
    AppCompatButton day1Ex6IntermediateNextButton, day1Ex7IntermediateNextButton, day1Ex8IntermediateNextButton, day1Ex9IntermediateNextButton, day1Ex10IntermediateNextButton;
    AppCompatImageView aboutDay1Ex1IntermediateButton, aboutDay1Ex2IntermediateButton, aboutDay1Ex3IntermediateButton, aboutDay1Ex4IntermediateButton, aboutDay1Ex5IntermediateButton;
    AppCompatImageView aboutDay1Ex6IntermediateButton, aboutDay1Ex7IntermediateButton, aboutDay1Ex8IntermediateButton, aboutDay1Ex9IntermediateButton, aboutDay1Ex10IntermediateButton;
    AppCompatImageView intermediate_day1_ex1_photo, intermediate_day1_ex2_photo, intermediate_day1_ex3_photo, intermediate_day1_ex4_photo, intermediate_day1_ex5_photo;
    AppCompatImageView intermediate_day1_ex6_photo, intermediate_day1_ex7_photo, intermediate_day1_ex8_photo, intermediate_day1_ex9_photo, intermediate_day1_ex10_photo;
    FrameLayout intermediate_day1_ex1_layout, intermediate_day1_ex2_layout, intermediate_day1_ex3_layout, intermediate_day1_ex4_layout, intermediate_day1_ex5_layout;
    FrameLayout intermediate_day1_ex6_layout, intermediate_day1_ex7_layout, intermediate_day1_ex8_layout, intermediate_day1_ex9_layout, intermediate_day1_ex10_layout;
    FrameLayout intermediate_day1_rest1_layout, intermediate_day1_rest2_layout, intermediate_day1_rest3_layout, intermediate_day1_rest4_layout;
    FrameLayout intermediate_day1_rest5_layout, intermediate_day1_rest6_layout, intermediate_day1_rest7_layout, intermediate_day1_rest8_layout, intermediate_day1_rest9_layout;
    AppCompatButton day1Rest1IntermediateStartButton, day1Rest2IntermediateStartButton, day1Rest3IntermediateStartButton, day1Rest4IntermediateStartButton;
    AppCompatButton day1Rest5IntermediateStartButton, day1Rest6IntermediateStartButton, day1Rest7IntermediateStartButton, day1Rest8IntermediateStartButton, day1Rest9IntermediateStartButton;
    AppCompatButton day1Rest1IntermediateFinishButton, day1Rest2IntermediateFinishButton, day1Rest3IntermediateFinishButton, day1Rest4IntermediateFinishButton;
    AppCompatButton day1Rest5IntermediateFinishButton, day1Rest6IntermediateFinishButton, day1Rest7IntermediateFinishButton, day1Rest8IntermediateFinishButton, day1Rest9IntermediateFinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_intermediate);

        day1IntermediateBackButton = findViewById(R.id.day1IntermediateBackButton);

        aboutDay1Ex1IntermediateButton = findViewById(R.id.aboutDay1Ex1IntermediateButton);
        aboutDay1Ex2IntermediateButton = findViewById(R.id.aboutDay1Ex2IntermediateButton);
        aboutDay1Ex3IntermediateButton = findViewById(R.id.aboutDay1Ex3IntermediateButton);
        aboutDay1Ex4IntermediateButton = findViewById(R.id.aboutDay1Ex4IntermediateButton);
        aboutDay1Ex5IntermediateButton = findViewById(R.id.aboutDay1Ex5IntermediateButton);
        aboutDay1Ex6IntermediateButton = findViewById(R.id.aboutDay1Ex6IntermediateButton);
        aboutDay1Ex7IntermediateButton = findViewById(R.id.aboutDay1Ex7IntermediateButton);
        aboutDay1Ex8IntermediateButton = findViewById(R.id.aboutDay1Ex8IntermediateButton);
        aboutDay1Ex9IntermediateButton = findViewById(R.id.aboutDay1Ex9IntermediateButton);
        aboutDay1Ex10IntermediateButton = findViewById(R.id.aboutDay1Ex10IntermediateButton);

        day1Ex1IntermediateStartButton = findViewById(R.id.day1Ex1IntermediateStartButton);
        day1Ex2IntermediateStartButton = findViewById(R.id.day1Ex2IntermediateStartButton);
        day1Ex3IntermediateStartButton = findViewById(R.id.day1Ex3IntermediateStartButton);
        day1Ex4IntermediateStartButton = findViewById(R.id.day1Ex4IntermediateStartButton);
        day1Ex5IntermediateStartButton = findViewById(R.id.day1Ex5IntermediateStartButton);
        day1Ex6IntermediateStartButton = findViewById(R.id.day1Ex6IntermediateStartButton);
        day1Ex7IntermediateStartButton = findViewById(R.id.day1Ex7IntermediateStartButton);
        day1Ex8IntermediateStartButton = findViewById(R.id.day1Ex8IntermediateStartButton);
        day1Ex9IntermediateStartButton = findViewById(R.id.day1Ex9IntermediateStartButton);
        day1Ex10IntermediateStartButton = findViewById(R.id.day1Ex10IntermediateStartButton);

        day1Ex1IntermediateNextButton = findViewById(R.id.day1Ex1IntermediateNextButton);
        day1Ex2IntermediateNextButton = findViewById(R.id.day1Ex2IntermediateNextButton);
        day1Ex3IntermediateNextButton = findViewById(R.id.day1Ex3IntermediateNextButton);
        day1Ex4IntermediateNextButton = findViewById(R.id.day1Ex4IntermediateNextButton);
        day1Ex5IntermediateNextButton = findViewById(R.id.day1Ex5IntermediateNextButton);
        day1Ex6IntermediateNextButton = findViewById(R.id.day1Ex6IntermediateNextButton);
        day1Ex7IntermediateNextButton = findViewById(R.id.day1Ex7IntermediateNextButton);
        day1Ex8IntermediateNextButton = findViewById(R.id.day1Ex8IntermediateNextButton);
        day1Ex9IntermediateNextButton = findViewById(R.id.day1Ex9IntermediateNextButton);
        day1Ex10IntermediateNextButton = findViewById(R.id.day1Ex10IntermediateNextButton);

        intermediate_day1_ex1_layout = findViewById(R.id.intermediate_day1_ex1_layout);
        intermediate_day1_ex2_layout = findViewById(R.id.intermediate_day1_ex2_layout);
        intermediate_day1_ex3_layout = findViewById(R.id.intermediate_day1_ex3_layout);
        intermediate_day1_ex4_layout = findViewById(R.id.intermediate_day1_ex4_layout);
        intermediate_day1_ex5_layout = findViewById(R.id.intermediate_day1_ex5_layout);
        intermediate_day1_ex6_layout = findViewById(R.id.intermediate_day1_ex6_layout);
        intermediate_day1_ex7_layout = findViewById(R.id.intermediate_day1_ex7_layout);
        intermediate_day1_ex8_layout = findViewById(R.id.intermediate_day1_ex8_layout);
        intermediate_day1_ex9_layout = findViewById(R.id.intermediate_day1_ex9_layout);
        intermediate_day1_ex10_layout = findViewById(R.id.intermediate_day1_ex10_layout);

        intermediate_day1_rest1_layout = findViewById(R.id.intermediate_day1_rest1_layout);
        intermediate_day1_rest2_layout = findViewById(R.id.intermediate_day1_rest2_layout);
        intermediate_day1_rest3_layout = findViewById(R.id.intermediate_day1_rest3_layout);
        intermediate_day1_rest4_layout = findViewById(R.id.intermediate_day1_rest4_layout);
        intermediate_day1_rest5_layout = findViewById(R.id.intermediate_day1_rest5_layout);
        intermediate_day1_rest6_layout = findViewById(R.id.intermediate_day1_rest6_layout);
        intermediate_day1_rest7_layout = findViewById(R.id.intermediate_day1_rest7_layout);
        intermediate_day1_rest8_layout = findViewById(R.id.intermediate_day1_rest8_layout);
        intermediate_day1_rest9_layout = findViewById(R.id.intermediate_day1_rest9_layout);

        day1Rest1IntermediateStartButton = findViewById(R.id.day1Rest1IntermediateStartButton);
        day1Rest2IntermediateStartButton = findViewById(R.id.day1Rest2IntermediateStartButton);
        day1Rest3IntermediateStartButton = findViewById(R.id.day1Rest3IntermediateStartButton);
        day1Rest4IntermediateStartButton = findViewById(R.id.day1Rest4IntermediateStartButton);
        day1Rest5IntermediateStartButton = findViewById(R.id.day1Rest5IntermediateStartButton);
        day1Rest6IntermediateStartButton = findViewById(R.id.day1Rest6IntermediateStartButton);
        day1Rest7IntermediateStartButton = findViewById(R.id.day1Rest7IntermediateStartButton);
        day1Rest8IntermediateStartButton = findViewById(R.id.day1Rest8IntermediateStartButton);
        day1Rest9IntermediateStartButton = findViewById(R.id.day1Rest9IntermediateStartButton);

        day1Rest1IntermediateFinishButton = findViewById(R.id.day1Rest1IntermediateFinishButton);
        day1Rest2IntermediateFinishButton = findViewById(R.id.day1Rest2IntermediateFinishButton);
        day1Rest3IntermediateFinishButton = findViewById(R.id.day1Rest3IntermediateFinishButton);
        day1Rest4IntermediateFinishButton = findViewById(R.id.day1Rest4IntermediateFinishButton);
        day1Rest5IntermediateFinishButton = findViewById(R.id.day1Rest5IntermediateFinishButton);
        day1Rest6IntermediateFinishButton = findViewById(R.id.day1Rest6IntermediateFinishButton);
        day1Rest7IntermediateFinishButton = findViewById(R.id.day1Rest7IntermediateFinishButton);
        day1Rest8IntermediateFinishButton = findViewById(R.id.day1Rest8IntermediateFinishButton);
        day1Rest9IntermediateFinishButton = findViewById(R.id.day1Rest9IntermediateFinishButton);

        intermediate_day1_ex1_photo = findViewById(R.id.intermediate_day1_ex1_photo);
        intermediate_day1_ex2_photo = findViewById(R.id.intermediate_day1_ex2_photo);
        intermediate_day1_ex3_photo = findViewById(R.id.intermediate_day1_ex3_photo);
        intermediate_day1_ex4_photo = findViewById(R.id.intermediate_day1_ex4_photo);
        intermediate_day1_ex5_photo = findViewById(R.id.intermediate_day1_ex5_photo);
        intermediate_day1_ex6_photo = findViewById(R.id.intermediate_day1_ex6_photo);
        intermediate_day1_ex7_photo = findViewById(R.id.intermediate_day1_ex7_photo);
        intermediate_day1_ex8_photo = findViewById(R.id.intermediate_day1_ex8_photo);
        intermediate_day1_ex9_photo = findViewById(R.id.intermediate_day1_ex9_photo);
        intermediate_day1_ex10_photo = findViewById(R.id.intermediate_day1_ex10_photo);


        day1IntermediateBackButton.setOnClickListener(this);

        day1Ex1IntermediateStartButton.setOnClickListener(this);
        day1Ex2IntermediateStartButton.setOnClickListener(this);
        day1Ex3IntermediateStartButton.setOnClickListener(this);
        day1Ex4IntermediateStartButton.setOnClickListener(this);
        day1Ex5IntermediateStartButton.setOnClickListener(this);
        day1Ex6IntermediateStartButton.setOnClickListener(this);
        day1Ex7IntermediateStartButton.setOnClickListener(this);
        day1Ex8IntermediateStartButton.setOnClickListener(this);
        day1Ex9IntermediateStartButton.setOnClickListener(this);
        day1Ex10IntermediateStartButton.setOnClickListener(this);

        day1Ex1IntermediateNextButton.setOnClickListener(this);
        day1Ex2IntermediateNextButton.setOnClickListener(this);
        day1Ex3IntermediateNextButton.setOnClickListener(this);
        day1Ex4IntermediateNextButton.setOnClickListener(this);
        day1Ex5IntermediateNextButton.setOnClickListener(this);
        day1Ex6IntermediateNextButton.setOnClickListener(this);
        day1Ex7IntermediateNextButton.setOnClickListener(this);
        day1Ex8IntermediateNextButton.setOnClickListener(this);
        day1Ex9IntermediateNextButton.setOnClickListener(this);
        day1Ex10IntermediateNextButton.setOnClickListener(this);

        aboutDay1Ex1IntermediateButton.setOnClickListener(this);
        aboutDay1Ex2IntermediateButton.setOnClickListener(this);
        aboutDay1Ex3IntermediateButton.setOnClickListener(this);
        aboutDay1Ex4IntermediateButton.setOnClickListener(this);
        aboutDay1Ex5IntermediateButton.setOnClickListener(this);
        aboutDay1Ex6IntermediateButton.setOnClickListener(this);
        aboutDay1Ex7IntermediateButton.setOnClickListener(this);
        aboutDay1Ex8IntermediateButton.setOnClickListener(this);
        aboutDay1Ex9IntermediateButton.setOnClickListener(this);
        aboutDay1Ex10IntermediateButton.setOnClickListener(this);

        day1Rest1IntermediateStartButton.setOnClickListener(this);
        day1Rest2IntermediateStartButton.setOnClickListener(this);
        day1Rest3IntermediateStartButton.setOnClickListener(this);
        day1Rest4IntermediateStartButton.setOnClickListener(this);
        day1Rest5IntermediateStartButton.setOnClickListener(this);
        day1Rest6IntermediateStartButton.setOnClickListener(this);
        day1Rest7IntermediateStartButton.setOnClickListener(this);
        day1Rest8IntermediateStartButton.setOnClickListener(this);
        day1Rest9IntermediateStartButton.setOnClickListener(this);

        day1Rest1IntermediateFinishButton.setOnClickListener(this);
        day1Rest2IntermediateFinishButton.setOnClickListener(this);
        day1Rest3IntermediateFinishButton.setOnClickListener(this);
        day1Rest4IntermediateFinishButton.setOnClickListener(this);
        day1Rest5IntermediateFinishButton.setOnClickListener(this);
        day1Rest6IntermediateFinishButton.setOnClickListener(this);
        day1Rest7IntermediateFinishButton.setOnClickListener(this);
        day1Rest8IntermediateFinishButton.setOnClickListener(this);
        day1Rest9IntermediateFinishButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(Day1IntermediateActivity.this, IntermediateWorkoutActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.day1IntermediateBackButton:
                onBackPressed();
                break;

            case R.id.day1Ex1IntermediateStartButton:
                intermediate_day1_ex1_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex1_photo);
                day1Ex1IntermediateStartButton.setVisibility(View.GONE);
                day1Ex1IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex1IntermediateNextButton:
                intermediate_day1_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex2_photo);
                break;

            case R.id.day1Rest1IntermediateStartButton:
                intermediate_day1_rest1_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest1IntermediateStartButton.setVisibility(View.GONE);
                day1Rest1IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest1IntermediateFinishButton:
                intermediate_day1_rest1_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex2IntermediateStartButton:
                intermediate_day1_ex2_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex2IntermediateStartButton.setVisibility(View.GONE);
                day1Ex2IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex2IntermediateNextButton:
                intermediate_day1_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex3_photo);
                break;

            case R.id.day1Rest2IntermediateStartButton:
                intermediate_day1_rest2_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest2IntermediateStartButton.setVisibility(View.GONE);
                day1Rest2IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest2IntermediateFinishButton:
                intermediate_day1_rest2_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex3IntermediateStartButton:
                intermediate_day1_ex3_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex3IntermediateStartButton.setVisibility(View.GONE);
                day1Ex3IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex3IntermediateNextButton:
                intermediate_day1_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex4_photo);
                break;

            case R.id.day1Rest3IntermediateStartButton:
                intermediate_day1_rest3_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest3IntermediateStartButton.setVisibility(View.GONE);
                day1Rest3IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest3IntermediateFinishButton:
                intermediate_day1_rest3_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex4IntermediateStartButton:
                intermediate_day1_ex4_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex4IntermediateStartButton.setVisibility(View.GONE);
                day1Ex4IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex4IntermediateNextButton:
                intermediate_day1_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex5_photo);
                break;

            case R.id.day1Rest4IntermediateStartButton:
                intermediate_day1_rest4_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest4IntermediateStartButton.setVisibility(View.GONE);
                day1Rest4IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest4IntermediateFinishButton:
                intermediate_day1_rest4_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex5IntermediateStartButton:
                intermediate_day1_ex5_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex5IntermediateStartButton.setVisibility(View.GONE);
                day1Ex5IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex5IntermediateNextButton:
                intermediate_day1_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex6_photo);
                break;

            case R.id.day1Rest5IntermediateStartButton:
                intermediate_day1_rest5_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest5IntermediateStartButton.setVisibility(View.GONE);
                day1Rest5IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest5IntermediateFinishButton:
                intermediate_day1_rest5_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex6IntermediateStartButton:
                intermediate_day1_ex6_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex6IntermediateStartButton.setVisibility(View.GONE);
                day1Ex6IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex6IntermediateNextButton:
                intermediate_day1_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex7_photo);
                break;

            case R.id.day1Rest6IntermediateStartButton:
                intermediate_day1_rest6_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest6IntermediateStartButton.setVisibility(View.GONE);
                day1Rest6IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest6IntermediateFinishButton:
                intermediate_day1_rest6_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex7IntermediateStartButton:
                intermediate_day1_ex7_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex7IntermediateStartButton.setVisibility(View.GONE);
                day1Ex7IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex7IntermediateNextButton:
                intermediate_day1_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex8_photo);
                break;

            case R.id.day1Rest7IntermediateStartButton:
                intermediate_day1_rest7_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest7IntermediateStartButton.setVisibility(View.GONE);
                day1Rest7IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest7IntermediateFinishButton:
                intermediate_day1_rest7_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex8IntermediateStartButton:
                intermediate_day1_ex8_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex8IntermediateStartButton.setVisibility(View.GONE);
                day1Ex8IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex8IntermediateNextButton:
                intermediate_day1_rest8_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex9_photo);
                break;

            case R.id.day1Rest8IntermediateStartButton:
                intermediate_day1_rest8_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest8IntermediateStartButton.setVisibility(View.GONE);
                day1Rest8IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest8IntermediateFinishButton:
                intermediate_day1_rest8_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                break;

            case R.id.day1Ex9IntermediateStartButton:
                intermediate_day1_ex9_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Ex9IntermediateStartButton.setVisibility(View.GONE);
                day1Ex9IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex9IntermediateNextButton:
                intermediate_day1_rest9_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);

                Glide.with(this).load(R.drawable.squats_exercise).into(intermediate_day1_ex10_photo);
                break;

            case R.id.day1Rest9IntermediateStartButton:
                intermediate_day1_rest9_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.GONE);
                day1Rest9IntermediateStartButton.setVisibility(View.GONE);
                day1Rest9IntermediateFinishButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Rest9IntermediateFinishButton:
                intermediate_day1_rest9_layout.setVisibility(View.GONE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                intermediate_day1_ex10_layout.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex10IntermediateStartButton:
                intermediate_day1_ex10_layout.setVisibility(View.VISIBLE);
                intermediate_day1_ex1_layout.setVisibility(View.GONE);
                intermediate_day1_ex2_layout.setVisibility(View.GONE);
                intermediate_day1_ex3_layout.setVisibility(View.GONE);
                intermediate_day1_ex4_layout.setVisibility(View.GONE);
                intermediate_day1_ex5_layout.setVisibility(View.GONE);
                intermediate_day1_ex6_layout.setVisibility(View.GONE);
                intermediate_day1_ex7_layout.setVisibility(View.GONE);
                intermediate_day1_ex8_layout.setVisibility(View.GONE);
                intermediate_day1_ex9_layout.setVisibility(View.GONE);
                day1Ex10IntermediateStartButton.setVisibility(View.GONE);
                day1Ex10IntermediateNextButton.setVisibility(View.VISIBLE);
                break;

            case R.id.day1Ex10IntermediateNextButton:

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

                                                                if (dayKey.equalsIgnoreCase("Day 1")) {

                                                                    Toast.makeText(Day1IntermediateActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }
                                                        }
                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 1")) {

                                                                    Toast.makeText(Day1IntermediateActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }
                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

                                                                if (dayKey.equalsIgnoreCase("Day 1")) {

                                                                    Toast.makeText(Day1IntermediateActivity.this, "You're already done for day 1!", Toast.LENGTH_SHORT).show();


                                                                } else {


                                                                }

                                                            }

                                                        }

                                                    }

                                                } else {

                                                    workoutReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Workouts").child("Intermediate").child("Day 1").child("Result").setValue("Completed");
                                                    Intent toStayHealthy = new Intent(Day1IntermediateActivity.this, IntermediateWorkoutActivity.class);
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

            case R.id.aboutDay1Ex1IntermediateButton:
                final DialogPlus about = DialogPlus.newDialog(Day1IntermediateActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_beginner_day1_ex1))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

        }

    }
}