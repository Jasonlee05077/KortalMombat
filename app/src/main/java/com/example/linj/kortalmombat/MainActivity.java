package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private int special = ((EditText) findViewById(R.id.editText);
    private int attack = ((EditText) findViewById(R.id.editText2);;
    private int defense = ((EditText) findViewById(R.id.editText3);;
    private Button continue_button = (Button) findViewById(R.id.button);
    private Button button_click = (Button) findViewById(R.id.button);
    private int totalPoints = special + attack + defense;

    public void finished_char(int totalPoints){
        if (totalPoints != 30){
           System.out.println("Please use 30 points");
        }
        else {startActivity(new Intent(MainActivity.this,FightingActivity.class));}

    }

    button_click.setOnClickListener(new View.OnClickListener(){
        finished_char(totalPoints);
    }
}

