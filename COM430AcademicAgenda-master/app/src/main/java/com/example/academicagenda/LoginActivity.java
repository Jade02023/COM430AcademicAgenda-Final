package com.example.academicagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;
    private Button forgotPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // calling layout file named "activity_login.xml"

        // Initialize UI elements
        usernameEditText = findViewById(R.id.editTextUsername); //EditText with id "editTextUsername" 
        passwordEditText = findViewById(R.id.editTextPassword); //EditText with id "editTextPassword" 
        loginButton = findViewById(R.id.buttonLogin); //Button with id "buttonLogin"
        registerButton = findViewById(R.id.buttonRegister); //Button with id "buttonRegister"
        forgotPasswordButton = findViewById(R.id.buttonForgotPassword); //Button with id "buttonForgotPassword" 

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Login information logic 
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check both username and password are not empty
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Successful login, navigate to the main activity or another appropriate screen
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the LoginActivity to prevent going back to it
                } else {
                    // Display an error message for invalid login credentials
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Registration logic
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the forgot password button
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Password recovery logic
                // Navigate to a password recovery dialog
                Toast.makeText(LoginActivity.this, "Password recovery!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
