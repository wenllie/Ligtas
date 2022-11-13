package com.example.ligtas.ui.privacyPolicy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;
import com.example.ligtas.ui.termsAndConditions.TermsAndConditionsActivity;

public class PrivacyPolicyActivity extends AppCompatActivity {

    AppCompatImageView backArrowPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        backArrowPrivacy = findViewById(R.id.backArrowPrivacy);

        backArrowPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent toDashboard = new Intent(PrivacyPolicyActivity.this, UserNavigationActivity.class);
        toDashboard.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toDashboard);
        finish();
    }
}