package com.example.siarnaud.ouaff.model

import android.provider.Contacts
import android.widget.DatePicker

class Chien(dogName: String, dogGender: String, dogWeigth: Int, dogAggressivity: Int, dogRace: String?, dogOwner: String?, dogEntry: String?) {

    var dogName: String = dogName
    var dogGender: String = dogGender
    var dogWeigth: Int = dogWeigth
    var dogAggressivity: Int = dogAggressivity

    var dogRace: String? = dogRace
    var dogOwner: String? = dogOwner
    var dogEntry: String? = dogEntry

    var dogId: Long = -1
}