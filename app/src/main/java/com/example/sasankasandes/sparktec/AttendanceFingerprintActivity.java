package com.example.sasankasandes.sparktec;

import android.app.Activity;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import com.multidots.fingerprintauth.AuthErrorCodes;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

public class AttendanceFingerprintActivity extends Activity implements FingerPrintAuthCallback {
    //implement FingerPrintAuthCallback predefined function set on activity
    FingerPrintAuthHelper mAttendanceFingerprint;
    //defining fingerprint anchor
    public int attempt_count= 5;
    //defining attempt counter for fingerprint
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //disable default title of the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_fingerprint);
        mAttendanceFingerprint= FingerPrintAuthHelper.getHelper(this, this);
        //casting fingerprint object
    }

    @Override
    protected void onResume() {
        super.onResume();
        //start finger print authentication
        mAttendanceFingerprint.startAuth();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mAttendanceFingerprint.stopAuth();
    }
    @Override
    public void onNoFingerPrintHardwareFound() {
        Toast.makeText(this,"no fingerprint sensor",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoFingerPrintRegistered() {
        Toast.makeText(this,"enroll at least one fingerprint",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBelowMarshmallow() {
        //Device running below API 23 version of android that does not support finger print authentication.
    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        Toast.makeText(this,"authentication verified!",Toast.LENGTH_SHORT).show();
        Intent nextActivity = new Intent("com.example.sasankasandes.sparktec.OBDpairActivity");
        startActivity(nextActivity);
    }

    @Override

    public void onAuthFailed(int errorCode, String errorMessage) {

            attempt_count-=1;
            if (attempt_count>0){
                String attempt_count_string = Integer.toString(attempt_count);
                ImageView fingerprintImage = (ImageView) findViewById(R.id.imageView3);
                Animation shake = AnimationUtils.loadAnimation(AttendanceFingerprintActivity.this, R.anim.wobble);

                Toast.makeText(this, "Unable to recognize fingerprint /n You have " + attempt_count_string + "more attempts", Toast.LENGTH_SHORT).show();
                shake.reset();
                shake.setFillAfter(true);
                fingerprintImage.startAnimation(shake);
            }
            else {


                }
            }

        /*switch (errorCode) {    //Parse the error code for recoverable/non recoverable error.
            case AuthErrorCodes.CANNOT_RECOGNIZE_ERROR:



                break;

            case AuthErrorCodes.NON_RECOVERABLE_ERROR:
                shake.reset();
                shake.setFillAfter(true);
                fingerprintImage.startAnimation(shake);
                break;

            case AuthErrorCodes.RECOVERABLE_ERROR:

                shake.reset();
                shake.setFillAfter(true);
                fingerprintImage.startAnimation(shake);
                break;
        }*/
    }

    class A {
        int i=0;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                i--;
            }
        };
    }


