package com.example.ligtas.ui.stayHealthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;

public class WaterIntakeActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView fromWIToStayHealthy;
    AppCompatButton drinkWaterbtn;
    AppCompatTextView drinkWaterCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

        fromWIToStayHealthy = findViewById(R.id.fromWIToStayHealthy);
        drinkWaterbtn = findViewById(R.id.drinkWaterbtn);
        drinkWaterCount = findViewById(R.id.drinkWaterCount);

        fromWIToStayHealthy.setOnClickListener(this);
        drinkWaterbtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(WaterIntakeActivity.this, StayHealthyActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fromWIToStayHealthy:
                onBackPressed();
                break;

            case R.id.drinkWaterbtn:
                /*int count = 0;
                for (int i = 0; i < 10; i++) {

                    drinkWaterCount.setText(String.valueOf(i+1));

                }*/
                break;

        }
    }
}