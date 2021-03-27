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
import com.example.moneysaver.Ultils.FontSetting;
import com.example.moneysaver.Ultils.SharePrefHelper;

import static maes.tech.intentanim.CustomIntent.customType;

public class WelcomeScreen extends AppCompatActivity {
    TextView start,appName,appDes;
    int firstUse=0;
    FontSetting fontSetting;
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
        fontSetting=new FontSetting(this);
        Init();
        sharePrefHelper=new SharePrefHelper(this);
        firstUse=sharePrefHelper.getInt("firstUse");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent=new Intent(WelcomeScreen.this, MainActivity.class);
                    startActivity(intent);
                    customType(WelcomeScreen.this,"left-to-right");}


        });
    }

    private void Init() {
        appName=findViewById(R.id.appName);
        appDes=findViewById(R.id.appDes);
        appName.setTypeface(fontSetting.getTf1());
        appDes.setTypeface(fontSetting.getTf2());
        start=findViewById(R.id.startBtn);
        start.setTypeface(fontSetting.getTf1());
    }
}