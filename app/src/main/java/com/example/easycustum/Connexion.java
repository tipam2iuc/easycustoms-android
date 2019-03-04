package com.example.easycustum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Connexion extends AppCompatActivity  {
   EditText mTextUsername;
   EditText mPassword;
   TextView mRegister;
   Button mButton;
   db_user db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        db=new db_user(this);
        mTextUsername = (EditText) findViewById(R.id.editText4);
        mPassword= (EditText) findViewById(R.id.editText6);
        mRegister=(TextView) findViewById(R.id.register);
        mButton= (Button) findViewById(R.id.button2);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(Connexion.this, Inscription.class);
                startActivity(RegisterIntent);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=mTextUsername.getText().toString().trim();
                String pwd=mPassword.getText().toString().trim();
                Boolean res= db.checkUser(user,pwd);
                if(res==true) {
                    Toast.makeText(Connexion.this,"Reussi",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Connexion.this,"Erreur",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
