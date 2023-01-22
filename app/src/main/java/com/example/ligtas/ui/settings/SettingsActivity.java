package com.example.ligtas.ui.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ligtas.R;
import com.example.ligtas.UserNavigationActivity;
import com.example.ligtas.ui.termsAndConditions.TermsAndConditionsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView fromSettingsToDashboard;
    CircleImageView profileImage;
    AppCompatTextView registeredFullName, registeredEmail;
    RelativeLayout aboutUsLayout, donateLayout, editProfileLayout, darkModeLayout, contactUsLayout;

    //theme
    ThemePref themePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        themePref = new ThemePref(this);
        if (themePref.loadNightModeState() == 2){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else if (themePref.loadNightModeState() == 1){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fromSettingsToDashboard = findViewById(R.id.fromSettingsToDashboard);
        profileImage = findViewById(R.id.profileImage);
        registeredFullName = findViewById(R.id.registeredFullName);
        registeredEmail = findViewById(R.id.registeredEmail);
        aboutUsLayout = findViewById(R.id.aboutUsLayout);
        donateLayout = findViewById(R.id.donateLayout);
        editProfileLayout = findViewById(R.id.editProfileLayout);
        darkModeLayout = findViewById(R.id.darkModeLayout);
        contactUsLayout = findViewById(R.id.contactUsLayout);


        /*Display user information*/
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

                                            Picasso.get().load(personalInfoSnap.child("profileUrl").getValue().toString()).into(profileImage);

                                        } else if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            registeredFullName.setText(personalInfoSnap.child("fullName").getValue().toString());
                                            registeredEmail.setText(personalInfoSnap.child("email").getValue().toString());

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

                                            Picasso.get().load(personalInfoSnap.child("profileUrl").getValue().toString()).into(profileImage);

                                        } if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            registeredFullName.setText(personalInfoSnap.child("fullName").getValue().toString());
                                            registeredEmail.setText(personalInfoSnap.child("email").getValue().toString());


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

                                            Picasso.get().load(personalInfoSnap.child("profileUrl").getValue().toString()).into(profileImage);

                                        } else if (personalInfoKey.equalsIgnoreCase("Personal Information")) {

                                            registeredFullName.setText(personalInfoSnap.child("fullName").getValue().toString());
                                            registeredEmail.setText(personalInfoSnap.child("email").getValue().toString());

                                        }

                                    }

                                }

                            }

                        }
                    }

                }

            }
        });

        //app theme light, dark, system
        darkModeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus themeDialog = DialogPlus.newDialog(SettingsActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.pop_up_set_theme))
                        .setExpanded(true, 1000)
                        .create();

                View v = themeDialog.getHolderView();

                RadioGroup radioGroup = v.findViewById(R.id.radioGroupTheme);
                RadioButton radioLight = v.findViewById(R.id.radioLight);
                RadioButton radioDark = v.findViewById(R.id.radioDark);
                RadioButton radioSystem = v.findViewById(R.id.radioSystem);

                if (themePref.loadNightModeState() == 2){
                    radioDark.setChecked(true);
                } else if (themePref.loadNightModeState() == 1){
                    radioLight.setChecked(true);
                } else {
                    radioSystem.setChecked(true);
                }

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int position) {

                        int id = radioGroup.getCheckedRadioButtonId();

                        switch (id) {
                            case R.id.radioLight:
                                themePref.setNightModeState(1);
                                restartApp();
                                break;

                            case R.id.radioDark:
                                themePref.setNightModeState(2);
                                restartApp();
                                break;

                            case R.id.radioSystem:
                                themePref.setNightModeState(-1);
                                restartApp();
                                break;
                        }
                    }
                });

                themeDialog.show();
            }
        });


        fromSettingsToDashboard.setOnClickListener(this);
        aboutUsLayout.setOnClickListener(this);
        donateLayout.setOnClickListener(this);
        editProfileLayout.setOnClickListener(this);
        contactUsLayout.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent toDashboard = new Intent(SettingsActivity.this, UserNavigationActivity.class);
        toDashboard.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(toDashboard);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fromSettingsToDashboard:
                onBackPressed();
                break;

            case R.id.aboutUsLayout:
                final DialogPlus aboutUsDialog = DialogPlus.newDialog(SettingsActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_about_us))
                        .setExpanded(true, 1500)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                aboutUsDialog.show();
                break;

            case R.id.donateLayout:
                final DialogPlus donateDialog = DialogPlus.newDialog(SettingsActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_donate))
                        .setExpanded(true, 1600)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                donateDialog.show();
                break;

            case R.id.editProfileLayout:
                startActivity(new Intent(SettingsActivity.this, EditProfileActivity.class));
                finish();
                break;

            case R.id.contactUsLayout:
                final DialogPlus contactUsDialog = DialogPlus.newDialog(SettingsActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.dialog_box_contact_us))
                        .setExpanded(true, 1400)
                        .setContentBackgroundResource(R.drawable.dialog_rounded_top)
                        .create();

                contactUsDialog.show();
                break;
        }
    }

    private void restartApp() {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
        finish();
    }
}