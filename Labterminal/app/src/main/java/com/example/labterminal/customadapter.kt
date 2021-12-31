package com.example.labterminal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.new_layout.view.*

class customadapter : RecyclerView.Adapter<viewholder>() {



    val title = arrayListOf<String>("Name : Hamza , Registration : 096 , Phone:201",
        "Name : Comsats , Registration : 022 , Phone:202",
    )
    override fun getItemCount(): Int {
        return title.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {


        val linflater = LayoutInflater.from(parent?.context)
        val newinf = linflater.inflate(R.layout.new_layout,parent,false)
        return viewholder(newinf)


    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val titlev = title.get(position)
        holder.v.textView.text=titlev
    }

}
class  viewholder(val v:View):RecyclerView.ViewHolder(v){

}