package com.example.coroutinestoturial01.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinestoturial01.model.part08.User
import com.example.coroutinestoturial01.model.part08.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Part08ViewModel2: ViewModel() {

    /**NOTE: this is how a view model scope is defined for each view model in our app, any coroutine launched in this scope
     * will be automatically canceled if the view model is cleared */

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


    }



}