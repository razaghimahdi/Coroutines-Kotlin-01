package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.view.part06.UserDataManager2
import kotlinx.android.synthetic.main.activity_part07.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class Part07Activity : AppCompatActivity() {
    private var count = 0

    val TAG = "Part07Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part07)
        title = "Part07Activity"


        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }


        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Main).launch {
                tvUserMessage.text = UserDataManager2().getTotalUserCount1().toString()/**NOTE: with coroutineScope we can have child scope which is under the controller,
            and we we created parallel scope in the main*/
            }
        }




    }
}