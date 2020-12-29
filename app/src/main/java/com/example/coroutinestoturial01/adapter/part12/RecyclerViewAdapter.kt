package com.example.coroutinestoturial01.adapter.part12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinestoturial01.R
import com.example.coroutinestoturial01.databinding.SubsItemBinding
import com.example.coroutinestoturial01.generated.callback.OnClickListener
import com.example.coroutinestoturial01.model.part12.Subscriber

class RecyclerViewAdapter(private val subscribersList: List<Subscriber>,
                          private val clickListener: (Subscriber)->Unit/**this function does not return anything so we add Unit*/):
    RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:SubsItemBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.subs_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }
}

class MyViewHolder(val binding: SubsItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(subscriber: Subscriber,clickListener: (Subscriber)->Unit){
        binding.nameTextView.text=subscriber.name
        binding.emailTextView.text=subscriber.email
        binding.listItemLayout.setOnClickListener{
            clickListener(subscriber)
        }
    }
}