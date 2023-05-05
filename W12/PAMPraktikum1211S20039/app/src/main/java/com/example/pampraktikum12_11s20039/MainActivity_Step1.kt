//package com.example.pampraktikum12_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.pampraktikum12_11s20039.databinding.ActivityMainBinding
//import retrofit2.*
//import retrofit2.converter.gson.GsonConverterFactory
//
//class MainActivity : AppCompatActivity() {
//
//    private val baseURL = "https://jsonplaceholder.typicode.com/"
//
//    lateinit var mainBinding: ActivityMainBinding
//
//    var postList = ArrayList<Post>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        showPost()
//    }
//
//    fun showPost(){
//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val retrofitAPI : RetrofitAPI = retrofit.create(RetrofitAPI::class.java)
//
//        val call : Call<List<Post>> = retrofitAPI.getAllPosts()
//
//        call.enqueue(object : Callback<List<Post>>{
//            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//                if(!response.isSuccessful){
//                    mainBinding.tvUserId.text = "error"
//                    mainBinding.tvId.text = "error"
//                    mainBinding.tvTitle.text = "error"
//                    mainBinding.tvSubtitle.text = "error"
//                }else{
//                    postList = response.body() as ArrayList<Post>
//                    val post = postList[0]
//                    mainBinding.tvUserId.text = "User ID : ${post.userId}"
//                    mainBinding.tvId.text = "ID : ${post.id}"
//                    mainBinding.tvTitle.text = "Title: ${post.title}"
//                    mainBinding.tvSubtitle.text = "Subtitle: ${post.subtitle}"
//                }
//            }
//
//            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                Toast.makeText(
//                    applicationContext,
//                    t.localizedMessage,
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        })
//    }
//}