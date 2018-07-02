package com.example.kenedi.nicolsrestaruant.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kenedi.nicolsrestaruant.R;

public class presetacion2 extends AppCompatActivity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presetacion2);
        siguiente=findViewById(R.id.btn1);


    }

    public void siguiente(View view ){
        Intent intent = new Intent(presetacion2.this, presentacion3.class);
        startActivity(intent);
        finish();
    }
}
