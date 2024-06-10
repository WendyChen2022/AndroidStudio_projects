package com.prog.easygeartrack;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.prog.easygeartrack.Constants;
import com.prog.easygeartrack.GearItem;

public class ViewGearActivity extends AppCompatActivity {

    private TextView textViewGearName;
    private TextView textViewGearType;
    private TextView textViewGearCondition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gear);

        textViewGearName = findViewById(R.id.textViewGearName);
        textViewGearType = findViewById(R.id.textViewGearType);
        textViewGearCondition = findViewById(R.id.textViewGearCondition);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            GearItem gearItem = extras.getParcelable(Constants.EXTRA_VIEW_GEAR_ITEM);
            if (gearItem != null) {
                textViewGearName.setText(gearItem.getName());
                textViewGearType.setText(gearItem.getCategory());
                textViewGearCondition.setText(gearItem.getCondition());
            }
        }
    }
}
