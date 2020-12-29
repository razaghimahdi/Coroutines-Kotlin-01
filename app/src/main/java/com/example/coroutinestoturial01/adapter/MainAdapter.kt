package com.example.coroutinestoturial01.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.model.InfoMain
import com.example.coroutinestoturial01.view.*

class MainAdapter(
    private val context: Context,
    private val data: List<InfoMain>
) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = data[position].title

        holder.itemView.setOnClickListener {
            when(position){
                0->context.startActivity(Intent(context,Part01Activity::class.java))
                1->context.startActivity(Intent(context, Part02Activity::class.java))
                2->context.startActivity(Intent(context, Part03Activity::class.java))
                3->context.startActivity(Intent(context, Part04Activity::class.java))
                4->context.startActivity(Intent(context, Part05Activity::class.java))
                5->context.startActivity(Intent(context, Part06Activity::class.java))
                6->context.startActivity(Intent(context, Part07Activity::class.java))
                7->context.startActivity(Intent(context, Part08Activity::class.java))
                8->context.startActivity(Intent(context, Part09Activity::class.java))
                9->context.startActivity(Intent(context, Part10Activity::class.java))
                10->context.startActivity(Intent(context, Part11Activity::class.java))
                11->context.startActivity(Intent(context, Part12Activity::class.java))
            }
        }

    }

    override fun getItemCount(): Int = data.count()


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.list_nav_title)
    }

}