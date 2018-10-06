package com.example.siarnaud.ouaff.model

import android.provider.Contacts
import android.widget.DatePicker

class Chien(dogName: String, dogGender: Gender, dogWeigth: Int, dogAggressivity: Int) {

    var dogName: String = dogName
    var dogGender: Gender = dogGender
    var dogWeigth = dogWeigth
    var dogAggressivity = dogAggressivity

    lateinit var dogRace: String
    lateinit var dogOwner: Contacts
    lateinit var dogEntry: DatePicker


}