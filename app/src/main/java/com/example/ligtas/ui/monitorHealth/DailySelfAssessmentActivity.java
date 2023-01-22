package com.example.ligtas.ui.monitorHealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class DailySelfAssessmentActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    RelativeLayout feverCheckBoxParentLayout, achesCheckBoxParentLayout, diarrheaCheckBoxParentLayout, dryCoughCheckBoxParentLayout, fatigueCheckBoxParentLayout;
    RelativeLayout headAcheCheckBoxParentLayout, lostTasteCheckBoxParentLayout, runnyNoseCheckBoxParentLayout, shortnessCheckBoxParentLayout;
    RelativeLayout soreThroatCheckBoxParentLayout, noneCheckBoxParentLayout;
    CheckBox feverCheckBox, achesCheckBox, diarrheaCheckBox, dryCoughCheckBox, fatigueCheckBox, headAcheCheckBox, lostTasteCheckBox, runnyNoseCheckBox, shortnessCheckBox;
    CheckBox noneCheckBox, soreThroatCheckBox, agreeCheckBox;
    AppCompatImageView fromdsaTomyh;
    AppCompatButton dsaSubmitBtn;
    SelfAssessmentHelper selfAssessmentHelper = new SelfAssessmentHelper();

    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    //checkbox
    int checks = 0;
    String condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_self_assessment);

        fromdsaTomyh = findViewById(R.id.fromdsaTomyh);
        feverCheckBoxParentLayout = findViewById(R.id.feverCheckBoxParentLayout);
        achesCheckBoxParentLayout = findViewById(R.id.achesCheckBoxParentLayout);
        diarrheaCheckBoxParentLayout = findViewById(R.id.diarrheaCheckBoxParentLayout);
        dryCoughCheckBoxParentLayout = findViewById(R.id.dryCoughCheckBoxParentLayout);
        fatigueCheckBoxParentLayout = findViewById(R.id.fatigueCheckBoxParentLayout);
        headAcheCheckBoxParentLayout = findViewById(R.id.headAcheCheckBoxParentLayout);
        lostTasteCheckBoxParentLayout = findViewById(R.id.lostTasteCheckBoxParentLayout);
        runnyNoseCheckBoxParentLayout = findViewById(R.id.runnyNoseCheckBoxParentLayout);
        shortnessCheckBoxParentLayout = findViewById(R.id.shortnessCheckBoxParentLayout);
        soreThroatCheckBoxParentLayout = findViewById(R.id.soreThroatCheckBoxParentLayout);
        noneCheckBoxParentLayout = findViewById(R.id.noneCheckBoxParentLayout);
        feverCheckBox = findViewById(R.id.feverCheckBox);
        achesCheckBox = findViewById(R.id.achesCheckBox);
        diarrheaCheckBox = findViewById(R.id.diarrheaCheckBox);
        dryCoughCheckBox = findViewById(R.id.dryCoughCheckBox);
        fatigueCheckBox = findViewById(R.id.fatigueCheckBox);
        headAcheCheckBox = findViewById(R.id.headAcheCheckBox);
        lostTasteCheckBox = findViewById(R.id.lostTasteCheckBox);
        runnyNoseCheckBox = findViewById(R.id.runnyNoseCheckBox);
        shortnessCheckBox = findViewById(R.id.shortnessCheckBox);
        soreThroatCheckBox = findViewById(R.id.soreThroatCheckBox);
        noneCheckBox = findViewById(R.id.noneCheckBox);
        agreeCheckBox = findViewById(R.id.agreeCheckBox);
        dsaSubmitBtn = findViewById(R.id.dsaSubmitBtn);

        agreeCheckBox.setEnabled(false);

        noneCheckBox.setOnCheckedChangeListener(this);
        agreeCheckBox.setOnCheckedChangeListener(this);
        achesCheckBox.setOnCheckedChangeListener(this);
        feverCheckBox.setOnCheckedChangeListener(this);
        diarrheaCheckBox.setOnCheckedChangeListener(this);
        dryCoughCheckBox.setOnCheckedChangeListener(this);
        fatigueCheckBox.setOnCheckedChangeListener(this);
        headAcheCheckBox.setOnCheckedChangeListener(this);
        lostTasteCheckBox.setOnCheckedChangeListener(this);
        runnyNoseCheckBox.setOnCheckedChangeListener(this);
        shortnessCheckBox.setOnCheckedChangeListener(this);
        soreThroatCheckBox.setOnCheckedChangeListener(this);

        fromdsaTomyh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent tomyh = new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class);
        tomyh.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        tomyh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(tomyh);
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        /*Snackbar.make(feverCheckBoxParentLayout, "value is " + checked, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();*/

        if (compoundButton == noneCheckBox) {

            if (checked) {

                achesCheckBox.setEnabled(false);
                diarrheaCheckBox.setEnabled(false);
                dryCoughCheckBox.setEnabled(false);
                fatigueCheckBox.setEnabled(false);
                feverCheckBox.setEnabled(false);
                headAcheCheckBox.setEnabled(false);
                lostTasteCheckBox.setEnabled(false);
                runnyNoseCheckBox.setEnabled(false);
                shortnessCheckBox.setEnabled(false);
                soreThroatCheckBox.setEnabled(false);
                agreeCheckBox.setEnabled(true);

            } else {

                achesCheckBox.setEnabled(true);
                diarrheaCheckBox.setEnabled(true);
                dryCoughCheckBox.setEnabled(true);
                fatigueCheckBox.setEnabled(true);
                feverCheckBox.setEnabled(true);
                headAcheCheckBox.setEnabled(true);
                lostTasteCheckBox.setEnabled(true);
                runnyNoseCheckBox.setEnabled(true);
                shortnessCheckBox.setEnabled(true);
                soreThroatCheckBox.setEnabled(true);

            }

            agreeCheckBox.setChecked(false);

        } else if (compoundButton != noneCheckBox && compoundButton != agreeCheckBox) {

            if (checked) {

                selfAssessmentHelper.setNoneOfTheAbove(false);
                noneCheckBox.setEnabled(false);
                agreeCheckBox.setEnabled(true);

            } else {

                if (checks == 1) {
                    agreeCheckBox.setEnabled(false);
                }

                selfAssessmentHelper.setCondition("");
                noneCheckBox.setEnabled(true);
            }

            agreeCheckBox.setChecked(false);

            if (compoundButton == achesCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == diarrheaCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == dryCoughCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == fatigueCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == feverCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == headAcheCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == lostTasteCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == runnyNoseCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == shortnessCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            } else if (compoundButton == soreThroatCheckBox) {

                if (checked) {
                    checks = checks + 1;
                } else {
                    checks = checks - 1;
                }

            }


        } else if (compoundButton == agreeCheckBox) {

            if (checked) {
                dsaSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saveDailyAssessment();
                    }

                    private void saveDailyAssessment() {

                        if (checks == 0) {
                            condition = "Good Condition";
                        } else if (checks == 1) {
                            condition = "Mild Condition";
                        } else if (checks >= 2) {
                            condition = "Severe Condition";
                        }

                        SelfAssessmentHelper selfAssessmentHelper = new SelfAssessmentHelper(achesCheckBox.isChecked(), diarrheaCheckBox.isChecked(), dryCoughCheckBox.isChecked(), fatigueCheckBox.isChecked(), feverCheckBox.isChecked(), headAcheCheckBox.isChecked(), lostTasteCheckBox.isChecked(), runnyNoseCheckBox.isChecked(), shortnessCheckBox.isChecked(), soreThroatCheckBox.isChecked(), noneCheckBox.isChecked(), condition);

                        DatabaseReference submitDailyAssessmentReference = FirebaseDatabase.getInstance().getReference().child("Users");

                        calendar = Calendar.getInstance();
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        int year = calendar.get(Calendar.YEAR);
                        String month = monthName[calendar.get(Calendar.MONTH)];

                        String currentDate = month + " " + day + " " + year;

                        submitDailyAssessmentReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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

                                                    for (DataSnapshot dailySnap : userIdSnap.getChildren()) {

                                                        String dailyKey = dailySnap.getKey();

                                                        if (dailySnap.hasChild("Daily Self Assessment")) {

                                                            for (DataSnapshot dailyAssSnap : dailySnap.getChildren()) {

                                                                String dailyAssKey = dailyAssSnap.getKey();

                                                                if (dailyAssKey.equalsIgnoreCase(currentDate)) {

                                                                    Toast.makeText(DailySelfAssessmentActivity.this, "You already take this assessment!", Toast.LENGTH_SHORT).show();

                                                                } else {

                                                                    submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(dailyAssKey).setValue(null);
                                                                    submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(currentDate).setValue(selfAssessmentHelper);
                                                                    setCheckboxToFalse();
                                                                    startActivity(new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class));
                                                                    finish();

                                                                }
                                                            }

                                                        } else {

                                                            submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(currentDate).setValue(selfAssessmentHelper);
                                                            setCheckboxToFalse();
                                                            startActivity(new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class));
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

                                                    for (DataSnapshot dailySnap : userIdSnap.getChildren()) {

                                                        String dailyKey = dailySnap.getKey();

                                                        if (dailySnap.hasChild("Daily Self Assessment")) {

                                                            for (DataSnapshot dailyAssSnap : dailySnap.getChildren()) {

                                                                String dailyAssKey = dailyAssSnap.getKey();

                                                                if (dailyAssKey.equalsIgnoreCase(currentDate)) {

                                                                    Toast.makeText(DailySelfAssessmentActivity.this, "You already take this assessment!", Toast.LENGTH_SHORT).show();

                                                                } else {

                                                                    submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(dailyAssKey).setValue(null);
                                                                    submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(currentDate).setValue(selfAssessmentHelper);
                                                                    setCheckboxToFalse();
                                                                    startActivity(new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class));
                                                                    finish();

                                                                }
                                                            }

                                                        } else {

                                                            submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(currentDate).setValue(selfAssessmentHelper);
                                                            setCheckboxToFalse();
                                                            startActivity(new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class));
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

                                                    for (DataSnapshot dailySnap : userIdSnap.getChildren()) {

                                                        String dailyKey = dailySnap.getKey();

                                                        if (dailyKey.equalsIgnoreCase("Daily Self Assessment")) {

                                                            for (DataSnapshot dailyAssSnap : dailySnap.getChildren()) {

                                                                String dailyAssKey = dailyAssSnap.getKey();

                                                                if (dailyAssKey.equalsIgnoreCase(currentDate)) {

                                                                    Toast.makeText(DailySelfAssessmentActivity.this, "You already take this assessment!", Toast.LENGTH_SHORT).show();

                                                                } else {

                                                                    submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(dailyAssKey).setValue(null);
                                                                    submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(currentDate).setValue(selfAssessmentHelper);
                                                                    setCheckboxToFalse();
                                                                    startActivity(new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class));
                                                                    finish();

                                                                }
                                                            }

                                                        } else {

                                                            submitDailyAssessmentReference.child(userTypeKey).child(idNumberKey).child(userIdKey).child("Daily Self Assessment").child(currentDate).setValue(selfAssessmentHelper);
                                                            setCheckboxToFalse();
                                                            startActivity(new Intent(DailySelfAssessmentActivity.this, MonitorYourHealthActivity.class));
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

                    }

                    private void setCheckboxToFalse() {
                        achesCheckBox.setChecked(false);
                        diarrheaCheckBox.setChecked(false);
                        dryCoughCheckBox.setChecked(false);
                        fatigueCheckBox.setChecked(false);
                        feverCheckBox.setChecked(false);
                        headAcheCheckBox.setChecked(false);
                        lostTasteCheckBox.setChecked(false);
                        runnyNoseCheckBox.setChecked(false);
                        shortnessCheckBox.setChecked(false);
                        soreThroatCheckBox.setChecked(false);
                        noneCheckBox.setChecked(false);
                        agreeCheckBox.setChecked(false);
                    }
                });
            } else {
            }

        }
    }

}