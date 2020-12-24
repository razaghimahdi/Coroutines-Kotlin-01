package com.example.coroutinestoturial01.model.part10

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User>{
        delay(8000)
        val users : List<User> = listOf(
            User(1,"Mahdi"),
            User(2,"Ali"),
            User(3,"Mohsen"),
            User(4,"Erfan"),
            User(5,"Nima"),
        )

        return users
    }


}