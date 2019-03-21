package com.akihitoq.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DrawOS extends View {
    Paint paint = new Paint();

    public DrawOS(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,0,100,100, paint);
    }
}
