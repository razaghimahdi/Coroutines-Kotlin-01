package com.example.coroutinestoturial01.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    /**NOTE: why we add companion object?
     * in kotlin companion object initializes when the class is loaded for the first time ,
     * so if we write codes to create a retrofit instance inside this companion object will be able to easily get it using the class name
     * */
    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}