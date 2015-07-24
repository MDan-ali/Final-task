package com.example.danish.healthmaster;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class pedometer extends Activity implements SensorEventListener {

    private int steps=0;
    private double a;
    NotificationCompat.Builder stepNotification ;
    private static final int uniqueID = 123456789;
    private SensorManager accsensorManager;
    private Sensor accelerometer;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private double distance, calories;
    private static final int SHAKE_THRESHOLD = 900;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);
        accsensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = accsensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accsensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        stepNotification = new NotificationCompat.Builder(this);
        stepNotification.setAutoCancel(true);
        EditText steps = (EditText)findViewById(R.id.steps);
        a = Double.parseDouble(steps.getText().toString());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    steps++;
                }
            }

            last_x = x;
            last_y = y;
            last_z = z;

        }

        TextView stepsValue = (TextView)findViewById(R.id.stepsValue);
        stepsValue.setText("" + steps);

        distance = (0.00086)*steps;
        calories = (0.05)*steps;

        TextView distValue = (TextView)findViewById(R.id.distValue);
        distValue.setText(distance + "km");
        TextView calValue = (TextView)findViewById(R.id.calValue);
        calValue.setText(calories + "cal");

        if (steps==a){
            stepNotification.setSmallIcon(R.drawable.ic_launcher);
            stepNotification.setTicker("Completed");
            stepNotification.setWhen(System.currentTimeMillis());
            stepNotification.setContentTitle("Goal Reached");
            stepNotification.setContentText("Your goal set has been compleated");

            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            stepNotification.setContentIntent((pendingIntent));

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(uniqueID, stepNotification.build());
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public  void onclick (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
