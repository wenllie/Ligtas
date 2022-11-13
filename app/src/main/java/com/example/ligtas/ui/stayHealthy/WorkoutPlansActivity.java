package com.example.ligtas.ui.stayHealthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ligtas.R;

public class WorkoutPlansActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView fromWPToStayHealthy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans);

        fromWPToStayHealthy = findViewById(R.id.fromWPToStayHealthy);

        fromWPToStayHealthy.setOnClickListener(this);
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

        }
    }
}