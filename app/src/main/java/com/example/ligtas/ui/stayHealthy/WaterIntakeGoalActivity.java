package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ligtas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.regex.Pattern;

public class WaterIntakeGoalActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView fromWIGToStayHealthy;
    AppCompatTextView currentDateWIG, waterIntakeGoalTextView;
    TextInputEditText weightWIGEditText, durationWIGEditText;
    AppCompatButton setGoalBtn, calculateBtn;

    String currentDate;
    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    double waterNeeded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake_goal);

        fromWIGToStayHealthy = findViewById(R.id.fromWIGToStayHealthy);
        currentDateWIG = findViewById(R.id.currentDateWIG);
        weightWIGEditText = findViewById(R.id.weightWIGEditText);
        durationWIGEditText = findViewById(R.id.durationWIGEditText);
        waterIntakeGoalTextView = findViewById(R.id.waterIntakeGoalTextView);
        setGoalBtn = findViewById(R.id.setGoalBtn);
        calculateBtn = findViewById(R.id.calculateBtn);

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String month = monthName[calendar.get(Calendar.MONTH)];

        currentDate = month + " " + day + " " + year;

        currentDateWIG.setText(month + " " + day + ", " + year);


        fromWIGToStayHealthy.setOnClickListener(this);
        setGoalBtn.setOnClickListener(this);
        calculateBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fromWIGToStayHealthy:
                onBackPressed();
                break;

            case R.id.calculateBtn:

                String weight = weightWIGEditText.getText().toString().trim();
                String exerciseTime = durationWIGEditText.getText().toString().trim();

                if (weight.isEmpty()) {

                    weightWIGEditText.setError("Please fill out required fields!");
                    weightWIGEditText.requestFocus();

                } else if (exerciseTime.isEmpty()) {

                    durationWIGEditText.setError("Please fill out required fields!");
                    durationWIGEditText.requestFocus();

                } else {

                    int wt = Integer.parseInt(weight);
                    int et = Integer.parseInt(exerciseTime);

                    waterNeeded = wt + (12 * et / 30);

                    waterIntakeGoalTextView.setText(String.valueOf(Math.round(waterNeeded)));

                }

                break;

            case R.id.setGoalBtn:

                DatabaseReference waterIntakeReference = FirebaseDatabase.getInstance().getReference().child("Users");

                waterIntakeReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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

                                            for (DataSnapshot waterIntakeSnap : userIdSnap.getChildren()) {

                                                String waterIntakeKey = waterIntakeSnap.getKey();

                                                if (waterIntakeKey.equalsIgnoreCase("Water Intake")) {

                                                    for (DataSnapshot dateSnap : waterIntakeSnap.getChildren()) {

                                                        String dateKey = dateSnap.getKey();

                                                        if (dateKey.equalsIgnoreCase(currentDate)) {

                                                            Toast.makeText(WaterIntakeGoalActivity.this, "You've already set your water intake goal today!", Toast.LENGTH_SHORT).show();

                                                        } else {

                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Goal").setValue(String.valueOf(Math.round(waterNeeded)));
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Progress").setValue("0");
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Current").setValue("0");
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Percentage").setValue("0");
                                                            Toast.makeText(WaterIntakeGoalActivity.this, "Goal Set!", Toast.LENGTH_SHORT).show();
                                                            Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
                                                            toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            startActivity(toStayHealthy);
                                                            finish();
                                                        }

                                                    }

                                                } else {

                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Goal").setValue(String.valueOf(Math.round(waterNeeded)));
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Progress").setValue("0");
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Current").setValue("0");
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Percentage").setValue("0");
                                                    Toast.makeText(WaterIntakeGoalActivity.this, "Goal Set!", Toast.LENGTH_SHORT).show();
                                                    Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
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

                                            for (DataSnapshot waterIntakeSnap : userIdSnap.getChildren()) {

                                                String waterIntakeKey = waterIntakeSnap.getKey();

                                                if (waterIntakeKey.equalsIgnoreCase("Water Intake")) {

                                                    for (DataSnapshot dateSnap : waterIntakeSnap.getChildren()) {

                                                        String dateKey = dateSnap.getKey();

                                                        if (dateKey.equalsIgnoreCase(currentDate)) {

                                                            Toast.makeText(WaterIntakeGoalActivity.this, "You've already set your water intake goal today!", Toast.LENGTH_SHORT).show();

                                                        } else {

                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Goal").setValue(String.valueOf(Math.round(waterNeeded)));
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Progress").setValue("0");
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Current").setValue("0");
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Percentage").setValue("0");
                                                            Toast.makeText(WaterIntakeGoalActivity.this, "Goal Set!", Toast.LENGTH_SHORT).show();
                                                            Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
                                                            toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            startActivity(toStayHealthy);
                                                            finish();
                                                        }

                                                    }

                                                } else {

                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Goal").setValue(String.valueOf(Math.round(waterNeeded)));
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Progress").setValue("0");
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Current").setValue("0");
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Percentage").setValue("0");
                                                    Toast.makeText(WaterIntakeGoalActivity.this, "Goal Set!", Toast.LENGTH_SHORT).show();
                                                    Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
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

                                            for (DataSnapshot waterIntakeSnap : userIdSnap.getChildren()) {

                                                String waterIntakeKey = waterIntakeSnap.getKey();

                                                if (waterIntakeKey.equalsIgnoreCase("Water Intake")) {

                                                    for (DataSnapshot dateSnap : waterIntakeSnap.getChildren()) {

                                                        String dateKey = dateSnap.getKey();

                                                        if (dateKey.equalsIgnoreCase(currentDate)) {

                                                            Toast.makeText(WaterIntakeGoalActivity.this, "You've already set your water intake goal today!", Toast.LENGTH_SHORT).show();

                                                        } else {

                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Goal").setValue(String.valueOf(Math.round(waterNeeded)));
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Progress").setValue("0");
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Current").setValue("0");
                                                            waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Percentage").setValue("0");
                                                            Toast.makeText(WaterIntakeGoalActivity.this, "Goal Set!", Toast.LENGTH_SHORT).show();
                                                            Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
                                                            toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            startActivity(toStayHealthy);
                                                            finish();
                                                        }

                                                    }

                                                } else {

                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Goal").setValue(String.valueOf(Math.round(waterNeeded)));
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Progress").setValue("0");
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Current").setValue("0");
                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).child("Percentage").setValue("0");
                                                    Toast.makeText(WaterIntakeGoalActivity.this, "Goal Set!", Toast.LENGTH_SHORT).show();
                                                    Intent toStayHealthy = new Intent(WaterIntakeGoalActivity.this, WaterIntakeActivity.class);
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

        }

    }
}