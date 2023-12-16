package com.example.academicagenda;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    public class RegistrationActivity extends AppCompatActivity {

        private EditText usernameEditText;
        private EditText passwordEditText;
        private Spinner securityQuestionSpinner;
        private EditText securityAnswerEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration); // Assuming you have a layout file named "activity_registration.xml"

            // Initialize UI elements
            usernameEditText = findViewById(R.id.editTextUsername); //  EditText with id "editTextUsername" 
            passwordEditText = findViewById(R.id.editTextPassword); // EditText with id "editTextPassword" 
            securityQuestionSpinner = findViewById(R.id.spinnerSecurityQuestion); // Spinner with id "spinnerSecurityQuestion"
            securityAnswerEditText = findViewById(R.id.editTextSecurityAnswer); // EditText with id "editTextSecurityAnswer" 
            Button registerButton = findViewById(R.id.buttonRegister); // Button with id "buttonRegister"

            // Set up the security question spinner with sample questions
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.security_questions,
                    android.R.layout.simple_spinner_item
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            securityQuestionSpinner.setAdapter(adapter);

            // Set click listener for the register button
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //registration logic
                    String username = usernameEditText.getText().toString().trim();
                    String password = passwordEditText.getText().toString().trim();
                    String selectedQuestion = securityQuestionSpinner.getSelectedItem().toString();
                    String securityAnswer = securityAnswerEditText.getText().toString().trim();

                    SharedPreferencesHelper.saveRegistrationInfo(
                            RegistrationActivity.this,
                            username,
                            password,
                            selectedQuestion,
                            securityAnswer
                    );
                    // registration is successful and navigate to the login screen
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Finish the RegistrationActivity
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
}
