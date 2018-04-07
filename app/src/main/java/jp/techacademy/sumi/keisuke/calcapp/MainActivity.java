package jp.techacademy.sumi.keisuke.calcapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Activity theActivity;
    String plus="plus",minus="minus",times="times",divided="divided";
    EditText numstr1,numstr2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theActivity = this;
        Log.d("UI_PARTS", "ボタンをタップしました");

        System.out.print("come hr2e");
        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);

        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);

        Button times = (Button) findViewById(R.id.times);
        times.setOnClickListener(this);

        Button divided = (Button) findViewById(R.id.divided);
        divided.setOnClickListener(this);

        numstr1 = (EditText) findViewById(R.id.num1);
        numstr2 = (EditText) findViewById(R.id.num2);




        EditText edit1 = (EditText) findViewById(R.id.num1);
        EditText edit2 = (EditText) findViewById(R.id.num2);
        edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    //ソフトキーボードを閉じる
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);


                    return true;
                }
                return false;
            }
        });

        edit2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(theActivity, CalcActivity.class);
        if (v.getId() == R.id.plus) {
            intent.putExtra(CalcActivity.Calc,plus);
        } else if (v.getId() == R.id.minus) {
            intent.putExtra(CalcActivity.Calc,minus);
        } else if (v.getId() == R.id.times) {
            intent.putExtra(CalcActivity.Calc,times);
        } else if (v.getId() == R.id.divided) {
            intent.putExtra(CalcActivity.Calc,divided);
        }
        if(numstr1.getText().length()!=0&&numstr2.getText().length()!=0){
            double num1=Double.valueOf(String.valueOf(numstr1.getText()));
            double num2=Double.valueOf(String.valueOf(numstr2.getText()));
            intent.putExtra(CalcActivity.Num1,num1);
            intent.putExtra(CalcActivity.Num2,num2);
            startActivity(intent);
        }else{
            Toast.makeText(this, "数字が入力されていません。正しく入力してください。", Toast.LENGTH_LONG).show();
        }


    }






}
