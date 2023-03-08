package com.if4a.football_player;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String DATABASE_NAME ="db_football";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME ="tbl_player";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAMA = "nama";
    private static final String FIELD_NOMOR = "nomor";
    private static final String FIELD_KLUB = "klub";

    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FIELD_NAMA + " VARCHAR(50), " +
                FIELD_NOMOR + " VARCHAR(2), " +
                FIELD_KLUB + " VARCHAR(50)" +
                ");"
                ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public long tambahPlayer(String nama, String nomor, String klub){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIELD_NAMA, nama);
        cv.put(FIELD_NOMOR, nomor);
        cv.put(FIELD_KLUB, klub);

        long eksekusi = db.insert(TABLE_NAME,null,cv);
        return eksekusi;

    }
}