package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthActionCodeException
import com.google.firebase.database.FirebaseDatabase


class registration_fragment : Fragment(R.layout.fragment_registration_fragment) {
    private lateinit var name: EditText
    private lateinit var surname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var checkbox: CheckBox
    private lateinit var registrationButton: Button
    private lateinit var id: EditText
    private lateinit var city: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var Repeatpass : EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.name)
        surname = view.findViewById(R.id.surname)
        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)
        checkbox = view.findViewById(R.id.checkBox)
        registrationButton = view.findViewById(R.id.registration)
        id = view.findViewById(R.id.id)
        city = view.findViewById(R.id.city)
        auth = FirebaseAuth.getInstance()
        Repeatpass = view.findViewById(R.id.password2)

        registrationButton.setOnClickListener {
            if (name.text.toString().isNotEmpty() and surname.text.toString().isNotEmpty()
                and id.text.toString().isNotEmpty() and city.text.toString().isNotEmpty()
                and email.text.toString().isNotEmpty() and password.text.toString().isNotEmpty()
                and checkbox.isChecked
            ) {
                if (password.text.toString() == Repeatpass.text.toString()) {
                    auth.createUserWithEmailAndPassword(
                        email.text.toString(),
                        password.text.toString()
                    ).addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            findNavController().navigate(R.id.action_registration_fragment_to_sign_in)
                            val info = Users_info(
                                name.text.toString(),
                                surname.text.toString(),
                                id.text.toString(),
                                city.text.toString()
                            )
                            val data =
                                FirebaseDatabase.getInstance("https://exchanger-585e7-default-rtdb.europe-west1.firebasedatabase.app")
                                    .getReference("მომხმარებლების ინფორმაცია")
                            data.child("User").push().setValue(info)
                        }else{
                            Toast.makeText(activity, "შეყვანილი მონაცემები არასწორია", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Repeatpass.error = "DISMACH"
                }
            }else {
                name.error
                surname.error
                id.error
                city.error
                email.error
                city.error
            }


        }

    }
}