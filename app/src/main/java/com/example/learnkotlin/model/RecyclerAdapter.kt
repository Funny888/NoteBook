package com.example.learnkotlin.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.R
import com.example.learnkotlin.model.database.PersonTable

class RecyclerAdapter(list: MutableList<PersonTable>) :
    RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {
    private var mList: MutableList<PersonTable> = list

    fun getList() = mList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_maket, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.mName.text = mList.get(position).Name
        holder.mFamily.text = mList.get(position).Family
        holder.mNumber.text = mList.get(position).Number
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mName: TextView = itemView.findViewById(R.id.maketName)
        val mFamily: TextView = itemView.findViewById(R.id.maketFamily)
        val mNumber: TextView = itemView.findViewById(R.id.maketNumber)
    }
}