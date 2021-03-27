package com.example.moneysaver.Ultils;

import android.content.Context;
import android.graphics.Typeface;

public class FontSetting {
    Context context;
    Typeface tf1,tf2,tf3;

    public FontSetting(Context context) {
        this.context = context;
        tf1=Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-ExtraBold.ttf");
        tf2= Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Regular.ttf");
        tf3= Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Bold.ttf");
    }

    public Typeface getTf3() {
        return tf3;
    }

    public void setTf3(Typeface tf3) {
        this.tf3 = tf3;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Typeface getTf1() {
        return tf1;
    }

    public void setTf1(Typeface tf1) {
        this.tf1 = tf1;
    }

    public Typeface getTf2() {
        return tf2;
    }

    public void setTf2(Typeface tf2) {
        this.tf2 = tf2;
    }
}
