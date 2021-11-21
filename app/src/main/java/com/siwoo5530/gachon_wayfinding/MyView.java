package com.siwoo5530.gachon_wayfinding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class MyView extends View {
    private Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);

    public static Bitmap uniMap;

    private PointF pointA, pointB;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        uniMap = BitmapFactory.decodeResource(getResources(),R.drawable.uni_map);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        pnt.setColor(Color. BLUE );
        pnt.setStrokeWidth(10.0f);

        canvas.drawColor(Color. GRAY);
        canvas.drawBitmap(uniMap,(canvas.getWidth()/50),0,null);

        //canvas.drawLine(pointA.x,pointA.y, pointB.x,pointB.y,pnt);
        //canvas.drawBitmap();
        canvas.drawCircle(200, 200, 50, pnt);
        pnt.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(300,300,100,pnt);
    }

    public void setPointA(PointF point){
        pointA = point;
    }
    public void setPointB(PointF point){
        pointB = point;
    }
    public void draw(){
        invalidate();
        requestLayout();
    }
}
