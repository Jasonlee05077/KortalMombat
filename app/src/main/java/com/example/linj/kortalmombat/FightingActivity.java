package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;


public class FightingActivity extends AppCompatActivity {
    private boolean TwoFingersTapped;
    private boolean hitpercent;


    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);

        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_POINTER_DOWN:
                        TwoFingersTapped = true;
                        kick(YourFighter.getFighter(),ComputerFighter.getFighter());
                    case MotionEvent.ACTION_BUTTON_PRESS:
                        punch(YourFighter.getFighter(), ComputerFighter.getFighter());

                }
                return true;
            }
        });

    while(YourFighter.getFighter().getHp()>0|| ComputerFighter.getFighter().getHp()>0){

        kick(ComputerFighter.getFighter(), YourFighter.getFighter());
        try {
            Thread.sleep(500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
        if(YourFighter.getFighter().getHp() <= 0){
            startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
        }
        else if(ComputerFighter.getFighter().getHp() <= 0){
            startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

        }




    }
    public void kick(Fighter attacker, Fighter defenser){
        int block = defenser.getDefense()/2;
        if (attacker.getSpecial() + attacker.getAttack() >= 21) {
            int place = random.nextInt(100);
            if (place > 10) {
                defenser.setHp(defenser.getHp() - (attacker.getSpecial()+attacker.getAttack()- block ));
            }
        } else if (attacker.getSpecial() + attacker.getAttack() >= 10) {
            int place = random.nextInt(100);
            if (place > 25) {
                defenser.setHp(defenser.getHp() - (attacker.getSpecial()+attacker.getAttack()- block ));
            }
        } else if (attacker.getSpecial() + attacker.getAttack() < 10) {
            int place = random.nextInt(100);
            if (place > 50) {
                defenser.setHp(defenser.getHp() - (attacker.getSpecial()+attacker.getAttack()- block ));
            }
        }
    }
    public void punch(Fighter attacker, Fighter defender) {
        if (attacker.getAttack() >= 20) {
            int place = random.nextInt(100);
            if (place > 10) {
                defender.setHp(defender.getHp()- attacker.getAttack());
            }
        } else if (attacker.getAttack() >= 10) {
            int place = random.nextInt(100);
            if (place > 25) {
                defender.setHp(defender.getHp()- attacker.getAttack());
            }
        } else if (attacker.getAttack() < 10) {
            int place = random.nextInt(100);
            if (place > 50) {
                defender.setHp(defender.getHp() - attacker.getAttack());
            }
        }
    }
}







