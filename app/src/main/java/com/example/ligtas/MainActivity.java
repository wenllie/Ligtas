package com.example.ligtas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*Declare variables*/
    AppCompatTextView userRegisterTextView, forgotPassword;
    TextInputEditText userEmail, userPassword;
    AppCompatButton signInBtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Initialize variables*/
        userRegisterTextView = findViewById(R.id.userRegisterTextView);
        forgotPassword = findViewById(R.id.forgotPassword);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        signInBtn = findViewById(R.id.signInBtn);

        mAuth = FirebaseAuth.getInstance();

        /*Set on click listeners*/
        userRegisterTextView.setOnClickListener(this);
        signInBtn.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        finishAffinity();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.userRegisterTextView:

                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                finish();
                break;
                
            case R.id.signInBtn:
                signInUser();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
                finish();
                break;

        }
    }

    private void signInUser() {

        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            userEmail.setError("Email is required!");
            userEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            userPassword.setError("Password is required!");
            userPassword.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        if (mAuth.getCurrentUser().isEmailVerified()) {

                            startActivity(new Intent(MainActivity.this, UserNavigationActivity.class));
                            finish();

                        } else {

                            Toast.makeText(MainActivity.this, "Please verify your email address!", Toast.LENGTH_SHORT).show();
                            clearField();
                            FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();
                            FirebaseAuth.getInstance().signOut();

                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Log in failed! \n" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

    }

    private void clearField() {

        userEmail.setText("");
        userEmail.clearFocus();
        userPassword.setText("");
        userPassword.clearFocus();

    }
}