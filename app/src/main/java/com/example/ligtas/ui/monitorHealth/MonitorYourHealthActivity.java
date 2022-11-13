package com.example.ligtas.ui.monitorHealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MonitorYourHealthActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView fromMonitorYourHealthToDashboard;
    CardView dailySelfAssessmentCardView, healthAssessmentCardView;
    AppCompatTextView myhCurrentDate, myhConditionTextView;
    LinearLayoutCompat healthStatusLayout;
    AppCompatImageView myhCircleConditionImageView, myhConditionImageView;

    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_your_health);

        myhCurrentDate = findViewById(R.id.myhCurrentDate);
        fromMonitorYourHealthToDashboard = findViewById(R.id.fromMonitorYourHealthToDashboard);
        dailySelfAssessmentCardView = findViewById(R.id.dailySelfAssessmentCardView);
        healthAssessmentCardView = findViewById(R.id.healthAssessmentCardView);
        myhCircleConditionImageView = findViewById(R.id.myhCircleConditionImageView);
        myhConditionImageView = findViewById(R.id.myhConditionImageView);
        myhConditionTextView = findViewById(R.id.myhConditionTextView);
        healthStatusLayout = findViewById(R.id.healthStatusLayout);

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String month = monthName[calendar.get(Calendar.MONTH)];

        myhCurrentDate.setText(month + " " + String.valueOf(day) + ", " + String.valueOf(year));

        /*User health condition*/
        myhCircleConditionImageView.setVisibility(View.GONE);
        userHealthCondition();

        fromMonitorYourHealthToDashboard.setOnClickListener(this);
        dailySelfAssessmentCardView.setOnClickListener(this);
        healthAssessmentCardView.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent toDashboard = new Intent(MonitorYourHealthActivity.this, UserNavigationActivity.class);
        toDashboard.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toDashboard);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fromMonitorYourHealthToDashboard:
                onBackPressed();
                break;

            case R.id.dailySelfAssessmentCardView:
                startActivity(new Intent(MonitorYourHealthActivity.this, DailySelfAssessmentActivity.class));
                finish();
                break;

            case R.id.healthAssessmentCardView:
                startActivity(new Intent(MonitorYourHealthActivity.this, HealthAssessmentActivity.class));
                finish();
                break;

        }
    }

    private void userHealthCondition() {

        DatabaseReference healthConditionReference = FirebaseDatabase.getInstance().getReference().child("Users");

        healthConditionReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                    String userTypeKey = userTypeSnap.getKey();

                    if (userTypeKey.equalsIgnoreCase("Employees")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                String userIdKey = userIdSnap.getKey();

                                if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot assessmentSnap : userIdSnap.getChildren()) {

                                        String assessmentKey = assessmentSnap.getKey();

                                        if (assessmentKey.equalsIgnoreCase("Daily Self Assessment")) {

                                            for (DataSnapshot dateSnap : assessmentSnap.getChildren()) {

                                                for (DataSnapshot snap : dateSnap.getChildren()) {

                                                    String assessedKey = snap.getKey();

                                                    if (!assessedKey.equalsIgnoreCase("noneOfTheAbove")) {

                                                        if (snap.getValue().toString().equalsIgnoreCase("true")) {

                                                            myhCircleConditionImageView.setVisibility(View.VISIBLE);
                                                            myhCircleConditionImageView.setBackground(getResources().getDrawable(R.drawable.circle_severe_condition));
                                                            myhConditionImageView.setBackground(getResources().getDrawable(R.drawable.mild_condition));
                                                            myhConditionTextView.setText("Bad Condition");
                                                            healthStatusLayout.setBackgroundColor(getResources().getColor(R.color.orange_light));

                                                            healthStatusLayout.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {


                                                                    MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MonitorYourHealthActivity.this);

                                                                    alertDialogBuilder.setTitle("Health Status")
                                                                            .setMessage("You are in a severe condition please stay at home, observe social distancing and follow health protocols.\n" +
                                                                                    "Please have yourself checked first by medical health personnel as soon as possible.")
                                                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                                    dialogInterface.dismiss();
                                                                                }
                                                                            });

                                                                    alertDialogBuilder.show();
                                                                }
                                                            });


                                                        }

                                                    } else {

                                                        if (snap.getValue().toString().equalsIgnoreCase("true")) {

                                                            myhCircleConditionImageView.setVisibility(View.VISIBLE);
                                                            myhCircleConditionImageView.setBackground(getResources().getDrawable(R.drawable.circle_good_condition));
                                                            myhConditionImageView.setBackground(getResources().getDrawable(R.drawable.good_condition));
                                                            myhConditionTextView.setText("Good Condition");
                                                            healthStatusLayout.setBackgroundColor(getResources().getColor(R.color.green_lighter));

                                                            healthStatusLayout.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {


                                                                    MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MonitorYourHealthActivity.this);

                                                                    alertDialogBuilder.setTitle("Health Status")
                                                                            .setMessage("You are in a good condition you may now proceed with your daily activities.\n" +
                                                                                    "Please stay safe and follow the health protocols.")
                                                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                                    dialogInterface.dismiss();
                                                                                }
                                                                            });

                                                                    alertDialogBuilder.show();
                                                                }
                                                            });


                                                        }

                                                    }

                                                }


                                            }

                                        }

                                    }

                                }

                            }

                        }

                    } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                String userIdKey = userIdSnap.getKey();

                                if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot assessmentSnap : userIdSnap.getChildren()) {

                                        String assessmentKey = assessmentSnap.getKey();

                                        if (assessmentKey.equalsIgnoreCase("Daily Self Assessment")) {

                                            for (DataSnapshot dateSnap : assessmentSnap.getChildren()) {

                                                for (DataSnapshot snap : dateSnap.getChildren()) {

                                                    String assessedKey = snap.getKey();

                                                    if (!assessedKey.equalsIgnoreCase("noneOfTheAbove")) {

                                                        if (snap.getValue().toString().equalsIgnoreCase("true")) {

                                                            myhCircleConditionImageView.setVisibility(View.VISIBLE);
                                                            myhCircleConditionImageView.setBackground(getResources().getDrawable(R.drawable.circle_severe_condition));
                                                            myhConditionImageView.setBackground(getResources().getDrawable(R.drawable.mild_condition));
                                                            myhConditionTextView.setText("Bad Condition");
                                                            healthStatusLayout.setBackgroundColor(getResources().getColor(R.color.orange_light));

                                                            healthStatusLayout.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {


                                                                    MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MonitorYourHealthActivity.this);

                                                                    alertDialogBuilder.setTitle("Health Status")
                                                                            .setMessage("You are in a severe condition please stay at home, observe social distancing and follow health protocols.\n" +
                                                                                    "Please have yourself checked first by medical health personnel as soon as possible.")
                                                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                                    dialogInterface.dismiss();
                                                                                }
                                                                            });

                                                                    alertDialogBuilder.show();
                                                                }
                                                            });


                                                        }

                                                    } else {

                                                        if (snap.getValue().toString().equalsIgnoreCase("true")) {

                                                            myhCircleConditionImageView.setVisibility(View.VISIBLE);
                                                            myhCircleConditionImageView.setBackground(getResources().getDrawable(R.drawable.circle_good_condition));
                                                            myhConditionImageView.setBackground(getResources().getDrawable(R.drawable.good_condition));
                                                            myhConditionTextView.setText("Good Condition");
                                                            healthStatusLayout.setBackgroundColor(getResources().getColor(R.color.green_lighter));

                                                            healthStatusLayout.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {


                                                                    MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MonitorYourHealthActivity.this);

                                                                    alertDialogBuilder.setTitle("Health Status")
                                                                            .setMessage("You are in a good condition you may now proceed with your daily activities.\n" +
                                                                                    "Please stay safe and follow the health protocols.")
                                                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                                    dialogInterface.dismiss();
                                                                                }
                                                                            });

                                                                    alertDialogBuilder.show();
                                                                }
                                                            });


                                                        }

                                                    }

                                                }


                                            }

                                        }

                                    }

                                }

                            }

                        }

                    } else if (userTypeKey.equalsIgnoreCase("Students")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                String userIdKey = userIdSnap.getKey();

                                if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot assessmentSnap : userIdSnap.getChildren()) {

                                        String assessmentKey = assessmentSnap.getKey();

                                        if (assessmentKey.equalsIgnoreCase("Daily Self Assessment")) {

                                            for (DataSnapshot dateSnap : assessmentSnap.getChildren()) {

                                                for (DataSnapshot snap : dateSnap.getChildren()) {

                                                    String assessedKey = snap.getKey();

                                                    if (!assessedKey.equalsIgnoreCase("noneOfTheAbove")) {

                                                        if (snap.getValue().toString().equalsIgnoreCase("true")) {

                                                            myhCircleConditionImageView.setVisibility(View.VISIBLE);
                                                            myhCircleConditionImageView.setBackground(getResources().getDrawable(R.drawable.circle_severe_condition));
                                                            myhConditionImageView.setBackground(getResources().getDrawable(R.drawable.mild_condition));
                                                            myhConditionTextView.setText("Bad Condition");
                                                            healthStatusLayout.setBackgroundColor(getResources().getColor(R.color.orange_light));

                                                            healthStatusLayout.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {


                                                                    MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MonitorYourHealthActivity.this);

                                                                    alertDialogBuilder.setTitle("Health Status")
                                                                            .setMessage("You are in a severe condition please stay at home, observe social distancing and follow health protocols.\n" +
                                                                                    "Please have yourself checked first by medical health personnel as soon as possible.")
                                                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                                    dialogInterface.dismiss();
                                                                                }
                                                                            });

                                                                    alertDialogBuilder.show();
                                                                }
                                                            });


                                                        }

                                                    } else {

                                                        if (snap.getValue().toString().equalsIgnoreCase("true")) {

                                                            myhCircleConditionImageView.setVisibility(View.VISIBLE);
                                                            myhCircleConditionImageView.setBackground(getResources().getDrawable(R.drawable.circle_good_condition));
                                                            myhConditionImageView.setBackground(getResources().getDrawable(R.drawable.good_condition));
                                                            myhConditionTextView.setText("Good Condition");
                                                            healthStatusLayout.setBackgroundColor(getResources().getColor(R.color.green_lighter));

                                                            healthStatusLayout.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {


                                                                    MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MonitorYourHealthActivity.this);

                                                                    alertDialogBuilder.setTitle("Health Status")
                                                                            .setMessage("You are in a good condition you may now proceed with your daily activities.\n" +
                                                                                    "Please stay safe and follow the health protocols.")
                                                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                                    dialogInterface.dismiss();
                                                                                }
                                                                            });

                                                                    alertDialogBuilder.show();
                                                                }
                                                            });


                                                        }

                                                    }

                                                }


                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }
        });

    }
}