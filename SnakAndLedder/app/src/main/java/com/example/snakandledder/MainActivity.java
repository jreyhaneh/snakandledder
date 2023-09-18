package com.example.snakandledder;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

  private Button snakeStart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snakeStart1 = (Button) findViewById(R.id.snakeStart1);


        snakeStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SnakL.class);
                startActivity(intent);

            }
        });

    }}

