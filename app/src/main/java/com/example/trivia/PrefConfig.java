package com.example.trivia;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

class PrefConfig {
    private static final String LIST_KEY = "list_key100";
//Gson library is used to store the data in form of array list
    //Shared prefrences to save the data
    public static void writeListInPref(Context context, List<TaskModel> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }
//To read the Json String using Gson in the form of array list
    public static List<TaskModel> readListFromPref(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<TaskModel>>() {}.getType();
        List<TaskModel> list = gson.fromJson(jsonString, type);
        return list;
    }
}
