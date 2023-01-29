package com.example.ligtas.ui.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.ligtas.R;
import com.example.ligtas.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    TextView morningOrNight, userName, currentDate;

    private Calendar calendar;
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

    RecyclerView newsfeedRecyclerView;
    List<NewsfeedModel> newsfeedList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        morningOrNight = root.findViewById(R.id.morningOrNight);
        userName = root.findViewById(R.id.userName);
        currentDate = root.findViewById(R.id.currentDate);
        newsfeedRecyclerView = root.findViewById(R.id.newsfeedRecyclerView);

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String month = monthName[calendar.get(Calendar.MONTH)];

        currentDate.setText(month + " " + String.valueOf(day) + "\n" + String.valueOf(year));

        int timeOfTheDay = calendar.get(Calendar.HOUR_OF_DAY);
        if (timeOfTheDay >= 0 && timeOfTheDay < 12) {
            morningOrNight.setText("Good morning!");
        } else if (timeOfTheDay >= 12 && timeOfTheDay < 16) {
            morningOrNight.setText("Good afternoon!");
        } else if (timeOfTheDay >= 16 && timeOfTheDay < 21) {
            morningOrNight.setText("Good evening!");
        } else if (timeOfTheDay >= 21 && timeOfTheDay < 24) {
            morningOrNight.setText("Good night!");
        }

        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Users");

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot userTypeSnap : snapshot.getChildren()) {

                    for (DataSnapshot idNumberSnap : userTypeSnap.getChildren()) {

                        for (DataSnapshot userIdSnap : idNumberSnap.getChildren()) {

                            String userIdKey = userIdSnap.getKey();

                            if (userIdKey.equalsIgnoreCase(FirebaseAuth.getInstance().getUid())) {

                                for (DataSnapshot personalInfoSnap : userIdSnap.getChildren()) {

                                    String personalInfoKey = personalInfoSnap.getKey();

                                    if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                        userName.setText(personalInfoSnap.child("fullName").getValue().toString());

                                    }

                                }

                            }

                        }

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        newsfeedList = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        DatabaseReference newsfeedReference = FirebaseDatabase.getInstance().getReference("Newsfeeds");
        HashMap<String, Object> values = new HashMap<>();

        newsfeedReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                newsfeedList.clear();

                for (DataSnapshot snap : snapshot.getChildren()) {

                    NewsfeedModel newsfeedModel = snap.getValue(NewsfeedModel.class);
                    newsfeedList.add(newsfeedModel);

                }

                NewsfeedAdapter newsfeedAdapter = new NewsfeedAdapter(view.getContext(), newsfeedList);
                newsfeedRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, true));
                newsfeedRecyclerView.setAdapter(newsfeedAdapter);
                newsfeedAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}