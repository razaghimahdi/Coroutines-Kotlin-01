package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.adapter.MainAdapter
import com.example.coroutinestoturial01.model.InfoMain
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
            InfoMain("Part01:Click Event Example "),
            InfoMain("Part02 Coroutines Scope:Click Event Example With Coroutines Scope"),
            InfoMain("Part03 WithContext:Click Event Example With Coroutines Scope, delay method"),
            InfoMain("Part04 Async and Await: Parallel Decomposition"),
            InfoMain("Part05 Job: isActive, isCancelled, isCompleted"),
            InfoMain("Part06 Unstructured Concurrency01"),
            InfoMain("Part07 Unstructured Concurrency02"),
            InfoMain("Part08 ViewModelScope"),
            InfoMain("Part09 lifecycleScope"),
            InfoMain("Part10 live data"),
            InfoMain("Part11 Retrofit"),
            InfoMain("Part12 Project: Room,MVVM"),
        )

        return data
    }

}
