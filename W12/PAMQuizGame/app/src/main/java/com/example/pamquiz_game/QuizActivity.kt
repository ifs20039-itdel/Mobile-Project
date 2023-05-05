package com.example.pamquiz_game

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.pamquiz_game.databinding.ActivityQuizBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random
import com.google.firebase.auth.FirebaseAuth

class QuizActivity : AppCompatActivity() {

    lateinit var quizBinding: ActivityQuizBinding

    val db = FirebaseDatabase.getInstance()
    val dbRef = db.reference.child("questions")
    val dbScoreRef = db.reference.child("scores")

    var question = ""
    var  optionA = ""
    var optionB = ""
    var optionC = ""
    var optionD = ""
    var answer = ""

    var questionCount = 0
    var questionNumber = 0
    var userAnswer = ""
    var userCorrect = 0
    var userWrong = 0

    lateinit var timer : CountDownTimer
    private val totalTime = 25000L
    var timeContinue = false
    var leftTime = totalTime

    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser

    val questions = HashSet<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizBinding = ActivityQuizBinding.inflate(layoutInflater)
        val view = quizBinding.root
        setContentView(view)

        do{
            val number = Random.nextInt(1, 11)
            questions.add(number)
        }while (questions.size < 5)

        gameLogic()

        quizBinding.btnNext.setOnClickListener {
            resetTimer()
            gameLogic()
        }

        quizBinding.btnFinish.setOnClickListener {
            sendScore()
        }

        quizBinding.tvOptionA.setOnClickListener {
            pauseTimer()
            userAnswer = "a"
            if(answer == userAnswer){
                quizBinding.tvOptionA.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrectAnswer.text = userCorrect.toString()
            }else{
                quizBinding.tvOptionA.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrongAnswer.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOptions()
        }

        quizBinding.tvOptionB.setOnClickListener {
            pauseTimer()
            userAnswer = "b"
            if(answer == userAnswer){
                quizBinding.tvOptionB.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrectAnswer.text = userCorrect.toString()
            }else{
                quizBinding.tvOptionB.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrongAnswer.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOptions()
        }

        quizBinding.tvOptionC.setOnClickListener {
            pauseTimer()
            userAnswer = "c"
            if(answer == userAnswer){
                quizBinding.tvOptionC.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrectAnswer.text = userCorrect.toString()
            }else{
                quizBinding.tvOptionC.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrongAnswer.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOptions()
        }

        quizBinding.tvOptionD.setOnClickListener {
            pauseTimer()
            userAnswer = "d"
            if(answer == userAnswer){
                quizBinding.tvOptionD.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrectAnswer.text = userCorrect.toString()
            }else{
                quizBinding.tvOptionD.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrongAnswer.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOptions()
        }
    }

    private fun gameLogic(){

        restoreOptions()

        dbRef.addValueEventListener(object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                questionCount = snapshot.childrenCount.toInt()
                if(questionNumber < questions.size){

                    val orderQuestion = questions.elementAt(questionNumber).toString()

                    question = snapshot.child(orderQuestion).child("question").value.toString()
                    optionA = snapshot.child(orderQuestion).child("a").value.toString()
                    optionB = snapshot.child(orderQuestion).child("b").value.toString()
                    optionC = snapshot.child(orderQuestion).child("c").value.toString()
                    optionD = snapshot.child(orderQuestion).child("d").value.toString()

                    answer = snapshot.child(orderQuestion).child("answer").value.toString()

                    quizBinding.tvQuestion.text = question
                    quizBinding.tvOptionA.text = optionA
                    quizBinding.tvOptionB.text = optionB
                    quizBinding.tvOptionC.text = optionC
                    quizBinding.tvOptionD.text = optionD

                    quizBinding.pbQuiz.visibility = View.INVISIBLE
                    quizBinding.llQUizInfo.visibility = View.VISIBLE
                    quizBinding.llQuizQuestion.visibility = View.VISIBLE
                    quizBinding.llQuizButton.visibility = View.VISIBLE

                    startTimer()
                }else{

                    val dialogMessage = AlertDialog.Builder(this@QuizActivity)
                    dialogMessage.setTitle("Quiz Game")
                    dialogMessage.setMessage("Congratulation!\n You have answered all the question. Do you want to see the result?")
                    dialogMessage.setCancelable(false)
                    dialogMessage.setPositiveButton("See Result"){ dialogWindow, position ->
                        sendScore()
                    }

                    dialogMessage.setNegativeButton("Play again"){ dialogWindow, position ->
                        val intent = Intent(
                            this@QuizActivity, MainActivity::class.java
                        )
                        startActivity(intent)
                        finish()
                    }

                    dialogMessage.create().show()
                }
                questionNumber++
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    applicationContext,
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
    fun findAnswer(){
        when(answer){
            "a" -> quizBinding.tvOptionA.setBackgroundColor(Color.GREEN)
            "b" -> quizBinding.tvOptionA.setBackgroundColor(Color.GREEN)
            "c" -> quizBinding.tvOptionA.setBackgroundColor(Color.GREEN)
            "d" -> quizBinding.tvOptionA.setBackgroundColor(Color.GREEN)
        }
    }
    fun disableClickableOptions(){
        quizBinding.tvOptionA.isClickable = false
        quizBinding.tvOptionB.isClickable = false
        quizBinding.tvOptionC.isClickable = false
        quizBinding.tvOptionD.isClickable = false
    }

    fun restoreOptions(){
        quizBinding.tvOptionA.setBackgroundColor(Color.WHITE)
        quizBinding.tvOptionB.setBackgroundColor(Color.WHITE)
        quizBinding.tvOptionC.setBackgroundColor(Color.WHITE)
        quizBinding.tvOptionD.setBackgroundColor(Color.WHITE)

        quizBinding.tvOptionA.isClickable = true
        quizBinding.tvOptionB.isClickable = true
        quizBinding.tvOptionC.isClickable = true
        quizBinding.tvOptionD.isClickable = true

    }

    private fun startTimer(){
        timer = object : CountDownTimer(leftTime, 1000){
            override fun onTick(millisUntilFinished: Long) {
                leftTime = millisUntilFinished
                updateCountDownTime()
            }

            override fun onFinish() {
                disableClickableOptions()
                resetTimer()
                updateCountDownTime()
                quizBinding.tvQuestion.text = "Sorry, Time is up. Continue with the next question."
                timeContinue = false
            }
        }.start()

        timeContinue = true
    }

    fun updateCountDownTime(){
        val remainingTime : Int = (leftTime / 1000).toInt()
        quizBinding.tvTime.text = remainingTime.toString()
    }

    fun pauseTimer(){
        timer.cancel()
        timeContinue = false
    }

    fun resetTimer(){
        pauseTimer()
        leftTime = totalTime
        updateCountDownTime()
    }

    fun sendScore(){
        user?.let {
            val userUID = it.uid
            dbScoreRef.child(userUID).child("correct").setValue(userWrong).addOnSuccessListener {
                Toast.makeText(
                    applicationContext,
                    "Score sent to database sucessfully",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(
                    this@QuizActivity,
                    ResultActivity::class.java
                )
                startActivity(intent)
                finish()
            }
        }
    }

}