package jp.techacademy.sumi.keisuke.calcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sumikeisuke on 2018/04/05.
 */

public class CalcActivity extends AppCompatActivity {

    public static final String Calc = "Calc";
    public static final String Num1 = "Num1";
    public static final String Num2 = "Num2";

    String plus="plus",minus="minus",times="times",divided="divided";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultcalc);

        String calc = getIntent().getStringExtra(Calc);
        double num1=getIntent().getDoubleExtra(Num1,0);
        double num2=getIntent().getDoubleExtra(Num2,0);


        TextView textView = (TextView) findViewById(R.id.calcResult);


        double result=0;

        if(calc.equals(plus)){
            result=num1+num2;
        }else if(calc.equals(minus)){
            result=num1-num2;
        }else if(calc.equals(times)){
            result=num1*num2;
        }else if(calc.equals(divided)){
            result=num1/num2;
        }
        textView.setText(String.valueOf(result));
        //this.finish();
    }


}
