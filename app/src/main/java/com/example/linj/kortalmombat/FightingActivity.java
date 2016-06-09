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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;


public class FightingActivity extends AppCompatActivity {
    private boolean TwoFingersTapped;
    private boolean hitpercent;
    private static int userHP = YourFighter.defense*10 + 500;
    private static int aiHP = ComputerFighter.defense*10 +500;
    private static int userAttack;
    private static int userDefense;

    private static int compAttack;
    private static int compDefense;
    private static int compSpecial;
    private static boolean compBlock = false;

    private static Random  random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);
        TextView YourHP = ((TextView) findViewById(R.id.textView7));
        TextView CompHP = ((TextView) findViewById(R.id.textView10));
        userHP = YourFighter.defense*10 + 500;
        aiHP = ComputerFighter.defense*10 +500;

        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.myLayout);

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {


                int action = motionEvent.getAction();
                switch (action & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_POINTER_DOWN:
                        TwoFingersTapped = true;
                        TextView YourHP = ((TextView) findViewById(R.id.textView7));
                        TextView CompHP = ((TextView) findViewById(R.id.textView10));
                        userKick();
                        String yourHP = ""+userHP;
                        YourHP.setText(yourHP);
                        String compHP =""+aiHP;
                        CompHP.setText(compHP);
                        if (aiHP <= 0) {
                            startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
                        } else if (userHP <= 0) {
                            startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

                        }

                    case MotionEvent.ACTION_DOWN:
                        ImageView whiteStance = (ImageView) findViewById(R.id.imageView);
                        whiteStance.setImageResource(R.mipmap.a_white_punch);
                        YourHP = ((TextView) findViewById(R.id.textView7));
                        CompHP = ((TextView) findViewById(R.id.textView10));
                        userPunch();
                        yourHP = ""+userHP;
                        YourHP.setText(yourHP);
                        compHP =""+aiHP;
                        CompHP.setText(compHP);

                        if (aiHP <= 0) {
                            startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
                        } else if (userHP <= 0) {
                            startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

                        }

                }
                return true;
            }
        });


        if (aiHP <= 0) {
            startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
        } else if (userHP <= 0) {
            startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

        }



    }

    public static void userKick(){
        int blockDamage = 0;
        if (compBlock == true){
            blockDamage = ComputerFighter.defense;
        }


        if (YourFighter.attack + YourFighter.special >= 40) {
            int place = random.nextInt(100);
            if (place > 10) {
                aiHP = aiHP - (YourFighter.attack + YourFighter.special - blockDamage );
            }
        } else if (YourFighter.attack + YourFighter.special >= 20) {
            int place = random.nextInt(100);
            if (place > 25) {
                aiHP = aiHP - (YourFighter.attack + YourFighter.special - blockDamage );
            }
        } else if (YourFighter.attack + YourFighter.special < 20) {
            int place = random.nextInt(100);
            if (place > 50) {
                aiHP = aiHP - (YourFighter.attack + YourFighter.special - blockDamage );
            }
        }
    }
    public static void userPunch() {

        if (YourFighter.attack >= 20) {
            int place = random.nextInt(100);
            if (place > 10) {
                aiHP=aiHP-YourFighter.attack ;
            }
        } else if ( YourFighter.attack>= 10) {
            int place = random.nextInt(100);
            if (place > 25) {
                aiHP=aiHP-YourFighter.attack ;
            }
        } else if (YourFighter.attack< 10) {
            int place = random.nextInt(100);
            if (place > 50) {
                aiHP=aiHP-YourFighter.attack;
            }
        }
    }
    public static void computerBlock(){

        compBlock = !compBlock;

    }
}







