package com.example.linj.kortalmombat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int special = editText;
    private int attack = editText2;
    private int defense = editText3;
    private int totalPoints = special + attack + defense;

    public boolean finished_char(int totalPoints){
        if (totalPoints != 30){
           return button.setEnabled(false);
        }
        else {return button.setEnabled(true);}

    }

}

