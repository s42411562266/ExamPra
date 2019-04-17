package com.example.exampra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.SpannableString;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    EditText str;
    TextView text;
    int size=40;
    public void changeColor(View v) {
        str = findViewById(R.id.editText);
        text = findViewById(R.id.textView);
        String output = str.getText().toString();
        text.setTextSize(size);
        /*text.setText(str.getText().toString());
        String test = "<font color=\"#cc0029\">Erste Farbe</font> <font color=\"#ffcc00\">zweite Farbe</font>";
        text.setText(Html.fromHtml(test));*/
        int [][]RGBB=new int[7][3];
        RGBB[0][0]=255;RGBB[0][1]=0;RGBB[0][2]=0;//red
        RGBB[1][0]=255;RGBB[1][1]=165;RGBB[1][2]=0;//orange
        RGBB[2][0]=255;RGBB[2][1]=255;RGBB[2][2]=0;//yellow
        RGBB[3][0]=0;RGBB[3][1]=255;RGBB[3][2]=0;//green
        RGBB[4][0]=0;RGBB[4][1]=255;RGBB[4][2]=255;//blue
        RGBB[5][0]=43;RGBB[5][1]=0;RGBB[5][2]=255;
        RGBB[6][0]=87;RGBB[6][1]=0;RGBB[6][2]=255;//purple
        SpannableStringBuilder style = new SpannableStringBuilder(output);
        //style.setSpan(new BackgroundColorSpan(Color.RED),2,5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);     //设置指定位置textview的背景颜色
        style.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.rgb(0, 255, 0)), 2, 4, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        for (int i=0;i<output.length();i++){
            /*if(i+1>=output.length()){
                style.setSpan(new ForegroundColorSpan(Color.rgb(RGBB[i%7][0],RGBB[i%7][1],RGBB[i%7][2])), i, i+1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                break;
            }*/
            style.setSpan(new ForegroundColorSpan(Color.rgb(RGBB[i%7][0],RGBB[i%7][1],RGBB[i%7][2])), i, i + 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        text.setText(style);
    }

}
