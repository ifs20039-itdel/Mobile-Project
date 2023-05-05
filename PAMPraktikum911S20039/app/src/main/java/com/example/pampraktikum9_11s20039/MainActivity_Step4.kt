//package com.example.pampraktikum9_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.speech.RecognizerIntent
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.activity.result.ActivityResultCallback
//import androidx.activity.result.ActivityResultLauncher
//import androidx.activity.result.contract.ActivityResultContracts
//import java.util.Locale
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var tvResult: TextView
//    lateinit var ivMic: ImageView
//
//    lateinit var activityResultLauncher:
//            ActivityResultLauncher<Intent>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        tvResult = findViewById(R.id.tvResult)
//        ivMic = findViewById(R.id.ivMic)
//
//        activityResultLauncher = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult(),
//            ActivityResultCallback { result ->
//                val resultCode = result.resultCode
//                val data = result.data
//
//                if(resultCode == RESULT_OK && data != null){
//                    val speakResult : ArrayList<String> =
//                        data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
//
//                    tvResult.text = speakResult[0]
//
//                }
//            }        )
//        ivMic.setOnClickListener{
//            convertSpeech()
//        }
//
//    }
//
//    fun convertSpeech(){
//        val intent =
//            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
//        activityResultLauncher.launch(intent)
//    }
//}