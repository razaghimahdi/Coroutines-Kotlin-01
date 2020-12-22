package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.coroutinestoturial01.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Part04Activity : AppCompatActivity() {

    val TAG = "Part04ActivityTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part04)
        title="Part04Activity"

        notParallel()

        Parallel1()

        Parallel2()//on main thread


        /**NOTE: to get this total it takes 18 sec,
        because first stock1 takes 10000 sec then stock2 takes 8000, after those(18sec) we gonna get total,
         but with async and await it just gonna takes 10 sec*/
    }

    private fun Parallel1() {
        CoroutineScope(IO).launch {
            Log.i(TAG, "Parallel 1 Calculation started...")
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }
            val total = stock1.await() + stock2.await()
            Log.i(TAG, "Parallel 1 Total is $total")
        }

    }


    private fun Parallel2() {
        CoroutineScope(Main).launch {
            Log.i(TAG, "Parallel 2 Calculation started...")
            val stock1 = async(IO) { getStock1() }
            val stock2 = async(IO) { getStock2() }
            val total = stock1.await() + stock2.await()
            Log.i(TAG, "Parallel 2 Total is $total")
            Toast.makeText(applicationContext, "Parallel 2 Total is $total", Toast.LENGTH_SHORT).show()
        }

    }


    private fun notParallel() {
        CoroutineScope(IO).launch {
            Log.i(TAG, "notParallel Calculation started...")
            val stock1 = getStock1()
            val stock2 = getStock2()
            val total = stock1 + stock2
            Log.i(TAG, "notParallel Total is $total")
        }

    }

    private suspend fun getStock1(): Int {
        delay(8000)
        Log.i(TAG, "getStock: stock 1 returned")
        return 10
    }

    private suspend fun getStock2(): Int {
        delay(10000)
        Log.i(TAG, "getStock: stock 2 returned")
        return 20
    }

}