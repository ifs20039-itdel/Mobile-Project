package com.example.pampraktikum10_11s20039

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pampraktikum10_11s20039.databinding.ActivityUpdateUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateUserActivity : AppCompatActivity() {

    lateinit var updateUserBinding: ActivityUpdateUserBinding

    val db : FirebaseDatabase = FirebaseDatabase.getInstance()
    val dbRef : DatabaseReference = db.reference.child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUserBinding = ActivityUpdateUserBinding.inflate(layoutInflater)
        val view = updateUserBinding.root
        setContentView(view)

        supportActionBar?.title = "Update User"
        getAndSetData()

        updateUserBinding.btnUpdateUser.setOnClickListener {
            updateData()
        }
    }

    fun getAndSetData(){
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        updateUserBinding.etName.setText(name)
        updateUserBinding.etEmail.setText(email)
        updateUserBinding.etPassword.setText(password)
    }

    fun updateData(){
        val name = updateUserBinding.etName.text.toString()
        val email = updateUserBinding.etEmail.text.toString()
        val password = updateUserBinding.etPassword.text.toString()
        val id = intent.getStringExtra("id").toString()

        val userMap = mutableMapOf<String, Any>()
        userMap["id"] = id
        userMap["name"] = name
        userMap["email"] = email
        userMap["password"] = password

        dbRef.child(id).updateChildren(userMap)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(
                        applicationContext,
                        "The user has been updated",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
    }
}