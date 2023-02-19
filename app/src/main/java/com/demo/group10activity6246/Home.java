package com.demo.group10activity6246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView Status;
    Button Logout;
    public static final String mypreference = "Cred_Pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Status = findViewById(R.id.tvStatus);
        Logout = findViewById(R.id.btnLogout);

        SharedPreferences sharedPreferences = getSharedPreferences(mypreference, MODE_PRIVATE);
        String display = sharedPreferences.getString("display", "");

        Status.setText(display);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}