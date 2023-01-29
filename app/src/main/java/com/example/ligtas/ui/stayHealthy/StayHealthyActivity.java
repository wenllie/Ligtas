package com.example.ligtas.ui.stayHealthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;
import com.google.android.material.snackbar.Snackbar;

public class StayHealthyActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView fromStayHealthyToDashboard;
    CardView waterIntakeTrackerCardView, workoutPlansCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_healthy);

        fromStayHealthyToDashboard = findViewById(R.id.fromStayHealthyToDashboard);
        waterIntakeTrackerCardView = findViewById(R.id.waterIntakeTrackerCardView);
        workoutPlansCardView = findViewById(R.id.workoutPlansCardView);

        fromStayHealthyToDashboard.setOnClickListener(this);
        waterIntakeTrackerCardView.setOnClickListener(this);
        workoutPlansCardView.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toDashboard = new Intent(StayHealthyActivity.this, UserNavigationActivity.class);
        toDashboard.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toDashboard);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.waterIntakeTrackerCardView:
                startActivity(new Intent(StayHealthyActivity.this, WaterIntakeActivity.class));
                finish();
                break;

            case R.id.workoutPlansCardView:
                startActivity(new Intent(StayHealthyActivity.this, WorkoutPlansActivity.class));
                finish();
                break;

            case R.id.fromStayHealthyToDashboard:
                onBackPressed();
                break;

        }
    }
}