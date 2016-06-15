package com.example.sepri.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sepri.splashscreen.R;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    Animation fade_in, fade_out;
    ViewFlipper viewfliper;
    Button next;
    Button previous;

    TelephonyManager telephone;
    TextView imei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewfliper = (ViewFlipper) findViewById(R.id.viewfliper);
        fade_in =AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        viewfliper.setInAnimation(fade_in);
        viewfliper.setOutAnimation(fade_out);

        viewfliper.setAutoStart(true);
        viewfliper.setFlipInterval(5000);
        viewfliper.startFlipping();
        telephone= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        imei = (TextView) findViewById(R.id.TextView_imei);
        imei.setText(telephone.getDeviceId().toString());

        }

    public void tombollogin(View view) {
        Intent i= new Intent(MainActivity.this,NextActivity.class);
        startActivity(i);

    }
}


