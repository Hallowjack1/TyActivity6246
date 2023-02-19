package com.demo.group10activity6246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Email, Password;
    Button Login, Register;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "Cred_Pref";
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        Register = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(mypreference, MODE_PRIVATE);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = Password.getText().toString();
                String email = Email.getText().toString();

                sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

                String userDetails = sharedPreferences.getString(email + password + "data", "Unauthorized User");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("display", userDetails);
                editor.apply();

                i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
            }
        });
    }
}