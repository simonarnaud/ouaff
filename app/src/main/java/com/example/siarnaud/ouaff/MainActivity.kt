package com.example.siarnaud.ouaff

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import com.example.siarnaud.ouaff.model.Chien
import com.example.siarnaud.ouaff.model.Gender
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var chien = Chien("test",Gender.FEMALE,31,1)
    }
}
