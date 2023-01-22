package com.example.ligtas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class HealthInfoActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText registerHeight, registerWeight;
    Spinner covid19VaccinatedSpinner, comorbiditySpinner, covid19VaccinatedYesSpinner;
    AppCompatTextView yesComorbidity, yesCovid19Vaccinated;
    TextView healthIssueName;
    AppCompatButton healthInfoSaveBtn;

    boolean[] selectedHealthIssue;
    ArrayList<Integer> healthIssueList = new ArrayList<>();
    String[] healthIssueArray = {"ADHD", "Asthma", "Cancer", "Cardiovascular Disease", "Cerebro-stroke/Cerebrovascular Accident",
            "Chronic Kidney Disease", "Chronic Liver Disease", "Chronic Obstructive Pulmonary Disease (COPD)", "Color Blindness", "Diabetes", "Down Syndrome",
            "Emphysema", "Fluid and electrolyte disorders", "Heart disease", "Hepatitis B", "High blood pressure", "Hypertension", "Immunodeficiency State",
            "Neurologic Disease", "Obesity", "Respiratory Disease", "Sleep apnea", "Tuberculosis"};

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_info);

        registerHeight = findViewById(R.id.registerHeight);
        registerWeight = findViewById(R.id.registerWeight);
        covid19VaccinatedSpinner = findViewById(R.id.covid19VaccinatedSpinner);
        covid19VaccinatedYesSpinner = findViewById(R.id.covid19VaccinatedYesSpinner);
        yesCovid19Vaccinated = findViewById(R.id.yesCovid19Vaccinated);
        comorbiditySpinner = findViewById(R.id.comorbiditySpinner);
        yesComorbidity = findViewById(R.id.yesComorbidity);
        healthIssueName = findViewById(R.id.healthIssueName);
        healthInfoSaveBtn = findViewById(R.id.healthInfoSaveBtn);

        mAuth = FirebaseAuth.getInstance();

        /*Disable the save button*/
        selectedHealthIssue = new boolean[healthIssueArray.length];

        healthIssueName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HealthInfoActivity.this);

                builder.setCancelable(false)
                        .setTitle("Select Health Issue")
                        .setMultiChoiceItems(healthIssueArray, selectedHealthIssue, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                                if (b) {
                                    healthIssueList.add(i);

                                    Collections.sort(healthIssueList);
                                } else {

                                    healthIssueList.remove(Integer.valueOf(i));

                                }

                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Initialize string builder
                                StringBuilder stringBuilder = new StringBuilder();
                                // use for loop
                                for (int j = 0; j < healthIssueList.size(); j++) {
                                    // concat array value
                                    stringBuilder.append(healthIssueArray[healthIssueList.get(j)]);
                                    // check condition
                                    if (j != healthIssueList.size() - 1) {
                                        // When j value  not equal
                                        // to lang list size - 1
                                        // add comma
                                        stringBuilder.append(", ");
                                    }
                                }
                                // set text on textView
                                healthIssueName.setText(stringBuilder.toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();

            }
        });

        comorbiditySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


                if (comorbiditySpinner.getSelectedItem().toString().equalsIgnoreCase("Yes")) {
                    yesComorbidity.setVisibility(View.VISIBLE);
                    healthIssueName.setVisibility(View.VISIBLE);
                } else {
                    yesComorbidity.setVisibility(View.GONE);
                    healthIssueName.setVisibility(View.GONE);
                    // use for loop
                    for (int j = 0; j < selectedHealthIssue.length; j++) {
                        // remove all selection
                        selectedHealthIssue[j] = false;
                        // clear language list
                        healthIssueList.clear();
                        // clear text view value
                        healthIssueName.setText("None");
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        covid19VaccinatedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (covid19VaccinatedSpinner.getSelectedItem().toString().equalsIgnoreCase("Yes")) {
                    yesCovid19Vaccinated.setVisibility(View.VISIBLE);
                    covid19VaccinatedYesSpinner.setVisibility(View.VISIBLE);

                    if (covid19VaccinatedYesSpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {

                    }

                } else {
                    yesCovid19Vaccinated.setVisibility(View.GONE);
                    covid19VaccinatedYesSpinner.setVisibility(View.GONE);
                    covid19VaccinatedYesSpinner.getSelectedItem().toString().equalsIgnoreCase("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        healthInfoSaveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.healthInfoSaveBtn:
                saveHealthInfo();

                startActivity(new Intent(HealthInfoActivity.this, WelcomeActivity.class));
                finish();
                break;
        }
    }

    private void saveHealthInfo() {

        String height = registerHeight.getText().toString();
        String weight = registerWeight.getText().toString();
        String covid19Vaccinated = covid19VaccinatedSpinner.getSelectedItem().toString();
        String covid19Vaccine = covid19VaccinatedYesSpinner.getSelectedItem().toString();
        String comorbidity = comorbiditySpinner.getSelectedItem().toString();
        String healthIssue = healthIssueName.getText().toString();

        if (height.isEmpty()) {
            registerHeight.setError("Height is required!");
            registerHeight.requestFocus();
        } else if (weight.isEmpty()) {
            registerWeight.setError("Weight is required!");
            registerWeight.requestFocus();
        } else if (covid19Vaccinated.isEmpty()) {
            covid19VaccinatedSpinner.requestFocus();
        } else if (comorbidity.isEmpty()) {
            comorbiditySpinner.requestFocus();
        } else {

            FirebaseUser user = mAuth.getCurrentUser();

            //extracting user reference from database for "Registered Users"
            DatabaseReference personalReference = FirebaseDatabase.getInstance().getReference("Users");

            personalReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {

                    for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                        String userTypeKey = userTypeSnap.getKey();

                        if (userTypeKey.equalsIgnoreCase("Employees")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("height").setValue(height);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("weight").setValue(weight);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("covid19Vaccinated").setValue(covid19Vaccinated);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("covid19Vaccine").setValue(covid19Vaccine);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("healthIssue").setValue(healthIssue);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("healthIssueName").setValue(healthIssueName);

                                    }

                                }

                            }

                        } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("height").setValue(height);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("weight").setValue(weight);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("covid19Vaccinated").setValue(covid19Vaccinated);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("covid19Vaccine").setValue(covid19Vaccine);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("healthIssue").setValue(healthIssue);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("healthIssueName").setValue(healthIssueName);

                                    }

                                }

                            }

                        } else if (userTypeKey.equalsIgnoreCase("Students")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("height").setValue(height);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("weight").setValue(weight);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("covid19Vaccinated").setValue(covid19Vaccinated);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("covid19Vaccine").setValue(covid19Vaccine);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("healthIssue").setValue(healthIssue);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").child("healthIssueName").setValue(healthIssueName);

                                    }

                                }

                            }
                        }
                    }

                }
            });

        }

    }
}