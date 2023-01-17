package com.example.exchanger

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class History : Fragment(R.layout.fragment_history) {
    private lateinit var Count : TextView
    private lateinit var Card_Number : TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var Restart : Button
    private lateinit var home:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Count = view.findViewById(R.id.Count)
        Card_Number = view.findViewById(R.id.Card_Number)
        Restart = view.findViewById(R.id.restart)
        home = view.findViewById(R.id.Home)
        val args = this.arguments
        val inputCardNumber = args?.get("cardNumber")
        val inputCount = args?.get("Count")
        sharedPreferences = requireActivity().getSharedPreferences("DATA", MODE_PRIVATE)
        val CardNumber = sharedPreferences.getString("DATA", "Card Number")
        val Count1 = sharedPreferences.getString("Count", "Count")
        Card_Number.text = CardNumber
        Count.text = Count1

        Restart.setOnClickListener {
            val Add = inputCardNumber.toString()
            val Default = Card_Number.text.toString()
            val result = Default + "\n" + Add
            Card_Number.text = result
            sharedPreferences.edit()
                .putString("DATA", result)
                .apply()


            val Add1 = inputCount.toString()
            val Default1 = Count.text.toString()
            val result1 = Default1 + "\n" + Add1
            Count.text = result1
            sharedPreferences.edit()
                .putString("Count", result1)
                .apply()
        }
        home.setOnClickListener {
            findNavController().navigate(R.id.action_history2_to_home2)
        }

    }

}