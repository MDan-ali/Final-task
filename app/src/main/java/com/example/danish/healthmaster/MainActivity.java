package com.example.danish.healthmaster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void yoga (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public  void fat (View view){
        Intent i = new Intent(this,bodyfat.class);
        startActivity(i);
    }
    public  void music (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public  void stepCalc (View view){
        Intent i = new Intent(this,pedometer.class);
        startActivity(i);
    }
    public  void bmiCalc (View view){
        Intent i = new Intent(this,BMI.class);
        startActivity(i);
    }
    public  void work (View view){
        Intent i = new Intent(this,workouts.class);
        startActivity(i);
    }
    public  void medi (View view){
        Intent i = new Intent(this,medidation.class);
        startActivity(i);
    }
    public void exit(View view){
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

}
