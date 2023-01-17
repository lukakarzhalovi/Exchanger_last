package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Report : Fragment(R.layout.fragment_report) {
    private lateinit var Email : EditText
    private lateinit var Report : EditText
    private lateinit var button : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Email = view.findViewById(R.id.Reportemail)
        Report= view.findViewById(R.id.Report)
        button= view.findViewById(R.id.send)
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            if(Email.text.isNotEmpty() and Report.text.isNotEmpty()){
                Toast.makeText(activity, "თქვენი მოხსენება მიღებულია", Toast.LENGTH_LONG).show()
                Email.text.clear()
                Report.text.clear()
                val info  = Report_data(Email.text.toString(), Report.text.toString())
                val data = FirebaseDatabase.getInstance("https://exchanger-585e7-default-rtdb.europe-west1.firebasedatabase.app").getReference("მომხმარებლების ინფორმაცია")
                data.child("Report").push().setValue(info)
            } else{
                Toast.makeText(activity, "შეავსეთ მოცემული ორივე ველი", Toast.LENGTH_SHORT).show()
            }
        }
    }

}