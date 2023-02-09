package com.example.ligtasscanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AcceptedListActivity extends AppCompatActivity {

    RecyclerView acceptedListRecyclerView;
    AppCompatSpinner userTypeSpinner, dateSpinner;
    AppCompatImageView acceptedListBackBtn;
    FloatingActionButton downloadFloatingButton;

    ArrayList<AcceptedListContent> acceptedListContentArrayList;

    ArrayList<String> userTypeList;
    ArrayList<String> dateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted_list);

        acceptedListRecyclerView = findViewById(R.id.acceptedListRecyclerView);
        userTypeSpinner = findViewById(R.id.userTypeSpinner);
        dateSpinner = findViewById(R.id.dateSpinner);
        acceptedListBackBtn = findViewById(R.id.acceptedListBackBtn);
        downloadFloatingButton = findViewById(R.id.downloadFloatingButton);

        userTypeList = new ArrayList<>();
        dateList = new ArrayList<>();

        acceptedListContentArrayList = new ArrayList<>();

        DatabaseReference userTypeRef = FirebaseDatabase.getInstance().getReference().child("Accepted");

        userTypeRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                userTypeList.clear();

                for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                    String userTypeKey = userTypeSnap.getKey();
                    userTypeList.add(userTypeKey);


                }

                ArrayAdapter<String> userTypeAdapter = new ArrayAdapter<String>(AcceptedListActivity.this, android.R.layout.simple_spinner_dropdown_item, userTypeList);
                userTypeSpinner.setAdapter(userTypeAdapter);
            }
        });

        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                DatabaseReference acceptedList = FirebaseDatabase.getInstance().getReference().child("Accepted");

                if (userTypeSpinner.getSelectedItem().toString().equalsIgnoreCase("Employees")) {

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Accepted");

                    reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                                String userTypeKey = userTypeSnap.getKey();

                                if (userTypeKey.equalsIgnoreCase("Employees")) {
                                    dateList.clear();

                                    for (DataSnapshot dateSnap : userTypeSnap.getChildren()) {

                                        String dateKey = dateSnap.getKey();
                                        dateList.add(dateKey);

                                    }

                                }

                            }

                            ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(AcceptedListActivity.this, android.R.layout.simple_spinner_dropdown_item, dateList);
                            dateSpinner.setAdapter(dateAdapter);

                        }
                    });

                    dateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                            acceptedList.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                                        String userTypeKey = userTypeSnap.getKey();

                                        if (userTypeKey.equalsIgnoreCase("Employees")) {

                                            for (DataSnapshot dateSnap : userTypeSnap.getChildren()) {

                                                String dateKey = dateSnap.getKey();

                                                if (dateKey.equalsIgnoreCase(dateList.get(position))) {
                                                    acceptedListContentArrayList.clear();

                                                    for (DataSnapshot idSnap : dateSnap.getChildren()) {

                                                        AcceptedListContent acceptedListContent = idSnap.getValue(AcceptedListContent.class);
                                                        acceptedListContentArrayList.add(acceptedListContent);

                                                    }

                                                }

                                            }

                                        }

                                    }

                                    AcceptedListMainAdapter acceptedListMainAdapter = new AcceptedListMainAdapter(acceptedListContentArrayList, AcceptedListActivity.this);
                                    acceptedListRecyclerView.setLayoutManager(new LinearLayoutManager(AcceptedListActivity.this, LinearLayoutManager.VERTICAL, false));
                                    acceptedListRecyclerView.setAdapter(acceptedListMainAdapter);
                                    acceptedListMainAdapter.notifyDataSetChanged();

                                }
                            });

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                } else if (userTypeSpinner.getSelectedItem().toString().equalsIgnoreCase("Students")) {

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Accepted");

                    reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                                String userTypeKey = userTypeSnap.getKey();

                                if (userTypeKey.equalsIgnoreCase("Students")) {
                                    dateList.clear();

                                    for (DataSnapshot dateSnap : userTypeSnap.getChildren()) {

                                        String dateKey = dateSnap.getKey();
                                        dateList.add(dateKey);

                                    }

                                }

                            }

                            ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(AcceptedListActivity.this, android.R.layout.simple_spinner_dropdown_item, dateList);
                            dateSpinner.setAdapter(dateAdapter);

                        }
                    });

                    dateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                            acceptedList.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                                        String userTypeKey = userTypeSnap.getKey();

                                        if (userTypeKey.equalsIgnoreCase("Students")) {

                                            for (DataSnapshot dateSnap : userTypeSnap.getChildren()) {

                                                String dateKey = dateSnap.getKey();

                                                if (dateKey.equalsIgnoreCase(dateList.get(position))) {
                                                    acceptedListContentArrayList.clear();

                                                    for (DataSnapshot idSnap : dateSnap.getChildren()) {

                                                        AcceptedListContent acceptedListContent = idSnap.getValue(AcceptedListContent.class);
                                                        acceptedListContentArrayList.add(acceptedListContent);

                                                    }

                                                }

                                            }

                                        }

                                    }

                                    AcceptedListMainAdapter acceptedListMainAdapter = new AcceptedListMainAdapter(acceptedListContentArrayList, AcceptedListActivity.this);
                                    acceptedListRecyclerView.setLayoutManager(new LinearLayoutManager(AcceptedListActivity.this, LinearLayoutManager.VERTICAL, false));
                                    acceptedListRecyclerView.setAdapter(acceptedListMainAdapter);
                                    acceptedListMainAdapter.notifyDataSetChanged();

                                }
                            });

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                } else if (userTypeSpinner.getSelectedItem().toString().equalsIgnoreCase("Professors")) {

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Accepted");

                    reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                                String userTypeKey = userTypeSnap.getKey();

                                if (userTypeKey.equalsIgnoreCase("Professors")) {
                                    dateList.clear();

                                    for (DataSnapshot dateSnap : userTypeSnap.getChildren()) {

                                        String dateKey = dateSnap.getKey();
                                        dateList.add(dateKey);

                                    }

                                }

                            }

                            ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(AcceptedListActivity.this, android.R.layout.simple_spinner_dropdown_item, dateList);
                            dateSpinner.setAdapter(dateAdapter);

                        }
                    });

                    dateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                            acceptedList.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    for (DataSnapshot userTypeSnap : task.getResult().getChildren()) {

                                        String userTypeKey = userTypeSnap.getKey();

                                        if (userTypeKey.equalsIgnoreCase("Professors")) {

                                            for (DataSnapshot dateSnap : userTypeSnap.getChildren()) {

                                                String dateKey = dateSnap.getKey();

                                                if (dateKey.equalsIgnoreCase(dateList.get(position))) {
                                                    acceptedListContentArrayList.clear();

                                                    for (DataSnapshot idSnap : dateSnap.getChildren()) {

                                                        AcceptedListContent acceptedListContent = idSnap.getValue(AcceptedListContent.class);
                                                        acceptedListContentArrayList.add(acceptedListContent);

                                                    }

                                                }

                                            }

                                        }

                                    }

                                    AcceptedListMainAdapter acceptedListMainAdapter = new AcceptedListMainAdapter(acceptedListContentArrayList, AcceptedListActivity.this);
                                    acceptedListRecyclerView.setLayoutManager(new LinearLayoutManager(AcceptedListActivity.this, LinearLayoutManager.VERTICAL, false));
                                    acceptedListRecyclerView.setAdapter(acceptedListMainAdapter);
                                    acceptedListMainAdapter.notifyDataSetChanged();

                                }
                            });

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        downloadFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(AcceptedListActivity.this)
                        .setTitle("Download PDF")
                        .setMessage("Is your theme set to a light theme?\n\nNote: Make sure that your theme is in \"Light Theme\" before downloading PDF.")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                final ProgressDialog progressDialog = new ProgressDialog(AcceptedListActivity.this);
                                progressDialog.setTitle("Downloading");
                                progressDialog.setCancelable(false);
                                progressDialog.show();

                                PdfGenerator.getBuilder()
                                        .setContext(AcceptedListActivity.this)
                                        .fromViewIDSource()
                                        .fromViewID(AcceptedListActivity.this, R.id.linearLayoutPDF)
                                        .setFileName(userTypeSpinner.getSelectedItem().toString() + dateSpinner.getSelectedItem().toString())
                                        .setFolderNameOrPath("Ligtas/")
                                        .actionAfterPDFGeneration(PdfGenerator.ActionAfterPDFGeneration.OPEN)
                                        .build(new PdfGeneratorListener() {
                                            @Override
                                            public void onFailure(FailureResponse failureResponse) {
                                                super.onFailure(failureResponse);
                                                progressDialog.dismiss();
                                            }

                                            @Override
                                            public void onStartPDFGeneration() {
                                                progressDialog.setMessage("Your PDF file is downloading.");

                                            }

                                            @Override
                                            public void onFinishPDFGeneration() {
                                                progressDialog.dismiss();
                                            }

                                            @Override
                                            public void onSuccess(SuccessResponse response) {
                                                super.onSuccess(response);
                                                progressDialog.dismiss();
                                                Toast.makeText(AcceptedListActivity.this, "Created successfully!", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();

            }
        });


        acceptedListBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(AcceptedListActivity.this, MainActivity.class);
        back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
        finish();
    }
}