package com.example.siarnaud.ouaff

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import com.example.siarnaud.ouaff.database.DogDataSource
import com.example.siarnaud.ouaff.model.Chien
import com.example.siarnaud.ouaff.model.Gender
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var chien = Chien("test",Gender.FEMALE.toString(),31,1, null, null, null)

        val dataSource: DogDataSource = DogDataSource(this)

        dataSource.open()
       // dataSource.createDog("test","race",Gender.FEMALE.toString(),31,1, null, null)
       // var chien2: Chien = dataSource.getADog(4)
       // System.out.println(chien2.dogName)
       // dataSource.deleteDog(5)

    }
}
