package com.example.coroutinestoturial01.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinestoturial01.R
import kotlinx.android.synthetic.main.activity_part03.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Part03Activity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part03)
        title="Part03Activity"

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                /**NOTE: Dispatchers is the context*/
                downloadUserData()
            }

        }

    }



    @SuppressLint("SetTextI18n")
    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                /**NOTE: This is how we switch coroutine between threads*/

                /**NOTE: This is how we switch coroutine between threads*/

                /**NOTE: if we are going to use a suspending function such as withContext,
                 * we have to mark our calling function with suspend modifier */

                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }
}