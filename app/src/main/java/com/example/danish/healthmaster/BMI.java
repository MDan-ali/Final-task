package com.example.danish.healthmaster;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class BMI extends Activity {
    String w,h;
    TextView bmi,bmiRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        EditText weight = (EditText)findViewById(R.id.weight);
        w = weight.getText().toString();
        EditText height = (EditText)findViewById(R.id.height);
        h = height.getText().toString();
        bmi = (TextView)findViewById(R.id.bmiValue);
        bmiRemark = (TextView)findViewById(R.id.bmiRemarks);
    }

    public  void calculate(View view) {
        int x = Integer.parseInt(w);
        int y = Integer.parseInt(h);
        float z;
        z=(float)x/(y*y);
        bmi.setText(String.valueOf(z));
        if (z<=18.5){
            bmiRemark.setText("(Underweight)");
        }
        else if (z>18.5&&z<=25){
            bmiRemark.setText("(Normal weight)");
        }
        else if (z>25&&z<30){
            bmiRemark.setText("(Over weight)");
        }
        else
            bmiRemark.setText("(Obese)");
    }
}
