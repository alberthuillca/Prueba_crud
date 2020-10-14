package com.example.prueba_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_new;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_new = findViewById(R.id.btn_2);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(view.getContext(), ProductoActivity.class);
                startActivityForResult(int2, 0);
            }
        });

    }

    public void onclick_pro(View view) {
        Intent int2 = new Intent(this, ProductoActivity.class);
        startActivity(int2);
    }
}