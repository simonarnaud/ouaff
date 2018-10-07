package com.example.siarnaud.ouaff

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.*
import android.widget.*
import com.example.siarnaud.ouaff.model.Gender
import com.example.siarnaud.ouaff.model.TesteurDeChampsNul
import kotlinx.android.synthetic.main.fragment_add_dog.*

class Detail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_dog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        val listGender = arrayOf(Gender.MALE.toString(), Gender.FEMALE.toString(), Gender.AUTRE.toString())
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, listGender)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        my_toolbar.title = "Ajouter un chien"
        my_toolbar.setLogo(R.mipmap.ic_launcher)

        my_toolbar.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorPrimaryText))
        my_toolbar.setTitleTextColor(ContextCompat.getColor(context!!, R.color.colorNice))
        my_toolbar.setTitle("Ajouter un chien")

        //val activity: AppCompatActivity = getActivity() as AppCompatActivity
        //activity.setSupportActionBar(my_toolbar)
        //activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)        //fleche revenir en arriere


    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.add_dog_tool_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.validateButton -> {
                testChamps()
                return true
            }

        }
        return false
        //return super.onOptionsItemSelected(item)
    }

    fun testChamps() {
        val testeurDeChampsNul = TesteurDeChampsNul(false,false,false,false)
        if(identityName.text.isEmpty()) {
            testeurDeChampsNul.nameIsEmpty = true
        }
        if(genderSpinner.selectedItem.toString().isEmpty()) {
            testeurDeChampsNul.genderIsEmpty = true
        }
        if(poidsEdit.text.isEmpty()) {
            testeurDeChampsNul.weigthIsEmpty = true
        }
        if(stars.rating.toString().isEmpty()) {
            testeurDeChampsNul.aggressivityIsEmpty = true
        }

        val sb = StringBuilder()

        // a finir

    }
}