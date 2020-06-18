package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class Main4Activity extends AppCompatActivity {
SharedPreferences result;
    StringBuffer data;
    String valuen;
//Gets the string values from each activity and displays it in a textView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView textView=(TextView) findViewById(R.id.summary);
        result = getSharedPreferences("name", Context.MODE_PRIVATE);
        String value= result.getString("userName","No data to be shown");
        String value1= result.getString("cricketerName","No data to be shown");
        String value2= result.getString("colorName","No data to be shown");
         valuen=value+value1+value2;
        textView.setText( "Summary \n Hello "+ value + "\nHere are the answers selected:\n Who is the best cricketer in the world?\n Answer:" + value1 + "\n What are the colors in the national flag?\nAnswers:" + value2);

    }
    //Passes all the data to history
    public void saveClicked(View view)
    {
        SharedPreferences storeData = getSharedPreferences("store_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=storeData.edit();
        editor.putString("data",valuen);
        editor.apply();
    }
    //Goes back to the first activity
    public void finishClicked(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    //Goes to the history activity
    public void historyClicked(View view)
    {
        Intent intent=new Intent(this,History.class);
        startActivity(intent);
    }
}
