package com.example.ligtas.ui.stayHealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ligtas.R;
import com.example.ligtas.databinding.ActivityWaterIntakeReminderBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class WaterIntakeReminderActivity extends AppCompatActivity {

    private ActivityWaterIntakeReminderBinding reminderBinding;
    private MaterialTimePicker timePicker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderBinding = ActivityWaterIntakeReminderBinding.inflate(getLayoutInflater());
        setContentView(reminderBinding.getRoot());

        NotificationChannel();

        reminderBinding.timeWaterIntakeReminderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timePicker = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(0)
                        .setTitleText("Select Notification Time")
                        .build();

                timePicker.show(getSupportFragmentManager(), "Notification");
                timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (timePicker.getHour() > 12) {
                            reminderBinding.timeWaterIntakeReminderTextView.setText(String.format("%02d", (timePicker.getHour() - 12)) + ":"
                                    + String.format("%02d", timePicker.getMinute()) + "PM");
                        } else {
                            reminderBinding.timeWaterIntakeReminderTextView.setText(timePicker.getHour() + ":" + timePicker.getMinute() + "AM");
                        }

                        calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                        calendar.set(Calendar.MINUTE, timePicker.getMinute());
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);

                        if (Calendar.getInstance().after(calendar)) {

                            calendar.add(Calendar.DAY_OF_MONTH, 1);

                        }

                    }
                });

            }
        });

        reminderBinding.setAlarmWaterIntakeReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaterIntakeReminderActivity.this, WaterIntakeNotificationPublisher.class);
                pendingIntent = PendingIntent.getBroadcast(WaterIntakeReminderActivity.this, 0, intent, 0);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                Toast.makeText(WaterIntakeReminderActivity.this, "Notification alarm set!", Toast.LENGTH_SHORT).show();
                onBackPressed();

            }
        });

        reminderBinding.cancelAlarmWaterIntakeReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaterIntakeReminderActivity.this, WaterIntakeNotificationPublisher.class);
                pendingIntent = PendingIntent.getBroadcast(WaterIntakeReminderActivity.this, 0, intent, 0);

                if (alarmManager == null) {

                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                } else {

                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(WaterIntakeReminderActivity.this, "Notification alarm cancelled!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        reminderBinding.closeWaterIntakeReminderImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(WaterIntakeReminderActivity.this, WaterIntakeActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    private void NotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "WATER_INTAKE";
            String description = "WATER INTAKE CHANNEL";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("Notification", name, importance);
            channel.setDescription(description);

            NotificationManager notificationChannel = getSystemService(NotificationManager.class);
            notificationChannel.createNotificationChannel(channel);

        }

    }
}