package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

SharedPreferences sharedPreferences;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.userName);
    }
    public void nextClicked(View view)
    {
        //If the name is empty, shows a toast message else it will move on to the next activity, and passes the data taken here to the summary activity
        if (editText.length()==0)
        {
            Toast.makeText(this, "Please fill the above details", Toast.LENGTH_SHORT).show();
        }else
        {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
        sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("userName",editText.getText().toString());
        editor.apply();
    }}
}
