package com.example.moneysaver.Fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moneysaver.R;
import com.example.moneysaver.Ultils.SharePrefHelper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TotalFragment extends Fragment {
    TextView total,free,tvBalance,tvMoney;
    SharePrefHelper sharePrefHelper;
    public TotalFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        total=view.findViewById(R.id.totalBtn);
        free=view.findViewById(R.id.freeBtn);
        tvBalance=view.findViewById(R.id.balance);
        tvMoney=view.findViewById(R.id.totalMoney);
        sharePrefHelper=new SharePrefHelper(getContext());
        SetMoney(1);
        clickEvent();
        return view;
    }

    private void SetMoney(int i) {
        NumberFormat formatter = new DecimalFormat("#,###");
        int result=0;
        if(i==1) result=sharePrefHelper.getInt("Total");
        if (i==2) result=sharePrefHelper.getInt("Free");
        String formattedNumber = formatter.format(result);
        tvMoney.setText(formattedNumber+" VND");
    }

    private void clickEvent() {
        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setBackgroundColor(getContext().getResources().getColor(R.color.white));
                free.setBackground(getContext().getResources().getDrawable(R.drawable.detail_btn));
                free.setTextColor(getContext().getResources().getColor(R.color.white));
                total.setTextColor(getContext().getResources().getColor(R.color.black));
                tvBalance.setText("Free to use");
               SetMoney(2);
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                free.setBackgroundColor(getContext().getResources().getColor(R.color.white));
               total.setBackground(getContext().getResources().getDrawable(R.drawable.detail_btn));
                total.setTextColor(getContext().getResources().getColor(R.color.white));
                free.setTextColor(getContext().getResources().getColor(R.color.black));
                tvBalance.setText("Total balance");
                SetMoney(1);
            }
        });
    }

    private void init(View view) {

    }
}
