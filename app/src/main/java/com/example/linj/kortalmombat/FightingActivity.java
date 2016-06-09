package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;


public class FightingActivity extends AppCompatActivity {
    private boolean TwoFingersTapped;
    private boolean hitpercent;
    private static Fighter yourFighter = new Fighter(YourFighter.special,YourFighter.defense,YourFighter.attack, YourFighter.title,YourFighter.password);
    private static Fighter compFighter = new Fighter(ComputerFighter.special, ComputerFighter.defense,ComputerFighter.attack,ComputerFighter.title,ComputerFighter.password);

    private static Random  random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);

        EditText YourHP = ((EditText) findViewById(R.id.editText14));
        EditText CompHP = ((EditText) findViewById(R.id.editText15));

        int compHP = compFighter.getHp();
        String compHP2 =""+compHP;
        CompHP.setText(compHP2);
        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {


                int action = motionEvent.getAction();
                switch (action & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_POINTER_DOWN:
                        TwoFingersTapped = true;
                        kick(yourFighter,compFighter);


                    case MotionEvent.ACTION_BUTTON_PRESS:
                        punch(yourFighter, compFighter);

                    case MotionEvent.ACTION_SCROLL:
                        block(yourFighter, compFighter);
                }
                return true;
            }
        });


        if (yourFighter.getHp() <= 0) {
            startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
        } else if (compFighter.getHp() <= 0) {
            startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

        }



    }
   /*protected static void Fight() {
        while (yourFighter.getHp() > 0 || compFighter.getHp() > 0) {

            kick(compFighter, yourFighter);
            /*try {
                Thread.sleep(500);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }

    }*/
    public static void kick(Fighter attacker, Fighter defenser){
        int block = defenser.getDefense()/2;
        if (attacker.getSpecial() + attacker.getAttack() >= 21) {
            int place = random.nextInt(100);
            if (place > 10) {
                defenser.setHp(defenser.getHp() - (attacker.getSpecial()+attacker.getAttack()  ));
            }
        } else if (attacker.getSpecial() + attacker.getAttack() >= 10) {
            int place = random.nextInt(100);
            if (place > 25) {
                defenser.setHp(defenser.getHp() - (attacker.getSpecial()+attacker.getAttack()  ));
            }
        } else if (attacker.getSpecial() + attacker.getAttack() < 10) {
            int place = random.nextInt(100);
            if (place > 50) {
                defenser.setHp(defenser.getHp() - (attacker.getSpecial()+attacker.getAttack()  ));
            }
        }
    }
    public static void punch(Fighter attacker, Fighter defender) {
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
    public static void block(Fighter attacker, Fighter defender) {
        if (defender.getDefense() >= 20) {
            int place = random.nextInt(100);
            if (place < 10) {
                defender.setHp(defender.getHp()- attacker.getAttack());
            }
        }
       else if (defender.getDefense() >= 15) {
            int place = random.nextInt(100);
            if (place < 20) {
                defender.setHp(defender.getHp()- attacker.getAttack());
            }
        }
       else if (defender.getDefense() >= 10) {
            int place= random.nextInt(100);
            if (place < 35) {
                defender.setHp(defender.getHp()- attacker.getAttack());
            }
        }
    }
}







