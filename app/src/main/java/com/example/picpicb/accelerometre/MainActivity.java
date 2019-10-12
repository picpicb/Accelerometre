package com.example.picpicb.accelerometre;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listeCapteurs;
    ArrayAdapter<String> listeAdapter;
    private SensorManager mSensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView liste = (ListView) findViewById(R.id.listeView);
        listeCapteurs = new ArrayList<String>();
        listeAdapter = new ArrayAdapter<String>(this, R.layout.case_vide, listeCapteurs);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensors) {
            listeAdapter.add("Sensors" + sensor.getName());
        }
        liste.setAdapter( listeAdapter );
        final AppCompatActivity this2 = this;

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                Intent intent = new Intent(this2, Senseur.class);
                System.out.println(sensors.get(position).getType());
                intent.putExtra("sensor",Integer.toString(sensors.get(position).getType()));
                startActivity(intent);
            }
        });
    }
}
