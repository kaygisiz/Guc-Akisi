package com.example.telefonkayit;

public class Kisiler {
	 
    // Private de�i�kenler
	int _p;
    int _id;
    String _ad;
    String _grup;
    int _tuketim;
 
    // Varsay�lan Yap�land�r�c� Metod
    public Kisiler(){
 
    }
    // Yap�land�r�c� Metod
    public Kisiler(int p, int id, String ad, String grup, int tuketim){
    	this._p = p;
        this._id = id;
        this._ad = ad;
        this._grup = grup;
        this._tuketim = tuketim;
    }
 
    // Yap�land�r�c� Metod
    public Kisiler(int id, String ad, String grup, int tuketim){
    	this._id = id;
        this._ad = ad;
        this._grup = grup;
        this._tuketim = tuketim;
    }
 
    // ID yi belirle.
    public void setP(int p){
        this._p = p;
    }
    // ID yi getir.
    public int getP(){
        return this._p;
    } 
 // ID belirle.
    public void setID(int id){
        this._id = id;
    }
    // ID getir.
    public int getID(){
        return this._id;
    }
    // Ad� belirle.
    public String setAd(String ad){
        this._ad = ad;
        return this._ad;
    }
    // Ad� getir.
    public String getAd(){
        return this._ad;
    }
 
    // Soyad� belirle.
    public void setGrup(String grup){
        this._grup = grup;
    }
    // Soyad� getir.
    public String getGrup(){
        return this._grup;
    }
 
    // Telefon numar�s�n� belirle.
    public void setTuketim(int tuketim){
        this._tuketim = tuketim;
    }
    // Telefon numaras�n� getir.
    public int getTuketim(){
        return this._tuketim;
    }
}