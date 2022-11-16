package com.example.idnp_lab06;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GraficoBarrasVista extends View {

    private ArrayList<String> listaPais = new ArrayList<>();
    private ArrayList<Double> listaTNatalidad = new ArrayList<>();
    private int limiteMaximo;

    public GraficoBarrasVista(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.limiteMaximo = Integer.MAX_VALUE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ingresandoDatos();

        //pintar fondo
        canvas.drawRGB(240, 240, 240);

        //recibiendo el ancho y alto
        int ancho = getWidth();
        int alto = getHeight();

        Paint pincel1 = new Paint();
        pincel1.setColor(Color.RED);

        Paint pincel2 = new Paint();
        pincel2.setColor(Color.BLACK);
        pincel2.setStrokeWidth(3);

        //solo texto
        pincel2.setTextSize(40);

        canvas.drawText("Tasa de Natalidad", 0.25f*ancho,
                0.1f*alto, pincel2);

        //solo texto
        pincel2.setTextSize(22);

        //lineas de grafico de barras***************************************************
        canvas.drawLine(0.15f*ancho, 0.2f*alto, 0.15f*ancho, 0.8f*alto, pincel2);
        canvas.drawLine(0.15f*ancho, 0.8f*alto, 0.85f*ancho, 0.8f*alto, pincel2);

        //lineas de medicion de la grafica***********************************************
        pincel2.setStrokeWidth(1);
        for (int i = 0; i < 10; i++){
            float yLine = 0.2f*alto + (0.06f)*alto*(i);
            //numeros de la eje y
            canvas.drawText(""+(limiteMaximo/10)*(10-i), 0.1f*ancho, yLine, pincel2);

            canvas.drawLine(0.15f*ancho, yLine,
                    0.85f*ancho, yLine,
                    pincel2);
        }

        //leyenda***********************************************
        canvas.drawRect(0.34f*ancho,0.92f*alto,
                0.36f*ancho, 0.94f*alto, pincel1);
        canvas.drawText("Tasa de Natalidad", 0.38f*ancho,
                0.94f*alto, pincel2);

        //****************************************************
        //creando las barras y etiquetas
        float parts = (0.70f*ancho)/((float)listaPais.size()*2 + 1f);

        float espacios = parts;

        for (int i = 0; i < listaPais.size(); i++) {
            //Texto-Primeras tres letras
            canvas.drawText(listaPais.get(i), 0,3,0.15f*ancho +espacios, 0.85f*alto, pincel2);
            //barras
            canvas.drawRect(0.15f*ancho + espacios,
                    0.8f*alto-(0.6f*alto*listaTNatalidad.get(i).floatValue()/limiteMaximo),
                    0.15f*ancho + espacios+parts, 0.8f*alto, pincel1);
            espacios += parts*2;
        }
        //****************************************************
    }


    public void ingresandoDatos(){
        //INGRESO DE DATOS
        //limite maximo del eje Y
        limiteMaximo = 50;

        //datos del excel
        this.listaPais.add("Argentina");
        this.listaTNatalidad.add(20.7);

        this.listaPais.add("Bolivia");
        this.listaTNatalidad.add(46.6);

        this.listaPais.add("Brasil");
        this.listaTNatalidad.add(28.6);

        this.listaPais.add("Canada");
        this.listaTNatalidad.add(14.5);

        this.listaPais.add("Chile");
        this.listaTNatalidad.add(23.4);

        this.listaPais.add("Colombia");
        this.listaTNatalidad.add(27.4);

        this.listaPais.add("Ecuador");
        this.listaTNatalidad.add(32.9);

        this.listaPais.add("Guyana");
        this.listaTNatalidad.add(28.3);

        this.listaPais.add("Mexico");
        this.listaTNatalidad.add(29.0);

        this.listaPais.add("Paraguay");
        this.listaTNatalidad.add(34.8);

        this.listaPais.add("Peru");
        this.listaTNatalidad.add(32.9);

        this.listaPais.add("USA");
        this.listaTNatalidad.add(16.7);

        this.listaPais.add("Uruguay");
        this.listaTNatalidad.add(18.0);

        this.listaPais.add("Venezuela");
        this.listaTNatalidad.add(27.5);

    }
}
