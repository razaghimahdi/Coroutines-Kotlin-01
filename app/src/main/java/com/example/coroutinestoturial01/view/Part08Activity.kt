package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.viewModel.Part08ViewModel2

class Part08Activity : AppCompatActivity() {

    lateinit var part08ViewModel2: Part08ViewModel2

    val TAG="Part08Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part08)

        title="Part08Activity"

        part08ViewModel2 = ViewModelProvider(this).get(Part08ViewModel2::class.java)
        part08ViewModel2.getUserData()
        part08ViewModel2.users.observe(this, Observer { myUsers ->
            myUsers.forEach {
                Log.i(TAG, "name is ${it.name}")
            }
        })


    }
}