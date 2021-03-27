package com.example.moneysaver.CustomView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.moneysaver.R;
import com.example.moneysaver.Ultils.SharePrefHelper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GoalDialog extends Dialog implements View.OnClickListener {
    public GoalDialog(@NonNull Context context) {
        super(context);
    }

    TextView doneBtn,tvMoney;
    RadioButton rd1,rd2;
    int amount=0;
    SharePrefHelper sharePrefHelper;
    int type=1;
    public GoalDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected GoalDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }catch (Exception e){}


        setContentView(R.layout.goal_dialog);
        tvMoney=findViewById(R.id.editTextMoney);
        doneBtn=findViewById(R.id.dontBtn);
        sharePrefHelper=new SharePrefHelper(getContext());
        if(sharePrefHelper.getInt("Total")-sharePrefHelper.getInt("Free")>0) amount=sharePrefHelper.getInt("Total")-sharePrefHelper.getInt("Free");
        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = formatter.format(amount);
        tvMoney.setText(formattedNumber+" VND");
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePrefHelper.putInt("Free",sharePrefHelper.getInt("Free")+amount);
                cancel();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
