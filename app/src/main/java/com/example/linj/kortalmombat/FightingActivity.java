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
    private static int userSpecial;
    private static int compAttack;
    private static int compDefense;
    private static int compSpecial;
    private static boolean compBlock = false;
    private static boolean userBlock=false;
    private static Random rand = new Random();
    private static Random  random = new Random();
    private static String[] chances = new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);
        TextView YourHP = ((TextView) findViewById(R.id.textView7));
        TextView CompHP = ((TextView) findViewById(R.id.textView10));
        userHP = YourFighter.defense*10 + 500;
        aiHP = ComputerFighter.defense*10 +500;

        for(int i = 0 ; i < ComputerFighter.defensechance;i++){
            chances[i] = "block";

        }
        for(int i = ComputerFighter.defensechance ; i < ComputerFighter.defensechance+ComputerFighter.attackchance ;i++){
            chances[i] = "attack";

        }
        for(int i = ComputerFighter.defensechance+ComputerFighter.attackchance ; i < ComputerFighter.defensechance+ComputerFighter.attackchance+ComputerFighter.special ;i++){
            chances[i] = "kick";

        }

        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.myLayout);

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {


                int action = motionEvent.getAction();
                switch (action & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_POINTER_DOWN:
                        TwoFingersTapped = true;
                        TextView YourHP = ((TextView) findViewById(R.id.textView7));
                        TextView CompHP = ((TextView) findViewById(R.id.textView10));
                        int move = rand.nextInt(100);
                        if(chances[move].equals("block")){
                            computerBlock();
                            userKick();
                            computerBlock();
                        }
                        else if (chances[move].equals("punch")){
                            userKick();
                            compPunch();
                        }
                        else if (chances[move].equals("kick")){
                            userKick();
                            compKick();
                        }

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
                        move = rand.nextInt(100);
                        if(chances[move].equals("block")){
                            computerBlock();
                            userPunch();
                            computerBlock();
                        }
                        else if (chances[move].equals("punch")){
                            userPunch();
                            compPunch();
                        }
                        else if (chances[move].equals("kick")){
                            userPunch();
                            compKick();
                        }

                        yourHP = ""+userHP;
                        YourHP.setText(yourHP);
                        compHP =""+aiHP;
                        CompHP.setText(compHP);

                        if (aiHP <= 0) {
                            startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
                        } else if (userHP <= 0) {
                            startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

                        }
                        case MotionEvent.ACTION_SCROLL:
                            YourHP = ((TextView) findViewById(R.id.textView7));
                            CompHP = ((TextView) findViewById(R.id.textView10));
                            move = rand.nextInt(100);
                            if(chances[move].equals("block")){
                                computerBlock();
                                userBlock();
                                computerBlock();
                                userBlock();
                            }
                            else if (chances[move].equals("punch")){
                                userBlock();
                                compPunch();
                            }
                            else if (chances[move].equals("kick")){
                                userBlock();
                                compKick();
                            }

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
    public static void compKick(){
        int blockDamage = 0;
        if (userBlock == true){
            blockDamage = ComputerFighter.defense;
        }


        if (ComputerFighter.attack + ComputerFighter.special >= 40) {
            int place = random.nextInt(100);
            if (place > 10) {
                userHP = userHP - (ComputerFighter.attack + ComputerFighter.special - blockDamage );
            }
        } else if (ComputerFighter.attack + ComputerFighter.special >= 20) {
            int place = random.nextInt(100);
            if (place > 25) {
                userHP = userHP - (ComputerFighter.attack + ComputerFighter.special - blockDamage );
            }
        } else if (ComputerFighter.attack + ComputerFighter.special< 20) {
            int place = random.nextInt(100);
            if (place > 50) {
                userHP = userHP - (ComputerFighter.attack + ComputerFighter.special - blockDamage );
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
    public static void compPunch() {

        if (ComputerFighter.attack >= 20) {
            int place = random.nextInt(100);
            if (place > 10) {
                userHP=userHP-ComputerFighter.attack ;
            }
        } else if ( ComputerFighter.attack>= 10) {
            int place = random.nextInt(100);
            if (place > 25) {
                userHP=userHP-ComputerFighter.attack ;
            }
        } else if (ComputerFighter.attack< 10) {
            int place = random.nextInt(100);
            if (place > 50) {
                userHP=userHP-ComputerFighter.attack ;
            }
        }
    }
    public static void computerBlock(){

        compBlock = !compBlock;

    }
    public static void userBlock(){
        userBlock=!userBlock;
    }
}







