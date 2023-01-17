package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class sign_in : Fragment(R.layout.fragment_sign_in) {
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val sign_inButton : Button = view.findViewById(R.id.sign_in)
        val registrationButton : Button = view.findViewById(R.id.registration)
        val resetpasswordButton : Button = view.findViewById(R.id.resetpassword)
        val email: EditText = view.findViewById(R.id.email)
        val password : EditText = view.findViewById(R.id.password)
        auth = FirebaseAuth.getInstance()

        sign_inButton.setOnClickListener {
            if(email.text.isNotEmpty() and password.text.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            findNavController().navigate(R.id.action_sign_in_to_main_fragment)
                        } else {
                            Toast.makeText(
                                activity,
                                "შეყვანილი მონაცემები არასწორია",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
            }else{
                Toast.makeText(activity, "შეავსეთ მოვემული ველები", Toast.LENGTH_LONG).show()
            }
        }
        registrationButton.setOnClickListener {
            findNavController().navigate(R.id.action_sign_in_to_registration_fragment)
        }
        resetpasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_sign_in_to_resetpass_fragment)
         }


    }
}