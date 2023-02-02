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

public class IntermediateWorkoutActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView intermediateWorkoutBackBtn;
    RelativeLayout day1IntermediateRelativeLayout, day2IntermediateRelativeLayout, day3IntermediateRelativeLayout, day4IntermediateRelativeLayout;
    RelativeLayout day5IntermediateRelativeLayout, day6IntermediateRelativeLayout, day7IntermediateRelativeLayout;
    AppCompatImageView checkboxIntermediateDay1, checkboxIntermediateDay2, checkboxIntermediateDay3;
    AppCompatImageView checkboxIntermediateDay4, checkboxIntermediateDay5, checkboxIntermediateDay6, checkboxIntermediateDay7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_workout);

        intermediateWorkoutBackBtn = findViewById(R.id.intermediateWorkoutBackBtn);

        checkboxIntermediateDay1 = findViewById(R.id.checkboxIntermediateDay1);
        checkboxIntermediateDay2 = findViewById(R.id.checkboxIntermediateDay2);
        checkboxIntermediateDay3 = findViewById(R.id.checkboxIntermediateDay3);
        checkboxIntermediateDay4 = findViewById(R.id.checkboxIntermediateDay4);
        checkboxIntermediateDay5 = findViewById(R.id.checkboxIntermediateDay5);
        checkboxIntermediateDay6 = findViewById(R.id.checkboxIntermediateDay6);
        checkboxIntermediateDay7 = findViewById(R.id.checkboxIntermediateDay7);

        day1IntermediateRelativeLayout = findViewById(R.id.day1IntermediateRelativeLayout);
        day2IntermediateRelativeLayout = findViewById(R.id.day2IntermediateRelativeLayout);
        day3IntermediateRelativeLayout = findViewById(R.id.day3IntermediateRelativeLayout);
        day4IntermediateRelativeLayout = findViewById(R.id.day4IntermediateRelativeLayout);
        day5IntermediateRelativeLayout = findViewById(R.id.day5IntermediateRelativeLayout);
        day6IntermediateRelativeLayout = findViewById(R.id.day6IntermediateRelativeLayout);
        day7IntermediateRelativeLayout = findViewById(R.id.day7IntermediateRelativeLayout);

        day2IntermediateRelativeLayout.setEnabled(false);
        day3IntermediateRelativeLayout.setEnabled(false);
        day4IntermediateRelativeLayout.setEnabled(false);
        day5IntermediateRelativeLayout.setEnabled(false);
        day6IntermediateRelativeLayout.setEnabled(false);
        day7IntermediateRelativeLayout.setEnabled(false);

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

                                                if (typeKey.equalsIgnoreCase("Intermediate")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay1.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(true);
                                                                    day3IntermediateRelativeLayout.setEnabled(false);
                                                                    day4IntermediateRelativeLayout.setEnabled(false);
                                                                    day5IntermediateRelativeLayout.setEnabled(false);
                                                                    day6IntermediateRelativeLayout.setEnabled(false);
                                                                    day7IntermediateRelativeLayout.setEnabled(false);
                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay2.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(false);
                                                                    day3IntermediateRelativeLayout.setEnabled(true);
                                                                    day4IntermediateRelativeLayout.setEnabled(false);
                                                                    day5IntermediateRelativeLayout.setEnabled(false);
                                                                    day6IntermediateRelativeLayout.setEnabled(false);
                                                                    day7IntermediateRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay3.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(false);
                                                                    day3IntermediateRelativeLayout.setEnabled(false);
                                                                    day4IntermediateRelativeLayout.setEnabled(true);
                                                                    day5IntermediateRelativeLayout.setEnabled(false);
                                                                    day6IntermediateRelativeLayout.setEnabled(false);
                                                                    day7IntermediateRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay4.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(false);
                                                                    day3IntermediateRelativeLayout.setEnabled(false);
                                                                    day4IntermediateRelativeLayout.setEnabled(false);
                                                                    day5IntermediateRelativeLayout.setEnabled(true);
                                                                    day6IntermediateRelativeLayout.setEnabled(false);
                                                                    day7IntermediateRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay5.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(false);
                                                                    day3IntermediateRelativeLayout.setEnabled(false);
                                                                    day4IntermediateRelativeLayout.setEnabled(false);
                                                                    day5IntermediateRelativeLayout.setEnabled(false);
                                                                    day6IntermediateRelativeLayout.setEnabled(true);
                                                                    day7IntermediateRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay6.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(false);
                                                                    day3IntermediateRelativeLayout.setEnabled(false);
                                                                    day4IntermediateRelativeLayout.setEnabled(false);
                                                                    day5IntermediateRelativeLayout.setEnabled(false);
                                                                    day6IntermediateRelativeLayout.setEnabled(false);
                                                                    day7IntermediateRelativeLayout.setEnabled(true);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay7.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                    day2IntermediateRelativeLayout.setEnabled(false);
                                                                    day3IntermediateRelativeLayout.setEnabled(false);
                                                                    day4IntermediateRelativeLayout.setEnabled(false);
                                                                    day5IntermediateRelativeLayout.setEnabled(false);
                                                                    day6IntermediateRelativeLayout.setEnabled(false);
                                                                    day7IntermediateRelativeLayout.setEnabled(false);

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

                                                if (typeKey.equalsIgnoreCase("Intermediate")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay1.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);
                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay2.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay3.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay4.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay5.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay6.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay7.setVisibility(View.VISIBLE);

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

                                                if (typeKey.equalsIgnoreCase("Intermediate")) {

                                                    for (DataSnapshot daySnap : typeSnap.getChildren()) {

                                                        String dayKey = daySnap.getKey();

                                                        if (dayKey.equalsIgnoreCase("Day 1")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay1.setVisibility(View.VISIBLE);
                                                                    day1IntermediateRelativeLayout.setEnabled(false);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 2")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay2.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 3")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay3.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 4")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay4.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 5")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay5.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 6")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay6.setVisibility(View.VISIBLE);

                                                                }

                                                            }

                                                        } else if (dayKey.equalsIgnoreCase("Day 7")) {

                                                            for (DataSnapshot snaps : daySnap.getChildren()) {

                                                                String snapsKey = snaps.getValue().toString();

                                                                if (snapsKey.equalsIgnoreCase("Completed")) {

                                                                    checkboxIntermediateDay7.setVisibility(View.VISIBLE);

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


        intermediateWorkoutBackBtn.setOnClickListener(this);

        day1IntermediateRelativeLayout.setOnClickListener(this);
        day2IntermediateRelativeLayout.setOnClickListener(this);
        day3IntermediateRelativeLayout.setOnClickListener(this);
        day4IntermediateRelativeLayout.setOnClickListener(this);
        day5IntermediateRelativeLayout.setOnClickListener(this);
        day6IntermediateRelativeLayout.setOnClickListener(this);
        day7IntermediateRelativeLayout.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toStayHealthy = new Intent(IntermediateWorkoutActivity.this, WorkoutPlansActivity.class);
        toStayHealthy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toStayHealthy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toStayHealthy);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.intermediateWorkoutBackBtn:
                onBackPressed();
                break;

            case R.id.day1IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day1IntermediateActivity.class));
                finish();
                break;

            case R.id.day2IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day2IntermediateActivity.class));
                finish();
                break;

            case R.id.day3IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day3IntermediateActivity.class));
                finish();
                break;

            case R.id.day4IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day4IntermediateActivity.class));
                finish();
                break;

            case R.id.day5IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day5IntermediateActivity.class));
                finish();
                break;

            case R.id.day6IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day6IntermediateActivity.class));
                finish();
                break;

            case R.id.day7IntermediateRelativeLayout:
                startActivity(new Intent(IntermediateWorkoutActivity.this, Day7IntermediateActivity.class));
                finish();
                break;

        }

    }
}