package com.example.ligtasscanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AcceptedListActivity extends AppCompatActivity {

    RecyclerView acceptedListRecyclerView;
    ArrayList<AcceptedListMain> acceptedListMainArrayList;
    ArrayList<AcceptedListContent> acceptedListContentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted_list);

        acceptedListRecyclerView = findViewById(R.id.acceptedListRecyclerView);

        acceptedListMainArrayList = new ArrayList<>();
        acceptedListContentArrayList = new ArrayList<>();

        DatabaseReference acceptedList = FirebaseDatabase.getInstance().getReference().child("Accepted");

        acceptedList.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                String userTypeKey = task.getResult().getKey();

                for (DataSnapshot dateSnap : task.getResult().getChildren()) {

                    String dateKey = dateSnap.getKey();


                    for (DataSnapshot idNumberSnap : dateSnap.getChildren()) {

                        AcceptedListContent acceptedListContent = idNumberSnap.getValue(AcceptedListContent.class);
                        acceptedListContentArrayList.add(acceptedListContent);
                        Toast.makeText(AcceptedListActivity.this, idNumberSnap.getValue().toString(), Toast.LENGTH_SHORT).show();
                    }

                    acceptedListMainArrayList.add(new AcceptedListMain(dateKey, acceptedListContentArrayList));

                }

                AcceptedListMainAdapter acceptedListMainAdapter = new AcceptedListMainAdapter(acceptedListMainArrayList, AcceptedListActivity.this);
                acceptedListRecyclerView.setLayoutManager(new LinearLayoutManager(AcceptedListActivity.this, LinearLayoutManager.VERTICAL, false));
                acceptedListRecyclerView.setAdapter(acceptedListMainAdapter);
                acceptedListMainAdapter.notifyDataSetChanged();

            }
        });

    }
}