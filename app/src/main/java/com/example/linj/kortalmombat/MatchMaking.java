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
                int special =0;
                int attack =0;
                int defense =0;
                for (int i =0; i<30 ;i++){
                    int k = rand.nextInt(2);
                    if (k==0){
                        special++;
                    }
                    else if(k==1){
                        attack++;
                    }
                    else if (k==2){
                        defense++;
                    }
                }
                ComputerFighter.special=special;
                ComputerFighter.defense=defense;
                ComputerFighter.attack=attack;
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

        Button setAI = (Button)findViewById(R.id.button4);
        setAI.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



                startActivity(new Intent(MatchMaking.this, Main3Activity.class));


            }
        });




    }
}
