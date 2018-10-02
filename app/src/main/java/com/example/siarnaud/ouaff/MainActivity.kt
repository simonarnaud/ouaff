package com.example.siarnaud.ouaff

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.example.siarnaud.ouaff.model.Chien
import com.example.siarnaud.ouaff.model.Gender


class MainActivity : AppCompatActivity() {

    lateinit var identityRace: EditText
    lateinit var identityName: EditText
    lateinit var genderSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        identityRace = findViewById<EditText>(R.id.identityRace)
        identityName = findViewById<EditText>(R.id.identityName)
        genderSpinner = findViewById<Spinner>(R.id.genderSpinner)

        var listGender = arrayListOf<Gender>(Gender.MALE, Gender.FEMALE, Gender.AUTRE)
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listGender)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        var chien = Chien("test","test",Gender.FEMALE)
    }
}
