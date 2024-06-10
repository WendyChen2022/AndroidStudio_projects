package com.prog.easygeartrack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements GearAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private GearAdapter gearAdapter;
    private List<GearItem> gearItemList;
    private Button buttonLogout;
    private Button buttonAddGear;
    private static final int ADD_GEAR_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();
        loadGearList();
        setupRecyclerView();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewGearCatalog);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonAddGear = findViewById(R.id.buttonAddGear);

        buttonLogout.setOnClickListener(view -> logout());
        buttonAddGear.setOnClickListener(view -> addGear());
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        gearAdapter = new GearAdapter(gearItemList);
        recyclerView.setAdapter(gearAdapter);
        gearAdapter.setOnItemClickListener(this);
    }

    private void loadGearList() {
        gearItemList = SharedPrefsUtils.loadGearList(this);
        if (gearItemList == null) {
            gearItemList = new ArrayList<>();
        }
    }

    private void saveGearList() {
        SharedPrefsUtils.saveGearList(this, gearItemList);
    }

    private void logout() {
        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void addGear() {
        Intent intent = new Intent(DashboardActivity.this, AddGearActivity.class);
        startActivityForResult(intent, ADD_GEAR_REQUEST_CODE);
    }

    @Override
    public void onDeleteClick(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Gear")
                .setMessage("Are you sure you want to delete this gear?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    gearItemList.remove(position);
                    gearAdapter.notifyItemRemoved(position);
                    Toast.makeText(DashboardActivity.this, "Gear deleted", Toast.LENGTH_SHORT).show();
                    saveGearList();  // Save list after deleting item
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_GEAR_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            GearItem newGearItem = (GearItem) data.getSerializableExtra(AddGearActivity.EXTRA_NEW_GEAR_ITEM);
            if (newGearItem != null) {
                gearItemList.add(newGearItem);
                gearAdapter.notifyDataSetChanged(); // Notify adapter that data has changed
                saveGearList();  // Save list after adding item
            }
        }
    }
}
