package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class History extends AppCompatActivity {
SharedPreferences result;
    private List<TaskModel> taskList;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = findViewById(R.id.recyclerview);
        setContentView(R.layout.activity_history);
        result = getSharedPreferences("store_data", Context.MODE_PRIVATE);
        final String value= result.getString("data","No data to be shown");
        btnAdd = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.recyclerview);
        //get the time and date to show when it was created
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat simpleTimeFormat=new SimpleDateFormat("hh:mm");
        final String date=simpleDateFormat.format(calendar.getTime());
        final String time=simpleTimeFormat.format(calendar.getTime());

        taskList = PrefConfig.readListFromPref(this);
       // if (taskList == null)
            taskList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TaskAdapter(getApplicationContext(), taskList);
        recyclerView.setAdapter(adapter);

        //Passing the list to PrefConfig class
        //the data with the time and date, gets added to the history or the recycler view using the adapter from Pref config class
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskModel taskModel = new TaskModel(value,date,time);
                taskList.add(taskModel);
                PrefConfig.writeListInPref(getApplicationContext(), taskList);
                Collections.reverse(taskList);
                adapter.setTaskModelList(taskList);
            }

        });

    }


}
