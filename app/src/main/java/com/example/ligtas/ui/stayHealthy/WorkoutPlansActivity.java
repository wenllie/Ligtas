package com.example.ligtas.ui.stayHealthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ligtas.R;
import com.example.ligtas.ui.settings.SettingsActivity;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class WorkoutPlansActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView fromWPToStayHealthy, aboutWorkOutPlanImageView;
    AppCompatButton workoutBeginnerButton, workoutIntermediateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans);

        fromWPToStayHealthy = findViewById(R.id.fromWPToStayHealthy);
        aboutWorkOutPlanImageView = findViewById(R.id.aboutWorkOutPlanImageView);
        workoutBeginnerButton = findViewById(R.id.workoutBeginnerButton);
        workoutIntermediateButton = findViewById(R.id.workoutIntermediateButton);

        fromWPToStayHealthy.setOnClickListener(this);
        aboutWorkOutPlanImageView.setOnClickListener(this);
        workoutBeginnerButton.setOnClickListener(this);
        workoutIntermediateButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(WorkoutPlansActivity.this, StayHealthyActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fromWPToStayHealthy:
                onBackPressed();
                break;

            case R.id.aboutWorkOutPlanImageView:
                final DialogPlus about = DialogPlus.newDialog(WorkoutPlansActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_about_workout_plans))
                        .setExpanded(true, 800)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                about.show();
                break;

            case R.id.workoutBeginnerButton:
                startActivity(new Intent(WorkoutPlansActivity.this, BeginnerWorkoutActivity.class));
                finish();
                break;

            case R.id.workoutIntermediateButton:
                startActivity(new Intent(WorkoutPlansActivity.this, IntermediateWorkoutActivity.class));
                finish();
                break;

        }
    }
}