package com.example.napoleon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    Intent intent;
    Context context;
    int counter;
    SharedPreferences storage;
    private String TAG = "Жизненный цикл";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_splash);
        storage = getSharedPreferences("storageKey", MODE_PRIVATE);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("savedCounter", 0);
        } else {
            counter = storage.getInt("savedCounter", 0);
        }
        if (counter == 3) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "не особо понял как это вообще возможно посчитать количество холодных стартов", Toast.LENGTH_SHORT);
            toast.show();

        }
        if(counter==4) counter = 1;
        initViews();


    }

    private void initViews() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                intent = new Intent(context,MainActivity.class);
                intent.putExtra("number",counter);
                startActivity(intent);
                finish();
            }
        },1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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