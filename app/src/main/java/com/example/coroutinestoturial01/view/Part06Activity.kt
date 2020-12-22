package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.view.part06.UserDataManager
import kotlinx.android.synthetic.main.activity_part06.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class Part06Activity : AppCompatActivity() {

    private var count = 0

    val TAG = "Part06Activity"

    /** Unstructured concurrency does not guarantee to complete all the tasks of the suspending function, before it returns.
     * But it is ok with async builders
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part06)
        title = "Part06Activity"


        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }


        unstructuredConcurrency1()

        unstructuredConcurrency2()//with async and await


    }

    private fun unstructuredConcurrency2() {

        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Main).launch {
                /**NOTE: we should use Dispatchers.Main otherwise we will not be able to show value on the textView*/
                tvUserMessage.text = UserDataManager().getTotalUserCount2().toString()

            }
        }



    }

    private fun unstructuredConcurrency1() {

        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Main).launch {
                /**NOTE: we should use Dispatchers.Main otherwise we will not be able to show value on the textView*/
                tvUserMessage.text = UserDataManager().getTotalUserCount1().toString()
                /**NOTE: this will returns us 0 bu we expected 50,
                because getTotalUserCount() creates a new coroutine which behaves separately from this parent coroutine in this activity
                so this function reach us to the end and returns this count variable value before the completion of coroutine
                because of that reason instead of 50 we got zero as the result */
            }
        }





    }


    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i(TAG, "Downloading user $i in ${Thread.currentThread().name}")

        }
    }


}