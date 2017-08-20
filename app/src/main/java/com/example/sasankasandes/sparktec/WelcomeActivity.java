package com.example.sasankasandes.sparktec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//remove default title bar from activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        linkNext();// calling report attendance button listener to link next activity (attendance fingerprint activity)
    }
    public void linkNext(){
        Button link_button = (Button)findViewById(R.id.button);//casting button
        link_button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent nextActivity = new Intent("com.example.sasankasandes.sparktec.AttendanceFingerprintActivity");//intent object for next activity
                        startActivity(nextActivity);
                    }
                }
        );
    }
}
