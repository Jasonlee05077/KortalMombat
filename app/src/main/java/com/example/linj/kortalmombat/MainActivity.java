package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        Button continueButton = (Button) findViewById(R.id.button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText specialText = ((EditText) findViewById(R.id.editText2));
                String specialString = specialText.getText().toString();
                final int special = Integer.parseInt(specialString);
                EditText attackText = ((EditText) findViewById(R.id.editText));
                String attackString = attackText.getText().toString();
                final int attack = Integer.parseInt(attackString);
                EditText defenseText = ((EditText) findViewById(R.id.editText3));
                String defenseString = defenseText.getText().toString();
                final int defense = Integer.parseInt(defenseString);
                int totalPoints = special + attack + defense;
                EditText nameText = ((EditText) findViewById(R.id.editText4));
                String name = nameText.getText().toString();
                EditText passwordText = ((EditText) findViewById(R.id.editText5));
                String password = passwordText.getText().toString();
                if (totalPoints != 30)
                {System.out.println("Please use 30 points");
                } else {
                    int uniqueID = (int) Math.random();
                    Fighter fighter = new Fighter(special, defense, attack, name, password);
                    Cloud.fighterUpload(fighter);
                    YourFighter.setFighter(fighter);
                    FighterNamesPassword.namesAndPasswords.add(name+" "+password);
                    startActivity(new Intent(MainActivity.this, MatchMaking.class));

                }
            }
        });


        Button LoginButton = (Button)findViewById(R.id.button2);
        LoginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });


    }



}

