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

import com.example.ligtas.dbhelpers.AddressDetails;
import com.example.ligtas.dbhelpers.HealthDetails;
import com.example.ligtas.ui.stayHealthy.Day6IntermediateActivity;
import com.example.ligtas.ui.stayHealthy.IntermediateWorkoutActivity;
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

public class AddressInfoActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText registerAddressLineOne, registerAddressLineTwo, registerBrgy, registerCity, registerProvince, registerZipCode, registerEmergencyContactName, registerEmergencyContactPhone;
    AppCompatButton addressInfoSaveBtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_info);

        registerAddressLineOne = findViewById(R.id.registerAddressLineOne);
        registerAddressLineTwo = findViewById(R.id.registerAddressLineTwo);
        registerBrgy = findViewById(R.id.registerBrgy);
        registerCity = findViewById(R.id.registerCity);
        registerProvince = findViewById(R.id.registerProvince);
        registerZipCode = findViewById(R.id.registerZipCode);
        registerEmergencyContactName = findViewById(R.id.registerEmergencyContactName);
        registerEmergencyContactPhone = findViewById(R.id.registerEmergencyContactPhone);
        addressInfoSaveBtn = findViewById(R.id.addressInfoSaveBtn);

        mAuth = FirebaseAuth.getInstance();

        addressInfoSaveBtn.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exercise")
                .setMessage("Are you sure you want to cancel your registration?\n\nNote: Once you cancel your registration, you will be needing to contact support if you want to register again with the same credentials.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAffinity();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.addressInfoSaveBtn:

                /*Function to save health and address information into the database*/
                saveInformation();

                startActivity(new Intent(AddressInfoActivity.this, HealthInfoActivity.class));
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
        } else if (zipCode.length() != 4) {
            registerZipCode.setError("Zip Code is incorrectly inputted!");
            registerZipCode.requestFocus();
        }else if (zipCode.isEmpty()) {
            registerZipCode.setError("Zip Code is required!");
            registerZipCode.requestFocus();
        } else if (emergencyContactFullName.isEmpty()) {
            registerEmergencyContactName.setError("Emergency Contact is required!");
            registerEmergencyContactName.requestFocus();
        } else if (emergencyContactPhoneNumber.isEmpty()) {
            registerEmergencyContactPhone.setError("Emergency Contact is required!");
            registerEmergencyContactPhone.requestFocus();
        } else {

            FirebaseUser user = mAuth.getCurrentUser();

            AddressDetails addressDetails = new AddressDetails(addressLineOne, addressLineTwo, barangay, city, province, zipCode, emergencyContactFullName, emergencyContactPhoneNumber);

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

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("addressLine1").setValue(addressLineOne);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("addressLine2").setValue(addressLineTwo);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("barangay").setValue(barangay);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("city").setValue(city);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("province").setValue(province);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("zipCode").setValue(zipCode);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("emergencyContactFullName").setValue(emergencyContactFullName);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("emergencyContactPhone").setValue(emergencyContactPhoneNumber);

                                    }

                                }

                            }

                        } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("addressLine1").setValue(addressLineOne);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("addressLine2").setValue(addressLineTwo);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("barangay").setValue(barangay);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("city").setValue(city);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("province").setValue(province);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("zipCode").setValue(zipCode);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("emergencyContactFullName").setValue(emergencyContactFullName);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("emergencyContactPhone").setValue(emergencyContactPhoneNumber);

                                    }

                                }

                            }

                        } else if (userTypeKey.equalsIgnoreCase("Students")) {

                            for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                                String idNumberKey = idNumberSnap.getKey();

                                for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                    String userIdSnap = snap.getKey();

                                    if (userIdSnap.equalsIgnoreCase(user.getUid())) {

                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("addressLine1").setValue(addressLineOne);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("addressLine2").setValue(addressLineTwo);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("barangay").setValue(barangay);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("city").setValue(city);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("province").setValue(province);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("zipCode").setValue(zipCode);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("emergencyContactFullName").setValue(emergencyContactFullName);
                                        personalReference.child(userTypeKey).child(idNumberKey).child(userIdSnap).child("Address Information").child("emergencyContactPhone").setValue(emergencyContactPhoneNumber);

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