package com.example.ligtas.ui.stayHealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.ligtas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdvancedWorkoutActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView advancedWorkoutBackBtn;
    RelativeLayout day1AdvancedRelativeLayout, day2AdvancedRelativeLayout, day3AdvancedRelativeLayout, day4AdvancedRelativeLayout;
    RelativeLayout day5AdvancedRelativeLayout, day6AdvancedRelativeLayout, day7AdvancedRelativeLayout;
    AppCompatImageView checkboxAdvancedDay1, checkboxAdvancedDay2, checkboxAdvancedDay3, checkboxAdvancedDay4, checkboxAdvancedDay5, checkboxAdvancedDay6, checkboxAdvancedDay7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_workout);

        advancedWorkoutBackBtn = findViewById(R.id.advancedWorkoutBackBtn);

        checkboxAdvancedDay1 = findViewById(R.id.checkboxAdvancedDay1);
        checkboxAdvancedDay2 = findViewById(R.id.checkboxAdvancedDay2);
        checkboxAdvancedDay3 = findViewById(R.id.checkboxAdvancedDay3);
        checkboxAdvancedDay4 = findViewById(R.id.checkboxAdvancedDay4);
        checkboxAdvancedDay5 = findViewById(R.id.checkboxAdvancedDay5);
        checkboxAdvancedDay6 = findViewById(R.id.checkboxAdvancedDay6);
        checkboxAdvancedDay7 = findViewById(R.id.checkboxAdvancedDay7);

        day1AdvancedRelativeLayout = findViewById(R.id.day1AdvancedRelativeLayout);
        day2AdvancedRelativeLayout = findViewById(R.id.day2AdvancedRelativeLayout);
        day3AdvancedRelativeLayout = findViewById(R.id.day3AdvancedRelativeLayout);
        day4AdvancedRelativeLayout = findViewById(R.id.day4AdvancedRelativeLayout);
        day5AdvancedRelativeLayout = findViewById(R.id.day5AdvancedRelativeLayout);
        day6AdvancedRelativeLayout = findViewById(R.id.day6AdvancedRelativeLayout);
        day7AdvancedRelativeLayout = findViewById(R.id.day7AdvancedRelativeLayout);


        DatabaseReference workoutReference = FirebaseDatabase.getInstance().getReference().child("Users");

        workoutReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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

                                    for (DataSnapshot workoutSnap : userIdSnap.getChildren()) {

                                        String workoutkey = workoutSnap.getKey();

                                        if (workoutkey.equalsIgnoreCase("Workouts")) {

                                            for (DataSnapshot typeSnap : workoutSnap.getChildren()) {

                                                String typeKey = typeSnap.getKey();

                                                if (typeKey.equalsIgnoreCase("Advanced")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay1.setVisibility(View.VISIBLE);
                                                                    day1AdvancedRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay2.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay3.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay4.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay5.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay6.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay7.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        }

                                                    }

                                                }

                                            }

                                        } else {

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

                                    for (DataSnapshot workoutSnap : userIdSnap.getChildren()) {

                                        String workoutkey = workoutSnap.getKey();

                                        if (workoutkey.equalsIgnoreCase("Workouts")) {

                                            for (DataSnapshot typeSnap : workoutSnap.getChildren()) {

                                                String typeKey = typeSnap.getKey();

                                                if (typeKey.equalsIgnoreCase("Advanced")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay1.setVisibility(View.VISIBLE);
                                                                    day1AdvancedRelativeLayout.setEnabled(false);
                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay2.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay3.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay4.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay5.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay6.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay7.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        }

                                                    }

                                                }

                                            }

                                        } else {

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

                                    for (DataSnapshot workoutSnap : userIdSnap.getChildren()) {

                                        String workoutkey = workoutSnap.getKey();

                                        if (workoutkey.equalsIgnoreCase("Workouts")) {

                                            for (DataSnapshot typeSnap : workoutSnap.getChildren()) {

                                                String typeKey = typeSnap.getKey();

                                                if (typeKey.equalsIgnoreCase("Advanced")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay1.setVisibility(View.VISIBLE);
                                                                    day1AdvancedRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay2.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay3.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay4.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay5.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay6.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxAdvancedDay7.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        }

                                                    }

                                                }

                                            }

                                        } else {

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }
        });


        advancedWorkoutBackBtn.setOnClickListener(this);

        day1AdvancedRelativeLayout.setOnClickListener(this);
        day2AdvancedRelativeLayout.setOnClickListener(this);
        day3AdvancedRelativeLayout.setOnClickListener(this);
        day4AdvancedRelativeLayout.setOnClickListener(this);
        day5AdvancedRelativeLayout.setOnClickListener(this);
        day6AdvancedRelativeLayout.setOnClickListener(this);
        day7AdvancedRelativeLayout.setOnClickListener(this);
        
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(AdvancedWorkoutActivity.this, WorkoutPlansActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.advancedWorkoutBackBtn:
                onBackPressed();
                break;

            case R.id.day1AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day1AdvancedActivity.class));
                finish();
                break;

            case R.id.day2AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day2AdvancedActivity.class));
                finish();
                break;

            case R.id.day3AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day3AdvancedActivity.class));
                finish();
                break;

            case R.id.day4AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day4AdvancedActivity.class));
                finish();
                break;

            case R.id.day5AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day5AdvancedActivity.class));
                finish();
                break;

            case R.id.day6AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day6AdvancedActivity.class));
                finish();
                break;

            case R.id.day7AdvancedRelativeLayout:
                startActivity(new Intent(AdvancedWorkoutActivity.this, Day7AdvancedActivity.class));
                finish();
                break;
        }

    }
}