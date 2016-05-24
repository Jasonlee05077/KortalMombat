package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MatchMaking extends AppCompatActivity {


    private Random rand = new Random();
    private static int totalStat = YourFighter.getFighter().getAttack()+YourFighter.getFighter().getSpecial()+YourFighter.getFighter().getDefense();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_making);
        Button generateFighter = (Button)findViewById(R.id.button6);

        generateFighter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int computerTotalStats = 0;
                ComputerFighter.getFighter().setAttack(0);
                ComputerFighter.getFighter().setDefense(0);
                ComputerFighter.getFighter().setSpecial(0);
                for(int i = 0 ; i < totalStat ; i++){
                    int randomNumber = rand.nextInt(2);
                    if (randomNumber == 0){
                        ComputerFighter.getFighter().gainAttackByOne();
                    }
                    else if (randomNumber == 1){
                        ComputerFighter.getFighter().gainDefenseByOne();
                    }
                    else if (randomNumber == 2){
                        ComputerFighter.getFighter().gainSpecialByOne();
                    }


                }
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
                for()
            }
        });




    }
}
