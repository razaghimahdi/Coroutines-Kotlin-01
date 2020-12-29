package com.example.coroutinestoturial01.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coroutinestoturial01.model.part12.Subscriber

@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase() {
    abstract val subscriberDAO: SubscriberDAO


    /**NOTE: usually we should only use one instance of a room database for entire app to avoid unexpected errors and performance issues
     * we should not let multi instance of database opening at the same time so we should use singleton here which in kotlin we use
     * companion objects*/
    companion object {
        @Volatile
        /**NOTE: this annotation makes the field immediately made visible to other threads*/
        private var INSTANCE: SubscriberDatabase? = null
        fun getInstance(context: Context): SubscriberDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscriberDB"
                    ).build()
                }
                return instance
            }
        }
    }

}