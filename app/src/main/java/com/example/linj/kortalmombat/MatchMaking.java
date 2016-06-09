package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MatchMaking extends AppCompatActivity {


    private Random rand = new Random();
    private static int totalStat = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_making);
        Button generateFighter = (Button)findViewById(R.id.button6);
        generateFighter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                startActivity(new Intent(MatchMaking.this, FightingActivity.class));

            }
        });
        Button specificFighter = (Button)findViewById(R.id.button7);
        specificFighter.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(MatchMaking.this, SpecificFighterActivity.class));


            }
        });

        Button findRandomFighter = (Button)findViewById(R.id.button3);

        findRandomFighter.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {


                startActivity(new Intent(MatchMaking.this, FightingActivity.class));


            }
        });
        Button test = (Button)findViewById(R.id.button8);

        test.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



                startActivity(new Intent(MatchMaking.this, Main2Activity.class));


            }
        });




    }
}
