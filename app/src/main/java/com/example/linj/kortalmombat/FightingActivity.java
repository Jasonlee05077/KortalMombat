package com.example.linj.kortalmombat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class FightingActivity extends AppCompatActivity {

    private Button button2;
    button2 = (Button) findViewById(R.id.Punch) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);

    }

}
