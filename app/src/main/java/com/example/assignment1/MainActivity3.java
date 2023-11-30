package com.example.assignment1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytest.R;
import com.google.gson.Gson;

public class MainActivity3 extends AppCompatActivity {
    private Spinner spinner;
    private EditText resultText;
    private Button searchButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner = findViewById(R.id.spinner);
        resultText = findViewById(R.id.text3);
        searchButton = findViewById(R.id.searchbutton);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("pharmacyDetails", Context.MODE_PRIVATE);

        String[] pharmacyItems = {"Capsules", "Suppositories", "Drops", "Inhalers", "Injections", "Tablet"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pharmacyItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
//search button action
        searchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Get the selected item from the spinner
                String selectedPharmacyItem = spinner.getSelectedItem().toString();

                // Retrieve JSON string from SharedPreferences
                String json = sharedPreferences.getString(selectedPharmacyItem, "");

                // Convert JSON string to PharmacyItem using Gson
                pharmacy pharmacyItem = new Gson().fromJson(json, pharmacy.class);

                if (pharmacyItem != null) {
                    // Display the details in the resultText EditText
                    resultText.setText("Description: " + pharmacyItem.getDescription() + "\nDate: " + pharmacyItem.getDueDate());
                } else {
                    resultText.setText("No data found for " + selectedPharmacyItem);
                }
            }
        });
    }
    // Method to save data using Gson
    private void saveDataWithGson(String key, pharmacy pharmacyItem) {
        // Convert PharmacyItem to JSON string using Gson
        String json = new Gson().toJson(pharmacyItem);
        // Save JSON string in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }
}