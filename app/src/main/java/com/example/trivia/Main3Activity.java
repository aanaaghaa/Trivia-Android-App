package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        cb1=findViewById(R.id.color1);
        cb2=findViewById(R.id.color2);
        cb3=findViewById(R.id.color3);
        cb4=findViewById(R.id.color4);
    }
    //When next is clicked, appends the data to the string buffer if it is checked and passes the data to the summary activity
    public void nextClicked(View view)
    {
StringBuffer selectedOptions=new StringBuffer();
if (cb1.isChecked())  {   selectedOptions.append(cb1.getText().toString());}
if (cb2.isChecked())   {  selectedOptions.append(" ,"+cb2.getText().toString());}
if (cb3.isChecked())    { selectedOptions.append(" ,"+cb3.getText().toString());}
if (cb4.isChecked())     {selectedOptions.append(" ,"+cb4.getText().toString());}

        sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("colorName",selectedOptions.toString());
        editor.apply();
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}
