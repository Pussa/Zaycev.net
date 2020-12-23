package com.example.napoleon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextView Entries_number;
    int counter;
    SharedPreferences storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Entries_number = findViewById(R.id.entries_number);
        storage = getSharedPreferences("storageKey", MODE_PRIVATE);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("savedCounter",0);
        } else {
            counter = storage.getInt("savedCounter",0);
        }
        Entries_number.setText(String.valueOf(counter));
        if (counter==3) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "не особо понял как это вообще возможно посчитать количество холодных стартов", Toast.LENGTH_SHORT);
            toast.show();
            counter = 0;
        }


    }
    @Override
    protected void onStop() {
        super.onStop();
        counter += 1;
        storage = getSharedPreferences("storageKey", MODE_PRIVATE);
        storage.edit().putInt("savedCounter", counter).apply();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("savedCounter", counter);
    }
}





