package com.zero.bless.demo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.zero.bless.R;

/**
 * Created by xiaocai on 2018/3/29.
 */

public class TestView extends View {

    public TestView(Context context, AttributeSet attrs)
    {

        super(context, attrs);

    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasureSize(widthMeasureSpec, dpToPx(200));
        int height = getMeasureSize(heightMeasureSpec, dpToPx(200));

        setMeasuredDimension(width, height);


    }

    @Override
    public void onDraw(Canvas canvas){

        super.onDraw(canvas);

        int drawType = 8;

        if(drawType == 0){

            canvas.drawRect(10, 10, 90, 90, createPaint(1));

        }
        else if(drawType == 1){

//            canvas.drawLine((float)dpToPx(10), (float)dpToPx(10), (float)dpToPx(140),(float)dpToPx(140), createPaint(2));

            float[] points = {dpToPx(10), dpToPx(10), dpToPx(50), dpToPx(50), dpToPx(50), dpToPx(50), dpToPx(100), dpToPx(50)};

            canvas.drawLines(points, createPaint(2));

        }
        else if(drawType == 2){

            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH){

                canvas.drawRoundRect(dpToPx(10), dpToPx(10), dpToPx(90), dpToPx(50), dpToPx(5), dpToPx(5), createPaint(0));

            }
            else {

                RectF rectf = new RectF();
                rectf.set(dpToPx(10), dpToPx(10), dpToPx(90), dpToPx(50));

                canvas.drawRoundRect(rectf, dpToPx(5), dpToPx(5), createPaint(0));

            }

        }
        else if(drawType == 3){

            canvas.drawCircle(dpToPx(60), dpToPx(60), dpToPx(50), createPaint(0));

        }
        else if(drawType == 4){

            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH){

                canvas.drawArc(dpToPx(10), dpToPx(10),dpToPx(90), dpToPx(90), 0, 100, true,  createPaint(0));

            }
            else {

                RectF rectF = new RectF();
                rectF.set(dpToPx(10), dpToPx(10),dpToPx(90), dpToPx(90));

                boolean useCenter = false; //true 绘制扇形， false 绘制弧形
                canvas.drawArc(rectF, 0, 100, useCenter, createPaint(1));

            }

        }
        else if(drawType == 5){

            RectF rectF = new RectF();
            rectF.set(dpToPx(10), dpToPx(10),dpToPx(90), dpToPx(50));

            canvas.drawOval(rectF, createPaint(0));

        }
        else if(drawType == 6){

            Path path = new Path();
            path.moveTo(dpToPx(0), dpToPx(0));
            path.lineTo(dpToPx(10), dpToPx(10));
            path.lineTo(dpToPx(10), dpToPx(50));
            path.lineTo(dpToPx(50), dpToPx(50));
            path.lineTo(dpToPx(20), dpToPx(30));

            canvas.drawPath(path, createPaint(0));

        }
        else if(drawType == 7){

            canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2 - 3, createPaint(0));

            for(int i = 0; i < 12; i++){

                if(i%3 == 0){

                    canvas.drawLine(getWidth()/2, getHeight()/2- getWidth()/2 + 3, getWidth()/2, getHeight()/2 - getWidth()/2 + dpToPx(10), createPaint(0));

                }
                else {

                    canvas.drawLine(getWidth()/2, getHeight()/2- getWidth()/2 + 3, getWidth()/2, getHeight()/2 - getWidth()/2 + dpToPx(5), createPaint(0));

                }

                canvas.rotate(30, getWidth()/2, getHeight()/2);

            }

            canvas.save();

            canvas.translate(getWidth()/2, getHeight()/2);

            canvas.drawLine(0, 0, dpToPx(30) , dpToPx(30), createPaint(2));
            canvas.drawLine(0, 0, dpToPx(15) , dpToPx(20), createPaint(2));

            canvas.restore();

        }
        else if(drawType == 8){

            canvas.drawCircle(getWidth()/3, getHeight()/3, getWidth()/3 - 3, createPaint(1));

            RectF rectF = new RectF();
            rectF.set(0, 0, getWidth() - 3*2, getHeight() - 3*2);

            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH){

                canvas.saveLayerAlpha(rectF, 127);

            }
            else {

                canvas.saveLayerAlpha(rectF, 0, LAYER_TYPE_NONE);

            }

            canvas.drawCircle(getWidth()*2/3, getHeight()*2/3, getWidth()/3 - 3, createPaint(1));

        }

    }

    public int getMeasureSize(int measure_size, int default_size){

        int result = default_size;

        int mode = MeasureSpec.getMode(measure_size);
        int size = MeasureSpec.getSize(measure_size);

        if(mode == MeasureSpec.EXACTLY){

            result = size;

        }
        else {

            if(mode == MeasureSpec.AT_MOST){

                result = Math.min(result, size);

            }

        }

        return result;

    }

    public int dpToPx(int dp_value){

        float scale = getContext().getResources().getDisplayMetrics().density;

        int result = (int)(dp_value*scale + 0.5f);

        return result;

    }

    public int pxToDp(int px_value){

        float scale = getContext().getResources().getDisplayMetrics().density;

        int result = (int)(px_value/scale + 0.5f);

        return result;

    }

    public Paint createPaint(int type){

        Paint paint = new Paint();

        if(type == 0){

            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3.0f);

        }
        else if(type == 1){

            paint.setAntiAlias(true);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);

        }
        else if(type == 2){

            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(3.0f);

        }

        return paint;

    }

}
