package com.prog.easygeartrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AddGearActivity extends AppCompatActivity {

    private EditText editTextGearName;
    private Spinner spinnerGearCategory;
    private EditText editTextGearCondition;
    private Button saveButton;

    public static final String EXTRA_NEW_GEAR_ITEM = "extra_new_gear_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gear);

        // Initialize views
        editTextGearName = findViewById(R.id.editTextGearName);
        spinnerGearCategory = findViewById(R.id.spinnerGearCategory);
        editTextGearCondition = findViewById(R.id.editTextGearCondition);
        saveButton = findViewById(R.id.buttonSaveGear);

        // Set click listener for the Save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get new gear information
                String gearName = editTextGearName.getText().toString();
                String gearCategory = spinnerGearCategory.getSelectedItem().toString();
                String gearCondition = editTextGearCondition.getText().toString();

                // Create a new gear item
                GearItem newGearItem = new GearItem(gearName, gearCategory, gearCondition);

                // Return the new gear item to the calling activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_NEW_GEAR_ITEM, newGearItem);
                setResult(RESULT_OK, resultIntent);

                // Finish the current activity
                finish();
            }
        });

        // Set up spinner with categories
        String[] categories = getResources().getStringArray(R.array.gear_categories);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGearCategory.setAdapter(spinnerAdapter);
    }
}