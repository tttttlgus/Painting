package com.example.painting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SingleTouchView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    private int currentColor = Color.BLACK;
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();

    public SingleTouchView(Context context) {
        super(context);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setColor(currentColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x, y);
                paths.add(path);
                colors.add(currentColor);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                // do nothing
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void setCurrentColor(int color) {
        currentColor = color;
        paint.setColor(currentColor);
    }

    public void clearCanvas() {
        paths.clear();
        colors.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < paths.size(); i++) {
            paint.setColor(colors.get(i));
            canvas.drawPath(paths.get(i), paint);
        }
    }
}



