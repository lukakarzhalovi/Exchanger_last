package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class main_fragment : Fragment(R.layout.fragment_main_fragment) {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView=view.findViewById(R.id.bottom_nav)
        val navHostFragment=childFragmentManager.findFragmentById(R.id.fragment1)
                as NavHostFragment
        navController=navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)



    }
}