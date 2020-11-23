package com.example.learnsqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class data extends SQLiteOpenHelper {
    Context m_context;
    public static String m_data="TK";
    public data(@Nullable Context context) {
        super(context, m_data, null, 1);
        m_context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "create table TK( tk text primary key, mk text)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="DROP TABLE IF EXISTS taikhoan";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void Them(String _tk, String _mk)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tk", _tk);
        values.put("mk", _mk);
        db.insert("TK", null, values);
        db.close();

    }

    public List<TK> Show()
    {

        List<TK> L_tk = new ArrayList<>();
        String sql = "Select * from TK";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor m_cursor = db.rawQuery(sql, null);
        m_cursor.moveToFirst();

        while (!m_cursor.isAfterLast())
        {
            TK m_tk = new TK();
        m_tk.tk = m_cursor.getString(m_cursor.getColumnIndex("tk"));
        m_tk.mk = m_cursor.getString(m_cursor.getColumnIndex("mk"));
            Toast.makeText(m_context,"tk =  " + m_tk.tk,Toast.LENGTH_LONG).show();
        L_tk.add(m_tk);
        m_cursor.moveToNext();
        }
        return L_tk;

    }




}
