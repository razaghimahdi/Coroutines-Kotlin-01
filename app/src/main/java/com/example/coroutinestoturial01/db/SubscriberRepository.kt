package com.example.coroutinestoturial01.db

import com.example.coroutinestoturial01.model.part12.Subscriber

class SubscriberRepository(private val dao: SubscriberDAO) {

    val subscribers = dao.getAllSubscribers()


    suspend fun insert(subscriber: Subscriber):Long {
       return dao.insertSubscriber(subscriber)
    }


    suspend fun update(subscriber: Subscriber) {
        dao.updateSubscriber(subscriber)
    }


    suspend fun delete(subscriber: Subscriber) {
        dao.deleteSubscriber(subscriber)
    }


    suspend fun deleteAll() {
        dao.deleteAll()
    }


}