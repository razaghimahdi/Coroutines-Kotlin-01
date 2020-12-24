package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinestoturial01.R
 import com.example.coroutinestoturial01.viewModel.Part10ViewModel

class Part10Activity : AppCompatActivity() {


    lateinit var part10ViewModel: Part10ViewModel

    val TAG="Part10Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part10)


        title="Part10Activity"

        part10ViewModel = ViewModelProvider(this).get(Part10ViewModel::class.java)
        //part10ViewModel.getUserData()
        part10ViewModel.users.observe(this, Observer { myUsers ->
            myUsers.forEach {
                Log.i(TAG, "name is ${it.name}")
            }
        })



    }
}