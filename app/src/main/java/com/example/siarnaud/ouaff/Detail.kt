package com.example.siarnaud.ouaff

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.*
import com.example.siarnaud.ouaff.model.Gender
import kotlinx.android.synthetic.main.fragment_add_dog.*

class Detail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_add_dog, container, false)
            setHasOptionsMenu(true)


        var listGender = arrayListOf<Gender>(Gender.MALE, Gender.FEMALE, Gender.AUTRE)
        var adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, listGender)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter
    }
}