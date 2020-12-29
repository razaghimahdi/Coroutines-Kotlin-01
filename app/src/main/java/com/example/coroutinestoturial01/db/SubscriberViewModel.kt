package com.example.coroutinestoturial01.db

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutinestoturial01.model.part12.Subscriber
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber


    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val btnSave = MutableLiveData<String>()

    @Bindable
    val btnDelete = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
    get() = statusMessage


    init {
        /**NOTE: why we do this? because according to our xml,
         * buttons should change dynamically when the user clicks on the recyclerView list item
         * the selected name and email should display on editText,
         * and button should change as UPDATE and CLEAR ALL should change as DELETE*/
        btnSave.value = "SAVE"
        btnDelete.value = "CLEAR All"
    }

    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            subscriberToUpdateOrDelete.name = inputName.value!!
            subscriberToUpdateOrDelete.email = inputEmail.value!!
            update(subscriberToUpdateOrDelete)
        } else {
            val name = inputName.value!!
            val email = inputEmail.value!!
            insert(Subscriber(0, name, email))
            /**we set 0 for ID which Room will automatically set generate it*/
            inputName.value = null
            inputEmail.value = null
        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
        val newRowId = repository.insert(subscriber)
        if (newRowId>-1) {
            statusMessage.value = Event("Subscriber Inserted Successfully,ID = $newRowId")
        }else{
            statusMessage.value = Event("Error while Inserting")
        }
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        btnSave.value = "SAVE"
        btnDelete.value = "CLEAR ALL"

        statusMessage.value = Event("Subscriber Updated Successfully")
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        btnSave.value = "SAVE"
        btnDelete.value = "CLEAR ALL"


        statusMessage.value = Event("Subscriber Deleted Successfully")
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()


        statusMessage.value = Event("All Subscribers Deleted Successfully")
    }


    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        btnSave.value = "UPDATE"
        btnDelete.value = "DELETE"
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}