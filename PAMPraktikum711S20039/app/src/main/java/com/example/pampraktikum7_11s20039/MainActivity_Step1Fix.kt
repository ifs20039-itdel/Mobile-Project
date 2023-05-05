//package com.example.pampraktikum7_11s20039
//
//import android.content.DialogInterface
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ListView
//import androidx.appcompat.app.AlertDialog
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var etTodo : EditText
//    lateinit var btnAdd : Button
//    lateinit var btnDeleteAll : Button
//    lateinit var lvTodos : ListView
//
//    var dataTodos = ArrayList<String>()
//    var fileHelper = FileHelper()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etTodo = findViewById(R.id.etTodo)
//        btnAdd = findViewById(R.id.btnAdd)
//        btnDeleteAll = findViewById(R.id.btnDeleteAll)
//        lvTodos = findViewById(R.id.lvTodos)
//
//        dataTodos = fileHelper.readData(this)
//
//        var arrayAdapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            android.R.id.text1,
//            dataTodos
//        )
//        lvTodos.adapter = arrayAdapter
//
//        btnAdd.setOnClickListener{
//            var itemTodo : String = etTodo.text.toString()
//            etTodo.setText("")
//            dataTodos.add(itemTodo)
//            arrayAdapter.notifyDataSetChanged()
//            fileHelper.writeData(dataTodos, applicationContext)
//        }
//
//        lvTodos.setOnItemClickListener{ parent, view, position, id ->
//            var alert = AlertDialog.Builder(this)
//            alert.setTitle("Hapus")
//            alert.setMessage("Yakin ingin menghapus item ini?")
//            alert.setCancelable(false)
//            alert.setNegativeButton("No", DialogInterface.OnClickListener{dialog, i -> dialog.cancel()}
//            )
//            alert.setPositiveButton(
//                "Yes",
//                DialogInterface.OnClickListener{ dialog, i ->
//                    dataTodos.removeAt(position)
//                    arrayAdapter.notifyDataSetChanged()
//                    fileHelper.writeData(dataTodos, applicationContext)
//                }
//            )
//            alert.create().show()
//        }
//
//        btnDeleteAll.setOnClickListener{
//            var alert = AlertDialog.Builder(this)
//            alert.setTitle("Hapus Semua")
//            alert.setMessage("Yakin ingin menghapus semua data?")
//            alert.setCancelable(false)
//            alert.setNegativeButton("No", DialogInterface.OnClickListener{dialog, i -> dialog.cancel()}
//            )
//            alert.setPositiveButton(
//                "Yes",
//                DialogInterface.OnClickListener{ dialog, i ->
//                    dataTodos.clear()
//                    arrayAdapter.notifyDataSetChanged()
//                    fileHelper.writeData(dataTodos, applicationContext)
//                }
//            )
//            alert.create().show()
//        }
//    }
//}
