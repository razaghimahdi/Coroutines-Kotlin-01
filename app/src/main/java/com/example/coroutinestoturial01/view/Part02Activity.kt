package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinestoturial01.R
import kotlinx.android.synthetic.main.activity_part02.*
import kotlinx.android.synthetic.main.activity_part02.btnCount
import kotlinx.android.synthetic.main.activity_part02.btnDownloadUserData
import kotlinx.android.synthetic.main.activity_part02.tvCount
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class Part02Activity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part02)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {/**NOTE: Dispatchers is the context*/
                downloadUserData()
            }

        }

    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("Part02Activity", "Downloading user $i in ${Thread.currentThread().name}")


        }
    }
}