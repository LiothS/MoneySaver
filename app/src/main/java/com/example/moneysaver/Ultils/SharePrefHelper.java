package com.example.moneysaver.Ultils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefHelper {
    SharedPreferences sharedPreferences;
    Context context;
    SharedPreferences.Editor editor;
    public SharePrefHelper(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences("MoneyPref",context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void putInt(String key,int value){
        editor.putInt(key,value);
        editor.commit();
    }
    public int getInt(String key){
        return sharedPreferences.getInt(key,0);
    }

}
