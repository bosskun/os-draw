package com.akihitoq.draw;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView tv_xy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = (ConstraintLayout) findViewById(R.id.layout_touch);

        tv_xy = (TextView) findViewById(R.id.tv_xy);
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                tv_xy.setText("X: " + String.valueOf(x) + " Y: " + String.valueOf(y));
                return false;
            }
        });

    }
}
