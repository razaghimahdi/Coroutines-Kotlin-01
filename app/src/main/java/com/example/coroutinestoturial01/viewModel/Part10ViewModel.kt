package com.example.coroutinestoturial01.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.coroutinestoturial01.model.part10.User
import com.example.coroutinestoturial01.model.part10.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Part10ViewModel : ViewModel() {

/*
    private var userRepository = UserRepository()
    var users:MutableLiveData<List<User>> = MutableLiveData()


    fun getUserData(){
        viewModelScope.launch {

            var result : List<User>?=null
            withContext(IO){
                result=userRepository.getUsers()
            }
            users.value=result

        }


 */

    private var userRepository = UserRepository()

    var users = liveData(IO) {
        val result = userRepository.getUsers()
        emit(result)
    }


}
