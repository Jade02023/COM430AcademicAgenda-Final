package com.example.academicagenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.academicagenda.databinding.ActivityPasswordRecoveryBinding;
import com.google.android.material.snackbar.Snackbar;

public class PasswordRecoveryActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button recoverPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery); // Create a layout file named "activity_password_recovery.xml"

        // Initialize UI elements
        emailEditText = findViewById(R.id.editTextEmail); //Button with id "editTextEmail"
        recoverPasswordButton = findViewById(R.id.buttonRecoverPassword); // Button with id "buttonRecoverPassword" 

        // Set click listener for the recover password button
        recoverPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    

            }
        });
    }


    private AppBarConfiguration appBarConfiguration;
    private ActivityPasswordRecoveryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPasswordRecoveryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_password_recovery);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Recover Password", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_password_recovery);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
