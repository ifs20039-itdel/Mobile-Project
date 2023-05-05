package com.example.pamprak039

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamprak039.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    var imageUri: Uri? = null

    val db : FirebaseDatabase = FirebaseDatabase.getInstance()
    val dbRef : DatabaseReference = db.reference.child("images")

    val firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
    val storageRef: StorageReference = firebaseStorage.reference

    val myImageList = ArrayList<MyImage>()
    lateinit var myImageAdapter: MyImageAdapter

    val imageNameList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        registerActivityForResult()

        mainBinding.ivData.setOnClickListener {
            chooseImage()
        }

        mainBinding.btnSave.setOnClickListener {
            uploadPhoto()
        }

        retrieveDataFromDatabase()

        ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


                val id = myImageAdapter.getMyImageId(viewHolder.adapterPosition)

                dbRef.child(id).removeValue()

                // delete()
                val imageName = myImageAdapter.getImageName(viewHolder.adapterPosition)

                val imageReference = storageRef.child("images").child(imageName)

                imageReference.delete()

                Toast.makeText(
                    applicationContext,
                    "The image was deleted",
                    Toast.LENGTH_SHORT
                ).show()

            }

        }).attachToRecyclerView(mainBinding.rvImages)
    }
    fun chooseImage(){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf( android.Manifest.permission.READ_EXTERNAL_STORAGE), 1) }else{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            activityResultLauncher.launch(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            val intent = Intent()
            intent.type = "image/*"
            intent.action= Intent.ACTION_GET_CONTENT
            activityResultLauncher.launch(intent)
        }
    }

    fun registerActivityForResult(){
        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts .StartActivityForResult(), ActivityResultCallback { result ->
                val resultCode = result.resultCode
                val imageData = result.data
                if (resultCode == RESULT_OK && imageData != null){ imageUri = imageData.data
                    imageUri?.let {
                        Picasso.get()
                            .load(it). into (mainBinding.ivData)
                    }
                }
            })
    }
    fun uploadPhoto() {
        mainBinding.btnSave.isClickable = false
        mainBinding.pbUpload.visibility = View.VISIBLE
        // UUID
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
                    addImageToDatabase(imageUrl, imageName)
                }
            }.addOnFailureListener {
                Toast.makeText(
                    applicationContext,
                    it.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()

                mainBinding.btnSave.isClickable = true
                mainBinding.pbUpload.visibility = View.GONE
            }
        }
    }

    fun addImageToDatabase (url: String, imageName: String){
        val label : String = mainBinding.etLabel.text.toString()
        val id : String = dbRef.push().key.toString()

        val myImage = MyImage (id, label, url, imageName)

        dbRef.child(id).setValue(myImage).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(
                    applicationContext,
                    "The new image has been added to the database",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    applicationContext,
                    task.exception.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            mainBinding.btnSave.isClickable = true
            mainBinding.pbUpload.visibility = View.GONE

            finish()
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu (menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected( item: MenuItem): Boolean {
        if(item.itemId == R.id.miLogout){
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        if(item.itemId == R.id.miDeleteAll) {
            showDialogForDeleteAllData()
        }
        return super.onOptionsItemSelected(item)
    }


    fun retrieveDataFromDatabase(){ dbRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {

            myImageList.clear()

            for (currentUser in snapshot.children){
                val image = currentUser.getValue(MyImage::class.java)
                if(image != null){
                    myImageList.add(image)
                }
            }
            myImageAdapter = MyImageAdapter(this@MainActivity, myImageList)
            mainBinding.rvImages.layoutManager = LinearLayoutManager (this@MainActivity)
            mainBinding.rvImages.adapter = myImageAdapter
        }
        override fun onCancelled (error: DatabaseError) {
            TODO ("Not yet implemented")
        }
    })
    }

    fun showDialogForDeleteAllData(){

        val dialogMessage = AlertDialog.Builder(this)
        dialogMessage.setTitle("Delete All Images")
        dialogMessage.setMessage("If click Yes, all images will be deleted," +
                "If you want to delete a specific image, you can swipe the item you want to delete right or left")
        dialogMessage.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

            dialogInterface.cancel()
        })

        dialogMessage.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
            dbRef.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (eachMyImage in snapshot.children) {
                        val myImage = eachMyImage.getValue(MyImage::class.java)

                        if (myImage != null) { imageNameList.add(myImage.imageName)
                        }
                    }
                }

                override fun onCancelled (error: DatabaseError) {
                    TODO ("Not yet implemented")
                }
            })
            dbRef.removeValue().addOnCompleteListener { task ->
                if (task.isSuccessful){
                    for (imageName in imageNameList){

                        val imageReference = storageRef.child("images").child(imageName)
                        imageReference.delete()
                    }
                    myImageAdapter.notifyDataSetChanged()
                    Toast.makeText(applicationContext, "All images were deleted", Toast.LENGTH_SHORT).show()
                }
            }
        })
        dialogMessage.create().show()
    }
}