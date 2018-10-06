package com.example.siarnaud.ouaff.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLiteHelper(context: Context): SQLiteOpenHelper(context, "db", null, 1) {

    val TABLE_DOG: String = "dog"

    var COLUMN_DOG_ID: String = "dog_id"
    val COLUMN_DOG_NAME: String = "dog_name"
    val COLUMN_DOG_RACE: String = "dog_race"
    val COLUMN_DOG_GENDER: String = "dog_gender"
    val COLUMN_DOG_WEIGTH: String = "dog_weigth"
    val COLUMN_DOG_AGGRESSIVITY: String = "dog_aggressivity"
    val COLUMN_DOG_OWNER: String = "dog_owner"
    val COLUMN_DOG_ENTRY: String = "dog_entry"

    val DATABASE_NAME: String = "db"
    val DATABASE_VERSION: Int = 1

    val DATABASE_CREATE: String = ("create table "
            + TABLE_DOG + "("
            + COLUMN_DOG_ID + " integer primary key autoincrement, "
            + COLUMN_DOG_NAME + " text not null, "
            + COLUMN_DOG_RACE + " text, "               //attention gender
            + COLUMN_DOG_GENDER + " text not null, "
            + COLUMN_DOG_WEIGTH + " integer not null, "
            + COLUMN_DOG_AGGRESSIVITY + " integer not null, "
            + COLUMN_DOG_OWNER + " text, "                  //changer pour contact
            + COLUMN_DOG_ENTRY + " text "                   //a changer
            + ");")

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.w(SQLiteHelper::class.java.name, "Uppgrading database from version " + oldVersion
        + " to " + newVersion + ", which will destroy all old data")

        db?.execSQL("DROP IF TABLE EXISTS " + TABLE_DOG)
        onCreate(db)
    }

}