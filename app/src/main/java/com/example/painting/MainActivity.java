package com.example.painting;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //
    int color=Color.BLACK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    final SingleTouchView m=new SingleTouchView(this);
    public void onColorButtonClick(View v){
        SingleTouchView singleTouch=findViewById(R.id.singleTouchView);

        switch (v.getId()) {
            case R.id.btn_black:
                color = Color.BLACK;
                break;
                /*
            case R.id.btn_red:
                singleTouch.setColor(Color.RED);
                break;
                 */
            case R.id.btn_red:
                color = Color.RED;
                break;
            case R.id.btn_green:
                color = Color.GREEN;
                break;
            case R.id.btn_clear:
                singleTouch.clearCanvas();
                break;

        }

    }

}
