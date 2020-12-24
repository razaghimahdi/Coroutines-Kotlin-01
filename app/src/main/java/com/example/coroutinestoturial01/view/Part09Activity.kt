package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.coroutinestoturial01.R
import kotlinx.android.synthetic.main.activity_part09.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Part09Activity : AppCompatActivity() {

    val TAG = "Part09Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part09)

        title = "Part09Activity"


        /**NOTE: this is an example to use this coroutine to display progressbar or some message ,
         */
        lifecycleScope.launch {
            delay(5000)
            progressBar.visibility = View.VISIBLE
            delay(8000)
            progressBar.visibility = View.GONE
        }

        /** this coroutine runs in main thread if we want run it in a separate way*/

        lifecycleScope.launch(IO) {
            Log.i(TAG, "thread is : ${Thread.currentThread().name}")
        }


        /**NOTE: if you have some long-running operations which should happen only once during the lifecycle of the activity or fragment,
         * this coroutine will be helpful*/
        lifecycleScope.launchWhenCreated {

        }

        /**NOTE: this coroutine will launch when the activity of fragment is started, fragment transaction */
        lifecycleScope.launchWhenStarted {  }

        /**NOTE: if we have a requirement to start a long-running task just after the app is up and running we would use
         * this lifecycle scope launch with resumed*/
        lifecycleScope.launchWhenResumed {  }

    }
}