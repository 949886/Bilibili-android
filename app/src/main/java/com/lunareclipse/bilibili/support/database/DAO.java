package com.lunareclipse.bilibili.support.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lunareclipse.bilibili.support.database.table.AccountTable;

/**
 * Created by YaeSakura on 16/8/19.
 */
public class DAO extends SQLiteOpenHelper
{

    private SQLiteDatabase database;


    public DAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);

        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        createAccountDB();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    private void createAccountDB()
    {
        String sql = "CREATE TABLE " + AccountTable.NAME + "( " +
                AccountTable.Column.ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AccountTable.Column.UUID + ", " +
                AccountTable.Column.TITLE + ", " +
                AccountTable.Column.DATE + ", " +
                AccountTable.Column.SOLVED + ", " +
                AccountTable.Column.SUSPECT + ")";
        database.execSQL(sql);
    }

}
