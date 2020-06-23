package com.xjkwak.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        buttonSave.setOnClickListener { saveName() }
    }

    private fun loadData() {
        val myPreferences: SharedPreferences = getSharedPreferences("com.xjkwak.mydata", Context.MODE_PRIVATE)
        if (myPreferences.contains("personName")) {
            val value = myPreferences.getString("personName", "")
            editTextName.setText(value)
        }

        if (myPreferences.contains("personAge")) {
            val value = myPreferences.getInt("personAge", 0)
            editTextAge.setText(value.toString())
        }

        if (myPreferences.contains("personMale")) {
            val value = myPreferences.getBoolean("personMale", false)
            radioButtonMale.isChecked = value
        }

        if (myPreferences.contains("personFemale")) {
            val value = myPreferences.getBoolean("personFemale", false)
            radioButtonFemale.isChecked = value
        }

        Toast.makeText(this, "Datos recuperados!", Toast.LENGTH_LONG).show()
    }

    private fun saveName() {
        val myPreferences = getSharedPreferences("com.xjkwak.mydata", Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = (myPreferences as SharedPreferences).edit()


        if (!TextUtils.isEmpty(editTextName.text)) {
            editor.putString("personName", editTextName.text.toString())
        }
        if (!TextUtils.isEmpty(editTextAge.text)) {
            editor.putInt("personAge", editTextAge.text.toString().toInt())
        }

        editor.putBoolean("personMale", radioButtonMale.isChecked)
        editor.putBoolean("personFemale", radioButtonFemale.isChecked)
        editor.commit()

    }
}