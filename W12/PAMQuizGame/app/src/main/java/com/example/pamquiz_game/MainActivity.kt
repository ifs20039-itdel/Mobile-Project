package com.example.pamquiz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pamquiz_game.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.btnStart.setOnClickListener {
            val intent = Intent(
                this@MainActivity, QuizActivity::class.java)
            startActivity(intent)
        }

        mainBinding.btnLogout.setOnClickListener {
            // sign out : email and password
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(
                this,
                LoginActivity::class.java
            )

            //sign out : google account
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build()
            val googleSignInClient = GoogleSignIn.getClient(this, gso)
            googleSignInClient.signOut().addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(
                        applicationContext,
                        "Sign out is successful",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            startActivity(intent)
            finish()
        }

    }
}