//package com.example.pamprak039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.pamprak039.databinding.ActivitySignupBinding
//import com.google.firebase.auth.FirebaseAuth
//
//class SignupActivity : AppCompatActivity() {
//
//    lateinit var signupBinding : ActivitySignupBinding
//
//    val auth : FirebaseAuth = FirebaseAuth.getInstance()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        signupBinding =
//            ActivitySignupBinding.inflate(layoutInflater)
//        val view = signupBinding.root
//        setContentView(view)
//
//        signupBinding.btnSignup.setOnClickListener {
//            val email = signupBinding.etEmail.text.toString()
//            val password = signupBinding.etPassword.text.toString()
//
//            signupWithFirebase (email, password)
//        }
//    }
//
//    fun signupWithFirebase(email: String, password: String){
//        auth.createUserWithEmailAndPassword(
//            email, password).addOnCompleteListener { task ->
//            if(task.isSuccessful){
//                Toast.makeText(
//                    applicationContext,
//                    "Your account has been created",
//                    Toast.LENGTH_SHORT
//                ).show()
//                finish()
//            }else{
//                Toast.makeText(
//                    applicationContext,
//                    task.exception?.toString(),
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//    }
//
//}
