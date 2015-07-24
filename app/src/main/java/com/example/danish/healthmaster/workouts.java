package com.example.danish.healthmaster;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class workouts extends ActionBarActivity {
    TextView first,second,third,forth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        first = (TextView)findViewById(R.id.first);
        second = (TextView)findViewById(R.id.second);
        third = (TextView)findViewById(R.id.third);
        forth = (TextView)findViewById(R.id.forth);
    }
    public  void back(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void begin(View view){
        first.setText("30-50");
        second.setText("50-70");
        third.setText("5-10");
        forth.setText("25-40");
    }
    public void moderate(View view){
        first.setText("50-70");
        second.setText("70-90");
        third.setText("10-15");
        forth.setText("40-60");
    }
    public void advanced(View view){
        first.setText("70-90");
        second.setText("90-120");
        third.setText("15-25");
        forth.setText("40-100");
    }
    public void push(View view){
        first.setText("When down on the ground, set your hands at a distance that is slightly wider than shoulder-width apart.Your feet should be set up in a way that feels right and comfortable to you.Think of your body as one giant straight line. \nWith your arms straight, butt clenched, and abs braced, steadily lower yourself until your elbows are at a 90 degree angle or smaller. \nOnce your chest touches the floor (or your arms go down to a 90 degree angle), pause slightly and then explode back up until you’re back in the same position.");
        second.setText("");
        third.setText("");
        forth.setText("");
    }

    public void Squat(View view){
        second.setText("");
        third.setText("");
        forth.setText("");
        first.setText("Push your hand straight forward front up in air so that its at right angle to your body. \nSlowly sit down till your bottom is almost touching the ground with some few inches left.\n Stay in that position for some time and the stand back up. " );
    }

    public void pull(View view){
        second.setText("");
        third.setText("");
        forth.setText("");
        first.setText("Find a bar or a rod which can hold your weight. \nGet a firm grip on the rod with your hands. \nNow pull yourself up till your chest touches the rod and then come back down but don't touch the floor");
    }

    public void situps(View view){
        second.setText("");
        third.setText("");
        forth.setText("");
        first.setText("Lie down on the ground and keep your hands behind your head. \nLegs should be kept folded with nees above the ground. \nNow pull your upper body above the ground till your face touched your knee using onl your abs muscles \nNow lie back down.");
    }
}
