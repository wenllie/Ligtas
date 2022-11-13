package com.example.ligtas.ui.termsAndConditions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ligtas.MainActivity;
import com.example.ligtas.R;
import com.example.ligtas.RegisterActivity;
import com.example.ligtas.UserNavigationActivity;

public class TermsAndConditionsActivity extends AppCompatActivity {

    AppCompatImageView backArrowTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        backArrowTerms = findViewById(R.id.backArrowTerms);

        backArrowTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent toDashboard = new Intent(TermsAndConditionsActivity.this, UserNavigationActivity.class);
        toDashboard.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toDashboard);
        finish();
    }
}