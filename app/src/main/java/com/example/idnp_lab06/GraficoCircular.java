package com.example.idnp_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GraficoCircular extends AppCompatActivity {

    double[] val ={20.7,46.6,28.6,14.5,23.4,27.4,32.9,28.3,29,34.8,32.9,16.7,18,27.5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_circular);
        LinearLayout linear=(LinearLayout) findViewById(R.id.linear);
        val=calculateData(val);
        linear.addView(new MyGraphview(this, val));
    }
    private double[] calculateData(double[] data) {
        // TODO Auto-generated method stub
        float total=0;
        for(int i=0;i<data.length;i++)
        {
            total+=data[i];
        }
        for(int i=0;i<data.length;i++)
        {
            data[i]=360*(data[i]/total);
        }
        return data;

    }
    public static class MyGraphview extends View
    {
        private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        private float[] value_degree;
        private final int[] COLORS={Color.BLUE,Color.GREEN,Color.GRAY,Color.CYAN,Color.RED,Color.MAGENTA,Color.YELLOW,Color.BLACK,Color.BLUE,Color.GREEN,Color.GRAY,Color.CYAN,Color.RED,Color.MAGENTA};
        RectF rectf = new RectF (50, 50, 1000, 1000);
        float temp=0;
        public MyGraphview(Context context, double[] values) {

            super(context);
            value_degree=new float[values.length];
            for(int i=0;i<values.length;i++)
            {
                value_degree[i]= (float) values[i];
            }
        }
        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);

            for (int i = 0; i < value_degree.length; i++) {
                if (i == 0) {
                    paint.setColor(COLORS[i]);
                    canvas.drawArc(rectf, 0, value_degree[i], true, paint);
                }
                else
                {
                    temp +=  value_degree[i - 1];
                    paint.setColor(COLORS[i]);
                    canvas.drawArc(rectf, temp, value_degree[i], true, paint);
                }
            }
        }

    }
}