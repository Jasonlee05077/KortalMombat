package com.example.linj.kortalmombat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText YourAttackText = ((EditText) findViewById(R.id.editText8));
        EditText YourDefenseText = ((EditText) findViewById(R.id.editText9));
        EditText YourSpecialText = ((EditText) findViewById(R.id.editText10));
        EditText CompAttackText = ((EditText) findViewById(R.id.editText11));
        EditText CompDefenseText = ((EditText) findViewById(R.id.editText12));
        EditText CompSpecialText = ((EditText) findViewById(R.id.editText13));
        int yourFighterAtt = YourFighter.getFighter().getAttack();
        int yourFighterDef = YourFighter.getFighter().getDefense();
        int yourFighterSpec = YourFighter.getFighter().getSpecial();
        int yourCompAtt = ComputerFighter.getFighter().getAttack();
        int yourCompDef = ComputerFighter.getFighter().getDefense();
        int yourCompSpec = ComputerFighter.getFighter().getSpecial();
        String yFighterAtt = ""+yourFighterAtt;
        String yFighterDef = ""+yourFighterDef;
        String yFighterSpec = ""+yourFighterSpec;
        String cFighterAtt = ""+yourCompAtt;
        String cFighterDef = ""+yourCompDef;
        String cFighterSpec = ""+yourCompSpec;

        YourAttackText.setText(yFighterAtt);
        YourDefenseText.setText(yFighterDef);
        YourSpecialText.setText(yFighterSpec);
        CompAttackText.setText(cFighterAtt);
        CompDefenseText.setText(cFighterDef);
        CompSpecialText.setText(cFighterSpec);
    }
}
