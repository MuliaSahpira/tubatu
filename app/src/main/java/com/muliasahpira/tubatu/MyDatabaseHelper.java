package com.muliasahpira.tubatu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String DATABASE_NAME = "db_idol";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tbl_idol";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAMA = "nama";
    private static final String FIELD_TANGGAL = "tanggal";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "( " +
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_NAMA + " VARCHAR(50), " +
                FIELD_TANGGAL + " VARCHAR(20)" +
                ");"
                ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public long tambahIdol(String nama, String tanggal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIELD_NAMA, nama);
        cv.put(FIELD_TANGGAL, tanggal);

        long eksekusi = db.insert(TABLE_NAME, null, cv);
        return eksekusi;
    }

    public Cursor bacaDataPlayer(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor varCursor = null;
        if (db != null){
            varCursor = db.rawQuery(query, null);
        }
        return varCursor;
    }
}
