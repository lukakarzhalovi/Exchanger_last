package com.example.exchanger

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class pay_fragment : Fragment(R.layout.fragment_pay) {
    private lateinit var builder: AlertDialog.Builder
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Id : TextView = view.findViewById(R.id.ID)
        val image :ImageView = view.findViewById(R.id.imageView4)
        val args = this.arguments
        val inputId = args?.get("Id")
        val inputImage = args?.getInt("image")
        Id.text = inputId.toString()
        if (inputImage != null) {
            image.setImageResource(inputImage)
        }


        val inputNumberView = view.findViewById<EditText>(R.id.conversionNum)
        val convertedNumView = view.findViewById<EditText>(R.id.convertedNum)
        val convertButton = view.findViewById<Button>(R.id.convertButton)
        val gatana = view.findViewById<Button>(R.id.button)
        val CardNumber = view.findViewById<EditText>(R.id.editTextNumber4)
        builder = AlertDialog.Builder(activity)



        fun conversion(Id: String){
            var inputNumber = inputNumberView.text.toString().toDouble()
            var convertedNumber: String
            var exchangeRate = 1.0

            when(Id){
                "USD" -> exchangeRate = 2.67231
                "EUR" -> exchangeRate = 2.882561
                "GPG" -> exchangeRate = 3.27324
                "TRY" -> exchangeRate = 0.1420565
                "AZN" -> exchangeRate = 1.568803
                "AMD" -> exchangeRate = 0.00676
                "NOK" -> exchangeRate = 0.27101
                "CAD" -> exchangeRate = 1.9948
                "BTC" -> exchangeRate = 5649281.0
                "CRO" -> exchangeRate = 0.21
                "ETH" -> exchangeRate = 4190.64
                "ADA" -> exchangeRate = 0.94
                "DOGE" -> exchangeRate = 0.22
                "SHIB" -> exchangeRate = 0.000029
                "XRP" -> exchangeRate = 1.03
            }
            convertedNumber = (inputNumber / exchangeRate).toString()

            convertedNumView.setText(convertedNumber)
        }
        convertButton.setOnClickListener(){
            conversion(inputId.toString())


        }
        gatana.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("cardNumber", CardNumber.text.toString())
            bundle.putString("Count",convertedNumView.text.toString())
            val fragment = pay_fragment()
            fragment.arguments = bundle
            builder.setTitle("გაფრთხილება")
                .setMessage("ნამდვილად გსურთ ვალუტის გადაცვლა?")
                .setCancelable(true)
                .setNegativeButton("არ მსურს"){dialogInterface, it-> dialogInterface.cancel()}
                .setPositiveButton("მსურს"){dialogInterface, it -> findNavController().navigate(R.id.action_pay_fragment2_to_history2,bundle)
                    dialogInterface.cancel()

                }
                .show()
        }



    }

}