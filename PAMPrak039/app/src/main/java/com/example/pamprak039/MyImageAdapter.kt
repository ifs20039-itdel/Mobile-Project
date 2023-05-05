package com.example.pamprak039

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pamprak039.databinding.ItemImageBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class MyImageAdapter (
    var context : Context,
    var myImageList : ArrayList<MyImage>
) : RecyclerView.Adapter<MyImageAdapter.UsersViewHolder>(){

    inner class UsersViewHolder(
        val adapterBinding: ItemImageBinding) :
            RecyclerView.ViewHolder(adapterBinding.root){

            }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UsersViewHolder, position: Int) {
        val myImage : MyImage = myImageList[position]
        holder.adapterBinding.tvLabel.text = myImage.label
        holder.adapterBinding.pbData.visibility = View.VISIBLE

        val imageUrl = myImage.url
        Picasso.get().load(imageUrl).into(holder.adapterBinding.imgData, object  : Callback{
            override fun onSuccess() {
                holder.adapterBinding.pbData.visibility = View.INVISIBLE
            }

            override fun onError(e: Exception?) {
                Toast.makeText(
                    context,
                    e?.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        holder.adapterBinding.clData.setOnClickListener {
            val intent = Intent(context, UpdateMyImageActivity::class.java)
            intent.putExtra("id", myImage.id)
            intent.putExtra("label", myImage.label)
            intent.putExtra("imageUrl", imageUrl)
            intent.putExtra("imageName", myImage.imageName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return myImageList.size
    }

    fun getMyImageId(position: Int) : String{
        return myImageList[position].id
    }

    fun getImageName(position: Int) : String{
        return myImageList[position].imageName
    }
}