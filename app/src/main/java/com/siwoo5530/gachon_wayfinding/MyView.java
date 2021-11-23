package com.siwoo5530.gachon_wayfinding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyView extends View {
    private Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path route = new Path();
    public static Bitmap uniMap;

    public void setPointFS(ArrayList<PointF> pointFS) {
        this.pointFS = pointFS;
    }

    private ArrayList<PointF> pointFS;
    public PointF pointA;
    public PointF pointB;



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



        //canvas.drawLine(pointA.x,pointA.y, pointB.x,pointB.y,pnt);//선긋기

//        route.moveTo(100,100);

        if (pointFS !=null) {
            for (int i =0;i < pointFS.size()-1;i++){
                canvas.drawLine(pointFS.get(i).x,pointFS.get(i).y,pointFS.get(i+1).x,pointFS.get(i+1).y,pnt);
            }
        }
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
