package com.example.pamprak039

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.pamprak039.databinding.ActivityMainBinding
import com.example.pamprak039.databinding.ActivityUpdateMyImageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import java.util.*

class UpdateMyImageActivity : AppCompatActivity() {

    lateinit var updateMyImageBinding: ActivityUpdateMyImageBinding

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    var imageUri: Uri? = null

    val db: FirebaseDatabase = FirebaseDatabase.getInstance()
    val dbRef: DatabaseReference = db.reference.child("images")

    val firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
    val storageRef: StorageReference = firebaseStorage.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateMyImageBinding = ActivityUpdateMyImageBinding.inflate(layoutInflater)
        val view = updateMyImageBinding.root
        setContentView(view)

        supportActionBar?.title = "Update Image"

        registerActivityForResult()

        getAndSetData()

        updateMyImageBinding.ivUpdateData.setOnClickListener {
            chooseImage()
        }
        updateMyImageBinding.btnUpdateData.setOnClickListener {
            uploadPhoto()
        }
    }

    fun getAndSetData() {
        val label = intent.getStringExtra("label")
        val imageUrl = intent.getStringExtra("imageUrl")
        val id = intent.getStringExtra("id")

        updateMyImageBinding.etUpdateLabel.setText(label)
        Picasso.get().load(imageUrl).into(updateMyImageBinding.ivUpdateData)
    }

    fun registerActivityForResult() {
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback { result ->
                val resultCode = result.resultCode
                val imageData = result.data

                if (resultCode == RESULT_OK && imageData != null) {
                    imageUri = imageData.data
                    imageUri?.let {
                        Picasso.get().load(it).into(updateMyImageBinding.ivUpdateData)
                    }
                }
            })
    }

    fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        activityResultLauncher.launch(intent)
    }

    fun uploadPhoto(){
        updateMyImageBinding.btnUpdateData.isClickable = false
        updateMyImageBinding.pbUpdateData.visibility = View.VISIBLE
        //UUID
        val imageName = UUID.randomUUID().toString()
        val imageRef = storageRef.child("images").child(imageName)
        imageUri?.let { uri ->
            imageRef.putFile(uri).addOnSuccessListener {
                Toast.makeText(
                    applicationContext,
                    "Image Uploaded",
                    Toast.LENGTH_SHORT
                ).show()

                val myUploadImageRef = storageRef.child("images").child(imageName)
                myUploadImageRef.downloadUrl.addOnSuccessListener { url ->
                    val imageUrl = url.toString()
                    updateData(imageUrl, imageName)
                }
            }.addOnFailureListener{
                Toast.makeText(
                    applicationContext,
                    it.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()

                updateMyImageBinding.btnUpdateData.isClickable = true
                updateMyImageBinding.pbUpdateData.visibility = View.GONE
            }
        }
    }

    fun updateData(imageUrl : String, imageName : String){

        val label = updateMyImageBinding.etUpdateLabel.text.toString()
        val id = intent.getStringExtra("id").toString()

        val myImageMap = mutableMapOf<String,Any>()
        myImageMap["id"] = id
        myImageMap["label"] = label
        myImageMap["url"] = imageUrl
        myImageMap["imageName"] = imageName

        dbRef.child(id).updateChildren(myImageMap).addOnCompleteListener { task ->

            if (task.isSuccessful){
                Toast.makeText(
                    applicationContext,
                    "The image has been updated",
                    Toast.LENGTH_SHORT
                ).show()
                updateMyImageBinding.btnUpdateData.isClickable = true
                updateMyImageBinding.pbUpdateData.visibility = View.GONE

                finish()
            }
        }
    }
}