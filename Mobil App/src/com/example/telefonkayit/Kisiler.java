package com.example.telefonkayit;

public class Kisiler {
	 
    // Private deðiþkenler
	int _p;
    int _id;
    String _ad;
    String _grup;
    int _tuketim;
 
    // Varsayýlan Yapýlandýrýcý Metod
    public Kisiler(){
 
    }
    // Yapýlandýrýcý Metod
    public Kisiler(int p, int id, String ad, String grup, int tuketim){
    	this._p = p;
        this._id = id;
        this._ad = ad;
        this._grup = grup;
        this._tuketim = tuketim;
    }
 
    // Yapýlandýrýcý Metod
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
    // Adý belirle.
    public String setAd(String ad){
        this._ad = ad;
        return this._ad;
    }
    // Adý getir.
    public String getAd(){
        return this._ad;
    }
 
    // Soyadý belirle.
    public void setGrup(String grup){
        this._grup = grup;
    }
    // Soyadý getir.
    public String getGrup(){
        return this._grup;
    }
 
    // Telefon numarýsýný belirle.
    public void setTuketim(int tuketim){
        this._tuketim = tuketim;
    }
    // Telefon numarasýný getir.
    public int getTuketim(){
        return this._tuketim;
    }
}