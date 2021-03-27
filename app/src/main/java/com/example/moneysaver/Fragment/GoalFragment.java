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

public class GoalFragment extends Fragment {
    EditText cardNumber;
    TextView cardName;
    ImageView copyBtn;
    SharePrefHelper sharePrefHelper;
    public GoalFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goal_fragment, container, false);

        return view;
    }

    private void clickEvent() {

    }

    private void init(View view) {

    }
}
