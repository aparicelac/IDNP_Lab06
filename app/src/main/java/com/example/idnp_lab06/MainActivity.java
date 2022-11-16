package com.example.idnp_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gBarras = (Button) findViewById(R.id.botonBarras);
        Button gCircular = (Button) findViewById(R.id.botonCircular);

        gBarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GraficoBarras.class);
                startActivity(intent);
            }
        });

        gCircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GraficoCircular.class);
                startActivity(intent);
            }
        });
    }
}