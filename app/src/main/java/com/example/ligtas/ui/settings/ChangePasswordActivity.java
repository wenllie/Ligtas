package com.example.ligtas.ui.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ligtas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePasswordActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextInputEditText currentPassword, newPassword, confirmNewPassword;
    AppCompatButton authenticatePasswordBtn, updatePasswordBtn;
    ImageView backToEditProfile;
    TextView textVerify;

    private String currPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        authenticatePasswordBtn = (AppCompatButton) findViewById(R.id.authenticatePasswordBtn);
        updatePasswordBtn = (AppCompatButton) findViewById(R.id.updatePasswordBtn);
        currentPassword = (TextInputEditText) findViewById(R.id.currentPassword);
        newPassword = (TextInputEditText) findViewById(R.id.newPassword);
        confirmNewPassword = (TextInputEditText) findViewById(R.id.confirmNewPassword);
        textVerify = (TextView) findViewById(R.id.textVerify);
        backToEditProfile = (ImageView) findViewById(R.id.backToEditProfile);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if (firebaseUser == null){
            Toast.makeText(this, "Something went wrong! User not available!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ChangePasswordActivity.this, EditProfileActivity.class));
            finish();
        } else {
            reAuthenticateUser(firebaseUser);
        }

        backToEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent toEditProfile = new Intent(ChangePasswordActivity.this, EditProfileActivity.class);
        startActivity(toEditProfile);
        finish();
    }

    //Re-authenticate user before updating the password
    private void reAuthenticateUser(FirebaseUser firebaseUser) {
        authenticatePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currPassword = currentPassword.getText().toString();

                if (TextUtils.isEmpty(currPassword)){
                    currentPassword.setError("Please enter your current password!");
                    currentPassword.requestFocus();
                    textVerify.setVisibility(View.VISIBLE);
                } else {
                    AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), currPassword);

                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                textVerify.setVisibility(View.GONE);
                                authenticatePasswordBtn.setEnabled(false);
                                currentPassword.setEnabled(false);

                                newPassword.setEnabled(true);
                                confirmNewPassword.setEnabled(true);
                                updatePasswordBtn.setEnabled(true);

                                Toast.makeText(ChangePasswordActivity.this, "Password has been verified! Change your password now.", Toast.LENGTH_SHORT).show();


                                updatePasswordBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        changePassword(firebaseUser);
                                    }
                                });
                            } else {
                                try {
                                    throw task.getException();
                                } catch (Exception e) {
                                    Toast.makeText(ChangePasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    private void changePassword(FirebaseUser firebaseUser) {
        String newPwd = newPassword.getText().toString();
        String confirmNewPwd = confirmNewPassword.getText().toString();

        if (TextUtils.isEmpty(newPwd)){
            newPassword.setError("This field is required!");
            newPassword.requestFocus();
        } else if (TextUtils.isEmpty(confirmNewPwd)){
            confirmNewPassword.setError("This field is required!");
            confirmNewPassword.requestFocus();
        }  else if (newPwd.length() < 8 && !isValidPassword(newPassword.getText().toString())) {
            newPassword.setError("Password must contain a minimum of 8 characters with special characters!");
            newPassword.requestFocus();
        } else if (!newPwd.matches(confirmNewPwd)){
            newPassword.setError("Passwords do not match!");
            newPassword.requestFocus();
        }else {
            firebaseUser.updatePassword(newPwd).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(ChangePasswordActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ChangePasswordActivity.this, EditProfileActivity.class));
                        finish();
                    } else {
                        try {
                            throw task.getException();
                        } catch (Exception e){
                            Toast.makeText(ChangePasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}