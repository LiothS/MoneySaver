package com.example.moneysaver.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.moneysaver.MainActivity;
import com.example.moneysaver.R;
import com.example.moneysaver.Ultils.SharePrefHelper;

import static maes.tech.intentanim.CustomIntent.customType;

public class WelcomeScreen extends AppCompatActivity {
    TextView start;
    int firstUse=0;
    SharePrefHelper sharePrefHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.blue_main));
        }
        try {
           // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        start=findViewById(R.id.startBtn);
        sharePrefHelper=new SharePrefHelper(this);
        firstUse=sharePrefHelper.getInt("firstUse");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(firstUse==1){
                    Intent intent=new Intent(WelcomeScreen.this, MainActivity.class);
                    startActivity(intent);
                    customType(WelcomeScreen.this,"left-to-right");}
                else {
                    Intent intent=new Intent(WelcomeScreen.this,SettingScreen.class);
                    startActivity(intent);
                    customType(WelcomeScreen.this,"left-to-right");
                    sharePrefHelper.putInt("firstUse",1);
                }
            }
        });
    }
}