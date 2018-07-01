package com.example.user.eduplus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Tablename = "JOURNALAPP";
    private static final String column1= "id";
    private static final String column2 = "TITLE";
    private static final String column3 = "JOURNALMSG";
    private static final String column4 = "EMAILADDRESS";

    public DatabaseHelper(Context context) {
        super(context, Tablename, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tablename + "( "
                + column1 + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + column2 + " TEXT, "
                + column3 + " TEXT, "
                + column4 + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tablename);
        onCreate(db);
    }
    public boolean AddData(String item,String item1,String item2){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column2,item);
        contentValues.put(column3,item1);
        contentValues.put(column4,item2);
        long result = db.insert(Tablename,null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ Tablename;
        Cursor data = db.rawQuery(query,null);
        return data;


    }
}
