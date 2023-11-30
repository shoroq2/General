package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytest.R;

public class MainActivity extends AppCompatActivity {
private Button bt2;
private Button bt1;
private Button bt3;
    public MainActivity() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt2=(Button) bt2.findViewById(R.id.bt2);
        bt1=(Button) bt1.findViewById(R.id.bt1);
        bt3=(Button) bt3.findViewById(R.id.bt3);

        bt1.setOnClickListener(new View.OnClickListener() { //admin button action
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class) ;
            startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() { //user button action
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity3.class) ;
                startActivity(intent);
            }
        });
        //exit button action
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Close the app by finish method
                finish();
        }

    });
}
}