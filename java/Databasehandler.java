package com.example.telefonkayit;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class Databasehandler extends SQLiteOpenHelper {
	static int i = 0;
	public static String[] dizi = new String[5];
	public static String[] dizi2 = new String[5];
	public static String[] dizi3 = new String[5];
	public static int[] guc = new int[5];
	public static int[] guc2 = new int[5];
	public static int[] guc3 = new int[5];
 
    // T�m Static de�i�kenler
    // Database Versiyonu
    private static final int DATABASE_VERSION = 1;
 
    // Database Ad�
    private static final String DATABASE_NAME = "final";
 
    // Kisiler Tablosunun Ad�
    private static final String TABLE_NAME = "tuketim";
 
    // Kisiler Tablosunun Kolon Adlar�
    private static final String KEY_P = "p";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "ad";
    private static final String KEY_GROUP = "grup_tip";
    private static final String KEY_TUKETIM_GUC = "tuketim_guc";
 
    // Yap�land�r�c� metod
    public Databasehandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Database Olu�turma i�lemi.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TUKETIM_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_P + " INTEGER PRIMARY KEY,"
                + KEY_ID + " INTEGER,"
                + KEY_NAME + " TEXT,"
                + KEY_GROUP + " TEXT,"
                + KEY_TUKETIM_GUC + " INTEGER" + ")";
        db.execSQL(CREATE_TUKETIM_TABLE);
    }
 
    // Database Y�kseltme i�lemi.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * T�m CRUD(Create, Read, Update, Delete) i�lemleri
     */
 
    // Yeni Kay�t Eklemek.
    void addKisiler(Kisiler kisiler) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, kisiler.getID()); // ID Getir
        values.put(KEY_NAME, kisiler.getAd()); // Ad Getir
        values.put(KEY_GROUP, kisiler.getGrup()); // Grup Getir
        values.put(KEY_TUKETIM_GUC, kisiler.getTuketim()); // Tuketim Getir
 
        // Ekleme i�lemi...
        db.insert(TABLE_NAME, null, values);
        db.close(); // A��k olan database i kapat.
    }
 
    // �stenilen Kayd� Getirmek.
    Kisiler getKisiler(int p) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_P, KEY_ID,
                KEY_NAME, KEY_GROUP, KEY_TUKETIM_GUC }, KEY_ID + "=?",
                new String[] { String.valueOf(p) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Kisiler Kisiler = new Kisiler(Integer.parseInt(cursor.getString(0)),
        		Integer.parseInt(cursor.getString(1)),
                cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)));
        // return Kisiler
        return Kisiler;
    }
 
    // T�m Kayd� Getirmek.
    public List<Kisiler> getAllKisiler() {
        List<Kisiler> KisilerList = new ArrayList<Kisiler>();
        // T�m Kisiler Tablosunu Getir.
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // D�ng� Olu�turmak ve S�rasy�la Eklemek.
        if (cursor.moveToFirst()) {
            do {
                Kisiler Kisiler = new Kisiler();
                Kisiler.setP(Integer.parseInt(cursor.getString(0)));
                Kisiler.setID(Integer.parseInt(cursor.getString(1)));
                Kisiler.setAd(cursor.getString(2));
                Kisiler.setGrup(cursor.getString(3));
                Kisiler.setTuketim(Integer.parseInt(cursor.getString(4)));
                // Ki�ileri listeye eklemek.
                KisilerList.add(Kisiler);
            } while (cursor.moveToNext());
        }
 
        // return KisilerList
        return KisilerList;
    }
 
    // Kisiler Tablosunu G�ncellemek(Update)
    public int updateKisiler(Kisiler Kisiler) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, Kisiler.getID());
        values.put(KEY_NAME, Kisiler.getAd());
        values.put(KEY_GROUP, Kisiler.getGrup());
        values.put(KEY_TUKETIM_GUC, Kisiler.getTuketim());
 
        // updating row
        return db.update(TABLE_NAME, values, KEY_P + " = ?",
                new String[] { String.valueOf(Kisiler.getP()) });
    }
 
    // Kisiler Tablosundan Tek Kay�t Silmek(Delete)
    public void deleteKisiler(Kisiler Kisiler) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_P + " = ?",
                new String[] { String.valueOf(Kisiler.getP()) });
        db.close();
    }
 
    // Kisiler Tablosunun Kay�t Say�s�
    public int getKisilersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }

    public String[] getAllContacts() {
    	dizi[0] = "Y�ks�z";
    	guc[0] = 0;
        // T�m Kisiler Tablosunu Getir.
        String selectQuery = "SELECT ad, tuketim_guc FROM " + TABLE_NAME + " Where grup_tip = 'Kucuk Ev Aletleri'";
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        i = 1;
 
        // D�ng� Olu�turmak ve S�rasy�la Eklemek.
        if (cursor.moveToFirst()) {
            do {
                dizi[i] = cursor.getString(0);
                guc[i] = Integer.parseInt(cursor.getString(1));
                i++;
                // Ki�ileri listeye eklemek.
            } while (cursor.moveToNext());
        }
        // return KisilerList
        return dizi;
    }
    public String[] getAllContacts2() {
    	dizi2[0] = "Y�ks�z";
    	guc2[0] = 0;
        // T�m Kisiler Tablosunu Getir.
        String selectQuery = "SELECT ad, tuketim_guc FROM " + TABLE_NAME + " Where grup_tip = 'Eglence Grubu'";
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        i = 1;
 
        // D�ng� Olu�turmak ve S�rasy�la Eklemek.
        if (cursor.moveToFirst()) {
            do {
                dizi2[i] = cursor.getString(0);
                guc2[i] = Integer.parseInt(cursor.getString(1));
                i++;
                // Ki�ileri listeye eklemek.
            } while (cursor.moveToNext());
        }
        // return KisilerList
        return dizi2;
    }
    public String[] getAllContacts3() {
    	dizi3[0] = "Y�ks�z";
    	guc3[0] = 0;
        // T�m Kisiler Tablosunu Getir.
        String selectQuery = "SELECT ad, tuketim_guc FROM " + TABLE_NAME + " Where grup_tip = 'Agir Enerji Grubu'";
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        i = 1;
 
        // D�ng� Olu�turmak ve S�rasy�la Eklemek.
        if (cursor.moveToFirst()) {
            do {
                dizi3[i] = cursor.getString(0);
                guc3[i] = Integer.parseInt(cursor.getString(1));
                i++;
                // Ki�ileri listeye eklemek.
            } while (cursor.moveToNext());
        }
        // return KisilerList
        return dizi3;
    }
}