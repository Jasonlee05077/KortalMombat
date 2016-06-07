package com.example.linj.kortalmombat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static String title = "";
    private static String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        EditText enteredTitle = ((EditText) findViewById(R.id.editText6));
        EditText enteredPassword = ((EditText) findViewById(R.id.editText7));
         title = enteredTitle.getText().toString();
         password = enteredPassword.getText().toString();
        Button AccessButton = (Button)findViewById(R.id.button5);
        AccessButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                YourFighter.setFighter( Cloud.getFighter(title, password));
                startActivity(new Intent(LoginActivity.this, MatchMaking.class));
            }
        });

    }
}
