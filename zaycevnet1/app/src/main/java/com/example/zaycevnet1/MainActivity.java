package com.example.zaycevnet1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        i++;
        outState.putInt("count", i);


    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        i = savedInstanceState.getInt("count");

        if (i==3){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "не особо понял как это вообще возможно посчитать количество холодных стартов", Toast.LENGTH_SHORT);
            toast.show();
            i=0;
        }

    }
}
