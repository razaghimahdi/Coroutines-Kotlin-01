package com.example.coroutinestoturial01.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Part08ViewModel: ViewModel() {

    /**NOTE: in android every time a view model is cleared from the memory just before the clearing view model invokes its onCreate method,
     * onCreate method is always there by default but if you want to do something just before the clearing, we can manually override the
     * onCreate method*/

    private val myJob = Job()
    private val myScope = CoroutineScope(IO+myJob)

    fun getUserData(){
        myScope.launch {

        }




    }

    override fun onCleared() {
        super.onCleared()
        myJob.cancel()
    }


}