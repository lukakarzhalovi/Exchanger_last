package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Home : Fragment(R.layout.fragment_home) {
    var tabTitle = arrayOf("Fiat","Crypto")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pager = view.findViewById<ViewPager2>(R.id.viewpager2)
        var tablayout = view.findViewById<TabLayout>(R.id.tabLayout)

        pager.adapter = myAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(tablayout ,pager){
                tab, position ->
            tab.text = tabTitle[position]
        }.attach()

    }

}