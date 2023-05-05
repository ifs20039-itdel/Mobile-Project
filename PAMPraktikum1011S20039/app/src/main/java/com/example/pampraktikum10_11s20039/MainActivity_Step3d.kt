//package com.example.pampraktikum10_11s20039
//
//import android.content.DialogInterface
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//import android.widget.Toast
//import androidx.appcompat.app.AlertDialog
//import androidx.recyclerview.widget.ItemTouchHelper
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.pampraktikum10_11s20039.databinding.ActivityMainBinding
//import com.google.firebase.database.*
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var mainBinding : ActivityMainBinding
//
//    val db : FirebaseDatabase = FirebaseDatabase.getInstance()
//    val dbRef :DatabaseReference = db.reference.child("users")
//
//    val userList = ArrayList<User>()
//    lateinit var usersAdapter : UsersAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        mainBinding.fabAdd.setOnClickListener{
//            val intent = Intent(
//                this, AddUserActivity::class.java
//            )
//            startActivity(intent)
//        }
//
//        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val id = usersAdapter.getUserId(viewHolder.adapterPosition)
//
//                dbRef.child(id).removeValue()
//
//                Toast.makeText(
//                    applicationContext, "The user has deleted",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }).attachToRecyclerView(mainBinding.rvUsers)
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
//                    if(user != null){
//                        userList.add(user)
//                    }
//                }
//
//                usersAdapter = UsersAdapter(this@MainActivity, userList)
//                mainBinding.rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
//                mainBinding.rvUsers.adapter = usersAdapter
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_delete_all, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.itemDeleteAll){
//            showDialogMessage()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    fun showDialogMessage(){
//        val dialogMessage = AlertDialog.Builder(this)
//        dialogMessage.setTitle("Delete All Users")
//        dialogMessage.setMessage("If click Yes, all users will be deleted, If you want to delete a specific user, you can swipe the item you want to delete right or left")
//        dialogMessage.setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog, which ->
//            dialog.cancel()
//        })
//        dialogMessage.setPositiveButton("Yes", DialogInterface.OnClickListener{
//                dialog, which -> dbRef.removeValue().addOnCompleteListener{
//                task -> if(task.isComplete){
//            usersAdapter.notifyDataSetChanged()
//            Toast.makeText(
//                applicationContext, "All users were deleted", Toast.LENGTH_SHORT
//            ).show()
//        }
//        }
//        })
//
//        dialogMessage.create().show()
//    }
//}