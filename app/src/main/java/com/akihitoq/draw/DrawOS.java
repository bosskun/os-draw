package com.akihitoq.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DrawOS extends View {
    Paint paint = new Paint();
    PointF pointF;
    ArrayList<PointF> lpointf = new ArrayList<>();
    public DrawOS(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        //canvas.drawLine(0,0,100,100, paint);
        //canvas.drawLine(100,0,0,100, paint);
        if (pointF != null)
            for(int i = 0; i <lpointf.size() ; i++ ){
                canvas.drawCircle(lpointf.get(i).x,lpointf.get(i).y,100,paint);
            }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                pointF = new PointF(x, y);
                lpointf = addPointToList(lpointf, pointF);
                this.invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                pointF = new PointF(x, y);
                lpointf = addPointToList(lpointf, pointF);
                this.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                lpointf = new ArrayList<>();
                this.invalidate();
                break;
            }
        }
        Toast.makeText(this.getContext(),"X: "+String.valueOf(x)+" , Y: "+String.valueOf(y),Toast.LENGTH_SHORT).show();
        this.invalidate();
        return true;
    }

    private ArrayList<PointF> addPointToList(ArrayList<PointF> lpointf, PointF pointF){
        if (lpointf.size() >= 5) {
            lpointf.remove(0);
            lpointf.add(pointF);
        }else{
            lpointf.add(pointF);
        }
        return lpointf;
    }
}
