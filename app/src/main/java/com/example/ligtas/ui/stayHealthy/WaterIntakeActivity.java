package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.core.widget.ImageViewCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ligtas.MainActivity;
import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;
import com.example.ligtas.databinding.ActivityWaterIntakeBinding;
import com.example.ligtas.ui.monitorHealth.MonitorYourHealthActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class WaterIntakeActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView fromWIToStayHealthy;
    AppCompatButton drinkWaterbtn, waterIntakeGoalBtn;
    AppCompatImageView waterIntakeReminderNotificationButton;
    AppCompatTextView waterIntakeProgressTextView;
    ProgressBar waterIntakeProgressBar;

    String currentDate;
    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

        fromWIToStayHealthy = findViewById(R.id.fromWIToStayHealthy);
        waterIntakeGoalBtn = findViewById(R.id.waterIntakeGoalBtn);
        drinkWaterbtn = findViewById(R.id.drinkWaterbtn);
        waterIntakeReminderNotificationButton = findViewById(R.id.waterIntakeReminderNotificationButton);
        waterIntakeProgressTextView = findViewById(R.id.waterIntakeProgressTextView);
        waterIntakeProgressBar = findViewById(R.id.waterIntakeProgressBar);

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String month = monthName[calendar.get(Calendar.MONTH)];

        currentDate = month + " " + day + " " + year;

        DatabaseReference waterIntakeGoalReference = FirebaseDatabase.getInstance().getReference().child("Users");

        waterIntakeGoalReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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

                                                    waterIntakeGoalBtn.setVisibility(View.GONE);
                                                    drinkWaterbtn.setVisibility(View.VISIBLE);


                                                    for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                        String snapsKey = snaps.getKey();

                                                        if (snapsKey.equalsIgnoreCase("Progress")) {

                                                            String progress = snaps.getValue().toString();
                                                            waterIntakeProgressTextView.setText(progress + "%");

                                                            int wiprogress = (int) Float.parseFloat(progress);

                                                            Toast.makeText(WaterIntakeActivity.this, String.valueOf(wiprogress), Toast.LENGTH_SHORT).show();

                                                            waterIntakeProgressBar.setProgress(wiprogress);

                                                        }

                                                    }


                                                } else {

                                                    waterIntakeGoalBtn.setVisibility(View.VISIBLE);
                                                    drinkWaterbtn.setVisibility(View.GONE);

                                                }

                                            }

                                        } else {

                                            waterIntakeGoalBtn.setVisibility(View.VISIBLE);
                                            drinkWaterbtn.setVisibility(View.GONE);

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

                                                    waterIntakeGoalBtn.setVisibility(View.GONE);
                                                    drinkWaterbtn.setVisibility(View.VISIBLE);


                                                    for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                        String snapsKey = snaps.getKey();

                                                        if (snapsKey.equalsIgnoreCase("Progress")) {

                                                            String progress = snaps.getValue().toString();
                                                            waterIntakeProgressTextView.setText(progress + "%");

                                                            int wiprogress = (int) Float.parseFloat(progress);

                                                            Toast.makeText(WaterIntakeActivity.this, String.valueOf(wiprogress), Toast.LENGTH_SHORT).show();

                                                            waterIntakeProgressBar.setProgress(wiprogress);

                                                        }

                                                    }


                                                } else {

                                                    waterIntakeGoalBtn.setVisibility(View.VISIBLE);
                                                    drinkWaterbtn.setVisibility(View.GONE);

                                                }

                                            }

                                        } else {

                                            waterIntakeGoalBtn.setVisibility(View.VISIBLE);
                                            drinkWaterbtn.setVisibility(View.GONE);

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

                                                    waterIntakeGoalBtn.setVisibility(View.GONE);
                                                    drinkWaterbtn.setVisibility(View.VISIBLE);


                                                    for (DataSnapshot snaps : dateSnap.getChildren()) {

                                                        String snapsKey = snaps.getKey();

                                                        if (snapsKey.equalsIgnoreCase("Progress")) {

                                                            String progress = snaps.getValue().toString();
                                                            waterIntakeProgressTextView.setText(progress + "%");

                                                            int wiprogress = (int) Float.parseFloat(progress);

                                                            Toast.makeText(WaterIntakeActivity.this, String.valueOf(wiprogress), Toast.LENGTH_SHORT).show();

                                                            waterIntakeProgressBar.setProgress(wiprogress);

                                                        }

                                                    }


                                                } else {

                                                    waterIntakeGoalBtn.setVisibility(View.VISIBLE);
                                                    drinkWaterbtn.setVisibility(View.GONE);

                                                }

                                            }

                                        } else {

                                            waterIntakeGoalBtn.setVisibility(View.VISIBLE);
                                            drinkWaterbtn.setVisibility(View.GONE);

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }
        });

        fromWIToStayHealthy.setOnClickListener(this);
        drinkWaterbtn.setOnClickListener(this);
        waterIntakeReminderNotificationButton.setOnClickListener(this);
        waterIntakeGoalBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(WaterIntakeActivity.this, StayHealthyActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fromWIToStayHealthy:
                onBackPressed();
                break;

            case R.id.drinkWaterbtn:

                startActivity(new Intent(WaterIntakeActivity.this, DrinkWaterActivity.class));
                finish();

                break;

            case R.id.waterIntakeReminderNotificationButton:

                startActivity(new Intent(WaterIntakeActivity.this, WaterIntakeReminderActivity.class));
                finish();

                /*NotificationChannel();

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 43);
                calendar.set(Calendar.SECOND, 00);

                if (Calendar.getInstance().after(calendar)) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }

                Intent notificationIntent = new Intent(this, WaterIntakeNotificationPublisher.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }*/

                break;

            case R.id.waterIntakeGoalBtn:

                startActivity(new Intent(WaterIntakeActivity.this, WaterIntakeGoalActivity.class));
                finish();

                break;

        }
    }


}