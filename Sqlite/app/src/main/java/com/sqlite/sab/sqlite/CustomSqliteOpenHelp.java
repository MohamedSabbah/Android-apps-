package com.sqlite.sab.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Sab on 22/03/2018.
 */

public class CustomSqliteOpenHelp extends SQLiteOpenHelper {

     private static final String DATABASE_NAME = "bookDB";
     private static final int DATABASE_VERSION = 3;


    public CustomSqliteOpenHelp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE bookTable( Id integer primary key AUTOINCERMENT, bookName text, bookAuthor text)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE bookTable");
        this.onCreate(sqLiteDatabase);

    }

    public void addBook (int idBook, String nameBook, String authorBook){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id" , idBook);
        contentValues.put("bookName" , nameBook);
        contentValues.put("bookAuthor" , authorBook);
        sqLiteDatabase.insert("bookTable" , null, contentValues);
    }

    public ArrayList<BookModel> retrieveAllBooks(){
        ArrayList<BookModel> allBooks= new ArrayList<>();
        BookModel bookModel;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM bookTable", null);
        if(cursor.moveToFirst()){
            do{
                bookModel = new BookModel();

                bookModel.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                bookModel.setBookName(cursor.getString(cursor.getColumnIndex("bookName")));
                bookModel.setBookAuthor(cursor.getString(2));
                allBooks.add(bookModel);
            }while (cursor.moveToNext());
        }
        return allBooks;
    }

    public void deleteOneBook(int position){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("bookTable","Id = ?" , new String[]{String.valueOf(position)});
    }

    public void  deleteAllBooks(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("bookTable", null, null);
        //sqLiteDatabase.execSQL("DELETE FROM bookTable");
    }

    public void updateBook(int idBook, String nameBook, String authorBook){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookName" , nameBook);
        contentValues.put("bookAuthor" , authorBook);
        sqLiteDatabase.update("bookTable", contentValues, "Id =? " , new String[]{String.valueOf(idBook)});
    }
}
