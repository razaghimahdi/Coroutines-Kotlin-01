package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.adapter.part12.RecyclerViewAdapter
import com.example.coroutinestoturial01.databinding.ActivityPart12Binding
import com.example.coroutinestoturial01.db.SubscriberDatabase
import com.example.coroutinestoturial01.db.SubscriberRepository
import com.example.coroutinestoturial01.db.SubscriberViewModel
import com.example.coroutinestoturial01.db.SubscriberViewModelFactory
import com.example.coroutinestoturial01.model.part12.Subscriber

class Part12Activity : AppCompatActivity() {

    val TAG = "Part12Activity"

    private lateinit var binding: ActivityPart12Binding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part12)
        title = "Part12Activity"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_part12)

        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        displaySubscriberList()
        initRecyclerView()

        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun displaySubscriberList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.i(TAG, "displaySubscriberList: ${it.toString()}")
            binding.subscriberRecyclerView.adapter=RecyclerViewAdapter(it,{selectedItem:Subscriber->listItemClicked(selectedItem)})
        })
    }

    private fun initRecyclerView(){
        binding.subscriberRecyclerView.layoutManager=LinearLayoutManager(this)
        displaySubscriberList()
    }

    private fun listItemClicked(subscriber: Subscriber){
        //Toast.makeText(this, "selected name is ${subscriber.name}", Toast.LENGTH_SHORT).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }


}