package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.adapter.MainAdapter
import com.example.coroutinestoturial01.dataModel.InfoMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this, getData())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun getData(): List<InfoMain> {
        val data = listOf<InfoMain>(
            InfoMain("Part01 Coroutines Scope:Click Event Example Without Coroutines Scope"),
            InfoMain("Part02 Coroutines Scope:Click Event Example With Coroutines Scope"),
            InfoMain("Part03 Coroutines Scope:Click Event Example With Coroutines Scope"),
        )

        return data
    }

}
