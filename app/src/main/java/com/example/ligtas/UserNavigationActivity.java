package com.example.ligtas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ligtas.databinding.ActivityUserNavigationBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserNavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityUserNavigationBinding binding;

    TextView navFullName;
    CircleImageView navProfilePicture;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarUserNavigation.toolbar);

        mAuth = FirebaseAuth.getInstance();

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        navFullName = navigationView.getHeaderView(0).findViewById(R.id.navFullName);
        navProfilePicture = navigationView.getHeaderView(0).findViewById(R.id.navProfilePicture);

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

                                        if (personalInfoKey.equalsIgnoreCase("Profile Photo")) {

                                            Picasso.get().load(personalInfoSnap.child("profileUrl").getValue().toString()).into(navProfilePicture);

                                        } else if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            navFullName.setText(personalInfoSnap.child("fullName").getValue().toString());

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

                                        if (personalInfoKey.equalsIgnoreCase("Profile Photo")) {

                                            Picasso.get().load(personalInfoSnap.child("profileUrl").getValue().toString()).into(navProfilePicture);

                                        } else if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            navFullName.setText(personalInfoSnap.child("fullName").getValue().toString());

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

                                        if (personalInfoKey.equalsIgnoreCase("Profile Photo")) {

                                            Picasso.get().load(personalInfoSnap.child("profileUrl").getValue().toString()).into(navProfilePicture);

                                        } else if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            navFullName.setText(personalInfoSnap.child("fullName").getValue().toString());

                                        }

                                    }

                                }

                            }

                        }
                    }

                }

            }
        });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_dashboard, R.id.nav_stay_healthy, R.id.nav_monitor_your_health,
                R.id.nav_settings, R.id.nav_terms_and_conditions, R.id.nav_privacy_policy, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setItemIconTintList(null);
        navigationView.getMenu().findItem(R.id.nav_logout).setOnMenuItemClickListener(menuItem -> {
            logout();
            return true;
        });
    }

    private void logout() {

        mAuth.signOut();
        Intent signout = new Intent(UserNavigationActivity.this, MainActivity.class);//open login activity on successful logout
        signout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        signout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(signout);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}