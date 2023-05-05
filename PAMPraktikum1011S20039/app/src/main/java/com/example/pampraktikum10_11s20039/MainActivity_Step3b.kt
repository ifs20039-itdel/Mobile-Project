//package com.example.pampraktikum10_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.PersistableBundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.pampraktikum10_11s20039.databinding.ActivityMainBinding
//import com.google.firebase.database.*
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var mainBinding: ActivityMainBinding
//
//    val db : FirebaseDatabase = FirebaseDatabase.getInstance()
//    val dbRef : DatabaseReference = db.reference.child("users")
//
//    val userList = ArrayList<User>()
//    lateinit var usersAdapter: UsersAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        mainBinding.fabAdd.setOnClickListener {
//            val intent = Intent(
//                this,
//                AddUserActivity::class.java
//            )
//            startActivity(intent)
//        }
//        retrieveDataFromDatabase()
//    }
//
//    fun retrieveDataFromDatabase(){
//        dbRef.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                userList.clear()
//
//                for(currentUser in snapshot.children){
//                    val user = currentUser.getValue(User::class.java)
//
//                    if(user != null){
//                        userList.add(user)
//                    }
//                }
//
//                usersAdapter = UsersAdapter(this@MainActivity, userList)
//                mainBinding.rvUsers.layoutManager =
//                    LinearLayoutManager(this@MainActivity)
//                mainBinding.rvUsers.adapter = usersAdapter
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//}