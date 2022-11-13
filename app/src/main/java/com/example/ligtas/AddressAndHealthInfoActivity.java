package com.example.ligtas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.ligtas.dbhelpers.AddressDetails;
import com.example.ligtas.dbhelpers.HealthDetails;
import com.example.ligtas.dbhelpers.PersonalDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddressAndHealthInfoActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText registerAddressLineOne, registerAddressLineTwo, registerBrgy, registerCity, registerProvince, registerZipCode, registerEmergencyContactName, registerEmergencyContactPhone;
    AppCompatButton registerSaveBtn;
    TextInputEditText registerHeight, registerWeight;
    Spinner covid19VaccinatedSpinner, comorbiditySpinner, comorbidityYesSpinner, covid19VaccinatedYesSpinner;
    AppCompatTextView yesComorbidity, yesCovid19Vaccinated;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_and_health_info);

        registerAddressLineOne = findViewById(R.id.registerAddressLineOne);
        registerAddressLineTwo = findViewById(R.id.registerAddressLineTwo);
        registerBrgy = findViewById(R.id.registerBrgy);
        registerCity = findViewById(R.id.registerCity);
        registerProvince = findViewById(R.id.registerProvince);
        registerZipCode = findViewById(R.id.registerZipCode);
        registerEmergencyContactName = findViewById(R.id.registerEmergencyContactName);
        registerEmergencyContactPhone = findViewById(R.id.registerEmergencyContactPhone);
        registerEmergencyContactPhone = findViewById(R.id.registerEmergencyContactPhone);
        registerEmergencyContactPhone = findViewById(R.id.registerEmergencyContactPhone);
        registerEmergencyContactPhone = findViewById(R.id.registerEmergencyContactPhone);
        registerEmergencyContactPhone = findViewById(R.id.registerEmergencyContactPhone);
        registerSaveBtn = findViewById(R.id.registerSaveBtn);
        registerHeight = findViewById(R.id.registerHeight);
        registerWeight = findViewById(R.id.registerWeight);
        covid19VaccinatedSpinner = findViewById(R.id.covid19VaccinatedSpinner);
        covid19VaccinatedYesSpinner = findViewById(R.id.covid19VaccinatedYesSpinner);
        yesCovid19Vaccinated = findViewById(R.id.yesCovid19Vaccinated);
        comorbiditySpinner = findViewById(R.id.comorbiditySpinner);
        comorbidityYesSpinner = findViewById(R.id.comorbidityYesSpinner);
        yesComorbidity = findViewById(R.id.yesComorbidity);

        mAuth = FirebaseAuth.getInstance();

        /*Disable the save button*/

        comorbiditySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


                if (comorbiditySpinner.getSelectedItem().toString().equalsIgnoreCase("Yes")) {
                    yesComorbidity.setVisibility(View.VISIBLE);
                    comorbidityYesSpinner.setVisibility(View.VISIBLE);
                } else {
                    yesComorbidity.setVisibility(View.GONE);
                    comorbidityYesSpinner.setVisibility(View.GONE);
                    comorbidityYesSpinner.getSelectedItem().toString().equalsIgnoreCase("None");
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
                } else {
                    yesCovid19Vaccinated.setVisibility(View.GONE);
                    covid19VaccinatedYesSpinner.setVisibility(View.GONE);
                    covid19VaccinatedYesSpinner.getSelectedItem().toString().equalsIgnoreCase("None");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        registerSaveBtn.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.registerSaveBtn:

                /*Function to save health and address information into the database*/
                saveInformation();

                startActivity(new Intent(AddressAndHealthInfoActivity.this, WelcomeActivity.class));
                finish();
                break;

        }
    }

    private void saveInformation() {

        String addressLineOne = registerAddressLineOne.getText().toString();
        String addressLineTwo = registerAddressLineTwo.getText().toString();
        String barangay = registerBrgy.getText().toString();
        String city = registerCity.getText().toString();
        String province = registerProvince.getText().toString();
        String zipCode = registerZipCode.getText().toString();
        String emergencyContactFullName = registerEmergencyContactName.getText().toString();
        String emergencyContactPhoneNumber = registerEmergencyContactPhone.getText().toString();
        String height = registerHeight.getText().toString();
        String weight = registerWeight.getText().toString();
        String covid19Vaccinated = covid19VaccinatedSpinner.getSelectedItem().toString();
        String covid19Vaccine = covid19VaccinatedYesSpinner.getSelectedItem().toString();
        String comorbidity = comorbiditySpinner.getSelectedItem().toString();
        String comorbidityYes = comorbidityYesSpinner.getSelectedItem().toString();

        if (addressLineOne.isEmpty()) {
            registerAddressLineOne.setError("Address Line One is required!");
            registerAddressLineOne.requestFocus();

        } else if (addressLineTwo.isEmpty()) {
            registerAddressLineOne.setText("None");

        } else if (barangay.isEmpty()) {
            registerBrgy.setError("Barangay is required!");
            registerBrgy.requestFocus();
        } else if (city.isEmpty()) {
            registerCity.setError("City/Municipality is required!");
            registerCity.requestFocus();
        } else if (province.isEmpty()) {
            registerProvince.setError("Province is required!");
            registerProvince.requestFocus();
        } else if (zipCode.isEmpty()) {
            registerZipCode.setError("Zip Code is required!");
            registerZipCode.requestFocus();
        } else if (emergencyContactFullName.isEmpty()) {
            registerEmergencyContactName.setError("Emergency Contact is required!");
            registerEmergencyContactName.requestFocus();
        } else if (emergencyContactPhoneNumber.isEmpty()) {
            registerEmergencyContactPhone.setError("Emergency Contact is required!");
            registerEmergencyContactPhone.requestFocus();
        } else if (height.isEmpty()) {
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

            /*Enable save button*/

            //store user data into realtime database
            HealthDetails healthDetails = new HealthDetails(height, weight, covid19Vaccinated, covid19Vaccine, comorbidity, comorbidityYes);

            AddressDetails addressDetails = new AddressDetails(addressLineOne, addressLineTwo, barangay, city, province, zipCode, emergencyContactFullName, emergencyContactPhoneNumber);

            //extracting user reference from database for "Registered Users"
            DatabaseReference personalReference = FirebaseDatabase.getInstance().getReference("Users");
            DatabaseReference addressReference = FirebaseDatabase.getInstance().getReference("Users");

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

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").setValue(healthDetails);

                                    }

                                }

                            }
                        } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").setValue(healthDetails);

                                    }

                                }

                            }
                        } else if (userTypeKey.equalsIgnoreCase("Students")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Health Information").setValue(healthDetails);

                                    }

                                }

                            }
                        }
                    }

                }
            });

            addressReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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

                                        addressReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").setValue(addressDetails);

                                    }
                                }

                            }
                        } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        addressReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").setValue(addressDetails);

                                    }

                                }

                            }
                        } else if (userTypeKey.equalsIgnoreCase("Students")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        addressReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").setValue(addressDetails);

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