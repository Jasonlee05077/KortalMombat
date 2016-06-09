package com.example.linj.kortalmombat;

import android.content.Intent;
import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;


public class FightingActivity extends AppCompatActivity {
    private boolean TwoFingersTapped;
    private boolean hitpercent;
    private static int userHP = YourFighter.defense*10 + 500;
    private static int aiHP = ComputerFighter.defense*10+ 500;
    private Timer timer;
    private TimerTask timerTask;
    private static Random random = new Random();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);

            TextView YourHP = ((TextView) findViewById(R.id.textView7));
            TextView CompHP = ((TextView) findViewById(R.id.textView10));





        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.myLayout);
            myLayout.setOnTouchListener(new View.OnTouchListener() {


                public boolean onTouch(View view, MotionEvent motionEvent) {


                    int action = motionEvent.getAction();
                    switch (action & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_POINTER_DOWN:
                            TwoFingersTapped = true;
                            userKick();
                            TextView YourHP = ((TextView) findViewById(R.id.textView7));
                            TextView CompHP = ((TextView) findViewById(R.id.textView10));
                            String yourCurrentHP = ""+userHP;
                            String compCurrentHP=""+aiHP;
                            YourHP.setText(yourCurrentHP);
                            CompHP.setText(compCurrentHP);
                            if (aiHP <= 0) {
                                startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
                            } else if (userHP <= 0) {
                                startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

                            }

                            TwoFingersTapped = false;
                            userPunch();
                             YourHP = ((TextView) findViewById(R.id.textView7));
                             CompHP = ((TextView) findViewById(R.id.textView10));
                             yourCurrentHP = ""+userHP;
                             compCurrentHP=""+aiHP;
                            YourHP.setText(yourCurrentHP);
                            CompHP.setText(compCurrentHP);
                            if (aiHP <= 0) {
                                startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
                            } else if (userHP <= 0) {
                                startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

                            }

                    }
                    return true;
                }


            });


            if (userHP <= 0) {
                startActivity(new Intent(FightingActivity.this, VictoryActivity.class));
            } else if (aiHP <= 0) {
                startActivity(new Intent(FightingActivity.this, DefeatActivity.class));

            }


        }



    public static void userKick() {


        if (YourFighter.special + YourFighter.attack >= 40) {
            int place = random.nextInt(100);
            if (place > 10) {
                aiHP = aiHP - (YourFighter.special + YourFighter.attack) ;
            }
        } else if (YourFighter.special + YourFighter.attack>= 20) {
            int place = random.nextInt(100);
            if (place > 25) {
                aiHP = aiHP - (YourFighter.special + YourFighter.attack) ;
            }
        } else if (YourFighter.special + YourFighter.attack < 20) {
            int place = random.nextInt(100);
            if (place > 50) {
                aiHP = aiHP - (YourFighter.special + YourFighter.attack) ;;
            }
        }

    }

    public static void userPunch() {
        if (YourFighter.attack >= 20) {
            int place = random.nextInt(100);
            if (place > 10) {
                aiHP = aiHP - YourFighter.attack;
            }
        } else if (YourFighter.attack >= 10) {
            int place = random.nextInt(100);
            if (place > 25) {
                aiHP = aiHP - YourFighter.attack;
            }
        } else if (YourFighter.attack < 10) {
            int place = random.nextInt(100);
            if (place > 50) {
                aiHP = aiHP - YourFighter.attack;
            }
        }

    }

}







