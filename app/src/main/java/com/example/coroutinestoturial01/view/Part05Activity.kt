package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinestoturial01.R
import kotlinx.android.synthetic.main.activity_part05.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class Part05Activity : AppCompatActivity() {

    /** NOTE: job instance is a representation of coroutine, every coroutine has its own job instance attached to it,
     *  a job can have 6 status: New, Active, Completing, Cancelling, Cancelled, Completed.
     *  a job has three boolean variables:isActive, isCompleted, isCancelled. we can use them to know about the status of coroutine*/

    lateinit var job1: Job

    val TAG = "Part05Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part05)

        title="Part05Activity"


        /**NOTE: launch coroutine builder returns a job */
        job1 = CoroutineScope(Main).launch {
            downloadData()
        }


        btnCancel.setOnClickListener {
            job1.cancel()
        }

        btnStatus.setOnClickListener {
            if (job1.isActive) {
                textView.text = "Active"
            } else if (job1.isCancelled) {
                textView.text = "Cancelled"
            } else if (job1.isCompleted) {
                textView.text = "Completed"
            }
        }


    }


    private suspend fun downloadData() {
        withContext(IO) {
            repeat(30) {
                delay(1000)
                Log.i(TAG, "downloadData: repeating $it")
            }
        }
    }

}