package com.example.ligtas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ligtas.dbhelpers.AddressDetails;
import com.example.ligtas.dbhelpers.PersonalDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    /*Declare variables*/
    AppCompatTextView userSignInTextView;
    Spinner registerGender, userTypeSpinner;
    AppCompatButton registerBtn, registerBirthdayDateBtn;
    CheckBox termsConditionsCheckbox;
    TextInputEditText registerEmail, registerPhoneNumber, registerPassword, registerConfirmPassword, registerFullName, registerBirthday, registerAge, registerIdNumber;

    private MaterialAlertDialogBuilder termsDialog;
    private int mYear, mMonth, mDay;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*Initialize variables*/
        userSignInTextView = findViewById(R.id.userSignInTextView);
        registerGender = findViewById(R.id.registerGender);
        registerBirthdayDateBtn = findViewById(R.id.registerBirthdayDateBtn);
        registerBtn = findViewById(R.id.registerBtn);
        termsConditionsCheckbox = findViewById(R.id.termsConditionsCheckbox);
        registerEmail = findViewById(R.id.registerEmail);
        registerPhoneNumber = findViewById(R.id.registerPhoneNumber);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        registerFullName = findViewById(R.id.registerFullName);
        registerIdNumber = findViewById(R.id.registerIdNumber);
        registerBirthday = findViewById(R.id.registerBirthday);
        registerAge = findViewById(R.id.registerAge);
        userTypeSpinner = findViewById(R.id.userTypeSpinner);

        mAuth = FirebaseAuth.getInstance();

        /*Check box for terms and conditions*/

        //Disable the register button
        registerBtn.setEnabled(false);
        termsDialog = new MaterialAlertDialogBuilder(this);
        termsConditionsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    termsDialog.setTitle("Terms & Conditions and Privacy Policy");
                    termsDialog.setMessage(getResources().getString(R.string.terms_and_conditions) + "\n\n" + getResources().getString(R.string.privacy_policy));
                    termsDialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            registerBtn.setEnabled(true);
                            dialogInterface.dismiss();
                        }
                    });
                    termsConditionsCheckbox.setChecked(true);
                    termsDialog.show();
                } else {
                    termsConditionsCheckbox.setChecked(false);
                    registerBtn.setEnabled(false);
                }
            }
        });

        /*Set on click listeners*/
        userSignInTextView.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        registerBirthdayDateBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toLogin = new Intent(RegisterActivity.this, MainActivity.class);
        toLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toLogin);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.userSignInTextView:
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();
                break;

            case R.id.registerBtn:
                createUserProfile();
                break;

            case R.id.registerBirthdayDateBtn:

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                final Calendar birthday = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int month, int day) {
                                registerBirthday.setText(day + "-" + (month + 1) + "-" + year);
                                birthday.set(year, month, day);
                                c.set(mYear, mMonth, mDay);
                                int age = c.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
                                if (c.get(Calendar.DAY_OF_YEAR) < birthday.get(Calendar.DAY_OF_YEAR)) {
                                    age--;
                                }
                                Integer ageInt = new Integer(age);
                                registerAge.setText(ageInt.toString());
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
        }
    }

    private void createUserProfile() {

        //extract data from edit text
        String email = registerEmail.getText().toString();
        String phoneNumber = registerPhoneNumber.getText().toString();
        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();
        String fullName = registerFullName.getText().toString();
        String idNumber = registerIdNumber.getText().toString();
        String gender = registerGender.getSelectedItem().toString();
        String birthday = registerBirthday.getText().toString();
        String age = registerAge.getText().toString();
        String userType = userTypeSpinner.getSelectedItem().toString();

        //verify that edit text fields are not empty
        if (email.isEmpty()) {
            registerEmail.setError("Email is required!");
            registerEmail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {         //verify that email address is a valid email
            registerEmail.setError("Please enter a valid email address.");
            registerEmail.requestFocus();
            return;
        } else if (phoneNumber.isEmpty()) {
            registerPhoneNumber.setError("Phone Number is required!");
            registerPhoneNumber.requestFocus();
            return;
        }else if (!Patterns.PHONE.matcher(phoneNumber).matches()) {         //verify that email address is a valid email
            registerPhoneNumber.setError("Please enter a valid Phone Number.");
            registerPhoneNumber.requestFocus();
            return;
        } else if (fullName.isEmpty()) {
            registerFullName.setError("Full Name is required!");
            registerFullName.requestFocus();
            return;
        } else if (idNumber.isEmpty()){
            registerIdNumber.setError("ID Number is required!");
            registerIdNumber.requestFocus();
        }else if (gender.isEmpty()) {
            registerGender.requestFocus();
            return;
        } else if (birthday.isEmpty()) {
            registerBirthday.setError("Birthday is required!");
            registerBirthday.requestFocus();
            return;
        } else if (age.isEmpty()) {
            registerAge.setError("Age is required!");
            registerAge.requestFocus();
            return;
        } else if (password.isEmpty()) {
            registerPassword.setError("Password is required!");
            registerPassword.requestFocus();
            return;
        }
        if (confirmPassword.isEmpty()) {
            registerConfirmPassword.setError("Confirm password is required!");
            registerConfirmPassword.requestFocus();
            return;
        }
        if (!password.equals(confirmPassword)) {         //verify that password and confirm password is the same
            registerPassword.setError("Password do not match!");
            registerPassword.requestFocus();
            registerConfirmPassword.setError("Password do not match!");
            registerConfirmPassword.requestFocus();
            return;
        }
        if (password.equals(confirmPassword)) {

            if (userType.equalsIgnoreCase("Employee")) {

                //Create user profile
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            //store user data into realtime database
                            PersonalDetails personalDetails = new PersonalDetails(user.getUid(), email, phoneNumber, fullName, gender, birthday, age, idNumber);

                            //extracting user reference from database for "Registered Users"
                            DatabaseReference personalReference = FirebaseDatabase.getInstance().getReference("Users").child("Employees");

                            personalReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    for (DataSnapshot snap : task.getResult().getChildren()) {

                                        String IDKey = snap.getKey();

                                        if (IDKey.equalsIgnoreCase(idNumber)) {

                                            Toast.makeText(RegisterActivity.this, idNumber + " is already registered. Please enter a different ID number", Toast.LENGTH_SHORT).show();

                                        } else {

                                            personalReference.child(idNumber).child(user.getUid()).child("Personal Information").setValue(personalDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {
                                                        //send email verification
                                                        user.sendEmailVerification();

                                                        // to get the user ID for verifying user
//                                    UserVerifyActivity.userID = user.getUid();

                                                        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                                                            @Override
                                                            public void onVerificationCompleted(PhoneAuthCredential credential) {
                                                            }

                                                            @Override
                                                            public void onVerificationFailed(FirebaseException e) {
                                                                Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                                            }

                                                            @Override
                                                            public void onCodeSent(@NonNull String verificationId,
                                                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                                                //verify user after successful registration
                                                                Intent verify = new Intent(RegisterActivity.this, UserVerifyActivity.class);
                                                                //prevent user from returning back to the register page on pressing back button after registration
                                                                verify.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                verify.putExtra("phone", registerPhoneNumber.getText().toString().trim());
                                                                verify.putExtra("verificationId", verificationId);
                                                                startActivity(verify);
                                                                finish();
                                                            }
                                                        };
                                                        PhoneAuthOptions options =
                                                                PhoneAuthOptions.newBuilder(mAuth)
                                                                        .setPhoneNumber("+63" + registerPhoneNumber.getText().toString().trim())       // Phone number to verify
                                                                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                                                        .setActivity(RegisterActivity.this)                 // Activity (for callback binding)
                                                                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                                                        .build();
                                                        PhoneAuthProvider.verifyPhoneNumber(options);

                                                    } else {
                                                        Toast.makeText(RegisterActivity.this, "Registration failed! Please try again.", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });

                                        }
                                    }

                                }
                            });


                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                registerPassword.setError("Password is too weak! Please use combination of alphabets, numbers and special characters.");
                                registerPassword.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                registerEmail.setError("Email is invalid or already in use! Please use another email.");
                                registerEmail.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e) {
                                registerEmail.setError("User already registered with this email! Please use another email.");
                                registerEmail.requestFocus();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });

            } else if (userType.equalsIgnoreCase("Professor")) {

                //Create user profile
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            //store user data into realtime database
                            PersonalDetails personalDetails = new PersonalDetails(user.getUid(), email, phoneNumber, fullName, gender, birthday, age, idNumber);

                            //extracting user reference from database for "Registered Users"
                            DatabaseReference personalReference = FirebaseDatabase.getInstance().getReference("Users").child("Professors");

                            personalReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    for (DataSnapshot snap : task.getResult().getChildren()) {

                                        String IDKey = snap.getKey();

                                        if (IDKey.equalsIgnoreCase(idNumber)) {

                                            Toast.makeText(RegisterActivity.this, idNumber + " is already registered. Please enter a different ID number", Toast.LENGTH_SHORT).show();

                                        } else {

                                            personalReference.child(idNumber).child(user.getUid()).child("Personal Information").setValue(personalDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {
                                                        //send email verification
                                                        user.sendEmailVerification();

                                                        // to get the user ID for verifying user
//                                    UserVerifyActivity.userID = user.getUid();

                                                        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                                                            @Override
                                                            public void onVerificationCompleted(PhoneAuthCredential credential) {
                                                            }

                                                            @Override
                                                            public void onVerificationFailed(FirebaseException e) {
                                                                Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                                            }

                                                            @Override
                                                            public void onCodeSent(@NonNull String verificationId,
                                                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                                                //verify user after successful registration
                                                                Intent verify = new Intent(RegisterActivity.this, UserVerifyActivity.class);
                                                                //prevent user from returning back to the register page on pressing back button after registration
                                                                verify.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                verify.putExtra("phone", registerPhoneNumber.getText().toString().trim());
                                                                verify.putExtra("verificationId", verificationId);
                                                                startActivity(verify);
                                                                finish();
                                                            }
                                                        };
                                                        PhoneAuthOptions options =
                                                                PhoneAuthOptions.newBuilder(mAuth)
                                                                        .setPhoneNumber("+63" + registerPhoneNumber.getText().toString().trim())       // Phone number to verify
                                                                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                                                        .setActivity(RegisterActivity.this)                 // Activity (for callback binding)
                                                                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                                                        .build();
                                                        PhoneAuthProvider.verifyPhoneNumber(options);

                                                    } else {
                                                        Toast.makeText(RegisterActivity.this, "Registration failed! Please try again.", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });

                                        }
                                    }

                                }
                            });


                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                registerPassword.setError("Password is too weak! Please use combination of alphabets, numbers and special characters.");
                                registerPassword.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                registerEmail.setError("Email is invalid or already in use! Please use another email.");
                                registerEmail.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e) {
                                registerEmail.setError("User already registered with this email! Please use another email.");
                                registerEmail.requestFocus();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });

            } else if (userType.equalsIgnoreCase("Student")) {

                //Create user profile
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            //store user data into realtime database
                            PersonalDetails personalDetails = new PersonalDetails(user.getUid(), email, phoneNumber, fullName, gender, birthday, age, idNumber);

                            //extracting user reference from database for "Registered Users"
                            DatabaseReference personalReference = FirebaseDatabase.getInstance().getReference("Users").child("Students");

                            personalReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    for (DataSnapshot snap : task.getResult().getChildren()) {

                                        String IDKey = snap.getKey();

                                        if (IDKey.equalsIgnoreCase(idNumber)) {

                                            Toast.makeText(RegisterActivity.this, idNumber + " is already registered. Please enter a different ID number", Toast.LENGTH_SHORT).show();

                                        } else {

                                            personalReference.child(idNumber).child(user.getUid()).child("Personal Information").setValue(personalDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()) {
                                                        //send email verification
                                                        user.sendEmailVerification();

                                                        // to get the user ID for verifying user
//                                    UserVerifyActivity.userID = user.getUid();

                                                        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                                                            @Override
                                                            public void onVerificationCompleted(PhoneAuthCredential credential) {
                                                            }

                                                            @Override
                                                            public void onVerificationFailed(FirebaseException e) {
                                                                Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                                            }

                                                            @Override
                                                            public void onCodeSent(@NonNull String verificationId,
                                                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                                                //verify user after successful registration
                                                                Intent verify = new Intent(RegisterActivity.this, UserVerifyActivity.class);
                                                                //prevent user from returning back to the register page on pressing back button after registration
                                                                verify.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                verify.putExtra("phone", registerPhoneNumber.getText().toString().trim());
                                                                verify.putExtra("verificationId", verificationId);
                                                                startActivity(verify);
                                                                finish();
                                                            }
                                                        };
                                                        PhoneAuthOptions options =
                                                                PhoneAuthOptions.newBuilder(mAuth)
                                                                        .setPhoneNumber("+63" + registerPhoneNumber.getText().toString().trim())       // Phone number to verify
                                                                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                                                        .setActivity(RegisterActivity.this)                 // Activity (for callback binding)
                                                                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                                                        .build();
                                                        PhoneAuthProvider.verifyPhoneNumber(options);

                                                    } else {
                                                        Toast.makeText(RegisterActivity.this, "Registration failed! Please try again.", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });

                                        }
                                    }

                                }
                            });


                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                registerPassword.setError("Password is too weak! Please use combination of alphabets, numbers and special characters.");
                                registerPassword.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                registerEmail.setError("Email is invalid or already in use! Please use another email.");
                                registerEmail.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e) {
                                registerEmail.setError("User already registered with this email! Please use another email.");
                                registerEmail.requestFocus();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

            } else {
                Toast.makeText(this, "Please select type of user", Toast.LENGTH_SHORT).show();
            }
        }
    }
}