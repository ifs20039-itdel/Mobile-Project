//package com.example.pamprak039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.pamprak039.databinding.ActivityForgetBinding
//import com.google.firebase.auth.FirebaseAuth
//
//class ForgetActivity : AppCompatActivity() {
//
//    lateinit var forgetBinding : ActivityForgetBinding
//
//    val auth : FirebaseAuth = FirebaseAuth.getInstance()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        forgetBinding =
//            ActivityForgetBinding.inflate(layoutInflater)
//        val view = forgetBinding.root
//        setContentView(view)
//
//        forgetBinding.btnResetPassword.setOnClickListener {
//            val email = forgetBinding.etEmail.text.toString()
//            auth.sendPasswordResetEmail(email)
//                .addOnCompleteListener { task ->
//                    if(task.isSuccessful){
//                        Toast.makeText(
//                            applicationContext,
//                            "We sent a password reset mail to your email address",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        finish()
//                    }
//                }
//        }
//    }
//}