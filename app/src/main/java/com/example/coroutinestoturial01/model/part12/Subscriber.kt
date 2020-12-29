package com.example.coroutinestoturial01.model.part12

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_subscriber")
data class Subscriber(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subs_id")
    var id:Int,
    @ColumnInfo(name = "subs_name")
    var name:String,
    @ColumnInfo(name = "subs_email")
    var email:String,
)