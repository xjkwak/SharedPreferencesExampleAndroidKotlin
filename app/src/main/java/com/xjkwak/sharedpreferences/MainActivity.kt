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

        loadName()

        buttonSave.setOnClickListener { saveName() }
    }

    private fun loadName() {
        val myPreferences: SharedPreferences = getSharedPreferences("com.xjkwak.mydata", Context.MODE_PRIVATE)
        if (myPreferences.contains("personName")) {
            editTextTextPersonName.setText(myPreferences.getString("personName", ""))
            Toast.makeText(this, "Nombre recuperado!", Toast.LENGTH_LONG).show()
        }
    }

    private fun saveName() {
        val myPreferences = getSharedPreferences("com.xjkwak.mydata", Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = (myPreferences as SharedPreferences).edit()


        if (!TextUtils.isEmpty(editTextTextPersonName.text)) {
            editor.putString("personName", editTextTextPersonName.text.toString())
            editor.commit()
            Toast.makeText(this, "Nombre guardado!", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "Por favor ingresa tu nombre!", Toast.LENGTH_LONG).show()
        }

    }


}