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

public class GetDialog extends Dialog implements View.OnClickListener {
    public GetDialog(@NonNull Context context) {
        super(context);
    }
    EditText money;
    TextView doneBtn;
    RadioButton rd1,rd2;
    int type=1;
    public GetDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected GetDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }catch (Exception e){}


        setContentView(R.layout.get_dialog);
        money=findViewById(R.id.editTextMoney);
        doneBtn=findViewById(R.id.dontBtn);
        rd1=findViewById(R.id.radio1);
        rd2=findViewById(R.id.radio2);
        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rd2.setChecked(false);
                type=1;
            }
        });
        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rd1.setChecked(false);
                type=2;
            }
        });
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result=money.getText().toString();
                if(!result.isEmpty()){
                    int amount=0;
                    try {
                        amount = Integer.parseInt(result);
                    } catch(NumberFormatException nfe) {
                        System.out.println("Could not parse " + nfe);
                    }
                    SharePrefHelper sharePrefHelper=new SharePrefHelper(getContext());
                    int total=sharePrefHelper.getInt("Total");
                    int free=sharePrefHelper.getInt("Free");
                    if(type==1){
                        if(total-free-amount>0){
                            sharePrefHelper.putInt("Total",sharePrefHelper.getInt("Total")-amount);
                        }
                        else{
                            int temp=total-free-amount;
                            if(free+temp>=0){
                                sharePrefHelper.putInt("Total",free+temp);
                                sharePrefHelper.putInt("Free",free+temp);
                            }
                            else {
                                Toast.makeText(getContext(), "Not enough money", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }
                    else {
                        sharePrefHelper.putInt("Total",sharePrefHelper.getInt("Total")-amount);
                        sharePrefHelper.putInt("Free",sharePrefHelper.getInt("Free")-amount);
                    }
                    NumberFormat formatter = new DecimalFormat("#,###");
                    String formattedNumber = formatter.format(amount);
                    sharePrefHelper.putString("lastTransAmount","-"+formattedNumber);
                    sharePrefHelper.putString("lastTransTitle","Add money");
                    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

                    sharePrefHelper.putString("lastTransDay",currentDate);
                }
                cancel();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
