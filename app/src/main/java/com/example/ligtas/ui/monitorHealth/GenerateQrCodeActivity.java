package com.example.ligtas.ui.monitorHealth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ligtas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class GenerateQrCodeActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView fromhaTomyh;
    ImageView qrCodeImageView;
    AppCompatButton downloadQRButton;
    AppCompatTextView nameTextView, currentDateTextView;
    LinearLayoutCompat QRCodeLayout;

    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    private Bitmap bitmaps;
    private QRGEncoder qrgEncoder;
    private AppCompatActivity activity;

    String currentDate;
    String qrCodeText;
    String name;

    private String savePath = Environment.getExternalStorageDirectory().getPath() + "/LigtasQRCode/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr_code);

        fromhaTomyh = findViewById(R.id.fromhaTomyh);
        qrCodeImageView = findViewById(R.id.qrCodeImageView);
        downloadQRButton = findViewById(R.id.downloadQRButton);
        nameTextView = findViewById(R.id.nameTextView);
        currentDateTextView = findViewById(R.id.currentDateTextView);
        QRCodeLayout = findViewById(R.id.QRCodeLayout);

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String month = monthName[calendar.get(Calendar.MONTH)];

        currentDate = month + " " + day + " " + year;

        currentDateTextView.setText(month + " " + day + ", " + year);

        activity = this;

        downloadQRButton.setOnClickListener(this);
        fromhaTomyh.setOnClickListener(this);

        DatabaseReference generateQRReference = FirebaseDatabase.getInstance().getReference().child("Users");

        generateQRReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                    String userTypeKey = userTypeSnap.getKey();

                    if (userTypeKey.equalsIgnoreCase("Employees")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            String userIDNumber = idNumberSnap.getKey();

                            for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                String userIdKey = userIdSnap.getKey();

                                if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot assessmentSnap : userIdSnap.getChildren()) {

                                        String assessmentKey = assessmentSnap.getKey();

                                        if (assessmentKey.equalsIgnoreCase("Daily Self Assessment")) {

                                            for (DataSnapshot dateSnap : assessmentSnap.getChildren()) {

                                                String dateKey = dateSnap.getKey();

                                                if (dateKey.equalsIgnoreCase(currentDate)) {

                                                    for (DataSnapshot snap : dateSnap.getChildren()) {

                                                        String assessedKey = snap.getKey();

                                                        if (assessedKey.equalsIgnoreCase("condition")) {

                                                            String condition = snap.getValue().toString();

                                                            if (condition.equalsIgnoreCase("Good Condition")) {

                                                                qrCodeText = userIDNumber + "=" + condition + "=" + currentDate + "=" + userTypeKey;

                                                                MultiFormatWriter writer = new MultiFormatWriter();

                                                                try {
                                                                    BitMatrix matrix = writer.encode(qrCodeText, BarcodeFormat.QR_CODE, 600, 600);
                                                                    BarcodeEncoder encoder = new BarcodeEncoder();
                                                                    bitmaps = encoder.createBitmap(matrix);
                                                                    qrCodeImageView.setImageBitmap(bitmaps);
                                                                } catch (WriterException e) {
                                                                    e.printStackTrace();
                                                                }

                                                            }


                                                        }

                                                    }

                                                }

                                            }

                                        } else if (assessmentKey.equalsIgnoreCase("Personal Information")) {

                                            name = assessmentSnap.child("fullName").getValue().toString();

                                            nameTextView.setText(name);


                                        }

                                    }

                                }

                            }

                        }

                    } else if (userTypeKey.equalsIgnoreCase("Professors")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            String userIDNumber = idNumberSnap.getKey();

                            for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                String userIdKey = userIdSnap.getKey();

                                if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot assessmentSnap : userIdSnap.getChildren()) {

                                        String assessmentKey = assessmentSnap.getKey();

                                        if (assessmentKey.equalsIgnoreCase("Daily Self Assessment")) {

                                            for (DataSnapshot dateSnap : assessmentSnap.getChildren()) {

                                                String dateKey = dateSnap.getKey();

                                                if (dateKey.equalsIgnoreCase(currentDate)) {

                                                    for (DataSnapshot snap : dateSnap.getChildren()) {

                                                        String assessedKey = snap.getKey();

                                                        if (assessedKey.equalsIgnoreCase("condition")) {

                                                            String condition = snap.getValue().toString();

                                                            if (condition.equalsIgnoreCase("Good Condition")) {

                                                                qrCodeText = userIDNumber + "=" + condition + "=" + currentDate + "=" + userTypeKey;

                                                                MultiFormatWriter writer = new MultiFormatWriter();

                                                                try {
                                                                    BitMatrix matrix = writer.encode(qrCodeText, BarcodeFormat.QR_CODE, 600, 600);
                                                                    BarcodeEncoder encoder = new BarcodeEncoder();
                                                                    bitmaps = encoder.createBitmap(matrix);
                                                                    qrCodeImageView.setImageBitmap(bitmaps);
                                                                } catch (WriterException e) {
                                                                    e.printStackTrace();
                                                                }

                                                            }


                                                        }

                                                    }

                                                }

                                            }

                                        } else if (assessmentKey.equalsIgnoreCase("Personal Information")) {

                                            name = assessmentSnap.child("fullName").getValue().toString();

                                            nameTextView.setText(name);


                                        }

                                    }

                                }

                            }

                        }

                    } else if (userTypeKey.equalsIgnoreCase("Students")) {

                        for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                            String userIDNumber = idNumberSnap.getKey();

                            for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                                String userIdKey = userIdSnap.getKey();

                                if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                    for (DataSnapshot assessmentSnap : userIdSnap.getChildren()) {

                                        String assessmentKey = assessmentSnap.getKey();

                                        if (assessmentKey.equalsIgnoreCase("Daily Self Assessment")) {

                                            for (DataSnapshot dateSnap : assessmentSnap.getChildren()) {

                                                String dateKey = dateSnap.getKey();

                                                if (dateKey.equalsIgnoreCase(currentDate)) {

                                                    for (DataSnapshot snap : dateSnap.getChildren()) {

                                                        String assessedKey = snap.getKey();

                                                        if (assessedKey.equalsIgnoreCase("condition")) {

                                                            String condition = snap.getValue().toString();

                                                            if (condition.equalsIgnoreCase("Good Condition")) {

                                                                qrCodeText = userIDNumber + "=" + condition + "=" + currentDate + "=" + userTypeKey;

                                                                MultiFormatWriter writer = new MultiFormatWriter();

                                                                try {
                                                                    BitMatrix matrix = writer.encode(qrCodeText, BarcodeFormat.QR_CODE, 600, 600);
                                                                    BarcodeEncoder encoder = new BarcodeEncoder();
                                                                    bitmaps = encoder.createBitmap(matrix);
                                                                    qrCodeImageView.setImageBitmap(bitmaps);
                                                                } catch (WriterException e) {
                                                                    e.printStackTrace();
                                                                }

                                                                /*WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                                                                Display display = manager.getDefaultDisplay();
                                                                Point point = new Point();
                                                                display.getSize(point);
                                                                int width = point.x;
                                                                int height = point.y;
                                                                int smallerDimension = Math.min(width, height);
                                                                smallerDimension = smallerDimension * 3 / 4;

                                                                qrgEncoder = new QRGEncoder(qrCodeText, null, QRGContents.Type.TEXT, smallerDimension);

                                                                try {
                                                                    bitmaps = qrgEncoder.getBitmap();
                                                                    qrCodeImageView.setImageBitmap(bitmaps);
                                                                } catch (Exception e) {
                                                                    e.printStackTrace();
                                                                }*/

                                                            }


                                                        }

                                                    }

                                                }

                                            }

                                        } else if (assessmentKey.equalsIgnoreCase("Personal Information")) {

                                            name = assessmentSnap.child("fullName").getValue().toString();

                                            nameTextView.setText(name);


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

    @Override
    public void onBackPressed() {
        Intent tomyh = new Intent(GenerateQrCodeActivity.this, MonitorYourHealthActivity.class);
        tomyh.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        tomyh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(tomyh);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fromhaTomyh:
                onBackPressed();
                break;

            case R.id.downloadQRButton:

                saveImage();

                /*if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    try {
                        boolean save = new QRGSaver().save(savePath, qrCodeText, bitmaps, QRGContents.ImageType.IMAGE_JPEG);
                        String result = save ? "Image Saved" : "Image Not Saved";
                        Toast.makeText(activity, result, Toast.LENGTH_LONG).show();
                        qrCodeText = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                }

                // Save with location, value, bitmap returned and type of Image(JPG/PNG).
                QRGSaver qrgSaver = new QRGSaver();
                String fName = name;
                fName = fName.replace(" ", "_");
                String cDate = currentDate;
                cDate = cDate.replace(" ", "_");
                qrgSaver.save(savePath, fName + "_" + cDate, bitmaps, QRGContents.ImageType.IMAGE_JPEG);*/

                break;

        }
    }

    private void saveImage() {

        QRCodeLayout.setDrawingCacheEnabled(true);
        QRCodeLayout.buildDrawingCache();
        QRCodeLayout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = QRCodeLayout.getDrawingCache();
        save(bitmap);

    }

    private void save(Bitmap bitmap) {

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/LigtasQRCode/");

        if (!file.exists()) {
            file.mkdirs();
        }

        String fName = name;
        fName = fName.replace(" ", "_");
        String cDate = currentDate;
        cDate = cDate.replace(" ", "_");
        String filename = fName + "_" + cDate + ".jpg";
        File myfile = new File(file, filename);

        if (myfile.exists()) {
            myfile.delete();
        }

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(activity, "Image saved Successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}