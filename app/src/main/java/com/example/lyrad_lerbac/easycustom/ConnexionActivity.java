package com.example.lyrad_lerbac.easycustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConnexionActivity extends AppCompatActivity {

    TextView mTextView;
    Button mConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        mTextView = (TextView) findViewById(R.id.textView_inscription);
        mConnexion=(Button)findViewById(R.id.button_valider);
        mConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnexionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnexionActivity.this,InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
