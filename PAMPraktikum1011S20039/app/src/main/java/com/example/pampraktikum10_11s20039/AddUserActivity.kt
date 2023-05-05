package com.example.pampraktikum10_11s20039

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pampraktikum10_11s20039.databinding.ActivityAddUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddUserActivity : AppCompatActivity() {

    lateinit var addUserBinding: ActivityAddUserBinding

    val db : FirebaseDatabase = FirebaseDatabase.getInstance()
    val dbRef : DatabaseReference = db.reference.child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUserBinding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = addUserBinding.root
        setContentView(view)

        supportActionBar?.title = "Add User"

        addUserBinding.btnAddUser.setOnClickListener {
            addUserToDatabase()
        }
    }

    fun addUserToDatabase(){
        val name : String = addUserBinding.etName.text.toString()
        val email : String = addUserBinding.etEmail.text.toString()
        val password : String = addUserBinding.etPassword.text.toString()

        val id : String = dbRef.push().key.toString()

        val user = User(id, name, email, password)

        dbRef.child(id).setValue(user).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(
                    applicationContext,
                    "The new user has been added to the database",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    applicationContext,
                    task.exception.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}