package com.example.ligtas.ui.monitorHealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ligtas.R;

public class HealthAssessmentActivity extends AppCompatActivity {

    AppCompatImageView fromhaTomyh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_assessment);

        fromhaTomyh = findViewById(R.id.fromhaTomyh);


        fromhaTomyh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent tomyh = new Intent(HealthAssessmentActivity.this, MonitorYourHealthActivity.class);
        tomyh.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        tomyh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(tomyh);
        finish();
    }
}