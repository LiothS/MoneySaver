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

public class PayCardFragment extends Fragment {
    EditText cardNumber;
    TextView cardName;
    ImageView copyBtn;
    SharePrefHelper sharePrefHelper;
    public PayCardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);
        sharePrefHelper=new SharePrefHelper(getContext());
        init(view);
        clickEvent();
        return view;
    }

    private void clickEvent() {
        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", cardNumber.getText().toString());
                Toast.makeText(getContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                clipboard.setPrimaryClip(clip);
            }
        });
    }

    private void init(View view) {
        cardName=view.findViewById(R.id.bankName);
        cardNumber=view.findViewById(R.id.cardNumber);
        copyBtn=view.findViewById(R.id.copyBtn);
        cardNumber.setText(sharePrefHelper.getString("cardNumber","7103205306080"));
        cardName.setText(sharePrefHelper.getString("bankName","Agribank"));
    }
}
