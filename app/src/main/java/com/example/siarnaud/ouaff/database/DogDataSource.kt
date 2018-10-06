package com.example.siarnaud.ouaff.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.siarnaud.ouaff.model.Chien

class DogDataSource(context: Context) {

    lateinit var database: SQLiteDatabase
    val dbHelper: SQLiteHelper = SQLiteHelper(context)

    val allColumns: MutableList<String> = mutableListOf(dbHelper.COLUMN_DOG_ID,
            dbHelper.COLUMN_DOG_NAME,
            dbHelper.COLUMN_DOG_RACE,
            dbHelper.COLUMN_DOG_GENDER,
            dbHelper.COLUMN_DOG_WEIGTH,
            dbHelper.COLUMN_DOG_AGGRESSIVITY,
            dbHelper.COLUMN_DOG_OWNER,
            dbHelper.COLUMN_DOG_ENTRY)

    fun open() {
        database = dbHelper.writableDatabase
    }

    fun close() {
        dbHelper.close()
    }

    fun createDog(name: String, race: String, gender: String, weigth: Int, aggressivity: Int, owner: String?, entry: String?): Chien {  //owner a changer et date
        val values: ContentValues = ContentValues()

        values.put(dbHelper.COLUMN_DOG_NAME, name)
        values.put(dbHelper.COLUMN_DOG_RACE, race)
        values.put(dbHelper.COLUMN_DOG_GENDER, gender)
        values.put(dbHelper.COLUMN_DOG_WEIGTH, weigth)
        values.put(dbHelper.COLUMN_DOG_AGGRESSIVITY, aggressivity)
        values.put(dbHelper.COLUMN_DOG_OWNER, owner)
        values.put(dbHelper.COLUMN_DOG_ENTRY, entry)

        val insertId: Long = database.insert(dbHelper.TABLE_DOG, null, values)
        val cursor: Cursor = database.query(dbHelper.TABLE_DOG, allColumns.toTypedArray(), dbHelper.COLUMN_DOG_ID + " = " + insertId, null, null, null, null)
        cursor.moveToFirst()
        val dog: Chien = cursorToDog(cursor)
        cursor.close()
        return dog
    }

    fun deleteDog(id: Long) {
        System.out.println("Dog deleted with id: " + id)
        database.delete(dbHelper.TABLE_DOG, dbHelper.COLUMN_DOG_ID + " = " + id, null)
    }

    fun getADog(id: Long): Chien {
        val chiens: MutableList<Chien> = arrayListOf()
        val cursor: Cursor = database.query(dbHelper.TABLE_DOG, allColumns.toTypedArray(), dbHelper.COLUMN_DOG_ID + " = " + id, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val chien: Chien = cursorToDog(cursor)
            chiens.add(chien)
            cursor.moveToNext()
        }
        cursor.close()
        return chiens.get(0)
    }

    fun getAllDog(): List<Chien> {
        val chiens: MutableList<Chien> = arrayListOf()
        val cursor: Cursor = database.query(dbHelper.TABLE_DOG, allColumns.toTypedArray(), null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val chien: Chien = cursorToDog(cursor)
            chiens.add(chien)
            cursor.moveToNext()
        }
        cursor.close()
        return chiens
    }

    fun cursorToDog(cursor: Cursor): Chien {
        val chien: Chien = Chien(cursor.getString(1),
                cursor.getString(3),
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getString(2),
                cursor.getString(6),
                cursor.getString(7) )
        chien.dogId = cursor.getLong(0)
        return chien
    }

}