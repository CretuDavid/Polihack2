package com.example.polihack2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + EMAIL_COL + " INTEGER PRIMARY KEY, " +
                PASSWORD_COL + " TEXT," + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // verific daca tabelul exista
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)//daca nu creezi unul
    }

    // functie pentru a introduce date in baza de date
    fun addcreds(email : String, password : String ){

        // variabila pt valori
        val values = ContentValues()

        // introduce date perechi
        values.put(EMAIL_COL, email)
        values.put(PASSWORD_COL, password)

        // creating a writable variable of our database(sa poti scrie in baza de date)
        val db = this.writableDatabase

        // datele sunt puse in baza de date
        db.insert(TABLE_NAME, null, values)

        // inchidem baza de date
        db.close()
    }

    // functie pt a lua date din baza de date
    fun getcreds(): Cursor? {

        // creez variabila citibila a bazei de date
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }

    companion object{
        // definesc variabilele bazei de date

        // Numele bazei de date
        private val DATABASE_NAME = "Credentials"

        // versiune
        private val DATABASE_VERSION = 1

        // Numele tabelului
        val TABLE_NAME = "credentials_table"

        // Variabila email
        val EMAIL_COL = "email"

        // Variabila parola
        val PASSWORD_COL = "password"
    }
}