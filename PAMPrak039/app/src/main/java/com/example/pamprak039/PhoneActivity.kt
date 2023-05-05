package com.example.pamprak039

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pamprak039.databinding.ActivityPhoneBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneActivity : AppCompatActivity() {

    lateinit var phoneBinding: ActivityPhoneBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    lateinit var mCallbacks : PhoneAuthProvider.OnVerificationStateChangedCallbacks

    var verificationCode = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        phoneBinding = ActivityPhoneBinding.inflate(layoutInflater)
        val view = phoneBinding.root
        setContentView(view)

        phoneBinding.btnSend.setOnClickListener {
            val phoneNumber = phoneBinding.etPhone.text.toString()
            val options = PhoneAuthOptions.newBuilder()
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this@PhoneActivity)
                .setCallbacks(mCallbacks)
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }

        phoneBinding.btnVerifiy.setOnClickListener {
            signingSMScode()
        }

        mCallbacks = object :
        PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                Toast.makeText(
                    applicationContext,
                    "Successfully sent verification code.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(
                    applicationContext,
                    "Failed to send verification code.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                verificationCode = p0
            }
        }
    }

    fun signingSMScode(){
        val userEnterCode = phoneBinding.etCode.text.toString()
        val credential =
            PhoneAuthProvider.getCredential(verificationCode, userEnterCode)
        signingWithPhoneAuthCredential(credential)
    }
    fun signingWithPhoneAuthCredential(credential: PhoneAuthCredential){
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val intent =
                        Intent(this@PhoneActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(
                        applicationContext,
                        "The code you entered incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}