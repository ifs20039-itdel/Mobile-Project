package com.example.pamquiz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pamquiz_game.databinding.ActivityMainBinding
import com.example.pamquiz_game.databinding.ActivityResultBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ResultActivity : AppCompatActivity() {

    lateinit var resultBinding: ActivityResultBinding

    val db = FirebaseDatabase.getInstance()
    val dbRef = db.reference.child("scores")

    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser

    var userCorrect = ""
    var userWrong = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultBinding = ActivityResultBinding.inflate(layoutInflater)
        val view = resultBinding.root
        setContentView(view)

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                user?.let {
                    val userUID = it.uid
                    userCorrect = snapshot.child(userUID).child("correct").value.toString()
                    userWrong = snapshot.child(userUID).child("Wrong").value.toString()

                    resultBinding.tvCorrectAnswer.text = userCorrect
                    resultBinding.tcWrongAnswer.text = userWrong
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        resultBinding.btnPlayAgain.setOnClickListener {
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }

        resultBinding.btnExit.setOnClickListener {
            finish()
        }
    }
}