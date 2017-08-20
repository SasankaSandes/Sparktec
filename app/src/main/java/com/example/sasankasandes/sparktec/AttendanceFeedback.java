package com.example.sasankasandes.sparktec;

import android.animation.TimeAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class AttendanceFeedback extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_feedback);
        nexActivity();
    }
    public void nexActivity(){
        Button getBackToWork = (Button)findViewById(R.id.button3);
        getBackToWork.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextActivity = new Intent("com.example.sasankasandes.sparktec.MainEmployeeActivity");
                    }
                }
        );
    }
}
