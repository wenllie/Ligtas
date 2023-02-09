package com.example.ligtas.ui.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ligtas.MainActivity;
import com.example.ligtas.R;
import com.example.ligtas.dbhelpers.AddressDetails;
import com.example.ligtas.dbhelpers.HealthDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView fromEditProfileToSettings;
    TextInputEditText editEmail, editPhoneNumber;
    TextInputEditText editFullName, editGender, editBirthday, editAge, editIdNumber;
    TextInputEditText editAddressLine1, editAddressLine2, editBarangay, editCity;
    TextInputEditText editProvince, editZipCode, editEmergencyContactName, editEmergencyContactPhoneNumber;
    TextInputEditText editHeight, editWeight, editCovid19Vaccinated, editCovid19Vaccine, editHealthIssue;
    AppCompatButton changePasswordBtn, updateProfileBtn;
    AppCompatTextView deactivateAccountBtn;

    FirebaseAuth mAuth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        fromEditProfileToSettings = findViewById(R.id.fromEditProfileToSettings);
        editEmail = findViewById(R.id.editEmail);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editFullName = findViewById(R.id.editFullName);
        editIdNumber = findViewById(R.id.editIdNumber);
        editGender = findViewById(R.id.editGender);
        editBirthday = findViewById(R.id.editBirthday);
        editAge = findViewById(R.id.editAge);
        editAddressLine1 = findViewById(R.id.editAddressLine1);
        editAddressLine2 = findViewById(R.id.editAddressLine2);
        editBarangay = findViewById(R.id.editBarangay);
        editCity = findViewById(R.id.editCity);
        editProvince = findViewById(R.id.editProvince);
        editZipCode = findViewById(R.id.editZipCode);
        editEmergencyContactName = findViewById(R.id.editEmergencyContactName);
        editEmergencyContactPhoneNumber = findViewById(R.id.editEmergencyContactPhoneNumber);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
        editCovid19Vaccinated = findViewById(R.id.editCovid19Vaccinated);
        editCovid19Vaccine = findViewById(R.id.editCovid19Vaccine);
        editHealthIssue = findViewById(R.id.editHealthIssue);
        changePasswordBtn = findViewById(R.id.changePasswordBtn);
        updateProfileBtn = findViewById(R.id.updateProfileBtn);
        deactivateAccountBtn = findViewById(R.id.deactivateAccountBtn);

        mAuth = FirebaseAuth.getInstance();

        showUserInformation();

        fromEditProfileToSettings.setOnClickListener(this);
        changePasswordBtn.setOnClickListener(this);
        updateProfileBtn.setOnClickListener(this);
        deactivateAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toSettings = new Intent(EditProfileActivity.this, SettingsActivity.class);
        toSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toSettings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toSettings);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fromEditProfileToSettings:
                onBackPressed();
                break;
            case R.id.changePasswordBtn:
                startActivity(new Intent(EditProfileActivity.this, ChangePasswordActivity.class));
                finish();
                break;

            case R.id.updateProfileBtn:
                updateProfile();
                break;

            case R.id.deactivateAccountBtn:
                deactivateAccount();
                break;
        }
    }

    private void deactivateAccount() {

        Calendar current = Calendar.getInstance();
        current.add(Calendar.DATE, 30);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Date resultdate = new Date(current.getTimeInMillis());
        String dueudate = df.format(resultdate);


        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(this);

        dialogBuilder.setTitle("Deactivate Account")
                .setMessage("You can restore your account if it was accidentally or wrongfully deactivated for up to 30 days after deactivation" +
                        "\n\nDo you still want to continue?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                        mAuth.signOut();
                        startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                        finish();
/*                        if (current.after(resultdate)) {
                            mAuth.getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {



                                    }

                                }
                            });

                            mAuth.signOut();
                            dialogInterface.dismiss();
                            startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                            finish();
                        }*/
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

    private void updateProfile() {

        String addressLine1 = editAddressLine1.getText().toString();
        String addressLine2 = editAddressLine2.getText().toString();
        String barangay = editBarangay.getText().toString();
        String city = editCity.getText().toString();
        String province = editProvince.getText().toString();
        String zipCode = editZipCode.getText().toString();
        String emergencyContactName = editEmergencyContactName.getText().toString();
        String emergencyContactPhoneNumber = editEmergencyContactPhoneNumber.getText().toString();
        String height = editHeight.getText().toString();
        String weight = editWeight.getText().toString();
        String covid19Vaccinated = editCovid19Vaccinated.getText().toString();
        String covid19Vaccine = editCovid19Vaccine.getText().toString();
        String healthIssue = editHealthIssue.getText().toString();

        HashMap addressDetails = new HashMap();
        addressDetails.put("addressLineOne", addressLine1);
        addressDetails.put("addressLineTwo", addressLine2);
        addressDetails.put("barangay", barangay);
        addressDetails.put("city", city);
        addressDetails.put("province", province);
        addressDetails.put("zipCode", zipCode);
        addressDetails.put("emergencyContactName", emergencyContactName);
        addressDetails.put("emergencyContactPhoneNumber", emergencyContactPhoneNumber);

        HashMap healthDetails = new HashMap();
        healthDetails.put("height", height);
        healthDetails.put("weight", weight);
        healthDetails.put("covid19Vaccinated", covid19Vaccinated);
        healthDetails.put("covid19Vaccine", covid19Vaccine);
        healthDetails.put("healthIssue", healthIssue);

        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Users");

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot userTypeSnap : snapshot.getChildren()) {

                    String userTypeKey = userTypeSnap.getKey();

                    if (userTypeKey.equalsIgnoreCase("Employees")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            String idNumberKey = idNumberSnap.getKey();

                            for (DataSnapshot uidSnap : idNumberSnap.getChildren()) {

                                String uidKey = uidSnap.getKey();

                                if (uidKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot snap : uidSnap.getChildren()) {

                                        String addressKey = snap.getKey();

                                        if (addressKey.equalsIgnoreCase("Address Information")) {

                                            userReference.child(userTypeKey).child(idNumberKey).child(uidKey).child(addressKey).updateChildren(addressDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {

                                                        editAddressLine1.setText(addressLine1);
                                                        editAddressLine2.setText(addressLine2);
                                                        editBarangay.setText(barangay);
                                                        editCity.setText(city);
                                                        editProvince.setText(province);
                                                        editZipCode.setText(zipCode);
                                                        editEmergencyContactName.setText(emergencyContactName);
                                                        editEmergencyContactPhoneNumber.setText(emergencyContactPhoneNumber);
                                                        editAddressLine1.clearFocus();
                                                        editAddressLine2.clearFocus();
                                                        editBarangay.clearFocus();
                                                        editCity.clearFocus();
                                                        editProvince.clearFocus();
                                                        editZipCode.clearFocus();
                                                        editEmergencyContactName.clearFocus();
                                                        editEmergencyContactPhoneNumber.clearFocus();

                                                        Toast.makeText(EditProfileActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(EditProfileActivity.this, "Update failed!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                        } else if (addressKey.equalsIgnoreCase("Health Information")) {

                                            userReference.child(userTypeKey).child(idNumberKey).child(uidKey).child(addressKey).updateChildren(healthDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {

                                                        editHeight.setText(height);
                                                        editWeight.setText(weight);
                                                        editCovid19Vaccinated.setText(covid19Vaccinated);
                                                        editCovid19Vaccine.setText(covid19Vaccine);
                                                        editHealthIssue.setText(healthIssue);
                                                        editHeight.clearFocus();
                                                        editWeight.clearFocus();
                                                        editCovid19Vaccinated.clearFocus();
                                                        editCovid19Vaccine.clearFocus();
                                                        editHealthIssue.clearFocus();

                                                        Toast.makeText(EditProfileActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(EditProfileActivity.this, "Update failed!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                        }

                                    }

                                }

                            }

                        }

                    } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            String idNumberKey = idNumberSnap.getKey();

                            for (DataSnapshot uidSnap : idNumberSnap.getChildren()) {

                                String uidKey = uidSnap.getKey();

                                if (uidKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot snap : uidSnap.getChildren()) {

                                        String addressKey = snap.getKey();

                                        if (addressKey.equalsIgnoreCase("Address Information")) {

                                            userReference.child(userTypeKey).child(idNumberKey).child(uidKey).child(addressKey).updateChildren(addressDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {

                                                        editAddressLine1.setText(addressLine1);
                                                        editAddressLine2.setText(addressLine2);
                                                        editBarangay.setText(barangay);
                                                        editCity.setText(city);
                                                        editProvince.setText(province);
                                                        editZipCode.setText(zipCode);
                                                        editEmergencyContactName.setText(emergencyContactName);
                                                        editEmergencyContactPhoneNumber.setText(emergencyContactPhoneNumber);
                                                        editAddressLine1.clearFocus();
                                                        editAddressLine2.clearFocus();
                                                        editBarangay.clearFocus();
                                                        editCity.clearFocus();
                                                        editProvince.clearFocus();
                                                        editZipCode.clearFocus();
                                                        editEmergencyContactName.clearFocus();
                                                        editEmergencyContactPhoneNumber.clearFocus();

                                                        Toast.makeText(EditProfileActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(EditProfileActivity.this, "Update failed!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                        } else if (addressKey.equalsIgnoreCase("Health Information")) {

                                            userReference.child(userTypeKey).child(idNumberKey).child(uidKey).child(addressKey).updateChildren(healthDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {

                                                        editHeight.setText(height);
                                                        editWeight.setText(weight);
                                                        editCovid19Vaccinated.setText(covid19Vaccinated);
                                                        editCovid19Vaccine.setText(covid19Vaccine);
                                                        editHealthIssue.setText(healthIssue);
                                                        editHeight.clearFocus();
                                                        editWeight.clearFocus();
                                                        editCovid19Vaccinated.clearFocus();
                                                        editCovid19Vaccine.clearFocus();
                                                        editHealthIssue.clearFocus();

                                                        Toast.makeText(EditProfileActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(EditProfileActivity.this, "Update failed!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                        }

                                    }

                                }

                            }

                        }

                    } else if (userTypeKey.equalsIgnoreCase("Students")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            String idNumberKey = idNumberSnap.getKey();

                            for (DataSnapshot uidSnap : idNumberSnap.getChildren()) {

                                String uidKey = uidSnap.getKey();

                                if (uidKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot snap : uidSnap.getChildren()) {

                                        String addressKey = snap.getKey();

                                        if (addressKey.equalsIgnoreCase("Address Information")) {

                                            userReference.child(userTypeKey).child(idNumberKey).child(uidKey).child(addressKey).updateChildren(addressDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {

                                                        editAddressLine1.setText(addressLine1);
                                                        editAddressLine2.setText(addressLine2);
                                                        editBarangay.setText(barangay);
                                                        editCity.setText(city);
                                                        editProvince.setText(province);
                                                        editZipCode.setText(zipCode);
                                                        editEmergencyContactName.setText(emergencyContactName);
                                                        editEmergencyContactPhoneNumber.setText(emergencyContactPhoneNumber);
                                                        editAddressLine1.clearFocus();
                                                        editAddressLine2.clearFocus();
                                                        editBarangay.clearFocus();
                                                        editCity.clearFocus();
                                                        editProvince.clearFocus();
                                                        editZipCode.clearFocus();
                                                        editEmergencyContactName.clearFocus();
                                                        editEmergencyContactPhoneNumber.clearFocus();

                                                        Toast.makeText(EditProfileActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(EditProfileActivity.this, "Update failed!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                        } else if (addressKey.equalsIgnoreCase("Health Information")) {

                                            userReference.child(userTypeKey).child(idNumberKey).child(uidKey).child(addressKey).updateChildren(healthDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {

                                                        editHeight.setText(height);
                                                        editWeight.setText(weight);
                                                        editCovid19Vaccinated.setText(covid19Vaccinated);
                                                        editCovid19Vaccine.setText(covid19Vaccine);
                                                        editHealthIssue.setText(healthIssue);
                                                        editHeight.clearFocus();
                                                        editWeight.clearFocus();
                                                        editCovid19Vaccinated.clearFocus();
                                                        editCovid19Vaccine.clearFocus();
                                                        editHealthIssue.clearFocus();

                                                        Toast.makeText(EditProfileActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(EditProfileActivity.this, "Update failed!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void showUserInformation() {

        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Users");

        userReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                    String userTypeKey = userTypeSnap.getKey();

                    if (userTypeKey.equalsIgnoreCase("Employees")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                String userIdSnap = snap.getKey();

                                if (userIdSnap.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot personalInfoSnap : snap.getChildren()) {

                                        String personalInfoKey = personalInfoSnap.getKey();

                                        if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            editEmail.setText(personalInfoSnap.child("email").getValue().toString());
                                            editPhoneNumber.setText(personalInfoSnap.child("phoneNumber").getValue().toString());
                                            editFullName.setText(personalInfoSnap.child("fullName").getValue().toString());
                                            editGender.setText(personalInfoSnap.child("gender").getValue().toString());
                                            editBirthday.setText(personalInfoSnap.child("birthday").getValue().toString());
                                            editAge.setText(personalInfoSnap.child("age").getValue().toString());
                                            editIdNumber.setText(personalInfoSnap.child("idNumber").getValue().toString());

                                        } else if (personalInfoKey.equalsIgnoreCase("Address Information")) {

                                            editAddressLine1.setText(personalInfoSnap.child("addressLine1").getValue().toString());
                                            editAddressLine2.setText(personalInfoSnap.child("addressLine2").getValue().toString());
                                            editBarangay.setText(personalInfoSnap.child("barangay").getValue().toString());
                                            editCity.setText(personalInfoSnap.child("city").getValue().toString());
                                            editProvince.setText(personalInfoSnap.child("province").getValue().toString());
                                            editZipCode.setText(personalInfoSnap.child("zipCode").getValue().toString());
                                            editEmergencyContactName.setText(personalInfoSnap.child("emergencyContactFullName").getValue().toString());
                                            editEmergencyContactPhoneNumber.setText(personalInfoSnap.child("emergencyContactPhone").getValue().toString());

                                        } else if (personalInfoKey.equalsIgnoreCase("Health Information")) {

                                            editHeight.setText(personalInfoSnap.child("height").getValue().toString());
                                            editWeight.setText(personalInfoSnap.child("weight").getValue().toString());
                                            editCovid19Vaccinated.setText(personalInfoSnap.child("covid19Vaccinated").getValue().toString());
                                            editCovid19Vaccine.setText(personalInfoSnap.child("covid19Vaccine").getValue().toString());
                                            editHealthIssue.setText(personalInfoSnap.child("healthIssue").getValue().toString());

                                        }

                                    }

                                }

                            }
                        }

                    } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                String userIdSnap = snap.getKey();

                                if (userIdSnap.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot personalInfoSnap : snap.getChildren()) {

                                        String personalInfoKey = personalInfoSnap.getKey();

                                        if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            editEmail.setText(personalInfoSnap.child("email").getValue().toString());
                                            editPhoneNumber.setText(personalInfoSnap.child("phoneNumber").getValue().toString());
                                            editFullName.setText(personalInfoSnap.child("fullName").getValue().toString());
                                            editGender.setText(personalInfoSnap.child("gender").getValue().toString());
                                            editBirthday.setText(personalInfoSnap.child("birthday").getValue().toString());
                                            editAge.setText(personalInfoSnap.child("age").getValue().toString());
                                            editIdNumber.setText(personalInfoSnap.child("idNumber").getValue().toString());

                                        } else if (personalInfoKey.equalsIgnoreCase("Address Information")) {

                                            editAddressLine1.setText(personalInfoSnap.child("addressLine1").getValue().toString());
                                            editAddressLine2.setText(personalInfoSnap.child("addressLine2").getValue().toString());
                                            editBarangay.setText(personalInfoSnap.child("barangay").getValue().toString());
                                            editCity.setText(personalInfoSnap.child("city").getValue().toString());
                                            editProvince.setText(personalInfoSnap.child("province").getValue().toString());
                                            editZipCode.setText(personalInfoSnap.child("zipCode").getValue().toString());
                                            editEmergencyContactName.setText(personalInfoSnap.child("emergencyContactFullName").getValue().toString());
                                            editEmergencyContactPhoneNumber.setText(personalInfoSnap.child("emergencyContactPhone").getValue().toString());

                                        } else if (personalInfoKey.equalsIgnoreCase("Health Information")) {

                                            editHeight.setText(personalInfoSnap.child("height").getValue().toString());
                                            editWeight.setText(personalInfoSnap.child("weight").getValue().toString());
                                            editCovid19Vaccinated.setText(personalInfoSnap.child("covid19Vaccinated").getValue().toString());
                                            editCovid19Vaccine.setText(personalInfoSnap.child("covid19Vaccine").getValue().toString());
                                            editHealthIssue.setText(personalInfoSnap.child("healthIssue").getValue().toString());

                                        }

                                    }

                                }

                            }
                        }

                    } else if (userTypeKey.equalsIgnoreCase("Students")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            for (DataSnapshot snap : idNumberSnap.getChildren()) {

                                String userIdSnap = snap.getKey();

                                if (userIdSnap.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot personalInfoSnap : snap.getChildren()) {

                                        String personalInfoKey = personalInfoSnap.getKey();

                                        if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            editEmail.setText(personalInfoSnap.child("email").getValue().toString());
                                            editPhoneNumber.setText(personalInfoSnap.child("phoneNumber").getValue().toString());
                                            editFullName.setText(personalInfoSnap.child("fullName").getValue().toString());
                                            editGender.setText(personalInfoSnap.child("gender").getValue().toString());
                                            editBirthday.setText(personalInfoSnap.child("birthday").getValue().toString());
                                            editAge.setText(personalInfoSnap.child("age").getValue().toString());
                                            editIdNumber.setText(personalInfoSnap.child("idNumber").getValue().toString());

                                        } else if (personalInfoKey.equalsIgnoreCase("Address Information")) {

                                            editAddressLine1.setText(personalInfoSnap.child("addressLine1").getValue().toString());
                                            editAddressLine2.setText(personalInfoSnap.child("addressLine2").getValue().toString());
                                            editBarangay.setText(personalInfoSnap.child("barangay").getValue().toString());
                                            editCity.setText(personalInfoSnap.child("city").getValue().toString());
                                            editProvince.setText(personalInfoSnap.child("province").getValue().toString());
                                            editZipCode.setText(personalInfoSnap.child("zipCode").getValue().toString());
                                            editEmergencyContactName.setText(personalInfoSnap.child("emergencyContactFullName").getValue().toString());
                                            editEmergencyContactPhoneNumber.setText(personalInfoSnap.child("emergencyContactPhone").getValue().toString());

                                        } else if (personalInfoKey.equalsIgnoreCase("Health Information")) {

                                            editHeight.setText(personalInfoSnap.child("height").getValue().toString());
                                            editWeight.setText(personalInfoSnap.child("weight").getValue().toString());
                                            editCovid19Vaccinated.setText(personalInfoSnap.child("covid19Vaccinated").getValue().toString());
                                            editCovid19Vaccine.setText(personalInfoSnap.child("covid19Vaccine").getValue().toString());
                                            editHealthIssue.setText(personalInfoSnap.child("healthIssue").getValue().toString());

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
}