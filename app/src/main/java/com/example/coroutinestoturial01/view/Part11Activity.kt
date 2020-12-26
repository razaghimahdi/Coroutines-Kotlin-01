package com.example.coroutinestoturial01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.model.part11.Albums
import com.example.coroutinestoturial01.service.AlbumService
import com.example.coroutinestoturial01.service.RetrofitInstance
import kotlinx.android.synthetic.main.activity_part11.*
import retrofit2.Response

class Part11Activity : AppCompatActivity() {


    val TAG ="Part11Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part11)

        title="Part11Activity"

        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response=retService.getAlbums()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            /**NOTE: next to the "Observer{" there is it:Response<Albums>!
             * so this 'it' here represents a retrofit response object of type albums
             * from that we will be able to get an object up albums class which is an array list of albums item objects*/
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    Log.i(TAG, "Title: ${albumsItem.title}")
                    val result=
                        " Album Title : ${albumsItem.title} \n"+
                        " Album id : ${albumsItem.id} \n"+
                        " User id : ${albumsItem.userId} \n\n\n"

                    txtAlbums.append(result)
                }
            }
        })


    }
}