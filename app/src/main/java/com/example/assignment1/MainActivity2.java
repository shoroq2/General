package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mytest.R;

import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView nameTextView, dateTextView, descriptionTextView, listResultTextView;
    private EditText nameEditText, dateEditText, descriptionEditText;
    private Button addButton, showListButton;
    private ListView listView;
    private ArrayList<String> medicineList;
    private ArrayAdapter<String> adapter;
    private Button deleteButton;

    public MainActivity2() {
    }

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameTextView = findViewById(R.id.name);
        dateTextView = findViewById(R.id.date);
        descriptionTextView = findViewById(R.id.Description);
        listResultTextView = findViewById(R.id.Listresult);
        nameEditText = findViewById(R.id.nametxt);
        dateEditText = findViewById(R.id.datetxt);
        descriptionEditText = findViewById(R.id.Descriptiontxt);
        addButton = findViewById(R.id.bt21);
        showListButton = findViewById(R.id.resultbutton);
        listView = findViewById(R.id.listView);
        medicineList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicineList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get data from the EditText fields
                String name = nameEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                // Add the medicine data to the list
                String medicineData = "Name: " + name + "\nDate: " + date + "\nDescription: " + description;
                medicineList.add(medicineData);
                adapter.notifyDataSetChanged();
                //clear the editText
                nameEditText.setText("");
                dateEditText.setText("");
                descriptionEditText.setText("");
            }
        });
        deleteButton = findViewById(R.id.bt22);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get data from the EditText fields
                String nameToDelete = nameEditText.getText().toString();
                String dateToDelete = dateEditText.getText().toString();
                String descriptionToDelete = descriptionEditText.getText().toString();
                String itemToDelete = "Name: " + nameToDelete + "\nDate: " + dateToDelete + "\nDescription: " + descriptionToDelete;

                // Check if the item exists in the medicineList
                if (medicineList.contains(itemToDelete)) {
                    // Remove the item from the list
                    medicineList.remove(itemToDelete);
                    adapter.notifyDataSetChanged();

                    // Clear the EditText fields
                    nameEditText.setText("");
                    dateEditText.setText("");
                    descriptionEditText.setText("");

                    Toast.makeText(MainActivity2.this, "Medicine deleted from the list", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "Medicine not found in the list", Toast.LENGTH_SHORT).show();
                }
            }
        });
        showListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (medicineList.isEmpty()) {
                    // Display a message if the list is empty
                    listResultTextView.setText("No data in the list. Try adding medicines.");
                } else {
                    // Display the medicine list in the TextView
                    listResultTextView.setText("Medicine List:\n" + String.join("\n\n", medicineList));
            }
            }
        });

    }
}