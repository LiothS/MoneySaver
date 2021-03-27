package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moneysaver.Adapter.CustomFragmentPager;
import com.example.moneysaver.CustomView.AddDialog;
import com.example.moneysaver.CustomView.GetDialog;
import com.example.moneysaver.Ultils.FontSetting;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FontSetting fontSetting;
    TextView cardBtn,detailBtn,goalBtn,tvOperations,tvAdd,tvGet,tvGoal,tvNote,tvTransactions;
    CardView addCard,getCard,goalCard,noteCard;
    ImageView exitBtn,settingBtn;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        try {
             getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        fontSetting=new FontSetting(this);
        Init();
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new CustomFragmentPager(fm,1));
        viewPager.setCurrentItem(0);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ClickEvent();
    }

    private void ClickEvent() {
        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                cardBtn.setTypeface(fontSetting.getTf3());
                cardBtn.setTextColor(getResources().getColor(R.color.orange));
                detailBtn.setTypeface(fontSetting.getTf2());
                goalBtn.setTypeface(fontSetting.getTf2());
               detailBtn.setTextColor(getResources().getColor(R.color.black));
                goalBtn.setTextColor(getResources().getColor(R.color.black));
            }
        });
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                detailBtn.setTypeface(fontSetting.getTf3());
                detailBtn.setTextColor(getResources().getColor(R.color.orange));
                cardBtn.setTypeface(fontSetting.getTf2());
                goalBtn.setTypeface(fontSetting.getTf2());
                goalBtn.setTextColor(getResources().getColor(R.color.black));
                cardBtn.setTextColor(getResources().getColor(R.color.black));
            }
        });
        goalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
                goalBtn.setTypeface(fontSetting.getTf3());
                goalBtn.setTextColor(getResources().getColor(R.color.orange));
                detailBtn.setTypeface(fontSetting.getTf2());
                cardBtn.setTypeface(fontSetting.getTf2());
                detailBtn.setTextColor(getResources().getColor(R.color.black));
                cardBtn.setTextColor(getResources().getColor(R.color.black));
            }
        });
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialog cdd=new AddDialog(MainActivity.this);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(Objects.requireNonNull(cdd.getWindow()).getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;


                cdd.getWindow().setAttributes(lp);
                cdd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                cdd.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
                cdd.show();
            }
        });
        getCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GetDialog cdd=new GetDialog(MainActivity.this);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(Objects.requireNonNull(cdd.getWindow()).getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;


                cdd.getWindow().setAttributes(lp);
                cdd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                cdd.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
                cdd.show();
            }
        });
    }

    private void Init() {
        cardBtn=findViewById(R.id.cardBtn);
        detailBtn=findViewById(R.id.detailBtn);
        goalBtn=findViewById(R.id.goalBtn);
        tvOperations=findViewById(R.id.operations);
        tvAdd=findViewById(R.id.tvAdd);
        tvGet=findViewById(R.id.tvGet);
        tvGoal=findViewById(R.id.tvGoal);
        tvNote=findViewById(R.id.tvNote);
        tvTransactions=findViewById(R.id.transaction);
        cardBtn.setTypeface(fontSetting.getTf3());
        cardBtn.setTextColor(getResources().getColor(R.color.orange));
        detailBtn.setTypeface(fontSetting.getTf2());
        goalBtn.setTypeface(fontSetting.getTf2());
        tvOperations.setTypeface(fontSetting.getTf3());
        tvAdd.setTypeface(fontSetting.getTf2());
        tvGet.setTypeface(fontSetting.getTf2());
        tvGoal.setTypeface(fontSetting.getTf2());
        tvNote.setTypeface(fontSetting.getTf2());
        tvTransactions.setTypeface(fontSetting.getTf3());
        viewPager=findViewById(R.id.moneyViewPager);
        addCard=findViewById(R.id.addCard);
        getCard=findViewById(R.id.getCard);
        goalCard=findViewById(R.id.goalCard);
        noteCard=findViewById(R.id.noteCard);
    }
}