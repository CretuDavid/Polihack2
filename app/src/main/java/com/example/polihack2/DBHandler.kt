package com.example.polihack2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHandler
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,")
        db.execSQL(query)
    }

    fun addNewCredentials(
        email: String?,
        password: String?
    ) {

        val db = this.writableDatabase

        val values = ContentValues()

        values.put(EMAIL_COL, email)
        values.put(PASSWORD_COL, password)

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "credentialsdb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "credentials"
        private const val EMAIL_COL = "email"
        private const val PASSWORD_COL = "password"
    }
}
