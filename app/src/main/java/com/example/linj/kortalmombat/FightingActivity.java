package com.example.linj.kortalmombat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class FightingActivity extends AppCompatActivity {
    private boolean TwoFingersTapped;
    private boolean hitpercent;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);
    button.setOnTouchListener(new View.OnTouchListener() {
                                  public boolean onTouch(View view, MotionEvent motionEvent) {
                                      int action = motionEvent.getAction();
                                      Switch(action & MotionEvent.ACTION_MASK) {
                                          caseMotionEvent.ACTION_POINTER_DOWN;
                                          TwoFingersTapped = true;
                                          if (YourFighter.getFighter().getSpecial() + YourFighter.getFighter().getAttack() >= 21) {
                                              int place = random.nextInt(100);
                                              if (place > 10) {
                                                  ComputerFighter.getFighter().setHp(ComputerFighter.getFighter().getHp() - YourFighter.getFighter().getSpecial());
                                              }
                                          } else if (YourFighter.getFighter().getSpecial() + YourFighter.getFighter().getAttack() >= 10) {
                                              int place = random.nextInt(100);
                                              if (place > 25) {
                                                  ComputerFighter.getFighter().setHp(ComputerFighter.getFighter().getHp() - YourFighter.getFighter().getSpecial());
                                              }
                                          } else if (YourFighter.getFighter().getSpecial() + YourFighter.getFighter().getAttack() < 10) {
                                              int place = random.nextInt(100);
                                              if (place > 50) {
                                                  ComputerFighter.getFighter().setHp(ComputerFighter.getFighter().getHp() - YourFighter.getFighter().getSpecial());
                                              }
                                          }

                                      }}

        /*myLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        // Perform tasks here
                        return true;
                    }
                }
    }
*/

    public void GestureDetector(){

    }
}
