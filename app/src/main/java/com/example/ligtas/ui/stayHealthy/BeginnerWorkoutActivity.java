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

public class BeginnerWorkoutActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView beginnerWorkoutBackBtn;
    RelativeLayout day1BeginnerRelativeLayout, day2BeginnerRelativeLayout, day3BeginnerRelativeLayout, day4BeginnerRelativeLayout;
    RelativeLayout day5BeginnerRelativeLayout, day6BeginnerRelativeLayout, day7BeginnerRelativeLayout;
    AppCompatImageView checkboxBeginnerDay1, checkboxBeginnerDay2, checkboxBeginnerDay3, checkboxBeginnerDay4, checkboxBeginnerDay5, checkboxBeginnerDay6, checkboxBeginnerDay7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_workout);

        beginnerWorkoutBackBtn = findViewById(R.id.beginnerWorkoutBackBtn);

        checkboxBeginnerDay1 = findViewById(R.id.checkboxBeginnerDay1);
        checkboxBeginnerDay2 = findViewById(R.id.checkboxBeginnerDay2);
        checkboxBeginnerDay3 = findViewById(R.id.checkboxBeginnerDay3);
        checkboxBeginnerDay4 = findViewById(R.id.checkboxBeginnerDay4);
        checkboxBeginnerDay5 = findViewById(R.id.checkboxBeginnerDay5);
        checkboxBeginnerDay6 = findViewById(R.id.checkboxBeginnerDay6);
        checkboxBeginnerDay7 = findViewById(R.id.checkboxBeginnerDay7);

        day1BeginnerRelativeLayout = findViewById(R.id.day1BeginnerRelativeLayout);
        day2BeginnerRelativeLayout = findViewById(R.id.day2BeginnerRelativeLayout);
        day3BeginnerRelativeLayout = findViewById(R.id.day3BeginnerRelativeLayout);
        day4BeginnerRelativeLayout = findViewById(R.id.day4BeginnerRelativeLayout);
        day5BeginnerRelativeLayout = findViewById(R.id.day5BeginnerRelativeLayout);
        day6BeginnerRelativeLayout = findViewById(R.id.day6BeginnerRelativeLayout);
        day7BeginnerRelativeLayout = findViewById(R.id.day7BeginnerRelativeLayout);

        day2BeginnerRelativeLayout.setEnabled(false);
        day3BeginnerRelativeLayout.setEnabled(false);
        day4BeginnerRelativeLayout.setEnabled(false);
        day5BeginnerRelativeLayout.setEnabled(false);
        day6BeginnerRelativeLayout.setEnabled(false);
        day7BeginnerRelativeLayout.setEnabled(false);


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

                                                if (typeKey.equalsIgnoreCase("Beginner")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay1.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(true);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay2.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(true);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay3.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(true);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay4.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(true);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay5.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(true);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay6.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(true);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay7.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

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

                                                if (typeKey.equalsIgnoreCase("Beginner")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay1.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(true);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);
                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay2.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(true);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay3.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(true);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay4.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(true);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay5.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(true);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay6.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(true);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay7.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

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

                                                if (typeKey.equalsIgnoreCase("Beginner")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay1.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(true);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay2.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(true);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay3.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(true);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay4.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(true);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay5.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(true);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay6.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(true);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxBeginnerDay7.setVisibility(View.VISIBLE);
                                                                    day1BeginnerRelativeLayout.setEnabled(false);
                                                                    day2BeginnerRelativeLayout.setEnabled(false);
                                                                    day3BeginnerRelativeLayout.setEnabled(false);
                                                                    day4BeginnerRelativeLayout.setEnabled(false);
                                                                    day5BeginnerRelativeLayout.setEnabled(false);
                                                                    day6BeginnerRelativeLayout.setEnabled(false);
                                                                    day7BeginnerRelativeLayout.setEnabled(false);

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


        beginnerWorkoutBackBtn.setOnClickListener(this);

        day1BeginnerRelativeLayout.setOnClickListener(this);
        day2BeginnerRelativeLayout.setOnClickListener(this);
        day3BeginnerRelativeLayout.setOnClickListener(this);
        day4BeginnerRelativeLayout.setOnClickListener(this);
        day5BeginnerRelativeLayout.setOnClickListener(this);
        day6BeginnerRelativeLayout.setOnClickListener(this);
        day7BeginnerRelativeLayout.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(BeginnerWorkoutActivity.this, WorkoutPlansActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.beginnerWorkoutBackBtn:
                onBackPressed();
                break;

            case R.id.day1BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day1BeginnerActivity.class));
                finish();
                break;

            case R.id.day2BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day2BeginnerActivity.class));
                finish();
                break;

            case R.id.day3BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day3BeginnerActivity.class));
                finish();
                break;

            case R.id.day4BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day4BeginnerActivity.class));
                finish();
                break;

            case R.id.day5BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day5BeginnerActivity.class));
                finish();
                break;

            case R.id.day6BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day6BeginnerActivity.class));
                finish();
                break;

            case R.id.day7BeginnerRelativeLayout:
                startActivity(new Intent(BeginnerWorkoutActivity.this, Day7BeginnerActivity.class));
                finish();
                break;
        }

    }
}