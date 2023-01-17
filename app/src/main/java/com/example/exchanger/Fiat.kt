package com.example.exchanger

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fiat : Fragment(R.layout.fragment_fiat) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fiatlist: ArrayList<fiat_data>
    private lateinit var fiatAdapter: fiatAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        fiatlist = ArrayList()

        fiatlist.add(fiat_data(R.drawable.usa,"USD","USD"))
        fiatlist.add(fiat_data(R.drawable.europe,"EUR","EUR"))
        fiatlist.add(fiat_data(R.drawable.ic_baseline_history_24,"GPG","GPG"))
        fiatlist.add(fiat_data(R.drawable.trk,"TRY","TRY"))
        fiatlist.add(fiat_data(R.drawable.azerbaijan,"AZN","AZN"))
        fiatlist.add(fiat_data(R.drawable.armenia,"AMD","AMD"))
        fiatlist.add(fiat_data(R.drawable.nw,"NOK","NOK"))
        fiatlist.add(fiat_data(R.drawable.ca,"CAD","CAD"))

        fiatAdapter =  fiatAdapter(fiatlist)
        recyclerView.adapter = fiatAdapter

        fiatAdapter.onItemClick = {
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