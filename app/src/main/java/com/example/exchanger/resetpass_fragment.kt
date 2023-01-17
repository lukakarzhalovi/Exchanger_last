package com.example.exchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class resetpass_fragment : Fragment(R.layout.fragment_resetpass_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resetpassButton : Button = view.findViewById(R.id.changepass)
        val email = view.findViewById<EditText>(R.id.email)
        resetpassButton.setOnClickListener {
            val email = email.text.toString()
            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        findNavController().navigate(R.id.action_resetpass_fragment_to_sign_in)
                    }
                }

        }

    }

}