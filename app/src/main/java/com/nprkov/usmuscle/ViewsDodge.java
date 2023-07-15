package com.nprkov.usmuscle;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewsDodge extends AppCompatActivity {

    private EditText editTextFirstName, editTextLastName, editTextEmail;
    private Button buttonSubmit;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodge_views);

        // Initialize Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");

        // Initialize Views
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Handle submit button click
        buttonSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });
    }

    private void saveUserData() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        // Validate the fields
        if (TextUtils.isEmpty(firstName)) {
            editTextFirstName.setError("Please enter first name");
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            editTextLastName.setError("Please enter last name");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter email");
            return;
        }

        // Create a new user object
        User user = new User(firstName, lastName, email);

        // Push the user data to Firebase
        databaseReference.push().setValue(user);

        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }
}
