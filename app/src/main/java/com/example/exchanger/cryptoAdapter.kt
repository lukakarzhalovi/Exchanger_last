package com.example.exchanger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class cryptoAdapter (private val cryptolist: ArrayList<crypro_data>)
    : RecyclerView.Adapter<cryptoAdapter.CryptoViewHolder>(){

    var onItemClick : ((crypro_data) -> Unit)? = null


    class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.crypto_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_item,parent,false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptolist[position]
        holder.imageView.setImageResource(crypto.image)
        holder.textView.text = crypto.name
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(crypto)

        }
    }

    override fun getItemCount(): Int {
        return cryptolist.size
    }
}
