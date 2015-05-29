package com.example.telefonkayit;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class DBCreating extends Activity {
     
    private EditText _editTextId, _editTextAd, _editTextGrup, _editTextTuketim;
    private Button _buttonKaydet, _buttonKayitGetir;
    private TextView _textIdGoster, _textAdGoster, _textGrupGoster, _textTuketimGoster;
    private OnClickListener _buttonKaydetListener, _buttonKayitGetirListener;
     
    private Databasehandler _db;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbcreating);
 
        _db = new Databasehandler(this);
 
        setObjectsFromXML();
 
        // Kaydet butonu i�in onClickListener tan�ml�yoruz.
        _buttonKaydetListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // A�a��da tan�mlanan metodu �a��r�yoruz.
                yeniKisiEkle();
            }
        };
        // Tan�mlad���m�z onClickListener i kaydet butonuna set ediyoruz.
        _buttonKaydet.setOnClickListener(_buttonKaydetListener);
 
        // Kay�t getir butonu i�in onClickListener tan�ml�yoruz.
        _buttonKayitGetirListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // A�a��da tan�mlanan metodu �a��r�yoruz.
                kayitlariGetir();
            }
        };
        // Tan�mlad���m�z onClickListener i kayit getir butonuna set ediyoruz.
        _buttonKayitGetir.setOnClickListener(_buttonKayitGetirListener);
 
    }
 
    /**
     * XML de bulunan t�m objeleri tan�ml�yoruz.
     * (onCreate metodunun i�inde �ok kar���k olmamas� 
     * i�in bir metodun i�ine ald�k)
     **/
    public void setObjectsFromXML(){
    	_editTextId = (EditText) findViewById(R.id.editText_ID);
        _editTextAd = (EditText) findViewById(R.id.editText_Ad);
        _editTextGrup = (EditText) findViewById(R.id.editText_Grup);
        _editTextTuketim = (EditText) findViewById(R.id.editText_Tuketim);
        _buttonKaydet = (Button) findViewById(R.id.button_Kaydet);
        _buttonKayitGetir = (Button) findViewById(R.id.button_Goster);
        _textIdGoster = (TextView) findViewById(R.id.textViewIdGoster);
        _textAdGoster = (TextView) findViewById(R.id.textViewAdGoster);
        _textGrupGoster = (TextView) findViewById(R.id.textViewGrupGoster);
        _textTuketimGoster = (TextView) findViewById(R.id.textViewTuketimGoster);
    }
 
    /**
     * Yeni Ki�i Eklemek.
     **/
    public void yeniKisiEkle(){
        _db.addKisiler(new Kisiler(Integer.parseInt(_editTextId.getText().toString()),_editTextAd.getText().toString(), _editTextGrup.getText().toString(), Integer.parseInt(_editTextTuketim.getText().toString())));
    }
 
    /**
     * T�m Kay�tlar� Getirmek.
     **/
    public void kayitlariGetir(){
    	_textIdGoster.setText("ID");
        _textAdGoster.setText("AD");
        _textGrupGoster.setText("GRUP");
        _textTuketimGoster.setText("TUKETIM");
 
        List<Kisiler> kisiler = _db.getAllKisiler();
        for (Kisiler k : kisiler) {
        	_textIdGoster.setText(_textIdGoster.getText().toString() + "\n" + k.getID());
            _textAdGoster.setText(_textAdGoster.getText().toString() + "\n" + k.getAd());
            _textGrupGoster.setText(_textGrupGoster.getText().toString() + "\n" + k.getGrup());
            _textTuketimGoster.setText(_textTuketimGoster.getText().toString() + "\n" + k.getTuketim());
             
        }
    }
}