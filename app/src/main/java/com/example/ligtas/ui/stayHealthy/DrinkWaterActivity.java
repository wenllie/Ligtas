package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;

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
import java.util.HashMap;

public class DrinkWaterActivity extends AppCompatActivity implements View.OnClickListener {

    CardView floz8CardView, floz16CardView, floz32CardView, floz40CardView, floz50CardView, floz80CardView, customWaterIntakeCardView;
    AppCompatImageView drinkWaterBackButton;
    TextInputEditText customWaterIntakeEditText;
    AppCompatButton confirmCustomWI;
    LinearLayoutCompat layout1, layout2, layout3;
    DatabaseReference waterIntakeReference = FirebaseDatabase.getInstance().getReference().child("Users");


    String currentDate;
    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    String wiGoal;
    String wiCurrent;
    String wiProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_water);

        drinkWaterBackButton = findViewById(R.id.drinkWaterBackButton);
        floz8CardView = findViewById(R.id.floz8CardView);
        floz16CardView = findViewById(R.id.floz16CardView);
        floz32CardView = findViewById(R.id.floz32CardView);
        floz40CardView = findViewById(R.id.floz40CardView);
        floz50CardView = findViewById(R.id.floz50CardView);
        floz80CardView = findViewById(R.id.floz80CardView);
        customWaterIntakeCardView = findViewById(R.id.customWaterIntakeCardView);
        customWaterIntakeEditText = findViewById(R.id.customWaterIntakeEditText);
        confirmCustomWI = findViewById(R.id.confirmCustomWI);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String month = monthName[calendar.get(Calendar.MONTH)];

        currentDate = month + " " + day + " " + year;

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

                                                    HashMap waterIntakeDetails = new HashMap();

                                                    for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                        String snapsKey = snaps.getKey();

                                                        if (snapsKey.equalsIgnoreCase("Goal")) {

                                                            wiGoal = snaps.getValue().toString();

                                                        } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                            wiCurrent = snaps.getValue().toString();

                                                        } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                            wiProgress = snaps.getValue().toString();

                                                        }

                                                        waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                    }

                                                    int goal = Integer.parseInt(wiGoal);
                                                    int progress = Integer.parseInt(wiProgress);

                                                    int sub = goal - progress;

                                                    if (sub < 8) {

                                                        customWaterIntakeCardView.setVisibility(View.VISIBLE);
                                                        layout1.setVisibility(View.GONE);
                                                        layout2.setVisibility(View.GONE);
                                                        layout3.setVisibility(View.GONE);


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

                                                    HashMap waterIntakeDetails = new HashMap();

                                                    for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                        String snapsKey = snaps.getKey();

                                                        if (snapsKey.equalsIgnoreCase("Goal")) {

                                                            wiGoal = snaps.getValue().toString();

                                                        } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                            wiCurrent = snaps.getValue().toString();

                                                        } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                            wiProgress = snaps.getValue().toString();

                                                        }

                                                        waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                    }

                                                    int goal = Integer.parseInt(wiGoal);
                                                    int progress = Integer.parseInt(wiProgress);

                                                    int sub = goal - progress;

                                                    if (sub < 8) {

                                                        customWaterIntakeCardView.setVisibility(View.VISIBLE);
                                                        layout1.setVisibility(View.GONE);
                                                        layout2.setVisibility(View.GONE);
                                                        layout3.setVisibility(View.GONE);


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

                                                    HashMap waterIntakeDetails = new HashMap();

                                                    for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                        String snapsKey = snaps.getKey();

                                                        if (snapsKey.equalsIgnoreCase("Goal")) {

                                                            wiGoal = snaps.getValue().toString();

                                                        } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                            wiCurrent = snaps.getValue().toString();

                                                        } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                            wiProgress = snaps.getValue().toString();

                                                        }

                                                        waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                    }

                                                    int goal = Integer.parseInt(wiGoal);
                                                    int progress = Integer.parseInt(wiProgress);

                                                    int sub = goal - progress;

                                                    if (sub < 8) {

                                                        customWaterIntakeCardView.setVisibility(View.VISIBLE);
                                                        layout1.setVisibility(View.GONE);
                                                        layout2.setVisibility(View.GONE);
                                                        layout3.setVisibility(View.GONE);


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


        drinkWaterBackButton.setOnClickListener(this);
        floz8CardView.setOnClickListener(this);
        floz16CardView.setOnClickListener(this);
        floz32CardView.setOnClickListener(this);
        floz40CardView.setOnClickListener(this);
        floz50CardView.setOnClickListener(this);
        floz80CardView.setOnClickListener(this);
        confirmCustomWI.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.drinkWaterBackButton:
                onBackPressed();
                break;

            case R.id.confirmCustomWI:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int sub = goal - progress;

                                                            if (sub < 8) {

                                                                String customWI = customWaterIntakeEditText.getText().toString().trim();

                                                                int wCustom = Integer.parseInt(customWI);

                                                                if (wCustom > sub) {

                                                                    customWaterIntakeEditText.setError("Your water intake cannot be greater than your goal!");
                                                                    customWaterIntakeEditText.requestFocus();

                                                                } else if (wCustom == 0) {

                                                                    customWaterIntakeEditText.setError("Water intake cannot be 0!");
                                                                    customWaterIntakeEditText.requestFocus();

                                                                } else {

                                                                    int tpr = progress + wCustom;
                                                                    int progressWI = Math.round(((float) tpr / (float) goal) * 100);

                                                                    waterIntakeDetails.put("Current", customWI);
                                                                    waterIntakeDetails.put("Progress", String.valueOf(tpr));
                                                                    waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                    Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
                                                                    toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                    toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                    startActivity(toStayHealthy);
                                                                    finish();

                                                                }

                                                            } else {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int sub = goal - progress;

                                                            if (sub < 8) {

                                                                String customWI = customWaterIntakeEditText.getText().toString().trim();

                                                                int wCustom = Integer.parseInt(customWI);

                                                                if (wCustom > sub) {

                                                                    customWaterIntakeEditText.setError("Your water intake cannot be greater than your goal!");
                                                                    customWaterIntakeEditText.requestFocus();

                                                                } else if (wCustom == 0) {

                                                                    customWaterIntakeEditText.setError("Water intake cannot be 0!");
                                                                    customWaterIntakeEditText.requestFocus();

                                                                } else {

                                                                    int tpr = progress + wCustom;
                                                                    int progressWI = Math.round(((float) tpr / (float) goal) * 100);

                                                                    waterIntakeDetails.put("Current", customWI);
                                                                    waterIntakeDetails.put("Progress", String.valueOf(tpr));
                                                                    waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                    Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
                                                                    toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                    toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                    startActivity(toStayHealthy);
                                                                    finish();

                                                                }

                                                            } else {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int sub = goal - progress;

                                                            if (sub < 8) {

                                                                String customWI = customWaterIntakeEditText.getText().toString().trim();

                                                                int wCustom = Integer.parseInt(customWI);

                                                                if (wCustom > sub) {

                                                                    customWaterIntakeEditText.setError("Your water intake cannot be greater than your goal!");
                                                                    customWaterIntakeEditText.requestFocus();

                                                                } else if (wCustom == 0) {

                                                                    customWaterIntakeEditText.setError("Water intake cannot be 0!");
                                                                    customWaterIntakeEditText.requestFocus();

                                                                } else {

                                                                    int tpr = progress + wCustom;
                                                                    int progressWI = Math.round(((float) tpr / (float) goal) * 100);

                                                                    waterIntakeDetails.put("Current", customWI);
                                                                    waterIntakeDetails.put("Progress", String.valueOf(tpr));
                                                                    waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                    waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                    Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
                                                                    toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                    toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                    startActivity(toStayHealthy);
                                                                    finish();

                                                                }

                                                            } else {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

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

                break;

            case R.id.floz8CardView:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 8;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 8;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 8;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                            }

                        }

                    }
                });

                break;

            case R.id.floz16CardView:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 16;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 16;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 16;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                            }

                        }

                    }
                });

                break;

            case R.id.floz32CardView:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 32;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 32;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 32;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                            }

                        }

                    }
                });

                break;

            case R.id.floz40CardView:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 40;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 40;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 40;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                            }

                        }

                    }
                });

                break;

            case R.id.floz50CardView:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 50;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 50;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 50;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                            }

                        }

                    }
                });

                break;

            case R.id.floz80CardView:

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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 80;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 80;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {


                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                                                            HashMap waterIntakeDetails = new HashMap();

                                                            for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                                String snapsKey = snaps.getKey();

                                                                if (snapsKey.equalsIgnoreCase("Goal")) {

                                                                    wiGoal = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Current")) {

                                                                    wiCurrent = snaps.getValue().toString();

                                                                } else if (snapsKey.equalsIgnoreCase("Progress")) {

                                                                    wiProgress = snaps.getValue().toString();

                                                                }

                                                                waterIntakeDetails.put(snaps.getKey(), snaps.getValue());

                                                            }

                                                            int current = 80;
                                                            int goal = Integer.parseInt(wiGoal);
                                                            int progress = Integer.parseInt(wiProgress);

                                                            int tProgress = progress + current;
                                                            int progressWI = Math.round(((float) tProgress / (float) goal) * 100);

                                                            if (tProgress > goal) {

                                                                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(DrinkWaterActivity.this);

                                                                alertDialogBuilder.setTitle("Danger")
                                                                        .setIcon(R.drawable.danger)
                                                                        .setMessage("Drinking too much water is bad for your kidneys!")
                                                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                                dialogInterface.dismiss();
                                                                            }
                                                                        });

                                                                alertDialogBuilder.show();

                                                            } else {

                                                                waterIntakeDetails.put("Current", String.valueOf(current));
                                                                waterIntakeDetails.put("Progress", String.valueOf(tProgress));
                                                                waterIntakeDetails.put("Percentage", String.valueOf(progressWI));

                                                                waterIntakeReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Water Intake").child(currentDate).updateChildren(waterIntakeDetails);
                                                                Intent toStayHealthy = new Intent(DrinkWaterActivity.this, WaterIntakeActivity.class);
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

                            }

                        }

                    }
                });

                break;

        }

    }
}