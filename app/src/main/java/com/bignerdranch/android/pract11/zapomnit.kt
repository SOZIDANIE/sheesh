package com.bignerdranch.android.pract11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class zapomnit : AppCompatActivity() {

    private val Books: MutableList<Book> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zapomnit)
        val toast = Toast.makeText(applicationContext, "Запомнили)", Toast.LENGTH_SHORT)
        val b3 = findViewById<Button>(R.id.button2)
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val editText1 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val editText2 = findViewById<EditText>(R.id.editTextNumber)
        b3.setOnClickListener{
            val preferences = getSharedPreferences("pref", MODE_PRIVATE)
            if(preferences.contains("json")){

                val listBooks: List<Book> = Gson().fromJson<MutableList<Book>>(preferences.getString("json", "qwe").toString(), object : TypeToken<MutableList<Book>>(){}.type)
                Books.addAll(listBooks)

            }

            val book: Book = Book(editText.text.toString(), editText1.text.toString(), editText2.text.toString())

            Books.add(book)

            preferences.edit{
                this.putString("json", Gson().toJson(Books))
            }


            //Log.d("prefs", "Название: "+editText.text.toString()+" Автор: " +editText1.text.toString()+" Количество страниц: "+editText2.text.toString())
            toast.show()
        }
    }
}