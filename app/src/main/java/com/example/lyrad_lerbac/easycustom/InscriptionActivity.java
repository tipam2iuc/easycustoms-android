package com.example.lyrad_lerbac.easycustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InscriptionActivity extends AppCompatActivity {

    Button mButton;
    Button mButton_retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        mButton_retour = findViewById(R.id.button_connexion_retour_inscription);
        mButton = findViewById(R.id.button_valider_inscription);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InscriptionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mButton_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InscriptionActivity.this,ConnexionActivity.class);
                startActivity(intent);
            }
        });
    }
}
