package com.example.picpicb.accelerometre;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Senseur extends AppCompatActivity implements SensorEventListener {
    private  SensorManager mSensorManager;
    private int type;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senseur);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        text = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        type = Integer.parseInt(intent.getStringExtra("sensor"));
        //text.setText(intent.getStringExtra("sensor"));
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor s = mSensorManager.getDefaultSensor(type);
        mSensorManager.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String s = "Sensor type :"+type+" ";
        if( event.sensor.getType() == type) {
            for(int i=0;i<event.values.length;i++){
                s += ""+event.values[i]+"   ";
                text.setText(s);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
