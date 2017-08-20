package com.example.sasankasandes.sparktec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class OBDpairActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obdpair);
        nextActivity();
    }

    public void nextActivity(){
        Button skipButton = (Button)findViewById(R.id.button2);
        skipButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent nextActivity = new Intent("com.example.sasankasandes.sparktec.AttendanceFeedback");
                        startActivity(nextActivity);
                    }
                }
        );
    }
}
