package com.example.pamprak039

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pamprak039.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)

        loginBinding.btnSignin.setOnClickListener {
            val email = loginBinding.etEmail.text.toString()
            val password = loginBinding.etPassword.text.toString()

            signWithFirebase(email, password)
        }

        loginBinding.btnSignup.setOnClickListener {
            val intent = Intent(
                this@LoginActivity,
                SignupActivity::class.java
            )
            startActivity(intent)
        }
        loginBinding.btnForgetPassword.setOnClickListener {
            val intent = Intent(
                this@LoginActivity,
                ForgetActivity::class.java
            )
            startActivity(intent)
        }

        loginBinding.btnSigninWithPhoneNumber.setOnClickListener {
            val intent = Intent(
                this@LoginActivity,
                PhoneActivity::class.java
            )
            startActivity(intent)
        }
    }
    fun signWithFirebase(email: String, password: String){
        auth.signInWithEmailAndPassword(
            email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(
                    applicationContext,
                    task.exception?.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val user = auth.currentUser
        if(user != null){
            val intent = Intent(
                this@LoginActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}