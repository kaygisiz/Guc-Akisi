package com.example.telefonkayit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
 
class DrawLine extends View {
	DrawLine drawline;
    Paint paint = new Paint();
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();
    static int konum = 300, konum2 = 220, konum3 = 140, konum4=500,konum5=560,konum6=620, 
    		konum7=530,konum8=590,konum9=650, konum10=500, konum11=500, konum12 = 570
    		, konum13 = 640, konum14=140, konum15=220, konum16=300, konum17=50
    		, konum18=125, konum19=380;
    public DrawLine(Context context) {
        super(context);
        
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        
    }
	@Override
    public void dispatchDraw(Canvas canvas) {
    	super.dispatchDraw(canvas);
    	  paint.setColor(Color.BLACK);
    	  paint2.setColor(Color.BLUE);
          paint.setStrokeWidth(2);
          paint2.setStrokeWidth(2);
          paint3.setColor(Color.rgb(230, 230, 12));
          paint3.setStrokeWidth(2);
    	canvas.drawColor(Color.TRANSPARENT);
    	canvas.drawLine(0, 100, 5, 100, paint);
        canvas.drawRect(5, 50, 100, 130, paint); // trafo
        canvas.drawLine(50, 400, 200, 400, paint); //trafo - sayaç
        canvas.drawLine(50, 130, 50, 400, paint);
        
        if(MainActivity.d == true){
        canvas.drawLine(35, konum14, 50, konum14+25, paint3);
    	canvas.drawLine(65, konum14, 50, konum14+25, paint3);
    	canvas.drawLine(35, konum14, 50, konum14+10, paint3);
    	canvas.drawLine(65, konum14, 50, konum14+10, paint3);

    	canvas.drawLine(35, konum15, 50, konum15+25, paint3);
    	canvas.drawLine(65, konum15, 50, konum15+25, paint3);
    	canvas.drawLine(35, konum15, 50, konum15+10, paint3);
    	canvas.drawLine(65, konum15, 50, konum15+10, paint3);
    	
    	canvas.drawLine(35, konum16, 50, konum16+25, paint3);
    	canvas.drawLine(65, konum16, 50, konum16+25, paint3);
    	canvas.drawLine(35, konum16, 50, konum16+10, paint3);
    	canvas.drawLine(65, konum16, 50, konum16+10, paint3);
        
    	canvas.drawLine(konum17,385,konum17+25,400,paint3);
        canvas.drawLine(konum17,415,konum17+25,400,paint3);
        canvas.drawLine(konum17,385,konum17+10,400,paint3);
        canvas.drawLine(konum17,415,konum17+10,400,paint3);
        
        canvas.drawLine(konum18,385,konum18+25,400,paint3);
        canvas.drawLine(konum18,415,konum18+25,400,paint3);
        canvas.drawLine(konum18,385,konum18+10,400,paint3);
        canvas.drawLine(konum18,415,konum18+10,400,paint3);
        }
        
    	paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(292, 395, 90, paint); // sayaç
        canvas.drawLine(380, 400, 420, 400, paint); // sayaç-sigorta arasý
        
        if(MainActivity.d == true){
        canvas.drawLine(konum19,385,konum19+25,400,paint3);
        canvas.drawLine(konum19,415,konum19+25,400,paint3);
        canvas.drawLine(konum19,385,konum19+10,400,paint3);
        canvas.drawLine(konum19,415,konum19+10,400,paint3);
        }
        
        canvas.drawRect(420, 300, 550, 500, paint); //sigorta
        
        if(MainActivity.a == true){
        canvas.drawLine(485, 300, 485, 70, paint2);
        canvas.drawLine(485, 70, 700, 70, paint2); // sigorta - image 1
        }
        else{
        canvas.drawLine(485, 300, 485, 70, paint); // sigorta - image1
        canvas.drawLine(485, 70, 700, 70, paint); // sigorta - image 1
        	
        //yýldýz1
        canvas.drawLine(485, konum, 500, konum+25, paint3);
        canvas.drawLine(470, konum+25, 485, konum, paint3);
        canvas.drawLine(470, konum+25, 485, konum+20, paint3);
        canvas.drawLine(500, konum+25, 485, konum+20, paint3);
        //yýldýz2
        canvas.drawLine(485, konum2, 500, konum2+25, paint3);
        canvas.drawLine(470, konum2+25, 485, konum2, paint3);
        canvas.drawLine(470, konum2+25, 485, konum2+20, paint3);
        canvas.drawLine(500, konum2+25, 485, konum2+20, paint3);
        //yýldýz3
        canvas.drawLine(485, konum3, 500, konum3+25, paint3);
        canvas.drawLine(470, konum3+25, 485, konum3, paint3);
        canvas.drawLine(470, konum3+25, 485, konum3+20, paint3);
        canvas.drawLine(500, konum3+25, 485, konum3+20, paint3);
        
        //yýldýz4
        canvas.drawLine(konum4,55,konum4+25,70,paint3);
        canvas.drawLine(konum4,85,konum4+25,70,paint3);
        canvas.drawLine(konum4,55,konum4+10,70,paint3);
        canvas.drawLine(konum4,85,konum4+10,70,paint3);
        //yýldýz5
        canvas.drawLine(konum5,55,konum5+25,70,paint3);
        canvas.drawLine(konum5,85,konum5+25,70,paint3);
        canvas.drawLine(konum5,55,konum5+10,70,paint3);
        canvas.drawLine(konum5,85,konum5+10,70,paint3);
        //yýldýz6
        canvas.drawLine(konum6,55,konum6+25,70,paint3);
        canvas.drawLine(konum6,85,konum6+25,70,paint3);
        canvas.drawLine(konum6,55,konum6+10,70,paint3);
        canvas.drawLine(konum6,85,konum6+10,70,paint3);
        }
        if(MainActivity.b == true){
        	canvas.drawLine(550,400,700,400,paint2); // sigorta - image2
        }
        else{
        canvas.drawLine(550,400,700,400,paint); // sigorta - image2
        //yýldýz1
        canvas.drawLine(konum7,385,konum7+25,400,paint3);
        canvas.drawLine(konum7,415,konum7+25,400,paint3);
        canvas.drawLine(konum7,385,konum7+10,400,paint3);
        canvas.drawLine(konum7,415,konum7+10,400,paint3);
        //yýldýz2
        canvas.drawLine(konum8,385,konum8+25,400,paint3);
        canvas.drawLine(konum8,415,konum8+25,400,paint3);
        canvas.drawLine(konum8,385,konum8+10,400,paint3);
        canvas.drawLine(konum8,415,konum8+10,400,paint3);
        //yýldýz3
        canvas.drawLine(konum9,385,konum9+25,400,paint3);
        canvas.drawLine(konum9,415,konum9+25,400,paint3);
        canvas.drawLine(konum9,385,konum9+10,400,paint3);
        canvas.drawLine(konum9,415,konum9+10,400,paint3);
        }
        if(MainActivity.c == true){
        canvas.drawLine(485, 500, 485, 550, paint2); // sigorta - image3
        canvas.drawLine(485, 550, 700, 550, paint2);
        }
        else{
        	canvas.drawLine(485, 500, 485, 550, paint); // sigorta - image3
        	canvas.drawLine(485, 550, 700, 550, paint);
        	//yýldýz10
        	canvas.drawLine(470, konum10, 485, konum10+25, paint3);
        	canvas.drawLine(500, konum10, 485, konum10+25, paint3);
        	canvas.drawLine(470, konum10, 485, konum10+10, paint3);
        	canvas.drawLine(500, konum10, 485, konum10+10, paint3);

            //yýldýz11
            canvas.drawLine(konum11,535,konum11+25,550,paint3);
            canvas.drawLine(konum11,565,konum11+25,550,paint3);
            canvas.drawLine(konum11,535,konum11+10,550,paint3);
            canvas.drawLine(konum11,565,konum11+10,550,paint3);
            //yýldýz12
            canvas.drawLine(konum12,535,konum12+25,550,paint3);
            canvas.drawLine(konum12,565,konum12+25,550,paint3);
            canvas.drawLine(konum12,535,konum12+10,550,paint3);
            canvas.drawLine(konum12,565,konum12+10,550,paint3);
            //yýldýz13
            canvas.drawLine(konum13,535,konum13+25,550,paint3);
            canvas.drawLine(konum13,565,konum13+25,550,paint3);
            canvas.drawLine(konum13,535,konum13+10,550,paint3);
            canvas.drawLine(konum13,565,konum13+10,550,paint3);
        }
    }
 
}