package com.demo.group10activity6246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText Name, Password, DateOfBirth, Country, PhoneNumber, Address, Email;
    Button Register, Cancel;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "Cred_Pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etRegPassword);
        DateOfBirth = findViewById(R.id.etDOB);
        Country = findViewById(R.id.etCountry);
        PhoneNumber = findViewById(R.id.etPhoneNumber);
        Address = findViewById(R.id.etAddress);
        Email = findViewById(R.id.etRegEmail);
        Register = findViewById(R.id.btnSaveRegister);
        Cancel = findViewById(R.id.btnCancel);

        sharedPreferences = getSharedPreferences(mypreference, MODE_PRIVATE);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String password = Password.getText().toString();
                String dateofbirth = DateOfBirth.getText().toString();
                String country = Country.getText().toString();
                String phonenumber = PhoneNumber.getText().toString();
                String address = Address.getText().toString();
                String email = Email.getText().toString();

                sharedPreferences = getSharedPreferences(mypreference, MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name);
                editor.putString("Password", password);
                editor.putString("DateOfBirth", dateofbirth);
                editor.putString("Country", country);
                editor.putString("PhoneNumber", phonenumber);
                editor.putString("Address", address);
                editor.putString("Email", email);
                editor.putString(email + password + "data", "Welcome Home\n" + name);
                editor.apply();

                Toast.makeText(Register.this, "Information Saved!", Toast.LENGTH_SHORT).show();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name.setText("");
                Password.setText("");
                DateOfBirth.setText("");
                Country.setText("");
                PhoneNumber.setText("");
                Address.setText("");
                Email.setText("");
            }
        });
    }
}