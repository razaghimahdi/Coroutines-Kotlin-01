package com.example.coroutinestoturial01.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coroutinestoturial01.model.part12.Subscriber

@Dao
interface SubscriberDAO {


    @Insert/**(onConflict = OnConflictStrategy.REPLACE)NOTE: onConflict=OnConflictStrategy.REPLACE:
    this will do insert entity and if there is an existing row that has the same ID value,
     it will delete the old entity and replace the the row with the new entity
    if we set it as ignore(OnConflictStrategy.IGNORE) it will ignore the  complicit*/
    suspend fun insertSubscriber(Subscriber: Subscriber): Long

   /* @Insert
    fun insertSubscriberNotCoroutine(Subscriber: Subscriber): Long

    @Insert
    fun insertMultiSubscriber(
        Subscriber: Subscriber,
        subscriber1: Subscriber,
        subscriber2: Subscriber
    ): List<Long>

    @Insert
    fun insertSubscribers(Subscribers: List<Subscriber>): List<Long>

    @Insert
    fun insertSubscribersAndSubscriber(
        Subscriber: Subscriber,
        Subscribers: List<Subscriber>
    ): List<Long>
*/

    @Update
    suspend fun updateSubscriber(Subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(Subscriber: Subscriber)

    @Query("DELETE FROM tbl_subscriber")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbl_subscriber")
    fun getAllSubscribers():LiveData<List<Subscriber>>/**NOTE: we do now coroutine here because this function returns us live data
     room library do this from background thread */





}