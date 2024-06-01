package com.example.couponadvantage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PROFILE extends AppCompatActivity {

    private TextView textViewUserName, textViewUserEmail;
    private EditText editTextUserPhone;
    private Button buttonEditProfile;
    private ImageView imageViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();


        textViewUserName = findViewById(R.id.textViewUserName);
        textViewUserEmail = findViewById(R.id.textViewUserEmail);
        editTextUserPhone = findViewById(R.id.editTextUserPhone);
        buttonEditProfile = findViewById(R.id.buttonEditProfile);
        imageViewProfile = findViewById(R.id.imageViewProfile);

        // Set click listener for "Edit Profile" button
        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PROFILE.this, Profile_info.class);
                startActivity(intent);
            }
        });
    }

}
