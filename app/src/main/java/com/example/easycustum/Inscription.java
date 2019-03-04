package com.example.easycustum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inscription extends AppCompatActivity{
EditText mEditText_user;
EditText mEditText_pwd;
EditText mEditText_confpwd;
Button mButton;
db_user db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        db =new db_user(this);
        mEditText_user= (EditText) findViewById(R.id.editText7);
        mEditText_pwd= (EditText) findViewById(R.id.editText8);
        mEditText_confpwd= (EditText) findViewById(R.id.editText9);
        mButton = (Button) findViewById(R.id.button3);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
                String user=mEditText_user.getText().toString().trim();
                String pwd= mEditText_pwd.getText().toString().trim();
                String cnf_pwd= mEditText_confpwd.getText().toString().trim();
                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val>0){
                        Toast.makeText(Inscription.this,"vous etes enregistrer",Toast.LENGTH_SHORT).show();
                        Intent backcon= new Intent(Inscription.this,Connexion.class);
                        startActivity(backcon);
                    }else{
                        Toast.makeText(Inscription.this,"Erreur d'enregistrement",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(Inscription.this,"Mot de passe incorrect",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

//    @Override
//    public void onClick(View v) {
//
//    }
}
