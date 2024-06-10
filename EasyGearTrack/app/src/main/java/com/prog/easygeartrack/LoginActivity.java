package com.prog.easygeartrack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);

        buttonLogin.setOnClickListener(view -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (validateInputs(username, password)) {
                progressBar.setVisibility(View.VISIBLE);
                checkAndLoginUser(username, password);
            }
        });
    }

    private boolean validateInputs(String username, String password) {
        if (username.isEmpty()) {
            editTextUsername.setError("Username is required");
            editTextUsername.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return false;
        }

        return true;
    }

    private void checkAndLoginUser(String username, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        if (sharedPreferences.contains(username)) {
            String storedPassword = sharedPreferences.getString(username, null);
            if (storedPassword != null && storedPassword.equals(password)) {
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            } else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
            }
        } else {
            progressBar.setVisibility(View.GONE);
            showUserNotFoundDialog();
        }
    }

    private void showUserNotFoundDialog() {
        new AlertDialog.Builder(this)
                .setTitle("User Not Found")
                .setMessage("This username is not registered. Please register first.")
                .setPositiveButton("OK", (dialog, which) -> {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                })
                .show();
    }
}
