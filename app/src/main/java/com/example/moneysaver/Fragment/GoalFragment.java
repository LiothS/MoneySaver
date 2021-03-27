package com.example.moneysaver.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moneysaver.R;
import com.example.moneysaver.Ultils.SharePrefHelper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class GoalFragment extends Fragment {
    TextView tvMoney;
    SharePrefHelper sharePrefHelper;
    public GoalFragment() {
    }
    int amount=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goal_fragment, container, false);
        sharePrefHelper=new SharePrefHelper(getContext());
        if(sharePrefHelper.getInt("Total")-sharePrefHelper.getInt("Free")>0) amount=sharePrefHelper.getInt("Total")-sharePrefHelper.getInt("Free");
        tvMoney=view.findViewById(R.id.totalMoney);
        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = formatter.format(amount);
        tvMoney.setText(formattedNumber+" VND");

        return view;
    }

    private void clickEvent() {

    }

    private void init(View view) {

    }
}
