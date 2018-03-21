package com.example.silence.myapplication;

/**
 * Created by Silence on 2018/3/21.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;
/**
 * 总结:
 * 在MainActivity中执行:
 * mTestMatrixImageView.setImageMatrix(matrix);
 * 时此自定义View会先调用setImageMatrix(Matrix matrix)
 * 然后调用onDraw(Canvas canvas)
 */
public class TestMatrixImageView extends AppCompatImageView{
    private Matrix mMatrix;
    private Bitmap mBitmap;
    public TestMatrixImageView(Context context) {
        super(context);
        mMatrix=new Matrix();
        mBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.tx23282_1);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("---> onDraw");
        //画原图
        canvas.drawBitmap(mBitmap, 0, 0, null);
        //画经过Matrix变化后的图
        canvas.drawBitmap(mBitmap, mMatrix, null);
        super.onDraw(canvas);
    }
    @Override
    public void setImageMatrix(Matrix matrix) {
        System.out.println("---> setImageMatrix");
        this.mMatrix.set(matrix);
        super.setImageMatrix(matrix);
    }

    public Bitmap getBitmap(){
        System.out.println("---> getBitmap");
        return mBitmap;
    }

}
