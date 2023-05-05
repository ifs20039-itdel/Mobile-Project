package com.example.pamquiz_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.pamquiz_game.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    lateinit var signupBinding: ActivitySignupBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signupBinding = ActivitySignupBinding.inflate(layoutInflater)
        val view = signupBinding.root
        setContentView(view)

        signupBinding.btnSignup.setOnClickListener {
            val email = signupBinding.etSignupEmail.text.toString()
            val password = signupBinding.etSignupPassword.text.toString()

            signupWithFirebase(email, password)
        }
    }

    fun signupWithFirebase(email : String, password: String){
        signupBinding.pbSignup.visibility = View.VISIBLE
        signupBinding.btnSignup.isVisible = false

        auth.createUserWithEmailAndPassword(
            email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(
                    applicationContext,
                    "Your account has been created",
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
            signupBinding.pbSignup.visibility = View.GONE
            signupBinding.btnSignup.isVisible = true

        }
    }
}