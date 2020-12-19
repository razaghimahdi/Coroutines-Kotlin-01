package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinestoturial01.R
import kotlinx.android.synthetic.main.activity_part01.*
import java.lang.StringBuilder

class Part01Activity : AppCompatActivity() {

    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part01)

        title="Part01Activity"

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            downloadUserData()
        }



    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("Part01Activity", "Downloading user $i in ${Thread.currentThread().name}")

        }
    }
}