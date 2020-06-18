package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button nextBtn;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2main);
        radioGroup=findViewById(R.id.radioGroup);

    }
    //Once any one of the radio button is checked, ID will be taken to the radio button and the text of the radio button checked will be passed to the summary activity
    public void radioChecked(View view)
    {
         int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);

            sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("cricketerName", radioButton.getText().toString());
            editor.apply();
    }
    //Moves to the next activity
    public void nextClicked(View view)
    {
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
    }
}
