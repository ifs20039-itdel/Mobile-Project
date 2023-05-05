package com.example.pamquiz_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pamquiz_game.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var forgotBinding : ActivityForgotPasswordBinding

    val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forgotBinding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        val view = forgotBinding.root
        setContentView(view)

        forgotBinding.btnReset.setOnClickListener {
            val email = forgotBinding.etEmail.text.toString()
            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(
                        applicationContext,
                        "We sent a password reset mail to your email address",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }else{
                    Toast.makeText(
                        applicationContext,
                        task.exception?.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}