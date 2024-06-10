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

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private Button buttonRegister;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonRegister = findViewById(R.id.buttonRegister);
        progressBar = findViewById(R.id.progressBar);

        buttonRegister.setOnClickListener(view -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();

            if (validateInputs(username, password, email)) {
                progressBar.setVisibility(View.VISIBLE);
                checkAndRegisterUser(username, password, email);
            }
        });
    }

    private boolean validateInputs(String username, String password, String email) {
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

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return false;
        }

        return true;
    }

    private void checkAndRegisterUser(String username, String password, String email) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        if (sharedPreferences.contains(username)) {
            progressBar.setVisibility(View.GONE);
            showUserExistsDialog();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(username, password); // 保存用户名和密码
            editor.apply();

            progressBar.setVisibility(View.GONE);
            Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void showUserExistsDialog() {
        new AlertDialog.Builder(this)
                .setTitle("User Already Exists")
                .setMessage("This username is already registered. Please use a different username.")
                .setPositiveButton("OK", (dialog, which) -> {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                })
                .show();
    }
}
