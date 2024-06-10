package com.prog.easygeartrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.prog.easygeartrack.Constants;


public class EditGearActivity extends AppCompatActivity {

    private EditText editTextGearName;
    private EditText editTextGearCategory;
    private EditText editTextGearCondition;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gear);

        // Initialize views
        editTextGearName = findViewById(R.id.editTextGearName);
        editTextGearCategory = findViewById(R.id.editTextGearCategory);
        editTextGearCondition = findViewById(R.id.editTextGearCondition);
        saveButton = findViewById(R.id.buttonSaveGear);

        // Retrieve gear item details from Intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString(Constants.EXTRA_EDIT_GEAR_NAME);
            String category = extras.getString(Constants.EXTRA_EDIT_GEAR_CATEGORY);
            String condition = extras.getString(Constants.EXTRA_EDIT_GEAR_CONDITION);

            editTextGearName.setText(name);
            editTextGearCategory.setText(category);
            editTextGearCondition.setText(condition);
        }

        // Set click listener for the Save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get updated gear information
                String gearName = editTextGearName.getText().toString();
                String gearCategory = editTextGearCategory.getText().toString();
                String gearCondition = editTextGearCondition.getText().toString();

                // Create a new gear item with updated information
                GearItem updatedGearItem = new GearItem(gearName, gearCategory, gearCondition);

                // Return the updated gear item to the calling activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra(Constants.EXTRA_UPDATED_GEAR_ITEM, updatedGearItem);
                setResult(RESULT_OK, resultIntent);

                // Finish the current activity
                finish();
            }
        });
    }
}
