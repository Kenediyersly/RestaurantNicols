package com.example.kenedi.nicolsrestaruant.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.kenedi.nicolsrestaruant.R;

import java.util.ArrayList;
import java.util.List;

public class presentacion extends AppCompatActivity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        siguiente=findViewById(R.id.btn1);


    }

    public void siguiente(View view ){
        Intent intent = new Intent(presentacion.this, presetacion2.class);
        startActivity(intent);
        finish();
    }
}
