package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Crypto : Fragment(R.layout.fragment_crypto) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptolist: ArrayList<crypro_data>
    private lateinit var cryptoAdapter: cryptoAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        cryptolist = ArrayList()

        cryptolist.add(crypro_data(R.drawable.bitcoin,"BTC","BTC"))
        cryptolist.add(crypro_data(R.drawable.cronos_square_light_background,"CRO","CRO"))
        cryptolist.add(crypro_data(R.drawable.ethereum,"ETH","ETH"))
        cryptolist.add(crypro_data(R.drawable.a7872fcc56858227ffa183256a5d55e1,"ADA","ADA"))
        cryptolist.add(crypro_data(R.drawable.bitcoin,"DOGE","DOGE"))
        cryptolist.add(crypro_data(R.drawable.download,"SHIB","SHIB"))
        cryptolist.add(crypro_data(R.drawable.ethereum,"XRP","XRP"))


        cryptoAdapter =  cryptoAdapter(cryptolist)
        recyclerView.adapter = cryptoAdapter

        cryptoAdapter.onItemClick = {
            val bundle = Bundle()
            bundle.putString("name",it.name)
            bundle.putInt("image",it.image)
            bundle.putString("Id",it.id)
            val fragment = pay_fragment()
            fragment.arguments = bundle
            findNavController().navigate(R.id.action_home2_to_pay_fragment2,bundle)
        }

    }

}