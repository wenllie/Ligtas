package com.example.ligtasscanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton scanQRCodeMainActButton;
    DatabaseReference acceptedReference;

    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};
    String currentDate;
    String infoKey = "";
    String userName = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acceptedReference = FirebaseDatabase.getInstance().getReference().child("Accepted");
        scanQRCodeMainActButton = findViewById(R.id.scanQRCodeMainActButton);


        scanQRCodeMainActButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.scanQRCodeMainActButton:
                scanQRCode();
                break;

        }

    }

    private void scanQRCode() {

        IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);

        intentIntegrator.setPrompt("Use volume up key to open flash");
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);
//        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.UPC_A);
        intentIntegrator.initiateScan();
        Intent intent = intentIntegrator.createScanIntent();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult != null) {
            if (intentResult.getContents() != null) {
                if (intentResult.getFormatName().equals(IntentIntegrator.QR_CODE)) {

                    LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                    View view = layoutInflater.inflate(R.layout.card_view_scanned_code, null);

                    AppCompatButton denyButton = view.findViewById(R.id.denyButton);
                    AppCompatButton acceptButton = view.findViewById(R.id.acceptButton);
                    AppCompatTextView nameTextView = view.findViewById(R.id.nameTextView);
                    AppCompatTextView IdNumberTextView = view.findViewById(R.id.IdNumberTextView);
                    AppCompatTextView dateTextView = view.findViewById(R.id.dateTextView);
                    AppCompatImageView userPhoto = view.findViewById(R.id.userPhoto);

                    AlertDialog showScanned = new AlertDialog.Builder(MainActivity.this)
                            .setView(view)
                            .create();

                    String[] contents = intentResult.getContents().split("=");
                    String IDNumber = contents[0];
                    String userType = contents[3];
                    DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Users");

                    userReference = userReference.child(userType).child(IDNumber);
                    userReference.get().addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (DataSnapshot userID : task.getResult().getChildren()) {
                                String userIDkey = userID.getKey();
                                for (DataSnapshot info : userID.getChildren()) {
                                    infoKey = info.getKey();
                                    if (infoKey.equalsIgnoreCase("Personal Information")) {
                                        userName = info.child("fullName").getValue().toString();
                                        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();
                                        nameTextView.setText(userName);
                                    } else if (infoKey.equalsIgnoreCase("Profile Photo")) {
                                        imageUrl = info.child("profileUrl").getValue().toString();
                                        Glide.with(MainActivity.this).load(imageUrl).into(userPhoto);
                                    }
                                }
                            }
                        } else {
                            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                        }

                    });

                    IdNumberTextView.setText(contents[0]);
                    dateTextView.setText(contents[2]);

                    acceptButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int year = calendar.get(Calendar.YEAR);
                            String month = monthName[calendar.get(Calendar.MONTH)];

                            currentDate = month + " " + day + " " + year;


                            if (currentDate.equalsIgnoreCase(dateTextView.getText().toString())) {
                                acceptedReference.child(userType).child(currentDate).child(IDNumber).child("Name").setValue(nameTextView.getText().toString());
                            } else {
                                Toast.makeText(MainActivity.this, "Old QR Code", Toast.LENGTH_SHORT).show();
                            }

                            showScanned.dismiss();
                        }
                    });

                    denyButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            showScanned.dismiss();
                        }
                    });

                    showScanned.show();
                    showScanned.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));

                }
            }
        }

    }
}