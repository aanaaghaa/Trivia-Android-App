package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button zero;
    EditText editText;
    int noOfBrackets=0;
    String value;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText=(EditText)findViewById(R.id.calculate);
         value="0";
    }

    public void backSpace(View view) {
    }

    public void advanceCalculator(View view) {
    }

    public void showConverter(View view) {
    }

    public void showHistory(View view) {
    }

    public void btnClicked(View view) {
        Button btn=(Button)view;
        String numTag= (String) btn.getTag();
        //Log.i("Zero", zeroTag);
         value=editText.getText().toString();
         editText.setText(value + numTag);
    }


    public void cancel(View view) {
    }

    public void brackets(View view) {
        if (noOfBrackets%2==0)
        {
             value=editText.getText().toString();
            editText.setText(value + "(" );
        }else{
            editText.setText(value + ")" );
        }
        noOfBrackets++;
    }
    public void equals(View view) {
        int sum=0;
        String val=editText.getText().toString();
        char[] numberArray = new char[4];
        for (i=0;i<val.length();i++)
        {
            char symbol=val.charAt(i); //convert into character and seperate when there is a symbol later convert that numString to num
            int temp = 0;
            while(symbol!='+' || symbol!='-' || symbol!='X' || symbol!='/' || symbol!='%' || symbol!='(')
            {
                    numberArray[i]=symbol;
                    int value = Integer.parseInt(String.valueOf(numberArray[i]));
                    temp = temp * 10 + value;
                Log.i("num",Integer.toString(temp));
            }
            if (symbol=='+' || symbol=='=')
            { //while symbol is =
            