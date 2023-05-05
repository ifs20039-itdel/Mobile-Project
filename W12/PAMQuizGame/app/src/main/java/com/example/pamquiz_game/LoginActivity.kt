package com.example.pamquiz_game

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pamquiz_game.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import android.app.Activity.RESULT_OK


class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding

    var auth : FirebaseAuth = FirebaseAuth.getInstance()

    lateinit var googleSignInClient: GoogleSignInClient

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)

        //register
        registerActivityForGoogleSignIn()

        val textOfGoogleSignIn = loginBinding.btnSigninGoogle.getChildAt(0) as TextView
        textOfGoogleSignIn.text = "Continue with Google"
        textOfGoogleSignIn.setTextColor(Color.BLACK)
        textOfGoogleSignIn.textSize = 18F

        loginBinding.btnSignin.setOnClickListener {
            val email = loginBinding.etSigninEmail.text.toString()
            val password = loginBinding.etSigninPassword.text.toString()

            signinUser(email, password)

        }

        loginBinding.btnSigninGoogle.setOnClickListener {
            signInGoogle()
        }

        loginBinding.tvSignup.setOnClickListener {
            val intent = Intent(
                this,
                SignupActivity::class.java
            )
            startActivity(intent)
        }
        loginBinding.tvForgotPassword.setOnClickListener{
            val intent = Intent(
                this,
                ForgotPasswordActivity::class.java
            )
            startActivity(intent)
        }
    }
    fun signinUser(email: String, password: String){
        auth.signInWithEmailAndPassword(
            email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(
                    applicationContext,
                    "Welcome to Quiz game",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
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

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if(user != null){
            Toast.makeText(
                applicationContext,
                "Welcome to Quiz game",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signInGoogle(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
            .requestIdToken("1037798924748-jcfnst00lcc88nhbo0vi8hue936j7rvv.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        signin()
    }

    private fun signin(){
        val signInIntent : Intent = googleSignInClient.signInIntent
        activityResultLauncher.launch(signInIntent)
    }

    private fun registerActivityForGoogleSignIn(){
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == RESULT_OK && data != null) {
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                firebaseSignInWithGoogle(task)
            }
        }
    }

    private fun firebaseSignInWithGoogle(
        task : Task<GoogleSignInAccount>){
        try {
            val account : GoogleSignInAccount = task.getResult(ApiException::class.java)
            firebaseGoogleAccount(account)
        }catch (e : ApiException){
            Toast.makeText(
                applicationContext,
                e.localizedMessage,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun firebaseGoogleAccount(account: GoogleSignInAccount){
        val authCredential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(authCredential).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(
                    applicationContext,
                    "Welcome to Quiz Game",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(
                    applicationContext,
                    "Failed to login, please try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


}