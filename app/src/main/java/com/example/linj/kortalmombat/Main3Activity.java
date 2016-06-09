package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button continueButton = (Button) findViewById(R.id.button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText specialText = ((EditText) findViewById(R.id.editText15));
                String specialString = specialText.getText().toString();
                final int special = Integer.parseInt(specialString);
                EditText attackText = ((EditText) findViewById(R.id.editText14));
                String attackString = attackText.getText().toString();
                final int attack = Integer.parseInt(attackString);
                EditText defenseText = ((EditText) findViewById(R.id.editText16));
                String defenseString = defenseText.getText().toString();
                final int defense = Integer.parseInt(defenseString);

                int totalPoints = attack+defense+special;
                if (totalPoints != 100)
                {System.out.println("Please use 100 points");
                } else {
                    Cloud.uploadChances(defense,attack,special,YourFighter.title,YourFighter.password);

                    startActivity(new Intent(Main3Activity.this, MatchMaking.class));

                }
            }
        });
    }
}
