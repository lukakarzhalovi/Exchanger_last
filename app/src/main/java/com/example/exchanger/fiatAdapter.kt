package com.example.exchanger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class fiatAdapter(private val fiatlist: ArrayList<fiat_data>)
    : RecyclerView.Adapter<fiatAdapter.FiatViewHolder>(){

    var onItemClick : ((fiat_data) -> Unit)? = null

    class FiatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.fiat_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fiat_item,parent,false)
        return FiatViewHolder(view)
    }

    override fun onBindViewHolder(holder: FiatViewHolder, position: Int) {
        val fiat = fiatlist[position]
        holder.imageView.setImageResource(fiat.image)
        holder.textView.text = fiat.name
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(fiat)

        }
    }

    override fun getItemCount(): Int {
        return fiatlist.size
    }
}