package com.example.ligtas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    TextInputEditText forgotPasswordEmail;
    AppCompatButton resetPasswordBtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        resetPasswordBtn = findViewById(R.id.resetPasswordBtn);
        forgotPasswordEmail = findViewById(R.id.forgotPasswordEmail);

        mAuth = FirebaseAuth.getInstance();

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetPassword();

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgotPasswordActivity.this, MainActivity.class));
        finish();
    }

    private void resetPassword() {

        String email = forgotPasswordEmail.getText().toString();

        if (email.isEmpty()) {

            forgotPasswordEmail.setError("Email is required!");
            forgotPasswordEmail.requestFocus();

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {         //verify that email address is a valid email
            forgotPasswordEmail.setError("Please enter a valid email address.");
            forgotPasswordEmail.requestFocus();
        } else {

            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(ForgotPasswordActivity.this, "Click the link sent to your email to change your password.", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ForgotPasswordActivity.this, MainActivity.class));
                        finish();
                    }
                }
            });

        }

    }
}