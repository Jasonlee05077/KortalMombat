package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SpecificFighterActivity extends AppCompatActivity {
    private static String title = "";
    private static String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_fighter);
        EditText enteredTitle = ((EditText) findViewById(R.id.editText17));
        EditText enteredPassword = ((EditText) findViewById(R.id.editText18));
        title = enteredTitle.getText().toString();
        password = enteredPassword.getText().toString();
        Button AccessButton = (Button)findViewById(R.id.button9);
        AccessButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Cloud.getTheirStats(title, password);

                startActivity(new Intent(SpecificFighterActivity.this, FightingActivity.class));
            }
        });

    }
}
