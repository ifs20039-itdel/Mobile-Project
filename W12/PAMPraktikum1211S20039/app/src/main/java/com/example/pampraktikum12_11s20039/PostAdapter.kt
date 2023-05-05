package com.example.pampraktikum12_11s20039

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pampraktikum12_11s20039.databinding.PostItemBinding

class PostAdapter (var postList: ArrayList<Post>) :
RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(
        val adapterBinding: PostItemBinding)
        : RecyclerView.ViewHolder(adapterBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.adapterBinding.tvUserId.text = "User ID : ${post.userId}"
        holder.adapterBinding.tvId.text = "ID : ${post.id}"
        holder.adapterBinding.tvTitle.text = "Title : ${post.title}"
        holder.adapterBinding.tvSubtitle.text = "Subtitle : ${post.subtitle}"
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}