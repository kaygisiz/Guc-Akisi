package com.example.telefonkayit;

import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity implements OnItemSelectedListener {
    private Spinner spinner1,spinner2,spinner3;
    private ImageView i1,i2,i3;
    DrawLine drawLine;
    Paint paint = new Paint();
    public static FrameLayout frame;
    public static boolean a = true, b=true, c=true, d=true, pause=true
    		, agecici=true, bgecici=true, cgecici=true;
    public TextView textview, textview2;
    public float sayac_sn=0, sp1=0, sp2=0, sp3=0, spt=0, sira;
    public int sayac_tl=0;
    public Button buton_bs,buton_dr,buton_sf;
    final Handler handler = new Handler();
    Timer timer = new Timer(false);
    Timer timer2 = new Timer(false);

  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //olu�turdu�umuz spinner, imageview, frame, textview ve button
        //de�i�kenlerini xml'dekilerle e�le�tirdik
    	spinner1 = (Spinner) findViewById(R.id.spinner1);
    	spinner2 = (Spinner) findViewById(R.id.spinner2);
    	spinner3 = (Spinner) findViewById(R.id.spinner3);
    	i1 = (ImageView) findViewById(R.id.imageView1);
    	i2 = (ImageView) findViewById(R.id.imageView2);
    	i3 = (ImageView) findViewById(R.id.imageView3);
    	frame=(FrameLayout) findViewById(R.id.frame);
    	textview = (TextView) findViewById(R.id.textView4);
    	textview2 = (TextView) findViewById(R.id.textView5);
    	buton_bs = (Button) findViewById(R.id.button2);
    	buton_dr = (Button) findViewById(R.id.button3);
    	buton_sf = (Button) findViewById(R.id.button4);
        //olu�turdu�um timer '�n saniyede bir �al��mas�n� sa�lad�m
    	timer.schedule(timerTask, 0 ,1000);
    	//timer2 'nin ise 10 milisaniyede bir �al��mas�n� sa�lad�m
        timer2.schedule(timerTask2, 0 ,10);
		//DrawLine s�n�f�mdan bir nesne olu�turdum
        drawLine = new DrawLine(this);
		
        //Databasehandler s�n�f�mdan bir nesne olu�turdum
		Databasehandler dbh = new Databasehandler(MainActivity.this);
    	
		//bir arrayadapter<string> olu�turuyoruz ve daha �nce olu�turdu�um databasehandler
		//nesnesine ait olan getAllContacts fonksiyonlar�yla veritaban�mdan ilgili de�erleri
		//al�p spinner'lara item olarak at�yoruz
    	final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
    			R.layout.diziler, dbh.getAllContacts());
    	final ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
    			R.layout.diziler, dbh.getAllContacts2());
    	final ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this,
    			R.layout.diziler, dbh.getAllContacts3());
    			spinner1.setOnItemSelectedListener(this);
    			spinner1.setAdapter(arrayAdapter);    			
    			spinner2.setOnItemSelectedListener(this);
    			spinner2.setAdapter(arrayAdapter2);    			
    			spinner3.setOnItemSelectedListener(this);
    			spinner3.setAdapter(arrayAdapter3);
    			//olu�turdu�umuz drawline nesnesi sayesinde drawline'da yapm��
    			//oldu�umuz �izimleri view olarak frame'e �izdiyoruz
    			frame.addView(drawLine);
    	
    	//Sayac� durduracak ve g�� ak���n� kesecek i�lemleri bu butona clicklistener
    	//ile yerle�tiriyoruz
    	buton_dr.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
            	//a, b ve c 'nin durdurulmadan �nceki de�erlerini al�yoruz ve
            	//yeniden ba�latt���m�zda kald�klar� yerden devam etmelerini sa�l�yoruz
            	agecici = a;
            	bgecici = b;
            	cgecici = c;
            	//bu de�i�kenler true oldu�unda DrawLine'daki if kontrol�m�z sayesinde
            	//g�� ak��� kesilmi� oluyor
            	a=true;
            	b=true;
            	c=true;
            	d=false;
            	pause = false;
            	//butona t�kland���nda g�r�n�rl���n� false yap�yoruz
                buton_dr.setVisibility(View.INVISIBLE);
            }
        });
    	buton_bs.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
            	//durdur butonumuza bast���m�zda al�nan eski de�erleri burada tekrar
            	//at�yoruz
            	a=agecici;
            	b=bgecici;
            	c=cgecici;
            	d=true;
            	pause = true;
            	//ve durdur butonumuzu tekrar g�r�n�r yap�yoruz
            	buton_dr.setVisibility(View.VISIBLE);
            }
        });
    	buton_sf.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
            	agecici = a;
            	bgecici = b;
            	cgecici = c;
            	d=false;
            	a=true;
            	b=true;
            	c=true;
            	pause = false;
            	//s�f�rla butonumuzda ekstra olarak sayac�m�zda yaz�lan de�eri
            	//s�f�rl�yoruz ve setText ile yazd�r�yoruz
            	spt = 0;
            	buton_dr.setVisibility(View.VISIBLE);
            	textview.setText(spt + " kWh");     			
            	textview2.setText(spt + " TL");
            }
        });
    	
    	//timer'lar�m�z� ba�lat�yoruz
        timerTask.run();
        timerTask2.run();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void CallSecondActivity(View v){
    	//CallSecondActivity click 'i ile DBCreating layout 'umuzu �a��r�yoruz
    	Intent i = new Intent(this, DBCreating.class);
    	startActivity(i);    
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
    long arg3) {
    	//buradaki switch-case yap�m�z sayesinde hangi spinner '�m�zda i�lem yap�l�yorsa
    	//onu belirleyip sadece orada i�lem yap�yoruz
    	switch(arg0.getId()){
    	//spinner1 id li spinner se�ildiyse vs
    	case R.id.spinner1:
    //spinner 'da se�ilen de�eri string de�ere �evirip at�yoruz
    String secilenDeger = spinner1.getItemAtPosition(position).toString();
    //spinner de�erlerini de veritaban�ndan �ekip atad���m�z dizimizden �a��r�yoruz
    if(secilenDeger.equals(Databasehandler.dizi[1]))
    {
    	//bu eleman�n t�ketti�i g�c� veritaban�ndan al�yoruz ve sp1 de�i�kenine at�yoruz
    	sp1 = Databasehandler.guc[1];
    	//a bool'unu y�ks�z harici elemanlarda false yap�yoruz y�ks�z de true yap�yoruz
    	//drawline'da true ise devre mavi oluyor de�ilse siyah
    	a=false;
    	//eleman�n resmini biz at�yoruz
    	i1.setImageResource(R.drawable.utu);			   
    }
    else if(secilenDeger.equals(Databasehandler.dizi[2]))
    {
    	sp1 = Databasehandler.guc[2];
    	a=false;
    	i1.setImageResource(R.drawable.fan);
    }
    else if(secilenDeger.equals(Databasehandler.dizi[3]))
    {
    	sp1 = Databasehandler.guc[3];
    	a=false;
    	i1.setImageResource(R.drawable.sac);
    }
    else if(secilenDeger.equals(Databasehandler.dizi[4]))
    {
    	sp1 = Databasehandler.guc[4];
    	a=false;
    	i1.setImageResource(R.drawable.mikrodalga);
    }
    else if(secilenDeger.equals("Y�ks�z"))
    {
    	sp1 = Databasehandler.guc[0];
    	i1.setImageResource(0);
    	a = true;
    }
    break;
    	case R.id.spinner2:
    String secilenDeger2 = spinner2.getItemAtPosition(position).toString();
    if(secilenDeger2.equals(Databasehandler.dizi2[1]))
    {
    	sp2 = Databasehandler.guc2[1];
    	b=false;
    	i2.setImageResource(R.drawable.televizyon);
    }
    else if(secilenDeger2.equals(Databasehandler.dizi2[2]))
    {
    	sp2 = Databasehandler.guc2[2];
    	b=false;
    	i2.setImageResource(R.drawable.ses);
    }
    else if(secilenDeger2.equals(Databasehandler.dizi2[3]))
    {
    	sp2 = Databasehandler.guc2[3];
    	b=false;
    	i2.setImageResource(R.drawable.bilgisayar);
    }
    else if(secilenDeger2.equals(Databasehandler.dizi2[4]))
    {
    	sp2 = Databasehandler.guc2[4];
    	b=false;
    	i2.setImageResource(R.drawable.playstation);
    }
    else if(secilenDeger2.equals("Y�ks�z"))
    {
    	sp2 = Databasehandler.guc2[0];
    	b=true;
    	i1.setImageResource(0);
    }
    break;
    	case R.id.spinner3:
    String secilenDeger3 = spinner3.getItemAtPosition(position).toString();
    if(secilenDeger3.equals(Databasehandler.dizi3[1]))
    {
    	sp3 = Databasehandler.guc3[1];
    	c=false;
    	i3.setImageResource(R.drawable.bulasik);
    }
    else if(secilenDeger3.equals(Databasehandler.dizi3[2]))
    {
    	sp3 = Databasehandler.guc3[2];
    	c=false;
    	i3.setImageResource(R.drawable.camasir);
    }
    else if(secilenDeger3.equals(Databasehandler.dizi3[3]))
    {
    	sp3 = Databasehandler.guc3[3];
    	c=false;
    	i3.setImageResource(R.drawable.kurutma);
    }
    else if(secilenDeger3.equals(Databasehandler.dizi3[4]))
    {
    	sp3 = Databasehandler.guc3[4];
    	c=false;
    	i3.setImageResource(R.drawable.buzdolabi);
    }
    else if(secilenDeger3.equals("Y�ks�z"))
    {
    	sp3 = Databasehandler.guc3[0];
    	c=true;
    	i3.setImageResource(0);
    }
    break;
    	}
    	
    }
    

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                	//pause false ise durdur butonuna bas�lm�� demektir
                	//o y�zden saya�lar�m�z� artt�rmamak i�in b�yle bir if yap�m�z var
                	if(pause == true){
                	//spinnerlarda se�ilen elemanlar�n g��lerini toplay�p spt 'ye at�yoruz
                	spt = sp1/10000 + sp2/10000 + sp3/10000 +spt;
                	sayac_sn = spt;
                	sayac_tl = (int) spt;
                	textview.setText(sayac_sn + " kWh");        			
                	textview2.setText(sayac_tl + " TL");
                }
            }});
        }
    };
    TimerTask timerTask2 = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                	//oklar�n dikeyse y'sini yataysa x'ini her saniye de�i�tirerek
                	//hareket etmesini sa�l�yoruz belli bi noktadan sonra if ler ile
                	//tekrar ba�a d�n�p ayn� do�rultuda s�rekli hareket etmesini sa�l�yoruz
                	if(DrawLine.konum == 70){
                		DrawLine.konum = 300;
                	}
                	if(DrawLine.konum2 == 70){
                		DrawLine.konum2 = 300;
                	}
                	if(DrawLine.konum3 == 70){
                		DrawLine.konum3 = 300;
                	}
                	if(DrawLine.konum4 == 690){
                		DrawLine.konum4 = 500;
                	}
                	if(DrawLine.konum5 == 690){
                		DrawLine.konum5 = 500;
                	}
                	if(DrawLine.konum6 == 690){
                		DrawLine.konum6 = 500;
                	}
                	if(DrawLine.konum7 == 690){
                		DrawLine.konum7 = 530;
                	}
                	if(DrawLine.konum8 == 690){
                		DrawLine.konum8 = 530;
                	}
                	if(DrawLine.konum9 == 690){
                		DrawLine.konum9 = 530;
                	}
                	if(DrawLine.konum10 == 525){
                		DrawLine.konum10 = 500;
                	}
                	if(DrawLine.konum11 == 690){
                		DrawLine.konum11 = 490;
                	}
                	if(DrawLine.konum12 == 690){
                		DrawLine.konum12 = 490;
                	}
                	if(DrawLine.konum13 == 690){
                		DrawLine.konum13 = 490;
                	}
                	if(DrawLine.konum14 == 385){
                		DrawLine.konum14 = 130;
                	}
                	if(DrawLine.konum15 == 385){
                		DrawLine.konum15 = 130;
                	}
                	if(DrawLine.konum16 == 385){
                		DrawLine.konum16 = 130;
                	}
                	if(DrawLine.konum17 == 190){
                		DrawLine.konum17 = 50;
                	}
                	if(DrawLine.konum18 == 190){
                		DrawLine.konum18 = 50;
                	}
                	if(DrawLine.konum19 == 405){
                		DrawLine.konum19 = 380;
                	}
                	else{
                	//burada her saniye konumlar� de�i�tiriyoruz
                	DrawLine.konum-=1;
                	DrawLine.konum2-=1;
                	DrawLine.konum3-=1;
                	DrawLine.konum4+=1;
                	DrawLine.konum5+=1;
                	DrawLine.konum6+=1;
                	DrawLine.konum7+=1;
                	DrawLine.konum8+=1;
                	DrawLine.konum9+=1;
                	DrawLine.konum10+=1;
                	DrawLine.konum11+=1;
                	DrawLine.konum12+=1;
                	DrawLine.konum13+=1;
                	DrawLine.konum14+=1;
                	DrawLine.konum15+=1;
                	DrawLine.konum16+=1;
                	DrawLine.konum17+=1;
                	DrawLine.konum18+=1;
                	DrawLine.konum19+=1;
                	//burada removeAllViews yaparsak e�er saya�lar da frame 'in i�erisinde
                	//oldu�u i�in onlar da siliniyor bu y�zden sadece drawline �izimlerini
                	// silip tekrar ekliyoruz yani her saniye yenilemi� oluyoruz
                	frame.removeView(drawLine);
                	frame.addView(drawLine);
                	}
                }
            });
        }
    };
    
    
}
