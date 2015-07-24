package com.example.danish.healthmaster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class bodyfat extends Activity {

    float a=0,b=0,c=0;
    double d=0;
    int age=0;
    int male=0,female=0,child=0,adult=0;
    EditText weight1,height2,ageVal;
    TextView fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyfat);
        weight1 = (EditText)findViewById(R.id.wt);
        height2 = (EditText)findViewById(R.id.ht);
        ageVal = (EditText)findViewById(R.id.age);
        fat = (TextView)findViewById(R.id.fat);
    }
    public void male (View view){
        if (((CheckBox) view).isChecked()) {
            male = 1;
        }
        else male=0;
    }
    public void female (View view){
        if (((CheckBox) view).isChecked()) {
            female = 1;
        }
        else female = 0;
    }
    public void child (View view){
        if (((CheckBox) view).isChecked()) {
            child = 1;
        }
        else
            child=0;
    }
    public void adult (View view){
        if (((CheckBox) view).isChecked()) {
            adult = 1;
        }
        else
            adult=0;
    }

    public void fatCalc(View view){
        a = Float.parseFloat(weight1.getText().toString());
        b = Float.parseFloat(height2.getText().toString());
        age = Integer.parseInt(ageVal.getText().toString());
        c=a/(b*b);
        if(male==1 && female==0){
            if (child==1 &&  adult==0){
                d =(float)(1.51*c)-(0.70*age)-(3.6) + 1.4;
                fat.setText(Double.toString(d));
            }
            else if (adult==1 && child==0){
                d=(float)(1.20*c) + (0.23*age)-(10.8)-5.4;
                fat.setText(Double.toString(d));
            }
            else if (child == 1 && adult == 1){
                fat.setText("Invalid Selections");
            }
            else {
                fat.setText("Invalid Selections");
            }
        }
        else if(female==1 && male==0){
            if (child==1&&adult==0){
                d=(float)(1.51*c)-(0.70*age)+ 1.4;
                fat.setText(Double.toString(d));
            }
            else if (adult==1&&child==0){
                d=(float)(1.20*c)+(0.23*age)- 5.4;
                fat.setText(Double.toString(d));
            }
            else if (child == 1 && adult == 1){
                fat.setText("Invalid Selections");
            }
            else {
                fat.setText("Invalid Selections");
            }
        }
        else if (male==1 && female ==1){
            fat.setText("Invalid Selections");
        }
        else {
            fat.setText("Invalid Selections");
        }
    }
    public  void goBack (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
