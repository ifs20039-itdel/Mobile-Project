//package com.example.pamprak039
//
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//import androidx.activity.result.ActivityResultCallback
//import androidx.activity.result.ActivityResultLauncher
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import com.example.pamprak039.databinding.ActivityMainBinding
//import com.google.firebase.auth.FirebaseAuth
//import com.squareup.picasso.Picasso
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var mainBinding: ActivityMainBinding
//
//    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
//
//    var imageUri : Uri? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        registerActivityResult()
//
//        mainBinding.ivData.setOnClickListener {
//            chooseImage()
//        }
//    }
//
//    fun chooseImage(){
//        if(ContextCompat.checkSelfPermission(this,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE) !=
//            PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, arrayOf(
//                android.Manifest.permission.READ_EXTERNAL_STORAGE),1 )
//        }else{
//            val intent = Intent()
//            intent.type = "image/*"
//            intent.action = Intent.ACTION_GET_CONTENT
//            activityResultLauncher.launch(intent)
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(
//            requestCode, permissions, grantResults)
//        if(requestCode == 1 && grantResults.isNotEmpty() &&
//            grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            val intent = Intent()
//            intent.type = "image/*"
//            intent.action = Intent.ACTION_GET_CONTENT
//            activityResultLauncher.launch(intent)
//        }
//    }
//
//    fun registerActivityResult(){
//        activityResultLauncher =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallback { result ->
//                val resultCode = result.resultCode
//                val imageData = result.data
//
//                if(resultCode == RESULT_OK && imageData != null){
//                    imageUri = imageData.data
//                    imageUri?.let(){
//                        Picasso.get().load(it).into(mainBinding.ivData)
//                    }
//                }
//            })
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_home, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.miLogout){
//            FirebaseAuth.getInstance().signOut()
//            val intent = Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//}
