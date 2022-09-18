package com.bignerdranch.android.pract11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class spisok : AppCompatActivity() {

    private val Books: MutableList<Book> = mutableListOf()
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInfo()

        rv = findViewById<RecyclerView>(R.id.recycler)

        val adapter = ContaktRVAdapter(this, Books)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        setContentView(R.layout.activity_spisok)

    }

    private fun getInfo(){
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json: String= ""
        if (preferences.contains("json")){
            json = preferences.getString("json", "NOT_JSON").toString()
        }else{
            return
        }
        val tempList = Gson().fromJson<List<Book>>(json, object: TypeToken<List<Book>>(){}.type)
        Books.addAll(tempList)
    }

}