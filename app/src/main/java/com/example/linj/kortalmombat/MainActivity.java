package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button continueButton = (Button) findViewById(R.id.button);
        Button.OnClickListener(new View.OnClickListener){
            public void onClick(View v){
                EditText specialText = ((EditText) findViewById(R.id.editText));
                String specialString = specialText.getText().toString();
                final int special = Integer.parseInt(specialString);
                EditText attackText = ((EditText) findViewById(R.id.editText2));
                String attackString = attackText.getText().toString();
                final int attack = Integer.parseInt(attackString);
                EditText defenseText = ((EditText) findViewById(R.id.editText3));
                String defenseString = defenseText.getText().toString();
                final int defense = Integer.parseInt(defenseString);
                int totalPoints = special + attack + defense;
                if (totalPoints != 30){
                    System.out.println("Please use 30 points");
                }
                else {startActivity(new Intent(MainActivity.this,FightingActivity.class));}

                }
            }

    }


}

