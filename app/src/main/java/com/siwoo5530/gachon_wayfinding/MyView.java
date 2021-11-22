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
    //public MyPath myPath = new MyPath();

    public PointF pointA = new PointF();
    public PointF pointB = new PointF();
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
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        double scale;

        uniMap = BitmapFactory.decodeResource(getResources(),R.drawable.uni_map);
        scale = uniMap.getWidth()/width;
        height = uniMap.getHeight();
        height = (int) (height / scale);
        Bitmap resize_bitmap = Bitmap.createScaledBitmap(uniMap,width,height,true);
        pnt.setColor(Color. BLUE );//선 색깔
        pnt.setStrokeWidth(5.0f);//선 굵기
        canvas.drawColor(Color. GRAY);
        canvas.drawBitmap(resize_bitmap,0,0,null);

        //testLine

        pointA.set(50.00f,50.00f);//시작점
        pointB.set(1100.00f,900.00f);//도착점

        canvas.drawLine(pointA.x,pointA.y, pointB.x,pointB.y,pnt);//선긋기
        canvas.drawCircle(200, 200, 50, pnt);//채운원그리기
        pnt.setStyle(Paint.Style.STROKE);//원 둘레에만하기

        canvas.drawCircle(300,300,100,pnt);//빈 원그리기
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
